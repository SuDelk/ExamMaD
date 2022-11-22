package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.exam.Database.DBHandler;

public class ProfileManagement extends AppCompatActivity {

    EditText username,dob,password;
    Button add,updateProfile;
    RadioButton male,female;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_management);

        username = findViewById(R.id.unReg);
        dob =  findViewById(R.id.dobReg);
        password = findViewById(R.id.pwdReg);
        add = findViewById(R.id.addBtn);
        updateProfile = findViewById(R.id.updateBtn);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);

        updateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),EditProfile.class);
                startActivity(i);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(male.isChecked()){
                    gender = "Male";
                }
                else{
                    gender = "Female";
                }
                DBHandler db = new DBHandler(getApplicationContext());
                long newID = db.addInfo(username.getText().toString(),dob.getText().toString(),password.getText().toString(),gender);
                Toast.makeText(ProfileManagement.this, String.valueOf(newID), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),EditProfile.class);
                startActivity(i);
            }
        });
    }
}