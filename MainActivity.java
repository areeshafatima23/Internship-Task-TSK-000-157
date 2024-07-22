package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Task> tasks;
    private TaskAdapter taskAdapter;
    private ListView listViewTasks;
    private EditText editTextTask;
    private Button buttonAdd, buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasks = new ArrayList<>();
        taskAdapter = new TaskAdapter(this, tasks);

        listViewTasks = findViewById(R.id.listViewTasks);
        listViewTasks.setAdapter(taskAdapter);

        editTextTask = findViewById(R.id.editTextTask);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonDelete = findViewById(R.id.buttonDelete);

        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = editTextTask.getText().toString();
                if (!taskName.isEmpty()) {
                    Task task = new Task(taskName);
                    tasks.add(task);
                    taskAdapter.notifyDataSetChanged();
                    editTextTask.setText("");
                    listViewTasks.startAnimation(fadeIn); // Apply animation
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = tasks.size() - 1; i >= 0; i--) {
                    if (tasks.get(i).isDone()) {
                        tasks.remove(i);
                    }
                }
                taskAdapter.notifyDataSetChanged();
            }
        });

        listViewTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task task = tasks.get(position);
                Intent intent = new Intent(MainActivity.this, TaskDetailActivity.class);
                intent.putExtra("TASK_DETAIL", task.getName());
                startActivity(intent);
            }
        });
    }
}
