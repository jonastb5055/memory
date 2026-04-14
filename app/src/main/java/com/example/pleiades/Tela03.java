package com.example.pleiades;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class Tela03 extends AppCompatActivity implements View.OnClickListener {
    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, imgPrimeiroToque, imgSegundoToque;
    private int imagemPrimeiroToque, imagemSegundoToque, contaToque, quantasJogadas;
    private TextView texto;
    private ArrayList<Integer> lista;
    private Button btn, btn2;
    private String nomeSujeito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela03);
        btn = findViewById(R.id.button4);
        btn.setOnClickListener(this);
        btn2 = findViewById(R.id.button5);
        btn2.setOnClickListener(this);
        quantasJogadas = 1;

        texto = findViewById(R.id.textView1);
        Intent i = getIntent();
        if (i != null) {
            Bundle caixa = i.getExtras();
            if (caixa != null) {
                nomeSujeito = caixa.getString("nome");
            }
        }

        img1 = findViewById(R.id.imageView2);
        img2 = findViewById(R.id.imageView3);
        img3 = findViewById(R.id.imageView4);
        img4 = findViewById(R.id.imageView5);
        img5 = findViewById(R.id.imageView6);
        img6 = findViewById(R.id.imageView7);
        img7 = findViewById(R.id.imageView8);
        img8 = findViewById(R.id.imageView9);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        img6.setOnClickListener(this);
        img7.setOnClickListener(this);
        img8.setOnClickListener(this);

        imgPrimeiroToque = new ImageView(this);
        imgSegundoToque = new ImageView(this);
        carregaTudo();
    }

    public void carregaTudo() {
        texto.setText(nomeSujeito);
        setImagensHabilitadas(false); // Desabilita durante o tempo de memorização

        img1.setBackgroundColor(Color.WHITE);
        img2.setBackgroundColor(Color.WHITE);
        img3.setBackgroundColor(Color.WHITE);
        img4.setBackgroundColor(Color.WHITE);
        img5.setBackgroundColor(Color.WHITE);
        img6.setBackgroundColor(Color.WHITE);
        img7.setBackgroundColor(Color.WHITE);
        img8.setBackgroundColor(Color.WHITE);

        lista = new ArrayList<Integer>();
        lista.add(R.drawable.ic_action_name_3);
        lista.add(R.drawable.ic_action_name_3);
        lista.add(R.drawable.ic_action_name_4);
        lista.add(R.drawable.ic_action_name_4);
        lista.add(R.drawable.ic_action_name_5);
        lista.add(R.drawable.ic_action_name_5);
        lista.add(R.drawable.ic_action_name_6);
        lista.add(R.drawable.ic_action_name_6);
        Collections.shuffle(lista);

        img1.setImageResource(lista.get(0));
        img2.setImageResource(lista.get(1));
        img3.setImageResource(lista.get(2));
        img4.setImageResource(lista.get(3));
        img5.setImageResource(lista.get(4));
        img6.setImageResource(lista.get(5));
        img7.setImageResource(lista.get(6));
        img8.setImageResource(lista.get(7));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                img1.setImageResource(R.drawable.ic_action_name_2);
                img2.setImageResource(R.drawable.ic_action_name_2);
                img3.setImageResource(R.drawable.ic_action_name_2);
                img4.setImageResource(R.drawable.ic_action_name_2);
                img5.setImageResource(R.drawable.ic_action_name_2);
                img6.setImageResource(R.drawable.ic_action_name_2);
                img7.setImageResource(R.drawable.ic_action_name_2);
                img8.setImageResource(R.drawable.ic_action_name_2);
                setImagensHabilitadas(true); // Habilita para começar o jogo
            }
        }, 3000);

        contaToque = 0;
    }


    private void setImagensHabilitadas(boolean estado) {
        img1.setEnabled(estado); img2.setEnabled(estado);
        img3.setEnabled(estado); img4.setEnabled(estado);
        img5.setEnabled(estado); img6.setEnabled(estado);
        img7.setEnabled(estado); img8.setEnabled(estado);
    }

    public void compara(int imagem1, int imagem2) {
        contaToque = 0;

        if (imagem1 == imagem2) {

            imgPrimeiroToque.setEnabled(false);
            imgPrimeiroToque.setBackgroundColor(Color.GREEN);
            imgSegundoToque.setEnabled(false);
            imgSegundoToque.setBackgroundColor(Color.GREEN);
            imgPrimeiroToque = null;
            setImagensHabilitadas(true);
        } else {

            imgPrimeiroToque.setBackgroundColor(Color.RED);
            imgSegundoToque.setBackgroundColor(Color.RED);
            setImagensHabilitadas(false);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    imgPrimeiroToque.setImageResource(R.drawable.ic_action_name_2);
                    imgSegundoToque.setImageResource(R.drawable.ic_action_name_2);
                    imgPrimeiroToque.setBackgroundColor(Color.WHITE);
                    imgSegundoToque.setBackgroundColor(Color.WHITE);
                    imgPrimeiroToque = null; // Limpa a referência
                    setImagensHabilitadas(true);
                }
            }, 2000);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btn) {
            carregaTudo();
            quantasJogadas++;
            return;
        }
        if (v == btn2) {
            Intent i = new Intent(this, Tela04.class);
            Bundle caixa = new Bundle();
            caixa.putString("nome", nomeSujeito);
            caixa.putInt("contador", quantasJogadas);
            i.putExtras(caixa);
            startActivity(i);
            return;
        }


        if (contaToque == 1 && v == imgPrimeiroToque) {
            return;
        }

        contaToque++;

        if (v == img1) {
            img1.setImageResource(lista.get(0));
            if (contaToque == 1) { imgPrimeiroToque = img1; imagemPrimeiroToque = lista.get(0); }
            else { imgSegundoToque = img1; imagemSegundoToque = lista.get(0); compara(imagemPrimeiroToque, imagemSegundoToque); }
        } else if (v == img2) {
            img2.setImageResource(lista.get(1));
            if (contaToque == 1) { imgPrimeiroToque = img2; imagemPrimeiroToque = lista.get(1); }
            else { imgSegundoToque = img2; imagemSegundoToque = lista.get(1); compara(imagemPrimeiroToque, imagemSegundoToque); }
        } else if (v == img3) {
            img3.setImageResource(lista.get(2));
            if (contaToque == 1) { imgPrimeiroToque = img3; imagemPrimeiroToque = lista.get(2); }
            else { imgSegundoToque = img3; imagemSegundoToque = lista.get(2); compara(imagemPrimeiroToque, imagemSegundoToque); }
        } else if (v == img4) {
            img4.setImageResource(lista.get(3));
            if (contaToque == 1) { imgPrimeiroToque = img4; imagemPrimeiroToque = lista.get(3); }
            else { imgSegundoToque = img4; imagemSegundoToque = lista.get(3); compara(imagemPrimeiroToque, imagemSegundoToque); }
        } else if (v == img5) {
            img5.setImageResource(lista.get(4));
            if (contaToque == 1) { imgPrimeiroToque = img5; imagemPrimeiroToque = lista.get(4); }
            else { imgSegundoToque = img5; imagemSegundoToque = lista.get(4); compara(imagemPrimeiroToque, imagemSegundoToque); }
        } else if (v == img6) {
            img6.setImageResource(lista.get(5));
            if (contaToque == 1) { imgPrimeiroToque = img6; imagemPrimeiroToque = lista.get(5); }
            else { imgSegundoToque = img6; imagemSegundoToque = lista.get(5); compara(imagemPrimeiroToque, imagemSegundoToque); }
        } else if (v == img7) {
            img7.setImageResource(lista.get(6));
            if (contaToque == 1) { imgPrimeiroToque = img7; imagemPrimeiroToque = lista.get(6); }
            else { imgSegundoToque = img7; imagemSegundoToque = lista.get(6); compara(imagemPrimeiroToque, imagemSegundoToque); }
        } else if (v == img8) {
            img8.setImageResource(lista.get(7));
            if (contaToque == 1) { imgPrimeiroToque = img8; imagemPrimeiroToque = lista.get(7); }
            else { imgSegundoToque = img8; imagemSegundoToque = lista.get(7); compara(imagemPrimeiroToque, imagemSegundoToque); }
        }
    }
}