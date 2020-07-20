package com.chenghua.test;

import com.chenghua.collections.ArrayUtils;
import com.chenghua.exceptions.CollectionNullOrEmptyException;
import com.chenghua.exceptions.InvalidConstructorArgs;
import com.chenghua.exceptions.InvalidInputException;
import com.chenghua.datetime.DateFormatPatternEnum;
import com.chenghua.datetime.DateTime;
import com.chenghua.ios.FileUtils;
import com.chenghua.random.Random;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;

public class Test {

	public static void main(String[] args) throws InvalidInputException, InvalidConstructorArgs, CollectionNullOrEmptyException {
		// TODO Auto-generated method stub
		//DateTime dateTime = new DateTime();
		//dateTime.setMinute(0);
		//System.out.println(dateTime.description2());
		//System.out.println(dateTime.format(DateFormatPatternEnum.SHORT_TIME));


		ArrayUtils.print(FileUtils.getFiles("/Users"),null);
		System.out.println();
	}

}
