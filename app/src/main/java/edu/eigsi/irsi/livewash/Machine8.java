package edu.eigsi.irsi.livewash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Machine8 extends AppCompatActivity {

    private Button buttonLaverie8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine8);

        this.buttonLaverie8 = (Button) findViewById(R.id.buttonLaverie8);

        buttonLaverie8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour8 = new Intent(getApplicationContext(), Laverie.class);
                startActivity(retour8);
                finish();
            }
        });
    }
}
