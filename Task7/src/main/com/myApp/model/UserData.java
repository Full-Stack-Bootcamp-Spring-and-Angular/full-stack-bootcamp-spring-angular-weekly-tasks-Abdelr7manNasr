package main.com.myApp.model;

import java.util.List;

public class UserData {

    private String userName;
    private String passWord;
    private String country;
    private String Programminglang;
    private List <String> os;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProgramminglang() {
        return Programminglang;
    }

    public void setProgramminglang(String programminglang) {
        Programminglang = programminglang;
    }

    public List<String> getOs() {
        return os;
    }

    public void setOs(List<String> os) {
        this.os = os;
    }
}
