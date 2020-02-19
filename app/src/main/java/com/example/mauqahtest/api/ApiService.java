package com.example.mauqahtest.api;


import com.example.mauqahtest.model.ArticleModel;
import com.example.mauqahtest.model.general.GeneralResponseModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;;

public interface ApiService {
    @GET("svc/mostpopular/v2/viewed/7.json")
    Call<GeneralResponseModel<ArrayList<ArticleModel>>> getMostpopularArticles(@Query("api-key") String apiKey);

//    ?api-key=sKu1UKq4yi2G3UFYGs3z7QWiv4AUGuMO
//@Query("api-key") String apiKey
}
