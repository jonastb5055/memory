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
    private ImageView img1, img2, img3, img4, img5, img6,img7, img8, imgPrimeiroToque,imgSegundoToque;
    private int imagemPrimeiroToque, imagemSegundoToque, contaToque;
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


        texto = findViewById(R.id.textView1);
        Intent i = new Intent();
        i = getIntent();
        if(i != null){
            //significa que não veio corrompido
            Bundle caixa = new Bundle();
            caixa = i.getExtras();
            if(caixa != null){
                //significa que a caixa não veio corrompido
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
        imgPrimeiroToque = new  ImageView(this);
        imgSegundoToque = new ImageView(this);
        carregaTudo();

    }
    public void carregaTudo(){
        texto.setText(nomeSujeito);
        img1.setBackgroundColor(Color.CYAN);
        img2.setBackgroundColor(Color.CYAN);
        img3.setBackgroundColor(Color.CYAN);
        img4.setBackgroundColor(Color.CYAN);
        img5.setBackgroundColor(Color.CYAN);
        img6.setBackgroundColor(Color.CYAN);
        img7.setBackgroundColor(Color.CYAN);
        img8.setBackgroundColor(Color.CYAN);
        img1.setEnabled(false);
        img2.setEnabled(false);
        img3.setEnabled(false);
        img4.setEnabled(false);
        img5.setEnabled(false);
        img6.setEnabled(false);
        img7.setEnabled(false);
        img8.setEnabled(false);
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
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
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
                img1.setEnabled(true);
                img2.setEnabled(true);
                img3.setEnabled(true);
                img4.setEnabled(true);
                img5.setEnabled(true);
                img6.setEnabled(true);
                img7.setEnabled(true);
                img8.setEnabled(true);

            }
        }, 3000);

        contaToque = 0;
    }
    public void compara(int imagem1, int imagem2){
        contaToque=0;
        if(imagem1 == imagem2){
            imgPrimeiroToque.setEnabled(false);
            imgPrimeiroToque.setBackgroundColor(Color.GREEN);
            imgSegundoToque.setEnabled(false);
            imgSegundoToque.setBackgroundColor(Color.GREEN);
        }else{
            imgPrimeiroToque.setBackgroundColor(Color.RED);
            imgSegundoToque.setBackgroundColor(Color.RED);
            Handler h = new Handler();
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    imgPrimeiroToque.setImageResource(R.drawable.ic_action_name_2);
                    imgSegundoToque.setImageResource(R.drawable.ic_action_name_2);
                    imgPrimeiroToque.setBackgroundColor(Color.CYAN);
                    imgSegundoToque.setBackgroundColor(Color.CYAN);
                }
            }, 2000);
        }
    }
    @Override
    public void onClick(View v) {
        contaToque ++;

        if(v == img1){
            img1.setImageResource(lista.get(0));
            if(contaToque==1){
                imgPrimeiroToque = img1;
                imagemPrimeiroToque = lista.get(0);
            }else{
                imgSegundoToque = img1;
                imagemSegundoToque = lista.get(0);
                compara(imagemPrimeiroToque, imagemSegundoToque);
            }
        }
        if(v == img2){
            img2.setImageResource(lista.get(1));
            if(contaToque==1){
                imgPrimeiroToque = img2;
                imagemPrimeiroToque = lista.get(1);
            }else{
                imgSegundoToque = img2;
                imagemSegundoToque = lista.get(1);
                compara(imagemPrimeiroToque, imagemSegundoToque);
            }
        }
        if(v == img3){
            img3.setImageResource(lista.get(2));
            if(contaToque==1){
                imgPrimeiroToque = img3;
                imagemPrimeiroToque = lista.get(2);
            }else{
                imgSegundoToque = img3;
                imagemSegundoToque = lista.get(2);
                compara(imagemPrimeiroToque, imagemSegundoToque);
            }
        }
        if(v == img4){
            img4.setImageResource(lista.get(3));
            if(contaToque==1){
                imgPrimeiroToque = img4;
                imagemPrimeiroToque = lista.get(3);
            }else{
                imgSegundoToque = img4;
                imagemSegundoToque = lista.get(3);
                compara(imagemPrimeiroToque, imagemSegundoToque);
            }
        }
        if(v == img5){
            img5.setImageResource(lista.get(4));
            if(contaToque==1){
                imgPrimeiroToque = img5;
                imagemPrimeiroToque = lista.get(4);
            }else{
                imgSegundoToque = img5;
                imagemSegundoToque = lista.get(4);
                compara(imagemPrimeiroToque, imagemSegundoToque);
            }
        }
        if(v == img6){
            img6.setImageResource(lista.get(5));
            if(contaToque==1){
                imgPrimeiroToque = img6;
                imagemPrimeiroToque = lista.get(5);
            }else{
                imgSegundoToque = img6;
                imagemSegundoToque = lista.get(5);
                compara(imagemPrimeiroToque, imagemSegundoToque);
            }
        }
        if(v == img7){
            img7.setImageResource(lista.get(6));
            if(contaToque==1){
                imgPrimeiroToque = img7;
                imagemPrimeiroToque = lista.get(6);
            }else{
                imgSegundoToque = img7;
                imagemSegundoToque = lista.get(6);
                compara(imagemPrimeiroToque, imagemSegundoToque);
            }
        }
        if(v == img8){
            img8.setImageResource(lista.get(7));
            if(contaToque==1){
                imgPrimeiroToque = img8;
                imagemPrimeiroToque = lista.get(7);
            }else{
                imgSegundoToque = img8;
                imagemSegundoToque = lista.get(7);
                compara(imagemPrimeiroToque, imagemSegundoToque);
            }
        }
        if(v == btn){
            carregaTudo();
        }
    }
}