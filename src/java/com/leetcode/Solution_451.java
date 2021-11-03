package com.leetcode;

public class Solution_451 {
//    public String frequencySort(String s) {
//        Map<Character, Node> map = new HashMap<>();
//        for (char c : s.toCharArray()) {
//            map.compute(c, (k, v) -> v == null ? new Node(k) : v.count+1);
//        }
//        List<>
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            tmap.put(entry.getValue(), entry.getKey());
//        }
//
//        StringBuilder str = new StringBuilder();
//        for (Map.Entry<Integer, Character> entry : tmap.entrySet()) {
//            for (int i = 0; i < entry.getKey(); i++) {
//                str.insert(0, entry.getValue());
//            }
//        }
//        return str.toString();
//    }
//
//    private void upAdjust(Node[] heap, int idx, int len) {
//        if (idx == 0) return;
//        int f = (idx - 1) >> 1;
//        if (heap[f].count < heap[idx].count) {
//            swap(heap, f, idx);
//            upAdjust(heap, f, len);
//        }
//    }
//
//
//    private void downAdjust(Node[] heap, int idx, int len) {
//        int left = idx << 1 + 1;
//        int right = idx << 1 + 2;
//        int max = idx;
//        if (heap[left].count > heap[max].count) max = left;
//        if (heap[right].count > heap[max].count) max = right;
//        if (max != idx) {
//            swap(heap, idx, max);
//            downAdjust(heap, max, len);
//        }
//    }
//
//    private void swap(Node[] arr, int a, int b) {
//        Node t = arr[a];
//        arr[a] = arr[b];
//        arr[b] = t;
//    }
//
//    class Node {
//        public char c;
//        public int count;
//        public Node(char ch){
//            c = ch;
//            count = 1;
//        }
//    }
}
