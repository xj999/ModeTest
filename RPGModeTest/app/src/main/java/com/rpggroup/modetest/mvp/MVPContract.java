package com.rpggroup.modetest.mvp;


public class MVPContract {
    interface View extends BaseView<Presenter> {
        void showData(String data);

        void showLoading();

        void hideLoading();

        void showLoadErrorView(int errorCode);
    }

    interface Presenter extends BasePresenter {
        void loadDataFromServer();

        void loadDataFromLocal();
    }
}
