package com.example.worldskills.tsppspmobile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.worldskills.tsppspmobile.R;
import com.example.worldskills.tsppspmobile.models.Projecto;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private int layout;
    private ArrayList<Projecto>projectos;

    public MyAdapter(int layout, ArrayList<Projecto> projectos) {
        this.layout = layout;
        this.projectos = projectos;
    }


    @Override
    public int getCount() {
        return projectos.size();
    }

    @Override
    public Object getItem(int position) {
        return projectos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView= LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
            holder=new ViewHolder();
            holder.id=convertView.findViewById(R.id.content_id);
            holder.nombre=convertView.findViewById(R.id.content_nombre);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }

        Projecto projecto= (Projecto) getItem(position);
        holder.id.setText(projecto.getId()+"");
        holder.nombre.setText(projecto.getNombre());
        return convertView;
    }
    static class ViewHolder{
        TextView id,nombre;
    }
}
