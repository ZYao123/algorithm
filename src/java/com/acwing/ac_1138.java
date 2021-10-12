package com.acwing;

import java.util.*;

public class ac_1138 {
//    k
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        var cityCount = cin.nextInt();
        var edgeCount = cin.nextInt();
        HashMap<Integer, List<edge>> nodeMap = new HashMap<>();
        for (int i = 0; i < edgeCount; i++) {
            var from = cin.nextInt();
            var to = cin.nextInt();
            var price = cin.nextInt();
            if (nodeMap.containsKey(from)) {
                List<edge> edges = nodeMap.get(from);
                edges.add(new edge(from, to, price));
            } else {
                ArrayList<edge> edges = new ArrayList<>();
                edges.add(new edge(from, to, price));
                nodeMap.put(from, edges);
            }
            if (nodeMap.containsKey(to)) {
                List<edge> edges = nodeMap.get(to);
                edges.add(new edge(to, from, price));
            } else {
                ArrayList<edge> edges = new ArrayList<>();
                edges.add(new edge(to, from, price));
                nodeMap.put(to, edges);
            }
        }
        List<edge> res = new ArrayList<>();
        HashMap<Integer, List<edge>> setMap = new HashMap<>();
        List<edge> list = nodeMap.get(1);
        setMap.put(1, list);
        while (setMap.size() != nodeMap.size()) {
            int min = Integer.MAX_VALUE;
            edge cur = null;
            for (edge e : list) {
                List<edge> to = nodeMap.get(e.to);
                if (to == list)
                    continue;
                if (e.price < min) {
                    min = e.price;
                    cur = e;
                }
            }
            res.add(cur);
            for (edge e : nodeMap.get(cur.to)) {
                list.add(e);
            }
            nodeMap.put(cur.to, list);
            setMap.put(cur.to, list);
        }
        for (edge e : res) {
            System.out.println(e.from + " " + e.to);
        }
    }

    static class edge {
        int from;
        int to;
        int price;

        public edge(int f, int to, int price) {
            this.from = f;
            this.to = to;
            this.price = price;
        }
    }

    //  p
//    public static void main(String args[]) throws Exception {
//        Scanner cin = new Scanner(System.in);
//        var cityCount = cin.nextInt();
//        var edgeCount = cin.nextInt();
//        HashMap<Integer, List<Integer>> nodeMap = new HashMap<>();
//        for (int i = 0; i < edgeCount; i++) {
//            var from = cin.nextInt();
//            var to = cin.nextInt();
//            var price = cin.nextInt();
//            if (nodeMap.containsKey(from)) {
//                List<Integer> prices = nodeMap.get(from);
//                prices.add(price);
//            } else {
//                ArrayList<Integer> prices = new ArrayList<>();
//                prices.add(price);
//                nodeMap.put(from, prices);
//            }
//            if (nodeMap.containsKey(to)) {
//                List<Integer> prices = nodeMap.get(to);
//                prices.add(price);
//            } else {
//                ArrayList<Integer> prices = new ArrayList<>();
//                prices.add(price);
//                nodeMap.put(to, prices);
//            }
//        }
//        List<edge> res = new ArrayList<>();
//
//        for (edge e : res) {
//            System.out.println(e.from + " " + e.to);
//        }
//    }
}

