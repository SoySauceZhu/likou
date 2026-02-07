import java.util.HashMap;
import java.util.Map;

public class Solution211 {

    static class WordDictionary {
        private class Node {
            char val;
            HashMap<Character, Node> children;
            boolean endOfWord;

            Node() {
                children = new HashMap<>();
                endOfWord = false;
            }

            Node(char val) {
                this.val = val;
                children = new HashMap<>();
                endOfWord = false;
            }

        }


        final private Node root;

        public WordDictionary() {
            root = new Node();
            root.endOfWord = false;
        }

        public void addWord(String word) {
            Node ptr = root;
            for (char c : word.toCharArray()) {
                if (!ptr.children.containsKey(c)) {
                    ptr.children.put(c, new Node(c));
                }
                ptr = ptr.children.get(c);
            }
            ptr.endOfWord = true;

        }

        public boolean search(String word) {
            return searchHelper(root, word);

        }

        private boolean searchHelper(Node ptr, String s) {
            if (ptr == null) return false;
            if (s.isEmpty()) {
                return ptr.endOfWord;
            }

            char c = s.charAt(0);
            if (ptr.children.containsKey(c)) {
                ptr = ptr.children.get(c);
                return searchHelper(ptr, s.substring(1));
            }

            if (c == '.') {
                boolean flag = false;
                for (Map.Entry<Character, Node> kv : ptr.children.entrySet()) {
                    flag = flag || searchHelper(kv.getValue(), s.substring(1));
                }
                return flag;
            }

            return false;
        }

    }


    public static void main(String[] args) {
        WordDictionary trie = new WordDictionary();
        trie.addWord("apple");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // false
        System.out.println(trie.search("app.."));     // true
        System.out.println(trie.search("app.e"));     // true
        System.out.println(trie.search("...le"));     // true
    }
}
