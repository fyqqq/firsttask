package com.example.firsttask;

import static com.example.firsttask.MainActivity.MESSAGE_ALAMAT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public final static String MESSAGE_KEY = "com.example.firsttask.message_key";
    public final static String MESSAGE_ALAMAT = "com.example.firsttask.message_alamat";
    public final static String MESSAGE_PHONE = "com.example.firsttask.message_phone";
    public final static String MESSAGE_DATE = "com.example.firsttask.message_date";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intentName = getIntent();
        Intent intentAdd = getIntent();
        Intent intentPhone = getIntent();
        Intent intentDate = getIntent();

        String messageName = intentName.getStringExtra(MESSAGE_KEY);
        String messageAdd = intentAdd.getStringExtra(MESSAGE_ALAMAT);
        String messagePhone = intentPhone.getStringExtra(MESSAGE_PHONE);
        String messageDate = intentDate.getStringExtra(MESSAGE_DATE);

        TextView textview = new TextView(this);
        textview.setTextSize(25);
        textview.setText("Name : "+messageName+"\nAddress : "+messageAdd+"\nPhone No : "+messagePhone+"\nDate : "+messageDate);

        setContentView(textview);
    }
}