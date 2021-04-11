package com.example.tiki_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements SendingData {
    TextView tvThanhtienMain;
    int soLuong = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvThanhtienMain = findViewById(R.id.tvThanhTienMain);
        //addFragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frmContainerBelow,BelowFragment.newInstance("1")).commit();
    }

    @Override
    public void sendData(String data) {
        soLuong = Integer.parseInt(data);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        tvThanhtienMain.setText(String.valueOf(decimalFormat.format(soLuong * 141800)) + "d");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frmContainerBelow,BelowFragment.newInstance(String.valueOf(soLuong))).commit();
    }
}