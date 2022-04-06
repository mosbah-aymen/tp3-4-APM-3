package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
TextView result;
    TextInputLayout input;
RadioButton euro,dinar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result=findViewById(R.id.textView);
        euro=findViewById(R.id.euro);
        dinar=findViewById(R.id.dinar);
        input=findViewById(R.id.input);
    }

    public  String euroToDA(double euro){
        return "0"+new DecimalFormat("#.0#").format(euro*215)+" DA";
    }
    public  String daToEuro(double da){
        return "0"+ new DecimalFormat("#.0#").format(da/215) +" €";
    }

    public void convert(View view) {
        if(euro.isChecked()){
            double number= Double.valueOf(input.getEditText().getText().toString());
            result.setText(euroToDA(number));
        }
        if (dinar.isChecked()){
            double number= Double.valueOf(input.getEditText().getText().toString());
            result.setText(daToEuro(number));

        }
    }

    public void NavToTemperature(View view) {
        Intent intent = new Intent(this, temperature.class);
        String message = euroToDA(110);
        intent.putExtra("ddd", message);        startActivity(intent);

    }
}