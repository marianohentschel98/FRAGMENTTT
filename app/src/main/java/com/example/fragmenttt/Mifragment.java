package com.example.fragmenttt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Mifragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    public Mifragment() {

    }

    public static Mifragment newInstance(String param1) {
        Mifragment fragment = new Mifragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mifragment, container, false);

        TextView textView = rootView.findViewById(R.id.textViewFragment);

        if (mParam1 != null) {
            textView.setText(mParam1);
        }

        return rootView;
    }

    public void actualizarTexto(String texto) {
        mParam1 = texto;
        if (getView() != null) {
            TextView textView = getView().findViewById(R.id.textViewFragment);
            textView.setText(texto);
        }
    }
}