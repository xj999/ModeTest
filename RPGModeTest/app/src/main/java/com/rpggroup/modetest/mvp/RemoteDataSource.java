package com.rpggroup.modetest.mvp;

/**
 * Created by bb on 2017/2/23.
 */

public class RemoteDataSource implements IDataSource {

    private static RemoteDataSource INSTANCE;

    private RemoteDataSource(){}

    public static RemoteDataSource getINstance() {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void getData(final OnGetDataCallback onGetDataCallback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                   Thread.sleep(5000);
                } catch (InterruptedException e) {

                }
                onGetDataCallback.onGetDataSuccessed("远程资源 嘿嘿嘿");
            }
        }).start();
    }
}
