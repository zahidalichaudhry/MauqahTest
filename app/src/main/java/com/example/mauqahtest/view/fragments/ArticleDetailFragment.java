package com.example.mauqahtest.view.fragments;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mauqahtest.R;
import com.example.mauqahtest.databinding.FragmentArticleDetailBinding;
import com.example.mauqahtest.databinding.FragmentMostPopularArticleListBinding;
import com.example.mauqahtest.model.ArticleModel;
import com.example.mauqahtest.model.general.GeneralResponseModel;
import com.example.mauqahtest.utils.Resource;
import com.example.mauqahtest.utils.Status;
import com.example.mauqahtest.view.MostPopularArticleActivity;
import com.example.mauqahtest.viewmodel.MostPopularArticleViewModel;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleDetailFragment extends Fragment {
    private MostPopularArticleViewModel mViewModel;
    private FragmentArticleDetailBinding binding;
    public ArticleDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_article_detail, container, false);
        mViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(MostPopularArticleViewModel.class);

        mViewModel.init();
        binding.setMViewModel(mViewModel);

        if (mViewModel.getArticleModel() != null && mViewModel.getArticleModel().getMedia().get(0).getMediametadata()!= null && mViewModel.getArticleModel().getMedia().get(0).getMediametadata().size()!= 0) {
            Glide.with(Objects.requireNonNull(getActivity()))
                    .load(mViewModel.getArticleModel().getMedia().get(0).getMediametadata().get(0).getUrl())
                    .into(binding.imgArticle);
        }else {
            binding.imgArticle.setVisibility(View.GONE);
        }
        return binding.getRoot();
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

}
