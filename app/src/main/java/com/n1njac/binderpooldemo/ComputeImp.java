package com.n1njac.binderpooldemo;

import android.os.RemoteException;

/**
 * Created by N1njaC on 2017/8/21.
 */

public class ComputeImp extends ICompute.Stub {
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
