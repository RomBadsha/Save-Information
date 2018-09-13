package com.example.ratul_pc.diu_cse_e57demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mName, mPhone;
    Button saveButton, showButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = findViewById(R.id.nameEditTextId);
        mPhone = findViewById(R.id.phoneEditTextId);

        saveButton = findViewById(R.id.saveButtonId);
        showButton = findViewById(R.id.showButtonId);

        final MyDbFunction mf =new MyDbFunction(getApplication());

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name =mName.getText().toString();
                String phone =mPhone.getText().toString();

                DataTemp dt = new DataTemp(name,phone);
                mf.addingDataToTable(dt);

                Toast.makeText(getApplicationContext(),"Data added successfully", Toast.LENGTH_SHORT).show();
            }
        });
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShowDetails.class));
            }
        });
    }
}
