package com.example.appwithneo4j;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button btn_register;
    private EditText txt_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_register = findViewById(R.id.register);
        txt_name = findViewById(R.id.name);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PersonModel person;

                person = new PersonModel(-1, txt_name.getText().toString());
                DataBaseHelper dataBaseHelper= new DataBaseHelper();
                boolean success = dataBaseHelper.AddPerson(person);
                Toast.makeText(MainActivity.this,"success="+success,Toast.LENGTH_SHORT).show();

            }
        });
    }



}
