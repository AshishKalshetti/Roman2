package com.ashish.roman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    Button btn1,btn2,button;
    TextView output;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.name);
        et2=findViewById(R.id.mobile);
        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);
        output=findViewById(R.id.textView);
        button=findViewById(R.id.b4);

        db = new DatabaseHelper(MainActivity.this,"company",null,1);

        //Save
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pname=et1.getText().toString().trim();
                String mobile=et2.getText().toString().trim();
                long recordid = db.saveNewUserData(pname,mobile); //calling save logic
                if (recordid > 0)
                    Toast.makeText(getApplicationContext(), "Saved Successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Saved Successfully", Toast.LENGTH_SHORT).show();
            }
        });
        //display
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String records = db.getALlRecords();
                output.setText(records);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity3.class));
            }
        });
    }
}