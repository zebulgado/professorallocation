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

public class DepartamentActivity extends AppCompatActivity {

    ArrayList<Departament> listDepartament;
    private ArrayAdapter manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departament);

        ListView listView = findViewById(R.id.listView);

        listDepartament = new ArrayList<>();
        manager = new DepartamentAdapter(this, R.layout.item_view_departament, listDepartament);

        listView.setAdapter(manager);

        RetrofitConfig retrofitConfig = new RetrofitConfig();
        Call<List<Departament>> call = retrofitConfig.getDepartamentService().getAllDepartaments();

        call.enqueue(new Callback<List<Departament>>() {
            @Override
            public void onResponse(Call<List<Departament>> call, Response<List<Departament>> response) {
                List<Departament> Departaments = response.body();

                ArrayList<Departament> novalista = new ArrayList<>(Departaments);
                listDepartament.addAll(novalista);

                manager.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Departament>> call, Throwable t) {
                Toast.makeText(DepartamentActivity.this, "Sua request falhou!", Toast.LENGTH_LONG).show();
            }
        });
    }
}