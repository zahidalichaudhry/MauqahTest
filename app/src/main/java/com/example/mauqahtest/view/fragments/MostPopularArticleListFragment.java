package com.example.mauqahtest.view.fragments;


import android.location.Location;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mauqahtest.R;
import com.example.mauqahtest.adapters.ArticleListAdapter;
import com.example.mauqahtest.databinding.FragmentMostPopularArticleListBinding;
import com.example.mauqahtest.model.ArticleModel;
import com.example.mauqahtest.model.general.GeneralResponseModel;
import com.example.mauqahtest.utils.Resource;
import com.example.mauqahtest.utils.Status;
import com.example.mauqahtest.view.MostPopularArticleActivity;
import com.example.mauqahtest.viewmodel.MostPopularArticleViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class MostPopularArticleListFragment extends Fragment implements ArticleListAdapter.OnItemClicked {

    private MostPopularArticleViewModel mViewModel;
    private FragmentMostPopularArticleListBinding binding;
    private ArticleListAdapter adapter;
    private ArrayList<ArticleModel> articleModels = new ArrayList<>();

    public MostPopularArticleListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_most_popular_article_list, container, false);
        adapter = new ArticleListAdapter(articleModels,getContext(),this);
        binding.rvArticles.setAdapter(adapter);
        mViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(MostPopularArticleViewModel.class);
        mViewModel.init();
        mViewModel.getPopularArticles();
        return binding.getRoot();


    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel.getPopularArticlesData().observe(getActivity(), new Observer<Resource<GeneralResponseModel<ArrayList<ArticleModel>>>>() {
            @Override
            public void onChanged(Resource<GeneralResponseModel<ArrayList<ArticleModel>>> response) {
                if (response.getStatus() == Status.status.SUCCESS) {
                    ((MostPopularArticleActivity) Objects.requireNonNull(getActivity())).showHidePleaseWaitDialog(1);
                    adapter.setDataChanged(response.getData().getData());

                } else if (response.getStatus() == Status.status.ERROR) {
                    ((MostPopularArticleActivity) Objects.requireNonNull(getActivity())).showHidePleaseWaitDialog(1);
                    Toast.makeText(getContext(),response.getMessage(),Toast.LENGTH_SHORT).show();

                } else if (response.getStatus() == Status.status.LOADING) {
                    ((MostPopularArticleActivity) Objects.requireNonNull(getActivity())).showHidePleaseWaitDialog(0);

                }
            }
        });

    }

    @Override
    public void OnItemClicked(ArticleModel articleModel) {
        mViewModel.setArticleModel(articleModel);
        Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.list_article_to_details_action);

    }
}
