package com.entain.cicdtest

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class LoginTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<LoginActivity>()

    @Test
    fun testSuccessfulLogin() {
        // Enter username
        composeTestRule.onNodeWithTag("usernameInput")
            .performTextInput("rishi")

        // Enter password
        composeTestRule.onNodeWithTag("passwordInput")
            .performTextInput("panchal")

        // Click login button
        composeTestRule.onNodeWithTag("loginButton")
            .performClick()

        // Verify that the main screen is displayed
        composeTestRule.onNodeWithTag("mainScreenElement")
            .assertIsDisplayed()
    }
}