/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String string1 = preProcess(str1); 
		String string2 = preProcess(str2); 
		boolean check;
		int counter = 0; 
		
		if (string1.length() != string2.length()) {
			check = false; 
		
		} else {
			int i = 0;
			while (i < string1.length()) {
				boolean matchFound = false; 
				for (int j = 0; j < string2.length(); j++) {
					if (string1.charAt(i) == string2.charAt(j)) {
						counter ++; 
						matchFound = true;
						break; 
					} 
				}
				if (matchFound == false) {
					check = false; 
					break; 
				}
				i++; 
			}
			if (counter == string1.length()) {
				check = true; 
			} else {
				check = false; 
			}
		}
		return check;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String output = ""; 
		int i = 0; 
		while (i < str.length()) {
			if ((str).charAt(i) >= 97 && (str).charAt(i) <= 122) {
				output += (str).charAt(i) ; 
			}
			if ((str).charAt(i) >= 65 && (str).charAt(i) <= 90) {
				char lowerCase = (char) ((str).charAt(i) + 32); 
				output += lowerCase; 
			}
			i++; 
		}
		return output;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String input = preProcess(str); 
		String output = ""; 
		for (int i = 0; input.length() > 1; i++) {
			int index = (int) (Math.random() * input.length()); 
			output += input.charAt(index); 
			input = removeCharAt(input, index); 
		}
		if (input.length() == 1) {
			output += input; 
		}
		return output; 
	}

	public static String removeCharAt(String input, int index) { 
        String output = ""; 
        if (input.length() == 1) {
            output = ""; 
        } else if (input.length() == 2) {
            if (index == 0) {
                output += input.charAt(1);
            } else if (index == 1) {
                output += input.charAt(0);
            }
        } else if (input.length() == 3) {
            if (index == 0) {
                output += input.substring(1);
            } else if (index == 1) {
                output += input.charAt(0) + input.charAt(2); 
            } else if (index == 2) {
                output += input.substring(0, 2); 
            }
        } else {
            if (index == 0) {
                output += input.substring(1); 
            } else if (index == (input.length() - 1)) {
                output += input.substring(0, (input.length() - 1)); 
            } else {
                output += input.substring(0, index) + input.substring(index + 1); 
            }
        }
        return output; 
    }
}

