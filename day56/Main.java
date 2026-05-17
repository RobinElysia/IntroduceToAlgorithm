/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Trie {
    // 子节点数组，存储26个小写字母
    private Trie[] children;
    // 标记当前节点是否是某个单词的结尾
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        // 遍历单词的每个字符
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            // 如果子节点不存在，创建新节点
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            // 移动到子节点
            node = node.children[index];
        }
        // 标记单词结尾
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        // 找到了节点且该节点是单词结尾
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        // 只要找到了前缀对应的节点即可
        return searchPrefix(prefix) != null;
    }

    // 辅助方法：搜索前缀，返回最后一个节点
    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            // 如果子节点不存在，返回null
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}