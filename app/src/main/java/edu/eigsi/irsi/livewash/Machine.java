package edu.eigsi.irsi.livewash;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

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


        Intent intent = getIntent();
        if(intent != null){
            String numMach = "";
            if(intent.hasExtra("numMach")){
                numMach = intent.getStringExtra("numMach");
            }
            nomMachine.setText("Machine n°" + numMach);
        }


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
                buttonLancer.setBackgroundColor(getResources().getColor(R.color.blue));
                buttonLancer.setText("Machine vidée");
                buttonLancer.setVisibility(View.GONE);
                buttonVider.setVisibility(View.VISIBLE);
                heureDebut.setVisibility(View.VISIBLE);
                heureFin.setVisibility(View.VISIBLE);

                //lancerMachine();

            }

        });

        buttonVider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (buttonVider.isChecked()){

                    //viderMachine();

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


}
