package com.example.goldmoon_bistro;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Menu extends AppCompatActivity {

    //Creación de Variables
    ListView platillos;
    Button btnsalir;
    //Arreglo con items del menú
    String[] platillosArr = new String[]{"Croissant + café", "Sandwich de pollo", "Caramel Frapuccino", "Tiramisú", "Quesadilla + café"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        //Obtener referencia a componentes
        platillos = findViewById(R.id.lstvPlatillo);
        btnsalir = findViewById(R.id.btnSalir);

        //Adapter para generar una fila por cada item del menú
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, platillosArr);
        platillos.setAdapter(adapter);

        //Mostrar toast con información del platillo seleccionado
        platillos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Seleccionaste " + platillosArr[position] + " - GoldMoon Bistro", Toast.LENGTH_SHORT).show();
            }
        });

        //Finaliza todas las activity (Cierra la aplicación)
        btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

    }
}