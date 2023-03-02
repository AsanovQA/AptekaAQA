package ru.apteka.tests.android;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        OnboardingTest.class,
        DistrictTest.class
})
public class JunitTestSuiteAndroid {
}
