package com.example.ratul_pc.diu_cse_e57demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDetails extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        tv = findViewById(R.id.showTextId);

        MyDbFunction mf = new MyDbFunction(getApplicationContext());

        String[] data = mf.my_data();
        String s = "";

        for(int i=0; i< data.length;i++){
            s = s + data[i]+"\n\n";
        }
        tv.setText(s);
    }
}
