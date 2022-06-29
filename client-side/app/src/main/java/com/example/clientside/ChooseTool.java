package com.example.clientside;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChooseTool extends AppCompatActivity {
    private TextView textView;
    private RecyclerView recyclerView;
    private Category category;
    private ToolListAdapter toolListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_tool);
        setAdapter();
        textView = (TextView) findViewById(R.id.choose_tool_text_view);

        getCategoryDetails();

    }
    private void getCategoryDetails(){
        Long id = getIntent().getLongExtra(CategoryListAdapter.CATEGORY_KEY, 0);
        if(id != 0){
            Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.103:8080/").addConverterFactory(GsonConverterFactory.create()).build();
            CategoryApi categoryApi = retrofit.create(CategoryApi.class);
            categoryApi.singleCategory(id).enqueue(new Callback<Category>() {
                @Override
                public void onResponse(Call<Category> call, Response<Category> response) {
                    category = response.body();
                    textView.setText(category.getTitle());
                    toolListAdapter.setToolList(category.getTools());
                }

                @Override
                public void onFailure(Call<Category> call, Throwable t) {
                    Toast.makeText(ChooseTool.this, "ERROR: " + t.getMessage(), Toast.LENGTH_LONG).show();
                    Log.e("ERROR47", t.getMessage());
                }
            });
        }
    }

    private void setAdapter() {
        recyclerView = (RecyclerView) findViewById(R.id.tool_recycler_view);
        this.toolListAdapter = new ToolListAdapter(this);

        recyclerView.setAdapter(toolListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}