package com.example.professor_allocation;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CourseService {

    @GET("course")
    Call<List<Course>> getAllCourses();
}
