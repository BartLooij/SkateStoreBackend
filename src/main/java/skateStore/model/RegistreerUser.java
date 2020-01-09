package skateStore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class RegistreerUser {

    @JsonProperty
    @NotNull
    @Length(max = 255)
    private String Email;

    @NotNull
    @Length(max = 255)
    @JsonProperty
    private String Password;

    @NotNull
    @Length(max = 255)
    private String Name;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}
