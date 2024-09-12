package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //1) Atributos
    Button botaozinho;
    EditText caixinhaDeTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) 'Linkar' o layout com a programação
        botaozinho = (Button) findViewById(R.id.btnCadastar);
        caixinhaDeTexto = (EditText) findViewById(R.id.txtNome);

        //3) Criando o evento do botao
        botaozinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Variavel para receber o valor da caixa de texto
                String nome = caixinhaDeTexto.getText().toString();

                //TOAST!!!!!!!!
                Toast.makeText(MainActivity.this,
                                 "Nome:"+nome,
                                 Toast.LENGTH_LONG).show();
            }
        });//BotaoCadastrar

        //4) Evento do botao cadastrar (clique demorado)
        botaozinho.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v) {
                //Limpando a caixa de texto
                caixinhaDeTexto.setText("");

                return false;
            }
        });


    }//Metodo
}//Classe