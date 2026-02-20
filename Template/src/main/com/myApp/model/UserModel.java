package main.com.myApp.model;


import main.com.myApp.validation.PasswordMatch;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@PasswordMatch

public class UserModel {
    @NotNull(message = "this field cannot empty or null")
    @Size(min =3,message = "this field cannot be less 3 letters")
    private String userName;
    @NotNull(message = "this field cannot empty or null")
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "this is invalid email"
    )

    private String email;
    private String password;
    private String confirmPassword;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
