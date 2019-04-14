package edu.eigsi.irsi.livewash;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

    public static final String prefsFile = "MyPrefsFile";


    Date dateIni = new Date();
    Date dateToAdd = new Date(90*1000);
    Date dateFinal = new Date(dateIni.getTime() + dateToAdd.getTime());
    SimpleDateFormat sdfIni = new SimpleDateFormat("HH:mm");
    SimpleDateFormat sdfFinal = new SimpleDateFormat("HH:mm");
    String timeIni = sdfIni.format(dateIni);
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
        buttonVider.setVisibility(View.GONE);
        heureDebut.setVisibility(View.GONE);
        heureFin.setVisibility(View.GONE);
        numeroMach = getNumMach();

        buttonLancer.setVisibility(View.VISIBLE);


        getNumMach();

        //------------------------------------------------
        this.progress = new ProgressDialog(this);
        this.progress.setTitle("Veuillez patientez");
        this.progress.setMessage("Récupération du résultat en cours...");
        this.progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        //------------------------------------------------



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
                heureDebut.setText("Heure de début du cycle : " + timeIni);
                heureFin.setText("Heure de fin du cycle : " + timeFinal);
                buttonVider.setVisibility(View.VISIBLE);
                heureDebut.setVisibility(View.VISIBLE);
                heureFin.setVisibility(View.VISIBLE);
                buttonLancer.setVisibility(View.GONE);

                lancerMachine();
            }
        });

        buttonVider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonVider.isChecked()){
                    viderMachine();
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

    public void lancerMachine(){

        String url;
        // Appel du service read
        this.progress.show();
        url = "http://qcmjava.eigsi.fr/data/read.php";
        WebServicesCallRead wscr = new WebServicesCallRead(this, url);
        wscr.read("local");

    }


    public void viderMachine(){

        String url;
        // Appel du service read
        this.progress.show();
        url = "http://qcmjava.eigsi.fr/data/read.php";
        WebServicesCallRead wscr = new WebServicesCallRead(this, url);
        wscr.read("local");


    }


    // Fonction appelée par l'objet wscr
    public void populateRead(String reponse) {
        if (this.progress.isShowing())
            this.progress.dismiss();

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

        if (!buttonVider.isChecked()){
            // Appel de la fonction write
            if (numeroMach.equals("1")) {
                wscw.write("local", "O," + etatmach2 + "," + etatmach3 + "," +
                        etatmach4 + "," + etatmach5 + "," + etatmach6 + "," + etatmach7
                        + "," + etatmach8);
            }
            if (numeroMach.equals("2")) {
                wscw.write("local", etatmach1 + ",O" + "," + etatmach3 + ","
                        + etatmach4 + "," + etatmach5 + "," + etatmach6 + "," + etatmach7 + "," +
                        etatmach8);
            }
            if (numeroMach.equals("3")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + ",O," + etatmach4
                        + "," + etatmach5 + "," + etatmach6 + "," + etatmach7 + "," + etatmach8);
            }
            if (numeroMach.equals("4")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3 +
                        ",O," + etatmach5 + "," + etatmach6 + "," + etatmach7 +  "," + etatmach8);
            }
            if (numeroMach.equals("5")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3
                        + "," + etatmach4 + ",O," + etatmach6 + "," + etatmach7 +  "," + etatmach8);
            }
            if (numeroMach.equals("6")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3 + ","
                        + etatmach4  + "," + etatmach5 + ",O," + etatmach7 + "," + etatmach8);
            }
            if (numeroMach.equals("7")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3 + ","
                        + etatmach4  + "," + etatmach5 + "," + etatmach6 + ",O," + etatmach8);
            }
            if (numeroMach.equals("8")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3 + ","
                        + etatmach4  + "," + etatmach5 + "," + etatmach6 + "," + etatmach7 + ",O");
            }
        }

        if (buttonVider.isChecked()){
            // Appel de la fonction write
            if (numeroMach.equals("1")) {
                wscw.write("local", "L," + etatmach2 + "," + etatmach3 + "," +
                        etatmach4 + "," + etatmach5 + "," + etatmach6 + "," + etatmach7
                        + "," + etatmach8);
            }
            if (numeroMach.equals("2")) {
                wscw.write("local", etatmach1 + ",L," + etatmach3 + "," + etatmach4
                        + "," + etatmach5 + "," + etatmach6 + "," + etatmach7 + "," + etatmach8);
            }
            if (numeroMach.equals("3")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + ",L," + etatmach4
                        + "," + etatmach5 + "," + etatmach6 + "," + etatmach7 + "," + etatmach8);
            }
            if (numeroMach.equals("4")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3
                        + ",L," + etatmach5 + "," + etatmach6 + "," + etatmach7 + "," + etatmach8);
            }
            if (numeroMach.equals("5")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3
                        + "," + etatmach4 + ",L," + etatmach6 + "," + etatmach7 + "," + etatmach8);
            }
            if (numeroMach.equals("6")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3
                        + "," + etatmach4 + "," + etatmach5 + ",L," + etatmach7 + "," + etatmach8);
            }
            if (numeroMach.equals("7")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3
                        + "," + etatmach4 + "," + etatmach5 + "," + etatmach6 + ",L," + etatmach8);
            }
            if (numeroMach.equals("8")) {
                wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3
                        + "," + etatmach4 + "," + etatmach5 + "," + etatmach6 + ","
                        + etatmach7 + ",L");
            }
        }

    }

    // Fonction appelée par l'objet wscw
    public void populateWrite(String reponse) {
        if(this.progress.isShowing())
            this.progress.dismiss();

    }

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


    }
