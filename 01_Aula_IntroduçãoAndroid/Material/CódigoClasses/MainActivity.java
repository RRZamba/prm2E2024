package com.example.appchuchu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    //1) Atributos
    Button btnMostrar;
    TextView lbTitulo;
    EditText txtMens;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2)'iniciando' os elementos!!!
        //o metodo findviewbyid() possibilita o
        //'link' entre o .XML(telinha) e a programação
        // .java
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
        txtMens = (EditText) findViewById(R.id.txtMens);
        lbTitulo = (TextView) findViewById(R.id.lbTitulo);

        //3) Criando o evento do botao mostrar
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Recuperando o valor digitado
                String mens = txtMens.getText().toString();

                //Mostrar o valor digitado
                lbTitulo.setText(mens);
            }
        });
    }//Metodo
}//Classe