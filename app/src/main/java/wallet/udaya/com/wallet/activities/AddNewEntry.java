package wallet.udaya.com.wallet.activities;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wallet.udaya.com.wallet.R;
import wallet.udaya.com.wallet.database.DatabaseHelper;
import wallet.udaya.com.wallet.fragments.BankDetailsFragment;
import wallet.udaya.com.wallet.fragments.CreditCardFragment;
import wallet.udaya.com.wallet.fragments.DebitCardFragment;
import wallet.udaya.com.wallet.models.BankDetails;
import wallet.udaya.com.wallet.models.CreditCardDetails;
import wallet.udaya.com.wallet.models.DebitCardDetails;


public  class AddNewEntry extends AppCompatActivity implements View.OnClickListener {

    static int mId=2;

   static String mName="", mEmail="",mMobilenumber="",mBankname="",mBranchname="", mBankAddress="",mIFSC="",
                mAccountnumber="",mInternetbankingusername="",mInternetBankingPassword="",mInternetBankingTransactionPassword="";
   static String mDebitCardHolderName="", mDebitBankName ="", mDebitcardNumber ="",mDebitCardType="", mDebitcardcvvNumber ="",mDebitcardpin="",mDebitMonth="",mDebitYear="";
   static String mCreditCardHolderName="", mCreditBankname="", mCreditcardNumber ="",mCreditCardType="",mCreditcardcvvnumber="",mCreditcardpin="",mCreditMonth="",mCreditYear="";

    ViewPager viewPager;
    TabLayout tabLayout;
    View content;

    TextView mTxtViewtabOneTitle,mTxtViewtabTwoTitle,mTxtViewtabThreeTitle;
    View aBankDetailsInflateView,aCreditCardInflateView,aDebitCardInflateView;
    LinearLayout aBankDetailsInflateLinear,aCreditCardInflateLinear,aDebitCardInflateLinear;

    public static BankDetails mBankDetails=new BankDetails();
    public static CreditCardDetails mCreditCardDetails=new CreditCardDetails();
    public static DebitCardDetails mDebitCardDetails=new DebitCardDetails();

    BankDetailsFragment mBankDetailsFragment=new BankDetailsFragment();
    DebitCardFragment mDebitCardFragment=new DebitCardFragment();
    CreditCardFragment mCreditCardFragment=new CreditCardFragment();

