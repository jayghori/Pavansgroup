package com.example.pavansgroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pavansgroup.Adapter.UserAadapter;
import com.example.pavansgroup.Database.UserDatabase;
import com.example.pavansgroup.Model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String TAG = "MAINTAGER";
    EditText edtName, edtAddress;
    ImageView imageView;
    TextView textView;
    Button btnAdd;
    RecyclerView recyclerView;
    List<User> userList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtAddress = findViewById(R.id.edtAddress);
        btnAdd = findViewById(R.id.btnAdd);
        imageView = findViewById(R.id.image);
        textView = findViewById(R.id.tvTextview);
        userList=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerView);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TicTacToeActivity.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String adress = edtAddress.getText().toString();

                User user = new User(1, name, adress);

                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        super.run();

                        UserDatabase.getInstance(MainActivity.this).userDao().insertUser(user);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "Inserted succesfully", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                };
                thread.start();

                new Thread() {
                    @Override
                    public void run() {
                        super.run();

                        List<User> userList = UserDatabase.getInstance(MainActivity.this).userDao().getAllUser();


                        final StringBuilder data = new StringBuilder();

                        for (User user : userList) {
                            data.append("id : ").append(user.getId()).append("\n");
                            data.append("name : ").append(user.getName()).append("\n");
                            data.append("company : ").append(user.getAddress()).append("\n");
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(data.toString());
                            }
                        });
                    }
                }.start();





            }
        });

    }
}