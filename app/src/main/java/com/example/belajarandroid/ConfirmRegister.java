package com.example.belajarandroid;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfirmRegister extends AppCompatActivity {

    TextView txtWelcome, txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confirm_register);

        txtWelcome = findViewById(R.id.txtWelcome);
        txtData = findViewById(R.id.txtData);

        String Nama = getIntent().getStringExtra("username");
        String Alamat = getIntent().getStringExtra("alamat");
        String Email = getIntent().getStringExtra("email");
        String NoTelp = getIntent().getStringExtra("noTelp");
        String Password = getIntent().getStringExtra("password");

        txtWelcome.setText("Welcome " + Nama);
        txtData.setText("Nama: " + Nama + "\n" +
                "Alamat: " + Alamat + "\n" +
                "Email: " + Email + "\n" +
                "NoTelp: " + NoTelp + "\n" +
                "Password: " + Password);





    }
}