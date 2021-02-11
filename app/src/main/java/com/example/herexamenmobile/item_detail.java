package com.example.herexamenmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class item_detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemdetail);

        Intent intent = getIntent();

        TextView textView_title = findViewById(R.id.title);
        TextView textView_description = findViewById(R.id.description);

        final String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        final String url = intent.getStringExtra("url");

        Button share_button = findViewById(R.id.share);

        textView_title.setText(title);
        textView_description.setText(description);

        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentShare = new Intent(Intent.ACTION_SEND);
                intentShare.putExtra(Intent.EXTRA_TEXT, "Bekijk " + title + " via " + url);
                intentShare.setType("text/plain");
                startActivity(intentShare);
            }
        });
    }


}