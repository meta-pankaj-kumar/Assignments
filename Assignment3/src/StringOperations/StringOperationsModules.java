/*
 * Class consists of several functions of operations performed on the string
 * Operations that can be performed are
 * 		compareTwoString - checks for the equality of string
 * 		removeBlankSpaces - removes blank spaces from starting and ending of the string
 * 		reverse - reverses the string 
 * 		caseReverse - changes capital alphabets to small and vice versa
 * 		largestWord - returns the last largest word of the string 
 */
package StringOperations;
public class StringOperationsModules {
	/*
	 * @param String 1
	 * @param String 2
	 * @return integer 1 if strings are equal otherwise 0 
	 * Assumption String is not null
	 * Assumption String is case Sensitive 
	 */
	public static int compareTwoString(String firstString,String secondString) {
		//remove extra starting blank spaces and ending blank spaces from both strings
		firstString=removeBlankSpaces(firstString);
		secondString=removeBlankSpaces(secondString);
		//if lengths are different then strings are not equal so return 0
		if(firstString.length()!=secondString.length())
		{
			return 0;
		}
		//if lengths are equal then
		else {
			for(int characterIndex=0;characterIndex<firstString.length();characterIndex++)
			{
				//if any of the character is different then return 0 immediately
				if(firstString.charAt(characterIndex)!=secondString.charAt(characterIndex))
					return 0;
			}
		}
		//after completion of the loop if control reaches here this means strings are equal so return 1
		return 1;
	}
	/*
	 * @param String
	 * @return string after removing extra blank spaces from starting and ending of the string
	 * Assumption String is not null
	 * Assumption String is case Sensitive 
	 */
	public static String removeBlankSpaces(String firstString) {
		int characterIndex;
		//if first character of the string is a blank space
		if(firstString.charAt(0)==' '){
			for(characterIndex=0;characterIndex<firstString.length();characterIndex++){
				char character=firstString.charAt(characterIndex);
				//checks continuously until any other character comes and as soon as any other character comes break the loop
				if(character!=' ') {
					break;
				}
			}
			//fetch out the string till last from the index of the first charcter's occurrence i.e. not a blank space
			//and store it back to original string
			firstString=firstString.substring(characterIndex);
		}
		if((firstString.charAt(firstString.length()-1))==' '){
			for(characterIndex=firstString.length()-1;characterIndex>0;characterIndex--){
				char character=firstString.charAt(characterIndex);
				//checks continuously until any other character comes and as soon as any other character comes break the loop
				if(character!=' ') {
					break;
				}
			}
			//fetch out the string from 0 till the index of the first charcter's occurrence i.e. not a blank space
			//and store it back to original string
			firstString=firstString.substring(0,characterIndex+1);
		}
		//return string back
		return firstString;
	}
	/*
	 * @param String
	 * @return string after reversing it
	 * Assumption String is not null
	 * Assumption String is case Sensitive 
	 */
	public static String reverse(String firstString) {
		//remove extra starting blank spaces and ending blank spaces from both strings
		firstString=removeBlankSpaces(firstString);
		String reversedString="";
		//extracting string character by character in reverse order by moving the loop from string.length-1 to 0
		for(int characterIndex=firstString.length()-1;characterIndex>=0;characterIndex--) {
			//adding up the extracted characters to a previously null declared string
			reversedString+=firstString.charAt(characterIndex);
		}
		//return reversed string
		return reversedString;		
	}
	/*
	 * @param String
	 * @return String after reversing the case of the string i.e. changes capital letters to small and vice versa
	 * Assumption String is not null
	 * Assumption String is case Sensitive 
	 */
	public static String caseReverse(String firstString) {
		//remove extra starting blank spaces and ending blank spaces from both strings
		firstString=removeBlankSpaces(firstString);
		String caseReversedString="";
		for(int characterIndex=0;characterIndex<firstString.length();characterIndex++) {
			//check for if the extracted character is a capital letter or not
			if((firstString.charAt(characterIndex)>='A')&&(firstString.charAt(characterIndex)<='Z')){
				//if so then for changing it to small add up the ASCII code of 'a' and subtract the ASCII code of 'A'
				caseReversedString+=((char)(((int)firstString.charAt(characterIndex))+((int)'a'-(int)'A')));
			}
			//check for if the extracted character is a small letter or not
			else if((firstString.charAt(characterIndex)>='a')&&(firstString.charAt(characterIndex)<='z')){
				//if so then for changing it to capital add up the ASCII code of 'A' and subtract the ASCII code of 'a'
				caseReversedString+=((char)(((int)firstString.charAt(characterIndex))+((int)'A'-(int)'a')));
			}
			//if neither capital nor small means it is either a blank space or any special character leave it as it is
			else {
				//add the special character or blank space as it is to the string
				caseReversedString+=firstString.charAt(characterIndex);
			}
		}
		//return finally case reversed string
		return caseReversedString;
	}
	/*
	 * @param String
	 * @return String returns the last largest word of the string
	 * Assumption String is not null
	 * Assumption String is case Sensitive 
	 */
	public static String largestWord(String firstString) {
		//remove extra starting blank spaces and ending blank spaces from both strings
		firstString=removeBlankSpaces(firstString);
		//here blank found variable is used as a flag variable
		int characterIndexFirst,characterIndexSecond,blankFound=0,maxLength;
		String maxLengthWord;
		for(characterIndexFirst=0;characterIndexFirst<firstString.length();characterIndexFirst++){
			//find the first occurrence of blank space in your word
			if(firstString.charAt(characterIndexFirst)==' '){
				 break;
			}
		}
		//do substring of the string from starting till the occurrence of first blank space
		//store the length of this word and suppose it is the longest word and compare its length with all other words length
		maxLength=firstString.substring(0,characterIndexFirst).length();
		maxLengthWord=firstString.substring(0,characterIndexFirst);
		//add single blank spaces in starting and ending of the string
		firstString=" "+firstString+" ";
		for(characterIndexFirst=0;characterIndexFirst<firstString.length()-1;characterIndexFirst++){
			//find for an occurrence of blank space
			if(firstString.charAt(characterIndexFirst)==' '){
				for(characterIndexSecond=characterIndexFirst+1;characterIndexSecond<firstString.length();characterIndexSecond++){
					//find for next occurrence of a blank space
					if(firstString.charAt(characterIndexSecond)==' '){
						//if found then raise the flag that blank space found and break i.e. make it to 1
						blankFound=1;
						break;
					}
				}
				//if flag is raised
				if(blankFound==1){
					//do substring from the first index of blank till next index of blank excluding blanks
					//calculate its length and check for if its length is greater or equal to previous longest word
					if(maxLength<=(firstString.substring(characterIndexFirst+1,characterIndexSecond).length())){
						//if so then change max length word to this word and do same for the length
						maxLength=firstString.substring(characterIndexFirst+1,characterIndexSecond).length();
						maxLengthWord=firstString.substring(characterIndexFirst+1,characterIndexSecond);
					}
					//ultimately drop off the flag back down i.e. change it to 0
					blankFound=0;
				}
			}
		}		
		//return maximum length word
		return maxLengthWord;
	}
}
