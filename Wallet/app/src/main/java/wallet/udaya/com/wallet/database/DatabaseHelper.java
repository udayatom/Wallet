package wallet.udaya.com.wallet.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import wallet.udaya.com.wallet.models.BankDetails;

/**
 * Created by root on 13/4/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {



    // Logcat tag
    private static final String LOG = DatabaseHelper.class.getName();

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager";
    // Table Names
    private static final String TABLE_BANK_DETAILS = "bankdetails";
    private static final String TABLE_CREDIT_CARD_DETAILS = "debitcards";
    private static final String TABLE_DEBIT_CARD_DETAILS = "creditcards";
    private static final String TABLE_USERS = "users";

    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_USER_PROFILE_PICTURE_URL = "user_profile_url";


    // Bank card Table Columns
    private static final String KEY_BANK_DETAILS_ID = "id";
    private static final String KEY_BANK_HOLDERNAME = "account_holder_name";
    private static final String KEY_BANK_ACCOUNTNUMBER= "account_number";
    private static final String KEY_BANK_MOBILENUMBER= "mobile_number";
    private static final String KEY_BANK_EMAIL   = "email";
    private static final String KEY_BANK_BANKNAME= "bank_name";
    private static final String KEY_BANK_BRANCH= "branch_name";
    private static final String KEY_BANK_IFSC= "ifsc_code";
    private static final String KEY_BANK_ADDRESS= "bank_address";
    private static final String KEY_BANK_INTERNET_BANKING_USERNAME= "internet_banking_username";
    private static final String KEY_BANK_INTERNET_BANKING_PASSWORD= "internet_banking_password";
    private static final String KEY_BANK_INTERNET_BANKING_TRANSACTION_PASSWORD = "internet_banking_transaction_password";
    private static final String KEY_BANK_CREATED_AT = "created_at";


    // Credit card Table Columns
    private static final String KEY_CREDIT_CARD_ID = "id";
    private static final String KEY_CREDIT_CARD_HOLDERNAME = "credit_cardholder_name";
    private static final String KEY_CREDIT_CARD_NUMBER = "credit_cardcard_number";
    private static final String KEY_CREDIT_CARD_CVV = "credit_cardcvv_number";
    private static final String KEY_CREDIT_CARD_PIN   = "credit_cardpin";
    private static final String KEY_CREDIT_CARD_BANKNAME = "credit_cardbankname";
    private static final String KEY_CREDIT_CARD_EXPIRYMONTH = "credit_cardmonth";
    private static final String KEY_CREDIT_CARD_EXPIRYYEAR= "credit_cardyear";
    private static final String KEY_CREDIT_CARD_CREATED_AT = "created_at";

    // Debit card Table Columns
    private static final String KEY_DEBIT_CARD_ID = "id";
    private static final String KEY_DEBIT_CARD_HOLDERNAME = "debit_cardholder_name";
    private static final String KEY_DEBIT_CARD_NUMBER = "debit_cardnumber";
    private static final String KEY_DEBIT_CARD_CVV = "debit_cardcvv_number";
    private static final String KEY_DEBIT_CARD_PIN   = "debit_cardpin";
    private static final String KEY_DEBIT_CARD_BANKNAME = "debit_cardbankname";
    private static final String KEY_DEBIT_CARD_EXPIRYMONTH = "debit_cardmonth";
    private static final String KEY_DEBIT_CARD_EXPIRYYEAR= "debit_cardyear";
    private static final String KEY_DEBIT_CARD_CREATED_AT = "created_at";

    // Table Create Statements
    // BankDetails table create statement
    private static final String CREATE_TABLE_BANKDETAILS = "CREATE TABLE "
            + TABLE_BANK_DETAILS + "(" + KEY_BANK_DETAILS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_BANK_HOLDERNAME + " TEXT,"
            + KEY_BANK_ACCOUNTNUMBER + " TEXT,"
            + KEY_BANK_MOBILENUMBER + " TEXT,"
            + KEY_BANK_EMAIL + " TEXT,"
            + KEY_BANK_BANKNAME + " TEXT,"
            + KEY_BANK_BRANCH + " TEXT,"
            + KEY_BANK_IFSC + " TEXT,"
            + KEY_BANK_ADDRESS + " TEXT,"
            + KEY_BANK_INTERNET_BANKING_USERNAME + " TEXT,"
            + KEY_BANK_INTERNET_BANKING_PASSWORD + " TEXT,"
            + KEY_BANK_INTERNET_BANKING_TRANSACTION_PASSWORD + " TEXT,"
            + KEY_BANK_CREATED_AT+ " DATETIME,"
            +"FOREIGN KEY("+KEY_BANK_DETAILS_ID+") REFERENCES "+TABLE_CREDIT_CARD_DETAILS+"("+KEY_CREDIT_CARD_ID+"),"
            +"FOREIGN KEY("+KEY_BANK_DETAILS_ID+") REFERENCES "+TABLE_DEBIT_CARD_DETAILS+"("+KEY_DEBIT_CARD_ID+")"
            + ")";


    // CreditCardDetails table create statement
    private static final String CREATE_TABLE_CREDIT_CARD_DETAILS = "CREATE TABLE "
            + TABLE_CREDIT_CARD_DETAILS + "(" + KEY_CREDIT_CARD_ID + " INTEGER PRIMARY KEY,"
            + KEY_CREDIT_CARD_HOLDERNAME + " TEXT,"
            + KEY_CREDIT_CARD_NUMBER + " TEXT,"
            + KEY_CREDIT_CARD_CVV + " TEXT,"
            + KEY_CREDIT_CARD_PIN + " TEXT,"
            + KEY_CREDIT_CARD_BANKNAME + " TEXT,"
            + KEY_CREDIT_CARD_EXPIRYMONTH + " TEXT,"
            + KEY_CREDIT_CARD_EXPIRYYEAR + " TEXT,"
            + KEY_CREDIT_CARD_CREATED_AT+ " DATETIME);";

    // DebitCardDetails table create statement
    private static final String CREATE_TABLE_DEBIT_CARD_DETAILS = "CREATE TABLE "
            + TABLE_DEBIT_CARD_DETAILS + "(" + KEY_DEBIT_CARD_ID + " INTEGER PRIMARY KEY,"
            + KEY_DEBIT_CARD_HOLDERNAME + " TEXT,"
            + KEY_DEBIT_CARD_NUMBER + " TEXT,"
            + KEY_DEBIT_CARD_CVV + " TEXT,"
            + KEY_DEBIT_CARD_PIN + " TEXT,"
            + KEY_DEBIT_CARD_BANKNAME + " TEXT,"
            + KEY_DEBIT_CARD_EXPIRYMONTH + " TEXT,"
            + KEY_DEBIT_CARD_EXPIRYYEAR + " TEXT,"
            + KEY_DEBIT_CARD_CREATED_AT+ " DATETIME);";




    public void createBankDetails(BankDetails bankDetails)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(KEY_BANK_HOLDERNAME,bankDetails.getName());
        contentValues.put(KEY_BANK_ACCOUNTNUMBER,bankDetails.getAccountNumber());
        contentValues.put(KEY_BANK_MOBILENUMBER,bankDetails.getMobileNumber());
        contentValues.put(KEY_BANK_EMAIL,bankDetails.getEmailID());
        contentValues.put(KEY_BANK_BANKNAME,bankDetails.getBankName());
        contentValues.put(KEY_BANK_BRANCH,bankDetails.getBranchName());
        contentValues.put(KEY_BANK_IFSC,bankDetails.getIFSCCode());
        contentValues.put(KEY_BANK_ADDRESS,bankDetails.getAddress());
        contentValues.put(KEY_BANK_INTERNET_BANKING_USERNAME,bankDetails.getInternetBankingUserName());
        contentValues.put(KEY_BANK_INTERNET_BANKING_PASSWORD,bankDetails.getInternetBankingPassword());
        contentValues.put(KEY_BANK_INTERNET_BANKING_TRANSACTION_PASSWORD,bankDetails.getInternetBankingTransactionPassword());
        long bankDetailsInsertion= db.insert(TABLE_BANK_DETAILS,null,contentValues);

        Log.w(LOG,"New Bank Details Inserted "+bankDetailsInsertion);
    }

    public BankDetails getPerson(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( "SELECT * FROM " + TABLE_BANK_DETAILS + " WHERE " +
                KEY_BANK_DETAILS_ID + "=?", new String[] { Integer.toString(id) } );
        //Log.w("resData",res.toString());
        BankDetails aBankDetails = new BankDetails();

        aBankDetails.setId(cursor.getInt(cursor.getColumnIndex(KEY_BANK_DETAILS_ID)));
        aBankDetails.setName(cursor.getString(cursor.getColumnIndex(KEY_BANK_HOLDERNAME)));
        aBankDetails.setAccountNumber(cursor.getString(cursor.getColumnIndex(KEY_BANK_ACCOUNTNUMBER)));
        aBankDetails.setMobileNumber(cursor.getString(cursor.getColumnIndex(KEY_BANK_MOBILENUMBER)));
        aBankDetails.setEmailID(cursor.getString(cursor.getColumnIndex(KEY_BANK_EMAIL)));
        aBankDetails.setBankName(cursor.getString(cursor.getColumnIndex(KEY_BANK_BANKNAME)));
        aBankDetails.setBranchName(cursor.getString(cursor.getColumnIndex(KEY_BANK_BRANCH)));
        aBankDetails.setIFSCCode(cursor.getString(cursor.getColumnIndex(KEY_BANK_IFSC)));
        aBankDetails.setAddress(cursor.getString(cursor.getColumnIndex(KEY_BANK_ADDRESS)));
        aBankDetails.setInternetBankingUserName(cursor.getString(cursor.getColumnIndex(KEY_BANK_INTERNET_BANKING_USERNAME)));
        aBankDetails.setInternetBankingPassword(cursor.getString(cursor.getColumnIndex(KEY_BANK_INTERNET_BANKING_PASSWORD)));
        aBankDetails.setInternetBankingTransactionPassword(cursor.getString(cursor.getColumnIndex(KEY_BANK_INTERNET_BANKING_TRANSACTION_PASSWORD)));


        return aBankDetails;
    }

    // Getting All Contacts
    public ArrayList<BankDetails> getBankDetails() {
        ArrayList<BankDetails> aBankDetailsList = new ArrayList<BankDetails>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_BANK_DETAILS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                BankDetails aBankDetails = new BankDetails();

                aBankDetails.setId(cursor.getInt(cursor.getColumnIndex(KEY_BANK_DETAILS_ID)));
                aBankDetails.setName(cursor.getString(cursor.getColumnIndex(KEY_BANK_HOLDERNAME)));
                aBankDetails.setAccountNumber(cursor.getString(cursor.getColumnIndex(KEY_BANK_ACCOUNTNUMBER)));
                aBankDetails.setMobileNumber(cursor.getString(cursor.getColumnIndex(KEY_BANK_MOBILENUMBER)));
                aBankDetails.setEmailID(cursor.getString(cursor.getColumnIndex(KEY_BANK_EMAIL)));
                aBankDetails.setBankName(cursor.getString(cursor.getColumnIndex(KEY_BANK_BANKNAME)));
                aBankDetails.setBranchName(cursor.getString(cursor.getColumnIndex(KEY_BANK_BRANCH)));
                aBankDetails.setIFSCCode(cursor.getString(cursor.getColumnIndex(KEY_BANK_IFSC)));
                aBankDetails.setAddress(cursor.getString(cursor.getColumnIndex(KEY_BANK_ADDRESS)));
                aBankDetails.setInternetBankingUserName(cursor.getString(cursor.getColumnIndex(KEY_BANK_INTERNET_BANKING_USERNAME)));
                aBankDetails.setInternetBankingPassword(cursor.getString(cursor.getColumnIndex(KEY_BANK_INTERNET_BANKING_PASSWORD)));
                aBankDetails.setInternetBankingTransactionPassword(cursor.getString(cursor.getColumnIndex(KEY_BANK_INTERNET_BANKING_TRANSACTION_PASSWORD)));

                // Adding contact to list
                aBankDetailsList.add(aBankDetails);
            } while (cursor.moveToNext());
        }

        // return BankDetails list
        return aBankDetailsList;
    }


    public DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);

        }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_BANKDETAILS);
        sqLiteDatabase.execSQL(CREATE_TABLE_CREDIT_CARD_DETAILS);
        sqLiteDatabase.execSQL(CREATE_TABLE_DEBIT_CARD_DETAILS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // on upgrade drop older tables
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_BANKDETAILS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_CREDIT_CARD_DETAILS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_DEBIT_CARD_DETAILS);

        // create new tables
        onCreate(sqLiteDatabase);
    }

    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

}
