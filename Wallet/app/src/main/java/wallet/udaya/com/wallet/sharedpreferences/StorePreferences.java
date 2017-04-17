package wallet.udaya.com.wallet.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by root on 20/12/16.
 */

public class StorePreferences {

    Context mContext;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;

    public static final String PREFERENCESNAME = "wallet";

    public static  final String PREFERENCE_PASSWORD = "PASSWORD";


    public StorePreferences(Context context)
    {
        mContext=context;
        sharedpreferences=mContext.getSharedPreferences(PREFERENCESNAME,mContext.MODE_PRIVATE);
        editor=sharedpreferences.edit();
    }


    public String getPassword()
    {
        String password=sharedpreferences.getString(PREFERENCE_PASSWORD,"");
        return password;
    }

    public void setPassword(String password)
    {
        editor.putString(PREFERENCE_PASSWORD,password);
        editor.commit();

    }
}

