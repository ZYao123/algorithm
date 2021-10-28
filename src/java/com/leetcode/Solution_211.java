package com.leetcode;

public class Solution_211 {
    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        System.out.println(dictionary.search("pad"));
        System.out.println(dictionary.search("bad"));
        System.out.println(dictionary.search(".ad"));
        System.out.println(dictionary.search("b.."));
    }

    static class WordDictionary {
        wordDict[] root;

        public WordDictionary() {
            root = new wordDict[27];
        }

        public void addWord(String word) {
            wordDict[] cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int idx = c == '.' ? 26 : c - 'a';
                if (cur[idx] == null)
                    cur[idx] = new wordDict();
                if (i == word.length() - 1)
                    cur[idx].end++;
                else
                    cur[idx].pass++;
                cur = cur[idx].nextWord;
            }
        }

        public boolean search(String word) {
            char[] arr = word.toCharArray();
            return search(arr, 0, root);
        }

        public boolean search(char[] word, int idx, wordDict[] cur) {
            if (cur == null)
                return false;
            if (word[idx] == '.') {
                if (idx == word.length - 1) {
                    for (wordDict c : cur) {
                        if (c != null && c.end > 0)
                            return true;
                    }
                } else {
                    for (wordDict c : cur) {
                        if (c != null && search(word, idx + 1, c.nextWord))
                            return true;
                    }
                }
                return false;
            } else {
                wordDict d = cur[word[idx] - 'a'];
                if (d == null)
                    return false;
                if (idx == word.length - 1) {
                    if (d.end > 0)
                        return true;
                } else {
                    return search(word, idx + 1, d.nextWord);
                }
            }
            return false;
        }

        class wordDict {
            wordDict[] nextWord;
            int pass;
            int end;

            public wordDict() {
                nextWord = new wordDict[27];
                pass = 0;
                end = 0;
            }
        }
    }
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
