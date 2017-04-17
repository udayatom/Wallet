package wallet.udaya.com.wallet.models;

/**
 * Created by root on 7/1/17.
 */

public class DebitCardDetails {

    private String DebitCardHolderName="";

    private String DebitCardNumber="";

    private String DebitCardCvvNumber="";

    private String DebitCardType ="";

    private String DebitCardPin="";

    private String DebitCardBankName="";

    private String DebitCardExpiryDateMonth="";

    private String DebitCardExpiryDateYear="";

    public DebitCardDetails(String DebitCardHolderName,String DebitCardNumber,String DebitCardCvvNumber,String CardType,String DebitCardPin,String DebitCardBankName,String DebitCardExpiryDateMonth,String DebitCardExpiryDateYear)
    {
        setDebitCardHolderName(DebitCardHolderName);
        setDebitCardNumber(DebitCardNumber);
        setDebitCardCvvNumber(DebitCardCvvNumber);
        setDebitCardType(CardType);
        setDebitCardPin(DebitCardPin);
        setDebitCardBankName(DebitCardBankName);
        setDebitCardExpiryDateMonth(DebitCardExpiryDateMonth);
        setDebitCardExpiryDateYear(DebitCardExpiryDateYear);
    }


    public String getDebitCardNumber ()
    {
        return DebitCardNumber;
    }

    public void setDebitCardNumber (String DebitCardNumber)
    {
        this.DebitCardNumber = DebitCardNumber;
    }

    public String getDebitCardCvvNumber ()
    {
        return DebitCardCvvNumber;
    }

    public void setDebitCardCvvNumber (String DebitCardCvvNumber)
    {
        this.DebitCardCvvNumber = DebitCardCvvNumber;
    }

    public String getDebitCardPin ()
    {
        return DebitCardPin;
    }

    public void setDebitCardPin (String DebitCardPin)
    {
        this.DebitCardPin = DebitCardPin;
    }

    public String getDebitCardExpiryDateMonth() {
        return DebitCardExpiryDateMonth;
    }

    public void setDebitCardExpiryDateMonth(String debitCardExpiryDateMonth) {
        DebitCardExpiryDateMonth = debitCardExpiryDateMonth;
    }

    public String getDebitCardExpiryDateYear() {
        return DebitCardExpiryDateYear;
    }

    public void setDebitCardExpiryDateYear(String debitCardExpiryDateYear) {
        DebitCardExpiryDateYear = debitCardExpiryDateYear;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [DebitCardNumber = "+DebitCardNumber+", DebitCardCvvNumber = "+DebitCardCvvNumber+", DebitCardPin = "+DebitCardPin+", DebitExpiryDateMonth = "+DebitCardExpiryDateMonth+", DebitExpiryDateYear ="+DebitCardExpiryDateYear+" ]";
    }

    public String getDebitCardHolderName() {
        return DebitCardHolderName;
    }

    public void setDebitCardHolderName(String debitCardHolderName) {
        DebitCardHolderName = debitCardHolderName;
    }

    public String getDebitCardBankName() {
        return DebitCardBankName;
    }

    public void setDebitCardBankName(String debitCardBankName) {
        DebitCardBankName = debitCardBankName;
    }

    public DebitCardDetails()
    {

    }

    public String getDebitCardType() {
        return DebitCardType;
    }

    public void setDebitCardType(String debitCardType) {
        DebitCardType = debitCardType;
    }
}
