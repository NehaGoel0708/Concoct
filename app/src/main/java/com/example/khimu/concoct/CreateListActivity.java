package com.example.khimu.concoct;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class CreateListActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
   private  ListView lv;
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);
        Intent intent=this.getIntent();
        Spinner spinner=(Spinner)findViewById(R.id.spinner2);
        save=(Button) findViewById(R.id.savebtn);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CreateListActivity.this,"File Save in Your Device",Toast.LENGTH_LONG).show();
            }
        });

        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(this);
        List<String> food=new ArrayList<String>();

        food.add("Food");
        food.add("Water");
        food.add("Flashlight");
        food.add("Battery Radio");
        food.add("Extra Batteries");
        food.add("First Aid Kit");
        food.add("Local Maps");

        ArrayAdapter<String > dataset=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,food);
        spinner.setPrompt("Select disaster");
        dataset.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataset);
        lv = (ListView) findViewById(R.id.lv);
        items = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        lv.setAdapter(itemsAdapter);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item=parent.getItemAtPosition(position).toString();
        itemsAdapter.add(item);


    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    }


