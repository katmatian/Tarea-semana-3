package es.esy.elvinmorales48.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {

    private RecyclerView recicladorFav;
    private RecyclerView.LayoutManager layoutManagerFav;
    private RecyclerView.Adapter recyclerAdapterFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Favoritos");

        ArrayList<Mascota> datosFav = new ArrayList<Mascota>();

        datosFav.add(new Mascota(R.drawable.perro3, "Rambo",     0xFF10D94C));
        datosFav.add(new Mascota(R.drawable.perro6, "Toby",      0xFF7a355b));
        datosFav.add(new Mascota(R.drawable.perro5, "Niño",      0xFF426989));
        datosFav.add(new Mascota(R.drawable.perro1, "Pirulais",  0xFF00FF00));
        datosFav.add(new Mascota(R.drawable.perro4, "Princesa",  0xFF45694C));

        recicladorFav = (RecyclerView) findViewById(R.id.ReciclerView_RecicladorFavorito);
        layoutManagerFav = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recicladorFav.setLayoutManager(layoutManagerFav);

        recyclerAdapterFav = new MascotaAdaptador(datosFav);
        recicladorFav.setAdapter(recyclerAdapterFav);

    }
}
