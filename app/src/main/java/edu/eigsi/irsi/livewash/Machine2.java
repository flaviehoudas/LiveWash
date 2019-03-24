package edu.eigsi.irsi.livewash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Machine2 extends AppCompatActivity {

    private Button buttonLaverie2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine2);

        this.buttonLaverie2 = (Button) findViewById(R.id.buttonLaverie2);

        buttonLaverie2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour2 = new Intent(getApplicationContext(), Laverie.class);
                startActivity(retour2);
                finish();
            }
        });
    }
}
