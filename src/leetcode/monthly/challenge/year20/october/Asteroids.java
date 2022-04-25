package leetcode.monthly.challenge.year20.october;

import java.util.Arrays;
import java.util.Stack;

public class Asteroids {

    public static void main(String[] args) {
        int d[] = {-2,-1,1,2};
        System.out.println(Arrays.toString(asteroidCollision(d)));

    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<asteroids.length; i++){
            if(asteroids[i] < 0 && !stack.empty()){
                while(!stack.isEmpty()){
                    if(stack.peek() < 0){
                        stack.add(asteroids[i]);
                        break;
                    }
                    else if(stack.peek() == asteroids[i]*-1){
                        stack.pop();
                        break;
                    }else if(stack.peek() > asteroids[i]*-1){
                        break;
                    }
                    stack.pop();
                }
            }else{
                stack.add(asteroids[i]);
            }
        }

        int arr[] = new int[stack.size()];
        for(int i=arr.length-1; i>=0; i--){
            arr[i] = stack.pop();
        }
        return arr;
    }
}
