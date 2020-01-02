package basics;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * <p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * <p>Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public static void main(String[] args) {

//        ListNode result = new AddTwoNumbers().addTwoNumbers(node, node1);
//        System.out.println(result);
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode first = l1;
        ListNode second = l2;
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode prev = head;
        while (first != null && second != null) {
            int q = (first.val + second.val + carry) / 10;
            int r = (first.val + second.val + carry) % 10;
            carry = q;
            ListNode node = new ListNode(r);
            prev.next = node;
            prev = node;
            first = first.next;
            second = second.next;
        }

        while (first != null) {
            int q = (first.val + carry) / 10;
            int r = (first.val + carry) % 10;
            carry = q;
            ListNode node = new ListNode(r);
            prev.next = node;
            prev = node;
            first = first.next;
        }

        while (second != null) {
            int q = (second.val + carry) / 10;
            int r = (second.val + carry) % 10;
            carry = q;
            ListNode node = new ListNode(r);
            prev.next = node;
            prev = node;
            second = second.next;
        }

        if (carry != 0) prev.next = new ListNode(carry);

        return head.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        int sum;
        int carry = 0;
        ListNode current = null;
        while(temp1 != null || temp2!=null){
            sum = carry + (temp1!=null?temp1.val:0) + (temp2!=null?temp2.val:0);
            if(sum>9){
                carry = 1;
                sum = sum-10;
            }else{
                carry = 0;
            }
            ListNode r = new ListNode(sum);
            r.next = null;
            if(current != null){
                current.next = r;
            }else{
                result = r;
            }
            current = r;

            temp1 = temp1!=null?temp1.next:null;
            temp2 = temp2!=null?temp2.next:null;

        }
        if(carry!=0){
            ListNode r = new ListNode(carry);
            current.next = r;
        }

        return result;

    }
}
