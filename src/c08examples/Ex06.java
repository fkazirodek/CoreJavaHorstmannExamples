package c08examples;

public class Ex06 {

	public static void main(String[] args) {
		String s = "Some_text";
		System.out.println("is characters = " + isCharacters(s));
		System.out.println("is Java identifier = " + isJavaIdentifier(s));

	}
	
	public static boolean isCharacters(String s) {
		return s.replace(" ", "")
					.codePoints()
					.allMatch(Character::isAlphabetic);
	}
	
	public static boolean isJavaIdentifier(String s) {
		return s.substring(0, 1)
					.codePoints()
					.anyMatch(Character::isJavaIdentifierStart) && 
			   s.substring(1)
					.codePoints()
					.allMatch(Character::isJavaIdentifierPart);
			  
	}

}
