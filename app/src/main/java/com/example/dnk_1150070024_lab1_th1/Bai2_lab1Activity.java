package com.example.dnk_1150070024_lab1_th1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class Bai2_lab1Activity extends AppCompatActivity {

    ImageView imgDice;
    TextView txtKQ;
    Button btnRoll;
    Random rd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2_lab1);

        imgDice = (ImageView) findViewById(R.id.imgDice);
        txtKQ = (TextView) findViewById(R.id.txtKQ);
        btnRoll = (Button) findViewById(R.id.btnRoll);

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int so = rd.nextInt(6) + 1; // random từ 1 đến 6
                txtKQ.setText("Bạn tung được số " + so);

                if (so == 1)
                    imgDice.setImageResource(R.drawable.dice_1);
                else if (so == 2)
                    imgDice.setImageResource(R.drawable.dice_2);
                else if (so == 3)
                    imgDice.setImageResource(R.drawable.dice_3);
                else if (so == 4)
                    imgDice.setImageResource(R.drawable.dice_4);
                else if (so == 5)
                    imgDice.setImageResource(R.drawable.dice_5);
                else
                    imgDice.setImageResource(R.drawable.dice_6);
            }
        });
    }
}
