package edu.eigsi.irsi.livewash;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonLaverie;
    private Button buttonContact;

    private ProgressDialog progress;
    TextView textView1,textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);


        this.buttonLaverie = (Button) findViewById(R.id.buttonLaverie);
        this.buttonContact =(Button) findViewById(R.id.buttonContact);

        buttonLaverie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ouvrirLaverie = new Intent(getApplicationContext(), Laverie.class);
                startActivity(ouvrirLaverie);
                finish();
            }
        });
        
        buttonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ouvrirContact = new Intent(getApplicationContext(), Contact.class);
                startActivity(ouvrirContact);
                finish();
            }
        });
    }








    @Override
    protected void onStart() {
        super.onStart();
        // Lignes facultatives
        //------------------------------------------------
        this.progress = new ProgressDialog(this);
        this.progress.setTitle("Veuillez patientez");
        this.progress.setMessage("Récupération du résultat en cours...");
        this.progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        this.progress.show();
        //------------------------------------------------

        String url;
        // url du service write
        url = "http://qcmjava.eigsi.fr/data/write.php";
        // Instanciation du Web Service
        WebServicesCallWrite wscw = new WebServicesCallWrite(this, url);
        // Appel de la fonction write avec la donnée "a;-;-;d"
        wscw.write("local","a;D;D;d");

        // Appel du service read
        this.progress.show();
        url = "http://qcmjava.eigsi.fr/data/read.php";
        WebServicesCallRead  wscr = new WebServicesCallRead(this, url);
        wscr.read("local");

    }

    // Fonction appelée par l'objet wscw
    public void populateWrite(String response) {
        if(this.progress.isShowing())
            this.progress.dismiss();
        textView1.setText("Résultat ecriture = " + response);
    }

    // Fonction appelée par l'objet wscr
    public void populateRead(String response) {
        if(this.progress.isShowing())
            this.progress.dismiss();
        textView2.setText("Résultat lecture = " + response);
    }



    }
