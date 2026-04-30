package com.example.belajarandroid;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class HomeIntent extends AppCompatActivity {

    TextView txtHai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_intent);

        txtHai = findViewById(R.id.txtHai);

        String username = getIntent().getStringExtra("username");

        txtHai.setText("Hai " + username);
    }
}