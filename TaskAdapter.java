package com.example.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TaskAdapter extends ArrayAdapter<Task> {
    public TaskAdapter(@NonNull Context context, @NonNull ArrayList<Task> tasks) {
        super(context, 0, tasks);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.task_item, parent, false);
        }

        Task task = getItem(position);
        TextView textViewTask = convertView.findViewById(R.id.textViewTask);
        CheckBox checkBox = convertView.findViewById(R.id.checkBox);

        textViewTask.setText(task.getName());
        checkBox.setChecked(task.isDone());

        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> task.setDone(isChecked));

        return convertView;
    }
}
