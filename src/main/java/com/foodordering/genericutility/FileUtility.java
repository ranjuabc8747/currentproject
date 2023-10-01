package com.foodordering.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathconstants.PropertyFilepath);
		Properties p=new Properties();
		p.load(fis);
	return	p.getProperty(key);
	}

}
