package com.example.belajarandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class F1Team extends AppCompatActivity {

    RecyclerView rvF1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_f1_team);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rvF1 = (RecyclerView) findViewById(R.id.rvF1);

        ArrayList<F1Model> ListDataF1 = new ArrayList<>();

        ListDataF1.add(new F1Model("1", "Scuderia Ferrari", "1950", R.drawable.ferrari,"Tim tertua di Formula 1 yang sudah berkompetisi sejak 1950 dan menjadi simbol tradisi balap. Ferrari dikenal dengan sejarah panjang, fanbase besar (Tifosi), dan banyak gelar juara dunia. Meski beberapa tahun terakhir performanya naik turun, Ferrari tetap menjadi salah satu tim paling ikonik di F1. Warna merah khas mereka menjadi identitas kuat di dunia motorsport.",
                R.color.f1_ferrari_p, R.color.f1_ferrari_a, R.color.f1_ferrari_h));
        ListDataF1.add(new F1Model("2", "McLaren", "1966", R.drawable.mclaren, "McLaren adalah salah satu tim legendaris yang telah berkompetisi sejak 1966. Tim ini dikenal dengan inovasi teknologi dan sejarah panjang bersama pembalap hebat. Setelah sempat mengalami penurunan performa, McLaren kini kembali bangkit sebagai pesaing kuat di papan atas Formula 1.",
                R.color.f1_mclaren_p, R.color.f1_mclaren_a, R.color.f1_mclaren_c1, R.color.f1_mclaren_c2, R.color.f1_mclaren_c3, R.color.f1_mclaren_c4));
        ListDataF1.add(new F1Model("3", "Williams", "1977", R.drawable.williams, "Williams adalah salah satu tim legendaris Formula 1 yang berdiri sejak 1977 dan memiliki banyak gelar juara dunia di masa lalu. Tim ini dikenal dengan sejarah kuat dan kontribusi besar dalam perkembangan teknologi balap. Dalam beberapa tahun terakhir, Williams fokus membangun kembali performa untuk kembali bersaing di papan tengah hingga atas.",
                R.color.f1_williams_p, R.color.f1_williams_a, R.color.f1_williams_h));
        ListDataF1.add(new F1Model("4", "Audi (Sauber Stake)", "1993", R.drawable.audi, "Tim ini berawal dari Sauber yang telah lama berkompetisi di Formula 1 sejak 1993. Saat ini, tim sedang dalam masa transisi menuju proyek besar bersama Audi. Fokus utama mereka adalah membangun fondasi kuat sebelum berubah menjadi tim pabrikan penuh di masa depan.",
                R.color.f1_audi_p, R.color.f1_audi_a, R.color.f1_audi_h));
        ListDataF1.add(new F1Model("5", "Red Bull Racing", "2005", R.drawable.redbullracing, "Red Bull Racing merupakan tim yang dikenal dengan dominasi di era modern F1, terutama sejak 2010-an. Dengan pendekatan agresif dan inovatif, tim ini berhasil meraih banyak gelar juara dunia. Mereka juga terkenal dalam mengembangkan pembalap muda berbakat.",
                R.color.f1_redbull_p, R.color.f1_redbull_a, R.color.f1_redbull_h, R.color.f1_redbull_e));
        ListDataF1.add(new F1Model("6", "Mercedes-AMG", "2010", R.drawable.mercedespetronas, "Mercedes-AMG Petronas mendominasi Formula 1 di era hybrid sejak 2014 dengan berbagai gelar konstruktor dan pembalap. Tim ini dikenal dengan konsistensi, strategi matang, dan teknologi mesin yang sangat kuat. Salah satu era paling dominan dalam sejarah F1 berasal dari tim ini.",
                R.color.f1_mercedes_p, R.color.f1_mercedes_a, R.color.f1_mercedes_h));
        ListDataF1.add(new F1Model("7", "Haas", "2016", R.drawable.haas, "Haas merupakan tim asal Amerika Serikat yang debut di Formula 1 pada 2016. Tim ini dikenal dengan pendekatan efisien dan kerja sama teknis dengan Ferrari. Meskipun sering berada di papan tengah hingga bawah, Haas tetap kompetitif dalam memaksimalkan sumber daya yang terbatas.",
                R.color.f1_haas_p, R.color.f1_haas_a, R.color.f1_haas_h));
        ListDataF1.add(new F1Model("8", "RB (VCARB)", "2020", R.drawable.visacash, "RB adalah tim satelit dari Red Bull Racing yang berfungsi sebagai tempat pengembangan pembalap muda. Tim ini sebelumnya dikenal sebagai Toro Rosso dan AlphaTauri sebelum berganti nama. Fokus utama mereka adalah membina talenta baru sambil tetap kompetitif di grid." ,
                R.color.f1_rb_p, R.color.f1_rb_a, R.color.f1_rb_h));
        ListDataF1.add(new F1Model("9", "Aston Martin", "2021", R.drawable.astonmartin, "Aston Martin kembali ke Formula 1 dengan ambisi besar sebagai tim papan atas. Dengan investasi besar dan fasilitas modern, tim ini berkembang pesat dalam beberapa musim terakhir. Mereka menargetkan untuk menjadi penantang gelar di masa depan.",
                R.color.f1_aston_p, R.color.f1_aston_a, R.color.f1_aston_h));
        ListDataF1.add(new F1Model("10", "Alpine", "2021", R.drawable.alpine, "Alpine adalah tim pabrikan milik Renault yang berkompetisi di Formula 1 dengan identitas baru sejak 2021. Tim ini memiliki sejarah panjang dan dikenal sebagai pengembang mesin yang kuat. Target utama Alpine adalah kembali ke posisi teratas melalui kombinasi teknologi dan strategi.",
                R.color.f1_alpine_p, R.color.f1_alpine_a, R.color.f1_alpine_h));
        ListDataF1.add(new F1Model("11", "Cadillac", "2026", R.drawable.cadillac, "Cadillac adalah tim baru Formula 1 yang debut pada musim 2026 dengan dukungan General Motors. Sebagai pabrikan Amerika, tim ini fokus membangun performa dan fondasi kuat di musim awal. Meski belum kompetitif di papan atas, Cadillac membawa warna baru dalam persaingan Formula 1.",
                R.color.f1_cadillac_p, R.color.f1_cadillac_a, R.color.f1_cadillac_h));


        rvF1.setLayoutManager(new LinearLayoutManager(this));

        AdapterF1Team adapter = new AdapterF1Team(ListDataF1, new AdapterF1Team.OnItemClickListener() {
            @Override
            public void onItemClick(F1Model F1) {
                Toast.makeText(F1Team.this, F1.getNama(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(F1Team.this, DetailTeam.class);

                intent.putExtra("nama", F1.getNama());
                intent.putExtra("tahun", F1.getTahun());
                intent.putExtra("nomor", F1.getNomor());
                intent.putExtra("img", F1.getImg());
                intent.putExtra("detail", F1.getDetail());

                intent.putExtra("p_color", F1.getPColor());
                intent.putExtra("extra_colors", F1.getExtraColors());

                startActivity(intent);
            }
        });

        rvF1.setAdapter(adapter);
    }
}