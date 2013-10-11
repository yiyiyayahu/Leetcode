public class Solution {
    public String intToRoman(int num) {
        String a[][] = {
    	    { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" }, //1-9
    	    { "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" }, //10-90
    	    { "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" }, //100-900
    	    { "M", "MM", "MMM", "", "", "", "", "", "" }};              //M - 1000
        String result = "";
        int key = 0;
        while(num != 0) {
            int j = num % 10;
            if(j != 0) {
                result = a[key][j - 1] + result;  //remember here is j-1 not j
            }
            num = (num - j) / 10;
            key ++;
        }
        return result;
    }
}
