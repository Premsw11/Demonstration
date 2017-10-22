package Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import com.google.common.primitives.Ints;

public class LongestUniqueSubString {
	
	public static void TwoLoop() {
		//StringBuilder sb = new StringBuilder();
		String str = "TESTVAGRANT";
		str = str.toUpperCase();
		int length = str.length();
		int[] lengthOfSubString  = new int[length];
		int maxIndex = 0;
		int count = 0;
		int maxValue = 0;
		int maxValueIndex = 0;
		for(int i = 0; i < length; i++) {
			char ch = str.charAt(i);
			//sb.append(ch);
			int max = str.indexOf(ch, i+1);
			if(max == -1) {
				maxIndex = length;;
				max = length-i;
			}
			else {
				maxIndex = max;
				max = max-i;
			} // max is assigned
			//pick up the next character
			for(int j = i+1; j < maxIndex; j++) {
				char nextChar = str.charAt(j);
				int nextCharNextIndex = str.indexOf(nextChar, j+1);
				if(nextCharNextIndex == -1) {
					//nextCharNextIndex = length-j;
					
				}
				else{
					if(nextCharNextIndex >= maxIndex) {
						//keep previous max
					}
					else {
						maxIndex = nextCharNextIndex;
						max = nextCharNextIndex-i;
					}
				}
			}
			lengthOfSubString[i] = max;
					}
		//To print the array
		for(int i = 0; i < length; i++) {
			//System.out.print(lengthOfSubString[i] + ", ");
			if(maxValue > lengthOfSubString[i]) {
				//skip
			}
			else {
				maxValue = lengthOfSubString[i];
				maxValueIndex = i;
			}
		}
		// Print the substring that is longest without repeating any character
		System.out.println("The String  " +str+ "  has substring that is longest without repeating any character is ==  "+str.substring(maxValueIndex, maxValueIndex+maxValue));
	}
	
	static void longestSubstring(String inputString)
    {
        //Convert inputString to charArray
         
        char[] charArray = inputString.toCharArray();
         
        //Initialization
         
        String longestSubstring = null;
         
        int longestSubstringLength = 0;
         
        //Creating LinkedHashMap with characters as keys and their position as values.
         
        LinkedHashMap<Character, Integer> charPosMap = new LinkedHashMap<Character, Integer>();
         
        //Iterating through charArray
         
        for (int i = 0; i < charArray.length; i++) 
        {
            char ch = charArray[i];
         
            //If ch is not present in charPosMap, adding ch into charPosMap along with its position
             
            if(!charPosMap.containsKey(ch))
            {
                charPosMap.put(ch, i);
            }
             
            //If ch is already present in charPosMap, reposioning the cursor i to the position of ch and clearing the charPosMap
             
            else
            {    
                i = charPosMap.get(ch);
                 
                charPosMap.clear();
            }
             
            //Updating longestSubstring and longestSubstringLength
             
            if(charPosMap.size() > longestSubstringLength)
            {
                longestSubstringLength = charPosMap.size();
                 
                longestSubstring = charPosMap.keySet().toString();
            }
        }
         
        System.out.println("Input String : "+inputString);
         
        System.out.println("  longest substring : "+longestSubstring);
         
        System.out.println("The longest Substring Length : "+longestSubstringLength);
    }
     
    public static void main(String[] args) 
    {    
        longestSubstring("TESTVAGRANT");
         
        System.out.println("==========================");
         
        longestSubstring("thelongestsubstring");
        TwoLoop();
    }    

}