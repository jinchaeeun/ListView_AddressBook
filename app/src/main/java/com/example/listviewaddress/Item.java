package com.example.listviewaddress;

public class Item {
    String name;
    String phoneNum;
    String email;
    
    // 생성자
    public Item(String name, String phoneNum, String email)
    {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    //getter & setter 설정
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
