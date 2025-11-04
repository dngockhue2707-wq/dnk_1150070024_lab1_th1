package com.example.dnk_1150070024_lab1_th1;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Bai2_Lab2Activity extends AppCompatActivity {

    LinearLayout layoutMain;
    ImageView imgAnimal;
    View includeLoading;

    int[] bgColors = {
            Color.parseColor("#2196F3"),
            Color.parseColor("#4CAF50"),
            Color.parseColor("#FF9800"),
            Color.parseColor("#9C27B0"),
            Color.parseColor("#E91E63")
    };

    int[] animalIcons = {
            R.drawable.ic_penguin,
            R.drawable.ic_cat,
            R.drawable.ic_dog,
            R.drawable.ic_lion
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2_lab2);

        layoutMain = findViewById(R.id.layoutMain);
        imgAnimal = findViewById(R.id.imgAnimal);
        includeLoading = findViewById(R.id.includeLoading);

        // Hiển thị overlay loading
        includeLoading.setVisibility(View.VISIBLE);

        // Random nền + icon
        Random random = new Random();
        int color = bgColors[random.nextInt(bgColors.length)];
        int icon = animalIcons[random.nextInt(animalIcons.length)];
        layoutMain.setBackgroundColor(color);
        imgAnimal.setImageResource(icon);

        // Tự ẩn loading sau 3 giây
        new Handler().postDelayed(() -> includeLoading.setVisibility(View.GONE), 3000);
    }
}
