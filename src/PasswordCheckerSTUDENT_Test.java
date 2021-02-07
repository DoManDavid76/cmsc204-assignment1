
//@author David Do

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */



public class PasswordCheckerSTUDENT_Test {
	PasswordCheckerUtility utility = new PasswordCheckerUtility();
	ArrayList<String> passwords;
	@Before
	public void setUp() throws Exception {
		String[] password = { "a1A#b1Bc1Cd1D", "334455BB#", "Im2cool4U#", "george2ZZZ#", "4Sale#e",
				"bertha22", "march#"};
		passwords = new ArrayList<>();
		passwords.addAll(Arrays.asList(password));
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("abcABC123@"));
			PasswordCheckerUtility.isValidPassword("lol90");
			assertTrue("Did not throw lengthException", false);
		} catch (LengthException e) {
			assertTrue("Successfully threw a LengthException", true);
		} catch (Exception e) {
			assertTrue("Threw a different exception instead of LengthException", false);
		}	
		
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("ihaveCAPS!!2"));
			PasswordCheckerUtility.isValidPassword("whatiscap");
			assertTrue("Did not throw NoUpperAlphaException", false);
		} catch (NoUpperAlphaException e) {
			assertTrue("Successfully threw a NoUpperAlphaException", true);
		} catch (Exception e) {
			assertTrue("Threw a different exception instead of NoUpperAlphaException", false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("iamCAlm1@3"));
			PasswordCheckerUtility.isValidPassword("STOPSCREAMING1%6");
			assertTrue("Did not throw a NoLowerAlphaException", false);
		} catch (NoLowerAlphaException e) {
			assertTrue("Successfully threw a NoLowerAlphaException", true);
		} catch (Exception e) {
			assertTrue("Threw a different exception instead on NoLowerAlphaException", false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("abcABC123@"));
			PasswordCheckerUtility.isValidPassword("ABCDEF");
			assertTrue("Did not throw a NoLowerAlphaException", false);
		} catch (NoLowerAlphaException e) {
			assertTrue("Successfully threw a NoLowerAlphaException", true);
		} catch (Exception e) {
			assertTrue("Threw a different exception instead on NoLowerAlphaException", false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() 
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("abcABC1233@"));
			PasswordCheckerUtility.isValidPassword("abccccABC12333@");
			assertTrue("Did not throw InvalidSequenceException", false);
		} catch (InvalidSequenceException e) {
			assertTrue("Successfully threw a InvalidSequenceException", true);
		} catch (Exception e) {
			assertTrue("Threw a different exception instead of InvalidSequenceException", false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("abcABC123@"));
			PasswordCheckerUtility.isValidPassword("abcABC!");
			assertTrue("Did not throw NoDigitException", false);
		} catch (NoDigitException e) {
			assertTrue("Successfully threw a NoDigitException", true);
		} catch (Exception e) {
			assertTrue("Threw a different exception instead of InvalidSequenceException", false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			PasswordCheckerUtility.isValidPassword("abcABC123@");
			PasswordCheckerUtility.isValidPassword("Password123!");
			PasswordCheckerUtility.isValidPassword("AczasC231@");
			assertTrue("No exceptions thrown", true);		
		} catch (Exception e) {
			assertTrue("Should not have thrown any exceptions", false);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
	
		ArrayList<String> invalidArray = new ArrayList<>();
		 invalidArray = utility.getInvalidPasswords(passwords);
		 assertEquals(invalidArray.size(), 4);
		
	}
	
}