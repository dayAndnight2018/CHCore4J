package com.chenghua.test;

import java.util.Date;

import com.chenghua.exceptions.InValidConstructorArgs;
import com.chenghua.exceptions.InValidInputException;
import com.chenghua.extendslite.DateTime;
import com.chenghua.extendslite.StringExtends;

public class Test {

	public static void main(String[] args) throws InValidInputException, InValidConstructorArgs {
		// TODO Auto-generated method stub
		DateTime dateTime = new DateTime();
		dateTime.setDay(14);
		System.out.println(dateTime);
		System.out.println(dateTime.toDateTimeString());
	}

}
