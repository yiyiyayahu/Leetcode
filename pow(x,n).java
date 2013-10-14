public class Solution {
    public double pow(double x, int n) {
        if(x == 1) return 1;
        if(x == -1) {
            if(Math.abs(n) % 2 == 0) return 1;
            else return -1;
        }
        if(n >= 0) {
            if(n == 1) return x;
            if(n == 0) return 1;
            
            double mid = pow(x,n/2);
            double remainder = pow(x,n%2);
            return mid * mid * remainder;
        } else {
            return 1/pow(x, -n);
        }
    }
}
