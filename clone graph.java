public class Solution {
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
      if (node == null) return null;
      Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>(); 
      Map<UndirectedGraphNode, UndirectedGraphNode> map 
        = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
      
      q.add(node);
      UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
      map.put(node, newNode);
      
      while (!q.isEmpty()) {
        UndirectedGraphNode parent = q.poll();
        for (UndirectedGraphNode child : parent.neighbors) {
          if (!map.containsKey(child)) {
            q.add(child);
            UndirectedGraphNode newchildNode = new UndirectedGraphNode(child.label);
            map.put(child, newchildNode);
          }
          map.get(parent).neighbors.add(map.get(child)); //important 
        }
      }
      return map.get(node);
    }
}
