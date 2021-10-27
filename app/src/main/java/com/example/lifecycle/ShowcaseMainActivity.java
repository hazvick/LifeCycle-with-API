package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowcaseMainActivity extends AppCompatActivity {

    private TextView display_option_one, display_option_two, display_option_three, display_option_four, display_option_five;

    TextView kanyeQuotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showcase_main);

        kanyeQuotes = findViewById(R.id.kanyQuotes);

        //Retrofit Builder
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Interface Instance
        MyAPICAll myAPICAll = retrofit.create(MyAPICAll.class);

        Call<DataModel> call = myAPICAll.getData();

        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {

                //Check Response OK
                if (response.code() != 200) {
                    kanyeQuotes.setText("Failed response.");
                    return;
                }

                String jsony = "";
                jsony = "API Response = " + response.body().getQuote();
                kanyeQuotes.append(jsony);

            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {

            }
        });


        Intent intent = getIntent();
        String textOne = intent.getStringExtra(InputMainActivity.finalOne);
        String textTwo = intent.getStringExtra(InputMainActivity.finalTwo);
        String textThree = intent.getStringExtra(InputMainActivity.finalThree);
        String textFour = intent.getStringExtra(InputMainActivity.finalFour);
        String textFive = intent.getStringExtra(InputMainActivity.finalFive);

        TextView displayOne = (TextView) findViewById(R.id.display_option_one);
        TextView displayTwo = (TextView) findViewById(R.id.display_option_two);
        TextView displayThree = (TextView) findViewById(R.id.display_option_three);
        TextView displayFour = (TextView) findViewById(R.id.display_option_four);
        TextView displayFive = (TextView) findViewById(R.id.display_option_five);
        Button displayButton = (Button) findViewById(R.id.display_button_back);

        displayOne.setText(textOne);
        displayTwo.setText(textTwo);
        displayThree.setText(textThree);
        displayFour.setText(textFour);
        displayFive.setText(textFive);

        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToInput();
            }
        });

    }

    public void backToInput() {
        Intent intent = new Intent(this, InputMainActivity.class);
        startActivity(intent);
    }
}