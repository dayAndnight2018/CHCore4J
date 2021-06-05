package com.chenghua.test;

import com.chenghua.exceptions.CollectionNullOrEmptyException;
import com.chenghua.exceptions.InvalidConstructorArgs;
import com.chenghua.exceptions.InvalidInputException;
import com.chenghua.ios.PropertyUtils;

import java.io.File;
import java.io.IOException;
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

		Properties properties = PropertyUtils.loadProperties("test.txt");
		properties.list(System.out);
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
