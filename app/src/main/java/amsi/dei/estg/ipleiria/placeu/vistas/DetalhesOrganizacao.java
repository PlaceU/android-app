package amsi.dei.estg.ipleiria.placeu.vistas;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import amsi.dei.estg.ipleiria.placeu.R;
import amsi.dei.estg.ipleiria.placeu.modelo.Organizacao;
import amsi.dei.estg.ipleiria.placeu.modelo.SingletonOrganizacoes;

public class DetalhesOrganizacao extends AppCompatActivity {
    private EditText etNome;
    private Organizacao organizacao;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalhes_organizacao);

        this.etNome = findViewById(R.id.etNomeDetalhe);

        int indice = getIntent().getIntExtra("indice", -1);

        if(indice != -1){
            organizacao = SingletonOrganizacoes.getInstance().getOrganizacao(indice);

            this.etNome.setText(organizacao.getNome());
        }
        else{
            organizacao = null;
        }
    }
}
