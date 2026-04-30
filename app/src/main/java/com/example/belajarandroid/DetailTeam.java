package com.example.belajarandroid;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class DetailTeam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_team);
        setupUI();
    }

    private void setupUI() {
        View mainLayout = findViewById(R.id.mainDetailLayout);
        ImageView imgLogo = findViewById(R.id.detailImgF1);
        TextView tvNama = findViewById(R.id.detailNama);
        TextView tvTahun = findViewById(R.id.detailTahun);
        TextView tvDetail = findViewById(R.id.detailDeskripsi);

        String nama = getIntent().getStringExtra("nama");
        String tahun = getIntent().getStringExtra("tahun");
        String detail = getIntent().getStringExtra("detail");
        int imageRes = getIntent().getIntExtra("img", 0);
        int pColorRes = getIntent().getIntExtra("p_color", android.R.color.black);
        int[] extras = getIntent().getIntArrayExtra("extra_colors");

        tvNama.setText(nama);
        tvTahun.setText(String.format("Sejak %s", tahun));
        tvDetail.setText(detail);
        imgLogo.setImageResource(imageRes);

        int resolvedPrimaryColor = ContextCompat.getColor(this, pColorRes);
        mainLayout.setBackgroundColor(resolvedPrimaryColor);

        applyPatternColors(extras);

        adjustTextContrast(resolvedPrimaryColor, tvNama, tvTahun, tvDetail);
    }

    private void applyPatternColors(int[] extras) {
        if (extras == null) return;

        int[] patternIds = {
                R.id.imgPattern1, R.id.imgPattern2, R.id.imgPattern3,
                R.id.imgPattern4, R.id.imgPattern5, R.id.imgPattern6
        };

        for (int i = 0; i < extras.length && i < patternIds.length; i++) {
            ImageView imgPattern = findViewById(patternIds[i]);
            if (imgPattern != null) {
                imgPattern.setVisibility(View.VISIBLE);
                imgPattern.setColorFilter(ContextCompat.getColor(this, extras[i]));
            }
        }
    }

    private void adjustTextContrast(int backgroundColor, TextView... textViews) {
        double darkness = 1 - (0.299 * Color.red(backgroundColor) +
                0.587 * Color.green(backgroundColor) +
                0.114 * Color.blue(backgroundColor)) / 255;

        int textColor = (darkness < 0.5) ? Color.BLACK : Color.WHITE;
        int subTextColor = (darkness < 0.5) ? Color.parseColor("#444444") : Color.parseColor("#E0E0E0");

        for (TextView tv : textViews) {
            if (tv.getId() == R.id.detailTahun) {
                tv.setTextColor(subTextColor);
            } else {
                tv.setTextColor(textColor);
            }
        }
    }
}