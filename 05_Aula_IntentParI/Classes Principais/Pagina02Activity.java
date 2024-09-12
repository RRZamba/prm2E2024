package com.example.projetoshowintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Pagina02Activity extends AppCompatActivity
{
    //1) Atributo
    EditText txtNome, txtSobrenome;
    Button btnCad;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina02);

        //2) 'Linkando' os itens
        txtNome = (EditText) findViewById(R.id.txtName);
        txtSobrenome = (EditText) findViewById(R.id.txtSurname);
        btnCad = (Button) findViewById(R.id.btnCadastrar);

        // 3) Evento do botao
        btnCad.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Recuperando os valores
                String nome = txtNome.getText().toString();
                String sobrenome = txtSobrenome.getText().toString();

                //Classe Intent
                Intent it = new Intent(Pagina02Activity.this,
                                                    Pagina03Activity.class);

                //'Enviar' os dados para outra tela
                it.putExtra("1",nome);
                it.putExtra("2",sobrenome);

                //Chamando a outra tela
                startActivity(it);




            }
        });

    }
}