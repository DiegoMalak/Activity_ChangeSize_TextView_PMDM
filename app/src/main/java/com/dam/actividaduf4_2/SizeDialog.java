package com.dam.actividaduf4_2;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SizeDialog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SizeDialog extends DialogFragment {

    OnDatosListener listener;

    private static final String SIZE_PARAM = "sizeParam";

    private int sizeParam;

    public SizeDialog() {
        // Required empty public constructor
    }

    public static SizeDialog newInstance(int size) {
        SizeDialog fragment = new SizeDialog();
        Bundle args = new Bundle();
        args.putInt(SIZE_PARAM, size);
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        sizeParam = getArguments().getInt(SIZE_PARAM);

        // Usamos el inflater para crear la vista.
        View v = getLayoutInflater().inflate(R.layout.fragment_size_dialog, null);
        EditText etSizeDialog = v.findViewById(R.id.et_size_dialog);
        etSizeDialog.setText(String.valueOf(sizeParam));

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v);

        // En el botón de aceptar, no hacemos nada, porque vamos a consultar sus datos.
        // En el botón de cancelar, cerramos el diálogo.
        builder.setTitle("Hola")
                .setPositiveButton(R.string.btnd_aceptar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (etSizeDialog.getText().toString().isEmpty()) {
                            //Snackbar.make(v, "Error vacio", Snackbar.LENGTH_LONG).show();
                            Toast.makeText(getActivity(), "Error vacio", Toast.LENGTH_LONG).show();
                        } else {
                            listener.onAceptarDatosListener(Integer.parseInt(etSizeDialog.getText().toString()));
                        }
                    }
                })
                .setNegativeButton(R.string.btnd_cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Cerramos el diálogo.
                        dialogInterface.dismiss();
                    }
                });

        AlertDialog ad = builder.create();
        ad.setCanceledOnTouchOutside(false);

        return ad;
    }

    // Este método es para que el listener sea el que implementa la interfaz.
    // En caso de que no lo implemente, lanzamos una excepción.
    @Override
    public void onAttach(@NonNull Context context) {
        // No olvidar llamar al método de la superclase.
        super.onAttach(context);
        // Comprobamos que el contexto implementa la interfaz.
        // Si no lo implementa, lanzamos una excepción.
        if (context instanceof OnDatosListener) {
            listener = (OnDatosListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + getString(R.string.error_onAttach));
        }
    }

    // Este método es para que el listener sea nulo cuando se desatache el fragmento.
    // Si no lo hacemos, el listener no se desatachará y podremos tener problemas.
    @Override
    public void onDetach() {
        if (listener != null) {
            listener = null;
        }
        // No olvidar llamar al método de la superclase.
        super.onDetach();
    }
}