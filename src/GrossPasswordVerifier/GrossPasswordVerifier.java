/*This is Robert Gross' project written on June 27th, 2023. The purpose of the project is to test if a password
 * is strong, acceptable, or not acceptable. it does so by testing each character in the users password,
 * and increasing an integer depending on if the character meets certain criteria. If the integer is high 
 * enough, the password is strong, if not quite strong, its acceptable, and if its missing any major
 * requirements(no numbers, uppercase, lowercase, or special characters) it is determined to be weak,
 * and informs the user why
 */
package GrossPasswordVerifier;//package declaration

import java.util.Scanner;//import scanner

public class GrossPasswordVerifier {// class declaration
	public static void main(String[] args) {
		final int totalUpper = 1;// final ints for upper,lower,digits
		final int totalLower = 1;
		final int totalDigits = 1;
		final int totalSpecial = 1;
		final int totalChars = 6;
		final int strongSpecial = 2;//final ints for strong pass
		final int strongChars = 10;
		int upperCount = 0; //int for counting upper,lower,digits, and specials
		int lowerCount = 0;
		int digitCount = 0;
		int specialCount = 0;
		char[] specialChars = new char[] { '!', '@', '#', '$', '%', '&', '*', '?' };//array with specialChars
		Scanner scan = new Scanner(System.in);//create scanner
		System.out.println("Please insert a password:");//request password
		String userPass = scan.nextLine();//scan userPassword
		userPass = userPass.replaceAll("\\s","");
		int passLength = userPass.length();//determine length of password
		for (int i = 0; i < passLength; i++) { //increase the counts depending on the char
			char passLetter = userPass.charAt(i);
			if (Character.isUpperCase(passLetter)) {
				upperCount++;
			} else if (Character.isLowerCase(passLetter)) {
				lowerCount++;
			} else if (Character.isDigit(passLetter)) {
				digitCount++;
			} else if (!(Character.isDigit(passLetter))) {
				specialCount++;
			}
		}
		//if all the requirements for a Acceptable Password are met
			if (upperCount >= totalUpper && lowerCount >= totalLower && digitCount >= totalDigits &&
												specialCount>= totalSpecial && passLength>= totalChars) {
					if(passLength>= strongChars && specialCount >= strongSpecial) {//check for strong password
						System.out.println("Strong password!");
					}
					else {//if not strong, print acceptable
				System.out.println("Acceptable Password");
					}
			} else {//if not acceptable, tell user whats wrong
				System.out.println("The password didn't have enough:");
				if (totalUpper > upperCount) {
					System.out.println("UpperCase Letters");
				}
				if (totalLower > lowerCount) {
					System.out.println("LowerCase Letters");
				}
				if (totalDigits > digitCount) {
					System.out.println("Numbers");
				}
				if (totalSpecial > specialCount) {
					System.out.println("Special Characters");
				}
			}
		scan.close();//close scanner
	}
	
}
