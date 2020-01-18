package amsi.dei.estg.ipleiria.placeu.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import amsi.dei.estg.ipleiria.placeu.R;
import amsi.dei.estg.ipleiria.placeu.vistas.LoginActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btCancelar = findViewById(R.id.btCancelar);

        btCancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intentCancel = new Intent (view.getContext(), LoginActivity.class);
                startActivity(intentCancel);
                finish();
            }
        });

    }
}
