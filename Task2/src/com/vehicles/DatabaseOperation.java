package com.vehicles;

public class DatabaseOperation
{
    private String url;
    private String username;
    private String password;

    void saveVehicle(String vehicleName)
    {
        System.out.println(String.format("vehicle %s Stored in database" , vehicleName));
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
