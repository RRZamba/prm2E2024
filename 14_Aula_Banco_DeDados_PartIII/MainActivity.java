package com.example.bancodedadosinternopart1;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //Atributos
    Button btSalvar,btSelecionar,btSelecionarTodos;
    EditText txNome,txCurso;

    //SQLiteDatabase => classe para manipulacao do DB interno
    SQLiteDatabase bcoDados01;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1) Criando ou abrindo o BD
        CriarBanco();

        // 2) Iniciando os  botoes
        btSalvar = (Button) findViewById(R.id.btSave);
        btSelecionar = (Button) findViewById(R.id.btSelect);
        btSelecionarTodos = (Button) findViewById(R.id.btSelecionarTodos);



        // 2.1) Evento Botao Salvar
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gravar();
            }
        });

        // 2.2) Evento Botal Selecionar
        btSelecionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelecionarUnico();
            }
        });

        // 2.3 Selecionar Todos
        btSelecionarTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIt = new Intent(MainActivity.this,
                                    ListaActivity.class);
                startActivity(objIt);
            }
        });


    }//OnCreate()



    public void SelecionarUnico()
    {
        // 1) Iniciando elementos da tela
        txNome = (EditText) findViewById(R.id.nomeIn);

        // 2) Montando a Query
        String sql = "SELECT * FROM Alunos WHERE Nome='"+
                        txNome.getText().toString()+"'";

        try
        {
            // 3) Criando um Cursor para armazenar os dados durante a execucao
            Cursor objCursor;

            // 5) Executo a query e salvo os valores no cursor
            objCursor = bcoDados01.rawQuery(sql,null);

            // 6) Criando aluno e seu arraylist
            Aluno objAluno = new Aluno();
            ArrayList<Aluno> listaLog = new ArrayList<Aluno>();

            // 7)percorrendo o cursor
            while(objCursor.moveToNext())
            {
                objAluno.setMatricula(objCursor.getInt(0));
                objAluno.setNome(objCursor.getString(1));
                objAluno.setCurso(objCursor.getString(2));

                //Salvando dentro da lista
                listaLog.add(objAluno);
            }

            // 8) Mostrar os valores
            Toast.makeText(this,
                          "Nome:"+listaLog.get(0).getNome()+
                                " Curso:"+listaLog.get(0).getCurso(),
                                Toast.LENGTH_LONG).show();

        }
        catch (Exception erro)
        {
            //Mensagem de erro
            Toast.makeText(this,
                    "Erro ao Selecionar Aluno!"+
                            erro.getMessage(),
                    Toast.LENGTH_LONG).show();
        }

    }



    //Met. para inserir valores no DB
    public void Gravar()
    {
        // 1) Iniciar os elementos editText
        txNome = (EditText) findViewById(R.id.nomeIn);
        txCurso = (EditText) findViewById(R.id.cursoIn);

        // 2) Criando Query de INSERT
        String sql = "INSERT INTO Alunos(Nome,Curso) VALUES " +
                     "('"+txNome.getText().toString() +"'," +
                      "'"+txCurso.getText().toString()+"')";

        // 3) Verificando se houve erro no insert
        try
        {
            // 4) Executando a query
            bcoDados01.execSQL(sql);

            // 5) Mensagem de sucesso
            Toast.makeText(this,
                           "Usuario inserido com sucesso!",
                          Toast.LENGTH_LONG).show();

            // 6) Apagando os textos do EditText
            txNome.setText("");
            txCurso.setText("");
        }
        catch (Exception erro)
        {
            //Mensagem de erro
            Toast.makeText(this,
                    "Erro ao inserir aluno - ERRO: "+
                          erro.getMessage(),
                          Toast.LENGTH_LONG).show();
        }
    }//Gravar()


    //Met. para criacao do DB
    public void CriarBanco()
    {
        // 1) Criando ou abrindo o BD
        bcoDados01 = openOrCreateDatabase("ETEC",MODE_PRIVATE,null);

        // 2) Query para montar a primeira tabela
        String sql = "CREATE TABLE IF NOT EXISTS Alunos(" +
                     "Matricula INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "Nome TEXT," +
                     "Curso TEXT)";

        // 3) Tratando o erro, caso tenha problemas na criacao do BD ou na query
        try {

            // 4) Executando a query de criacao
            bcoDados01.execSQL(sql);

            // 5) Mensagem para o user
            Toast.makeText(this,
                    "Sistema carregado com sucesso!!!",
                    Toast.LENGTH_LONG).show();

        }catch(Exception erro){
            // 6) Mens. caso ocorra erro
            Toast.makeText(this,
                     "Erro ao abrir ou criar o DB",
                    Toast.LENGTH_LONG).show();
        }
    }//CriarBanco()

}