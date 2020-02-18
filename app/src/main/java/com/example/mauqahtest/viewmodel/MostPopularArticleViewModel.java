package com.example.mauqahtest.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.mauqahtest.model.ArticleModel;
import com.example.mauqahtest.model.general.GeneralResponseModel;
import com.example.mauqahtest.repository.ArticleRepository;
import com.example.mauqahtest.utils.IHandleAPICallBack;
import com.example.mauqahtest.utils.Resource;
import com.example.mauqahtest.utils.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Response;

public class MostPopularArticleViewModel extends AndroidViewModel {
    private ArticleRepository articleRepository;

    private MutableLiveData<Resource<GeneralResponseModel<ArrayList<ArticleModel>>>> mostPopularArticlelistLiveData;

    private ArticleModel articleModel;

    public MostPopularArticleViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        if(articleRepository == null) {
            articleRepository = ArticleRepository.getInstance(getApplication());
        }
        if (mostPopularArticlelistLiveData == null) {
            mostPopularArticlelistLiveData = new MutableLiveData<>();
        }
    }
    public MutableLiveData<Resource<GeneralResponseModel<ArrayList<ArticleModel>>>> getPopularArticlesData() {
        return mostPopularArticlelistLiveData;
    }


    public void getPopularArticles() {
        mostPopularArticlelistLiveData.setValue(new Resource<GeneralResponseModel<ArrayList<ArticleModel>>>(Status.status.LOADING,
                null, "Loading"));
        articleRepository.getMostPopularArtiles(
                new IHandleAPICallBack() {
                    @Override
                    public void handleWebserviceCallBackSuccess(Response response) {
                        Response<GeneralResponseModel<ArrayList<ArticleModel>>> mResponse = response;
                        mostPopularArticlelistLiveData.setValue(new Resource<GeneralResponseModel<ArrayList<ArticleModel>>>(Status.status.SUCCESS,
                                mResponse.body(), "Success"));
                    }

                    @Override
                    public void handleWebserviceCallBackFailure(String error) {
                        mostPopularArticlelistLiveData.setValue(new Resource<GeneralResponseModel<ArrayList<ArticleModel>>>(Status.status.ERROR,
                                null, error));
                    }

                    @Override
                    public void onConnectionError() {
                        mostPopularArticlelistLiveData.setValue(new Resource<GeneralResponseModel<ArrayList<ArticleModel>>>(Status.status.ERROR,
                                null, "Connection Error"));
                    }
                });
    }

    public ArticleModel getArticleModel() {
        return articleModel;
    }

    public void setArticleModel(ArticleModel articleModel) {
        this.articleModel = articleModel;
    }
}
