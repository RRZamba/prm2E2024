package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //1) Atributos
    Button btnAntes,btnDepois;
    ImageView fotinhas;
    String nomefoto = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) Iniciando os elementos
        btnAntes = (Button) findViewById(R.id.btnEsquerda);
        btnDepois = (Button) findViewById(R.id.btnDireita);
        fotinhas = (ImageView) findViewById(R.id.img);




        //3) Evento do botao
        btnAntes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nomefoto == "")
                {
                    fotinhas.setImageResource(R.drawable.vandamme);
                    nomefoto = "vandamme";
                }
                else if(nomefoto == "vandamme")
                {
                    fotinhas.setImageResource(R.drawable.rambo);
                    nomefoto = "rambo";
                }
                else if(nomefoto == "rambo")
                {
                    fotinhas.setImageResource(R.drawable.cobra);
                    nomefoto = "cobra";
                }
                else if(nomefoto == "cobra")
                {
                    fotinhas.setImageResource(R.drawable.ic_launcher_foreground);
                    nomefoto = "";
                }



            }
        });


        //4) Evento Botao 2
        btnDepois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fotinhas.setImageResource(R.drawable.rambo);
            }
        });

        // 5) Evento ImageView
        fotinhas.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                fotinhas.setImageResource(R.drawable.cobra);
                return false;
            }
        });
    }
}