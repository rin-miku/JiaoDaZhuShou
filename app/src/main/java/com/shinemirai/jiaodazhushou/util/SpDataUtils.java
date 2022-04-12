package com.shinemirai.jiaodazhushou.util;


import android.content.Context;
import android.content.SharedPreferences;

import com.shinemirai.jiaodazhushou.entity.AccountDatasEntity;

/*
    使用SharedPreference存储用户登录信息
 */
public class SpDataUtils {
    // 文件名
    private static final String mFileName = "AccountDatas";

    public static boolean saveAccountDatas(Context context,String account,String password)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(mFileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("account",account);
        editor.putString("password",password);
        editor.commit();
        return true;
    }

    public static AccountDatasEntity getAccountDatas(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(mFileName,Context.MODE_PRIVATE);
        String account = sharedPreferences.getString("account",null);
        String password = sharedPreferences.getString("password",null);

        AccountDatasEntity accountDatasEntity = new AccountDatasEntity(account,password);
        return accountDatasEntity;
    }
}
