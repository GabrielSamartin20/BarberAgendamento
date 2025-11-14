package com.gabriel.BarberApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.gabriel.BarberApp.R;

import java.util.ArrayList;
import java.util.List;

import adapter.BarberAdapter;
import model.Barber;

public class MainActivity extends AppCompatActivity {

            private RecyclerView recyclerViewBarbers;
            private BarberAdapter barberAdapter;
            private List<Barber> barberList;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(com.gabriel.barberapp.R.layout.activity_main);


                initBarberList();


                recyclerViewBarbers = findViewById(R.id.recycler_view_barbers);
                recyclerViewBarbers.setLayoutManager(new LinearLayoutManager(this));


                barberAdapter = new BarberAdapter(this, barberList);
                recyclerViewBarbers.setAdapter(barberAdapter);
            }


            private void initBarberList() {
                barberList = new ArrayList<>();

                barberList.add(new Barber("Carlos Silva", "Cortes Clássicos e Barba", R.drawable.barber3));
                barberList.add(new Barber("Rafael Santos", "Degradê e Risco", R.drawable.barber2));
                barberList.add(new Barber("Bruna Marques", "Cabelo Longo e Estilização", R.drawable.barber1));

            }
        }

