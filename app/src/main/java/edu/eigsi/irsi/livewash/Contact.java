package edu.eigsi.irsi.livewash;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Contact extends AppCompatActivity {

    private Button buttonRetourC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        this.buttonRetourC = (Button) findViewById(R.id.buttonRetourC);

        buttonRetourC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retourC = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(retourC);
                finish();
            }
        });

        //public void onBackPressed()

        //{
            // code here to show dialog
            //super.onBackPressed();  // optional depending on your needs
        //}

    }
}
