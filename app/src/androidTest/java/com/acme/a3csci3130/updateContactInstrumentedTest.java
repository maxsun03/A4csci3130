package com.acme.a3csci3130;


import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class updateContactInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>( MainActivity.class );

    @Test
    public void updateContactTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep( 60000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DataInteraction textView = onData( anything() )
                .inAdapterView( allOf( withId( R.id.listView ),
                        childAtPosition(
                                withClassName( is( "android.support.constraint.ConstraintLayout" ) ),
                                1 ) ) )
                .atPosition( 0 );
        textView.perform( click() );

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep( 3580032 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction editText = onView(
                allOf( withId( R.id.address ), withText( "5264 Morris Street" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( android.R.id.content ),
                                        0 ),
                                0 ),
                        isDisplayed() ) );
        editText.perform( replaceText( "5264 South Street" ) );

        ViewInteraction editText2 = onView(
                allOf( withId( R.id.address ), withText( "5264 South Street" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( android.R.id.content ),
                                        0 ),
                                0 ),
                        isDisplayed() ) );
        editText2.perform( closeSoftKeyboard() );

        ViewInteraction button = onView(
                allOf( withId( R.id.updateButton ), withText( "Update Data" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( android.R.id.content ),
                                        0 ),
                                5 ),
                        isDisplayed() ) );
        button.perform( click() );

        ViewInteraction button2 = onView(
                allOf( withId( R.id.updateButton ), withText( "Update Data" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( android.R.id.content ),
                                        0 ),
                                5 ),
                        isDisplayed() ) );
        button2.perform( click() );

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep( 3516286 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DataInteraction textView2 = onData( anything() )
                .inAdapterView( allOf( withId( R.id.listView ),
                        childAtPosition(
                                withClassName( is( "android.support.constraint.ConstraintLayout" ) ),
                                1 ) ) )
                .atPosition( 0 );
        textView2.perform( click() );

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText( "Child at position " + position + " in parent " );
                parentMatcher.describeTo( description );
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches( parent )
                        && view.equals( ((ViewGroup) parent).getChildAt( position ) );
            }
        };
    }
}
