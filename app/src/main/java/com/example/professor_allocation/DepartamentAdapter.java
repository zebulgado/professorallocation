package com.example.professor_allocation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DepartamentAdapter extends ArrayAdapter<Departament> {

    private Context context;
    private ArrayList<Departament> listDepartament;
    private int layout;


    public DepartamentAdapter(@NonNull Context context, int layout, ArrayList<Departament> listDepartament) {
        super(context, layout, listDepartament);
        this.context = context;
        this.listDepartament = listDepartament;
        this.layout = layout;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(layout, parent,false);
        }

        Departament departament = listDepartament.get(position);
        TextView tvDepartamentName = itemView.findViewById(R.id.tv_departament_name);
        tvDepartamentName.setText(departament.getName());
        return itemView;
    }
}
