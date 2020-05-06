package practiceFRQs.practice_4_1;

public class CheckDigit {
	// WRITING this method is
	// NOT part of the sample question
	// needed in order to type up and
	// test student code
	// Returns the check digit for num
	// Pre: The number of digits in num is >=1 and <=6 and num >= 0
	public static int getCheck(int num) {
		// made up a check algorithm
		// just for fun

		// sum all odd digits
		// multiply sum by 3
		// mod sum by 10

		int sum = 0;
		while (num > 0) {
			int dig = num % 10;
			if (dig % 2 != 0)
				sum += dig;
			num /= 10;
		}
		sum *= 3;
		return sum % 10;
	}

	// PART A - WRITE THE CODE FOR THIS PART
	// Returns true if numWithCheckDigit is valid
	// numWithCheckDigit is valid if
	// the right most digit is the check value
	// for the rest of the digits to the left of the right most digit
	// 1114 is valid if the check digit for 111 is 4
	// 1126 is valid if the check digit for 112 is 6
	// Pre: The number of digits in numWithCheckDigit >=2 and <=7 and
	// numWithCheckDigit >= 0
	public static boolean isValid(int numWithCheckDigit) {
		return getCheck(numWithCheckDigit / 10) == numWithCheckDigit % 10;
	}
}

//PART B
/*
 * OPEN-ENDED SECTION
 * 
 * A programmer wants to modify the CheckDigit class to keep track of how many
 * times a call to isValid is made with an incorrect check digit. Any time a
 * call to isValid is made with an incorrect check digit, the count should be
 * increased by one. The programmer would like to implement this change without
 * making any changes to the signature of the isValid method or overloading
 * isValid.
 * 
 * Write a description of how you would change the CheckDigit class in order to
 * support this modification. DO NOT write the program code for this part.
 * 
 * Make sure to include the following in your response. • Identify any new or
 * modified variables, constants, or methods. • Describe, for each new or
 * revised variable, constant, or method, how it would change or be implemented,
 * including visibility and type.
 * 
 


 * I would add a public static int variable called invalidCount, which is set to 0 in 
 * its declaration at the top of the code. In the isValid method, instead of just determining
 * validity, I would save the validity in a boolean called valid. Then, if valid is false,
 * I would increment invalidCount. Finally valid would be returned. This is just adding a check
 * in-between the calculation and return of isValid. The invalidCount variable would count all
 * calls to isValid, and isValid is a static method, so invalidCount has to be static as well.
 * invalidCount is public for easier access by the programmer.
 */