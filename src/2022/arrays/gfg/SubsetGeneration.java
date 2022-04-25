package access_specifiers.com;

class SubsetGeneration{

    public static void main(String[] args) {
        String word = "abc";
        StringBuilder sb = new StringBuilder();
        printSubset(word, sb, 0);
    }

    private static void printSubset(String word, StringBuilder sb, int pos) {
        if(word.length() == pos){
            System.out.println(sb.toString());
            return;
        }

        printSubset(word, sb.append(word.charAt(pos)), pos+1);
        sb.deleteCharAt(sb.length()-1);
        printSubset(word, sb, pos+1);
    }
}
