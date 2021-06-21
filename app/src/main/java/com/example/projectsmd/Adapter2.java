package com.example.projectsmd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapter2 extends ArrayAdapter<String> {

    public Adapter2( Context context, int resource,  List<String> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        String st = getItem(position);

        if(convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.quiz2_display, parent , false);


        }

        TextView statement;
        EditText ans;

        statement = convertView.findViewById(R.id.q2_statement);
        ans = convertView.findViewById(R.id.ans2);
        //ans =convertView.
        statement.setText(st);
        ans.setText("");


        return convertView;

    }

    public void updateList(){

        notifyDataSetChanged();
    }
}
