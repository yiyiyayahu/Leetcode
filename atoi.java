    public int atoi(String str) {
        str = str.trim();
        if(str == null) return 0;
        if(str.length() == 0) return 0;
        if(!isValid(str.charAt(0))) return 0;
        
        long num = 0;
        int sign = str.charAt(0) == '-' ? -1 : 1;
        int i = isNumbers(str.charAt(0)) ? 0 : 1;
        
        while(i < str.length()) {
            
            if(isNumbers(str.charAt(i))) {
                num *= 10;                 //put num * 10 in the front
                num += str.charAt(i) - '0';
                i++;
            } else {
                break;
            }
        }
        num = num * sign;
        
        if(num > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if(num < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)num;
        }
    }
    public boolean isValid(char c) {
        return (c <= '9' && c >= '0') || c == '+' || c == '-';
    }
    public boolean isNumbers(char c) {
        return (c <= '9' && c >= '0');
    }
    }
    public boolean isValid(char c) {
        return (c <= '9' && c >= '0') || c == '+' || c == '-';
    }
    public boolean isNumbers(char c) {
        return (c <= '9' && c >= '0');
    }
