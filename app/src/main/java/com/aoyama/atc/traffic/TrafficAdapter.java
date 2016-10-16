package com.aoyama.atc.traffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 16/10/2559.
 */

public class TrafficAdapter extends BaseAdapter{

    // ประกาศตัวแปร
    private Context context; //ท่อที่ใช้ส่งข้อมูล
    private String[] titleStrings, detilStrings;
    private int[] ints;
    // ประกาศตัวแปรเพื่อเก็บค่า เพื่อเรียกมาแสดง
    private TextView titleTextView, detailTextView;
    private ImageView imageView;


    //Contructer
    public TrafficAdapter(Context context, String[] titleStrings, String[] detilStrings, int[] ints) {
        this.context = context;
        this.titleStrings = titleStrings;
        this.detilStrings = detilStrings;
        this.ints = ints;

    }

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //สร้าง Layout เสมือน
        //เรียกใช้ Service เราต้องการใช้ Server ของ  Layout เสมือน
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.traffic_listview, parent, false);
         // Bind WIdget
        titleTextView = (TextView) view.findViewById(R.id.textView2);
        detailTextView = (TextView) view.findViewById(R.id.textView3);
        imageView = (ImageView) view.findViewById(R.id.imageView);

        titleTextView.setText(titleStrings[position]);

        //การตัดคำ
        if(detilStrings[position].length()<=30){
            detailTextView.setText(detilStrings[position]);

        }else{
            // มากกว่า 30 ตัวอักษร
            detailTextView.setText(detilStrings[position].substring(0,30)+"...");
        }
        // change Image
        imageView.setImageResource(ints[position]);

        return  view;
    }
} // Main Class
