package edu.eigsi.irsi.livewash;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Signaler extends AppCompatActivity {

    private Button buttonRmach1;
    private Button buttonEnvoyer;


    Machine1 machine1 = new Machine1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signaler);

        this.buttonRmach1 = (Button) findViewById(R.id.buttonRmach1);
        this.buttonEnvoyer = (Button) findViewById(R.id.buttonEnvoyer);

        buttonRmach1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retourmach1 = new Intent(getApplicationContext(), Machine1.class);
                startActivity(retourmach1);
                finish();
                    }
                });

        buttonEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

            }

    }

