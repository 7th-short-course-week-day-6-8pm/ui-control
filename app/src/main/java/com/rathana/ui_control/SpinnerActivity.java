package com.rathana.ui_control;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.rathana.ui_control.model.ColorList;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {

    Spinner spinnerColor;
    List<String> colorsList=new ArrayList<>();
    List<ColorList> colorLists2=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        for(int i=0;i<=5;i++){
            colorLists2.add(new ColorList(i,"color "+i));
            colorsList.add("color "+i);
        }

//        colorsList.add("select color");
//        colorsList.add("Red");
//        colorsList.add("green");
//        colorsList.add("blue");
//        colorsList.add("gray");
//        colorsList.add("black");

        spinnerColor=findViewById(R.id.spinnerColors);
        //create array adapter

//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_dropdown_item_1line,
//                colorsList
//        );

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(
                this,
                R.layout.custom_spinner_item_layout,
                R.id.textView,
                colorsList
        );
        spinnerColor.setAdapter(adapter);
        spinnerColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(SpinnerActivity.this,
                       ""+colorLists2.get(position).getId(),
                       Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

    }
}
