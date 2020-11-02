package com.pvt.gosselin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity4 extends AppCompatActivity {
    EditText txtfullname,txtemail,txtnumber,txtmovingfrom,txtmovingto,txtmovingdate,txtmessage;
    EditText txtpassword;
    Button bsubmit;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main4);
        //casting views
        //txtpassword = (EditText) findViewById(R.id.password);
        txtfullname = (EditText) findViewById(R.id.fullname);
        txtemail = (EditText) findViewById(R.id.email);
        txtnumber = (EditText) findViewById(R.id.number);
        txtmovingfrom = (EditText) findViewById(R.id.movingfrom);
        txtmovingto = (EditText) findViewById(R.id.movingto);
        txtmovingdate = (EditText) findViewById(R.id.date);
        txtmessage = (EditText) findViewById(R.id.message);
        bsubmit = (Button) findViewById(R.id.submbit);

        databaseReference = firebaseDatabase.getInstance().getReference("user");
        firebaseAuth =FirebaseAuth.getInstance();
        bsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String services="" ;
                final String password = "admin";
                 final String fullname=txtfullname.getText().toString();
                 final String email=txtemail.getText().toString();
                 final String number=txtnumber.getText().toString();
                final String movingfrom=txtmovingfrom.getText().toString();
                final String movingto=txtmovingto.getText().toString();
                final String date=txtmovingto.getText().toString();
                final String message=txtmessage.getText().toString();

                /*if (chhousehold.isChecked()){
                    services="household";

                }
                if(chpet.isChecked()){
                    services="pet";

                }
                if(chstoragesolution.isChecked()){
                    services="storage";

                }
                if(choffice.isChecked()){
                    services="office";
                }
                if(chfinearts.isChecked()){
                    services="finearts";
                }
                if(chcar.isChecked()){
                    services="car";
                }
                if(chothers.isChecked()){

                    services="others";

                } */


                //if fields are empty

              if(TextUtils.isEmpty(fullname)){
                    Toast.makeText(MainActivity4.this,
                            "Please enter fullname", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(MainActivity4.this,
                            "Please enter email", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(number)){

                    Toast.makeText(MainActivity4.this,
                            "Please enter number", Toast.LENGTH_SHORT).show();

                }
                if(TextUtils.isEmpty(movingfrom)){
                    Toast.makeText(MainActivity4.this,
                            "Please enter Moving from", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(movingto)){
                    Toast.makeText(MainActivity4.this,
                            "Please enter Moving to", Toast.LENGTH_SHORT).show();

                }
                if(TextUtils.isEmpty(date)){
                    Toast.makeText(MainActivity4.this,
                            "Please enter date", Toast.LENGTH_SHORT).show();

                }
                if(TextUtils.isEmpty(message)){
                    Toast.makeText(MainActivity4.this,
                            "Please enter message", Toast.LENGTH_SHORT).show();

                }

                //final String check = services;
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity4.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    users information = new users(
                                            fullname,
                                            email,
                                            number,
                                            movingfrom,
                                            movingto,
                                            date,
                                            message


                                    );

                                    FirebaseDatabase.getInstance().getReference("user")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            Toast.makeText(MainActivity4.this,
                                                    "Registration Succesfull", Toast.LENGTH_SHORT).show();

                                            startActivity(new Intent(getApplicationContext(),ScrollingActivity.class));


                                        }
                                    });



                                } else {



                                }

                            }
                        });




            }
        });


    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(MainActivity4.this,ScrollingActivity.class);
        startActivity(intent);
        finish();
    }
}