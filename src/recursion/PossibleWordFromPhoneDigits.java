package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PossibleWordFromPhoneDigits {

    static  HashMap<String, List<String>> map = new HashMap<>();
    public static void main(String[] args) {
        List<String> one = new ArrayList<String>();
        List<String> two = new ArrayList<String>(Arrays.asList("a","b","c"));
        List<String> three = new ArrayList<String>(Arrays.asList("d","e","f"));
        List<String> five = new ArrayList<String>(Arrays.asList("j","k","l"));
        List<String> four = new ArrayList<String>(Arrays.asList("g","h","i"));
        List<String> six = new ArrayList<String>(Arrays.asList("m","n","o"));
        List<String> seven = new ArrayList<String>(Arrays.asList("p","q","r","s"));
        List<String> eight = new ArrayList<String>(Arrays.asList("t","u","v"));
        List<String> nine = new ArrayList<String>(Arrays.asList("w","x","y","z"));
        List<String> zero = new ArrayList<String>(Arrays.asList());
        List<String> star = new ArrayList<String>(Arrays.asList("*"));
        List<String> hash = new ArrayList<String>(Arrays.asList("#"));

        map.put("1",one);
        map.put("2",two);
        map.put("3",three);
        map.put("4",four);
        map.put("5",five);
        map.put("6",six);
        map.put("7",seven);
        map.put("8",eight);
        map.put("9",nine);
        map.put("0",zero);
        map.put("*",star);
        map.put("#",hash);


        String ss[] = "234".split("");

            generatePossibleWords(ss, "", 0);

    }


    private static void generatePossibleWords(String[] ss, String currentWord, int position) {
        if(position == ss.length) {
            System.out.println(currentWord);
            return;
        }

        for (String character : map.get(ss[position])){
            generatePossibleWords(ss, currentWord + character, position+1);
        }


    }
}
