package com.example.pleiades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tela04 extends AppCompatActivity implements View.OnClickListener {

    private TextView textoNome;
    private String sujeitoNome;
    private int valorContador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela04);

        textoNome = findViewById(R.id.textView4);
        Intent i = new Intent();
        i = getIntent();
        if (i != null) {

            Bundle caixa = new Bundle();
            caixa = i.getExtras();
            if (caixa != null) {

                sujeitoNome = caixa.getString("nome");
                valorContador = caixa.getInt("contador");
                textoNome.setText("Parabéns " + sujeitoNome + " você jogou " + valorContador);
            }
        }
    }

    @Override
    public void onClick(View v) {

    }
}