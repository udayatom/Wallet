package wallet.udaya.com.wallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import wallet.udaya.com.wallet.security.AESHelper;

public class MainActivity extends AppCompatActivity {


    public static String seedValue = "I AM UNBREAKABLE";
    public static String MESSAGE = "101004525564564";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            String encryptedData = AESHelper.encrypt(seedValue, MESSAGE);
            Log.v("EncryptDecrypt", "Encoded String " + encryptedData);
            String decryptedData = AESHelper.decrypt(seedValue, encryptedData);
            Log.v("EncryptDecrypt", "Decoded String " + decryptedData);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
