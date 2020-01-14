package amsi.dei.estg.ipleiria.placeu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
