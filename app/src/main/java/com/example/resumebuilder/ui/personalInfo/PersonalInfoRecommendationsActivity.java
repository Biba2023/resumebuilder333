package com.example.resumebuilder.ui.personalInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.resumebuilder.R;
import com.example.resumebuilder.ui.contact.ContanctFragment;

public class PersonalInfoRecommendationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info_recommendations);
        ImageButton button_back = (ImageButton) findViewById(R.id.button_back6);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}