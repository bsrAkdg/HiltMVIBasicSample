package com.bsrakdg.hiltmvibasicsample

import androidx.fragment.app.testing.launchFragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.launchActivity
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import com.bsrakdg.hiltmvibasicsample.di.AppModule
import com.bsrakdg.hiltmvibasicsample.ui.MainActivity
import com.bsrakdg.hiltmvibasicsample.ui.MainFragment
import com.bsrakdg.hiltmvibasicsample.ui.MainFragmentFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.UninstallModules
import org.hamcrest.CoreMatchers.containsString
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Singleton

@UninstallModules(AppModule::class)
@HiltAndroidTest
class MainTest {

    @get:Rule // (order = 0)
    var hiltRule = HiltAndroidRule(this)

    /*
    @get:Rule(order = 1)
    var someRule = SomeRule()
    */

    @Inject
    lateinit var someString: String

    @Inject
    lateinit var fragmentFactory: MainFragmentFactory

    @Before
    fun init() {
        hiltRule.inject() // you should use it before each test class
    }

    @Test
    fun someTest() {
        // use some thing
        assertThat(someString, containsString("TEST"))
    }

    @Test
    fun mainActivityTest() {
        val scenario = launchActivity<MainActivity>()
    }

    @Test
    fun mainFragmentTest() {
        // hilt do not support launchFragmentInContainer
        // https://developer.android.com/training/dependency-injection/hilt-testing#launchfragment

        val scenario = launchFragmentInHiltContainer<MainFragment>(
            factory = fragmentFactory
        ) {

        }
    }

    @Module
    @InstallIn(ApplicationComponent::class)
    object AppModule {

        @Singleton
        @Provides
        fun provideSomeString(): String {
            return "TEST BLA BLA"
        }
    }
}