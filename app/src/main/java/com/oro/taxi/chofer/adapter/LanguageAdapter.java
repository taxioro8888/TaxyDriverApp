package com.oro.taxi.chofer.adapter;

/**
 * Created by Woumtana on 01/12/2016.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.oro.taxi.chofer.R;
import com.oro.taxi.chofer.model.LanguagePojo;

import java.util.List;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.MyViewHolder> {

    private Context mContext;
    private List<LanguagePojo> albumList;
    Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        private TextView name_language;
        private LinearLayout linear;
        private ImageView img_language;


        public MyViewHolder(View view) {
            super(view);
            name_language = (TextView) view.findViewById(R.id.name_language);
            img_language = (ImageView) view.findViewById(R.id.img_language);
            linear = (LinearLayout) view.findViewById(R.id.linear);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

    public LanguageAdapter(Context mContext, List<LanguagePojo> albumList, Activity activity) {
        this.mContext = mContext;
        this.albumList = albumList;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card_language, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final LanguagePojo languagePojo = albumList.get(position);
        holder.name_language.setText(languagePojo.getName());
        holder.img_language.setImageDrawable(languagePojo.getImage());
        if(languagePojo.getStatus().equals("yes")) {
            holder.linear.setBackground(mContext.getResources().getDrawable(R.drawable.custom_driver_select));
        }else
            holder.linear.setBackground(null);
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguagePojo languagePojo = albumList.get(position);
                languagePojo.setStatus("yes");
                for(int i=0; i<albumList.size(); i++){
                    if(albumList.get(i).getId() != languagePojo.getId())
                        albumList.get(i).setStatus("no");
                }
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public void delete(int position){
        albumList.remove(position);
        notifyItemRemoved(position);
        return;
    }

    public LanguagePojo getCategorieVehicle(int id){
        LanguagePojo languagePojo = null;
        for (int i=0; i< albumList.size(); i++){
            if(albumList.get(i).getId() == id){
                languagePojo = albumList.get(i);
                break;
            }
        }
        return languagePojo;
    }
}