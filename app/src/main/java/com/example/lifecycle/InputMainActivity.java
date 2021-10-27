package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputMainActivity extends AppCompatActivity {

    public static final String finalOne = "finalOne";
    public static final String finalTwo = "finalTwo";
    public static final String finalThree = "finalThree";
    public static final String finalFour = "finalFour";
    public static final String finalFive = "finalFive";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_main);

        Button button = (Button) findViewById(R.id.input_Button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity();
            };
        });

    }

    public void nextActivity() {

        EditText ioOne = (EditText) findViewById(R.id.input_option_one);
        EditText ioTwo = (EditText) findViewById(R.id.input_option_two);
        EditText ioThree = (EditText) findViewById(R.id.input_option_three);
        EditText ioFour = (EditText) findViewById(R.id.input_option_four);
        EditText ioFive = (EditText) findViewById(R.id.input_option_five);

        String textOne = ioOne.getText().toString();
        String textTwo = ioTwo.getText().toString();
        String textThree = ioThree.getText().toString();
        String textFour = ioFour.getText().toString();
        String textFive = ioFive.getText().toString();


        Intent intent = new Intent(this, ShowcaseMainActivity.class);
        intent.putExtra(finalOne, textOne);
        intent.putExtra(finalTwo, textTwo);
        intent.putExtra(finalThree, textThree);
        intent.putExtra(finalFour, textFour);
        intent.putExtra(finalFive, textFive);
        startActivity(intent);
    }
}