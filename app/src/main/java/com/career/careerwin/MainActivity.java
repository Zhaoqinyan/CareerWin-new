package com.career.careerwin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference userReference;
    EditText questionField;
    EditText answerField;
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userReference = database.getReference("HardCodedUser");

        auth = FirebaseAuth.getInstance();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    userReference = database.getReference(user.getUid());
                } else {
                    startActivity(new Intent(MainActivity.this, LogInActivity.class));
                }
            }
        };


        Button artButton=(Button) findViewById(R.id.button_Article);
        artButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ArticleActivity.class);
                startActivity(intent);
            }
        });
        Button bookButton=(Button) findViewById(R.id.button_E_Book);
        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,EbookActivity.class);
                startActivity(intent);
            }
        });
        Button videoButton=(Button) findViewById(R.id.button_Video);
        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,VideoActivity.class);
                startActivity(intent);
            }
        });

        Button weblinkButton =(Button) findViewById(R.id.button_WebLink);
        weblinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,WebLinkActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        auth.addAuthStateListener(authListener);
    }

    public void sendToFirebase(View view){
            String q = questionField.getText().toString();
            String a = answerField.getText().toString();
            TestItem testItem = new TestItem(q, a);
            userReference.push().setValue(testItem);
        }


        public void logOut(View view){ auth.signOut();
//            Button logOutButton =(Button) findViewById(R.id.button_logout);
//            logOutButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(MainActivity.this, WebLinkActivity.class);
//                    startActivity(intent);
//                }
//            });
    }

}

