package com.example.belajarandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername;
    EditText edtPassword;
    Button btnLogin;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputUser = edtUsername.getText().toString().trim();
                String inputPass = edtPassword.getText().toString().trim();

                if (inputUser.isEmpty() || inputPass.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Username dan Password wajib diisi",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (inputUser.equals("admin") && inputPass.equals("admin")) {
                    Toast.makeText(MainActivity.this,
                            "Login Admin Berhasil",
                            Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(MainActivity.this, Linkedin.class));
                    finish();
                    return;
                }

                SharedPreferences prefs =
                        getSharedPreferences("USER_DATA", MODE_PRIVATE);

                String savedEmail = prefs.getString("email", null);
                String savedPassword = prefs.getString("password", null);

                if (savedEmail == null || savedPassword == null) {
                    Toast.makeText(MainActivity.this,
                            "Akun tidak ditemukan, silakan register",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (inputUser.equals(savedEmail) &&
                        inputPass.equals(savedPassword)) {

                    Toast.makeText(MainActivity.this,
                            "Login User Berhasil",
                            Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(
                            MainActivity.this,
                            KalkulatorAritmatika.class
                    ));
                    finish();

                } else {
                    Toast.makeText(MainActivity.this,
                            "Username atau Password salah",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        });
    }
}
