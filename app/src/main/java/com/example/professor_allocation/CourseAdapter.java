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

public class CourseAdapter extends ArrayAdapter<Course> {

    private Context context;
    private ArrayList<Course> listCourses;
    private int layout;


    public CourseAdapter(@NonNull Context context, int layout, ArrayList<Course> listCourses) {
        super(context, layout, listCourses);
        this.context = context;
        this.listCourses = listCourses;
        this.layout = layout;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(layout, parent,false);
        }

        Course course = listCourses.get(position);
        TextView tvNomeProfessor = itemView.findViewById(R.id.tv_professor_name);
        tvNomeProfessor.setText(course.getName());
        return itemView;
    }
}
