package greedy;

import java.util.Arrays;

public class FractionalKnapsac {

    public static void main(String[] args) {
        Item items[] = {
                new Item(50, 600),
                new Item(20, 500),
                new Item(30, 400)
        };

        Item items2[] = {
                new Item(10, 200),
                new Item(5, 50),
                new Item(20, 100)
        };
        int maxCapacity = 70;
        int maxCapacity2 = 15;
        System.out.println(getTheMaximumKnapsackValue(items2, maxCapacity2));
    }

    private static double getTheMaximumKnapsackValue(Item[] items, int maxCapacity) {
        double maxKnapsackValue = 0.0;
        Arrays.sort(items, (i1,i2) -> (i2.getValue()/i2.getWeight()) > (i1.getValue()/i1.getWeight()) ? 1:-1);
        for(Item item: items){
            System.out.println("(" +item.getWeight() + " ->" + item.getValue() + ") ");
        }
        for (Item item: items){
            if(item.getWeight() <= maxCapacity) {
                maxKnapsackValue += item.getValue();
                maxCapacity -= item.getWeight();
            }
            else{
                maxKnapsackValue += maxCapacity * item.getValue() / item.getWeight();
                maxCapacity = 0;
            }

            if(maxCapacity == 0)
                return maxKnapsackValue;
        }

        return maxKnapsackValue;
    }

}

class Item{
    private int weight;
    private int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
