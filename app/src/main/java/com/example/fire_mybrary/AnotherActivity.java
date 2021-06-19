package com.example.fire_mybrary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AnotherActivity extends AppCompatActivity {
ImageView imageview;
ImageButton int_button;
Button btn_about,btn_help,btn_social;
TextView a_description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        getSupportActionBar().setTitle("MyBrary Info..");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageview = findViewById(R.id.imageView);
        btn_about = findViewById(R.id.btn_about);
        btn_help = findViewById(R.id.btn_help);
        btn_social = findViewById(R.id.btn_social);
        int_button = findViewById(R.id.int_button);
        a_description = findViewById(R.id.a_description);
        int_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vickysingh1601.github.io/MyBrary/"));
                startActivity(intent);
            }
        });

        btn_help.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String recipient1 = "vikas.singh2019@vitbhopal.ac.in";
                String recipient2 ="ankita.singh2019@vitbhoal.ac.in";
                String recipient3 ="rhea.banerjee2019@vitbhoal.ac.in";
                String recipient4 ="manya.tiwari2019@vitbhoal.ac.in";
                String subject = "/Your Issue Here/";
                String message = "/Brief About Issue/";
                AnotherActivity.this.sendemail(recipient1,recipient2,recipient3,recipient4, subject, message);
            }
        });
        btn_social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/vit.bhopal/"));
                startActivity(intent);
            }
        });

    }

    private void sendemail(String recipient1,String recipient2 ,String recipient3,String recipient4,String subject, String message) {
        Intent mIntent = new Intent("android.intent.action.SEND");
        mIntent.setData(Uri.parse("mailto:"));
        mIntent.setType("text/plain");
        mIntent.putExtra("android.intent.extra.EMAIL", new String[]{recipient1,recipient2,recipient3,recipient4});
        mIntent.putExtra("android.intent.extra.SUBJECT", subject);
        mIntent.putExtra("android.intent.extra.TEXT", message);

        try {
            this.startActivity(Intent.createChooser(mIntent, (CharSequence)"Choose Email Client.."));
        } catch (Exception var6) {
            Toast.makeText((Context)this, (CharSequence)var6.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
    }
