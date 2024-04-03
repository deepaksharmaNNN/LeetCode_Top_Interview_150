/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    class Pair{
        int length;
        ListNode node;
        Pair(int length, ListNode node){
            this.length = length;
            this.node = node;
        }
    }
    public Pair length(ListNode head){
        ListNode temp = head;
        int count = 0;
        ListNode prev = null;
        while(temp != null){
            prev = temp;
            temp = temp.next;
            count++;
        }
        return new Pair(count, prev);
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        Pair pair = length(head);
        int length = pair.length;
        ListNode last = pair.node;
        k = k % length;
        if(k == length) return head;
        int len = length - k;
        last.next = head;
        ListNode temp = head;
        while(len - 1 > 0){
            len--;
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}