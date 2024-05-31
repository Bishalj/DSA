package prepare.sort;

import prepare.common.DisplayUtils;

import java.util.HashSet;
import java.util.Set;

import static old.utils.CommonUsedUtils.swap;

public class ThreeWayPartitioning {
	public static void main(String[] args) {
		int arr[] = {0,1,2,0,0,2,1,2,0,1};
		DisplayUtils.array(arr);
		partitionInThreeWays(arr);
		DisplayUtils.array(arr);

		int arr1[] = {10,21,12,40,30,32,31,112,20,1};
		DisplayUtils.array(arr1);
		partitionAroundRange(arr1, 20, 35);
		DisplayUtils.array(arr1);
	}

	private static void partitionInThreeWays(int[] arr){
		int zeroIndex = 0, low = 0, high = arr.length-1;
		while (low<high){
			if(arr[low]==0)
				swap(arr, zeroIndex++, low++);
			else if(arr[low]==2)
				swap(arr, high--, low);
			else
				low++;
		}
	}

	private static void partitionAroundRange(int[] arr, int lowRange, int highRange){
		int zeroIndex = 0, low = 0, high = arr.length-1;
		while (low<high){
			if(arr[low]<=lowRange)
				swap(arr, zeroIndex++, low++);
			else if(arr[low]>=highRange)
				swap(arr, high--, low);
			else
				low++;
		}
	}
}

class Solution {
	public int numUniqueEmails(String[] emails) {
		Set<String> uniqueEmails = new HashSet();
		for(String email: emails)
			uniqueEmails.add(getFormattedEmail(email));

		return uniqueEmails.size();
	}

	private String getFormattedEmail(String email){
		int index = email.indexOf('@');
		String domain = email.substring(index);
		StringBuffer sb = new StringBuffer();
		int plusIndex = email.indexOf('+');
		sb.append(email.substring(0,plusIndex).replace(".",""));
		sb.append("@");
		sb.append(domain);
		return sb.toString();
	}
}