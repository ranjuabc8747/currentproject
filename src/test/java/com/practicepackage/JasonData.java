package com.practicepackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JasonData {
public static void main(String[] args) throws Throwable {
	
	JSONParser P=new JSONParser();
		Object obj = P.parse(new FileReader(".\\src\\test\\resources\\abc.jason"));
		JSONObject map = (JSONObject) obj;
		System.out.println(map.get("browser"));
		System.out.println( map.get("aurl"));
		System.out.println(map.get("ausername"));
		System.out.println(map.get("apassword"));


	}

}
