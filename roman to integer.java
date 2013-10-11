public class Solution {
    public int romanToInt(String s) {
        if(s == null) return 0;

        int result = 0;
        int n = s.length() - 1;
        int prev = getDigit(s.charAt(n)); 
        result += prev;
        for(int i = n-1; i >=0; i--) {
            //IV-4, VI-6, XL-40, LX-60
            int d = getDigit(s.charAt(i));  //assign i and i+1 to a integer will reduce the time
            if(d < prev) { 
                result -= d;
            } else {
                result += d;
            }
            prev = d;
        }
        return result;
    }
    public int getDigit(char c) {
    	switch(c) {
    	    case 'I': return 1;
    	    case 'V': return 5;
    	    case 'X': return 10;
    	    case 'L': return 50;
    	    case 'C': return 100;
    	    case 'D': return 500;
    	    case 'M': return 1000;
    	    default: return 0;
    	}
    }
}
