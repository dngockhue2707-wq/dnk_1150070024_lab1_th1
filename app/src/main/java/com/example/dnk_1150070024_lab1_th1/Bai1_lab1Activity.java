package com.example.dnk_1150070024_lab1_th1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai1_lab1Activity extends AppCompatActivity {

    EditText edtA, edtB;
    Button btnCong, btnTru, btnNhan, btnChia, btnChiaDu;
    TextView txtKQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitybai1_lab1);

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        btnChiaDu = findViewById(R.id.btnChiaDu);
        txtKQ = findViewById(R.id.txtKQ);

        btnCong.setOnClickListener(v -> tinh("+"));
        btnTru.setOnClickListener(v -> tinh("-"));
        btnNhan.setOnClickListener(v -> tinh("*"));
        btnChia.setOnClickListener(v -> tinh("/"));
        btnChiaDu.setOnClickListener(v -> tinh("%"));
    }

    private void tinh(String pheptoan) {
        try {
            double a = Double.parseDouble(edtA.getText().toString());
            double b = Double.parseDouble(edtB.getText().toString());
            double kq = 0;
            switch (pheptoan) {
                case "+": kq = a + b; break;
                case "-": kq = a - b; break;
                case "*": kq = a * b; break;
                case "/": kq = b != 0 ? a / b : 0; break;
                case "%": kq = a % b; break;
            }
            txtKQ.setText("Kết quả: " + kq);
        } catch (Exception e) {
            txtKQ.setText("Vui lòng nhập đủ 2 số!");
        }
    }
}
