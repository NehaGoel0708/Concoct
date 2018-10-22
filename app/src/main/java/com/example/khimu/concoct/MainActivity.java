package com.example.khimu.concoct;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button login,register,skipbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button) findViewById(R.id.loginbtn);
        register=(Button) findViewById(R.id.registerbtn);
        skipbtn=(Button) findViewById(R.id.skipbtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startlogin=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(startlogin);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startregister=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(startregister);
            }
        });
        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startskip=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(startskip);
            }
        });
    }
}
