package com.example.spinnerbeb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    //1) Atributo
    TextView lblTextinho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //2) findViewById()
        lblTextinho = (TextView) findViewById(R.id.lblTextinho);

        //Recebendo o valor da Activity anterior   :D
        Intent it = getIntent();

        lblTextinho.setText(it.getStringExtra("1"));
    }
}