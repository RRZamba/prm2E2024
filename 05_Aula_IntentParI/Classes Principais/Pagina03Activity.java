package com.example.projetoshowintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Pagina03Activity extends AppCompatActivity
{
    // 1) Atributo
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina03);

        // 2) Linkando os itens
        resultado = (TextView) findViewById(R.id.resultado);

        // 3) Classe Intent
        Intent it = getIntent();

        //4) Recuperando valor e colocando direto na mens.
        String texto = "Nome: " + it.getStringExtra("1")
                     + "\n Sobrenome: "+it.getStringExtra("2")
                     + "\n Você é um otário!";

        // 5) Mostrando a mensagem
        resultado.setText(texto);
    }
}