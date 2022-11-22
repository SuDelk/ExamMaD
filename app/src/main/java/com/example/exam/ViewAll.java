package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.exam.Database.DBHandler;

import java.util.ArrayList;
import java.util.List;

public class ViewAll extends AppCompatActivity {
    private ArrayList<Userss> ul;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        recyclerView = findViewById(R.id.recView);
//        DBHandler db = new DBHandler(getApplicationContext());
//        List userList = db.readAllInfo();
//        ul= (ArrayList<Userss>) userList;
        ul = new ArrayList<>();
        setUserInfo();
        setAdapter();
    }
    private void setAdapter(){
        recyclerAdapter adapter = new recyclerAdapter(ul);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager((getApplicationContext()));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
    private void setUserInfo(){
        DBHandler db = new DBHandler(getApplicationContext());
        List userList = db.readAllInfo();
        while(!userList.isEmpty()){
            ul.add(new Userss(userList.remove(0).toString()));
        }

    }

}