package com.example.firsttask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    EditText etAlamat;
    EditText etPhoneNo;
    EditText etTarikh;

    Button btnNama;

    DatePickerDialog dpdDate;


    public final static String MESSAGE_KEY = "com.example.firsttask.message_key";
    public final static String MESSAGE_ALAMAT = "com.example.firsttask.message_alamat";
    public final static String MESSAGE_PHONE = "com.example.firsttask.message_phone";
    public final static String MESSAGE_DATE = "com.example.firsttask.message_date";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTarikh = (EditText)  findViewById(R.id.etTarikh);
        etTarikh.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int Year = c.get(Calendar.YEAR);
                int Month = c.get(Calendar.MONTH);
                int Day = c.get(Calendar.DAY_OF_MONTH);

                dpdDate = new DatePickerDialog(MainActivity.this,

                    new DatePickerDialog.OnDateSetListener(){

                    @Override
                    public void onDateSet(DatePicker view,
                                          int year,
                                          int month,
                                          int day){

                        etTarikh.setText(day + "/" + month + "/" + year);
                    }

                }, Year, Month, Day);
                dpdDate.show();
            }
        });
    }


    public void sendData(View view){
        etNama = findViewById(R.id.etNama);
        etAlamat = findViewById(R.id.etAlamat);
        etPhoneNo = findViewById(R.id.etPhoneNo);
        etTarikh = findViewById(R.id.etTarikh);

        btnNama = findViewById(R.id.btnNama);

        String messageName = etNama.getText().toString();
        String messageAdd = etAlamat.getText().toString();
        String messagePhone = etPhoneNo.getText().toString();
        String messageDate = etTarikh.getText().toString();


        Intent intent= new Intent(MainActivity.this,SecondActivity.class);

        intent.putExtra(MESSAGE_KEY,messageName);
        intent.putExtra(MESSAGE_ALAMAT,messageAdd);
        intent.putExtra(MESSAGE_PHONE,messagePhone);
        intent.putExtra(MESSAGE_DATE,messageDate);
        startActivity(intent);

    }
}