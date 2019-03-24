package edu.eigsi.irsi.livewash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Machine5 extends AppCompatActivity {

    private Button buttonLaverie5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine5);

        this.buttonLaverie5 = (Button) findViewById(R.id.buttonLaverie5);

        buttonLaverie5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour5 = new Intent(getApplicationContext(), Laverie.class);
                startActivity(retour5);
                finish();
            }
        });
    }
}