    DatabaseHelper  mDatabaseHelper = new DatabaseHelper(AddNewEntry.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_entry);
      //Initializing the widgets
       initWidgets();
    }

    
    public void initWidgets()
    {
        //Custom Tab view
        aBankDetailsInflateView = (View) LayoutInflater.from(this).inflate(R.layout.custom_tab_text, null);
        aCreditCardInflateView = (View) LayoutInflater.from(this).inflate(R.layout.custom_tab_text, null);
        aDebitCardInflateView = (View) LayoutInflater.from(this).inflate(R.layout.custom_tab_text, null);

        aBankDetailsInflateLinear = (LinearLayout) aBankDetailsInflateView.findViewById(R.id.LinTabText);
        aCreditCardInflateLinear = (LinearLayout) aCreditCardInflateView.findViewById(R.id.LinTabText);
        aDebitCardInflateLinear = (LinearLayout) aDebitCardInflateView.findViewById(R.id.LinTabText);

        mTxtViewtabOneTitle = (TextView) aBankDetailsInflateLinear.findViewById(R.id.tabtext);
        mTxtViewtabTwoTitle = (TextView) aCreditCardInflateLinear.findViewById(R.id.tabtext);
        mTxtViewtabThreeTitle = (TextView) aDebitCardInflateLinear.findViewById(R.id.tabtext);

        viewPager = (ViewPager) findViewById(R.id.HomeViewPager);
        tabLayout = (TabLayout) findViewById(R.id.HomeTabs);
        content   = findViewById(R.id.HomeScreenFullLayout);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                changeMenu(tab.getPosition());
                tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.signin_blue));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

     /* Log.w("SizeOfBankDetails",mDatabaseHelper.getAllContacts().get(0)+"<>");
        Log.w("SizeOfBankDetails",mDatabaseHelper.getAllContacts().get(1)+"<>");
        Log.w("SizeOfBankDetails",mDatabaseHelper.getAllContacts().get(2)+"<>");
        Log.w("SizeOfBankDetails",mDatabaseHelper.getAllContacts().get(3)+"<>");
        */
    }


    public void changeMenu(int position) {

        if (position == 0) {
            mTxtViewtabOneTitle.setTextColor(getResources().getColor(R.color.selected_header_pink));
            mTxtViewtabTwoTitle.setTextColor(getResources().getColor(R.color.signin_blue));
            mTxtViewtabThreeTitle.setTextColor(getResources().getColor(R.color.signin_blue));
            tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.signin_blue));

        } else if (position == 1) {
            mTxtViewtabOneTitle.setTextColor(getResources().getColor(R.color.signin_blue));
            mTxtViewtabTwoTitle.setTextColor(getResources().getColor(R.color.selected_header_pink));
            mTxtViewtabThreeTitle.setTextColor(getResources().getColor(R.color.signin_blue));

        } else if (position == 2) {
            mTxtViewtabOneTitle.setTextColor(getResources().getColor(R.color.signin_blue));
            mTxtViewtabTwoTitle.setTextColor(getResources().getColor(R.color.signin_blue));
            mTxtViewtabThreeTitle.setTextColor(getResources().getColor(R.color.selected_header_pink));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.add_record) {
            Log.w("RecordDetails","AddNewEntryFragment");
           /* getCreditCardDetails=mCreditCardFragment.getCreditCardDetails();
            mBankDetails=mBankDetailsFragment.get;
            mDebitCardDetails=mDebitCardFragment.getDebitCardDetails();*/
            getDetails();
        }

        if (id == R.id.cancel) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {

        }
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /*
    private boolean validateEmail() {

        if (mEmail.isEmpty() || !isValidEmail(mEmail)) {
            minput_layout_email.setError(getString(R.string.err_msg_email));
            requestFocus(minput_layout_email);
            return false;
        } else {
            minput_layout_email.setErrorEnabled(false);
        }

        return true;
    }
    */

    public void getDetails()
    {
        mBankDetailsFragment.getAllDetails();
        mId=getBankDetails().getId();
        mName=getBankDetails().getName();
        mEmail =getBankDetails().getEmailID();
        mMobilenumber=getBankDetails().getMobileNumber();
        mBankname=getBankDetails().getBankName();
        mBranchname=getBankDetails().getBranchName();
        mBankAddress=getBankDetails().getAddress();
        mIFSC=getBankDetails().getIFSCCode();
        mAccountnumber=getBankDetails().getAccountNumber();
        mInternetbankingusername=getBankDetails().getInternetBankingUserName();
        mInternetBankingPassword=getBankDetails().getInternetBankingPassword();
        mInternetBankingTransactionPassword=getBankDetails().getInternetBankingTransactionPassword();

     /*   mCreditCardFragment.getAllDetails();
        mCreditCardHolderName=getCreditCardDetails().getCreditCardHolderName();
        mCreditBankname=getCreditCardDetails().getCreditCardBankName();
        mCreditcardNumber =getCreditCardDetails().getCreditCardNumber();
        mCreditCardType=getCreditCardDetails().getCreditCardType();
        mCreditcardcvvnumber=getCreditCardDetails().getCreditCardCvvNumber();
        mCreditMonth=getCreditCardDetails().getCreditCardExpiryDateMonth();
        mCreditcardpin=getCreditCardDetails().getCreditCardPin();
        mCreditYear=getCreditCardDetails().getCreditExpiryDateYear();

        mDebitCardFragment.getAllDetails();
        mDebitCardHolderName=getDebitCardDetails().getDebitCardHolderName();
        mDebitBankName =getCreditCardDetails().getCreditCardBankName();
        mDebitcardNumber =getDebitCardDetails().getDebitCardNumber();
        mDebitCardType=getDebitCardDetails().getDebitCardType();
        mDebitcardcvvNumber =getDebitCardDetails().getDebitCardCvvNumber();
        mDebitMonth=getDebitCardDetails().getDebitCardExpiryDateMonth();
        mDebitcardpin=getDebitCardDetails().getDebitCardPin();
        mDebitYear=getDebitCardDetails().getDebitCardExpiryDateYear();*/

        Log.w("BankDetails Id",mId+"<>");
        Log.w("BankDetails Name",mName+"<>");
        Log.w("BankDetails Email",mEmail);
        Log.w("BankDetails Mobile",mMobilenumber);
        Log.w("BankDetails Bank",mBankname);
        Log.w("BankDetails Branch",mBranchname);
        Log.w("BankDetails Address",mBankAddress);
        Log.w("BankDetails IFSC",mIFSC);
        Log.w("BankDetails Account",mAccountnumber);
        Log.w("BankDetails InName",mInternetbankingusername+"<>");
        Log.w("BankDetails InPass",mInternetBankingPassword);
        Log.w("BankDetails InTPass",mInternetBankingTransactionPassword);

        Log.w("CreditCardDetails Name",mCreditCardHolderName);
        Log.w("CreditCardDetails Bank",mCreditBankname);
        Log.w("CreditCardDetails No", mCreditcardNumber);
        Log.w("CreditCardDetails Type",mCreditCardType);
        Log.w("CreditCardDetails Cvv",mCreditcardcvvnumber);
        Log.w("CreditCardDetails Pin",mCreditcardpin);
        Log.w("CreditCardDetails month",mCreditMonth);
        Log.w("CreditCardDetails year",mCreditYear);


        Log.w("DebitCardDetails Name",mDebitCardHolderName);
        Log.w("CreditCardDetails Bank", mDebitBankName);
        Log.w("DebitCardDetails No", mDebitcardNumber);
        Log.w("DebitCardDetails Type",mDebitCardType);
        Log.w("DebitCardDetails Cvv", mDebitcardcvvNumber);
        Log.w("DebitCardDetails Pin",mDebitcardpin);
        Log.w("DebitCardDetails month",mDebitMonth);
        Log.w("DebitCardDetails year",mDebitYear);
       // mDatabaseHelper.createBankDetails(getBankDetails());
       // mDatabaseHelper.createBankDetails(getBankDetails());
       // mDatabaseHelper.createBankDetails(getBankDetails());

       // submitForm();

        addBankDetails(getBankDetails());
    }

  /*  private void submitForm() {
       *//* if (!validateName()) {
            return;
        }
*//*
        if (!validateEmail()) {
            return;
        }

        *//*if (!validatePassword()) {
            return;
        }
*//*
      //  Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
    }
*/

