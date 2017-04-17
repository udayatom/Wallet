package wallet.udaya.com.wallet.adapter;

import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


import wallet.udaya.com.wallet.R;
import wallet.udaya.com.wallet.models.BankDetails;

public class MyRecyclerViewAdapter extends RecyclerView
        .Adapter<MyRecyclerViewAdapter
        .BankDetailsHolder> {
    private static String LOG_TAG = "BankDetailsRViewAdapter";
    private ArrayList<BankDetails> mDataset;

    public static class BankDetailsHolder extends RecyclerView.ViewHolder{
        TextView mTxtView_name,mTxtView_email,mTxtView_mobilenumber,mTxtView_bankname,mTxtView_branchname,mTxtView_accountnumber,mTxtView_bankaddress,mTxtView_ifsccode,
                mTxtView_internetbankingusername,mTxtView_InternetBankingPassword,mTxtView_InternetBankingTransactionPassword;

        public BankDetailsHolder(View itemView) {
            super(itemView);
            mTxtView_name = (TextView) itemView.findViewById(R.id.rv_txtview_name);
            mTxtView_accountnumber = (TextView) itemView.findViewById(R.id.rv_txtview_accountno);
            mTxtView_mobilenumber = (TextView) itemView.findViewById(R.id.rv_txtview_mobilenumber);
            mTxtView_email = (TextView) itemView.findViewById(R.id.rv_txtview_email);
            mTxtView_bankname = (TextView) itemView.findViewById(R.id.rv_txtview_bankname);
            mTxtView_branchname = (TextView) itemView.findViewById(R.id.rv_txtview_branchname);
            mTxtView_bankaddress = (TextView) itemView.findViewById(R.id.rv_txtview_bankaddress);
            mTxtView_ifsccode = (TextView) itemView.findViewById(R.id.rv_txtview_ifsccode);
            mTxtView_internetbankingusername = (TextView) itemView.findViewById(R.id.rv_txtview_internetbankingusername);
            mTxtView_InternetBankingPassword = (TextView) itemView.findViewById(R.id.rv_txtview_internetbankingpassword);
            mTxtView_InternetBankingTransactionPassword = (TextView) itemView.findViewById(R.id.rv_txtview_internetbankingtransactionpassword);
        }
    }



    public MyRecyclerViewAdapter(ArrayList<BankDetails> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public BankDetailsHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_bankdetails, parent, false);

        BankDetailsHolder dataObjectHolder = new BankDetailsHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(BankDetailsHolder holder, int position) {
        holder.mTxtView_name.setText(mDataset.get(position).getName());
        holder.mTxtView_email.setText(mDataset.get(position).getEmailID());
        holder.mTxtView_mobilenumber.setText(mDataset.get(position).getMobileNumber());
        holder.mTxtView_bankname.setText(mDataset.get(position).getBankName());
        holder.mTxtView_branchname.setText(mDataset.get(position).getBranchName());
        holder.mTxtView_bankaddress.setText(mDataset.get(position).getAddress());
        holder.mTxtView_ifsccode.setText(mDataset.get(position).getIFSCCode());
        holder.mTxtView_internetbankingusername.setText(mDataset.get(position).getInternetBankingUserName());
        holder.mTxtView_InternetBankingPassword.setText(mDataset.get(position).getInternetBankingPassword());
        holder.mTxtView_InternetBankingTransactionPassword.setText(mDataset.get(position).getInternetBankingTransactionPassword());

    }

    public void addItem(BankDetails dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        Log.w("mDataset",mDataset.size()+"");
        return mDataset.size();
    }


}