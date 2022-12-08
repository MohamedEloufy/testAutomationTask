package Listeners;


import Util.jiraPolicy;
import io.qameta.allure.Severity;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.JiraServiceProvider;

import java.io.File;
import java.util.ArrayList;

import static utilities.ScreenRecordUtil.startRecord;
import static utilities.ScreenRecordUtil.stopRecord;

public class TestJiraListener implements ITestListener {
    String jiraUrl = "https://eloufy.atlassian.net";
    String jiraUserName = "mohamedeloufy1995@gmail.com";
    String jiraPassword = "A6TnEgJNYpHes8qOJzvQ30BF";
    String jiraProjectName = "EL";


    // Start video recording of test case execution
    @Override
    public void onTestStart(ITestResult result) {

        try {
            startRecord(result.getMethod().getConstructorOrMethod().getMethod().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // stop recording in case of test case pass
    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // stop recording Then create bug in jira
    @Override
    public void onTestFailure(ITestResult result) {
        // stop recording
        try {
            stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }


        // get recorded video
        String videoPath = System.getProperty("user.dir") + "/Test_recording/" + result.getMethod().getConstructorOrMethod().getName() + ".avi";
        File BugVideo = new File(videoPath);


        jiraPolicy jirapolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(jiraPolicy.class);
        boolean isTicketReady = jirapolicy.logTicketReady();
        if (isTicketReady) {
            System.out.println("is ticket ready for Jira" + true);
            JiraServiceProvider jsp = new JiraServiceProvider(jiraUrl, jiraUserName, jiraPassword, jiraProjectName);
            String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName() + " got failed due to some assertion or exception";
            String issueDescription = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(io.qameta.allure.Description.class).value() + "\n" + result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(io.qameta.allure.Step.class).value() + "\n" + result.getThrowable().getMessage() + "\n";
            //issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable())).concat(result.getMethod().getDescription());
            String priority = String.valueOf(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Severity.class).value());
            System.out.println(priority);


            // used switch statement in priority filed due to the variance between allure report priorities and jira priorities
            switch (priority) {
                case "blocker":
                case "critical":
                    priority = "Highest";
                    break;
                case "minor":
                    priority = "Medium";
                    break;
                case "normal":
                    priority = "Low";
                    break;
                case "trivial":
                    priority = "Lowest";
                    break;

            }

            jsp.createJiraTicket("Bug", issueSummary, issueDescription, new ArrayList() {{add("Regression");}}, "Mohamed Eloufy", priority, BugVideo, "helloWorld", null, "Mohamed Eloufy");
        }


    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
