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
 * Use the {@link PythonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PythonFragment extends Fragment {

    private static final String SIZE_PARAM = "size";

    private int sizeParam;

    public PythonFragment() {
        // Required empty public constructor
    }

    public static PythonFragment newInstance(int size) {
        PythonFragment fragment = new PythonFragment();
        Bundle args = new Bundle();
        args.putInt(SIZE_PARAM, size);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            sizeParam = getArguments().getInt(SIZE_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_python, container, false);
        TextView tv = view.findViewById(R.id.tv_fl_python);
        // Estos no son tamaño fijo, sino que se establecen en función del parámetro sizeParam.
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizeParam);
        return view;
    }
}