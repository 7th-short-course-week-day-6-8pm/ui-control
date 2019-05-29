package com.rathana.ui_control;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener {

    TextView textView;

    Button btnLogin;

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this,"Login button clicked",
                    Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        btnLogin=findViewById(R.id.btnLogin);

        textView.setTextColor(Color.RED);
        textView.setText("change text when app run");

        textView.setOnClickListener(v->{
                Toast.makeText(this, "click on textView",
                        Toast.LENGTH_SHORT).show();
        });

        //btnLogin.setOnClickListener(listener);
//
//        btnLogin.setOnClickListener(v -> {
//            Toast.makeText(this, "Register onclick with lambda expression",
//                    Toast.LENGTH_SHORT).show();
//        });

        btnLogin.setOnClickListener(this);
    }

    public void onButtonLabelClicked(View v){
        Toast.makeText(this, textView.getText().toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, ((Button) v).getText().toString(),
                Toast.LENGTH_SHORT).show();
    }
}
