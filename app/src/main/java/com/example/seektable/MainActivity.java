package com.example.seektable;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    TextView textview;
    SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listView);
        textview = findViewById(R.id.textView);
        seekbar = findViewById(R.id.seekBar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            seekbar.setMin(1);
        }
        seekbar.setMax(20);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Toast.makeText(MainActivity.this,"Table " + progress,Toast.LENGTH_SHORT).show();
                Table(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    @SuppressLint("SetTextI18n")
    public void Table(int table) {
        ArrayList<String> multable = new ArrayList<>();
        int i;
        for (i = 1; i <= 10; i++) {
            multable.add(table + " X " + i + " = " + table * i);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, multable);
        listview.setAdapter(arrayAdapter);
        textview.setText("Multiplication Table of " + table);

    }


}
