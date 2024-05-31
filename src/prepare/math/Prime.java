package prepare.math;

import prepare.common.DisplayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Prime {

	public static void main(String[] args) {
		System.out.println(isPrime(37));
		seiveOfErathosthenesAlgoToFindAllPrimeNumsLessThanN(23);
	}

	private static boolean isPrime(int num){
		if(num==0 || num==1)
			return false;
		if (num==2 || num==3)
			return true;
		if(num%2==0 || num%3==0)
			return false;
		for(int i=5; i*i<=num; i+=6){
			if(num%i==0 || num%(i+2)==0)
				return false;
		}
		return true;
	}

	private static void seiveOfErathosthenesAlgoToFindAllPrimeNumsLessThanN(int n){
		 boolean primes[] = new boolean[n+1];
		Arrays.fill(primes, true);
		 for(int i=2; i<=n; i++){
			 if(primes[i]) {
				 System.out.print(i + ", ");
				 int data = i+i;
				 while(data<=n){
					 primes[data] = false;
					 data += i;
				 }
			 }
		 }
	}
}


class Solution {
	public static int specialArray(int[] nums) {
		Comparator<Integer> comparator = (a,b) -> b-a;
		nums = Arrays.stream(nums)
				.boxed()
				.sorted(Collections.reverseOrder())
				.mapToInt(Integer::intValue)
				.toArray();
		int i;
		for(i=0; i<nums.length && nums[i]>=(i+1); i++);

		if(i==0 || (i!=nums.length&&nums[i]>=i))
			return -1;
		return i;
	}

	public static void main(String[] args) {
		int arr[] = {1,0,0,6,4,9};
		System.out.println(specialArray(arr));
	}
}