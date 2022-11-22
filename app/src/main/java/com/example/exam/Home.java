package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Home extends AppCompatActivity {

    EditText username,password;
    Button Login,Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        username = findViewById(R.id.userNameLgn);
        password = findViewById(R.id.passwordLgn);
        Login = findViewById(R.id.loginBtn);
        Register = findViewById(R.id.regBtn);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, ProfileManagement.class);
                startActivity(i);
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog bottomSheetDialog = new Dialog(Home.this);
                View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.delete_bottom_sheet,(LinearLayout)findViewById(R.id.deleteSheet));

                TextView deleteView = bottomSheetView.findViewById(R.id.deleteText);
                Button deleteQuizButton = bottomSheetView.findViewById(R.id.deleteButton);
                Button deleteCancel = bottomSheetView.findViewById(R.id.deleteCancel);

                deleteView.setText("This Quiz will be permanently deleted \nAre you sure?");
                deleteQuizButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                deleteCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetDialog.setCancelable(false);
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });
    }
}