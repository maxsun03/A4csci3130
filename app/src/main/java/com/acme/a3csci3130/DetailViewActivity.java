package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText nameField, addressField, businessnumberField, primarybusinessField, provinceField;
    Contact receivedPersonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        nameField = (EditText) findViewById(R.id.name);
        addressField = (EditText) findViewById(R.id.address);
        businessnumberField = (EditText) findViewById(R.id.businessnumber);
        primarybusinessField = (EditText) findViewById(R.id.primarybusiness);
        provinceField = (EditText) findViewById(R.id.province);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            addressField.setText(receivedPersonInfo.address);
            businessnumberField.setText(receivedPersonInfo.businessnumber);
            primarybusinessField.setText(receivedPersonInfo.primarybusiness);
            provinceField.setText(receivedPersonInfo.province);

        }
    }

    public void updateContact(View v){
        //TODO: Update contact funcionality
        final MyApplicationData state;
        state = ((MyApplicationData) getApplicationContext());

        Button btn = (Button) findViewById(R.id.updateButton);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String personID = receivedPersonInfo.uid;

                state.firebaseReference.child(personID).child("name").setValue(nameField.getText().toString());
                state.firebaseReference.child(personID).child("address").setValue(addressField.getText().toString());
                state.firebaseReference.child(personID).child("businessnumber").setValue(businessnumberField.getText().toString());
                state.firebaseReference.child(personID).child("primarybusiness").setValue(primarybusinessField.getText().toString());
                state.firebaseReference.child(personID).child("province").setValue(provinceField.getText().toString());
                finish();
            }
        });
    }


    public void eraseContact(View v) {
        //TODO: Erase contact functionality
        final MyApplicationData state;
        state = ((MyApplicationData) getApplicationContext());

        Button btn = (Button) findViewById(R.id.deleteButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String personID = receivedPersonInfo.uid;
                state.firebaseReference.child( personID ).child( "name" ).removeValue();
                state.firebaseReference.child( personID ).child( "address" ).removeValue();
                state.firebaseReference.child( personID ).child( "businessnumber" ).removeValue();
                state.firebaseReference.child( personID ).child( "primarybusiness" ).removeValue();
                state.firebaseReference.child( personID ).child( "province" ).removeValue();
                state.firebaseReference.child( personID ).removeValue();

                finish();
            }
        });
    }
}
