package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import java.util.List;

public class JsonUtils{
    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> boolean isListHasValidJson(List<T> list){
        try {
            for (T item : list) {
                objectMapper.writeValueAsString(item);
            }
        } catch (MismatchedInputException e) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}