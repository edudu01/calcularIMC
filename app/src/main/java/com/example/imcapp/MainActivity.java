package com.example.imcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText recebePeso;
    private EditText recebeAltura;
    private TextView exibeResultado;
    private Button calc;
    private ToggleButton selectGenero;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recebePeso = findViewById(R.id.editTextPesoId);
        recebeAltura = findViewById(R.id.editTextAlturaId);
        //exibeResultado = findViewById(R.id.textView);
        calc = findViewById(R.id.btnCalcId);
        selectGenero = findViewById(R.id.toggleButton3);


        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (recebePeso.getText().toString().trim().equals("") ||
                        recebeAltura.getText().toString().trim().equals("")){

                    Toast.makeText(MainActivity.this, "Preencha todos os campos!",
                            Toast.LENGTH_LONG).show();
                } else {

                    double peso = Double.parseDouble(recebePeso.getText().toString());
                    double altura = Double.parseDouble(recebeAltura.getText().toString());
                    double resultCalc = peso / ((altura / 100) * (altura / 100));

                    String situacao = "";

                    if(selectGenero.getText().toString().equals("Mulher")) {
                        if (resultCalc < 19) {
                            situacao = "Abaixo do peso";
                        } else if (resultCalc > 19 && resultCalc <= 25.8) {
                            situacao = "Peso normal";
                        } else if (resultCalc > 25.8 && resultCalc <= 27.3) {
                            situacao = "Pouco acima do peso";
                        } else if (resultCalc > 27.3 && resultCalc <= 31) {
                            situacao = "Acima do peso";
                        } else if (resultCalc > 31) {
                            situacao = "Obesidade";
                        }
                    } else {
                        if (resultCalc < 20.7) {
                            situacao = "Abaixo do peso";
                        } else if (resultCalc > 20.7 && resultCalc <= 26.4) {
                            situacao = "Peso normal";
                        } else if (resultCalc > 26.4 && resultCalc <= 27.3) {
                            situacao = "Pouco acima do peso";
                        } else if (resultCalc > 27.3 && resultCalc <= 31.2) {
                            situacao = "Pouco acima do peso";
                        } else if (resultCalc > 31.2) {
                            situacao = "Obesidade";
                        }
                    }
          //          exibeResultado.setText("IMC: " + String.valueOf(String.format("%.2f",resultCalc)) + " " + situacao);
                    String res = "IMC: " + String.valueOf(String.format("%.2f",resultCalc)) + " " + situacao;

                    Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
                    intent.putExtra("resultado", res);
                    startActivity(intent);


//                    InputMethodManager imm = (InputMethodManager) getSystemService(MainActivity.INPUT_METHOD_SERVICE);
//                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                }
            }
        });

    }

}
