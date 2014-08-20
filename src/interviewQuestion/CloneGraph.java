package interviewQuestion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.UndirectedGraphNode;


//http://blog.csdn.net/fightforyourdream/article/details/17497883
public class CloneGraph
{
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
    {
        if (node == null)
        {
            return null;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        queue.add(node);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);

        while (!queue.isEmpty())
        {
            UndirectedGraphNode cur = queue.poll();
            List<UndirectedGraphNode> array = cur.neighbors;
            for (UndirectedGraphNode n : array)
            {
                if (!map.containsKey(n))
                {
                    UndirectedGraphNode copy = new UndirectedGraphNode(n.label);
                    queue.add(n);
                    map.put(n, copy);
                    map.get(cur).neighbors.add(copy);
                }
                else
                {
                    map.get(cur).neighbors.add(map.get(n));
                }
            }
        }

        return newNode;
    }
}
