package com.leetcode;

import com.util.graph.Edge;
import com.util.graph.Node;
import com.util.graph.NodeHeap;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution_743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Node, ArrayList<Edge>> edgeMap = new HashMap<>();
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int[] time : times) {
            if (!nodeMap.containsKey(time[0]))
                nodeMap.put(time[0], new Node(Integer.MAX_VALUE));
            if (!nodeMap.containsKey(time[1]))
                nodeMap.put(time[1], new Node(Integer.MAX_VALUE));
            Node from = nodeMap.get(time[0]);
            Node to = nodeMap.get(time[1]);

            if (!edgeMap.containsKey(from))
                edgeMap.put(from, new ArrayList<>());
            ArrayList<Edge> list = edgeMap.get(from);
            list.add(new Edge(time[2], from, to));
        }

        PriorityQueue<Integer> delay = new PriorityQueue<>((a, b) -> b - a);
        Set<Node> set = new HashSet<>();
        NodeHeap heap = new NodeHeap();
        Node node = nodeMap.get(k);
        node.value = 0;
        heap.offer(node);
        while (heap.size() > 0) {
            Node poll = heap.poll();
            set.add(poll);
            delay.add(poll.value);
            ArrayList<Edge> edges = edgeMap.get(poll);
            if (edges == null)
                continue;
            for (Edge e : edges) {
                Node to = e.to;
                if (!set.contains(to)) {
                    heap.setValueOrAdd(to, Math.min(to.value, poll.value + e.weight));
                }
            }
        }
        if (set.size() < n)
            return -1;
        return delay.isEmpty() ? -1 : delay.poll();
    }


    public int networkDelayTime2(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], INF);
        }
        for (int[] t : times) {
            int x = t[0] - 1, y = t[1] - 1;
            g[x][y] = t[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int x = -1;
            for (int y = 0; y < n; ++y) {
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }
            used[x] = true;
            for (int y = 0; y < n; ++y) {
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
            }
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }

    public int networkDelayTime3(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<>();
        }
        for (int[] t : times) {
            int x = t[0] - 1, y = t[1] - 1;
            g[x].add(new int[]{y, t[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        pq.offer(new int[]{0, k - 1});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int time = p[0], x = p[1];
            if (dist[x] < time) {
                continue;
            }
            for (int[] e : g[x]) {
                int y = e[0], d = dist[x] + e[1];
                if (d < dist[y]) {
                    dist[y] = d;
                    pq.offer(new int[]{d, y});
                }
            }
            System.out.println(Arrays.toString(dist));
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }


    public int networkDelayTime4(int[][] times, int n, int k) {
        List<Map<Integer, Integer>> cache = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            cache.add(new HashMap<>());
        }
        for (int[] time : times) {
            Map<Integer, Integer> map = cache.get(time[0] - 1);
            map.put(time[1], time[2]);
        }
        boolean[] used = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[k - 1] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{k, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (used[poll[0] - 1])
                continue;
            used[poll[0] - 1] = true;
            Map<Integer, Integer> map = cache.get(poll[0] - 1);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int dis = entry.getValue() + poll[1];
                int key = entry.getKey();
                if (dist[key - 1] == -1 || dis < dist[key - 1]) {
                    dist[key - 1] = dis;
                    queue.add(new int[]{key, dis});
                }
            }
        }
        return Arrays.stream(dist).max().getAsInt();
    }

    @Test
    public void test() {
        int i = 0;
//        i = networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2);
//        Assert.assertEquals(i, 2);

//        i = networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 7}, {1, 3, 4}, {2, 1, 2}}, 4, 1);
//        Assert.assertEquals(i, -1);

        int[][] arr = {{4, 2, 76}, {1, 3, 79}, {3, 1, 81}, {4, 3, 30}, {2, 1, 47}, {1, 5, 61}, {1, 4, 99},
                {3, 4, 68}, {3, 5, 46}, {4, 1, 6}, {5, 4, 7}, {5, 3, 44}, {4, 5, 19}, {2, 3, 13}, {3, 2, 18},
                {1, 2, 0}, {5, 1, 25}, {2, 5, 58}, {2, 4, 77}, {5, 2, 74}};
        i = networkDelayTime4(arr, 5, 3);
        Assert.assertEquals(i, 59);
    }
}
