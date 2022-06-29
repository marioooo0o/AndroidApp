package com.example.clientside;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SliderViewer extends Activity implements AdapterView.OnItemSelectedListener {
    private ImageView iv_display;
    private Spinner spinner;
    private Button btn_first, btn_right, btn_left, btn_last;
    private int current_image_index;
    private List<Slide> slides;
    private List<String> names = new ArrayList<>();
    private List<String> namesShort= new ArrayList<>();
    public static boolean isAuthorize = false;
    private Lecture lecture;
    /*
     *
     * Alert Dialog
     */
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private TextView warning;
    private Button btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_viewer);
        getLectureDetails();
    }

    private void getLectureDetails() {
        Long id = getIntent().getLongExtra(LectureListAdapter.LECTURE_KEY, 0);
        if(id != 0) {
            //String url = "http://localhost:8080/lectures/"+id.toString();
            Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.103:8080/").addConverterFactory(GsonConverterFactory.create()).build();
            LectureApi lectureApi = retrofit.create(LectureApi.class);
            lectureApi.singleLecture(id).enqueue(new Callback<Lecture>() {
                @Override
                public void onResponse(Call<Lecture> call, Response<Lecture> response) {
                    lecture = response.body();
                    slides= response.body().getSlides();
                    for (Slide slide: slides
                         ) {
                        byte[] byteArray = slide.getImage().getBytes();
                        byte[] bytes = Base64.decode(slide.getImage(),Base64.DEFAULT);
                        slide.setImageBitmap(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
                        names.add(slide.getTitle());
                    }
                    System.arraycopy(names, 0, namesShort, 0, 5);
                    DisplayImage();
                    setShortArray();
                    SwitchButton();

                }

                @Override
                public void onFailure(Call<Lecture> call, Throwable t) {
                    Toast.makeText(SliderViewer.this, "ERROR: " + t.getMessage(), Toast.LENGTH_LONG).show();
                    Log.e("ERROR47", t.getMessage());
                }
            });
        }
    }

    void setShortArray(){
        for(int i = 0; i < 5; i++){
            namesShort.add(names.get(i));
        }
    }
    void DisplayImage(){
        iv_display = (ImageView)findViewById(R.id.iv_display);
        current_image_index = 0;
        iv_display.setImageBitmap(slides.get(current_image_index).getImageBitmap());
    }
    void SwitchButton(){
        btn_first = (Button)findViewById(R.id.btn_first);
        btn_left = (Button)findViewById(R.id.btn_left);
        spinner = (Spinner)findViewById(R.id.spinner);
        btn_right = (Button)findViewById(R.id.btn_right);
        btn_last = (Button)findViewById(R.id.btn_last);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, namesShort);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        btn_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_image_index = 0;
                spinner.setSelection(current_image_index);
                iv_display.setImageBitmap(slides.get(current_image_index).getImageBitmap());
            }
        });

        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_image_index++;
                if(current_image_index == 5 && !isAuthorize) {
                    createNewPopUPDialog();
                    current_image_index = 4;
                }
                else{
                    current_image_index = current_image_index % slides.size();
                    spinner.setSelection(current_image_index);
                    iv_display.setImageBitmap(slides.get(current_image_index).getImageBitmap());
                }
                if(isAuthorize){
                    adapter.clear();
                    adapter.addAll(names);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_image_index--;
                if(current_image_index < 0){
                    if(!isAuthorize){
                        current_image_index = 5;
                    }else{
                        current_image_index = slides.size()-1;
                    }
                }
                spinner.setSelection(current_image_index);
                iv_display.setImageBitmap(slides.get(current_image_index).getImageBitmap());
            }
        });

        btn_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isAuthorize){
                    current_image_index = 5;

                }else{
                    current_image_index = slides.size()-1;
                }
                spinner.setSelection(current_image_index);
                iv_display.setImageBitmap(slides.get(current_image_index).getImageBitmap());
                }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        current_image_index = position;
        iv_display.setImageBitmap(Bitmap.createScaledBitmap(slides.get(current_image_index).getImageBitmap(), iv_display.getWidth(), iv_display.getHeight(), false));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void createNewPopUPDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopUpView = getLayoutInflater().inflate(R.layout.popup, null);
        btn_login = (Button) contactPopUpView.findViewById(R.id.btn_login);

        dialogBuilder.setView(contactPopUpView);
        dialog = dialogBuilder.create();
        dialog.show();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SliderViewer.this, Login.class);
                startActivity(intent);
                dialog.hide();
            }
        });
    }
}