package com.dam.actividaduf4_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InicioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InicioFragment extends Fragment {

    public InicioFragment() {
        // Required empty public constructor
    }

    public static InicioFragment newInstance() {
        return new InicioFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);
        TextView tv = view.findViewById(R.id.tv_fl_inicio);
        // Establecemos el tamaño del texto al textView.
        // Este es el del InicioFragment, que es tamaño fijo.
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
        return view;
    }
}