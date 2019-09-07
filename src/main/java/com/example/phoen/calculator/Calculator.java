package com.example.phoen.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.Stack;

public class Calculator extends AppCompatActivity {
    int value =0;
    String btn_num;
    public String current="0";
    String[] equation = new String[16];
    int index=0;
    Stack st= new Stack();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }


    public void clear(View view){
        final TextView textview = findViewById(R.id.textView);
        current = "0";
        textview.setText(current);
        while(!st.empty()){
            st.pop();
        }
        for(int i = 0; i<16;i++){
            equation[i]=null;
        }
        index = 0;
    }

    public void add(View view){
        final TextView textview = findViewById(R.id.textView);
        if (current !="0"){
            current = current + "+";
            textview.setText(current);

            equation[index]=equation[index].substring(4);
            Log.d("add",equation[index]);

            equation[index+1]="add";
            index = index +2;
        }
    }

    public void minus(View view){
        final TextView textview = findViewById(R.id.textView);
        if (current !="0"){
            current = current + "-";
            textview.setText(current);

            equation[index]=equation[index].substring(4); //initial string has "null"

            equation[index+1]="minus";
            index = index +2;
        }
    }

    public void one(View view){
        btn_num="1";
        //Log.d("tag",current.length()+"hi");
        final TextView textview = findViewById(R.id.textView);
        if (current == "0"){
            //Log.d("fag","56");
            current = btn_num;

            textview.setText(btn_num);
        } else {
            current = current + btn_num;
            textview.setText(current);
        }
        equation[index]=equation[index]+btn_num;

    }

    public void two(View view){
        final TextView textview = findViewById(R.id.textView);
        if (current == "0"){
            current = "2";
            value = 2;
            textview.setText("2");
        } else {
            current = current + "2";
            textview.setText(current);
        }
        equation[index]=equation[index]+"2";;

    }
    public void three(View view){
        final TextView textview = findViewById(R.id.textView);
        if (current == "0"){
            current = "3";
            textview.setText("3");
        } else {
            current = current + "3";
            textview.setText(current);
        }
        equation[index]=equation[index]+"3";;
    }

    public void four(View view){
        btn_num="4";
        //Log.d("tag",current.length()+"hi");
        final TextView textview = findViewById(R.id.textView);
        if (current == "0"){
            //Log.d("fag","56");
            current = btn_num;

            textview.setText(btn_num);
        } else {
            current = current + btn_num;
            textview.setText(current);
        }
        equation[index]=equation[index]+btn_num;

    }
    public void five(View view){
        btn_num="5";
        //Log.d("tag",current.length()+"hi");
        final TextView textview = findViewById(R.id.textView);
        if (current == "0"){
            //Log.d("fag","56");
            current = btn_num;

            textview.setText(btn_num);
        } else {
            current = current + btn_num;
            textview.setText(current);
        }
        equation[index]=equation[index]+btn_num;
    }
    public void six(View view){
        btn_num="6";
        //Log.d("tag",current.length()+"hi");
        final TextView textview = findViewById(R.id.textView);
        if (current == "0"){
            //Log.d("fag","56");
            current = btn_num;

            textview.setText(btn_num);
        } else {
            current = current + btn_num;
            textview.setText(current);
        }
        equation[index]=equation[index]+btn_num;

    }
    public void seven(View view){
        btn_num="7";
        //Log.d("tag",current.length()+"hi");
        final TextView textview = findViewById(R.id.textView);
        if (current == "0"){
            //Log.d("fag","56");
            current = btn_num;

            textview.setText(btn_num);
        } else {
            current = current + btn_num;
            textview.setText(current);
        }
        equation[index]=equation[index]+btn_num;

    }
    public void eight(View view){
        btn_num="8";
        //Log.d("tag",current.length()+"hi");
        final TextView textview = findViewById(R.id.textView);
        if (current == "0"){
            //Log.d("fag","56");
            current = btn_num;

            textview.setText(btn_num);
        } else {
            current = current + btn_num;
            textview.setText(current);
        }
        equation[index]=equation[index]+btn_num;

    }
    public void nine(View view){
        btn_num="9";
        //Log.d("tag",current.length()+"hi");
        final TextView textview = findViewById(R.id.textView);
        if (current != "0"){
            //Log.d("fag","56");
            current = btn_num;

            textview.setText(btn_num);
        } else {
            current = current + btn_num;
            textview.setText(current);
        }
        equation[index]=equation[index]+btn_num;
    }
    public void zero(View view){
        btn_num="0";
        final TextView textview = findViewById(R.id.textView);
        if (current != "0"){
            current = current + btn_num;
            textview.setText(current);
        }
        equation[index]=equation[index]+btn_num;
    }

    public void decimal(View view){ //decimal has less conditions
        btn_num=".";
        final TextView textview = findViewById(R.id.textView);
        current = current+btn_num;
        textview.setText(current);
        equation[index]=equation[index]+btn_num;
    }


    public void equals(View view){
        final TextView textview = findViewById(R.id.textView);
        if(equation[0]==null){ //clicking clear with nothing so far
            for(int i = 0; i<16;i++){
                equation[i]=null;
            }
            index=0;
        }else {
            if (equation[1] == "add") {

                equation[index]=equation[index].substring(4);
                value = Integer.parseInt(equation[index-2])+Integer.valueOf(equation[index]);
                //convert string variables to int

            }else{ //is minus
                equation[index]=equation[index].substring(4);
                value = Integer.parseInt(equation[index-2])-Integer.valueOf(equation[index]);

            }

            textview.setText(value + "");
        }
        for(int i = 0; i<16;i++){  //clearing all records and keeping answer to current
            equation[i]=null;
        }
        equation[0]=value+"";
        index = 1;
    }
}