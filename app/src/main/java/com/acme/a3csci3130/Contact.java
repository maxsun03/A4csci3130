package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable {

    public  String uid;
    public  String name;
    public  String address;
    public  String businessnumber;
    public  String primarybusiness;
    public  String province;


    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Contact(String uid, String name, String address, String businessnumber, String primarybusiness, String province){
        this.uid = uid;
        this.name = name;
        this.address = address;
        this.businessnumber = businessnumber;
        this.primarybusiness = primarybusiness;
        this.province = province;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("address", address);
        result.put("businessnumber", businessnumber);
        result.put("primarybusiness", primarybusiness);
        result.put("province", province);

        return result;
    }
}
