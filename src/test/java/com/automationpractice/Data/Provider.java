package com.automationpractice.Data;

public interface Provider {
	
	Object getData( String objectName, Class className, String path );
	
}
