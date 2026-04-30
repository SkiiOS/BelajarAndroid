package com.example.belajarandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    EditText edtNama, edtEmail, edtAlamat, edtNoTelp, edtPassword, edtConfirm;
    Button btnRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtNama = findViewById(R.id.edtNama);
        edtEmail = findViewById(R.id.edtEmail);
        edtAlamat = findViewById(R.id.edtAlamat);
        edtNoTelp = findViewById(R.id.edtNoTelp);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirm = findViewById(R.id.edtConfirm);
        btnRegis = findViewById(R.id.btnRegis);

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nama = edtNama.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String alamat = edtAlamat.getText().toString().trim();
                String noTelp = edtNoTelp.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                String confirm = edtConfirm.getText().toString().trim();

                if (nama.isEmpty() || email.isEmpty() || alamat.isEmpty()
                        || noTelp.isEmpty() || password.isEmpty() || confirm.isEmpty()) {

                    Toast.makeText(Register.this,
                            "Semua field wajib diisi",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(confirm)) {
                    Toast.makeText(Register.this,
                            "Password tidak sama",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                SharedPreferences prefs =
                        getSharedPreferences("USER_DATA", MODE_PRIVATE);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("nama", nama);
                editor.putString("email", email);
                editor.putString("alamat", alamat);
                editor.putString("noTelp", noTelp);
                editor.putString("password", password);
                editor.apply();

                Toast.makeText(Register.this,
                        "Registrasi berhasil",
                        Toast.LENGTH_SHORT).show();

                startActivity(new Intent(Register.this, MainActivity.class));
                finish();
            }
        });
    }
}
