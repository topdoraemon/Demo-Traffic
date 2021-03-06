package com.aoyama.atc.traffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit การประกาศตัวแปร
    private ListView listView;
    private Button button;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        listView = (ListView) findViewById(R.id.LivTraffic);
        button = (Button) findViewById(R.id.button);

        //Button Controller
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Sound Effect
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(),
                        R.raw.dog);
                mediaPlayer.start();
                //show webView
                String url = "https://youtu.be/WF-lZRHrj4M";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
                //เคลื่อนย้ายการทำงาน
            } // Onclick ทำงานเมื่อคลิก
        });

        //ListVie Controller
        //Get Value from class
        MyConstant myConstant = new MyConstant();
        final int[] ints = myConstant.getInts();
        //Get Value Form xml
        final String[] titleStrings = getResources().getStringArray(R.array.title);
        final String[] detailStrings = getResources().getStringArray(R.array.detail);

        //create listview
        TrafficAdapter trafficAdapter = new TrafficAdapter(MainActivity.this,
                titleStrings,detailStrings,ints);
        listView.setAdapter(trafficAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //คลิกที่ Detail Item แล้วให้ไปที่หน้า Detail  พร้อมส่งค่าใสในตัวค่า
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("Title", titleStrings[position]);
                intent.putExtra("Image", ints[position]);
                intent.putExtra("Detail", detailStrings[position]);
                startActivity(intent);


            }
        });

    } //Main Method กลุ่มของคำสั่ง
}  //Main Class นี่คือ Class หลัก
