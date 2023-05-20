package com.example.minhtuan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainFan extends AppCompatActivity {
    ProgressBar progressBar;
    DatabaseReference analog;
    TextView  ana;
    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_fan);

        progressBar = findViewById(R.id.progressBar);
        ana = findViewById(R.id.ana);
   //     progressBar.setProgress(15);

        analog = FirebaseDatabase.getInstance().getReference();
        analog.child("ANALOG").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ana.setText(snapshot.getValue().toString());
                progress = Integer.parseInt(snapshot.getValue().toString());
                progressBar.setProgress(progress/40);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}