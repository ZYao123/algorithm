package com.learn.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author quanquan
 * @create 2020-05-03-20:40
 */
public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}