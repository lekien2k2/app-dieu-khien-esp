package com.example.minhtuan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class select extends AppCompatActivity {
    private TabLayout mTablayout;
    private ViewPager2 mviewPager;
    private viewpage viewpage;
    private TextView nhietdo;
    private TextView doam;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference DA1;
    DatabaseReference ND1;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_select);
        mTablayout = findViewById(R.id.tablayout);
        mviewPager = findViewById(R.id.view_page);
        nhietdo = findViewById(R.id.nhiet_do);
        doam = findViewById(R.id.do_am);

        ND1 = FirebaseDatabase.getInstance().getReference();
        ND1.child("NHIET_DO").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                nhietdo.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        DA1 = FirebaseDatabase.getInstance().getReference();
        DA1.child("DO_AM").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                doam.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        viewpage  viewpage = new viewpage(this);
        mviewPager.setAdapter(viewpage);

        new TabLayoutMediator(mTablayout, mviewPager, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText("Living");
                    break;
                case 1:
                    tab.setText("Dining");
                    break;
                case 2:
                    tab.setText("Kitchen");
                    break;
                case 3:
                    tab.setText("Bed room");
                    break;

            }
        }).attach();

    }
}