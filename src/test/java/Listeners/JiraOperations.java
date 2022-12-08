package Listeners;

import net.sf.json.JSONObject;
import org.apache.hc.client5.http.entity.mime.ContentBody;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.util.EntityUtils;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class JiraOperations {

    String jiraURL="https://eloufy.atlassian.net";
    String jiraUserName="mohamedeloufy1995@gmail.com";
    String jiraAccessKey="A6TnEgJNYpHes8qOJzvQ30BF";


    public String createJiraIssue(String ProjectName, String issueSummary, String issueDescription, String component, String priority, String label, String env, String assignee) throws IOException, ParseException, org.json.simple.parser.ParseException {
        String issueId=null;
        HttpClient httpClient = (HttpClient) HttpClientBuilder.create().build();
        String url = jiraURL+"/rest/api/3/issue";
        HttpPost postRequest = new HttpPost(url);
        postRequest.addHeader("content-type", "application/json");

        String encoding = Base64.getEncoder().encodeToString((jiraUserName+":"+jiraAccessKey).getBytes());
        //String encoding = base.encode((jiraUserName+":"+jiraAccessKey).getBytes());
        postRequest.setHeader("Authorization", "Basic " + encoding);


        StringEntity params = new StringEntity(createPayloadForCreateJiraIssue(ProjectName, issueSummary, issueDescription, component, priority, label, env, assignee));
        postRequest.setEntity(params);
        HttpResponse response = httpClient.execute(postRequest);


        String jsonString = EntityUtils.toString(response.getEntity());

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(jsonString);

        issueId = (String) json.get("key");


        return issueId;

    }
    public void addAttachmentToJiraIssue(String issueId, String filePath) throws ClientProtocolException, IOException
    {
        String pathname= filePath;
        File fileUpload = new File(pathname);

        HttpClient httpClient = (HttpClient) HttpClientBuilder.create().build();
        String url = jiraURL+"/rest/api/3/issue/"+issueId+"/attachments";
        HttpPost postRequest = new HttpPost(url);

        //BASE64Encoder base=new BASE64Encoder();
        //String encoding = base.encode((jiraUserName+":"+jiraAccessKey).getBytes());
        String encoding = Base64.getEncoder().encodeToString((jiraUserName+":"+jiraAccessKey).getBytes());

        postRequest.setHeader("Authorization", "Basic " + encoding);
        postRequest.setHeader("X-Atlassian-Token","nocheck");

        MultipartEntityBuilder entity=MultipartEntityBuilder.create();
        entity.addPart("file", (ContentBody) new FileBody(fileUpload));
        postRequest.setEntity((HttpEntity) entity.build());
        HttpResponse response = httpClient.execute(postRequest);
        System.out.println(response.getStatusLine());

        if(response.getStatusLine().toString().contains("200 OK")){
            System.out.println("Attachment uploaded");
        } else{
            System.out.println("Attachment not uploaded");
        }
    }










    private static String createPayloadForCreateJiraIssue(String ProjectName, String issueSummary, String issueDescription, String componentId, String priority, String label, String env, String assigneeId) {
        return "{\r\n" +
                "    \"fields\": {\r\n" +
                "       \"project\":\r\n" +
                "       {\r\n" +
                "          \"key\": \""+ProjectName+"\"\r\n" +
                "       },\r\n" +
                "       \"summary\": \""+issueSummary+"\",\r\n" +
                "	   \"description\": {\r\n" +
                "          \"type\": \"doc\",\r\n" +
                "          \"version\": 1,\r\n" +
                "          \"content\": [\r\n" +
                "				{\r\n" +
                "                    \"type\": \"paragraph\",\r\n" +
                "                    \"content\": [\r\n" +
                "								{\r\n" +
                "                                    \"text\": \""+issueDescription+"\",\r\n" +
                "                                    \"type\": \"text\"\r\n" +
                "								}\r\n" +
                "							   ]\r\n" +
                "				}\r\n" +
                "					]\r\n" +
                "						}, \r\n" +
                "		\"issuetype\": {\r\n" +
                "          \"name\": \"Bug\"\r\n" +
                "       },\r\n" +
                "      \"components\": [\r\n" +
                "      {\r\n" +
                "        \"id\": \""+componentId+"\"\r\n" +
                "      }\r\n" +
                "    ],\r\n" +
                "    \"priority\": {\r\n" +
                "      \"id\": \""+priority+"\"\r\n" +
                "    },\r\n" +
                "        \"labels\": [\r\n" +
                "      \""+label+"\"\r\n" +
                "    ],\r\n" +
                "    	\"environment\": {\r\n" +
                "      \"type\": \"doc\",\r\n" +
                "      \"version\": 1,\r\n" +
                "      \"content\": [\r\n" +
                "        {\r\n" +
                "          \"type\": \"paragraph\",\r\n" +
                "          \"content\": [\r\n" +
                "            {\r\n" +
                "              \"text\": \""+env+"\",\r\n" +
                "              \"type\": \"text\"\r\n" +
                "            }\r\n" +
                "          ]\r\n" +
                "        }\r\n" +
                "      ]\r\n" +
                "    },\r\n" +
                "    	\"assignee\": {\r\n" +
                "      \"id\": \""+assigneeId+"\"\r\n" +
                "    }\r\n" +
                "}\r\n" +
                "}";
    }


}
