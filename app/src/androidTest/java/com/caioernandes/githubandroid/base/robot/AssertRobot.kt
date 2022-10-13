package com.caioernandes.githubandroid.base.robot

import androidx.annotation.LayoutRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.caioernandes.githubandroid.helpers.RecyclerViewMatchers.hasItem
import org.hamcrest.CoreMatchers.allOf

internal open class AssertRobot {

    fun viewWithText(resId: Int, text: String): ViewInteraction = matchText(textView(resId), text)

    fun viewWithTextIsVisible(resId: Int, text: String): ViewInteraction =
        onView(allOf(withId(resId), withText(text))).isVisible()

    fun viewIsVisible(@LayoutRes resId: Int): ViewInteraction =
        onView(withId(resId)).isVisible()

    fun viewWithTextInRecyclerView(@LayoutRes resId: Int, text: String) {
        onView(withId(resId)).check(matches(hasItem(hasDescendant(withText(text)))))
    }

    private fun ViewInteraction.isVisible() = check(matches(isDisplayed()))

    private fun textView(@LayoutRes resId: Int): ViewInteraction = onView(withId(resId))

    private fun matchText(viewInteraction: ViewInteraction, text: String): ViewInteraction =
        viewInteraction.check(matches(withText(text)))
}