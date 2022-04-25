package Arrays;

public class VersionNumber {

    public static void main(String[] args) {
        compareVersion("0.1", "1.1");
    }
    public static int compareVersion(String version1, String version2) {
        int i =0;
        String versionOne[] = version1.split("\\.");
        String versionTwo[] = version2.split("\\.");
        int v1 = versionOne.length;
        int v2 = versionTwo.length;
        while(i<v1 && i<v2){
            int number1 = Integer.parseInt(versionOne[i]);
            int number2 = Integer.parseInt(versionTwo[i]);
            if(number1 > number2)
                return 1;
            else if(number1 < number2)
                return -1;
            i++;
        }

        while(i<v1){
            int number1 = Integer.parseInt(versionOne[i]);
            if(number1 != 0)
                return 1;
            i++;
        }

        while(i<v2){
            int number1 = Integer.parseInt(versionTwo[i]);
            if(number1 != 0)
                return -1;
            i++;
        }
        return 0;
    }
}
