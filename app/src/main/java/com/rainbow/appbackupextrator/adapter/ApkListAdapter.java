package com.rainbow.appbackupextrator.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rainbow.appbackupextrator.model.ApkListModel;
import com.rainbow.appbackupextrator.R;

import java.util.ArrayList;

/**
 * Created by Avinash on 3/1/2020.
 */

public class ApkListAdapter extends RecyclerView.Adapter<ApkListAdapter.APKViewHolder> {

    Context context;
    ArrayList<ApkListModel> apkListModels;
    OnItemClickListener ocl;


    public ApkListAdapter(Context context, ArrayList<ApkListModel> apkListModels, OnItemClickListener ocl) {
        this.context = context;
        this.apkListModels = apkListModels;
        this.ocl = ocl;
    }


    @Override
    public APKViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.apk_list_item, parent, false);
        return new APKViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final APKViewHolder holder, final int position) {

        final ApkListModel model = apkListModels.get(position);
        holder.tvname.setText(model.getName());
        holder.imgIcon.setImageDrawable(model.getIconPath());
        holder.onItemClickListener = ocl;
        holder.tvname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.onItemClickListener.onItemClick(position, model);
            }
        });
        holder.imgIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.onItemClickListener.onItemClick(position, model);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (apkListModels == null)
            return 0;

        return apkListModels.size();
    }

    public interface OnItemClickListener {
        public void onItemClick(int position, ApkListModel model);

    }

    public static class APKViewHolder extends RecyclerView.ViewHolder {

        TextView tvname;
        ImageView imgIcon;
        OnItemClickListener onItemClickListener;

        public APKViewHolder(View itemView) {
            super(itemView);
            tvname = (TextView) itemView.findViewById(R.id.app_name);
            imgIcon = (ImageView) itemView.findViewById(R.id.app_icon_img);

            //onItemClickListener = ocl;
        }
    }
}
