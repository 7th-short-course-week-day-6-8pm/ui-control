package com.rathana.ui_control;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.TextView;

import com.rathana.ui_control.utils.TimePicker;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class AutoCompleteTextActivity extends AppCompatActivity
    implements DatePickerDialog.OnDateSetListener,
        TimePicker.OnTimeSetPicker

{

    TextView tvDate, tvTime;
    AutoCompleteTextView textView;
    List<String> completions=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text);

        textView=findViewById(R.id.autoComplete);
        tvDate=findViewById(R.id.tvDate);
        tvTime=findViewById(R.id.tvTime);

        completions.add("book");
        completions.add("pen");
        completions.add("ball");
        completions.add("cat");
        completions.add("apple");

        //create adapter
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                completions
        );

        textView.setAdapter(adapter);
        textView.getText().toString();
    }


    ///create methods for button click

    public  void onPickDate(View v){
        createDatePicker().show();
    }

    public  void onPickTime(View v){
        new TimePicker().show(getSupportFragmentManager(),"time picker");
    }

    private DatePickerDialog createDatePicker(){
        Calendar calendar=Calendar.getInstance();
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        int month=calendar.get(Calendar.MONTH);
        int yy=calendar.get(Calendar.YEAR);
        return  new DatePickerDialog(this,this,yy,month,day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        String mm= month+1 <10 ? "0"+(month+1)  : (month+1)+"";

        String day =dayOfMonth <10 ? "0"+dayOfMonth : ""+dayOfMonth;

        tvDate.setText(day+"/"+mm+"/"+year);
    }

    @Override
    public void onTimeSet(int h, int mn) {
        tvTime.setText(h+":"+mn);
    }
}
