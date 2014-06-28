package Util;

import java.util.ArrayList;

public class UndirectedGraphNode
{
    public int label;
    public ArrayList<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x)
    {
        this.label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
