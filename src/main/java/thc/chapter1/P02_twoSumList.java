package thc.chapter1;

import thc.utils.ListNode;

/**
 * @author thc
 * @Title:
 * @Package
 * @Description:
 * @date 2020/5/246:51 下午
 */
public class P02_twoSumList {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 头节点
        ListNode head = new ListNode(0);
        // 遍历指针
        ListNode p = head;
        // 处理进位
        int c = 0;
        while(l1!=null || l2!=null){
            int x = l1 == null? 0 : l1.getVal();
            int y = l2 == null? 0 : l2.getVal();

            int sum = x + y + c;
            c = sum/10;
            int value = sum%10;
            p.setNext(new ListNode(value));

            p = p.getNext();
            if(l1!=null){
                l1 = l1.getNext();
            }
            if(l2!=null){
                l2 = l2.getNext();
            }
        }
        if(c==1){
            p.setNext(new ListNode(c));
        }
        return head.getNext();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.setNext(new ListNode(4));
        l1.getNext().setNext(new ListNode(3));

        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
        l2.setNext(new ListNode(6));
//        l2.next.next = new ListNode(4);
        l2.getNext().setNext(new ListNode(4));
        System.out.println(l1);
        System.out.println(l2);

        l1.output();
        System.out.println();
        l2.output();
        System.out.println();
        P02_twoSumList test = new P02_twoSumList();
        ListNode result = test.addTwoNumbers(l1, l2);
        result.output();

    }
}
