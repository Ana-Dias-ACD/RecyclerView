package com.example.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.RecyclerItemClickListener;
import com.example.recyclerview.adapter.Adapter;
import com.example.recyclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de filmes
        this.criarFilmes();

        //Configurar adapter
        Adapter adapter = new Adapter(listFilmes);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //evento de click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Filme filme = listFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Item pressionado: " + filme.getTituloFilme(),
                                        Toast.LENGTH_LONG
                                ).show();
                            }

                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Click longo: " + filme.getTituloFilme(),
                                        Toast.LENGTH_LONG
                                ).show();

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }
                        }
                )
        );
    }

    public void criarFilmes(){
        Filme filme = new Filme("Capitão América: O Primeiro Vingador"," Aventura e Ficção","1943-1945");
        this.listFilmes.add(filme);

        filme = new Filme("Capitã Marvel", "Aventura e Ficçã", "1995");
        this.listFilmes.add(filme);

        filme = new Filme(" Homem de Ferro", "Aventura e Ficçã", "2010");
        this.listFilmes.add(filme);

        filme = new Filme("O Incrível Hulk", "Aventura e Ficçã", "2011");
        this.listFilmes.add(filme);

        filme = new Filme("Homem de Ferro 2", "Aventura e Ficçã", "2011");
        this.listFilmes.add(filme);

        filme = new Filme("Thor", "Aventura e Ficçã", "2011");
        this.listFilmes.add(filme);

        filme = new Filme("Os Vingadores", "Aventura e Ficçã", "2012");
        this.listFilmes.add(filme);

        filme = new Filme("Homem de Ferro 3", "Aventura e Ficçã", "2012");
        this.listFilmes.add(filme);

        filme = new Filme("Thor: O Mundo Sombrio", "Aventura e Ficçã", "2013");
        this.listFilmes.add(filme);

        filme = new Filme("Capitã Marvel", "Aventura e Ficçã", "1995");
        this.listFilmes.add(filme);

        filme = new Filme(" Homem de Ferro", "Aventura e Ficçã", "2010");
        this.listFilmes.add(filme);

        filme = new Filme("O Incrível Hulk", "Aventura e Ficçã", "2011");
        this.listFilmes.add(filme);

        filme = new Filme("Homem de Ferro 2", "Aventura e Ficçã", "2011");
        this.listFilmes.add(filme);

        filme = new Filme("Thor", "Aventura e Ficçã", "2011");
        this.listFilmes.add(filme);

        filme = new Filme("Os Vingadores", "Aventura e Ficçã", "2012");
        this.listFilmes.add(filme);

        filme = new Filme("Homem de Ferro 3", "Aventura e Ficçã", "2012");
        this.listFilmes.add(filme);

        filme = new Filme("Thor: O Mundo Sombrio", "Aventura e Ficçã", "2013");
        this.listFilmes.add(filme);
    }
}