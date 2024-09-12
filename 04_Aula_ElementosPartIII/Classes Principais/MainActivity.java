package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 1)  Atributos
    EditText txtFunc, txtCargo, txtSalario;
    TextView lblValor;
    SeekBar barraAumento;
    Switch swAumento;
    Button btnTestar;

    //Atributo para recuperar valor da SeekBar
    double valor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) Iniciando os elementos
        txtSalario = (EditText) findViewById(R.id.txtSalario);
        txtFunc = (EditText) findViewById(R.id.txtFunc);
        txtCargo = (EditText) findViewById(R.id.txtCargo);
        barraAumento = (SeekBar) findViewById(R.id.barraAumento);
        swAumento = (Switch) findViewById(R.id.swAumento);
        lblValor = (TextView) findViewById(R.id.lblValor);
        btnTestar = (Button) findViewById(R.id.btnTestar);

        // 3) Configurando a seekBar para ficar inativa
        barraAumento.setEnabled(false);

        // 4) Evento do Switch
        swAumento.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
               barraAumento.setEnabled(true);
            }
        });//


        // 5) Evento da barrinha
        barraAumento.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progresso, boolean b)
            {
                valor = progresso;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                lblValor.setText(valor+"%");
            }
        });//



        // 6) Evento da btnTestar
        btnTestar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Recuperando os valores
                String nome = txtFunc.getText().toString();
                String cargo = txtCargo.getText().toString();
                double salario =  Double.parseDouble(txtSalario.getText().toString());


                // Fazendo a continha
                double novoSalario = salario + (salario * (valor/100));

                //Mostrando o novo valor
                String mensagem = "Nome: "+nome+ "\n" +
                                  "Cargo: " +cargo+ "\n" +
                                  "Sal. Anterior: " +salario+ "\n" +
                                  "Novo Sal. " +novoSalario+ "\n";

                //Toast
                Toast.makeText(MainActivity.this,
                                mensagem,
                               Toast.LENGTH_LONG).show();

            }
        });//
    }//
}//