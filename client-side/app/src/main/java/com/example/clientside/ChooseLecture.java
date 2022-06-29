package com.example.clientside;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


public class ChooseLecture extends AppCompatActivity {
    private TextView textView47;
    private RecyclerView recyclerView;
    private List<Lecture> lectures;
    private LectureListAdapter lectureListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_lecture);
        setAdapter();
        textView47 = (TextView) findViewById(R.id.btn_lecture1);
        String url = "http://localhost:8080/lectures";
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.103:8080/").addConverterFactory(JacksonConverterFactory.create(Mapper.get())).build();
        LectureApi lectureApi = retrofit.create(LectureApi.class);
        lectureApi.listLecture().enqueue(new Callback<List<Lecture>>() {
            @Override
            public void onResponse(Call<List<Lecture>> call, Response<List<Lecture>> response) {
                lectures = response.body();
                Toast.makeText(ChooseLecture.this, "Success!", Toast.LENGTH_LONG).show();
                lectureListAdapter.setLectureList(lectures);
            }

            @Override
            public void onFailure(Call<List<Lecture>> call, Throwable t) {
                Toast.makeText(ChooseLecture.this, "ERROR: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setAdapter() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.lectureListAdapter = new LectureListAdapter(this);

        recyclerView.setAdapter(lectureListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
