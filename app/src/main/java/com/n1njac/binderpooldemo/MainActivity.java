package com.n1njac.binderpooldemo;

import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
            }
        }).start();
    }


    private void doWork() {
        BinderPool binderPool = BinderPool.getInstance(MainActivity.this);
        try {
            IBinder securityBinder = binderPool.queryBinder(BinderPool.BINDER_SECURITY_CENTER);
            ISecurityCenter iSecurityCenter = SecurityCenterImp.asInterface(securityBinder);
            String content = iSecurityCenter.encrypt("hello");
            Log.d("xyz", "content:--------->" + content);
            String password = iSecurityCenter.decrypt(content);
            Log.d("xyz", "password:--------->" + password);

            IBinder computeBinder = binderPool.queryBinder(BinderPool.BINDER_COMPUTE);
            ICompute iCompute = ComputeImp.asInterface(computeBinder);
            Log.d("xyz", "a+b=" + iCompute.add(1, 3));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
