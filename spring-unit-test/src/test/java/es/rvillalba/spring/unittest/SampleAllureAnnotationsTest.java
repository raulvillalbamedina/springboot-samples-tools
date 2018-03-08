package es.rvillalba.spring.unittest;

import org.junit.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Issue;
import io.qameta.allure.Issues;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SampleAllureAnnotationsTest extends SpringUnitTestParent {

    @Test
    @DisplayName("Using display name")
    public void displayNameAnnotation() {
        log.debug("test");
    }

    @Test
    @Description("Using description")
    public void descriptionAnnotation() {
        log.debug("test");
    }

    @Test
    @Feature("Using feature")
    public void featureAnnotation() {
        log.debug("test");
    }

    @Test
    @Features({@Feature("Using feature"), @Feature("Second feature")})
    public void featuresAnnotation() {
        log.debug("test");
    }

    @Test
    @Issue("Using issue")
    public void issueAnnotation() {
        log.debug("test");
    }

    @Test
    @Issues({@Issue("Using issue"), @Issue("Second issue")})
    public void issuesAnnotation() {
        log.debug("test");
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void severityBlockerAnnotation() {
        log.debug("test");
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    public void severityMinorAnnotation() {
        log.debug("test");
    }

    @Test
    @Link("http://www.mijirapreferido")
    public void linkAnnotation() {
        log.debug("test");
    }

    @Test
    public void stepsAnnotation() {
        log.debug("test");
        step1();
        step2();
    }

    @Step("Step 2")
    private void step2() {
        log.debug("2");
    }

    @Step("Step 1")
    private void step1() {
        log.debug("1");
    }

    @Test
    @Story("Using story")
    public void storyAnnotation() {
        log.debug("test");
    }
}
