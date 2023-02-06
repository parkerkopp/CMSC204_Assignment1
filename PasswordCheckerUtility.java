import java.util.*;

public class PasswordCheckerUtility {
	
	public static boolean hasBetweenSixAndNineChars(String password){
		
		if(password.length() >= 6 && password.length() <= 9)
			
			return true;
		
		else
			
			return false;
		
	}

	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
		
		for(int i = 0; i < password.length()-2; i++) {
			
			if(password.charAt(i) == password.charAt(i+1) && password.charAt(i) == password.charAt(i+2))
				
				throw new InvalidSequenceException();
		}
		
		return false;
		
	}

	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		
		for(int i = 0; i < password.length(); i++) {
			
			char character = password.charAt(i);
			
			if( (character > 31 && character < 48) || (character > 57 && character < 65) || (character > 90 && character < 97) || (character > 122 && character < 127))
				
				return true;
			
		}
		
		throw new NoSpecialCharacterException();
		
	}

	public static boolean hasDigit(String password) throws NoDigitException {
		
		for(int i = 0; i < password.length(); i++) {
			
			if(password.charAt(i) > 47 && password.charAt(i) < 58)
				
				return true;
			
		}
		
		throw new NoDigitException();
		
	}

	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		
		for(int i = 0; i < password.length(); i++) {
			
			if(password.charAt(i) > 96 && password.charAt(i) < 123)
				
				return true;
			
		}
		
		throw new NoLowerAlphaException();
		
	}
	
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		
		for(int i = 0; i < password.length(); i++) {
			
			if(password.charAt(i) > 64 && password.charAt(i) < 91)
				
				return true;
			
		}
		
		throw new NoUpperAlphaException();
		
	}

	public static boolean isValidLength(String password) throws LengthException {
		
		if(password.length() >= 6)
			
			return true;
		
		else
			
			throw new LengthException();
		
	}

	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
		
		if(password.equals(passwordConfirm) == false)
			
			throw new UnmatchedException();
		
	}
	
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		
		if(password.equals(passwordConfirm) == false)
			
			return false;
		
		else
			
			return true;
		
	}

	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		
		if(isValidLength(password) == true && hasDigit(password) == true && hasUpperAlpha(password) == true && hasLowerAlpha(password) == true && hasSpecialChar(password) == true && NoSameCharInSequence(password) == false)
			
			return true;
		
		else
			
			return false;
		
	}

	public static boolean isWeakPassword(String password) throws WeakPasswordException{
		
		try {
		
			isValidPassword(password);
			
		}  catch(Exception e) {
			
			throw new WeakPasswordException();
			
		}
		
		if(hasBetweenSixAndNineChars(password) == true)
			
			throw new WeakPasswordException();
		
		return false;
		
	}

	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		
		ArrayList<String> toReturn = new ArrayList<String>();
		
		for(int i = 0; i < passwords.size(); i++) {
			
			try {
				
				isValidPassword(passwords.get(i));
				
			} catch(Exception e) {
				
				toReturn.add(passwords.get(i) + " " + e.getMessage());
				
			}
			
		}
		
		return toReturn;
		
	}
	
}
