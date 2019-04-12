package edu.eigsi.irsi.livewash;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;


import java.util.Date;
import java.text.SimpleDateFormat;



public class Machine1 extends AppCompatActivity {

    private Button buttonLaverie1;
    private Button buttonLancer;
    private ProgressDialog progress;
    private Switch buttonVider;
    private TextView heureDebut , heureFin;
    private Button buttonSignaler;


    Date dateIni = new Date();
    Date dateToAdd = new Date(90*1000);
    Date dateFinal = new Date(dateIni.getTime() + dateToAdd.getTime());
    Date dateNow = new Date();


    SimpleDateFormat sdfIni = new SimpleDateFormat("HH:mm");
    SimpleDateFormat sdfFinal = new SimpleDateFormat("HH:mm");
    SimpleDateFormat sdfNow = new SimpleDateFormat("HH:mm");

    String timeIni = sdfIni.format(dateIni);
    String timeFinal = sdfFinal.format(dateFinal);
    String timeNow = sdfNow.format(dateNow);






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine1);

        this.buttonLaverie1 = (Button) findViewById(R.id.buttonLaverie1);
        this.buttonLancer = (Button) findViewById(R.id.buttonLancer);
        this.buttonVider = (Switch) findViewById(R.id.buttonVider);
        this.buttonSignaler = (Button) findViewById(R.id.buttonSignaler) ;
        this.heureDebut=  (TextView) findViewById(R.id.heureDebut);
        this.heureFin = (TextView)  findViewById(R.id.heureFin);





        buttonLaverie1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour1 = new Intent(getApplicationContext(), Laverie.class);
                startActivity(retour1);
                finish();
            }
        });



        buttonVider.setVisibility(View.GONE);
        heureDebut.setVisibility(View.GONE);
        heureFin.setVisibility(View.GONE);



        buttonLancer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                heureDebut.setText("Heure de début du cycle : " + timeIni);
                heureFin.setText("Heure de fin du cycle : " + timeFinal);
                buttonLancer.setBackgroundColor(getResources().getColor(R.color.blue));
                buttonLancer.setText("Machine vidée");
                buttonLancer.setVisibility(View.GONE);
                buttonVider.setVisibility(View.VISIBLE);
                heureDebut.setVisibility(View.VISIBLE);
                heureFin.setVisibility(View.VISIBLE);

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
                startActivity(signaler);
                finish();
            }
        });




    }


    public void lancerMachine(){


        // Lignes facultatives
        //------------------------------------------------
        this.progress = new ProgressDialog(this);
        this.progress.setTitle("Veuillez patientez");
        this.progress.setMessage("Récupération du résultat en cours...");
        this.progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        this.progress.show();
        //------------------------------------------------

        String url;
        //url du service write
        url = "http://qcmjava.eigsi.fr/data/write.php";
        // Instanciation du Web Service
        //WebServicesCallWrite wscw = new WebServicesCallWrite(this, url);
        Unic.wscw = new WebServicesCallWrite(this, url);
        // Appel de la fonction write avec la donnée ""
        Unic.wscw.write("local","O");
    }



    public void viderMachine(){


        // Lignes facultatives
        //------------------------------------------------
        this.progress = new ProgressDialog(this);
        this.progress.setTitle("Veuillez patientez");
        this.progress.setMessage("Récupération du résultat en cours...");
        this.progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        this.progress.show();
        //------------------------------------------------

        String url;
        //url du service write
        url = "http://qcmjava.eigsi.fr/data/write.php";
        // Instanciation du Web Service
        //WebServicesCallWrite wscw = new WebServicesCallWrite(this, url);
        Unic.wscw = new WebServicesCallWrite(this, url);
        // Appel de la fonction write avec la donnée ""
        Unic.wscw.write("local","L");
    }



    // Fonction appelée par l'objet wscw
    public void populateWrite(String reponse) {
        if(this.progress.isShowing())
            this.progress.dismiss();

    }

    public void populateRead(String reponse) {
        if (this.progress.isShowing())
            this.progress.dismiss();
    }



}
