package com.example.dnk_1150070024_lab1_th1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Bai3_Lab2Activity extends AppCompatActivity {

    ImageView imgCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3_lab2);

        imgCall = findViewById(R.id.imgCall);

        // Khi bấm icon thì mở ứng dụng Gọi điện
        imgCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"));
            startActivity(intent);
        });
    }
}
