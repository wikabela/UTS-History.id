package com.example.wika.historyindoid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.wika.historyindoid.models.Aturan;

import java.util.ArrayList;

public class LangkahActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterLangkah adapter;
    private ArrayList<Aturan> langkahArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_langkah);

        addData();
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new AdapterLangkah(langkahArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LangkahActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    void addData(){
        langkahArrayList = new ArrayList<>();
        langkahArrayList.add(new Aturan("Pastikan anda telah mendaftar pada laman registrasi dengan mengisi data diri dan passsword", "aa"));
        langkahArrayList.add(new Aturan("Lalu masuk dengan login akun yang telah didaftarkan", "bb"));
        langkahArrayList.add(new Aturan("Jika anda kesulitan menjalankan aplikasi History.id, klik menu dipojok kanan atas dan pilih Langkah untuk mengetahui langkah menjalankannya", "bb"));
        langkahArrayList.add(new Aturan("Jika anda punya catatan sejarah indonesia yang penting untuk anda ingat, pilih buttton tulis untuk melakukan tambah data", "bb"));
        langkahArrayList.add(new Aturan("Jika data telah ditambahkan maka data akan keluar pada List", "bb"));
        langkahArrayList.add(new Aturan("List catatan history.id dapat melakukan 3 aksi yaitu dapat dilihat, diupdate dan dihapus", "bb"));
        langkahArrayList.add(new Aturan("Jika anda akan keluar dari akun anda klik menu dipojok kanan atas atas dan pilih logout", "bb"));
    }
}