public void addBankDetails(BankDetails bankDetails)
{
    mDatabaseHelper.createBankDetails(bankDetails);
    Log.w("SizeOfBankDetails",mDatabaseHelper.getBankDetails().get(mDatabaseHelper.getBankDetails().size()-1)+"<>");


}

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(mBankDetailsFragment.newInstance(), " Bank Details ");
        adapter.addFragment(mDebitCardFragment.newInstance(), " Debit Card ");
        adapter.addFragment(mCreditCardFragment.newInstance(), " Credit Card ");

        viewPager.setAdapter(adapter);
    }

    public BankDetails getBankDetails() {
        return mBankDetails;
    }

    public static void setBankDetails(BankDetails BankDetails) {
        mBankDetails = BankDetails;
    }

    public CreditCardDetails getCreditCardDetails() {
        return mCreditCardDetails;
    }

    public static void setCreditCardDetails(CreditCardDetails CreditCardDetails) {
        mCreditCardDetails = CreditCardDetails;
    }

    public DebitCardDetails getDebitCardDetails() {
        return mDebitCardDetails;
    }

    public static void setDebitCardDetails(DebitCardDetails DebitCardDetails) {
        mDebitCardDetails = DebitCardDetails;
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    public static void setmName(String name)
    {
        mName=name;
    }

}
