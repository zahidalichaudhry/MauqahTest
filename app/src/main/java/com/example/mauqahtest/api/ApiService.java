package com.example.mauqahtest.api;


import com.example.mauqahtest.model.ArticleModel;
import com.example.mauqahtest.model.general.GeneralResponseModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;;

public interface ApiService {
    @GET("mostviewed/all-sections/7.json?api-key=sKu1UKq4yi2G3UFYGs3z7QWiv4AUGuMO")
    Call<GeneralResponseModel<ArrayList<ArticleModel>>> getMostpopularArticles();
}
