package 剑指offer;

/**
 * @date 2022/1/7 14:17
 */
public class Q35_复杂链表的复制 {

    class Solution {
        public Node copyRandomList(Node head) {
            return null;
        }
    }
}


/**
 *
 * class Solution {
 *         public Node copyRandomList(Node head) {
 *             //链表的复制，你是不是想到了return head？？？笑死
 *             //这题其实不难，遍历赋值就行了，但是遍历整个链表，random指向的随机结点再去遍历，
 *             //时间复杂度为O（n） + O（n2）
 *             //可以优化吗？
 *             //我目前没想到，先写O（n2）的算法吧
 *             Node headd = head;
 *             Node node = new Node(head.val);
 *             Node headNode = node;//头结点
 *             if(head ==null)
 *                 return null;
 *             while (head!=null){
 *                 Node tmp = new Node(head.val);
 *                 node.next = tmp;
 *                 node = tmp;
 *                 head=head.next;
 *             }
 *             //拿到头结点headNode,这里还需遍历head，
 *             Node headNodee = headNode;
 *             while (headd!=null){
 *                 //我们新赋值的headNode和headd指向是一样
 *                 headNode.random = headd.random;
 *                 headd=headd.next;
 *                 headNode=headNode.next;
 *                 //突然觉得这题很美妙，让我理解了什么是深拷贝和浅拷贝
 *                 //我这里还是浅拷贝，只是复制了引用的地址罢了！！
 *                 //_________________________________________________
 *                 //再次犯病，你这不还是浅拷贝！！！
 *                 Node tmp = headNode.random;//这样可以开辟一个真正的对象
 *                 headd.random = tmp;
 *                 headd=headd.next;
 *                 headNode=headNode.next;
 *                 //我必须保证headNode引用的是自己的结点啊
 *                 //计数法？不太行，其实写到这我之前所有的想法和思想都错了，
 *                 //head的结点指向是没用下标的，我无法根据他的引用，拿到对自己的引用
 *                 //写到这，也不是没用收获，至少加深了我对深拷贝的认知
 *
 *                 headd=headd.next;
 *                 headNode=headNode.next;
 *             }
 *             return headNodee;
 *
 *         }
 *     }
 */