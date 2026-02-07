import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution208 {

    static class Trie {
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

        public Trie() {
            root = new Node();
            root.endOfWord = false;
        }

        public void insert(String word) {
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
            Node ptr = root;
            for (char c : word.toCharArray()) {
                if (!ptr.children.containsKey(c)) {
                    return false;
                }
                ptr = ptr.children.get(c);
            }
            return ptr.endOfWord;
        }

        public boolean startsWith(String prefix) {
            Node ptr = root;
            for (char c : prefix.toCharArray()) {
                if (!ptr.children.containsKey(c)) {
                    return false;
                }
                ptr = ptr.children.get(c);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // false
        System.out.println(trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println(trie.search("app"));     // true
    }
}
