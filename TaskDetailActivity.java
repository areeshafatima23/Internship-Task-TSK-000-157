package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TaskDetailActivity extends AppCompatActivity {

    private TextView textViewTaskDetail;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        textViewTaskDetail = findViewById(R.id.textViewTaskDetail);
        buttonBack = findViewById(R.id.buttonBack);

        String taskDetail = getIntent().getStringExtra("TASK_DETAIL");
        textViewTaskDetail.setText(taskDetail);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

