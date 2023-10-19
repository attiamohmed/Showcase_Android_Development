package algonquin.cst2335.atti0019;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import algonquin.cst2335.atti0019.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
         // Added a sleep statement to match the app's execution delay.
 // The recommended way to handle such scenarios is to use Espresso idling resources:
  // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
try {
 Thread.sleep(500);
 } catch (InterruptedException e) {
 e.printStackTrace();
 }

        ViewInteraction appCompatEditText = onView(withId(R.id.tp));
        appCompatEditText.perform(click());

        appCompatEditText.perform(replaceText("1289"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.bb));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.tv));
        textView.check(matches(withText("You shall not pass!")));
        }

    @Test
    public void testValidInput() {
        ViewInteraction appCompatEditText = onView(withId(R.id.tp));
        appCompatEditText.perform(click());

        appCompatEditText.perform(replaceText("1234"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.bb));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.tv));
        textView.check(matches(withText("You shall not pass!")));

    }

    @Test
    public void testValidInput1() {
        ViewInteraction appCompatEditText = onView(withId(R.id.tp));
        appCompatEditText.perform(click());

        appCompatEditText.perform(replaceText("aaaaa"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.bb));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.tv));
        textView.check(matches(withText("You shall not pass!")));
    }

    @Test
    public void testValidInput2() {
        ViewInteraction appCompatEditText = onView(withId(R.id.tp));
        appCompatEditText.perform(click());

        appCompatEditText.perform(replaceText("AaAa"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.bb));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.tv));
        textView.check(matches(withText("You shall not pass!")));
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
                        && view.equals(((ViewGroup)parent).getChildAt(position));
            }
        };
    }
    }
