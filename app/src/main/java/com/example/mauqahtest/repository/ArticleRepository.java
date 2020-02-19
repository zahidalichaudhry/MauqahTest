package com.example.mauqahtest.repository;

import android.app.Application;

import com.example.mauqahtest.api.ApiClientModule;
import com.example.mauqahtest.api.ApiUtils;
import com.example.mauqahtest.model.ArticleModel;
import com.example.mauqahtest.model.general.GeneralResponseModel;
import com.example.mauqahtest.utils.IHandleAPICallBack;
import com.example.mauqahtest.utils.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepository {
    private static final String TAG = "ArticleRepository";
    private NetworkUtils network;
    private static ArticleRepository instance = null;

    private Call<GeneralResponseModel<ArrayList<ArticleModel>>> getPopularAticleList;
    private ApiClientModule apiClientModule = new ApiClientModule();


    private ArticleRepository(Application application) {
        network = new NetworkUtils(application);
    }

    public static ArticleRepository getInstance(Application application) {
        if (instance == null) {
            instance = new ArticleRepository(application);
        }
        return instance;
    }

    public void getMostPopularArtiles(final IHandleAPICallBack handler) {

        if (!network.isConnectedToInternet()) {
            handler.onConnectionError();
            return;
        }
        try {

            getPopularAticleList = apiClientModule.getApiService().getMostpopularArticles(ApiUtils.APIKEY);

            getPopularAticleList.enqueue(new Callback<GeneralResponseModel<ArrayList<ArticleModel>>>() {
                @Override
                public void onResponse(Call<GeneralResponseModel<ArrayList<ArticleModel>>> call, Response<GeneralResponseModel<ArrayList<ArticleModel>>> response) {
                    if (response.isSuccessful()) {
//                        if (response.body().getStatus() == "OK") {
                            handler.handleWebserviceCallBackSuccess(response);
//                        } else {
//                            handler.handleWebserviceCallBackFailure("Something went wrong");
//                        }
                    } else {
                        // Handle error returned from server
                        handler.handleWebserviceCallBackFailure(response.errorBody().toString());
                    }
                }

                @Override
                public void onFailure(Call<GeneralResponseModel<ArrayList<ArticleModel>>> call, Throwable t) {
                    t.printStackTrace();
                    handler.handleWebserviceCallBackFailure(t.getMessage());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            handler.handleWebserviceCallBackFailure(e.getMessage());

        }
    }

}
