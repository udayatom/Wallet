package wallet.udaya.com.wallet.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import wallet.udaya.com.wallet.R;
import wallet.udaya.com.wallet.adapter.MyRecyclerViewAdapter;
import wallet.udaya.com.wallet.database.DatabaseHelper;

public class BankDetailsList extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    DatabaseHelper mDatabaseHelper=new DatabaseHelper(BankDetailsList.this);

    private static String LOG_TAG = "RecyclerViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_details_list);


        mRecyclerView = (RecyclerView) findViewById(R.id.bankdetails_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        Log.w("getDataSet",mDatabaseHelper.getBankDetails()+"<>");
        mAdapter = new MyRecyclerViewAdapter(mDatabaseHelper.getBankDetails());
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
    }
}
