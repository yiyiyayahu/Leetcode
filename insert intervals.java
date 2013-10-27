 //遍历input list。如果当前interval < newInterval, add当前；如果当前interval > newInterval, add new Interval; 若重叠，则合并成新的new interval.
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        
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
