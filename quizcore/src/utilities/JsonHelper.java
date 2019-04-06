package utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonHelper {

    public static String serialize(Object instance) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(instance);
    }

    public static <T> T deserialize(String jsonString, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, type);
    }

}

