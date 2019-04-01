package edu.eigsi.irsi.livewash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Calendar;
import java.util.Date;

public class Machine1 extends AppCompatActivity {

    private Button buttonLaverie1;
    private Machine machine1;
    private Button buttonLancer;
    private Button buttonSignaler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine1);

        this.buttonLaverie1 = (Button) findViewById(R.id.buttonLaverie1);

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
               Date now = new Date();
               int heureDebut = now.getHours();

             /** écrire sur le dossier serveur **/


            }
        });

        buttonSignaler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** écrire sur le dossier du serveur**/
            }
        });
    }



}
