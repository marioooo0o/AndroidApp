package com.example.clientside;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LectureApi {
    @GET("lectures")
    Call<List<Lecture>> listLecture();

    @GET("lectures/{id}")
    Call <Lecture> singleLecture(@Path("id") Long id);
}
