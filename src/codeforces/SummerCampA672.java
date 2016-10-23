package codeforces;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// http://codeforces.com/problemset/problem/672/A
public class SummerCampA672 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//while(true)
		//{
		int index =  new Integer(br.readLine());

		//if(index == 0)
		//return;

		Point groupAndPivot = findGroup(index);
		int group = groupAndPivot.x;
		int pivot = groupAndPivot.y + 1;
		int powerOfTen = (int)Math.pow(10, group - 1);
		int x = (index - pivot)/group + powerOfTen;
		int digitOffset = (index - pivot)%group;

		System.out.println((x+"").charAt(digitOffset));
		//		}
	}

	private static Point findGroup(int index)
	{
		// The first group is the group that contains 1-digit numbers
		// The second group is the group that contains 2-digit numbers
		// etc ...
		int groupId = 1;
		int cumulativeGroupMembers = 9;
		int possibleDigits = 10; // 0,1,2,3,4,5,6,7,8,9
		// no number can start with a leading 0
		int possibleLeadingDigits = possibleDigits - 1;
		int cumulativeNonLeadingDigitMultiplier = 1;
		int lastGroupHighestIndex = 0;

		while(true)
		{
			if (index <= cumulativeGroupMembers)
				return new Point(groupId, lastGroupHighestIndex);

			lastGroupHighestIndex = cumulativeGroupMembers;
			groupId++;
			cumulativeNonLeadingDigitMultiplier *= possibleDigits;

			int numbersInCurrentGroup = possibleLeadingDigits * cumulativeNonLeadingDigitMultiplier;
			cumulativeGroupMembers += groupId * numbersInCurrentGroup;
		}
	}
}
