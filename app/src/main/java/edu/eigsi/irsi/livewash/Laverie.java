package edu.eigsi.irsi.livewash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Laverie extends AppCompatActivity {

    private Button buttonRetour;
    private ImageView buttonMach1;
    private ImageView buttonMach2;
    private ImageView buttonMach3;
    private ImageView buttonMach4;
    private ImageView buttonMach5;
    private ImageView buttonMach6;
    private ImageView buttonMach7;
    private ImageView buttonMach8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laverie);

        this.buttonRetour = (Button) findViewById(R.id.buttonRetour);
        this.buttonMach1 = (ImageView) findViewById(R.id.buttonMach1);
        this.buttonMach2 = (ImageView) findViewById(R.id.buttonMach2);
        this.buttonMach3 = (ImageView) findViewById(R.id.buttonMach3);
        this.buttonMach4 = (ImageView) findViewById(R.id.buttonMach4);
        this.buttonMach5 = (ImageView) findViewById(R.id.buttonMach5);
        this.buttonMach6 = (ImageView) findViewById(R.id.buttonMach6);
        this.buttonMach7 = (ImageView) findViewById(R.id.buttonMach7);
        this.buttonMach8 = (ImageView) findViewById(R.id.buttonMach8);



        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RetourMenu = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(RetourMenu);
                finish();
            }
        });

        buttonMach1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ouvrirMach1 = new Intent(getApplicationContext(), Machine1.class);
                startActivity(ouvrirMach1);
                finish();
            }
        });

        buttonMach2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ouvrirMach2 = new Intent(getApplicationContext(), Machine2.class);
                startActivity(ouvrirMach2);
                finish();
            }
        });

        buttonMach3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ouvrirMach3 = new Intent(getApplicationContext(), Machine3.class);
                startActivity(ouvrirMach3);
                finish();
            }
        });

        buttonMach4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ouvrirMach4 = new Intent(getApplicationContext(), Machine4.class);
                startActivity(ouvrirMach4);
                finish();
            }
        });

        buttonMach5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ouvrirMach5 = new Intent(getApplicationContext(), Machine5.class);
                startActivity(ouvrirMach5);
                finish();
            }
        });

        buttonMach6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ouvrirMach6 = new Intent(getApplicationContext(), Machine6.class);
                startActivity(ouvrirMach6);
                finish();
            }
        });

        buttonMach7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ouvrirMach7 = new Intent(getApplicationContext(), Machine7.class);
                startActivity(ouvrirMach7);
                finish();
            }
        });

        buttonMach8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ouvrirMach8 = new Intent(getApplicationContext(), Machine8.class);
                startActivity(ouvrirMach8);
                finish();
            }
        });





    }



}
