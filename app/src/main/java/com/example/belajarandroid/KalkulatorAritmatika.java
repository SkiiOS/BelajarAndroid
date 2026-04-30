package com.example.belajarandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class KalkulatorAritmatika extends AppCompatActivity {

    EditText edtAngka1;
    EditText edtAngka2;
    Button btnTambah;
    Button btnKurang;
    Button btnKali;
    Button btnBagi;
    TextView txtHasil;
    Button btnClear;
    Button btnExit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kalkulator_aritmatika);
        edtAngka1 = (EditText) findViewById(R.id.edtAngka1);
        edtAngka2 = (EditText) findViewById(R.id.edtAngka2);
        btnTambah = (Button) findViewById(R.id.btnTambah);
        btnKurang = (Button) findViewById(R.id.btnKurang);
        btnKali = (Button) findViewById(R.id.btnKali);
        btnBagi = (Button) findViewById(R.id.btnBagi);
        txtHasil = (TextView) findViewById(R.id.txtHasil);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnExit = (Button) findViewById(R.id.btnExit);


        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int angka1 = Integer.parseInt(edtAngka1.getText().toString());
                int angka2 = Integer.parseInt(edtAngka2.getText().toString());
                int hasil = angka1 + angka2;
                txtHasil.setText("Hasil : " + hasil);
            }
        });

        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int angka1 = Integer.parseInt(edtAngka1.getText().toString());
                int angka2 = Integer.parseInt(edtAngka2.getText().toString());
                int hasil = angka1 - angka2;
                txtHasil.setText("Hasil : " + hasil);
            }
        });

        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int angka1 = Integer.parseInt(edtAngka1.getText().toString());
                int angka2 = Integer.parseInt(edtAngka2.getText().toString());
                int hasil = angka1 * angka2;
                txtHasil.setText("Hasil : " + hasil);
            }
        });

        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float angka1 = Integer.parseInt(edtAngka1.getText().toString());
                float angka2 = Integer.parseInt(edtAngka2.getText().toString());
                float hasil = angka1 / angka2;
                txtHasil.setText("Hasil : " + hasil);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtAngka1.setText("");
                edtAngka2.setText("");
                txtHasil.setText("Hasil : 0");
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KalkulatorAritmatika.this, MainActivity.class));
            }
        });
    }
}