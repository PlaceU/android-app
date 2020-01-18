package amsi.dei.estg.ipleiria.placeu.vistas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import amsi.dei.estg.ipleiria.placeu.R;

public class MenuMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private DrawerLayout drawer;

    private String mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.nav_view);
        drawer = findViewById(R.id.drawer_layout);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,
                toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        toggle.syncState();
        drawer.addDrawerListener(toggle);

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.contentFragment,
                    new RequisicoesFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_requisicoes_activas);
        }

        carregarCabecalho();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.nav_organizacoes:
                getSupportFragmentManager().beginTransaction().replace(R.id.contentFragment,
                        new OrganizacoesFragment()).commit();
                break;
            case R.id.nav_requisicoes_activas:
                getSupportFragmentManager().beginTransaction().replace(R.id.contentFragment,
                        new RequisicoesFragment()).commit();
                break;
            case R.id.nav_historico:
                getSupportFragmentManager().beginTransaction().replace(R.id.contentFragment,
                        new HistoricoFragment()).commit();
                break;
            case R.id.nav_sair:
                System.exit(1);
                break;

        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    private void carregarCabecalho() {
        View view = navigationView.getHeaderView(0);
        TextView tvmail = view.findViewById(R.id.tvMailMenu);
        tvmail.setText(mail);
    }

}
