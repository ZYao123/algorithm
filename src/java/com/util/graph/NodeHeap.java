package com.util.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class NodeHeap {
    Comparator<Node> comparator;
    int size;
    Node[] heap;
    Map<Node, Integer> map = new HashMap<>();

    public NodeHeap() {
        heap = new Node[8];
        comparator = new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.value - n2.value;
            }
        };
    }

    public int size() {
        return this.size;
    }

    public boolean offer(Node t) {
        if (size == heap.length) {
            Node[] newHeap = new Node[heap.length * 2];
            System.arraycopy(heap, 0, newHeap, 0, heap.length);
            heap = newHeap;
        }
        heap[size] = t;
        map.put(t, size);
        upAdapt(heap, size++);
        return true;
    }

    public Node poll() {
        Node t = heap[0];
        map.remove(t);
        swap(heap, 0, size - 1);
        size--;
        downAdapt(heap, 0);
        return t;
    }

    public Node peek() {
        return heap[0];
    }

    public boolean setValueOrAdd(Node t, int value) {
        if (map.containsKey(t)) {
            int idx = map.get(t);
            int oldValue = t.value;
            t.value = value;
            if (oldValue < value) {
                downAdapt(heap, idx);
            } else if (oldValue > value) {
                upAdapt(heap, idx);
            }
        } else {
            t.value = value;
            offer(t);
        }
        return false;
    }

    private void upAdapt(Node[] heap, int idx) {
        if (idx == 0)
            return;
        int father = (idx - 1) >>> 1;
        if (heap[father].value > heap[idx].value) {
            swap(heap, father, idx);
            upAdapt(heap, father);
        }
    }

    private void downAdapt(Node[] heap, int idx) {
        if (size == 0)
            return;
        int left = (idx << 1) + 1;
        int right = (idx << 1) + 2;
        int midx = idx;
        if (left < size && heap[left].value < heap[midx].value) {
            midx = left;
        }
        if (right < size && heap[right].value < heap[midx].value) {
            midx = right;
        }
        if (midx != idx) {
            swap(heap, idx, midx);
            downAdapt(heap, midx);
        }
    }

    private void swap(Node[] heap, int a, int b) {
        Node t = heap[a];
        heap[a] = heap[b];
        heap[b] = t;
        map.remove(heap[a]);
        map.remove(heap[b]);
        map.put(heap[a], a);
        map.put(heap[b], b);
    }

    @Test
    public void heapTest() {
        int size = 1000;
        for (int testCount = 0; testCount < 1000; testCount++) {
            NodeHeap heap = new NodeHeap();
            Node[] arr = new Node[size];
            for (int i = 0; i < size; i++) {
                arr[i] = new Node((int) (Math.random() * size * size));
                heap.offer(arr[i]);
            }
            for (int i = 0; i < size; i++) {
                if (Math.random() < 0.5) {
                    int value = (int) (Math.random() * size * size);
                    heap.setValueOrAdd(arr[i], value);
                }
            }
            Arrays.sort(arr, Comparator.comparingInt(a -> a.value));
            for (Node node : arr) {
                Node poll = heap.poll();
                Assert.assertEquals(node.value, poll.value);
            }
        }
    }
}
