package com.example.clientside;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ChooseCategory extends AppCompatActivity {
    private TextView textView;
    private RecyclerView recyclerView;
    private List<Category> categoryList;
    private CategoryListAdapter categoryListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);
        setAdapter();
        textView = (TextView) findViewById(R.id.choose_category_text_view);
        String url = "http://localhost:8080/categories";

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.103:8080/").addConverterFactory(JacksonConverterFactory.create(Mapper.get())).build();
        CategoryApi categoryApi = retrofit.create(CategoryApi.class);
        categoryApi.listCategories().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                categoryList = response.body();
                Toast.makeText(ChooseCategory.this, "Success!", Toast.LENGTH_LONG).show();
                categoryListAdapter.setCategoryList(categoryList);
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Toast.makeText(ChooseCategory.this, "ERROR: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setAdapter() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.categoryListAdapter = new CategoryListAdapter(this);

        recyclerView.setAdapter(categoryListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}