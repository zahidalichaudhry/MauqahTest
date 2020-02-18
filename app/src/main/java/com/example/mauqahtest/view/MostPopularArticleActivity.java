package com.example.mauqahtest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import com.example.mauqahtest.R;
import com.example.mauqahtest.viewmodel.MostPopularArticleViewModel;

import dmax.dialog.SpotsDialog;

public class MostPopularArticleActivity extends AppCompatActivity {

    AlertDialog pleaseWaitDialog;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = MostPopularArticleActivity.this;

        setContentView(R.layout.activity_most_popular_article);
        pleaseWaitDialog = new SpotsDialog(context, R.style.SpotDialogTheme);

    }
    public void showHidePleaseWaitDialog(int i) {
        if (i == 0) {
            pleaseWaitDialog.setCancelable(false);
            pleaseWaitDialog.show();
        } else if (i == 1) {
            pleaseWaitDialog.dismiss();
        }
    }
}
