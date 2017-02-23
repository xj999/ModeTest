package com.rpggroup.modetest.mvp;

import android.util.Log;

/**
 * Created by bb on 2017/2/23.
 */

public class LocalDataSource implements IDataSource {
    private static LocalDataSource INSTANCE;

    private LocalDataSource() {
    }

    public static LocalDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LocalDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void getData(final OnGetDataCallback onGetDataCallback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {

                }
                onGetDataCallback.onGetDataSuccessed("本地资源 嘿嘿嘿");
            }
        }).start();
    }
}
