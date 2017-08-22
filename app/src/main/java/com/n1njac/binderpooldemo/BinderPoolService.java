package com.n1njac.binderpooldemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by N1njaC on 2017/8/21.
 */

public class BinderPoolService extends Service {


    private Binder binderPool = new BinderPool.BinderPoolImp();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binderPool;
    }
}
