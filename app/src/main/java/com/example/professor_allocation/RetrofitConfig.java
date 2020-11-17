package com.example.professor_allocation;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private Retrofit retrofit;

    public RetrofitConfig() {

        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://professor-allocation.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public CourseService getCursoService(){
        return retrofit.create(CourseService.class);
    }

    public DepartamentService getDepartamentService(){
        return retrofit.create(DepartamentService.class);
    }




}
