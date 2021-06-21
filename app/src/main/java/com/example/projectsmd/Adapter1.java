package com.example.projectsmd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter1 extends ArrayAdapter<Mcq> {

    public Adapter1(Context context, int resource,  List<Mcq> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Mcq temp_mcq= new Mcq();

        temp_mcq = getItem(position);

        if(convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mcqs_cell , parent ,false);
        }

        TextView st;
        TextView op1;
        TextView op2;
        TextView op3;
        TextView op4;

        st = convertView.findViewById(R.id.mcq_question_statement);
        op1=convertView.findViewById(R.id.op1);
        op2=convertView.findViewById(R.id.op2);
        op3=convertView.findViewById(R.id.op3);
        op4=convertView.findViewById(R.id.op4);

        st.setText(temp_mcq.getStatement());
        op1.setText(temp_mcq.getOption1());
        op2.setText(temp_mcq.getOption2());
        op3.setText(temp_mcq.getOption3());
        op4.setText(temp_mcq.getOption4());

        return convertView;



    }

    public void updateList(){

        notifyDataSetChanged();
    }
}
