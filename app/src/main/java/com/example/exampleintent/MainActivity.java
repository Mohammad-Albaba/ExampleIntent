package com.example.exampleintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.number.IntegerWidth;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
EditText editTextName;
EditText editTextAddress;
EditText editTextPhone_Number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextTextName);
        editTextAddress = findViewById(R.id.editTextTextAddress);
        editTextPhone_Number = findViewById(R.id.editTextTextPhone_Number);

//        String name = getIntent().getStringExtra("name");
//        editTextName.setText(name);
//
//        String Address = getIntent().getStringExtra("address");
//        editTextAddress.setText(Address);
//
//        String Phone_Number = getIntent().getStringExtra("phone_number");
//        editTextPhone_Number.setText(Phone_Number);



//        if (getIntent() != null
//        && getIntent().hasExtra("name")
//        && getIntent().hasExtra("Address")
//        && getIntent().hasExtra("Phone_Number")){
//
//            String name = getIntent().getStringExtra("name");
//            String Address = getIntent().getStringExtra("Address");
//            String Phone_Number= getIntent().getStringExtra("Phone_Number");
//
//                editTextName.setText(name);
//                editTextAddress.setText(Address);
//                editTextPhone_Number.setText(Phone_Number);
//    }


//هاد لو بدي أعطيه بيانات عطريقة البندل
//        if (getIntent() !=null && getIntent().getExtras() != null){
//           Bundle bundle =getIntent().getExtras();
//           String name = bundle.getString("name");
//            String address = bundle.getString("address");
//            String phoneNumber = bundle.getString("phone_number");
//
//           editTextName.setText(name);
//           editTextAddress.setText(address);
//           editTextPhone_Number.setText(phoneNumber);
//    }





        //هاد لو بدي أعطيه أوبجيكت واستخدم البرسليبل بحط البيانات بكلاس وبقرأهم بالبريسيبل
        if (getIntent() !=null && getIntent().hasExtra("user")){
            User user = getIntent().getParcelableExtra("user");
            if (user != null){
                editTextName.setText(user.getName());
                editTextAddress.setText(user.getAddress());
                editTextPhone_Number.setText(user.getPhoneNumber());
            }
        }
        }}

