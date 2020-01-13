package amsi.dei.estg.ipleiria.placeu;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MenuMainActivity extends AppCompatActivity {

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

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,
                toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        toggle.syncState();
        drawer.addDrawerListener(toggle);

        carregarCabecalho();

    }

    private void carregarCabecalho() {
        View view = navigationView.getHeaderView(0);
        TextView tvmail = view.findViewById(R.id.tvMailMenu);
        tvmail.setText(mail);
    }
}
