package eventManager;
//ADMIN USER ACCOUNT
import java.io.Serializable;

public class AdminAccount implements Serializable 
{

    private String Aname;
    private String Apassword;
    private int Aid;


    public AdminAccount(String name, String password, int Aid) 
    {
        this.Aname = name;
        this.Apassword = password;
        this.Aid = Aid;

    }

    public String getName() {
        return Aname;
    }

    public void setName(String name) {
        this.Aname = name;
    }

    public String getPassword() {
        return Apassword;
    }

    public void setPassword(String password) {
        this.Apassword = password;
    }

    public int getAId() {
        return Aid;
    }

    public void setAId(int Aid) {
        this.Aid = Aid;
    }


}  