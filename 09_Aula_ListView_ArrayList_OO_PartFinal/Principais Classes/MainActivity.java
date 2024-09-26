package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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
        }); //

        //Evento da Lista
        listinha.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int posicao, long l)
            {
                /*
                     O Parâmetro 'int posicao' do método acima 'onItemClick'
                     retorna qual a posição do item que o usuário clicou
                     (ex. 1,2,0), com esse parâmetro é possível recuperar
                     o valor referente da listview
                        Ex.:
                           'lista.get(posicao)'
                     Porém, se quisermos apenas um campo da minha classe
                     usuário (nome,cargo,cpf,enderego) completamos o comando
                     acima com os métodos get/set da própria classe Usuario.
                        Ex.:
                           'lista.get(posicao).getNome;'
                    O exemplo acima irá nos trazer apenas o campo nome
                    de uma determinada linha da minha lista.



                 */


                //Variável para receber os campos
                String nome = lista.get(posicao).getNome();
                String endereco = lista.get(posicao).getEndereco();
                String cargo = lista.get(posicao).getCargo();
                String cpf = lista.get(posicao).getCpf();

                //Mostrar
                Toast.makeText(MainActivity.this,
                                "User: "+ nome + "\n"
                                    + endereco + "\n" + cargo
                                    + cpf,
                                      Toast.LENGTH_LONG).show();
            }
        });//
    }//
}//