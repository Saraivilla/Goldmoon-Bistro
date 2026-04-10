package com.example.goldmoon_bistro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Registro extends AppCompatActivity {

    //Creación de Variables
    EditText edtrestaurante, edtcliente, edtrubro;
    Button btncontinuar;
    String usr = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);

        //Obtener referencia a componentes
        edtrestaurante = findViewById(R.id.edtRestaurante);
        edtcliente = findViewById(R.id.edtCliente);
        edtrubro = findViewById(R.id.edtRubro);
        btncontinuar = findViewById(R.id.btnContinuar);

        //Acciones Botón continuar
        btncontinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Obtenemos valores ingresados por el usuario
                String restaurante = edtrestaurante.getText().toString();
                String rubro = edtrubro.getText().toString();
                String cliente = edtcliente.getText().toString();

                //Obtener información de activity anterior (usuario)
                Bundle bundle = getIntent().getExtras();
                usr = bundle.getString("usuario");

                //Validación campos vacíos
                if(restaurante.isEmpty() || rubro.isEmpty() || cliente.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Complete los campos", Toast.LENGTH_SHORT).show();
                }
                //Navegación hacia activity de Resumen, enviado información
                else{
                    Toast.makeText(getApplicationContext(), "Información guardada! " , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Registro.this, Resumen.class);

                    intent.putExtra("restaurante", restaurante);
                    intent.putExtra("rubro", rubro);
                    intent.putExtra("cliente", cliente);
                    intent.putExtra("usuario", usr);

                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
