package com.rpggroup.modetest.mvp;

import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.rpggroup.modetest.R;


public class MVPActivity extends AppCompatActivity implements MVPContract.View {

    private MVPContract.Presenter mPresenter;
    private TextView dataView;
    private TextView errorView;
    private View loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        mPresenter = new MVPPresenter(this, RemoteDataSource.getINstance(), LocalDataSource.getInstance());

        dataView = (TextView) findViewById(R.id.data);
        errorView = (TextView) findViewById(R.id.error);
        loading = findViewById(R.id.loading);

        findViewById(R.id.loadDataFromServer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.loadDataFromServer();
            }
        });

        findViewById(R.id.loadDataFromLocal).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mPresenter.loadDataFromLocal();
            }
        });
    }

    @Override
    public void showData(String data) {
        dataView.setText(data);
    }

    @Override
    @MainThread
    public void showLoading() {
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loading.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showLoadErrorView(int errorCode) {
        errorView.setText("错误原因: " + errorCode);
    }

    @Override
    public void setPresenter(MVPContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
