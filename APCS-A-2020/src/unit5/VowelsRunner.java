package unit5;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto
//Date - 2/10

// import for printing outputs
import static java.lang.System.*;

public class VowelsRunner
{
	public static void main(String args[])
	{
		// run all the test cases
		System.out.println(FirstLastVowel.go("dog#cat#pigaplus"));
		System.out.println(FirstLastVowel.go("pigs#apluscompsci#food"));
		System.out.println(FirstLastVowel.go("##catgiraffeapluscompsci"));
		System.out.println(FirstLastVowel.go("apluscatsanddogsaplus###"));
		System.out.println(FirstLastVowel.go("##"));
		System.out.println(FirstLastVowel.go("aplusdog#13337#pigaplusprogram"));
		System.out.println(FirstLastVowel.go("code#H00P#code1234"));
		System.out.println(FirstLastVowel.go("##wowgira77##eplus"));
		System.out.println(FirstLastVowel.go("catsandaplusdogsaplus###"));
		System.out.println(FirstLastVowel.go("7"));
		System.out.println(FirstLastVowel.go("A"));
		System.out.println(FirstLastVowel.go("E"));
		System.out.println(FirstLastVowel.go("9AEIOUaeiou@"));
	}
}


