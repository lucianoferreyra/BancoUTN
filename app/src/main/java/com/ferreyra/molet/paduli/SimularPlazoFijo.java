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
    TextView plazoText,capitalText,interesesText,montoTotalText,montoTotalAnualText;
    private EditText capital, tasaNominal, tasaEfectiva;
    private TextView textDias;
    private SeekBar seekBarPlazo;


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
                textDias.setText(String.valueOf(i*30)+ " dias");
                plazoText.setText(textDias.getText());
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

            }
        });
        capital.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                capitalText.setText(capital.getText());
            }
        });
    }



    public void onClick(View v){
       // plazoText.setText(R.id.);

    }
}