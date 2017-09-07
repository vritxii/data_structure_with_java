package tree;

import queue.Queue;
import java.util.ArrayList;
/**
 *                             _ooOoo_
 *                            o8888888o
 *                            88" . "88
 *                            (| -_- |)
 *                            O\  =  /O
 *                         ____/`---'\____
 *                       .'  \\|     |//  `.
 *                      /  \\|||  :  |||//  \
 *                     /  _||||| -:- |||||-  \
 *                     |   | \\\  -  /// |   |
 *                     | \_|  ''\---/''  |   |
 *                     \  .-\__  `-`  ___/-. /
 *                   ___`. .'  /--.--\  `. . __
 *                ."" '<  `.___\_<|>_/___.'  >'"".
 *               | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *               \  \ `-.   \_ __\ /__ _/   .-` /  /
 *          ======`-.____`-.___\_____/___.-`____.-'======
 *                             `=---='
 *          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *                     佛祖保佑        永无BUG
 *            佛曰:
 *                   写字楼里写字间，写字间里程序员；
 *                   程序人员写程序，又拿程序换酒钱。
 *                   酒醒只在网上坐，酒醉还来网下眠；
 *                   酒醉酒醒日复日，网上网下年复年。
 *                   但愿老死电脑间，不愿鞠躬老板前；
 *                   奔驰宝马贵者趣，公交自行程序员。
 *                   别人笑我忒疯癫，我笑自己命太贱；
 *                   不见满街漂亮妹，哪个归得程序员？
*/
/**
 *                      江城子 . 程序员之歌
 *
 *                  十年生死两茫茫，写程序，到天亮。
 *                      千行代码，Bug何处藏。
 *                  纵使上线又怎样，朝令改，夕断肠。
 *
 *                  领导每天新想法，天天改，日日忙。
 *                      相顾无言，惟有泪千行。
 *                  每晚灯火阑珊处，夜难寐，加班狂。
*/
public class Huffman {
    ArrayList<H_Node> tree;
    int size;
    int[] char_freq;

    public Huffman(String text){
        this.size = 0;
        this.tree = new ArrayList<>();
        getCharFreq(text);
        initList();
    }

    public void getCharFreq(String text){
        char_freq = new int[255];

        for(int i=0; i < text.length(); i++){
            char_freq[(int) text.charAt(i)] += 1;
        }
    }

    public H_Node setCode(H_Node node, String code){
        if (node.left == null){
            node.setCode(code);
            return node;
        }
        else  {
            node.left = setCode(node.left, code + '0');
            node.right = setCode(node.right, code + '1');
        }
        return node;
    }

    public void insert(H_Node node){
        for(int i=0; i < tree.size(); i++){
            if(node.getWeight() > tree.get(i).getWeight()){
                tree.add(i, node);
                return;
            }
        }
        tree.add(node);
    }

    public void initList(){
        for(int i=0; i < 255; i++){
            if(char_freq[i] > 0){
                H_Node node = new H_Node(char_freq[i], (char) i);
                insert(node);
                size ++;
            }
        }
    }

    public void unite(){
        H_Node node = new H_Node(tree.get(tree.size() - 1).getWeight() + tree.get(tree.size() - 2).getWeight(),
                                tree.get(tree.size() - 1), tree.get(tree.size() - 2));
        tree.remove(tree.size() - 1);
        tree.remove(tree.size() - 1);
        insert(node);
    }

    public void beginHuffman(){
        while (tree.size() > 1)
            unite();
    }

    public void BFS(int mode){
        Queue<H_Node> q = new Queue<>(size);
        H_Node root = tree.get(0);
        tree.remove(0);
        root.setCode("");
        q.enqueue(root);
        H_Node pointer = null;
        while (!q.isEmpty()){
            pointer = q.dequeue();
            if(pointer.left == null){
                if(mode==0)
                    System.out.println(pointer.getElement() + ": " + pointer.getCode());
                else
                    tree.add(pointer);
            }else {
                pointer.left.setCode(pointer.getCode() + "0");
                q.enqueue(pointer.left);
                pointer.right.setCode(pointer.getCode() + "1");
                q.enqueue(pointer.right);
            }
        }
        if(mode != 0)
            beginHuffman();
    }

    public static void print(Huffman h){
        for(H_Node ele: h.tree) {
            System.out.println(ele.getElement() + ": " + ele.getWeight());
        }
    }

    public static void main(String[] args){
        String text = "I still have a dream. It is a dream deeply rooted in the Americal dream";
        Huffman h = new Huffman(text);
        print(h);
        System.out.println("*************************可爱的分割线君*********************************");
        h.beginHuffman();
        h.BFS(1);
        h.BFS(0);
    }
}

class H_Node{
    private char element;
    private int weight;
    public H_Node left;
    public H_Node right;
    private String code;

    public H_Node(int weight, H_Node left, H_Node right){
        this.weight = weight;
        this.left = left;
        this.right = right;
        this.element = '*';
        this.code = null;
    }

    public H_Node(int weight, char element){
        this.weight = weight;
        this.element = element;
        this.left = null;
        this.right = null;
        this.code = null;
    }

    public void setCode(String code){
        this.code = code;
    }

    public int getWeight(){
        return weight;
    }

    public String getCode(){
        return code;
    }

    public char getElement(){
        return element;
    }

}