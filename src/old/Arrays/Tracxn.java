package old.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Tracxn {
    static String FAT = "FAT"
            , CARB = "CARB", FIBER = "FIBER";
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int numberOfDays = in.nextInt();
        boolean cookedY = false;
        boolean cookedX = false;
        Map<String, Integer> ingedientCount = new HashMap<>();
        for (int i = 0; i < numberOfDays; i++) {
            String ingredient = in.next();
            if(FAT.equals(ingredient.substring(0,3)))
                incrementTheCount(FAT, ingedientCount);
            else if(CARB.equals(ingredient.substring(0,4)))
                incrementTheCount(CARB, ingedientCount);
            else if(FIBER.equals(ingredient.substring(0,5)))
                incrementTheCount(FIBER, ingedientCount);

            if(isIngredientAvailableForDishX(ingedientCount) && !cookedX) {
                System.out.print("X");
                cookedX = true;
                cookedY = false;
            }
            else if(isIngredientAvailableForDishY(ingedientCount) && !cookedY) {
                System.out.print("Y");
                cookedX = false;
                cookedY = true;
            }
            else
                System.out.print("-");
        }
    }

    private static boolean isIngredientAvailableForDishY(Map<String, Integer> ingedientCount) {
        if(ingedientCount.containsKey(CARB) == false || ingedientCount.get(CARB) == 0)
            return false;
        if(ingedientCount.containsKey(FIBER) == false || ingedientCount.get(FIBER) == 0)
            return false;
        int carbs = ingedientCount.get(CARB);
        int fiber = ingedientCount.get(FIBER);
        if(carbs >= 3){
            if(carbs == 3) {
                ingedientCount.remove(CARB);
                if(fiber == 1)
                    ingedientCount.remove(FIBER);
                else
                    ingedientCount.put(FIBER, ingedientCount.get(FIBER) - 1);
            }
            else
                ingedientCount.put(CARB, ingedientCount.get(CARB) - 3);
            return true;
        }else if(carbs == 2 && fiber >= 2){
            ingedientCount.remove(CARB);
            if(fiber == 2)
                ingedientCount.remove(FIBER);
            else
                ingedientCount.put(FIBER, fiber-2);
            return true;
        }else if(fiber >= 3){
            ingedientCount.remove(CARB);
            if(fiber == 3)
                ingedientCount.remove(FIBER);
            else
                ingedientCount.put(FIBER, ingedientCount.get(FIBER) - 3);
            return true;
        }
        return false;
    }

    private static boolean isIngredientAvailableForDishX(Map<String, Integer> ingedientCount) {

        if(ingedientCount.containsKey(FAT) == false || ingedientCount.get(FAT) <= 1)
            return false;


        int fat = ingedientCount.get(FAT);
//        int numberOfIngredients =  4;
        if(fat >= 4){
            if(fat == 4)
                ingedientCount.remove(FAT);
            else
                ingedientCount.put(FAT, ingedientCount.get(FAT) - 4);
            return true;
        }

        if(ingedientCount.containsKey(FIBER) == false || ingedientCount.get(FIBER) == 0)
            return false;

        int fiber = ingedientCount.get(FIBER);
        if(fat == 3 && fiber >= 1){
            ingedientCount.remove(FAT);
            if(fiber == 1)
                ingedientCount.remove(FIBER);
            else
                ingedientCount.put(FIBER, fiber-1);
            return true;
        }else if(fiber >= 2){
            ingedientCount.remove(FAT);
            if(fiber == 2)
                ingedientCount.remove(FIBER);
            else
                ingedientCount.put(FIBER, fiber-2);
            return true;
        }
        return false;
    }

    private static void incrementTheCount(String ingerdient, Map<String, Integer> ingedientCount) {
        if(ingedientCount.containsKey(ingerdient))
            ingedientCount.put(ingerdient, ingedientCount.get(ingerdient) + 1);
        else
            ingedientCount.put(ingerdient, 1);
    }
}
