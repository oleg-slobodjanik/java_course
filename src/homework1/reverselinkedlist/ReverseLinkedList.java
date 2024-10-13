package homework1.reverselinkedlist;

public class ReverseLinkedList {

//    public static ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode current = head;
//
//        while (current != null) {
//            ListNode nextTemp = current.next;
//            current.next = prev;
//            prev = current;
//            current = nextTemp;
//        }
//
//        return prev;
//    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static ListNode reverseListIteratively(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;  // тимчасово зберігаємо наступний вузол
            curr.next = prev;               // змінюємо вказівник
            prev = curr;                    // рухаємо prev вперед
            curr = nextTemp;                // рухаємо curr вперед
        }
        return prev;
    }

    public static ListNode reverseListRecursively(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversedList = reverseListRecursively(head.next);
        head.next.next = head;
        head.next = null;

        return reversedList;
    }


    public static void main(String[] args) {


        //================ Example 1: ===================

        // Створюємо початковий список: 1 -> 2 -> 3 -> 4 -> 5
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//
//        System.out.println("Original List:");
//        printList(head);

//        ListNode reversedHead = reverseList(head);
//
//        System.out.println("Reversed List:");
//        printList(reversedHead);



        //================ Example 2: ===================

        // Створюємо початковий список: 1 -> 2
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//
//        System.out.println("Original List:");
//        printList(head);
//
//        ListNode reversedHead = reverseList(head);
//
//        System.out.println("Reversed List:");
//        printList(reversedHead);


        //================ Example 3: ===================

        // Створюємо початковий список: 1 -> 2 -> 3 -> 4 -> 5
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        // Створюємо список з різними значеннями: -5000 -> 0 -> 5000
        ListNode head = new ListNode(-5000, new ListNode(0, new ListNode(5000)));

        System.out.println("Original List:");
        printList(head);

        ListNode reversedHead1 = reverseListIteratively(head);
//        ListNode reversedHead2 = reverseListRecursively(head);

        System.out.println("Reversed List:");
        printList(reversedHead1);
//        printList(reversedHead2);

    }
}
