package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class temperature extends AppCompatActivity {
    TextView result;
    TextInputLayout input;
    RadioButton tc,tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result=findViewById(R.id.textView);
        tc=findViewById(R.id.tc);
        tf=findViewById(R.id.tf);
        input=findViewById(R.id.input);
        setContentView(R.layout.activity_temperature);
    }
    String TfToTc(double tf){
        double a= (5/9) * (tf -32);
        return a+" c";
        // return  "0"+new DecimalFormat("#.0#").format(a)+" c";
    }
    String TcToTf(double tc){
        double a=((9/5) * (tc +32));
        return a+" f";
//        return "0"+new DecimalFormat("#.0#").format(a)+" f";
    }

    public void CalculateTemp(View view) {
        if(tc.isChecked()){
            double number= Double.parseDouble(Objects.requireNonNull(input.getEditText()).getText().toString());
            result.setText(TcToTf(number));
        }
        if (tf.isChecked()){
            double number= Double.parseDouble(Objects.requireNonNull(input.getEditText()).getText().toString());
            result.setText(TfToTc(number));

        }

    }
}