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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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

    }
