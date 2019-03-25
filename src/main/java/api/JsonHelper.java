package api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

class JsonHelper {
    private ObjectMapper mapper = new ObjectMapper();

    /**
     * Parse java objects to Json
     * @param jsonString response call in jsonFormat
     * @param objectClass mapping the response to the desired class
     * @return jsonFormatString
     */
    Object parseJsonToJava(String jsonString, Object objectClass){
        Object abc = new Object();
        try{
            abc = mapper.readValue(jsonString, objectClass.getClass());
        } catch (IOException e) { e.printStackTrace();}

        return abc;
    }

    /**
     * Parse java objects to Json
     * @param parsingObject Java object used for call payload
     * @return jsonFormatString
     */
    String parseJavaObjectsToJson(Object parsingObject){
        String jsonString = null;
        try{
            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(parsingObject);
        } catch (IOException e) { e.printStackTrace();}

        return jsonString;
    }

}