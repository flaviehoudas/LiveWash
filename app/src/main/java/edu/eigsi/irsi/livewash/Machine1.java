package edu.eigsi.irsi.livewash;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




import java.util.Date;
import java.text.SimpleDateFormat;



public class Machine1 extends AppCompatActivity {

    private Button buttonLaverie1;
    private Button buttonLancer;


    Date dateIni = new Date();
    Date dateToAdd = new Date(10*1000);
    Date dateFinal = new Date(dateIni.getTime() + dateToAdd.getTime());
    Date dateNow = new Date();

    SimpleDateFormat sdfIni = new SimpleDateFormat("HH:mm");
    SimpleDateFormat sdfFinal = new SimpleDateFormat("HH:mm");

    String timeIni = sdfIni.format(dateIni);
    String timeFinal = sdfFinal.format(dateFinal);




    private TextView heureDebut , heureFin;
    private Button buttonSignaler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine1);


        this.buttonLaverie1 = (Button) findViewById(R.id.buttonLaverie1);
        this.buttonLancer = (Button) findViewById(R.id.buttonLancer);
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








        buttonLancer.setOnClickListener(new View.OnClickListener() {


            public void tempsMachine() {
                int compare = dateNow.compareTo(dateFinal);
                while (compare < 0){
                    buttonLancer.setText("Machine vidée");
                    //buttonLancer.setClickable(false);
                    buttonLancer.setBackgroundColor(0xFFFF0000);
                    //dateNow = new Date();
                    //compare = dateNow.compareTo(dateFinal);
                }
            }

            @Override
            public void onClick(View view) {


                heureDebut.setText("Heure de début du cycle : " + timeIni);
                heureFin.setText("Heure de fin du cycle : " + timeFinal);
                tempsMachine();

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
