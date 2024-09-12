package com.example.spinnerbeb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    //1) Atributos
    Spinner spinner;
    Button btnTestar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) Iniciando os elementos da tela
        btnTestar = (Button) findViewById(R.id.btnTestar);
        spinner = (Spinner) findViewById(R.id.spinner);

        //3) Criando um arrayList
        /* Funciona 'como' um array porém é
           uma classe, e permite a persistência
           de vários tipos além de conter métodos
           próprios!!!
         */
        ArrayList<String> listaBonita = new ArrayList<String>();

        //4) Inserindo valores no ArrayList<>
        listaBonita.add("Péricles");
        listaBonita.add("Slipknot");
        listaBonita.add("Alanis Morissette");
        listaBonita.add("Ozzy");
        listaBonita.add("Roberto Carlos");

        // 5) Adaptando o ArrayList<> para colocar no layout
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(MainActivity.this,
                                  android.R.layout.simple_list_item_1,
                                  listaBonita);

        // 6) Inserindo a lista já adaptada no layout
        spinner.setAdapter(adaptador);


        //7) Evento do Botão
        btnTestar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Mensagem
                String mens = "Item Selecionado: "
                        + spinner.getSelectedItem();

                //Intent
                Intent it = new Intent(MainActivity.this,
                                              MainActivity2.class);
                it.putExtra("1",mens);

                startActivity(it);

            }
        });
    }
}