package edu.eigsi.irsi.livewash;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
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
    private ProgressDialog progress;
    private String numMachine;
    private String libre;
    private String occupe;
    private String panne;
    String etatmach1;
    String etatmach2;
    String etatmach3;
    String etatmach4;
    String etatmach5;
    String etatmach6;
    String etatmach7;
    String etatmach8;





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
        libre ="L";
        occupe="O";
        panne="HS";

        //----------Fenêtre de chargement-----------------
        this.progress = new ProgressDialog(this);
        this.progress.setTitle("Veuillez patientez");
        this.progress.setMessage("Récupération du résultat en cours...");
        this.progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        this.progress.show();


        // Appel du service read
        String url;
        this.progress.show();
        url = "http://qcmjava.eigsi.fr/data/read.php";
        WebServicesCallReadLaverie wscr = new WebServicesCallReadLaverie(this, url);
        wscr.read("local");


    }


    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonRetourL:
                Intent ouvrirMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ouvrirMain);
                finish();
                break;

            case R.id.buttonMach1:
                if(etatmach1.equals(panne)){
                    popUp();
                }
                else{
                    numMachine = "1";
                    Intent ouvrirMachine1 = new Intent(getApplicationContext(), Machine.class);
                    ouvrirMachine1.putExtra("numMach", numMachine);
                    startActivity(ouvrirMachine1);
                    finish();
                }
                break;

            case R.id.buttonMach2:
                if(etatmach2.equals(panne)){
                    popUp();
                }
                else {
                    numMachine = "2";
                    Intent ouvrirMachine2 = new Intent(getApplicationContext(), Machine.class);
                    ouvrirMachine2.putExtra("numMach", numMachine);
                    startActivity(ouvrirMachine2);
                    finish();
                }
                break;
            case R.id.buttonMach3:
                if(etatmach3.equals(panne)){
                    popUp();
                }
                else {
                    numMachine = "3";
                    Intent ouvrirMachine3 = new Intent(getApplicationContext(), Machine.class);
                    ouvrirMachine3.putExtra("numMach", numMachine);
                    startActivity(ouvrirMachine3);
                    finish();
                }
                break;

            case R.id.buttonMach4:
                if(etatmach4.equals(panne)){
                    popUp();
                }
                else {
                    numMachine = "4";
                    Intent ouvrirMachine4 = new Intent(getApplicationContext(), Machine.class);
                    ouvrirMachine4.putExtra("numMach", numMachine);
                    startActivity(ouvrirMachine4);
                    finish();
                }
                break;
            case R.id.buttonMach5:
                if(etatmach5.equals(panne)){
                    popUp();
                }
                else {
                    numMachine = "5";
                    Intent ouvrirMachine5 = new Intent(getApplicationContext(), Machine.class);
                    ouvrirMachine5.putExtra("numMach", numMachine);
                    startActivity(ouvrirMachine5);
                    finish();
                }
                break;
            case R.id.buttonMach6:
                if(etatmach6.equals(panne)){
                    popUp();
                }
                else {
                    numMachine = "6";
                    Intent ouvrirMachine6 = new Intent(getApplicationContext(), Machine.class);
                    ouvrirMachine6.putExtra("numMach", numMachine);
                    startActivity(ouvrirMachine6);
                    finish();
                }
                break;
            case R.id.buttonMach7:
                if(etatmach7.equals(panne)){
                    popUp();
                }
                else {
                    numMachine = "7";
                    Intent ouvrirMachine7 = new Intent(getApplicationContext(), Machine.class);
                    ouvrirMachine7.putExtra("numMach", numMachine);
                    startActivity(ouvrirMachine7);
                    finish();
                }
                break;
            case R.id.buttonMach8:
                if(etatmach8.equals(panne)){
                    popUp();
                }
                else {
                    numMachine = "8";
                    Intent ouvrirMachine8 = new Intent(getApplicationContext(), Machine.class);
                    ouvrirMachine8.putExtra("numMach", numMachine);
                    startActivity(ouvrirMachine8);
                    finish();
                }
                break;
        }
    }


    /**
     * Fonction de lecture appelée par l'objet wscr
     * @param reponse les données stockées sur le réseau
     */
    public void populateRead(String reponse) {
        if(this.progress.isShowing())
            this.progress.dismiss();

        //Récupération des données du réseau
        String[] etatmach = reponse.split(",");
        this.etatmach1 = etatmach[0];
        this.etatmach2 = etatmach[1];
        this.etatmach3 = etatmach[2];
        this.etatmach4 = etatmach[3];
        this.etatmach5 = etatmach[4];
        this.etatmach6 = etatmach[5];
        this.etatmach7 = etatmach[6];
        this.etatmach8 = etatmach[7];


        //Changement de couleurs des images en fonction de la réponse du réseau
        //Machine1
        if (libre.equals(etatmach1)) {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach1);
            machine.setImageResource(R.drawable.machineverte);
        }
        if (occupe.equals(etatmach1)) {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach1);
            machine.setImageResource(R.drawable.machinerouge);
        }
        if (panne.equals(etatmach1))  {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach1);
            machine.setImageResource(R.drawable.machinepanne);
        }

        //Machine2
        if (libre.equals(etatmach2)) {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach2);
            machine.setImageResource(R.drawable.machineverte);
        }
        if (occupe.equals(etatmach2)) {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach2);
            machine.setImageResource(R.drawable.machinerouge);
        }
        if (panne.equals(etatmach2))  {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach2);
            machine.setImageResource(R.drawable.machinepanne);
        }

        //Machine3
        if (libre.equals(etatmach3)) {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach3);
            machine.setImageResource(R.drawable.machineverte);
        }
        if (occupe.equals(etatmach3)) {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach3);
            machine.setImageResource(R.drawable.machinerouge);
        }
        if (panne.equals(etatmach3))  {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach3);
            machine.setImageResource(R.drawable.machinepanne);
        }

        //Machine4
        if (libre.equals(etatmach4)) {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach4);
            machine.setImageResource(R.drawable.machineverte);
        }
        if (occupe.equals(etatmach4)) {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach4);
            machine.setImageResource(R.drawable.machinerouge);
        }
        if (panne.equals(etatmach4))  {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach4);
            machine.setImageResource(R.drawable.machinepanne);
        }

        //Machine5
        if (libre.equals(etatmach5)) {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach5);
            machine.setImageResource(R.drawable.machineverte);
        }
        if (occupe.equals(etatmach5)) {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach5);
            machine.setImageResource(R.drawable.machinerouge);
        }
        if (panne.equals(etatmach5))  {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach5);
            machine.setImageResource(R.drawable.machinepanne);
        }

        //Machine6
        if (libre.equals(etatmach6)) {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach6);
            machine.setImageResource(R.drawable.machineverte);
        }
        if (occupe.equals(etatmach6)) {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach6);
            machine.setImageResource(R.drawable.machinerouge);
        }
        if (panne.equals(etatmach6))  {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach6);
            machine.setImageResource(R.drawable.machinepanne);
        }

        //Machine7
        if (libre.equals(etatmach7)) {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach7);
            machine.setImageResource(R.drawable.machineverte);
        }
        if (occupe.equals(etatmach7)) {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach7);
            machine.setImageResource(R.drawable.machinerouge);
        }
        if (panne.equals(etatmach7))  {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach7);
            machine.setImageResource(R.drawable.machinepanne);
        }

        //Machine8
        if (libre.equals(etatmach8)) {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach8);
            machine.setImageResource(R.drawable.machineverte);
        }
        if (occupe.equals(etatmach8)) {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach8);
            machine.setImageResource(R.drawable.machinerouge);
        }
        if (panne.equals(etatmach8))  {
            ImageView machine = (ImageView) findViewById(R.id.buttonMach8);
            machine.setImageResource(R.drawable.machinepanne);
        }


    }

    /**
     * Affiche le message d'erreur
     */
    public void popUp(){
        AlertDialog.Builder myPopUp = new AlertDialog.Builder(this);
        myPopUp.setMessage("Cette machine est actuellement hors service. Notre équipe se mobilise " +
                "afin de la réparer dans les plus brefs délais. Merci de votre compréhension.");
        myPopUp.setTitle("Machine Hors Service");
        myPopUp.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent retourlav = new Intent(getApplicationContext(), Laverie.class);
                startActivity(retourlav);
                finish();
            }
        });
        myPopUp.show();
    }


}