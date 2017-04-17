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
import wallet.udaya.com.wallet.models.DebitCardDetails;


public class DebitCardFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARGS_DEBIT_CARD_DETAILS = "DebitCardDetails";

   static TextInputEditText minput_debitcardaccountname,minput_debitcardnumber,minput_debitcardtype,minput_debitcardcvvnumber,minput_debitcardpin,minput_debitcardmonth,minput_debitcardyear;

    static AutoCompleteTextView minput_debitcardbankname;

    static TextInputLayout minput_layout_debitcardaccountname,minput_layout_debitcardbankname,minput_layout_debitcardnumber,minput_layout_debitcardtype,minput_layout_debitcardcvvnumber,
            minput_layout_debitcardpin,minput_layout_debitcardmonth,minput_layout_debitcardyear;

    String mDebitcardaccountname="",mDebitcardnumber="",mDebitcardtype="",mDebitcardcvvnumber="",mDebitcardpin="",mDebitcardbankname="",mDebitcardmonth="",mDebitcardyear="";

    View view;

    // TODO: Rename and change types of parameters

    public DebitCardFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static DebitCardFragment newInstance() {
        DebitCardFragment fragment = new DebitCardFragment();

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
        view = inflater.inflate(R.layout.fragment_debit_card, container, false);
        initWidgets(view);
        return view;
    }

    public void initWidgets(View view)
    {
        minput_debitcardaccountname=(TextInputEditText)view.findViewById(R.id.input_debitcardaccountname);
        minput_debitcardbankname=(AutoCompleteTextView)view.findViewById(R.id.input_debitcardbankname);
        minput_debitcardnumber=(TextInputEditText)view.findViewById(R.id.input_debitcardnumber);
        minput_debitcardtype=(TextInputEditText)view.findViewById(R.id.input_debitcardtype);
        minput_debitcardcvvnumber=(TextInputEditText)view.findViewById(R.id.input_debitcardcvvnumber);
        minput_debitcardpin=(TextInputEditText)view.findViewById(R.id.input_debitcardpin);
        minput_debitcardmonth=(TextInputEditText)view.findViewById(R.id.input_debitcardmonth);
        minput_debitcardyear=(TextInputEditText)view.findViewById(R.id.input_debitcardyear);

        minput_layout_debitcardaccountname= (TextInputLayout) view.findViewById(R.id.input_layout_debitcardaccountname);
        minput_layout_debitcardbankname= (TextInputLayout) view.findViewById(R.id.input_layout_debitcardbankname);
        minput_layout_debitcardnumber= (TextInputLayout) view.findViewById(R.id.input_layout_debitcardnumber);
        minput_layout_debitcardtype= (TextInputLayout) view.findViewById(R.id.input_layout_debitcardtype);
        minput_layout_debitcardcvvnumber= (TextInputLayout) view.findViewById(R.id.input_layout_debitcardcvvnumber);
        minput_layout_debitcardpin= (TextInputLayout) view.findViewById(R.id.input_layout_debitcardpin);
        minput_layout_debitcardmonth= (TextInputLayout) view.findViewById(R.id.input_layout_debitcardmonth);
        minput_layout_debitcardyear= (TextInputLayout) view.findViewById(R.id.input_layout_debitcardyear);


        String[] banks = getResources().getStringArray(R.array.list_of_banks);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,banks);
        minput_debitcardbankname.setAdapter(adapter);

    }


    public void getAllDetails()
    {
        mDebitcardaccountname=minput_debitcardaccountname.getText().toString();
        mDebitcardbankname=minput_debitcardbankname.getText().toString();
        mDebitcardnumber=minput_debitcardnumber.getText().toString();
        mDebitcardtype=minput_debitcardtype.getText().toString();
        mDebitcardcvvnumber=minput_debitcardcvvnumber.getText().toString();
        mDebitcardpin=minput_debitcardpin.getText().toString();
        mDebitcardmonth=minput_debitcardmonth.getText().toString();
        mDebitcardyear=minput_debitcardyear.getText().toString();

        DebitCardDetails mDebitCardDetails=new DebitCardDetails(mDebitcardaccountname,mDebitcardnumber,mDebitcardcvvnumber,mDebitcardtype,mDebitcardpin,mDebitcardbankname,mDebitcardmonth,mDebitcardyear);
        AddNewEntry.setDebitCardDetails(mDebitCardDetails);
    }

}
