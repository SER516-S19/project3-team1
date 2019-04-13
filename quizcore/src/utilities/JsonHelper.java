package utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * The {@code JsonHelper} class contains the json util functions
 */
public class JsonHelper {

    /**
     * Converts an {@code Object} type to {@code String} type
     * in json format
     * @param instance represents the {@code Object} to be serialized
     * @return serialized {@code String}
     */
    public static String serialize(Object instance) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(instance);
    }

    /**
     * Converts a {@code String} in json format to {@code Object} type
     * @param jsonString represents the json {@code String} to be converted
     * @param type represents the target conversion type
     * @param <T> represents a generic {@code Class} {@code Type}
     * @return the converted object in target {@code Type} T
     */
    public static <T> T deserialize(String jsonString, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, type);
    }
}

