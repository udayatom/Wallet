/*
 * Copyright (c) 12/11/16 5:55 PM.
 *
 * Company : Netaxis IT Solutions Pvt Ltd, Chennai.
 *
 * Author : Udayakumar Prabhakaran
 *
 * Website : www.netaxis.in
 *
 * Email : udayakumar@netaxisstudio.com
 */

package wallet.udaya.com.wallet.fragments;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import wallet.udaya.com.wallet.R;
import wallet.udaya.com.wallet.activities.AddNewEntry;
import wallet.udaya.com.wallet.models.BankDetails;
import wallet.udaya.com.wallet.models.CreditCardDetails;
import wallet.udaya.com.wallet.models.DebitCardDetails;


public class BankDetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARGS_CREDIT_CARD_DETAILS = "BankDetails";

    // TODO: Rename and change types of parameters

   static AutoCompleteTextView minput_bankname;

   static TextInputLayout minput_layout_name,minput_layout_email,minput_layout_mobilenumber,minput_layout_bankname,minput_layout_branchname,minput_layout_bankaddress,minput_layout_ifsccode,minput_layout_accountnumber
            ,minput_layout_internetbankingusername,minput_layout_InternetBankingPassword,minput_layout_InternetBankingTransactionPassword;

   static TextInputEditText minput_name,minput_email,minput_mobilenumber,minput_branchname,minput_accountnumber,minput_bankaddress,minput_ifsccode,
            minput_internetbankingusername,minput_InternetBankingPassword,minput_InternetBankingTransactionPassword;

    String mName="", mEmail="", mMobileNumber ="", mBankName ="", mBranchName ="", mAccountNumber ="", mInternetBankingUsername ="",
            mInternetBankingPassword="",mInternetBankingTransactionPassword="",mAddress="",mIFSCCode="";

    public BankDetails mBankDetails=new BankDetails();

   static AddNewEntry mBankDetailsFragment;

    View view;


    public BankDetailsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static BankDetailsFragment newInstance() {
        BankDetailsFragment fragment = new BankDetailsFragment();
       /* Bundle args = new Bundle();
        args.putParcelable(ARGS_CREDIT_CARD_DETAILS, error);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_bank_details, container, false);
        initWidgets(view);
        return view;
    }

    public void getAllDetails()
    {
        mName=minput_name.getText().toString();
        mEmail =minput_email.getText().toString();
        mMobileNumber =minput_mobilenumber.getText().toString();
        mBankName =minput_bankname.getText().toString();
        mBranchName =minput_branchname.getText().toString();
        mAccountNumber =minput_accountnumber.getText().toString();
        mAddress=minput_bankaddress.getText().toString();
        mIFSCCode=minput_ifsccode.getText().toString();
        mInternetBankingUsername =minput_internetbankingusername.getText().toString();
        mInternetBankingPassword=minput_InternetBankingPassword.getText().toString();
        mInternetBankingTransactionPassword=minput_InternetBankingTransactionPassword.getText().toString();

        mBankDetails=new BankDetails(mName, mMobileNumber, mEmail, mAddress,mAccountNumber,mBankName,mBranchName,mIFSCCode,mInternetBankingUsername,mInternetBankingPassword,mInternetBankingTransactionPassword);
        AddNewEntry.setBankDetails(mBankDetails);
    }

    public void initWidgets(View view)
    {
        minput_name=(TextInputEditText)view.findViewById(R.id.input_name);
        minput_email=(TextInputEditText)view.findViewById(R.id.input_email);
        minput_mobilenumber=(TextInputEditText)view.findViewById(R.id.input_mobilenumber);
        minput_bankname=(AutoCompleteTextView)view.findViewById(R.id.input_bankname);
        minput_branchname=(TextInputEditText)view.findViewById(R.id.input_branchname);
        minput_bankaddress=(TextInputEditText)view.findViewById(R.id.input_bankaddress);
        minput_ifsccode=(TextInputEditText)view.findViewById(R.id.input_ifsccode);
        minput_accountnumber=(TextInputEditText)view.findViewById(R.id.input_accountnumber);
        minput_internetbankingusername=(TextInputEditText)view.findViewById(R.id.input_internetbankingusername);
        minput_InternetBankingPassword=(TextInputEditText)view.findViewById(R.id.input_InternetBankingPassword);
        minput_InternetBankingTransactionPassword=(TextInputEditText)view.findViewById(R.id.input_InternetBankingTransactionPassword);

        //InputLayout
        minput_layout_name=(TextInputLayout)view.findViewById(R.id.input_layout_name);
        minput_layout_email=(TextInputLayout)view.findViewById(R.id.input_layout_email);
        minput_layout_mobilenumber=(TextInputLayout)view.findViewById(R.id.input_layout_mobilenumber);
        minput_layout_bankname=(TextInputLayout)view.findViewById(R.id.input_layout_bankname);
        minput_layout_branchname=(TextInputLayout)view.findViewById(R.id.input_layout_branchname);
        minput_layout_bankaddress=(TextInputLayout)view.findViewById(R.id.input_layout_bankaddress);
        minput_layout_ifsccode=(TextInputLayout)view.findViewById(R.id.input_layout_ifsccode);
        minput_layout_accountnumber=(TextInputLayout)view.findViewById(R.id.input_layout_accountnumber);
        minput_layout_internetbankingusername=(TextInputLayout)view.findViewById(R.id.input_layout_internetbankingusername);
        minput_layout_InternetBankingPassword=(TextInputLayout)view.findViewById(R.id.input_layout_InternetBankingPassword);
        minput_layout_InternetBankingTransactionPassword=(TextInputLayout)view.findViewById(R.id.input_layout_InternetBankingTransactionPassword);

        String[] banks = getResources().getStringArray(R.array.list_of_banks);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,banks);
        minput_bankname.setAdapter(adapter);
    }

}
