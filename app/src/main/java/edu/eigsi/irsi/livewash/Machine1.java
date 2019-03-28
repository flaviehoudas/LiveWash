package edu.eigsi.irsi.livewash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Machine1 extends AppCompatActivity {

    private Button buttonLaverie1;
    private Machine machine1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine1);

        this.buttonLaverie1 = (Button) findViewById(R.id.buttonLaverie1);

        buttonLaverie1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retour1 = new Intent(getApplicationContext(), Laverie.class);
                startActivity(retour1);
                finish();
            }
        });
    }



}
