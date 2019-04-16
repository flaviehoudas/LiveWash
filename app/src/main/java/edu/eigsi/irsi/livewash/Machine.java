package edu.eigsi.irsi.livewash;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Machine extends AppCompatActivity {

    private Button buttonRetour;
    private Button buttonLancer;
    private ProgressDialog progress;
    private Switch buttonVider;
    private TextView heureDebut , heureFin;
    private Button buttonSignaler;
    private TextView nomMachine;
    private String numeroMach;
    Boolean click1;
    Boolean click2;
    Boolean click3;
    Boolean click4;
    Boolean click5;
    Boolean click6;
    Boolean click7;
    Boolean click8;


    Date dateIni = new Date();
    SimpleDateFormat sdfIni = new SimpleDateFormat("HH:mm");
    String timeIni = sdfIni.format(dateIni);
    Date dateToAdd = new Date(5400*1000);
    Date dateFinal = new Date(dateIni.getTime() + dateToAdd.getTime());
    SimpleDateFormat sdfFinal = new SimpleDateFormat("HH:mm");
    String timeFinal = sdfFinal.format(dateFinal);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine);

        this.buttonRetour = (Button) findViewById(R.id.buttonRetourM);
        this.buttonLancer = (Button) findViewById(R.id.buttonLancer);
        this.buttonVider = (Switch) findViewById(R.id.buttonVider);
        this.buttonSignaler = (Button) findViewById(R.id.buttonSignaler) ;
        this.heureDebut=  (TextView) findViewById(R.id.heureDebut);
        this.heureFin = (TextView)  findViewById(R.id.heureFin);
        this.nomMachine = (TextView)  findViewById(R.id.nomMachine);
        numeroMach = getNumMach();

        //---------------Fenêtre de chargement--------
        this.progress = new ProgressDialog(this);
        this.progress.setTitle("Veuillez patientez");
        this.progress.setMessage("Récupération du résultat en cours...");
        this.progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);


        //-----Enregistrer les états des boutons en utilisant SharedPrefereces---------
        final SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        click1 = sp.getBoolean("BUTTON1",false);
        click2 = sp.getBoolean("BUTTON2",false);
        click3 = sp.getBoolean("BUTTON3",false);
        click4 = sp.getBoolean("BUTTON4",false);
        click5 = sp.getBoolean("BUTTON5",false);
        click6 = sp.getBoolean("BUTTON6",false);
        click7 = sp.getBoolean("BUTTON7",false);
        click8 = sp.getBoolean("BUTTON8",false);
        buttonSwapping();



        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour = new Intent(getApplicationContext(), Laverie.class);
                startActivity(retour);
                finish();
            }
        });

        buttonLancer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                swapMachine();
                //----Mets à jour le bouton cliqué dans SharedPreferences
                //Machine1
                if(numeroMach.equals("1")) {
                    click1 = true;
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putBoolean("BUTTON1", click1);
                    edit.apply();
                    buttonSwapping();
                }
                //Machine2
                if(numeroMach.equals("2")) {
                    click2 = true;
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putBoolean("BUTTON2", click2);
                    edit.apply();
                    buttonSwapping();
                }
                //Machine3
                if(numeroMach.equals("3")) {
                    click3 = true;
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putBoolean("BUTTON3", click3);
                    edit.apply();
                    buttonSwapping();
                }
                //Machine4
                if(numeroMach.equals("4")) {
                    click4 = true;
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putBoolean("BUTTON4", click4);
                    edit.apply();
                    buttonSwapping();
                }
                //Machine5
                if(numeroMach.equals("5")) {
                    click5 = true;
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putBoolean("BUTTON5", click5);
                    edit.apply();
                    buttonSwapping();
                }
                //Machine6
                if(numeroMach.equals("6")) {
                    click6 = true;
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putBoolean("BUTTON6", click6);
                    edit.apply();
                    buttonSwapping();
                }
                //Machine7
                if(numeroMach.equals("7")) {
                    click7 = true;
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putBoolean("BUTTON7", click7);
                    edit.apply();
                    buttonSwapping();
                }
                //Machine8
                if(numeroMach.equals("8")) {
                    click8 = true;
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putBoolean("BUTTON8", click8);
                    edit.apply();
                    buttonSwapping();
                }
            }
        });

        buttonVider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonVider.isChecked()){
                    swapMachine();
                    //Machine1
                    if(numeroMach.equals("1")) {
                        click1 = false;
                        SharedPreferences.Editor edit = sp.edit();
                        edit.putBoolean("BUTTON1", click1);
                        edit.apply();
                        buttonSwapping();
                    }
                    //Machine2
                    if(numeroMach.equals("2")) {
                        click2 = false;
                        SharedPreferences.Editor edit = sp.edit();
                        edit.putBoolean("BUTTON2", click2);
                        edit.apply();
                        buttonSwapping();
                    }
                    //Machine3
                    if(numeroMach.equals("3")) {
                        click3 = false;
                        SharedPreferences.Editor edit = sp.edit();
                        edit.putBoolean("BUTTON3", click3);
                        edit.apply();
                        buttonSwapping();
                    }
                    //Machine4
                    if(numeroMach.equals("4")) {
                        click4 = false;
                        SharedPreferences.Editor edit = sp.edit();
                        edit.putBoolean("BUTTON4", click4);
                        edit.apply();
                        buttonSwapping();
                    }
                    //Machine5
                    if(numeroMach.equals("5")) {
                        click5 = false;
                        SharedPreferences.Editor edit = sp.edit();
                        edit.putBoolean("BUTTON5", click5);
                        edit.apply();
                        buttonSwapping();
                    }
                    //Machine6
                    if(numeroMach.equals("6")) {
                        click6 = false;
                        SharedPreferences.Editor edit = sp.edit();
                        edit.putBoolean("BUTTON6", click6);
                        edit.apply();
                        buttonSwapping();
                    }
                    //Machine7
                    if(numeroMach.equals("7")) {
                        click7 = false;
                        SharedPreferences.Editor edit = sp.edit();
                        edit.putBoolean("BUTTON7", click7);
                        edit.apply();
                        buttonSwapping();
                    }
                    //Machine8
                    if(numeroMach.equals("8")) {
                        click8 = false;
                        SharedPreferences.Editor edit = sp.edit();
                        edit.putBoolean("BUTTON8", click8);
                        edit.apply();
                        buttonSwapping();
                    }
                }
            }
        });

        buttonSignaler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signaler = new Intent(getApplicationContext() , Signaler.class);
                signaler.putExtra("numMach", numeroMach);
                startActivity(signaler);
                finish();
            }
        });

    }

    /**
     * Appel du sercice permettant de lire les données du réseau
     */
    public void swapMachine(){
        String url;
        this.progress.show();
        url = "http://qcmjava.eigsi.fr/data/read.php";
        WebServicesCallRead wscr = new WebServicesCallRead(this, url);
        wscr.read("local");
    }


    /**
     * Fonction de lecture appelée par l'objet wscr
     * @param reponse les données stockées sur le réseau
     */
    public void populateRead(String reponse) {
        if (this.progress.isShowing())
            this.progress.dismiss();

        //Récupération des données du réseau
        String[] etatmach = reponse.split(",");
        String etatmach1 = etatmach[0];
        String etatmach2 = etatmach[1];
        String etatmach3 = etatmach[2];
        String etatmach4 = etatmach[3];
        String etatmach5 = etatmach[4];
        String etatmach6 = etatmach[5];
        String etatmach7 = etatmach[6];
        String etatmach8 = etatmach[7];

        String url;
        // url du service write
        url = "http://qcmjava.eigsi.fr/data/write.php";
        // Instanciation du Web Service
        WebServicesCallWrite wscw = new WebServicesCallWrite(this, url);

        //-----Déclare la machine choisie comme étant occupée
        if (!buttonVider.isChecked()){
            //Machine1
            if (numeroMach.equals("1")) {
                wscw.write("local", "O," + etatmach2 + "," + etatmach3 + "," +
                        etatmach4 + "," + etatmach5 + "," + etatmach6 + "," + etatmach7
                        + "," + etatmach8);
            }
            //Machine2
            if (numeroMach.equals("2")) {
                wscw.write("local", etatmach1 + ",O" + "," + etatmach3 + ","
                        + etatmach4 + "," + etatmach5 + "," + etatmach6 + "," + etatmach7 + "," +
                        etatmach8);
            }
            //Machine3
            if (numeroMach.equals("3")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + ",O," + etatmach4
                        + "," + etatmach5 + "," + etatmach6 + "," + etatmach7 + "," + etatmach8);
            }
            //Machine4
            if (numeroMach.equals("4")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3 +
                        ",O," + etatmach5 + "," + etatmach6 + "," + etatmach7 +  "," + etatmach8);
            }
            //Machine5
            if (numeroMach.equals("5")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3
                        + "," + etatmach4 + ",O," + etatmach6 + "," + etatmach7 +  "," + etatmach8);
            }
            //Machine6
            if (numeroMach.equals("6")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3 + ","
                        + etatmach4  + "," + etatmach5 + ",O," + etatmach7 + "," + etatmach8);
            }
            //Machine7
            if (numeroMach.equals("7")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3 + ","
                        + etatmach4  + "," + etatmach5 + "," + etatmach6 + ",O," + etatmach8);
            }
            //Machine8
            if (numeroMach.equals("8")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3 + ","
                        + etatmach4  + "," + etatmach5 + "," + etatmach6 + "," + etatmach7 + ",O");
            }
        }

        //-----Déclare la machine choisie comme étant libre
        if (buttonVider.isChecked()){
            // Machine1
            if (numeroMach.equals("1")) {
                wscw.write("local", "L," + etatmach2 + "," + etatmach3 + "," +
                        etatmach4 + "," + etatmach5 + "," + etatmach6 + "," + etatmach7
                        + "," + etatmach8);
            }
            // Machine2
            if (numeroMach.equals("2")) {
                wscw.write("local", etatmach1 + ",L," + etatmach3 + "," + etatmach4
                        + "," + etatmach5 + "," + etatmach6 + "," + etatmach7 + "," + etatmach8);
            }
            // Machine3
            if (numeroMach.equals("3")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + ",L," + etatmach4
                        + "," + etatmach5 + "," + etatmach6 + "," + etatmach7 + "," + etatmach8);
            }
            // Machine4
            if (numeroMach.equals("4")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3
                        + ",L," + etatmach5 + "," + etatmach6 + "," + etatmach7 + "," + etatmach8);
            }
            // Machine5
            if (numeroMach.equals("5")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3
                        + "," + etatmach4 + ",L," + etatmach6 + "," + etatmach7 + "," + etatmach8);
            }
            // Machine6
            if (numeroMach.equals("6")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3
                        + "," + etatmach4 + "," + etatmach5 + ",L," + etatmach7 + "," + etatmach8);
            }
            // Machine7
            if (numeroMach.equals("7")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3
                        + "," + etatmach4 + "," + etatmach5 + "," + etatmach6 + ",L," + etatmach8);
            }
            // Machine8
            if (numeroMach.equals("8")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3
                        + "," + etatmach4 + "," + etatmach5 + "," + etatmach6 + ","
                        + etatmach7 + ",L");
            }
            buttonVider.setChecked(false);
        }

    }

    /**
     *  Fonction écriture appelée par l'objet wscw
     * @param reponse les données stockées sur le réseau
     */
    public void populateWrite(String reponse) {
        if(this.progress.isShowing())
            this.progress.dismiss();

    }

    /**
     *  Retourne un String qui complète le titre de l'activity
     * @return numMach le numéro de la machine choisie
     */
    public String getNumMach(){
        String numMach ="";
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("numMach")){
                numMach = intent.getStringExtra("numMach");
            }
            nomMachine.setText("Machine n°" + numMach);
        }
        return numMach;
    }

    /**
     * Change la visibilité de certains objets
     */
    public void buttonSwapping(){
        // Machine1
        if(numeroMach.equals("1")){
            if(click1) {
                heureDebut.setText("Début du cycle: " + timeIni);
                heureFin.setText("Fin du cycle: " + timeFinal);
                buttonLancer.setVisibility(View.GONE);
                heureFin.setVisibility(View.VISIBLE);
                heureDebut.setVisibility(View.VISIBLE);
                buttonVider.setVisibility(View.VISIBLE);
            }
            else{
                buttonLancer.setVisibility(View.VISIBLE);
                heureFin.setVisibility(View.GONE);
                heureDebut.setVisibility(View.GONE);
                buttonVider.setVisibility(View.GONE);
            }
        }
        // Machine2
        if(numeroMach.equals("2")){
            if(click2) {
                buttonLancer.setVisibility(View.GONE);
                heureFin.setVisibility(View.VISIBLE);
                heureDebut.setVisibility(View.VISIBLE);
                buttonVider.setVisibility(View.VISIBLE);
            }
            else{
                buttonLancer.setVisibility(View.VISIBLE);
                heureFin.setVisibility(View.GONE);
                heureDebut.setVisibility(View.GONE);
                buttonVider.setVisibility(View.GONE);
            }
        }
        // Machine3
        if(numeroMach.equals("3")){
            if(click3) {
                buttonLancer.setVisibility(View.GONE);
                heureFin.setVisibility(View.VISIBLE);
                heureDebut.setVisibility(View.VISIBLE);
                buttonVider.setVisibility(View.VISIBLE);
            }
            else{
                buttonLancer.setVisibility(View.VISIBLE);
                heureFin.setVisibility(View.GONE);
                heureDebut.setVisibility(View.GONE);
                buttonVider.setVisibility(View.GONE);
            }
        }
        // Machine4
        if(numeroMach.equals("4")){
            if(click4) {
                buttonLancer.setVisibility(View.GONE);
                heureFin.setVisibility(View.VISIBLE);
                heureDebut.setVisibility(View.VISIBLE);
                buttonVider.setVisibility(View.VISIBLE);
            }
            else{
                buttonLancer.setVisibility(View.VISIBLE);
                heureFin.setVisibility(View.GONE);
                heureDebut.setVisibility(View.GONE);
                buttonVider.setVisibility(View.GONE);
            }
        }
        // Machine5
        if(numeroMach.equals("5")){
            if(click5) {
                buttonLancer.setVisibility(View.GONE);
                heureFin.setVisibility(View.VISIBLE);
                heureDebut.setVisibility(View.VISIBLE);
                buttonVider.setVisibility(View.VISIBLE);
            }
            else{
                buttonLancer.setVisibility(View.VISIBLE);
                heureFin.setVisibility(View.GONE);
                heureDebut.setVisibility(View.GONE);
                buttonVider.setVisibility(View.GONE);
            }
        }
        // Machine6
        if(numeroMach.equals("6")){
            if(click6) {
                buttonLancer.setVisibility(View.GONE);
                heureFin.setVisibility(View.VISIBLE);
                heureDebut.setVisibility(View.VISIBLE);
                buttonVider.setVisibility(View.VISIBLE);
            }
            else{
                buttonLancer.setVisibility(View.VISIBLE);
                heureFin.setVisibility(View.GONE);
                heureDebut.setVisibility(View.GONE);
                buttonVider.setVisibility(View.GONE);
            }
        }
        // Machine7
        if(numeroMach.equals("7")){
            if(click7) {
                buttonLancer.setVisibility(View.GONE);
                heureFin.setVisibility(View.VISIBLE);
                heureDebut.setVisibility(View.VISIBLE);
                buttonVider.setVisibility(View.VISIBLE);
            }
            else{
                buttonLancer.setVisibility(View.VISIBLE);
                heureFin.setVisibility(View.GONE);
                heureDebut.setVisibility(View.GONE);
                buttonVider.setVisibility(View.GONE);
            }
        }
        // Machine8
        if(numeroMach.equals("8")){
            if(click8) {
                buttonLancer.setVisibility(View.GONE);
                heureFin.setVisibility(View.VISIBLE);
                heureDebut.setVisibility(View.VISIBLE);
                buttonVider.setVisibility(View.VISIBLE);
            }
            else{
                buttonLancer.setVisibility(View.VISIBLE);
                heureFin.setVisibility(View.GONE);
                heureDebut.setVisibility(View.GONE);
                buttonVider.setVisibility(View.GONE);
            }
        }
    }


}
