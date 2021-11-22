package linkedlist;

import java.util.List;

public class LC2 {
    /**
     * Definition for singly-linked list.
     */
    class ListNode {
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

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode ans = new ListNode(0);
            ListNode head = ans;
            int plus = 0;
            while (l1.next != null && l2.next != null) {
                if (l1.val + l2.val + plus >= 10) {
                    ans.val = l1.val + l2.val + plus - 10;
                    plus = 1;
                } else {
                    ans.val = l1.val + l2.val + plus;
                    plus = 0;
                }
                if (ans.next == null) {
                    ListNode next = new ListNode(0);
                    ans.next = next;
                    ans = ans.next;
                }
                l1 = l1.next;
                l2 = l2.next;
            }

            if (l1.next == null) {
                while (l2.next != null) {
                    if (l2.val + plus >= 10) {
                        ans.val =l2.val + plus - 10;
                        plus = 1;
                    } else {
                        ans.val = l2.val + plus;
                        plus = 0;
                    }
                    ListNode next = new ListNode(0);
                    l2 = l2.next;
                    ans.next = next;
                    ans = ans.next;
                }
            } else {
                while (l1.next != null) {
                    if (l1.val + plus >= 10) {
                        ans.val =l1.val + plus - 10;
                        plus = 1;
                    } else {
                        ans.val = l1.val + plus;
                        plus = 0;
                    }
                    ListNode next = new ListNode(0);
                    l1 = l1.next;
                    ans.next = next;
                    ans = ans.next;
                }
            }
            return ans;
        }
    }
}
