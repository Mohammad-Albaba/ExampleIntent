package com.example.exampleintent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Notification;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {
    private static final int REQUEST_CALL_PERMISSION = 100;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+90599900000"));
//                startActivity(intent);
//
//            }
//        });

//        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent();
////                intent.setData(Uri.parse("https://www.fb.com"));
//                intent.setData(Uri.parse("geo:0,0?q=Gaza+Strip"));
//
//                startActivity(intent);
//
//            }
//        });


//        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent();
//                intent.setAction(Intent.ACTION_SENDTO);
//                intent.setData(Uri.parse("smsto:+920000000,+98320000"));
//                intent.putExtra("sms_body","Hello ??");
//                startActivity(intent);
//
//            }
//        });

//        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent();
//                intent.setAction(Intent.ACTION_SENDTO);
//                intent.setData(Uri.fromParts("mailto", "omar.elbealbasy@gmail.com", null));
//                intent.putExtra(Intent.EXTRA_SUBJECT,"mail title");
//                intent.putExtra(Intent.EXTRA_EMAIL,"bla bla bla");
//                if (getPackageManager().resolveActivity(intent,0) != null){
//                    startActivity(intent);
//
//                }else {
//                    Toast.makeText(SplashActivity.this, "You don't have required application", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });

        user =new User("Mohammad", "Gaza..","0595335637");
        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent();
//                intent.setClass(SplashActivity.this, MainActivity.class);
//                intent.putExtras(intent);
//                   startActivity(intent);
//                intent.putExtra("name", "mohammad");
//                intent.putExtra("address", "Gaza..");
//                intent.putExtra("phone_number", "0595335637");

//                Bundle bundle=new Bundle();
//                bundle.putString("name", "mohammad");
//                bundle.putString("address", "Gaza..");
//                bundle.putString("phone_number", "0595335637");
//                Intent intent=new Intent();
//
//                intent.setClass(SplashActivity.this, MainActivity.class);
//                   intent.putExtras(bundle);
//                   startActivity(intent);


//                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
//                intent.putExtra("user", user);
//                startActivity(intent);

                checkPermissionAndCall();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_PERMISSION){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                checkPermissionAndCall();
            }else {
                Toast.makeText(this, "This app need call permission to work!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void  checkPermissionAndCall(){

        if (ContextCompat.checkSelfPermission(SplashActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0595335637"));
            startActivity(intent);

        }else {
            // إذا رجعت فولس بتكون اول مرة واذا رجعت ترو بتكون اني مرة أو أكثر فبدي أعمل توضيح للمستخدم عشان يرضى يوافق هاد بالنسبة ل شود شو ريكويست بارميشين
            if (ActivityCompat.shouldShowRequestPermissionRationale(SplashActivity.this,Manifest.permission.CALL_PHONE)){
                new AlertDialog.Builder(this).setTitle("Explanation").setMessage("The app need this permission to be able to call the phones directly when enter the call button in the menu").setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(SplashActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL_PERMISSION);

                    }
                }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create().show();
            }else {
                ActivityCompat.requestPermissions(SplashActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL_PERMISSION);

            }
        }
    }
}