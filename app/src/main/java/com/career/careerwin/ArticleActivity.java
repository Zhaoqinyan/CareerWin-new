package com.career.careerwin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ArticleActivity extends AppCompatActivity {


    FirebaseDatabase database;
    DatabaseReference articleReference;
    DatabaseReference educationArticlesRef;
    DatabaseReference tipsArticlesRef;
    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    ArticleAdapter articleAdapter1;
    ArticleAdapter articleAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        database = FirebaseDatabase.getInstance();
        articleReference = database.getReference("Articles");
        educationArticlesRef = articleReference.child("educational articles");
        tipsArticlesRef = articleReference.child("Tips articles");

        //writeTo();

        recyclerView1 = findViewById(R.id.recycler_view1);
        recyclerView2 = findViewById(R.id.recycler_view2);
        recyclerView1.setHasFixedSize(true);
        recyclerView2.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        articleAdapter1 = new ArticleAdapter(educationArticlesRef, this);
        articleAdapter2 = new ArticleAdapter(tipsArticlesRef, this);

        recyclerView1.setAdapter(articleAdapter1);
        recyclerView2.setAdapter(articleAdapter2);


    }

    public void writeTo() {
        Article article1 = new Article("Teacher Professional Development");
        educationArticlesRef.push().setValue(article1);
        Article article2 = new Article("Professional Identity Development");
        educationArticlesRef.push().setValue(article2);
        Article article3 = new Article("Professional Development of Medical Students");
        educationArticlesRef.push().setValue(article3);
        Article article4 = new Article("Writing Interview Protocols and Conducting Interviews");
        tipsArticlesRef.push().setValue(article4);
        Article article5 = new Article("Winning Interview Skills");
        tipsArticlesRef.push().setValue(article5);
        Article article6 = new Article("Strategies of Effective Interviewing");
        tipsArticlesRef.push().setValue(article6);

        //myRef = database.getReference("Messages");
        //myRef.child("Whatever you want").setValue("This is cool because keys can...");

    }
}
