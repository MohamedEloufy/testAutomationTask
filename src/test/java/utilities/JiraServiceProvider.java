package utilities;

import net.rcarz.jiraclient.*;
import net.rcarz.jiraclient.Issue.FluentCreate;

import java.io.File;
import java.util.ArrayList;

public class JiraServiceProvider {


    public JiraClient jira;
    public String project;

    public JiraServiceProvider(String jiraUrl, String username, String password, String projectName) {
        BasicCredentials credentials = new BasicCredentials(username, password);
        jira = new JiraClient(jiraUrl, credentials);
        this.project = projectName;
    }

    public void createJiraTicket(String issueType, String summary, String description, ArrayList<String> label, String assignee, String priority, File file, String comment, String component, String reporterName) {
        try {
            FluentCreate fluentCreate = jira.createIssue(project, issueType);
            fluentCreate.field(Field.SUMMARY, summary);
            fluentCreate.field(Field.DESCRIPTION, description);
            fluentCreate.field(Field.LABELS, label);
            fluentCreate.field(Field.ASSIGNEE, assignee);
            fluentCreate.field(Field.PRIORITY, priority);
            fluentCreate.field(Field.COMPONENTS, component);
            Issue newIssue = fluentCreate.execute();
            newIssue.addAttachment(file);
            newIssue.addComment(comment);

            System.out.println("new issue created in jira with ID" + newIssue);
        } catch (JiraException e) {
            e.printStackTrace();
        }

    }
}
