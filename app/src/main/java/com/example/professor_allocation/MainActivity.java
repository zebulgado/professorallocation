package com.example.professor_allocation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<Course> listCourse;
    private ArrayAdapter manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        listCourse = new ArrayList<>();
        manager = new CourseAdapter(this, R.layout.item_view, listCourse);

        listView.setAdapter(manager);

        RetrofitConfig retrofitConfig = new RetrofitConfig();
        Call<List<Course>> call = retrofitConfig.getCursoService().getAllCourses();

        call.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                List<Course> courses = response.body();


                ArrayList<Course> novalista = new ArrayList<>(courses);
                listCourse.addAll(novalista);

                manager.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Sua request falhou!", Toast.LENGTH_LONG).show();
            }
        });
    }
}