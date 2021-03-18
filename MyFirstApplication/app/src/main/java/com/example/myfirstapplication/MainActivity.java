package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;


public class MainActivity extends AppCompatActivity implements OnItemSelectedListener{

    Button button1, button2, button3;
    TextView textView2, textView3, textView4;
    EditText enterBox;
    Spinner spinner;

    String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1); //米 转换按钮
        button2 = findViewById(R.id.button2); //温度 转换按钮
        button3 = findViewById(R.id.button3); //重量 转换按钮
        textView2 = findViewById(R.id.textView2); //标签2
        textView3 = findViewById(R.id.textView3); //标签3
        textView4 = findViewById(R.id.textView4); //标签4
        enterBox = findViewById(R.id.enterBox); //输入框
        spinner = findViewById(R.id.spinner); //下拉框
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unit, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        enterBox.setText("");
        textView2.setText("");
        textView3.setText("");
        textView4.setText("");
        text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();




    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    //距离 转换按钮
    public void meterClick (View view){
        try {
            if(Objects.equals(text, "Meter")) {
                //-CM
                double result1 = Double.parseDouble(enterBox.getText().toString()) * 100;
                BigDecimal n1 = new BigDecimal(result1);
                textView2.setText((n1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()) + " CM");
                //-FOOT
                double result2 = Double.parseDouble(enterBox.getText().toString()) * 3.28;
                BigDecimal n2 = new BigDecimal(result2);
                textView3.setText((n2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()) + " Foot");
                //-INCH
                double result3 = Double.parseDouble(enterBox.getText().toString()) * 39.37;
                BigDecimal n3 = new BigDecimal(result3);
                textView4.setText((n3.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()) + " Inch");
            }
            Toast.makeText(MainActivity.this, "Please select the correct conversion button" , Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    //温度 转换按钮
    public void celsiusClick(View v) {
        try {
            if(Objects.equals(text, "Celsius")) {
                //-FA
                double result1 = Double.parseDouble(enterBox.getText().toString()) * 9 / 5 + 32;
                BigDecimal n1 = new BigDecimal(result1);
                textView2.setText((n1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()) + " Fahrenheit");
                //-KELVIN
                double result2 = Double.parseDouble(enterBox.getText().toString()) + 273.15;
                BigDecimal n2 = new BigDecimal(result2);
                textView3.setText((n2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()) + " Kelvin");
                //NONE
                textView4.setText("");
            }
            Toast.makeText(MainActivity.this, "Please select the correct conversion button" , Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    //重量 转换按钮
    public void kilogramClick(View v) {

        try {
            if (Objects.equals(text, "Kilogram")) {
                //-GRAM
                double result1 = Double.parseDouble(enterBox.getText().toString()) * 1000;
                BigDecimal n1 = new BigDecimal(result1);
                textView2.setText((n1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()) + " Gram");
                //-OUNCE
                double result2 = Double.parseDouble(enterBox.getText().toString()) * 35.274;
                BigDecimal n2 = new BigDecimal(result2);
                textView3.setText((n2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()) + " Ounce(Oz)");
                //-POUND
                double result3 = Double.parseDouble(enterBox.getText().toString()) * 2.205;
                BigDecimal n3 = new BigDecimal(result3);
                textView4.setText((n3.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()) + " Pound(lb)");

                Toast.makeText(MainActivity.this, "Hello " + enterBox.getText().toString(), Toast.LENGTH_LONG).show();
            }
            Toast.makeText(MainActivity.this, "Please select the correct conversion button" , Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}