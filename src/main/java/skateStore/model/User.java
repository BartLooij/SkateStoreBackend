package skateStore.model;

import javax.validation.constraints.NotNull;

public class User {

    @NotNull
    private int Account_id;

    @NotNull
    private String Name;

    @NotNull
    private String Email;

    @NotNull
    private String Password;

    @NotNull
    private boolean Admin_account;

    public int getAccountID(){
        return Account_id;
    }

    public String Name(){
        return Name;
    }

    public String Email(){
        return Email;
    }

    public String Password(){
        return Password;
    }

    public boolean Admin_account(){
        return Admin_account;
    }

    public void setAccount_id(int setAccount_id){
        this.Account_id = Account_id;
    }

    public void setName(String experiment_naam){
        this.Name = Name;
    }

    public void setEmail(String wijziging_datum){
        this.Email = Email;
    }

    public void setPassword(String fase){
        this.Password = Password;
    }

    public void setAdmin_account(boolean status_kleur){
        this.Admin_account = Admin_account;
    }
}
