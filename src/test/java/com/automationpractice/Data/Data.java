package com.automationpractice.Data;

import lombok.SneakyThrows;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.util.HashMap;

public class Data {

    @SneakyThrows
    public Object getData(String objectName, Class className, String path) {
        File file = new File(path);
        ObjectMapper mapper = new ObjectMapper();
        Object object;
        HashMap map;
        map = mapper.readValue(file, HashMap.class);
        object = mapper.convertValue(map.get(objectName), className);
        return object;
    }
}
