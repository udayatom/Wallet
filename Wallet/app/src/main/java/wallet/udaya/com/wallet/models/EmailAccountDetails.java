package wallet.udaya.com.wallet.models;

/**
 * Created by root on 20/12/16.
 */

public class EmailAccountDetails
{

    private String EmailId;

    private String Password;

    private String SecurityQuestion;

    private String SecurityAnswer;

    
    public EmailAccountDetails(String EmailId, String Password, String SecurityQuestion, String  SecurityAnswer)
    {

       this.EmailId  = EmailId;
       this.Password  = Password;
       this.SecurityQuestion  = SecurityQuestion;
       this.SecurityAnswer  = SecurityAnswer;

    }
       @Override
    public String toString()
    {
        return "ClassPojo [EmailId = "+EmailId+", Password = "+Password+" SecurityQuestion = "+SecurityQuestion+"SecurityAnswer = "+SecurityAnswer+"]";
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String emailId) {
        EmailId = emailId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getSecurityQuestion() {
        return SecurityQuestion;
    }

    public void setSecurityQuestion(String SecurityQuestion) {
        SecurityQuestion = SecurityQuestion;
    }

    public String getSecurityAnswer() {
        return SecurityAnswer;
    }

    public void setSecurityAnswer(String SecurityAnswer) {
        SecurityAnswer = SecurityAnswer;
    }
    
}

