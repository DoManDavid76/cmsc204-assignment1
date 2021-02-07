
/**@author David Do
 * CMSC 204
 * 2/7/21
 */

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility extends java.lang.Object{

	/**
	 * Compare equality of two passwords
	 * @param password
	 * @param passwordConfirm
	 * @throws UnmatchedException - thrown if not same length
	 */
	public static void comparePasswords(java.lang.String password, java.lang.String passwordConfirm) throws UnmatchedException {
		  if(!password.equals(passwordConfirm)){
	            throw new UnmatchedException();
	        }
	}
	/**
	 * Compare two passwords( with return) to check similarities
	 * @param password
	 * @param passwordConfirm
	 * @return false if two passwords are not the same - else true
	 */
	public static boolean comparePasswordsWithReturn(java.lang.String password, java.lang.String passwordConfirm) {
		if (password.equals(passwordConfirm)) 
			return true;
		else
			return false;
	}
	
	/**
	 * Reads a file of passwords and the passwords that failed the check will be added to an invalidPasswords with the reason
	 * @param passwords
	 * @return an array of invalidPasswords
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static java.util.ArrayList<java.lang.String> getInvalidPasswords(java.util.ArrayList<java.lang.String> passwords){
		ArrayList<String> invalidPasswords = new ArrayList<>();
		for (String onePassword: passwords) 
		{
			try{
				isValidPassword(onePassword);
				}
			catch(Exception e) {
				invalidPasswords.add(onePassword.concat(" -> ").concat(e.getMessage()));
			}
				
		}
		
		return invalidPasswords;

	}
	
	/**
	 * Checks the password length requirement - – The password must be at least 6 characters long
	 * @param password - password string to be checked
	 * @return true if the password meet requirement
	 * @throws LengthException  - thrown if does not meet min length requirement (6)
	 */
	public static boolean hasBetweenSixAndNineChars(java.lang.String password) {
		int length = password.length();
		
		if(length >= 6 && length <= 9) 
			return true;
		else 
			return false;
		
	}
	
	/**
	 * Checks the password Digit requirement - Password must contain a numeric character
	 * @param password - password string to be checked for Digit requirement
	 * @return true if meet Digit requirement
	 * @throws NoDigitException -thrown if does not meet Digit requirement
	 */
	public static boolean hasDigit(java.lang.String password) throws NoDigitException{
		
		for(int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if(Character.isDigit(c)) {
				return true;
			}
		}
		throw new NoDigitException();
	}
	
	/**
	 * Checks the password lower case requirement - Password must contain a lower case alpha character
	 * @param password - password string to be checked
	 * @return true if password has an lower case alpha
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha(java.lang.String password) throws NoLowerAlphaException{
		boolean holder = false;
		
		for(int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if(Character.isLowerCase(c)) {
				holder = true;
			}
		}
		if(holder != true)
			throw new NoLowerAlphaException();
		return holder;
	}

	/**
	 * Checks the password Sequence requirement - Password should not contain more than 2 of the same character in sequence
	 * @param password - password to be checked
	 * @return false if does NOT meet Sequence requirement
	 * @throws InvalidSequenceException - thrown if does not meet Sequence requirement
	 */
	public static boolean hasSameCharInSequence(java.lang.String password) throws InvalidSequenceException {
	
		for(int i = 0; i < password.length()-2 ; i++) {
			
			if(password.charAt(i) == password.charAt(i+1))
			{
				if(password.charAt(i) == password.charAt(i+2))
					throw new InvalidSequenceException();
			}
		}
		return false;

	}
	
	public static boolean hasSpecialChar(java.lang.String password) throws NoSpecialCharacterException {
		
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		if( !matcher.matches())
			return true;
		else
			throw new NoSpecialCharacterException();

		
//		boolean holder = false;		
//		for(int i = 0; i < password.length(); i++) {
//			char c = password.charAt(i);
//			int ascii = c;
//			if(ascii < 65 || ascii > 122) {
//				holder = true;
//			}
//		}
//		return holder;
	}
	
	/**
	 * Checks the password alpha character requirement - Password must contain an uppercase alpha character
	 * @param p - password string to be checked
	 * @return true if password has an upper case alpha
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha(java.lang.String password) throws NoUpperAlphaException{
		boolean holder = false;
		
		for(int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if(Character.isUpperCase(c)) {
				holder = true;
			}
		}
		if(holder != true)
			throw new NoUpperAlphaException();
		return holder;
	}

	public static boolean isValidLength(java.lang.String password) throws LengthException{
		if(password.length() >=6) 
			return true;
		throw new LengthException();
		}
	
	public static boolean isValidPassword(java.lang.String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
		
		if(isValidLength(password)&& hasUpperAlpha(password)&&hasLowerAlpha(password)&&
			       hasDigit(password)&& hasSpecialChar(password) && !hasSameCharInSequence(password))
				return true;
				else 
					return false;
		
	}
	
	public static boolean isWeakPassword(java.lang.String password) throws WeakPasswordException{
		
		if( hasBetweenSixAndNineChars(password))
			throw new WeakPasswordException();
		else
			return false;

		
	}

}
	
	


