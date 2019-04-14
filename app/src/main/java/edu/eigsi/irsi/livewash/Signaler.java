package edu.eigsi.irsi.livewash;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Signaler extends AppCompatActivity {

    private Button buttonRmach1;
    private Button buttonEnvoyer;
    private Signaler activity;
    private ProgressDialog progress;
    private String numeroMach;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signaler);

        //------------------------------------------------
        this.progress = new ProgressDialog(this);
        this.progress.setTitle("Veuillez patientez");
        this.progress.setMessage("Récupération du résultat en cours...");
        this.progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        //------------------------------------------------


        this.activity=this;
        numeroMach = getNumMach();
        this.buttonRmach1 = (Button) findViewById(R.id.buttonRmach1);


        buttonRmach1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retourmach1 = new Intent(getApplicationContext(), Machine.class);
                startActivity(retourmach1);
                finish();
            }
        });

        this.buttonEnvoyer = (Button) findViewById(R.id.buttonEnvoyer);

        buttonEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myPopUp = new AlertDialog.Builder(activity);
                myPopUp.setMessage("Le signalement a bien été pris en compte. Nous vous remercions pour votre contribution.");
                myPopUp.show();

            }
        });
    }

    public void putHS() {

        String url;
        // Appel du service read
        this.progress.show();
        url = "http://qcmjava.eigsi.fr/data/read.php";
        WebServicesCallReadSignaler wscr = new WebServicesCallReadSignaler(this, url);
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
        WebServicesCallWriteSignaler wscw = new WebServicesCallWriteSignaler(this, url);

        // Appel de la fonction write
        if (numeroMach.equals("1")) {
            wscw.write("local", "HS," + etatmach2 + "," + etatmach3 + "," +
                    etatmach4 + "," + etatmach5 + "," + etatmach6 + "," + etatmach7
                    + "," + etatmach8);
        }
        if (numeroMach.equals("2")) {
            wscw.write("local", etatmach1 + ",HS" + "," + etatmach3 + ","
                    + etatmach4 + "," + etatmach5 + "," + etatmach6 + "," + etatmach7 + "," +
                    etatmach8);
        }
        if (numeroMach.equals("3")) {
            wscw.write("local", etatmach1 + "," + etatmach2 + ",HS," + etatmach4
                    + "," + etatmach5 + "," + etatmach6 + "," + etatmach7 + "," + etatmach8);
        }
        if (numeroMach.equals("4")) {
            wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3 +
                    ",HS," + etatmach5 + "," + etatmach6 + "," + etatmach7 +  "," + etatmach8);
        }
        if (numeroMach.equals("5")) {
            wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3
                    + "," + etatmach4 + ",HS," + etatmach6 + "," + etatmach7 +  "," + etatmach8);
        }
        if (numeroMach.equals("6")) {
            wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3 + ","
                    + etatmach4  + "," + etatmach5 + ",HS," + etatmach7 + "," + etatmach8);
        }
        if (numeroMach.equals("7")) {
            wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3 + ","
                    + etatmach4  + "," + etatmach5 + "," + etatmach6 + ",HS," + etatmach8);
        }
        if (numeroMach.equals("8")) {
            wscw.write("local", etatmach1 + "," + etatmach2 + "," + etatmach3 + ","
                    + etatmach4  + "," + etatmach5 + "," + etatmach6 + "," + etatmach7 + ",HS");
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
        }
        return numMach;
    }

}
