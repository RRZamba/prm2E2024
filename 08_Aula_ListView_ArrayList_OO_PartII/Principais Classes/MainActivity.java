package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Atributos
    Button btnCad;
    EditText txtNome, txtCargo, txtCpf, txtEnd;
    ListView listinha;

    // Criando um ArrayList<> de Usuario!!!
    ArrayList<Usuario> lista = new ArrayList<Usuario>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2) Iniciando
        btnCad = (Button) findViewById(R.id.btnCad);
        txtEnd = (EditText) findViewById(R.id.txtEnd);
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtCargo = (EditText) findViewById(R.id.txtCargo);
        txtCpf = (EditText) findViewById(R.id.txtCpf);
        listinha = (ListView) findViewById(R.id.listinha);

        // 3) Evento do Botão
       btnCad.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View view)
           {
               //Recuperar os valores do EditText
               String nominho = txtNome.getText().toString();
               String enderecinho = txtEnd.getText().toString();
               String cpfzinho = txtCpf.getText().toString();
               String carguinho = txtCargo.getText().toString();

               //Instanciando a Classe Usuario
               Usuario user = new Usuario(nominho,enderecinho,
                                          cpfzinho,carguinho);

               /*   Exemplo ArrayList<Usuario>
                     | NOME    | End  |   CPF   | Cargo    |
                    0| Douglas | Mauá |  456465 | Gerente  |
                    1| Cida    | SBC  |  545455 | Caixa    |
                    2| Bruno   | Mauá |  878789 | Atendente|
                */


               //Adiciono o objeto user na lista
               lista.add(user);

               // Adaptando a lista para o layout
               ArrayAdapter<Usuario> adapter =
                       new ArrayAdapter<Usuario>(MainActivity.this,
                                         android.R.layout.simple_list_item_1,
                                         lista);

                // Inserindo a lista adaptada no layout
               listinha.setAdapter(adapter);

               //Limpando os campos
               txtCargo.setText("");
               txtCpf.setText("");
               txtEnd.setText("");
               txtNome.setText("");
           }
       });
    }
}