package wallet.udaya.com.wallet.models;

/**
 * Created by root on 20/12/16.
 */

public class BankDetails
{


    private int Id=0;

    private String Name="";

    private String AccountNumber="";

    private String MobileNumber="";

    private String EmailID="";

    private String BankName="";

    private String BranchName="";

    private String IFSCCode="";

    private String Address="";

    private String InternetBankingUserName="";

    private String InternetBankingPassword="";

    private String InternetBankingTransactionPassword="";



    public BankDetails()
    {

    }
    
public BankDetails(String Name, String MobileNumber, String EmailID, String Address,String AccountNumber,String BankName,String BranchName,String IFSCCode,String InternetBankingUserName,String InternetBankingPassword,String InternetBankingTransactionPassword)
{   setName(Name);
    setMobileNumber(MobileNumber);
    setEmailID(EmailID);
    setAddress(Address);
    setAccountNumber(AccountNumber);
    setBankName(BankName);
    setBranchName(BranchName);
    setIFSCCode(IFSCCode);
    setInternetBankingUserName(InternetBankingUserName);
    setInternetBankingPassword(InternetBankingPassword);
    setInternetBankingTransactionPassword(InternetBankingTransactionPassword);
    
}

    public String getInternetBankingUserName ()
    {
        return InternetBankingUserName;
    }

    public void setInternetBankingUserName (String InternetBankingUserName)
    {
        this.InternetBankingUserName = InternetBankingUserName;
    }

    public String getAccountNumber ()
    {
        return AccountNumber;
    }

    public void setAccountNumber (String AccountNumber)
    {
        this.AccountNumber = AccountNumber;
    }

    public String getIFSCCode ()
    {
        return IFSCCode;
    }

    public void setIFSCCode (String IFSCCode)
    {
        this.IFSCCode = IFSCCode;
    }

    public String getInternetBankingPassword ()
    {
        return InternetBankingPassword;
    }

    public void setInternetBankingPassword (String InternetBankingPassword)
    {
        this.InternetBankingPassword = InternetBankingPassword;
    }

    public String getBankName ()
    {
        return BankName;
    }

    public void setBankName (String BankName)
    {
        this.BankName = BankName;
    }

    public String getName ()
    {
        return Name;
    }

    public void setName (String Name)
    {
        this.Name = Name;
    }

    public String getBranchName ()
    {
        return BranchName;
    }

    public void setBranchName (String BranchName)
    {
        this.BranchName = BranchName;
    }

    public String getAddress ()
    {
        return Address;
    }

    public void setAddress (String Address)
    {
        this.Address = Address;
    }

    public String getInternetBankingTransactionPassword ()
    {
        return InternetBankingTransactionPassword;
    }

    public void setInternetBankingTransactionPassword (String InternetBankingTransactionPassword)
    {
        this.InternetBankingTransactionPassword = InternetBankingTransactionPassword;
    }

    public String getEmailID ()
    {
        return EmailID;
    }

    public void setEmailID (String EmailID)
    {
        this.EmailID = EmailID;
    }

    public String getMobileNumber ()
    {
        return MobileNumber;
    }

    public void setMobileNumber (String MobileNumber)
    {
        this.MobileNumber = MobileNumber;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ Id= "+Id+" InternetBankingUserName = "+InternetBankingUserName+", AccountNumber = "+AccountNumber+",  IFSCCode = "+IFSCCode+", InternetBankingPassword = "+InternetBankingPassword+", BankName = "+BankName+", Name = "+Name+", BranchName = "+BranchName+", Address = "+Address+", InternetBankingTransactionPassword = "+InternetBankingTransactionPassword+", EmailID = "+EmailID+", MobileNumber = "+MobileNumber+"]";
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}

