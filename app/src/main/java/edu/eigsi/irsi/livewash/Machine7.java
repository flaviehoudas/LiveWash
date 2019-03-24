package edu.eigsi.irsi.livewash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Machine7 extends AppCompatActivity {

    private Button buttonLaverie7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine7);

        this.buttonLaverie7 = (Button) findViewById(R.id.buttonLaverie7);

        buttonLaverie7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour7 = new Intent(getApplicationContext(), Laverie.class);
                startActivity(retour7);
                finish();
            }
        });
    }
}
