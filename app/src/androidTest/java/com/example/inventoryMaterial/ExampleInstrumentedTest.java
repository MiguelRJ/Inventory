package com.example.inventoryMaterial;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.espresso.Espresso;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 * 1. El usuario introduce usuario/email (Instrumental)
 * 2. El usuario introduce una contraseña (Instrumental)
 * 3. La contraseña tiene al menos 6 caracteres (Instrumental)
 * 4. Doble comprobacion de la contraseña (Instrumental)
 * 
 * https://developer.android.com/training/testing/ui-testing/espresso-testing.html
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    /**
     * Comprueba que el campo User no es vacio
     */
    @Test
    public void isUserEmpty() {
        onView(withId(R.id.btnSignIn)).perform(click());
        checkSnackBarDisplayByMessage(R.string.errorUserEmpty);
    }

    /**
     * Comprueba que el Email no es vacio
     */
    @Test
    public void isEmailEmpty() {
        onView(withId(R.id.btnSignIn)).perform(click());
        checkSnackBarDisplayByMessage(R.string.errorEmailEmpty);
    }

    /**
     * Comprueba que el password no es vacio
     */
    @Test
    public void isPasswordEmpty() {
        onView(withId(R.id.btnSignIn)).perform(click());
        checkSnackBarDisplayByMessage(R.string.errorPasswordEmpty);
    }

    /**
     * Comprueba que la longitud de la cotraseña es correcta
     */
    @Test
    public void passwordLenght() {
        onView(withId(R.id.edtUser)).perform(typeText("lourdes"),closeSoftKeyboard());
        onView(withId(R.id.edtPassword)).perform(typeText("lu"),closeSoftKeyboard());
        onView(withId(R.id.btnSignIn)).perform(click());
        checkSnackBarDisplayByMessage(R.string.errorPasswordLength);
    }

    /**
     *
     */
    @Test
    public void passwordDoubleCheck() {

    }

    private void checkSnackBarDisplayByMessage(@StringRes int message) {
        onView(withText(message)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

}
