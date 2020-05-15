package com.example.myfrontend.activities;

import android.content.Intent;
import android.os.Bundle;

import com.example.myfrontend.R;
import com.example.myfrontend.service.UserService;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button signin;
    private Button signup;
    private Button showmap;
    private Button showroute;
    private Button showfence;
    private Button test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ((EditText) findViewById(R.id.etname)).getText().toString();
                String password = ((EditText) findViewById(R.id.etpassword)).getText().toString();
                if (UserService.signIn(name, password))
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        }
                    });
                else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ((EditText) findViewById(R.id.etname)).getText().toString();
                String password = ((EditText) findViewById(R.id.etpassword)).getText().toString();
                if (UserService.signUp(name, password))
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        }
                    });
                else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        showmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

        showroute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, RouteActivity.class);
                startActivity(intent);
            }
        });
        showfence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, GeofencingActivity.class);
                startActivity(intent);
            }
        });
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, ForegroundActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init(){
        signin = (Button) findViewById(R.id.signin);
        signup = (Button) findViewById(R.id.signup);
        showmap = (Button)findViewById(R.id.showmap);
        showroute = (Button)findViewById(R.id.showroute);
        showfence = (Button)findViewById(R.id.showfence);
        test= (Button)findViewById(R.id.test);
    }
}
