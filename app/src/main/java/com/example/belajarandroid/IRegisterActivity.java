package com.example.belajarandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class IRegisterActivity extends AppCompatActivity {

    EditText edtNama, edtAlamat, edtEmail, edtNoTelp, edtPassword, edtConfirm;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_iregister);

        edtNama = findViewById(R.id.edtNama);
        edtAlamat = findViewById(R.id.edtAlamat);
        edtEmail = findViewById(R.id.edtEmail);
        edtNoTelp = findViewById(R.id.edtNoTelp);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirm = findViewById(R.id.edtConfirm);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = edtNama.getText().toString();
                String alamat = edtAlamat.getText().toString();
                String email = edtEmail.getText().toString();
                String noTelp = edtNoTelp.getText().toString();
                String password = edtPassword.getText().toString();
                String confirm = edtConfirm.getText().toString();

                if (username.isEmpty() || email.isEmpty() || alamat.isEmpty()
                        || noTelp.isEmpty() || password.isEmpty() || confirm.isEmpty()) {

                    Toast.makeText(IRegisterActivity.this,
                            "Semua field wajib diisi",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(confirm)) {
                    Toast.makeText(IRegisterActivity.this,
                            "Password tidak sama",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(IRegisterActivity.this, ConfirmRegister.class);
                intent.putExtra("username", username);
                intent.putExtra("alamat", alamat);
                intent.putExtra("email", email);
                intent.putExtra("noTelp", noTelp);
                intent.putExtra("password", password);

                startActivity(intent);
            }
        });
    }
}