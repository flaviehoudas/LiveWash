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
    SimpleDateFormat date = new java.text.SimpleDateFormat("HH:mm");
    String time = date.format(new Date());
    //SimpleDateFormat dateFinal = date + 90 ;
    //String timeFinal = dateFinal.format(new Date());
    private TextView heureDebut , heureFin;
    private Button buttonSignaler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine1);

        this.buttonLaverie1 = (Button) findViewById(R.id.buttonLaverie1);
        this.buttonLancer = (Button) findViewById(R.id.buttonLancer);
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

            @Override
            public void onClick(View view) {


               heureDebut.setText("Heure de début du cycle : " + time);
               //heureFin.setText("Heure de fin du cycle : " + timeFinal);


             /** écrire sur le dossier serveur **/


            }
        });

        //buttonSignaler.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View view) {
                /** écrire sur le dossier du serveur**/
            //}
        //});
    }



}
