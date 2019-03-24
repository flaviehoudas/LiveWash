package edu.eigsi.irsi.livewash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Machine3 extends AppCompatActivity {

    private Button buttonLaverie3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine3);

        this.buttonLaverie3 = (Button) findViewById(R.id.buttonLaverie3);

        buttonLaverie3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour3 = new Intent(getApplicationContext(), Laverie.class);
                startActivity(retour3);
                finish();
            }
        });
    }


}
