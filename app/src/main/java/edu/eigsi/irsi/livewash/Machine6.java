package edu.eigsi.irsi.livewash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Machine6 extends AppCompatActivity {

    private Button buttonLaverie6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine6);

        this.buttonLaverie6 = (Button) findViewById(R.id.buttonLaverie6);

        buttonLaverie6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour6 = new Intent(getApplicationContext(), Laverie.class);
                startActivity(retour6);
                finish();
            }
        });
    }

}
