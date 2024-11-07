package com.example.bancodedadosinternopart1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

    // Atributos
    ListView listinha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        //1) Iniciar os elementos
        listinha = (ListView) findViewById(R.id.lista);

        //2) Array list
        ArrayList<Aluno> listaDoBanco = new ArrayList<Aluno>();

        //3) Iniciano DB
        SQLiteDatabase bcoDados01 = openOrCreateDatabase(
                "ETEC",MODE_PRIVATE,null);

        //4) Criar o cursor para receber os dados da tabela
        Cursor resultado = bcoDados01.rawQuery(
                        "SELECT * FROM Alunos",null);

        //5) Percorrer o cursor e recuperar os dados
        while(resultado.moveToNext())
        {
            Aluno objAluno = new Aluno(resultado.getInt(0),
                                        resultado.getString(1),
                                        resultado.getString(2));

            listaDoBanco.add(objAluno);

        }

        //6) Adaptar o ArrayList
        ArrayAdapter<Aluno> adaptador = new
                ArrayAdapter<Aluno>(ListaActivity.this,
                           android.R.layout.simple_list_item_1,
                           listaDoBanco);

        //7) Inserir a lista adaptada ao listView
        listinha.setAdapter(adaptador);
    }
}