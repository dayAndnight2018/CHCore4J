package com.chenghua.extendslite;

import java.util.Random;
import com.chenghua.exceptions.InValidInputException;

public class StringExtends 
{
	/**
	 * check string is null or whitespace
	 * @param string
	 * @return is null or whitespace
	 */
	public static boolean isBlank(String string)
	{
		return string == null || string.trim().isEmpty();
	}
	
	/**
	 * subString extends
	 * @param string source String
	 * @param start start Index
	 * @param len  the length you want get	
	 * @return  subString
	 * @throws InValidInputException(The start index or length is invalid.)
	 */
	public static String subString(String string,int start, int len) throws InValidInputException
	{
		if(isBlank(string))
		{
			return null;
		}
		int length = string.length();
		
		if(start < 0 || len <= 0 )
		{
			throw new InValidInputException("The inputs are invalid.");
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
	public static String randomDigitString(int len) throws InValidInputException
	{
		if(len <= 0)
		{
			throw new InValidInputException("The length of the String is below zero.");
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
	 * @throws InValidInputException(The length of the String is below zero.)
	 */
	public static String randomLetterString(int len) throws InValidInputException
	{
		if(len <= 0)
		{
			throw new InValidInputException("The length of the String is below zero.");
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
	 * @throws InValidInputException(The length of the String is below zero.)
	 */
	public static String randomString(int len) throws InValidInputException
	{
		if(len <= 0)
		{
			throw new InValidInputException("The length of the String is below zero.");
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
	 * @throws InValidInputException(The digits is invalid.)
	 */
	public static String round(double source, int digits) throws InValidInputException
	{
		if(digits < 0)
		{
			throw new InValidInputException();
		}		
		return String.format("%." + digits + "f", source);
	}
	
	
}
