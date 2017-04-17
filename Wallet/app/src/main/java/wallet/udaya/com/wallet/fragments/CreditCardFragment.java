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
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import wallet.udaya.com.wallet.R;
import wallet.udaya.com.wallet.activities.AddNewEntry;
import wallet.udaya.com.wallet.models.CreditCardDetails;


public class CreditCardFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARGS_CREDIT_CARD_DETAILS = "CreditCardDetails";

   static TextInputEditText minput_creditcardaccountname,minput_creditcardnumber,minput_creditcardtype,minput_creditcardcvvnumber,minput_creditcardpin,minput_creditcardmonth,minput_creditcardyear;

   static TextInputLayout minput_layout_creditcardaccountname,minput_layout_creditcardbankname,minput_layout_creditcardnumber,minput_layout_creditcardtype,minput_layout_creditcardcvvnumber,
            minput_layout_creditcardpin,minput_layout_creditcardmonth,minput_layout_creditcardyear;
    static AutoCompleteTextView minput_creditcardbankname;

    String mCreditcardaccountname="",mBankName="",mCreditcardnumber="",mCreditcardtype="",mCreditcardcvvnumber="",mCreditcardpin="",mCreditcardmonth="",mCreditcardyear="";
    // TODO: Rename and change types of parameters

    public CreditCardDetails mCreditCardDetails=new CreditCardDetails();
    View view;

    public CreditCardFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CreditCardFragment newInstance() {
        CreditCardFragment fragment = new CreditCardFragment();

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
        view = inflater.inflate(R.layout.fragment_credit_card, container, false);
        initWidgets(view);

        return view;
    }

    public void initWidgets(View view)
    {
        minput_creditcardaccountname=(TextInputEditText)view.findViewById(R.id.input_creditcardaccountname);
        minput_creditcardbankname=(AutoCompleteTextView)view.findViewById(R.id.input_creditcardbankname);
        minput_creditcardnumber=(TextInputEditText)view.findViewById(R.id.input_creditcardnumber);
        minput_creditcardtype=(TextInputEditText)view.findViewById(R.id.input_creditcardtype);
        minput_creditcardcvvnumber=(TextInputEditText)view.findViewById(R.id.input_creditcardcvvnumber);
        minput_creditcardpin=(TextInputEditText)view.findViewById(R.id.input_creditcardpin);
        minput_creditcardmonth=(TextInputEditText)view.findViewById(R.id.input_creditcardmonth);
        minput_creditcardyear=(TextInputEditText)view.findViewById(R.id.input_creditcardyear);


        minput_layout_creditcardaccountname= (TextInputLayout) view.findViewById(R.id.input_layout_creditcardaccountname);
        minput_layout_creditcardbankname= (TextInputLayout) view.findViewById(R.id.input_layout_creditcardbankname);
        minput_layout_creditcardnumber= (TextInputLayout) view.findViewById(R.id.input_layout_creditcardnumber);
        minput_layout_creditcardtype= (TextInputLayout) view.findViewById(R.id.input_layout_creditcardtype);
        minput_layout_creditcardcvvnumber= (TextInputLayout) view.findViewById(R.id.input_layout_creditcardcvvnumber);
        minput_layout_creditcardpin= (TextInputLayout) view.findViewById(R.id.input_layout_creditcardpin);
        minput_layout_creditcardmonth= (TextInputLayout) view.findViewById(R.id.input_layout_creditcardmonth);
        minput_layout_creditcardyear= (TextInputLayout) view.findViewById(R.id.input_layout_creditcardyear);

        String[] banks = getResources().getStringArray(R.array.list_of_banks);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,banks);
        minput_creditcardbankname.setAdapter(adapter);

    }





    public void getAllDetails()
    {
        mCreditcardaccountname=minput_creditcardaccountname.getText().toString();
        mBankName=minput_creditcardbankname.getText().toString();
        mCreditcardnumber=minput_creditcardnumber.getText().toString();
        mCreditcardtype=minput_creditcardtype.getText().toString();
        mCreditcardcvvnumber=minput_creditcardcvvnumber.getText().toString();
        mCreditcardpin=minput_creditcardpin.getText().toString();
        mCreditcardmonth=minput_creditcardmonth.getText().toString();
        mCreditcardyear=minput_creditcardyear.getText().toString();

        mCreditCardDetails=new CreditCardDetails(mCreditcardaccountname,mCreditcardnumber,mCreditcardcvvnumber,mCreditcardpin,mCreditcardtype,mBankName,mCreditcardmonth,mCreditcardyear);

        AddNewEntry.setCreditCardDetails(mCreditCardDetails);

    }


}
