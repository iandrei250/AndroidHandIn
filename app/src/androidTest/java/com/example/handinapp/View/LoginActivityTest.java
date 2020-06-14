package com.example.handinapp.View;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.handinapp.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void loginActivityTest() {
        ViewInteraction frameLayout = onView(
                allOf(withId(android.R.id.content),
                        childAtPosition(
                                allOf(withId(R.id.action_bar_root),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        frameLayout.check(matches(isDisplayed()));

        ViewInteraction frameLayout2 = onView(
                allOf(withId(android.R.id.content),
                        childAtPosition(
                                allOf(withId(R.id.action_bar_root),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        frameLayout2.check(matches(isDisplayed()));

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.go_to_register), withText("Not registered ? Create an account here"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.register_password),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("asgdf"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.Sign_Up), withText("Sign up"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.register_email), withText("prtdace@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText(""));

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.register_email),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText3.perform(closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.Sign_Up), withText("Sign up"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.input),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.input_v),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText.perform(replaceText("h"), closeSoftKeyboard());

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.input1),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.input_v1),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("h"), closeSoftKeyboard());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.input2),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.input_v2),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText3.perform(replaceText("1234"), closeSoftKeyboard());

        pressBack();

        ViewInteraction textInputEditText4 = onView(
                allOf(withId(R.id.input3),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.input_v3),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText4.perform(replaceText("10-06-"), closeSoftKeyboard());

        pressBack();

        ViewInteraction textInputEditText5 = onView(
                allOf(withId(R.id.input3), withText("10-06-"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.input_v3),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText5.perform(replaceText("10-06-2020"));

        ViewInteraction textInputEditText6 = onView(
                allOf(withId(R.id.input3), withText("10-06-2020"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.input_v3),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText6.perform(closeSoftKeyboard());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.register), withText("Make Reservation"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.fragment_container),
                                        0),
                                4),
                        isDisplayed()));
        appCompatButton3.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
