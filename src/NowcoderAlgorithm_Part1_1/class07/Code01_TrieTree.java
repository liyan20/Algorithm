package NowcoderAlgorithm_Part1_1.class07;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xianz
 * @Date: 2020/6/17 10:35
 * @Title&Description: 前缀树
 * 是一个字符串数组，里面所有的字符串拿出来，对于每个字符串，从开头把字符一个个的加到结尾，就是前缀树
 * 前缀树的结点TrieNode
 * 属性pass，代表在加这个字符串的时候，经过这个结点几次；
 * 属性end：代表以这个结点结尾的字符串数量
 * @Analysis:
 * 1.一开始什么字符都没加的时候，新建头结点，pass和end都是0
 * 前缀树的字符是放在结点之间的边上的，不是放在结点上。
 * 比如来个字符串"abc"，头结点开始查找有没有通往a的路，没有，建一个路，然后加上下级节点。
 * 这时候，头结点pass++，下级节点因为在路上，所以pass也+1，
 * 接着是b字符，是从a下面那个结点开始走，没有这条路，新建，新建的结点pass++
 * 接着是c字符，还是没有，新建路，结点pass++，发现字符串没了，好了，最后一个结点的end++;
 * end的值代表，从头结点到这个结点的字符串，出现过多少次
 * 2.到了第二个字符串，每到一个新的字符串都从头结点开始走起。有这条路就在结点上pass++，没有就新建，到了停止了就end++
 * 前缀树的方法：
 * 1.插入：就按照上面的方法，建立前缀树就行
 * 2.查找某个字符串出现了几次
 * 3.查找以某个字符串开头的有几个
 *
 * 注意：hashmap我们在删除操作的时候可能会删除整个结点，在hashmap的时候就是变成null，而hashmap里面是可以在value存放null的
 * 所以，delete操作的时候，要使用remove，而不是把value置null。
 * 或者可以置null，那在前面插入时候就不能用containsKey了，而应该用判断get的value是否是null
 * @Summary:
 * @TimeConsuming:
 */
public class Code01_TrieTree {
    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixNumber("zuo"));
    }

    //前缀树的结点类
    public static class TrieNode {
        public int pass;
        public int end;
        HashMap<Character, TrieNode> nexts;

        public TrieNode() {
            pass = 0;
            end = 0;
            nexts = new HashMap<>();
        }
    }

    //前缀树类
    public static class Trie{
        //前缀树类里面的属性就是一个头结点
        private TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }

        //前缀树的插入方法，用于构建前缀树，所以不需要返回值
        public void insert(String word){
            if (word == null){
                return;
            }
            //每次插入都要来到头结点
            TrieNode node = this.root;
            node.pass++;
            for (int i=0; i<word.length(); i++){
                char curChar = word.charAt(i);  //当前字符
                //如果当前结点的next hashmap不包含这个字符，说明这条路还没有创建，就新建这个路，
                //即在node的hashmap中对这个字符创建一个value。这种最好用hashmap因为可以使用key查询value
                if (!node.nexts.containsKey(curChar)){
                    node.nexts.put(curChar, new TrieNode());
                }
                //当前结点跳到下一个结点的位置，即到next的hashmap里面的对应的是当前的字符的那条路，即当前字符的value
                node = node.nexts.get(curChar);
                node.pass++;  //pass++
            }
            //到了最后一个字符结束了，node也跳到了最后的结点，end++
            node.end++;
        }

        //输入一个字符串，返回这个字符串在字符串数组里面出现过几次
        public int search(String word){
            if (word == null){
                return 0;
            }
            TrieNode node = this.root;
            for (int i=0; i<word.length(); i++){
                char curChar = word.charAt(i);
                if (!node.nexts.containsKey(curChar)){
                    return 0;
                }
                node = node.nexts.get(curChar);  //跳到下一个字符的结点处
            }
            return node.end;
            //返回end值，因为是查找这个字符串出现了几次，所以必须是以字符串最后的字符结束的
            //所以是end而不是pass，因为可能这个字符串之后还有其他的字符，比如查找abc，结果如果还有abcde，就不对了
        }

        public int prefixNumber(String pre){
            if (pre == null){
                return 0;
            }
            TrieNode node = this.root;
            for (int i=0; i<pre.length(); i++){
                char curChar = pre.charAt(i);
                if (!node.nexts.containsKey(curChar)){
                    return 0;
                }
                node = node.nexts.get(curChar);
            }
            return node.pass;
            //这里面返回的是pass，因为这个前缀匹配不一定是整个字符串的，所以只需要得到到这个字符串最后的
            //字符所对应的边的结点的pass就行了，说明这条路有多少个字符串经过
        }

        public void delete(String word){
            //先看有没有加过，没加过直接返回
            if (search(word) == 0){
                return;
            }
            TrieNode node = this.root;
            node.pass--;
            for (int i=0; i<word.length(); i++){
                char curChar = word.charAt(i);
                //这边是--在前，先pass--，然后判断这时候的pass是啥情况，如果不是0就ok，如果是0，那说明这条路剩下的就没了
                //结点和路都要清空了，所以我们把nexts里面的这条路直接删掉
                if (--node.nexts.get(curChar).pass == 0){
                    node.nexts.remove(curChar);
                    return;
                }
                node = node.nexts.get(curChar);
            }
            node.end--;
        }
    }
}
