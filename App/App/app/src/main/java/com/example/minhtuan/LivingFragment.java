package com.example.minhtuan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LivingFragment extends Fragment {
    Switch  sw;
    ImageView img;
    Switch  sw1;
    ImageView img1;
    Switch  sw2;
    ImageView img2;
    Switch  sw3;
    ImageView img3;
    Button btn_tivi,btn_light,btn_air,btn_fan;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myref = database.getReference("PHONG_KHACH/DEN");
    DatabaseReference hi;
    DatabaseReference myref1 = database.getReference("PHONG_KHACH/AIR");
    DatabaseReference air1;
    DatabaseReference myref2 = database.getReference("PHONG_KHACH/FAN");
    DatabaseReference fan1;
    DatabaseReference myref3 = database.getReference("PHONG_KHACH/TI_VI");
    DatabaseReference tivi1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_living, container, false);


        img = (ImageView) view.findViewById(R.id.imageView12);
        sw = (Switch) view.findViewById(R.id.switch5);
        sw1 = (Switch) view.findViewById(R.id.switch3);
        img1 = (ImageView) view.findViewById(R.id.imageView15);
        sw2 = (Switch) view.findViewById(R.id.switch4);
        img2 = (ImageView) view.findViewById(R.id.imageView16);
        sw3 = (Switch) view.findViewById(R.id.switch7);
        img3 = (ImageView) view.findViewById(R.id.imageView18);

        btn_light = view.findViewById(R.id.btn_light);
        btn_air = view.findViewById(R.id.btn_air);
        btn_fan = view.findViewById(R.id.btn_fan);
        btn_tivi = view.findViewById(R.id.btn_tivi);


        hi =  FirebaseDatabase.getInstance().getReference();
        hi.child("PHONG_KHACH/DEN").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.getValue().toString().equals("1")){
                    img.setImageResource(R.drawable.img_17);
                    sw.setChecked(true);
                }
                else if (snapshot.getValue().toString().equals("0"))
                {
                    img.setImageResource(R.drawable.img_16);
                    sw.setChecked(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sw.isChecked()){
                    //led1.setValue("1");
                    myref.setValue(1);
                    img.setImageResource(R.drawable.img_17);
                }
                else {
                    myref.setValue(0);
                    //led1.setValue("0");
                    img.setImageResource(R.drawable.img_16);
                }
            }
        });

        air1 =  FirebaseDatabase.getInstance().getReference();
        air1.child("PHONG_KHACH/AIR").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.getValue().toString().equals("1")){
                    img3.setImageResource(R.drawable.img_19);
                    sw3.setChecked(true);
                }
                else if (snapshot.getValue().toString().equals("0"))
                {
                    img3.setImageResource(R.drawable.img_18);
                    sw3.setChecked(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        sw3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sw3.isChecked()){
                    //led1.setValue("1");
                    myref1.setValue(1);
                    img3.setImageResource(R.drawable.img_19);
                }
                else {
                    myref1.setValue(0);
                    //led1.setValue("0");
                    img3.setImageResource(R.drawable.img_18);
                }
            }
        });

        tivi1 =  FirebaseDatabase.getInstance().getReference();
        tivi1.child("PHONG_KHACH/TI_VI").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.getValue().toString().equals("1")){
                    img1.setImageResource(R.drawable.img_21);
                    sw1.setChecked(true);
                }
                else if (snapshot.getValue().toString().equals("0"))
                {
                    img1.setImageResource(R.drawable.img_20);
                    sw1.setChecked(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        sw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sw1.isChecked()){
                    //led1.setValue("1");
                    myref3.setValue(1);
                    img1.setImageResource(R.drawable.img_21);
                }
                else {
                    myref3.setValue(0);
                    //led1.setValue("0");
                    img1.setImageResource(R.drawable.img_20);
                }
            }
        });

        fan1 =  FirebaseDatabase.getInstance().getReference();
        fan1.child("PHONG_KHACH/FAN").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.getValue().toString().equals("1")){
                    img2.setImageResource(R.drawable.img_23);
                    sw2.setChecked(true);
                }
                else if (snapshot.getValue().toString().equals("0"))
                {
                    img2.setImageResource(R.drawable.img_22);
                    sw2.setChecked(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        sw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sw2.isChecked()){
                    //led1.setValue("1");
                    myref2.setValue(1);
                    img2.setImageResource(R.drawable.img_23);
                }
                else {
                    myref2.setValue(0);
                    //led1.setValue("0");
                    img2.setImageResource(R.drawable.img_22);
                }
            }
        });
        btn_light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MainLight.class);
                startActivity(intent);
            }
        });
        btn_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MainFan.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
