package edu.eigsi.irsi.livewash;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Signaler extends AppCompatActivity {

    private Button buttonRmach1;
    private Button buttonEnvoyer;
    private Signaler activity;
    private RadioButton buttonAutre;
    private EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signaler);
        this.activity=this;


        this.buttonRmach1 = (Button) findViewById(R.id.buttonRmach1);

        buttonRmach1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retourmach1 = new Intent(getApplicationContext(), Machine.class);
                startActivity(retourmach1);
                finish();
                    }
                });

        this.buttonAutre = (RadioButton) findViewById(R.id.radioButtonAutre);
        this.editText = (EditText) findViewById(R.id.editTextAutre);
        editText.setVisibility(View.INVISIBLE);

        buttonAutre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setVisibility( View.VISIBLE);
            }
        });



        this.buttonEnvoyer = (Button) findViewById(R.id.buttonEnvoyer);

        buttonEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myPopUp = new AlertDialog.Builder(activity);
                myPopUp.setMessage("Le signalement a bien été pris en compte, nous vous remercions.");
                myPopUp.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent retourmach1 = new Intent(getApplicationContext(), Laverie.class);
                        startActivity(retourmach1);
                        finish();
                    }
                });
                myPopUp.show();

            }
        });

    }

    }

