package com.example.khimu.concoct;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ChecklistActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView tv;
    Button go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);
        tv=(TextView) findViewById(R.id.tv);

        go=(Button) findViewById(R.id.gobtn);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startCreatelist=new Intent(ChecklistActivity.this,CreateListActivity.class);
                startActivity(startCreatelist);
            }
        });

        Spinner spinner=(Spinner)findViewById(R.id.spinner);

        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(this);
        List<String> disasters=new ArrayList<String>();

        disasters.add("Earthquake");
        disasters.add("Landslide");
        disasters.add("Hurricane");
        disasters.add("Volcanoes");
        disasters.add("Wild fires");
        disasters.add("Extreme Heat");
        disasters.add("Hail");
        disasters.add("Sink Holes");
        disasters.add("Thunderstorm");
        disasters.add("Tsunami");

        ArrayAdapter<String > dataset=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,disasters);
        spinner.setPrompt("Select disaster");
        dataset.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataset);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item=parent.getItemAtPosition(position).toString();


    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
