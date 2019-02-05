package com.automationpractice.Data;

import lombok.SneakyThrows;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.util.HashMap;

abstract class Data {
    
    static final String USERS_VALID_PATH =
            "./src/main/resources/UsersProfiles/Valid/Users.json";
    
    static final String USERS_INVALID_PATH =
            "./src/main/resources/UsersProfiles/Invalid/Users.json";
    
    @SneakyThrows
    Object getData( String objectName, Class className, String path ) {
    
        ObjectMapper mapper = new ObjectMapper();
        File         file   = new File( path );
        Object       object;
        HashMap      map;
        
        map = mapper.readValue( file, HashMap.class );
        object = mapper.convertValue( map.get( objectName ), className );
        return object;
    }
}
