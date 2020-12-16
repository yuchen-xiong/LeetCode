package com.leetcode.bear;
import java.util.*;




public class CloneGraph {
	public Node cloneGraph(Node node) {
        if(node == null)
        {
            return null;
        }
        
        Set<Node> nodeSet = getNodes(node);
        Map<Node, Node> nodeMap = new HashMap<>();
        //copy all the vectors
        for(Node cur : nodeSet)
        {
            Node copy = new Node(cur.val);
            nodeMap.put(cur, copy);
        }
        
        //copy all the edges
        for(Node cur : nodeSet)
        {
            List<Node> neighbors = cur.neighbors;
            for(Node nb : neighbors)
            {
                Node copyNb = nodeMap.get(nb);
                nodeMap.get(cur).neighbors.add(copyNb);
            }
        }
        return nodeMap.get(node);
    }
    
    private Set<Node> getNodes(Node node)
    {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(node);
        Set<Node> nodeSet = new HashSet<>();
        while(!nodeQueue.isEmpty())
        {
            Node cur = nodeQueue.poll();
            nodeSet.add(cur);
            
            for(Node nb : cur.neighbors)
            {
                if(!nodeSet.contains(nb))
                {
                    nodeQueue.offer(nb);
                }
            }
        }
        return nodeSet;
    }
}
