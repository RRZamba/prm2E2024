package com.example.bancodedados;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //Atributos
    EditText txtNome,txtCurso,txtID;
    Button btnSalvar;
    SQLiteDatabase bcoDadosShow;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Iniciando os itens
        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        //Chamando o método criarDB()
        criarDB();

        //Evento do botão
        btnSalvar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                gravar();
            }
        });
    }//onCreate


    public void atualizar()
    {

    }

    public void selecionarunico()
    {

    }
    public void selecionarTodos()
    {

    }

    public void deletar()
    {

    }



    public void gravar()
    {
        // Elementos
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtCurso = (EditText) findViewById(R.id.txtCurso);

        //Query
        String sql;

        try
        {
            //Query SQL para insert
            sql = "INSERT INTO Alunos(Nome,Curso) VALUES " +
                  "('"+txtNome.getText().toString()+"'," +
                  "'"+txtCurso.getText().toString()+"')";

            //Executando a query
            bcoDadosShow.execSQL(sql);

            // Executando mens de sucesso!!!!
            Toast.makeText(MainActivity.this,
                    "Aluno Cadastrado!!!",
                    Toast.LENGTH_LONG).show();
        }//Try
        catch(Exception erro)
        {
            // Executando mens de sucesso!!!!
            Toast.makeText(MainActivity.this,
                    "Erro!!!" + erro.getMessage(),
                    Toast.LENGTH_LONG).show();
        }


    }


    public void criarDB()
    {
        // 1) /variável para a query
        String sql;

        //2) Tentando criar/abrir o DB
        try
        {
            // 3) Criando a tabela, caso a mesma não exista
            sql = "CREATE TABLE IF NOT EXISTS Aluno(" +
                  "Matricula INTEGER PRIMARY KEY AUTOINCREMENT," +
                  "Nome TEXT," +
                  "Curso TEXT)";

            // 4) Criando ou Abrindo o DB
            bcoDadosShow = openOrCreateDatabase("ETEC",
                                             MODE_PRIVATE,
                                            null);

            // 5) Executando a query
            bcoDadosShow.execSQL(sql);

            // Executando mens de sucesso!!!!
            Toast.makeText(MainActivity.this,
                     "Sistema carregado com sucesso!!!",
                      Toast.LENGTH_LONG).show();
        }//Try
        catch(Exception erro)
        {
            // Executando mens de sucesso!!!!
            Toast.makeText(MainActivity.this,
                    "Erro!!!" + erro.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
    }//criarDB
}