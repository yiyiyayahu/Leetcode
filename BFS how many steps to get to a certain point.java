public class Solution {
    class Node {
        public int x;
        public int y;
        public int uniquepath;
        public ArrayList<Node> adjacent;
        Node(int m, int n) {
            x = m;
            y = n;
            uniquepath = 0;
            adjacent = new ArrayList<Node>();
        }
        public ArrayList<Node> getAdjacent() {
            if(this.x-1 > 0) {
                adjacent.add(new Node(this.x-1, this.y));
            }
            if(this.y-1 > 0) {
                adjacent.add(new Node(this.x, this.y-1));
            }
            return adjacent;
        }
    }
    public int uniquePaths(int m, int n) {
        Stack<Node> s = new Stack<Node>();
        Node dest = new Node(m, n);
        s.push(dest);
        while(!s.isEmpty()) {
            Node top = s.pop();
            if(top.x == 1 && top.y == 1) return top.uniquepath;
            for(Node node : top.getAdjacent()) {
                node.uniquepath = top.uniquepath + 1;
                s.push(node);
            }
        }
        return -1;
    }
}
