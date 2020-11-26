package org.maple.algorithm;

/*
2. 两数相加
链接：https://leetcode-cn.com/problems/add-two-numbers/

给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */
public class _2 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 创建一个为 0 的头部链表，边遍历边赋值
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumber1s(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, current = dummyHead;
        // 进位的值
        int beyond = 0;
        while (p != null || q != null) {
            int numP = (p == null) ? 0 : p.val;
            int numQ = (q == null) ? 0 : q.val;
            // 当前位两个值的和 + 进位的值
            int sum = numP + numQ + beyond;
            // result 的 ListNode
            current.next = new ListNode(sum % 10);
            // 进位的值
            beyond = sum / 10;
            // 移动指针
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
            current = current.next;
        }
        // 如果进位的值大于0
        if (beyond > 0) {
            current.next = new ListNode(beyond);
        }
        return dummyHead.next;
    }


}
