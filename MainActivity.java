package com.srinija.numberdetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void findit(View v)
    {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);


        EditText input = (EditText) findViewById(R.id.inputText);
        TextView output = (TextView) findViewById(R.id.outputText);

        inputMethodManager.hideSoftInputFromWindow(input.getWindowToken(),0);

        int number = Integer.parseInt(input.getText().toString());
        int x = 1, triangularNumber = 1;

        int choice = 0;

        while(triangularNumber < number)
        {
            x++;
            triangularNumber = triangularNumber + x;
        }
        if(triangularNumber == number)
            choice = 1;

        Double squareRoot = Math.sqrt(number);
        if(squareRoot == Math.floor(squareRoot))
            if(choice==1)
                 choice = 3;
            else
                choice = 2;

        switch (choice)
        {
            case 0: output.setText("NONE");
                    break;
            case 1: output.setText("TRIANGULAR");
                    break;
            case 2: output.setText("SQUARE");
                    break;
            case 3: output.setText("BOTH: TRIANGULAR, SQUARE");
                    break;
        }
    }

    public void helpNeeded(View view)
    {
        Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
        startActivity(intent);
    }
}