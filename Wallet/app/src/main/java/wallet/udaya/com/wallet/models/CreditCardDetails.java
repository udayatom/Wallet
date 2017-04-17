package wallet.udaya.com.wallet.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by root on 7/1/17.
 */

public class CreditCardDetails implements Parcelable {

    private String CreditCardHolderName="";

    private String CreditCardNumber="";

    private String CreditCardCvvNumber="";

    private String CreditCardType="";

    private String CreditCardBankName="";

    private String CreditCardPin="";

    private String CreditCardExpiryDateMonth="";

    private String CreditCardExpiryDateYear="";


    public CreditCardDetails(String CreditCardHolderName,String CreditCardNumber,String CreditCardCvvNumber,String CreditCardPin,String CardType,String CreditCardBankName,String CreditCardExpiryDateMonth,String CreditCardExpiryDateYear)
    {
        setCreditCardHolderName(CreditCardHolderName);
        setCreditCardNumber(CreditCardNumber);
        setCreditCardCvvNumber(CreditCardCvvNumber);
        setCreditCardPin(CreditCardPin);
        setCreditCardType(CardType);
        setCreditCardBankName(CreditCardBankName);
        setCreditCardExpiryDateMonth(CreditCardExpiryDateMonth);
        setCreditExpiryDateYear(CreditCardExpiryDateYear);

        Log.w("CreditName",this.CreditCardHolderName);
    }

    public String getCreditCardNumber ()
    {
        return CreditCardNumber;
    }

    public void setCreditCardNumber (String CreditCardNumber)
    {
        this.CreditCardNumber = CreditCardNumber;
    }


    public String getCreditCardCvvNumber ()
    {
        return CreditCardCvvNumber;
    }

    public void setCreditCardCvvNumber (String CreditCardCvvNumber)
    {
        this.CreditCardCvvNumber = CreditCardCvvNumber;
    }

    public String getCreditCardPin ()
    {
        return CreditCardPin;
    }

    public void setCreditCardPin (String CreditCardPin)
    {
        this.CreditCardPin = CreditCardPin;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [CreditCardNumber = "+CreditCardNumber+", CreditCardCvvNumber = "+CreditCardCvvNumber+", CreditCardPin = "+CreditCardPin+", CreditCardExpiryDateMonth = "+CreditCardExpiryDateMonth+", CreditCardExpiryDateYear ="+CreditCardExpiryDateYear+" ]";
    }

    public String getCreditCardExpiryDateMonth() {
        return CreditCardExpiryDateMonth;
    }

    public void setCreditCardExpiryDateMonth(String CreditCardExpiryDateMonth) {
        CreditCardExpiryDateMonth = CreditCardExpiryDateMonth;
    }

    public String getCreditExpiryDateYear() {
        return CreditCardExpiryDateYear;
    }

    public void setCreditExpiryDateYear(String CreditCardExpiryDateYear) {
        CreditCardExpiryDateYear = CreditCardExpiryDateYear;
    }

    public String getCreditCardHolderName() {
        return CreditCardHolderName;
    }

    public void setCreditCardHolderName(String creditCardHolderName) {
        CreditCardHolderName = creditCardHolderName;
    }

    public String getCreditCardType() {
        return CreditCardType;
    }

    public void setCreditCardType(String creditCardType) {
        CreditCardType = creditCardType;
    }

    public String getCreditCardBankName() {
        return CreditCardBankName;
    }

    public void setCreditCardBankName(String creditCardBankName) {
        CreditCardBankName = creditCardBankName;
    }

    public CreditCardDetails(Parcel in) {
        String[] data = new String[7];
        in.readStringArray(data);
        this.CreditCardHolderName = data[0];
        this.CreditCardNumber = data[1];
        this.CreditCardCvvNumber = data[2];
        this.CreditCardType = data[3];
        this.CreditCardBankName = data[4];
        this.CreditCardPin = data[5];
        this.CreditCardExpiryDateMonth = data[6];
        this.CreditCardExpiryDateYear = data[7];
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{this.CreditCardHolderName,
                this.CreditCardNumber,
                this.CreditCardCvvNumber, this.CreditCardType,this.CreditCardBankName,
                this.CreditCardPin,
                this.CreditCardExpiryDateMonth, this.CreditCardExpiryDateYear});

    }

    public static final Creator<CreditCardDetails> CREATOR = new Creator<CreditCardDetails>() {
        public CreditCardDetails createFromParcel(Parcel in) {
            return new CreditCardDetails(in);
        }


        public CreditCardDetails[] newArray(int size) {
            return new CreditCardDetails[size];
        }
    };


    public CreditCardDetails()
    {

    }
}
