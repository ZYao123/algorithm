package com.learn.graph;

import java.util.*;

public class TopologySort {

    // directed graph and no loop
    public static List<Node> sortedTopology(Graph graph) {
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQue = new LinkedList<>();
        for (Node node : graph.nodes.values()) { //遍历所有的点
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQue.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQue.isEmpty()) {
            Node cur = zeroInQue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQue.add(next);
                }
            }
        }
        return result;
    }
}