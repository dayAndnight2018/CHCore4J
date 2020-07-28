package com.chenghua.extendslite;

import java.util.Random;
import com.chenghua.exceptions.InvalidInputException;

public class StringExtends 
{
	public static final String EMPTY = "";
	public static final String ONE_SPACE = " ";
	/**
	 * check string is null or whitespace
	 * @param string
	 * @return is null or whitespace
	 */
	public static boolean isBlank(String string) {
		return string == null || string.trim().isEmpty();
	}

	/**
	 * judge is not blank
	 * @param s
	 * @return
	 */
	public static boolean isNotBlank(String s){
		return !isBlank(s);
	}
	
	/**
	 * subString extends
	 * @param string source String
	 * @param start start Index
	 * @param len  the length you want get	
	 * @return  subString
	 * @throws InvalidInputException(The start index or length is invalid)
	 */
	public static String subString(String string, int start, int len) throws InvalidInputException
	{
		if(isBlank(string))
		{
			return null;
		}

		int length = string.length();
		if(start < 0 || len <= 0 || start > length)
		{
			throw new InvalidInputException("The inputs are invalid.");
		}
		if(start + len > length)
		{
			len = length - start;
		}
		
		return string.substring(start, start + len);
	}
	
	/**
	 * random digit numbers
	 * @param len
	 * @return random String
	 */
	public static String randomDigitString(int len) throws InvalidInputException
	{
		if(len <= 0)
		{
			throw new InvalidInputException("The length of the String is below zero.");
		}
		
		StringBuilder sb = new StringBuilder();
        String numbers = "0123456789";
        int length  = numbers.length();
        
        Random rand = new Random();
        for (int i = 0; i < len; i++)
        {
            sb.append(numbers.charAt(rand.nextInt(length)));
        }
        return sb.toString();
	}
	
	/**
	 * random letters
	 * @param len
	 * @return Letters String
	 * @throws InvalidInputException(The length of the String is below zero)
	 */
	public static String randomLetterString(int len) throws InvalidInputException
	{
		if(len <= 0)
		{
			throw new InvalidInputException("The length of the String is below zero.");
		}
		
		StringBuilder sb = new StringBuilder();
        String numbers = "abcdefghighlmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int length  = numbers.length();
        
        Random rand = new Random();
        for (int i = 0; i < len; i++)
        {
            sb.append(numbers.charAt(rand.nextInt(length)));
        }
        return sb.toString();
	}
	
	/**
	 * random String
	 * @param len
	 * @return random String
	 * @throws InvalidInputException(The length of the String is below zero)
	 */
	public static String randomString(int len) throws InvalidInputException
	{
		if(len <= 0)
		{
			throw new InvalidInputException("The length of the String is below zero.");
		}
		
		StringBuilder sb = new StringBuilder();
        String numbers = "0123456789abcdefghighlmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int length  = numbers.length();
        
        Random rand = new Random();
        for (int i = 0; i < len; i++)
        {
            sb.append(numbers.charAt(rand.nextInt(length)));
        }
        return sb.toString();
	}

	/**
	 * get number rounded
	 * @param source source double
	 * @param digits digits
	 * @return rounded number String
	 * @throws InvalidInputException(The digits is invalid)
	 */
	public static String round(double source, int digits) throws InvalidInputException
	{
		if(digits < 0)
		{
			throw new InvalidInputException();
		}		
		return String.format("%." + digits + "f", source);
	}

	/**
	 * if test in str
	 * @param test
	 * @param str
	 * @return
	 */
	public static boolean isSubStringOf(String test, String str){
		if(isBlank(str)){
			return false;
		}

		if(isBlank(test)){
			return true;
		}

		return (str.indexOf(test)!= -1);
	}
	
	
}
