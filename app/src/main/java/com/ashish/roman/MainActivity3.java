package com.ashish.roman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        lv =findViewById(R.id.lv);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch(position){
                    case 0:
                        startActivity(new Intent(MainActivity3.this, MainActivity2.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity3.this, MainActivity4.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity3.this, MainActivity.class));
                        break;

                }
            }
        });
    }
}