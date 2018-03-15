package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Instrumented test for testing user profile input
 * Created by kangshusun on 2018-03-15.
 */

@RunWith(AndroidJUnit4.class)
public class onCreateInstrumentedTest {

    @Rule
    public ActivityTestRule <DetailViewActivity> mActivityRule = new ActivityTestRule<>(DetailViewActivity.class);


    @Test
    public void onCreate() throws Exception {
        String address = "5264 Morris Street";
        String businessnumber = "000123456";
        String name = "John Peter";
        String primarybusiness = "Fisher";
        String province = "NS";

        //type address
        onView(withId(R.id.address)).perform(typeText(address), closeSoftKeyboard());

        //type businessnumber
        onView(withId(R.id.businessnumber)).perform(typeText(businessnumber), closeSoftKeyboard());

        //type name
        onView(withId(R.id.name)).perform(typeText(name), closeSoftKeyboard());

        //type primarybusiness
        onView(withId(R.id.primarybusiness)).perform(typeText(primarybusiness), closeSoftKeyboard());

        //type province
        onView(withId(R.id.province)).perform(typeText(province), closeSoftKeyboard());

    }

}