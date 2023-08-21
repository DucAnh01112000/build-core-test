package util;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class ObjectMappingUtil {
    public static String parseModelToJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
        return gson.toJson(object);
    }

    public static <T> Object parseJsonToModel(String json, Class<T> c){
        JsonDeserializer<T> jsonDeserializer = new JsonDeserializer<T>(){
            public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException{
                if(json.isJsonNull()){
                    return null;
                }
                return new Gson().fromJson(json, typeOfT);
            }
        };
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.registerTypeAdapter(c,jsonDeserializer).create();
        return gson.fromJson(json, c);
    }
    public static <T> List<T> parseJsonToModelList(String json, Class<T[]> list){
        JsonDeserializer<T> jsonDeserializer = new JsonDeserializer<T>(){
            public T deserialize(JsonElement json, Type type, JsonDeserializationContext context ) throws JsonParseException{
             if(json.isJsonNull()) return null;
             return new Gson().fromJson(json, type);
            }
        };
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.registerTypeAdapter(list, jsonDeserializer).create();
        T[] modelList = gson.fromJson(json, list);
        return Arrays.asList(modelList);
    }
}
