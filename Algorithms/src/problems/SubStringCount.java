package problems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/* ############Problem Description############
 * You are given a string of 0’s and 1’s 
 * you have to find the number of substrings 
 * in the string which starts and end with a 1.
 * */
public class SubStringCount {
	private int result;
	private Set<String> allSubStrings = new HashSet<String>();
	
	
	
	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public void countSubstrings(String input) {
		int count = 0;
		int index = 0;
		
		try {
			for (char current : input.toCharArray()) {
				if (current != '0' && current != '1') {
					System.out.println("Accepted input only 1s and 0s, Not even spaces");
					return;
				}
				if (current != '0') {
					findSubstrings(input.substring(count));
				}
				count++;
			}
			result = allSubStrings.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int findSubstrings(String section){
		
		int result = 0;
		int index = 0;
		try {
			for(char cur : section.toCharArray()){
				if (index != 0 && cur == '1'){
					result++;
					allSubStrings.add(section.substring(0, index));
				}
				index++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args)
    {
		Scanner scan = new Scanner(System.in);
        System.out.println("Please input a string on 1's and 0's \n");
        String input = scan.nextLine();
        
        System.out.println("You've enetered: " + input);
        SubStringCount count = new SubStringCount();
        count.countSubstrings(input);
        System.out.println("Number of strings : " + count.getResult());
    }
}
