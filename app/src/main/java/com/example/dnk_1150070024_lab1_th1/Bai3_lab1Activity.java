package com.example.dnk_1150070024_lab1_th1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai3_lab1Activity extends AppCompatActivity {

    EditText edtPhone, edtSMS;
    Button btnCall, btnSMS;
    TextView txtKQ;
    static final int REQUEST_CALL_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3_lab1);

        edtPhone = findViewById(R.id.edtPhone);
        edtSMS = findViewById(R.id.edtSMS);
        btnCall = findViewById(R.id.btnCall);
        btnSMS = findViewById(R.id.btnSMS);
        txtKQ = findViewById(R.id.txtKQ);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edtPhone.getText().toString().trim();
                if (phone.isEmpty()) {
                    txtKQ.setText("Vui lòng nhập số điện thoại!");
                    return;
                }

                if (ContextCompat.checkSelfPermission(Bai3_lab1Activity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Bai3_lab1Activity.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            REQUEST_CALL_PERMISSION);
                } else {
                    Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
                    startActivity(callIntent);
                }
            }
        });

        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edtPhone.getText().toString().trim();
                String message = edtSMS.getText().toString().trim();

                if (phone.isEmpty() || message.isEmpty()) {
                    txtKQ.setText("Vui lòng nhập đủ số và nội dung!");
                    return;
                }

                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phone));
                smsIntent.putExtra("sms_body", message);
                startActivity(smsIntent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                txtKQ.setText("Đã được cấp quyền gọi!");
            } else {
                txtKQ.setText("Bạn chưa cấp quyền gọi điện!");
            }
        }
    }
}
