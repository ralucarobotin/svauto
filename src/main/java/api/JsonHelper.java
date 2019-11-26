package api;

import com.google.gson.Gson;

class JsonHelper {
    private Gson gson = new Gson();

    /**
     * Parse java objects to Json
     * @param jsonString response call in jsonFormat
     * @param cls mapping the response to the desired class
     * @return jsonFormatString
     */
    Object  parseJsonToJava(String jsonString, Class cls){
       return gson.fromJson(jsonString, cls);
    }

    /**
     * Parse java objects to Json
     * @param object Java object used for call payload
     * @return jsonFormatString
     */
    String parseJavaObjectsToJson(Object object){
       return gson.toJson(object);
    }

}
