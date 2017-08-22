package com.n1njac.binderpooldemo;

import android.os.RemoteException;

/**
 * Created by N1njaC on 2017/8/21.
 */

public class SecurityCenterImp extends ISecurityCenter.Stub {

    private static final char SECRET_CODE = '^';

    @Override
    public String encrypt(String content) throws RemoteException {
        char[] chars = content.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //二进制形式后按位进行异或运算，即遇相同位取0不同位取1。
            chars[i] ^= SECRET_CODE;
        }
        return new String(chars);
    }

    @Override
    public String decrypt(String password) throws RemoteException {
        return encrypt(password);
    }
}
