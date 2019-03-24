package edu.eigsi.irsi.livewash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Machine4 extends AppCompatActivity {

    private Button buttonLaverie4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine4);

        this.buttonLaverie4 = (Button) findViewById(R.id.buttonLaverie4);

        buttonLaverie4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour4 = new Intent(getApplicationContext(), Laverie.class);
                startActivity(retour4);
                finish();
            }
        });

    }



}
