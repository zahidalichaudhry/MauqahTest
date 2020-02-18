package com.example.mauqahtest.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mauqahtest.R;
import com.example.mauqahtest.databinding.ItemArticleBinding;
import com.example.mauqahtest.model.ArticleModel;


import java.util.ArrayList;


/**
 * Created by CH-Hamza on 2/21/2018.
 */


public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.MyViewHolder> {
    ArrayList<ArticleModel> arrayList = new ArrayList<>();
    Activity activity;
    private OnItemClicked onItemClicked;


    public  interface OnItemClicked {
        void OnItemClicked(ArticleModel articleModel);
    }

    public ArticleListAdapter(ArrayList<ArticleModel> arrayList, Context context, OnItemClicked onItemClicked) {
        activity = (Activity) context;
        this.arrayList = arrayList;
        this.onItemClicked = onItemClicked;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemArticleBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(activity),
                R.layout.item_article,
                parent, false);
        return new MyViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        ArticleModel articleModel = arrayList.get(position);

        holder.binding.setArticlemodel(articleModel);
        if (articleModel != null && articleModel.getMedia().get(0).getMediametadata()!= null && articleModel.getMedia().get(0).getMediametadata().size()!= 0) {
            Glide.with(activity)
                    .load(articleModel.getMedia().get(0).getMediametadata().get(0).getUrl())
                    .into(holder.binding.imgArticle);
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClicked!=null){
                    onItemClicked.OnItemClicked(arrayList.get(position));
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ItemArticleBinding binding;

        public MyViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

    }
    public void setDataChanged(ArrayList<ArticleModel> driversModels){
        arrayList = driversModels;
        notifyDataSetChanged();
    }
}


