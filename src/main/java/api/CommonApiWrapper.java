package api;

import java.io.IOException;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import helpers.Utilities;

public class CommonApiWrapper {
    private static final Logger logger = Logger.getLogger(CommonApiWrapper.class.getName());
    private HttpClient httpclient = HttpClients.createDefault();
    private JsonHelper jsonHelper = new JsonHelper();
    protected String baseUrl = Utilities.getPropertyFromAppProp("baseUrl");

    protected Object post(Object payload, String endpoint) throws IOException {
        HttpPost httpPost = new HttpPost(endpoint);
        logger.info("Post HTTP method initialized" + httpPost);
        StringEntity requestEntity = new StringEntity(jsonHelper.parseJavaObjectsToJson(payload), ContentType.APPLICATION_JSON);
        logger.info("POST REQUEST " + jsonHelper.parseJavaObjectsToJson(payload));
        httpPost.setEntity(requestEntity);
        HttpResponse response = httpclient.execute(httpPost);
        Object responseDto = jsonHelper.parseJsonToJava(EntityUtils.toString(response.getEntity()
        ), payload.getClass());
        logger.info("POST RESPONSE " + jsonHelper.parseJavaObjectsToJson(responseDto));

        return responseDto;
    }

    protected Object get(Object payload, String endpoint) throws IOException {
        HttpGet httpGet = new HttpGet(endpoint);
        logger.info("Get HTTP method initialized" + httpGet);
        HttpResponse response = httpclient.execute(httpGet);
        Object responseDto = jsonHelper.parseJsonToJava(EntityUtils.toString(response.getEntity()
        ), payload.getClass());
        logger.info("GET RESPONSE " + jsonHelper.parseJavaObjectsToJson(responseDto));

        return responseDto;
    }
}
