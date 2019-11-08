package api;

import java.io.IOException;
import java.util.logging.Logger;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class CommonApiWrapper {
    private static final Logger logger = Logger.getLogger(CommonApiWrapper.class.getName());
    private HttpClient httpclient = HttpClients.createDefault();
    private JsonHelper jsonHelper = new JsonHelper();
    //protected String baseUrl = Utilities.getPropertyFromAppProp("baseUrl");//TODO - To be fixed

    private int statusCode;

    protected Object post(Object payload, String endpoint, Header[] headers, Class mapClass) {
        HttpPost httpPost = new HttpPost(endpoint);
        logger.info("Post HTTP method initialized " + httpPost);
        StringEntity requestEntity = new StringEntity(jsonHelper.parseJavaObjectsToJson(payload), ContentType.APPLICATION_JSON);
        logger.info("POST REQUEST " + jsonHelper.parseJavaObjectsToJson(payload));
        httpPost.setEntity(requestEntity);

        //Set the headers for POST call
        for (Header header : headers) {
            httpPost.setHeader(header);
        }

        HttpResponse response = null;
        try {
            response = httpclient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        statusCode = response.getStatusLine().getStatusCode();
        Object responseDto = null;
        try {
            responseDto = jsonHelper.parseJsonToJava(EntityUtils.toString(response.getEntity()),
                mapClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("POST RESPONSE " + jsonHelper.parseJavaObjectsToJson(responseDto));
        logger.info("POST HTTP RESPONSE " + statusCode);

        return responseDto;
    }

    protected Object get(Object payload, String endpoint, Header[] headers) {
        HttpGet httpGet = new HttpGet(endpoint);
        logger.info("Get HTTP method initialized " + httpGet);

        //Set the headers for GET call
        for (Header header : headers) {
            httpGet.setHeader(header);
        }

        HttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }

        statusCode = response.getStatusLine().getStatusCode();
        Object responseDto = null;
        try {
            responseDto = jsonHelper.parseJsonToJava(EntityUtils.toString(response.getEntity()
            ), payload.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("GET RESPONSE " + jsonHelper.parseJavaObjectsToJson(responseDto));
        logger.info("GET HTTP RESPONSE " + statusCode);

        return responseDto;
    }

    @Deprecated
    protected Object put(Object payload, String endpoint) {
        HttpPut httpPut = new HttpPut(endpoint);
        logger.info("Put HTTP method initialized " + httpPut);
        StringEntity requestEntity = new StringEntity(jsonHelper.parseJavaObjectsToJson(payload), ContentType.APPLICATION_JSON);
        logger.info("PUT REQUEST " + jsonHelper.parseJavaObjectsToJson(payload));
        httpPut.setEntity(requestEntity);
        HttpResponse response = null;
        try {
            response = httpclient.execute(httpPut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        statusCode = response.getStatusLine().getStatusCode();
        Object responseDto = null;
        try {
            responseDto = jsonHelper.parseJsonToJava(EntityUtils.toString(response.getEntity()
            ), payload.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("PUT RESPONSE " + jsonHelper.parseJavaObjectsToJson(responseDto));
        logger.info("PUT HTTP RESPONSE " + statusCode);

        return responseDto;
    }

    @Deprecated
    protected void delete(String endpoint) {
        HttpDelete httpDelete = new HttpDelete(endpoint);
        logger.info("Delete HTTP method initialized " + httpDelete);
        HttpResponse response = null;
        try {
            response = httpclient.execute(httpDelete);
        } catch (IOException e) {
            e.printStackTrace();
        }
        statusCode = response.getStatusLine().getStatusCode();
        logger.info("DELETE HTTP RESPONSE " + statusCode);
    }
}
