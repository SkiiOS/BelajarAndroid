package com.example.belajarandroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginSharedPreference extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;

    // 1. Definisikan Nama File dan Key
    private static final String PREF_NAME = "UserSession";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_shared_preference);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // 2. Inisialisasi SharedPreferences
        SharedPreferences sharedPref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        // 3. Cek apakah sudah pernah login
        boolean isLoggedIn = sharedPref.getBoolean(KEY_IS_LOGGED_IN, false);
        if (isLoggedIn) {
            String savedUsername = sharedPref.getString(KEY_USERNAME, "");
            Toast.makeText(this, "Welcome Back, " + savedUsername, Toast.LENGTH_SHORT).show();
            // Biasanya di sini langsung pindah ke Dashboard/Home
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginSharedPreference.this, "Isi dulu bor!", Toast.LENGTH_SHORT).show();
                } else {
                    // 4. Proses Simpan ke SharedPreferences (Login)
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(KEY_USERNAME, username);
                    editor.putBoolean(KEY_IS_LOGGED_IN, true);
                    editor.apply(); // apply() itu asynchronous (lebih cepat)

                    Toast.makeText(LoginSharedPreference.this, "Login Berhasil & Tersimpan!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}