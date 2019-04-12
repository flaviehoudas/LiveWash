package edu.eigsi.irsi.livewash;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class Laverie extends AppCompatActivity implements View.OnClickListener {

    private Button buttonRetour;
    private ImageView buttonMach1;
    private ImageView buttonMach2;
    private ImageView buttonMach3;
    private ImageView buttonMach4;
    private ImageView buttonMach5;
    private ImageView buttonMach6;
    private ImageView buttonMach7;
    private ImageView buttonMach8;
    private int numClick;
    private String numMachine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laverie);

        this.buttonRetour = (Button) findViewById(R.id.buttonRetourL);
        buttonRetour.setOnClickListener(this);
        this.buttonMach1 = (ImageView) findViewById(R.id.buttonMach1);
        buttonMach1.setOnClickListener(this);
        this.buttonMach2 = (ImageView) findViewById(R.id.buttonMach2);
        buttonMach2.setOnClickListener(this);
        this.buttonMach3 = (ImageView) findViewById(R.id.buttonMach3);
        buttonMach3.setOnClickListener(this);
        this.buttonMach4 = (ImageView) findViewById(R.id.buttonMach4);
        buttonMach4.setOnClickListener(this);
        this.buttonMach5 = (ImageView) findViewById(R.id.buttonMach5);
        buttonMach5.setOnClickListener(this);
        this.buttonMach6 = (ImageView) findViewById(R.id.buttonMach6);
        buttonMach6.setOnClickListener(this);
        this.buttonMach7 = (ImageView) findViewById(R.id.buttonMach7);
        buttonMach7.setOnClickListener(this);
        this.buttonMach8 = (ImageView) findViewById(R.id.buttonMach8);
        buttonMach8.setOnClickListener(this);

    }



    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonRetourL:
                Intent ouvrirMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ouvrirMain);
                finish();
                break;


            case R.id.buttonMach1:
                numMachine = "1";
                Intent ouvrirMachine1 = new Intent(getApplicationContext(), Machine.class);
                ouvrirMachine1.putExtra("numMach", numMachine);
                startActivity(ouvrirMachine1);
                finish();
                break;
            case R.id.buttonMach2:
                numMachine = "2";
                Intent ouvrirMachine2 = new Intent(getApplicationContext(), Machine.class);
                ouvrirMachine2.putExtra("numMach", numMachine);
                startActivity(ouvrirMachine2);
                finish();
                break;
            case R.id.buttonMach3:
                numMachine = "3";
                Intent ouvrirMachine3 = new Intent(getApplicationContext(), Machine.class);
                ouvrirMachine3.putExtra("numMach", numMachine);
                startActivity(ouvrirMachine3);
                finish();
                break;
            case R.id.buttonMach4:
                numMachine = "4";
                Intent ouvrirMachine4 = new Intent(getApplicationContext(), Machine.class);
                ouvrirMachine4.putExtra("numMach", numMachine);
                startActivity(ouvrirMachine4);
                finish();
                break;
            case R.id.buttonMach5:
                numMachine = "5";
                Intent ouvrirMachine5 = new Intent(getApplicationContext(), Machine.class);
                ouvrirMachine5.putExtra("numMach", numMachine);
                startActivity(ouvrirMachine5);
                finish();
                break;
            case R.id.buttonMach6:
                numMachine = "6";
                Intent ouvrirMachine6 = new Intent(getApplicationContext(), Machine.class);
                ouvrirMachine6.putExtra("numMach", numMachine);
                startActivity(ouvrirMachine6);
                finish();
                break;
            case R.id.buttonMach7:
                numMachine = "7";
                Intent ouvrirMachine7 = new Intent(getApplicationContext(), Machine.class);
                ouvrirMachine7.putExtra("numMach", numMachine);
                startActivity(ouvrirMachine7);
                finish();
                break;
            case R.id.buttonMach8:
                numMachine = "8";
                Intent ouvrirMachine8 = new Intent(getApplicationContext(), Machine.class);
                ouvrirMachine8.putExtra("numMach", numMachine);
                startActivity(ouvrirMachine8);
                finish();
                break;

        }
    }





}