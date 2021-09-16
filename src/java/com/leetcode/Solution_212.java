package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_212 {
    List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        WordTree root = new WordTree();
        for (String word : words) {
            root.insert(word);
        }
        boolean[][] cache = new boolean[board.length][board[0].length];
        for (int j = 0; j < board.length; j++) {
            for (int k = 0; k < board[j].length; k++) {
                check(board, root, j, k, cache);
            }
        }
        return res;
    }

    private void check(char[][] board, WordTree tree, int x, int y, boolean[][] cache) {
        if (tree.over && !tree.add) {
            tree.add = true;
            res.add(tree.word);
        }
        if (x < 0 || x == board.length || y < 0 || y == board[0].length)
            return;
        char c = board[x][y];
        int idx = c - 'a';
        if (cache[x][y] || tree.nodes[idx] == null)
            return;

        cache[x][y] = true;
        check(board, tree.nodes[idx], x - 1, y, cache);
        check(board, tree.nodes[idx], x + 1, y, cache);
        check(board, tree.nodes[idx], x, y - 1, cache);
        check(board, tree.nodes[idx], x, y + 1, cache);
        cache[x][y] = false;
    }

    static class WordTree {
        WordTree[] nodes = new WordTree[26];
        String word;
        boolean over;
        boolean add;

        public void insert(String word) {
            WordTree t = this;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (t.nodes[idx] == null) {
                    t.nodes[idx] = new WordTree();
                }
                t = t.nodes[idx];
            }
            t.over = true;
            t.word = word;
        }
    }

    private boolean checkChar(char[][] board, String word) {
        char c = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean[][] cache = new boolean[board.length][board[0].length];
                if (search(board, word, 0, i, j, cache))
                    return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int idx, int x, int y, boolean[][] cache) {
        if (idx == word.length())
            return true;
        if (x < 0 || x == board.length || y < 0 || y == board[0].length)
            return false;
        char c = word.charAt(idx);
        if (c != board[x][y] || cache[x][y])
            return false;
        cache[x][y] = true;
        boolean res = search(board, word, idx + 1, x - 1, y, cache) ||
                search(board, word, idx + 1, x + 1, y, cache) ||
                search(board, word, idx + 1, x, y - 1, cache) ||
                search(board, word, idx + 1, x, y + 1, cache);
        cache[x][y] = false;
        return res;
    }
}
