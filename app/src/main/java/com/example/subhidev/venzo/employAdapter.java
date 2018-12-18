package com.example.subhidev.venzo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class employAdapter extends RecyclerView.Adapter<employAdapter.MyViewHolder> {
    private Context mcontext;
    private  ArrayList<SaveData> employList;
    public employAdapter(Context con, ArrayList<SaveData> list){
        this.mcontext=con;
        this.employList=list;

    }
    @NonNull
    @Override
    public employAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_employ,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull employAdapter.MyViewHolder holder, int position) {
        holder.idTxtview.setText(employList.get(position).getEmployeeid());
        holder.nameTxtview.setText(employList.get(position).getEmployeename());
        holder.degreeTxtview.setText(employList.get(position).getEducation());
        holder.collegeTxtview.setText(employList.get(position).getUniversity());
        holder.yearTxtview.setText(employList.get(position).getPassing());
        holder.emp1Txtview.setText(employList.get(position).getEmployer1());
        holder.durationTxtview.setText(employList.get(position).getDuration());


    }

    @Override
    public int getItemCount() {
        return  employList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView idTxtview,nameTxtview,degreeTxtview,collegeTxtview,yearTxtview,emp1Txtview,durationTxtview;

        public MyViewHolder(View itemView) {
            super(itemView);
            idTxtview=(TextView)itemView.findViewById(R.id.txt1);
            nameTxtview=(TextView)itemView.findViewById(R.id.txt2);
            degreeTxtview=(TextView)itemView.findViewById(R.id.txt3);
            collegeTxtview=(TextView)itemView.findViewById(R.id.txt4);
            yearTxtview=(TextView)itemView.findViewById(R.id.txt5);
            emp1Txtview=(TextView)itemView.findViewById(R.id.txt6);
            durationTxtview=(TextView)itemView.findViewById(R.id.txt7);


        }
    }
}
