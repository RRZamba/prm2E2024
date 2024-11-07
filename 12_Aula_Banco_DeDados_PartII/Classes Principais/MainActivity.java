package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //1) Atributos
    EditText txtNome,txtCurso, txtId;
    Button btnSalvar,btnAtualizar, btnDeletar,btnSelecionar;
    //Classe SQLiteDatabase -> Responsável por todas as
    //Operações do DB
    SQLiteDatabase dbShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2) Iniciar elementos
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnAtualizar = (Button) findViewById(R.id.btnAtualizar);
        btnDeletar = (Button) findViewById(R.id.btnDeletar);
        btnSelecionar = (Button) findViewById(R.id.btnSelecionar);

        //3) Chamando o método para abrir o DB
        CriarAbrirDB();

        //Evento do Botao Salvar
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chamando o método Gravar()
                Gravar();
            }
        });


        //Botão Selecionar
        btnSelecionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Botão Deletar
        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Botão Atualizar
        btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Atualizar();
            }
        });
    }//OnCreate

    public void CriarAbrirDB()
    {
        //1) Criando variável para receber a query
        String sql;

        //2) Tentando Criar/Abrir o DB
        try
        {
            // 3) Criando a tabela, caso a mesma não exista
            sql = "CREATE TABLE IF NOT EXISTS Alunos(" +
                    "Matricula INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "Nome TEXT," +
                    "Curso TEXT)";

            //4) Criando/Abrindo DB
            dbShow = openOrCreateDatabase("ETEC",
                                         MODE_PRIVATE,
                                          null);

            //5) Executando a query
            dbShow.execSQL(sql);

            //6) Mostrando mens. de sucesso!!!
            Toast.makeText(MainActivity.this,
                         "Sistema Carregado com Sucesso!",
                        Toast.LENGTH_LONG).show();
        }
        catch(Exception erro)
        {
            //Se ocorrer um erro... Mens. de erro!
            Toast.makeText(MainActivity.this,
                    "Erro ao Carregar o sistema: "
                            + erro.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
    }//CriarAbrirDB

    public void Gravar()
    {
        //Iniciando os elementos -  caixas de texto
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtCurso = (EditText) findViewById(R.id.txtCurso);

        //Variavel para query sql
        String sql;

        try
        {
            //Criando a query
            sql = "INSERT INTO Alunos(Nome,Curso)VALUES('"
                    +txtNome.getText().toString()+"','"
                    +txtCurso.getText().toString()+"')";

            //Executando a query
            dbShow.execSQL(sql);

            //Mens. de sucesso
            Toast.makeText(MainActivity.this,
                    "Aluno inserido com sucesso!",
                    Toast.LENGTH_LONG).show();

        }
        catch(Exception erro)
        {
            //Se ocorrer um erro... Mens. de erro!
            Toast.makeText(MainActivity.this,
                    "Erro ao inserir Aluno: "
                            + erro.getMessage(),
                    Toast.LENGTH_LONG).show();
        }



    }//Gravar

    public void Atualizar()
    {
        //Valores da Caixinha
        txtId = (EditText) findViewById(R.id.txtId);
        txtCurso = (EditText) findViewById(R.id.txtCurso);
        txtNome = (EditText) findViewById(R.id.txtNome);

        //Var. para receber a Query!!!
        String sql;

        try{
            //Montanto a query de update
            sql = "UPDATE Alunos SET " +
                    "NOME='"+txtNome.getText().toString()+"', " +
                    "Curso = '"+txtCurso.getText().toString()+"' " +
                    "WHERE Matricula = "+txtId.getText().toString();

            //Executando a query
            dbShow.execSQL(sql);

            //Mens.
            Toast.makeText(MainActivity.this,
                            "Inserido com sucesso!",
                            Toast.LENGTH_LONG).show();

            //Limpando os campos
            txtId.setText("");
            txtNome.setText("");
            txtCurso.setText("");
        }
        catch(Exception erro)
        {
            //Mens. de Erro
            Toast.makeText(MainActivity.this,
                            "Erro:" + erro.getMessage(),
                          Toast.LENGTH_LONG).show();
        }




    }

    public void Selecionar()
    {
        //Iniciando elemento da tela
        txtId = (EditText) findViewById(R.id.txtId);

        //Var. para query
        String sql;
        try {
            //Montando Query de Select
            sql = "SELECT * FROM Alunos WHERE Matricula ="+
                   txtId.getText().toString();

            //Criando  um cursor para armazenar os dados
            //durante a execução do método!!!
            Cursor objCursor;

            //Executando a query e salvando os dados no cursor
            objCursor = dbShow.rawQuery(sql,null);

            /*
                "Exemplificando" o cursor

            |--  | Matricula(0) |  Nome(1)    |  Curso(2)  |
            |0   |  1           |  João       |  ADM       |
            |1   |  2           |  Dorivaldo  |  Ballet    |
            |2   |  3           |  Bruna      |  DES       |
            |3   |  4           |  Camila     |  Química   |
             */

            //Chamando a classe Aluno
            Aluno objAluno = new Aluno();

            //Criando o List<>
            ArrayList<Aluno> objLista = new ArrayList<Aluno>();

            //Percorrendo o cursor
            while(objCursor.moveToNext()) //Enquanto houver linha...
            {
                //'Monto' o Aluno
                objAluno.setMatricula(objCursor.getInt(0));
                objAluno.setNome(objCursor.getString(1));
                objAluno.setCurso(objCursor.getString(2));

                //Inserindo Aluno 'Pronto' no ArrayList<>
                objLista.add(objAluno);
            }

            //Var. de Teste
            String mens = "Mat.: " + objLista.get(0).getMatricula()+
                          "Nome: " + objLista.get(0).getNome()+
                          "Curso:" + objLista.get(0).getCurso();

            Toast.makeText(MainActivity.this,
                            mens,
                            Toast.LENGTH_LONG).show();


        }
        catch(Exception erro)
        {
            //Mens. de erro
            Toast.makeText(MainActivity.this,
                            "Erro: " + erro.getMessage(),
                            Toast.LENGTH_LONG).show();
        }


    }



}//MainActivity