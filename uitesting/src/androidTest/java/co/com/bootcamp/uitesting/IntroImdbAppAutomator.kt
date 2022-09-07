package co.com.bootcamp.uitesting

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class IntroImdbAppAutomator {

    private lateinit var device: UiDevice

    @Test
    fun useAppContext() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        device.pressHome()

        // Wait for launcher
        val launcherPackage = device.launcherPackageName
        assertThat(launcherPackage, notNullValue())

        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT)

        // Launch the app
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE)?.apply {
            // Clear out any previous instances
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        context.startActivity(intent)

        // Wait for the app to appear
        device.wait(
            Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
            LAUNCH_TIMEOUT
        )

        device.wait(
            Until.findObjects(By.textContains("User")), LAUNCH_TIMEOUT
        )

        device.findObject(UiSelector().descriptionContains("Input Content Description for User")).text =
            "Usuario nuevo"

    }

    companion object {
        private const val LAUNCH_TIMEOUT = 5000L
        private const val BASIC_SAMPLE_PACKAGE = "co.com.esteban.imdbapp"
    }
}