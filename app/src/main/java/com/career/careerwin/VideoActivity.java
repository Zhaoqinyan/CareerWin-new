package com.career.careerwin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;


public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        TextView t = (TextView) findViewById(R.id.video1);
        t.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t2 = (TextView) findViewById(R.id.video2);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t3 = (TextView) findViewById(R.id.video3);
        t3.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t4 = (TextView) findViewById(R.id.video4);
        t4.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t5 = (TextView) findViewById(R.id.video5);
        t5.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t6 = (TextView) findViewById(R.id.video6);
        t6.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
