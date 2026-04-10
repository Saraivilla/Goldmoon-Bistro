package com.example.goldmoon_bistro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Resumen extends AppCompatActivity {

    //Creación de Variables
    TextView txvrestaurante, txvrubro, txvcliente, txvusuario;
    Button btnmenu, btnregresar, btnsalir;
    String restaurante = null, rubro = null, cliente = null, usuario = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumen);

        //Obtener referencia a componentes
        txvrestaurante = findViewById(R.id.txvRestaurante);
        txvrubro = findViewById(R.id.txvRubro);
        txvcliente = findViewById(R.id.txvCliente);
        txvusuario = findViewById(R.id.txvUsuario);
        btnmenu = findViewById(R.id.btnMenu);
        btnregresar = findViewById(R.id.btnRegresar);
        btnsalir = findViewById(R.id.btnSalir);

        //Obtener información de activity anterior
        Bundle bundle = getIntent().getExtras();
        restaurante = bundle.getString("restaurante");
        rubro = bundle.getString("rubro");
        cliente = bundle.getString("cliente");
        usuario = bundle.getString("usuario");

        //Mostrar la información en componentes textView
        txvrestaurante.setText(restaurante);
        txvrubro.setText(rubro);
        txvcliente.setText(cliente);
        txvusuario.setText(usuario);


        //Abrir activity menú
        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resumen.this, Menu.class);
                startActivity(intent);
            }
        });

        //Regresar a activity de Reistro
        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resumen.this, Registro.class);
                startActivity(intent);
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