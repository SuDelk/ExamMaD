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

import java.util.List;

public class EditProfile extends AppCompatActivity {
    EditText username,dob,password;
    Button edit,Delete,search,view;
    RadioButton male,female;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        username = findViewById(R.id.unEdit);
        dob =  findViewById(R.id.dobEdit);
        password = findViewById(R.id.pwdEdit);
        edit = findViewById(R.id.edit);
        Delete = findViewById(R.id.dlt);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        search = findViewById(R.id.search);
        view = findViewById(R.id.viewBtn);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler db = new DBHandler(getApplicationContext());
                List user = db.readAllInfo(username.getText().toString());
                if(user.isEmpty()){
                    Toast.makeText(EditProfile.this, "No User", Toast.LENGTH_SHORT).show();
                    username.setText(null);
                }
                else{
                    Toast.makeText(EditProfile.this, "User Found : " + user.get(0).toString(), Toast.LENGTH_SHORT).show();
                    username.setText(user.get(0).toString());
                    dob.setText(user.get(1).toString());
                    password.setText(user.get(2).toString());
                    if(user.get(3).toString().equals("Male")){
                        male.setChecked(true);
                    }else{
                        female.setChecked(true);
                    }
                }
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(male.isChecked()){
                    gender = "Male";
                }
                else{
                    gender = "Female";
                }
                DBHandler db = new DBHandler(getApplicationContext());
                Boolean status = db.updateInfo(username.getText().toString(),dob.getText().toString(),password.getText().toString(),gender);
                if(status){
                    Toast.makeText(EditProfile.this, "Update Successful", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(EditProfile.this, "Update Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler db = new DBHandler(getApplicationContext());
                db.deleteInfo(username.getText().toString());
                Toast.makeText(EditProfile.this, "User Deleted", Toast.LENGTH_SHORT).show();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EditProfile.this,ViewAll.class);
                startActivity(i);
            }
        });
    }
}