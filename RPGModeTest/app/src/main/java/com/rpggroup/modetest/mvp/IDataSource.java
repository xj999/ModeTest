package com.rpggroup.modetest.mvp;

/**
 * Created by bb on 2017/2/23.
 */

public interface IDataSource {
    interface OnGetDataCallback{
        void onGetDataSuccessed(String data);
        void onGetDataFailed(int errorCode);
    }

    void getData(OnGetDataCallback onGetDataCallback);

}
