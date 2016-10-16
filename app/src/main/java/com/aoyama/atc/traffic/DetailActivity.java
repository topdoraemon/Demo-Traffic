package com.aoyama.atc.traffic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    //ประกาศตัวแปร
    private TextView titleTextView, detailTextView;
    private ImageView imageView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //bind widget
        titleTextView = (TextView) findViewById(R.id.textViewHead);
        detailTextView = (TextView) findViewById(R.id.textViewDetail);
        imageView = (ImageView) findViewById(R.id.imageViewDetail);
        button = (Button) findViewById(R.id.button_back);

        // Show View
        titleTextView.setText(getIntent().getStringExtra("Title"));
        detailTextView.setText(getIntent().getStringExtra("Detail"));
        imageView.setImageResource(getIntent().getIntExtra("Image",R.drawable.traffic_01));
        //Button Back
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
              //  Intent intent = new Intent(DetailActivity.this, MainActivity.class);
            }
        });
    } //main method

}
