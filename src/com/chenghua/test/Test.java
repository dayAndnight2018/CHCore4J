package com.chenghua.test;

import com.chenghua.exceptions.CollectionNullOrEmptyException;
import com.chenghua.exceptions.InvalidConstructorArgs;
import com.chenghua.exceptions.InvalidInputException;
import com.chenghua.extendslite.OptionalString;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Test {

	public static void main(String[] args) throws InvalidInputException, InvalidConstructorArgs, CollectionNullOrEmptyException, IOException, InterruptedException {
		// TODO Auto-generated method stub
//		List<String> result = new ArrayList<String>();
//		FindFile(rootPath, result);
//		CollectionUtils.print(result);

//		Properties properties = PropertyUtils.loadProperties("test.txt");
//		properties.list(System.out);

		OptionalString nullableString = new OptionalString(null);
		nullableString.ifNotNull(System.out::println);

		String s = null;
		if (s != null) {
			System.out.println(s);
		}
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
