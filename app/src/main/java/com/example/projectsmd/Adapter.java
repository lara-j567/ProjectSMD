package com.example.projectsmd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Adapter extends ArrayAdapter<Mcq> {


    public Adapter(@NonNull Context context, int resource, @NonNull List<Mcq> objects) {
        super(context, resource, objects);
    }

    public View getView(int position , View convertview , ViewGroup parent){

        Mcq mcq_obj=getItem(position);

        if(convertview==null){

            convertview = LayoutInflater.from(getContext()).inflate(R.layout.mcqs_cell , parent , false);
        }

        TextView statement;
        TextView op1 ;
        TextView op2;
        TextView op3;
        TextView op4;

        statement = convertview.findViewById(R.id.mcq_question_statement);
        op1= convertview.findViewById(R.id.op1);
        op2= convertview.findViewById(R.id.op2);
        op3= convertview.findViewById(R.id.op3);
        op4= convertview.findViewById(R.id.op4);

        return convertview;


    }

    public void updateList(){

        notifyDataSetChanged();
    }

}
