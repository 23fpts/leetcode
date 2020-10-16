package thc.daily;

/**
 * @author thc
 * @Title:
 * @Package thc.daily
 * @Description:
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  * public class ListNode {
 *  *     int val;
 *  *     ListNode next;
 *  *     ListNode() {}
 *  *     ListNode(int val) { this.val = val; }
 *  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *  * }
 *
 * <p>https://leetcode-cn.com/problems/swap-nodes-in-pairs/</p>
 * @date 2020/10/13 11:10 上午
 */
public class P024_swapPairs {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void printList(ListNode head) {
        ListNode tmp = head;
        while (tmp!=null) {
            System.out.print(tmp.val+"->");
            tmp = tmp.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        // 如果只有一个结点直接返回
        if (head==null || head.next==null) {
            return head;
        }
        // 新的头结点必是第二个结点
        ListNode newHead = head.next;
        // first 和 second是交换的结点
        ListNode first;
        ListNode second;
        // newFirst 是下一组需要交换的结点
        ListNode newFirst;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode preFirst = preHead;
        while (preFirst.next!=null && preFirst.next.next!=null) {
            // 赋值
            first = preFirst.next;
            second = preFirst.next.next;
            newFirst = second.next;
            // 交换
            first.next = newFirst;
            preFirst.next = second;
            second.next = first;
            // 循环
            preFirst = first;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        P024_swapPairs test = new P024_swapPairs();
        test.printList(node1);
        System.out.println();
        ListNode newHead = test.swapPairs(node1);
        test.printList(newHead);

    }
}
