package com.example.ejerciciocalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declaro todos los componentes que voy a utilizar
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnIgual,btnMas,btnMenos,btnMultiplicar,btnDividir;
    private TextView tvResultado;
    private String delimitador;
    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Asocio los componentes con las variables
        btn0 = findViewById(R.id.idBoton0); btn1 = findViewById(R.id.idBoton1);
        btn2 = findViewById(R.id.idBoton2); btn3 = findViewById(R.id.idBoton3);
        btn4 = findViewById(R.id.idBoton4); btn5 = findViewById(R.id.idBoton5);
        btn6 = findViewById(R.id.idBoton6); btn7 = findViewById(R.id.idBoton7);
        btn8 = findViewById(R.id.idBoton8); btn9 = findViewById(R.id.idBoton9);
        btnMas = findViewById(R.id.idBotonMas); btnMenos = findViewById(R.id.idBotonMenos);
        btnMultiplicar = findViewById(R.id.idBotonMultiplicacion); btnDividir = findViewById(R.id.idBotonDivision);
        tvResultado = findViewById(R.id.tvResultado); btnIgual = findViewById(R.id.idBotonIgual);

        // Agrego un listener para cada botón en el que le agreago el numero asociado a cada botón
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText(tvResultado.getText()+"0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText(tvResultado.getText()+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText(tvResultado.getText()+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText(tvResultado.getText()+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText(tvResultado.getText()+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText(tvResultado.getText()+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText(tvResultado.getText()+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText(tvResultado.getText()+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText(tvResultado.getText()+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText(tvResultado.getText()+"9");
            }
        });
        // Al pulsar el boton de una operacion, se agrega al tvResultado el simbolo de la operacion.
        // Además desactivo los botones de las demas operaciones hasta que se pulse le boton =
        // para poder realizar la operación
        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText(tvResultado.getText()+"/");
                delimitador="/";
                btnDividir.setEnabled(false);
                btnMas.setEnabled(false);
                btnMenos.setEnabled(false);
                btnMultiplicar.setEnabled(false);
            }
        });
        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText(tvResultado.getText()+"*");
                delimitador = "\\*";
                btnDividir.setEnabled(false);
                btnMas.setEnabled(false);
                btnMenos.setEnabled(false);
                btnMultiplicar.setEnabled(false);
            }
        });
        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText(tvResultado.getText()+"-");
                delimitador = "-";
                btnDividir.setEnabled(false);
                btnMas.setEnabled(false);
                btnMenos.setEnabled(false);
                btnMultiplicar.setEnabled(false);
            }
        });
        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText(tvResultado.getText()+"+");
                delimitador = "\\+";
                btnDividir.setEnabled(false);
                btnMas.setEnabled(false);
                btnMenos.setEnabled(false);
                btnMultiplicar.setEnabled(false);
            }
        });
        // Utilizado un split con un delimitador para poder separar los dos numeros y conocer cual es el simbolo de la operacion
        // por ultimo vuelvo a activar los botones
        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultado = (String) tvResultado.getText();
                String[] numeros = resultado.split(delimitador);
                switch (delimitador) {
                    case "\\+":
                        result = Integer.parseInt(numeros[0]) + Integer.parseInt(numeros[1]);
                        tvResultado.setText(String.valueOf(result));
                        break;
                    case "-":
                        result = Integer.parseInt(numeros[0]) - Integer.parseInt(numeros[1]);
                        tvResultado.setText(String.valueOf(result));
                        break;
                    case "\\*":
                        result = Integer.parseInt(numeros[0]) * Integer.parseInt(numeros[1]);
                        tvResultado.setText(String.valueOf(result));
                        break;
                    case "/":
                        result = Integer.parseInt(numeros[0]) / Integer.parseInt(numeros[1]);
                        tvResultado.setText(String.valueOf(result));
                        break;
                }
                btnDividir.setEnabled(true);
                btnMas.setEnabled(true);
                btnMenos.setEnabled(true);
                btnMultiplicar.setEnabled(true);
            }
        });
    }
}