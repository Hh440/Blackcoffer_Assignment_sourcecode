package com.example.asiignment_problem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.Objects;

public class Refine extends AppCompatActivity {

    Toolbar toolbar;
    String[] items={"Available | Hey Let Us Connect","Away | Stay Discrete And Watch","Busy | Do Not Disturb | Will Catch Up later",
            "SoS | Emergency!Need Assistance!Help"};

    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapteritems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refine);

        toolbar=findViewById(R.id.refine_toolbar);

        autoCompleteTextView=findViewById(R.id.auto_complte_txt);
        adapteritems= new ArrayAdapter<String>(this,R.layout.list_view,items);

        autoCompleteTextView.setAdapter(adapteritems);





        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        getSupportActionBar().setTitle("Refine");



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}