       public int atoi(String str) {
        
        str = str.trim();
        if(str == null) return 0;
        if(str.length() == 0) return 0;
        if(!isValid(str.charAt(0))) return 0;
        
        long num = 0;
        int sign = 1;
        int i = 0;
        if(str.charAt(0) == '-') {
            sign = -1;
            i = 1;
        }
        if(str.charAt(0) == '+') {
            i = 1;
        }
        for(; i < str.length(); i++) {
            
            if(isNumbers(str.charAt(i))) {
                num *= 10;                 //put num * 10 in the front
                num += str.charAt(i) - '0';
                
            } else {
                break;
            }
        }
        num = num * sign;
        /*
        if(sign == 1 && num < 0) {
            return Integer.MAX_VALUE;
        } else if(sign == -1 && num > 0) {
            return Integer.MIN_VALUE;
        }
        return num;
        */
        if(num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else return (int)num;
    }
    public boolean isValid(char c) {
        return (c <= '9' && c >= '0') || c == '+' || c == '-';
    }
    public boolean isNumbers(char c) {
        return (c <= '9' && c >= '0');
    }
