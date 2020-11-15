package com.example.manillas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String opciones[];
    private Spinner snpMateriales;
    private Spinner snpDijes;
    private Spinner snpTipos;
    private TextView txtCotizacion;
    private Switch moneda;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        snpMateriales = findViewById(R.id.cmbMaterial);
        opciones = getResources().getStringArray(R.array.materiales);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        snpMateriales.setAdapter(adapter);

        snpDijes = findViewById(R.id.cmbDije);
        opciones = getResources().getStringArray(R.array.dijes);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        snpDijes.setAdapter(adapter);

        snpTipos = findViewById(R.id.cmbTipo);
        opciones = getResources().getStringArray(R.array.tipo);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        snpTipos.setAdapter(adapter);

        txtCotizacion = findViewById(R.id.lblCotizacion);
        moneda = findViewById(R.id.swMoneda);
        moneda.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cotizar();
            }
        });

    }

    public void cotizar(View v) {
       cotizar();
    }

    private void cotizar(){
        int opMaterial = snpMateriales.getSelectedItemPosition();
        int opDijes = snpDijes.getSelectedItemPosition();
        int opTipo = snpTipos.getSelectedItemPosition();
        int val = 0;
        int codigo = opMaterial*100 + opDijes*10 + opTipo;
        switch (codigo){
            case 0:
                val = 100;
                break;
            case 1:
                val = 80;
                break;
            case 2:
                val = 70;
                break;
            case 10:
                val = 120;
                break;
            case 11:
                val = 100;
                break;
            case 12:
                val = 90;
                break;
            case 100:
                val = 90;
                break;
            case 101:
                val = 70;
                break;
            case 102:
                val = 50;
                break;
            case 110:
                val = 110;
                break;
            case 111:
                val = 90;
                break;
            case 112:
                val = 80;
                break;
        }

        if(moneda.isChecked()){
            txtCotizacion.setText(Integer.toString(val*3200));
        }
        else{
            txtCotizacion.setText(Integer.toString(val));
        }
    }
}