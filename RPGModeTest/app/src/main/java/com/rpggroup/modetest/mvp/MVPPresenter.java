package com.rpggroup.modetest.mvp;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by bb on 2017/2/23.
 */

public class MVPPresenter implements MVPContract.Presenter, IDataSource.OnGetDataCallback {

    private final MVPContract.View mView;
    private final IDataSource remoteDataSource;
    private final IDataSource localDataSource;
    private Handler mainHandler;

    public MVPPresenter(@NonNull MVPContract.View view, @NonNull IDataSource remoteDataSource, @NonNull IDataSource localDataSource) {
        this.mView = view;
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        mainHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void loadDataFromServer() {
        Log.d("MVP", "从远程开始加载资源");
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
               mView.showLoading();
            }
        });
        remoteDataSource.getData(this);

    }

    @Override
    public void loadDataFromLocal() {
        Log.d("MVP", "从远程开始加载资源");
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                mView.showLoading();
            }
        });
        localDataSource.getData(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void onGetDataSuccessed(final String data) {
        Log.d("MVP", "加载资源成功 资源: " + data);
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                mView.hideLoading();
                mView.showData(data);
            }
        });
    }

    @Override
    public void onGetDataFailed(final int errorCode) {
        Log.d("MVP", "加载资源失败 错误原因: " + errorCode);
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                mView.hideLoading();
                mView.showLoadErrorView(errorCode);
            }
        });
    }
}
