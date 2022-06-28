package com.example.clientside;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends Activity {
    protected Button btn_slider_viewer, btn_java_tools;
    protected TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_slider_viewer = (Button)findViewById(R.id.btn_slider_viewer);
        btn_java_tools = (Button)findViewById(R.id.btn_java_tool);
        switchButton();
    }
    void switchButton(){
        btn_slider_viewer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChooseLecture.class);
                startActivity(intent);
            }
        });

        btn_java_tools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChooseCategory.class);
                startActivity(intent);
            }
        });
    }
}