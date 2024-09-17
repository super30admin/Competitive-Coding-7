package s30.Competitive-Coding-7;

public class problem1 {
    class MagicDictionary {
        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isEnd;
            public TrieNode() {}
        }
        TrieNode root;
        public MagicDictionary() {
            root = new TrieNode();
        }
        public void buildDict(String[] dict) {
            for (String s : dict) {
                TrieNode curr = root;
                for (char c : s.toCharArray()) {
                    if (curr.children[c - 'a'] == null) {
                        curr.children[c - 'a'] = new TrieNode();
                    }
                    curr = curr.children[c - 'a'];
                }
                curr.isEnd = true;
            }
        }
        public boolean search(String word) {
            char[] arr = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (arr[i] == c) {
                        continue;
                    }
                    char org = arr[i];
                    arr[i] = c;
                    if (helper(new String(arr), root)) {
                        return true;
                    }
                    arr[i] = org;
                }
            }
            return false;
        }
        public boolean helper(String s, TrieNode root) {
            TrieNode curr = root;
            for (char c : s.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    return false;
                }
                curr = curr.children[c - 'a'];
            }
            return curr.isEnd;
        }
    }
}
