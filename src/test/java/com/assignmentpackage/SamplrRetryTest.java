package com.assignmentpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.foodordering.genericutility.BaseClass;

public class SamplrRetryTest  extends BaseClass{
	
@Test(retryAnalyzer=com.foodordering.genericutility.RetryImpl.class)

public void retryTest()
{
	Assert.assertEquals("A", "B");
}
}
