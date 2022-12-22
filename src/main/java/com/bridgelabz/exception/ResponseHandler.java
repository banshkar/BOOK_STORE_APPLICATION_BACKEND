package com.bridgelabz.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseHandler {
    
	public ResponseEntity<Object> getResponse(String message,Object object){
		 Map<String, Object>map =new HashMap<>();
		 map.put("message", message);
		 map.put("result", object);
		return new ResponseEntity<Object>(map,HttpStatus.OK);
	}
		public ResponseEntity<Object> getResponse(String message){
			 Map<String, Object>map =new HashMap<>();
			 map.put("message", message);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		}
		public ResponseEntity<Object> getResponse(String message,String token){
			 Map<String, Object>map =new HashMap<>();
			 map.put("message", message);
			 map.put("token", token);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		}
		
}
