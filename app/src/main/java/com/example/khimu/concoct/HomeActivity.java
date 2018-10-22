package com.example.khimu.concoct;

import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button disaster_btn,checklistbtn,emer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        disaster_btn=(Button)findViewById(R.id.disasterbtn);
        checklistbtn=(Button)findViewById(R.id.checklistbtn);
        emer=(Button) findViewById(R.id.emerbtn);
        emer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startemer=new Intent(HomeActivity.this,EmergencyActivity.class);
                startActivity(startemer);
            }
        });
        checklistbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startChecklist=new Intent(HomeActivity.this,ChecklistActivity.class);
                startActivity(startChecklist);
            }
        });
        disaster_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent disaster_intent=new Intent(HomeActivity.this,DisasterActivity.class);
                startActivity(disaster_intent);
            }
        });
    }
}
