package com.ferreyra.molet.paduli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class SimularPlazoFijo extends AppCompatActivity {
    Button confirmarButton;
    TextView plazoText;
    TextView capitalText;
    TextView interesesText;

    TextView montoTotalText;
    TextView montoTotalAnualText;
    private EditText capital, tasaNominal, tasaEfectiva;
    private TextView textDias;
    private SeekBar seekBarPlazo;
    int mes = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simular_plazo_fijo);
        tasaNominal= (EditText) findViewById(R.id.editTextTasaNominalAnual);
        tasaEfectiva =(EditText) findViewById(R.id.editTextTasaEfectivaAnual);
        capital = (EditText) findViewById(R.id.editTextCapital);
        seekBarPlazo = (SeekBar) findViewById(R.id.seekBar);
        textDias = (TextView) findViewById(R.id.datoSeekBar);

        plazoText = (TextView) findViewById(R.id.plazoDato);
        capitalText = (TextView) findViewById(R.id.capitalDato);
        interesesText = (TextView) findViewById(R.id.interesesDatos);
        montoTotalText = (TextView) findViewById(R.id.montoDatos);
        montoTotalAnualText = (TextView) findViewById(R.id.montoAnualDatos);
        confirmarButton = (Button)findViewById(R.id.confirmarButton);
        confirmarButton.setOnClickListener(this::onClick);

        seekBarPlazo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mes = i;
                calcular(i);

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });



        tasaNominal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        tasaEfectiva.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void afterTextChanged(Editable editable) {
                calcular(mes);
            }
        });
        capital.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calcular(mes);
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void calcular(int dias) {
        double tasaEfectivaValue = 0;
        double tasaEfectivaMensualValue = 0;
        double interesGanado = 0;
        double capitalValue = 0;
        double interesGanadoAnual = 0;
        double montoTotal = 0;
        double montoTotalAnual = 0;
        double tasaNominalValue = 0;
        double tasaNominalMensualValue = 0;
        textDias.setText(String.valueOf(dias*30)+ " dias");
        plazoText.setText(textDias.getText());
        if(capital.getText().toString().length() > 0 && tasaEfectiva.getText().toString().length() > 0
                && tasaNominal.getText().toString().length() > 0) {
            capitalText.setText(capital.getText());
            tasaEfectivaValue = Double.valueOf(tasaEfectiva.getText().toString());
            tasaNominalValue =Double.valueOf(tasaNominal.getText().toString());
            tasaNominalMensualValue = (tasaNominalValue/100) / 12;
            tasaEfectivaMensualValue = (tasaEfectivaValue/100) / 12;
            capitalValue = Double.valueOf(capital.getText().toString());
            interesGanado = capitalValue * (tasaNominalMensualValue)*dias;
            interesGanadoAnual = capitalValue* (tasaNominalMensualValue)*12;
            montoTotal = capitalValue + interesGanado;
            montoTotalAnual = capitalValue + interesGanadoAnual;



            interesesText.setText(""+interesGanado);
            montoTotalText.setText(""+montoTotal);
            montoTotalAnualText.setText(""+montoTotalAnual);
        }
    }


    public void onClick(View v){
        if(capital.getText().toString().length() > 0 && tasaEfectiva.getText().toString().length() > 0
                && tasaNominal.getText().toString().length() > 0) {

        }
    }
}