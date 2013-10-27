public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if(intervals == null || intervals.size() <= 1) return intervals;
        Interval temp = null;
        result.add(intervals.get(0));
        for(int i = 0; i < intervals.size(); i ++) {
            result = merge(result, intervals.get(i));
        }
        return result;
        
    }
    
    public ArrayList<Interval> merge(ArrayList<Interval> intervals, Interval newInterval) {
        
        Interval temp = newInterval;
        ArrayList<Interval> result = new ArrayList<Interval>();
        for(Interval in : intervals) {
            if(in.end < temp.start) {
                result.add(in);
            } else if(in.start > temp.end) {
                result.add(temp);
                temp = in;
            } else {
                int start = Math.min(in.start, temp.start);
                int end = Math.max(in.end, temp.end);
                temp = new Interval(start, end);
            }
        }
        result.add(temp);
        return result;
    }
}
