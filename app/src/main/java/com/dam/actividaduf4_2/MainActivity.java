package com.dam.actividaduf4_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

// Implementamos la interfaz OnDatosListener para poder recibir los datos del diálogo.
public class MainActivity extends AppCompatActivity implements OnDatosListener {

    // Creamos tam inicialmente a 24 porque es el tamaño por defecto. Más adelante
    // lo modificaremos pasandoselo la interfaz mediante el método onAceptarDatosListener(),
    // que lo que se reciba sobre escribirá el valor de tam.
    private int tam = 24;
    private AlertDialog ad;
    // Lo declaramos como atributo para poder acceder a él desde el método, así
    // como para poder reutilizarlo en el método mostrarDialogoSalir() y no crearlo
    // cada vez que se pulse el botón de salir.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCambiarTam = findViewById(R.id.btnCambiarTamanio);
        btnCambiarTam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // De esta manera le pasamos el tamaño actual como parámetro.
                SizeDialog.newInstance(tam).show(getSupportFragmentManager(), "SizeDialog");
            }
        });

        // Inicializamos el diálogo, para que no se cree cada vez que se pulse el botón de salir.
        inicializarDialogoSalir();
        // Según iniciamos la actividad, mostramos el fragmento de inicio. ("Hello world")
        replaceFragment(InicioFragment.newInstance());
    }

    // Metodo para crear el menú.
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // Inflamos el menú.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Este método es el que hará que se sustituya el fragmento actual por el que le pasemos,
    // pasandole el fragmento por parámetro. Remplazamos el flContenedor por el fragmento que le pasemos.
    // Invocamos este metodo par cuando pulsemos java o python, y en el onCreate para mostrar el
    // fragmento de inicio.
    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flContenedor, fragment)
                .commit();
    }

    // Añadimos @SuppressLint("NonConstantResourceId") para que no nos de error al usar el switch.
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSalir:
                mostrarDialogoSalir();
                break;
            case R.id.menuJava:
                replaceFragment(JavaFragment.newInstance(tam));
                break;
            case R.id.menuPython:
                replaceFragment(PythonFragment.newInstance(tam));
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void inicializarDialogoSalir() {
        // Creamos el constructor del diálogo.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle(R.string.dialog_salir_title);
        builder.setMessage(R.string.confirmar_salir);
        builder.setPositiveButton(R.string.btnd_aceptar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Si se pulsa el botón de aceptar, finalizamos la actividad.
                finish();
            }
        });

        builder.setNegativeButton(R.string.btnd_cancelar,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        // Si se pulsa el botón de cancelar, cerramos el diálogo.
                        dialogInterface.cancel();
                    }
                });

        // Creamos el diálogo y lo mostramos.
        ad = builder.create();
        // Para que no se pueda cerrar el diálogo pulsando fuera de él.
        ad.setCanceledOnTouchOutside(false);
    }

    // Se ejecuta una vez termine el InicializarDialogoSalir().
    private void mostrarDialogoSalir() {
        ad.show();
    }

    // Método que hemos implementado de la interfaz OnDatosListener.
    @Override
    public void onAceptarDatosListener(int size) {
        // Recibimos el tamaño y lo guardamos en el atributo.
        this.tam = size;
    }
}