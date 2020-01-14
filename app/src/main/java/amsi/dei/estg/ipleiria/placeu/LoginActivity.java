package amsi.dei.estg.ipleiria.placeu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {


    private EditText etMail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btLogin = findViewById(R.id.btLogin);
        this.etMail = findViewById(R.id.etEmail);
        this.etPassword = findViewById(R.id.etPassword);

        this.etMail.setText("joao@mail.com");
        this.etPassword.setText("q1234");

        btLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                verificaLogin();
            }
        });

        Button btRegistar = findViewById(R.id.btRegistar);

        btRegistar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intentRegister = new Intent (view.getContext(),RegisterActivity.class);
                startActivity(intentRegister);
                finish();
            }
        });
    }

    private void verificaLogin(){
        String pass = this.etPassword.getText().toString();
        String mail = this.etMail.getText().toString();

        if(!isEmailValido(mail)){
            this.etMail.setError("Email inválido");
            return;
        }

        if(!isPassValida(pass)){
            this.etPassword.setError("Password inválida");
            return;
        }

        Intent intentMain = new Intent (this, MenuMainActivity.class);
        intentMain.putExtra("Mail", mail);
        startActivity(intentMain);
        finish();

    }

    private boolean isEmailValido(String mail){
        if(mail == null)
            return false;

        return Patterns.EMAIL_ADDRESS.matcher(mail).matches();
    }

    private boolean isPassValida(String pass){
        if(pass == null)
            return false;

        if(pass.length() < 4)
            return false;

        return true;
    }

}
