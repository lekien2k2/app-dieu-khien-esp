package com.example.minhtuan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class MainLight extends AppCompatActivity {

    Button btn_start,btn_end;
    TextView start,end;
    TimePicker timePicker;
    Calendar calendar;
    SeekBar sk;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference hour = database.getReference("PHONG_KHACH/HEN_GIO/gio");
    DatabaseReference minute = database.getReference("PHONG_KHACH/HEN_GIO/phut");
    DatabaseReference pwm = database.getReference("PWM");

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_light);
        btn_start = (Button) findViewById(R.id.button19);
        btn_end = (Button) findViewById(R.id.button20);
        start = (TextView) findViewById(R.id.start);
        end = (TextView) findViewById(R.id.end);
        timePicker = (TimePicker) findViewById(R.id.time);
        calendar = Calendar.getInstance();
        sk = findViewById(R.id.seekbarlight);

        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //i giá trị seebar
                pwm.setValue(i*2);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //GetData(urlGetData);

            }
        });

        btn_start.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                calendar.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE,timePicker.getCurrentMinute());
                int gio1 = timePicker.getCurrentHour();
                int phut1 = timePicker.getCurrentMinute();

                if (gio1 < 10) {
                    if (phut1 <10) {
                        String string_gio1 = String.valueOf(gio1);
                        String string_phut1 = String.valueOf(phut1);
                        start.setText("Start: 0" + string_gio1 + ":0" + string_phut1);
                    }
                    else{
                        String string_gio1 = String.valueOf(gio1);
                        String string_phut1 = String.valueOf(phut1);
                        start.setText("Start: 0" + string_gio1 + ":" + string_phut1);
                    }
                }
                else{
                    if (phut1 <10) {
                        String string_gio1 = String.valueOf(gio1);
                        String string_phut1 = String.valueOf(phut1);
                        start.setText("Start: " + string_gio1 + ":0" + string_phut1);
                    }
                    else{
                        String string_gio1 = String.valueOf(gio1);
                        String string_phut1 = String.valueOf(phut1);
                        start.setText("Start: " + string_gio1 + ":" + string_phut1);
                    }
                }
            }

        });
        btn_end.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                calendar.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE,timePicker.getCurrentMinute());
                int gio2 = timePicker.getCurrentHour();
                int phut2 = timePicker.getCurrentMinute();
                if (gio2 < 10) {
                    if (phut2 <10) {
                        String string_gio2 = String.valueOf(gio2);
                        String string_phut2 = String.valueOf(phut2);
                        end.setText("End: 0" + string_gio2 + ":0" + string_phut2);
                    }
                    else{
                        String string_gio2 = String.valueOf(gio2);
                        String string_phut2 = String.valueOf(phut2);
                        end.setText("End: 0" + string_gio2 + ":" + string_phut2);
                    }
                }
                else{
                    if (phut2 <10) {
                        String string_gio2 = String.valueOf(gio2);
                        String string_phut2 = String.valueOf(phut2);
                        end.setText("End: " + string_gio2 + ":0" + string_phut2);
                    }
                    else{
                        String string_gio2 = String.valueOf(gio2);
                        String string_phut2 = String.valueOf(phut2);
                        end.setText("End: " + string_gio2 + ":" + string_phut2);
                    }
                }
            }
        });
    }
}