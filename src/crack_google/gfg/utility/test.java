package crack_google.gfg.utility;

import java.util.*;

class Solution {

	public static void main(String[] args) {
		System.out.println(romanToInt("III"));
	}
	public static int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int result = 0;
		for(int i= 1; i>s.length(); i++){
			char ch = (char)s.charAt(i);
			char prev = (char)s.charAt(i-1);
			if(map.get(ch) > map.get(prev)){
				result += (map.get(prev)*-1);
				System.out.println(map.get(prev)*-1);
			}
			else{
				System.out.println(map.get(prev));
				result += map.get(prev);
			}
		}
		result += map.get(s.charAt(s.length()-1));
		return result;
	}
}

class Solutions {
	public static String nearestPalindromic(String n) {
		String arr[] = new String[7];
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		int length = n.length()/2;
		String num = n.substring(0,length);
		sb1.append(num);
		sb2.append(num);
		sb1.append(n.substring(length, n.length()-length));
		sb1.append(sb2.reverse());
		String result = sb1.toString();
		arr[0] = result;
		String secondString = "9".repeat(n.length()-1);
		arr[1] = secondString;
		String thirdString = "1" + "0".repeat(n.length()-1) + "1";
		arr[2] = thirdString;
		if(secondString.equals("")) {
			secondString = "0";
			arr[1] = secondString;
		}

		StringBuffer sb3 = new StringBuffer(sb1.toString());
		StringBuffer sb4 = new StringBuffer(sb1.toString());
		StringBuffer sb5 = new StringBuffer(sb1.toString());
		StringBuffer sb6 = new StringBuffer(sb1.toString());
		int value = sb1.toString().charAt(length)-48;
		if(n.length()%2 != 0){
			if(value != 0){
				sb3.setCharAt(length, (char)(value+47));
				if(value != 9)
					sb6.setCharAt(length, (char) (value + 49));
			}
			else {
				sb3.setCharAt(length, '1');
			}
		}else{
			if(value != 0) {
				value = Math.min(value, sb1.toString().charAt(length-1)-48);
				sb4.setCharAt(length, (char) (value + 47));
				sb4.setCharAt(length-1, (char) (value + 47));
				if(value != 9) {
					sb5.setCharAt(length, (char) (value + 49));
					sb5.setCharAt(length - 1, (char) (value + 49));
				}
			}
			else {
				sb4.setCharAt(length, '1');
				sb4.setCharAt(length-1, '1');
			}
		}
		arr[3] = sb3.toString();
		arr[4] = sb4.toString();
		arr[5] = sb5.toString();
		arr[6] = sb6.toString();
		long res = Long.MAX_VALUE;
		int pos = 1;
		long intialValue = Long.parseLong(n);
		for(int i =1; i<arr.length; i++){
			long data = Long.parseLong(arr[i]);
			if(data != intialValue && Math.abs(intialValue-data) <= res) {
				if(Math.abs(intialValue-data) == res){
					if(Long.parseLong(arr[i]) < Long.parseLong(arr[pos]))
						pos = i;
				}else {
					pos = i;
				}
				res = Math.abs(intialValue-data);
			}
		}
		return arr[pos];
	}

	public static void main(String[] args) {
		System.out.println(nearestPalindromic("1837722381"));
	}
}

//2589246
//2589852


class Solutionss {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap();
		int pos=0;
		int[] arr = new int[k];
		for(int value: nums)
			map.put(value, (map.getOrDefault(value, 0)+1));

		while(k>0){
			int max = -1;
			for(Map.Entry<Integer,Integer> data: map.entrySet()){
				max = Math.max(data.getValue(), max);
			}

			arr[pos++] = max;
			map.remove(max);
		}
		return arr;
	}
}