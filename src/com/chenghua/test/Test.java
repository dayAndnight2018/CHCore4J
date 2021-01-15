package com.chenghua.test;

import com.chenghua.beans.AssertUtils;
import com.chenghua.beans.BeanUtils;
import com.chenghua.collections.ArrayUtils;
import com.chenghua.collections.CollectionUtils;
import com.chenghua.datetime.TimeSpan;
import com.chenghua.encrypt.EraseUtils;
import com.chenghua.exceptions.CollectionNullOrEmptyException;
import com.chenghua.exceptions.InvalidConstructorArgs;
import com.chenghua.exceptions.InvalidInputException;
import com.chenghua.datetime.DateFormatPatternEnum;
import com.chenghua.datetime.DateTime;
import com.chenghua.ios.FileUtils;
import com.chenghua.random.Random;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Test {

	public static void main(String[] args) throws InvalidInputException, InvalidConstructorArgs, CollectionNullOrEmptyException, IOException, InterruptedException {
		// TODO Auto-generated method stub
//		String rootPath = "/Users/dxm/code/payserver/robo-advisor/fund-payserver";
//		List<String> result = new ArrayList<String>();
//		FindFile(rootPath, result);
//		CollectionUtils.print(result);

		Integer a = null;
		System.out.println(BeanUtils.defaultValue(a,5));
	}

	static void FindFile(String path, List<String> result){
		Path p = Paths.get(path);
		if(Files.exists(p)){
			if(Files.isDirectory(p)){
				File[] children = new File(path).listFiles();
				for (File child : children){
					FindFile(child.getAbsolutePath(),result);
				}
			}
			else{
				if(new File(path).getName().endsWith("cpp"))
					result.add(new File(path).getName());
				return;
			}
		}
	}
}
