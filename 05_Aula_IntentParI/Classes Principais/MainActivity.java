package com.example.projetoshowintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    // 1) Atributos
    Button bntPagina1,bntPagina2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2) 'Linkando' o tela com a programção
        bntPagina1 = (Button) findViewById(R.id.btnPG01);
        bntPagina2 = (Button) findViewById(R.id.btnPG02);

        // 3) Evento do btn01
        bntPagina1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                /*    INTENT!!!!
                   Classe responsável pela manipulação
                   de activities... Permitindo uma espécie
                   de 'ligação' entre elas, além da passagem
                   de parâmetros!!!
                 */

                // Instanciando a classe Intent
                Intent it = new Intent(MainActivity.this,
                                         Pagina01Activity.class);
                //'Chamando' a outra activity
                startActivity(it);

            }
        });

        bntPagina2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Instanciando a classe Intent
                Intent it = new Intent(MainActivity.this,
                                               Pagina02Activity.class);
                //'Chamando' a outra activity
                startActivity(it);

            }
        });
    }
}