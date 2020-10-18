package es.esy.elvinmorales48.petagram;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView reciclador;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Mascota> datos = new ArrayList<Mascota>();

        datos.add(new Mascota(R.drawable.perro1, "Pirulais",  0xFF00FF00));
        datos.add(new Mascota(R.drawable.perro2, "Terry",     0xFFa8285c));
        datos.add(new Mascota(R.drawable.perro3, "Rambo",     0xFF10D94C));
        datos.add(new Mascota(R.drawable.perro4, "Princesa",  0xFF45694C));
        datos.add(new Mascota(R.drawable.perro5, "Niño",      0xFF426989));
        datos.add(new Mascota(R.drawable.perro6, "Toby",      0xFF7a355b));
        datos.add(new Mascota(R.drawable.perro7, "Wiro",      0xFFd1c1fc));
        datos.add(new Mascota(R.drawable.perro8, "Rocky",     0xFF962489));

        reciclador = (RecyclerView) findViewById(R.id.ReciclerView_Reciclador);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(layoutManager);

        recyclerAdapter = new MascotaAdaptador(datos);
        reciclador.setAdapter(recyclerAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Mi FloatingActionButton haciendo una accion",Snackbar.LENGTH_LONG).setAction("Accion", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.menuActionSettings){
            return true;
        }

        if(id == R.id.menuActionFavorito){
            startActivity(new Intent(MainActivity.this, FavoritosActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
