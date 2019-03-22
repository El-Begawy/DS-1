public class MySpecialLinkedListUtils {
    public static double[] summary(LinkedListNode head) {
        double count = 0;
        double[] x = new double[5];
        x[4] = 20130124;
        LinkedListNode temp = head;
        while (temp != null) {
            x[0] += temp.getValue();
            count++;
            if (x[3] < temp.getValue())
                x[3] = temp.getValue();
            if (x[4] > temp.getValue())
                x[4] = temp.getValue();
            temp = temp.getNext();
        }
        temp = head;
        for (int i = 0; i < (count / 2) - 1; i++) {
            temp = temp.getNext();
        }
        if(count%2==1)
        {
            x[2]+=temp.getNext().getValue();
        }
        x[1] = x[0] / count;
        x[2] = temp.getValue();
        return x;
    }

    public static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode previous;
        previous = null;
        LinkedListNode current = head;
        LinkedListNode next = null;
        while (current != null) {
            next = current.getNext();
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static LinkedListNode evenIndexedElement(LinkedListNode head) {
        LinkedListNode current = head.getNext().getNext();
        LinkedListNode newhead = head;
        LinkedListNode newcurrent = newhead;
        while (current != null) {
            newcurrent.next = current;
            newcurrent = current;
            current = current.getNext();
            if (current != null)
                current = current.getNext();
        }
        return newhead;
    }

    public static LinkedListNode insertionSort(LinkedListNode head) {
        LinkedListNode sorted = null, prev = sorted, current = head;
        while (current != null && prev != head) {
            LinkedListNode next = current;
            while (next.getNext() != prev) {
                if (next.value >= next.next.value) {
                    int temp = next.value;
                    next.value = next.next.value;
                    next.next.value = temp;

                }
                next = next.getNext();
            }
            prev = next;
            current = head;
        }
        return current;
    }

    static LinkedListNode getMid(LinkedListNode head) {
        if (head == null)
            return head;
        LinkedListNode fastptr = head.next;
        LinkedListNode slowptr = head;
        while (fastptr != null) {
            fastptr = fastptr.getNext();
            if (fastptr != null) {
                slowptr = slowptr.next;
                fastptr = fastptr.next;
            }
        }
        return slowptr;
    }

    static LinkedListNode Merge(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode newhead = null;
        if (head1.getValue() < head2.getValue()) {
            newhead = head1;
            if (head1.getNext() != null)
                newhead.next = Merge(head1.next, head2);
            else
                newhead.next = head2;
        } else {
            newhead = head2;
            if (head2.getNext() != null)
                newhead.next = Merge(head1, head2.getNext());
            else
                newhead.next = head1;
        }
        return newhead;
    }

    public static LinkedListNode mergeSort(LinkedListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // get the middle of the list
        LinkedListNode middle = getMid(head);
        LinkedListNode next = middle.getNext();
        middle.next = null;

        // Apply mergeSort on left list
        LinkedListNode left = mergeSort(head);

        // Apply mergeSort on right list
        LinkedListNode right = mergeSort(next);

        // Merge the left and right lists
        LinkedListNode sortedlist = Merge(left, right);
        return sortedlist;
    }

    public static LinkedListNode removeCentralNode(LinkedListNode head) {
        LinkedListNode current = head;
        int count = 0;
        while (current.getNext() != null) {
            count++;
            current = current.getNext();
        }
        current = head;
        LinkedListNode prev;
        for (int i = 0; i < count / 2 - 1; i++) {
            current = current.getNext();
        }
        prev = current;
        current = current.getNext();
        prev.next = current.getNext();
        return head;
    }

    public static boolean palindrome(LinkedListNode head) {
        LinkedListNode current = head;
        int count = 0;
        while (current.getNext() != null) {
            count++;
            current = current.getNext();
        }
        LinkedListNode otherside = head;
        boolean flag = true;
        current = head;
        for (int i = 0; i < count / 2; i++) {
            for (int j = i; j < count; j++)
                otherside = otherside.getNext();
            if (otherside.getValue() != current.getValue()) {
                flag = false;
                break;
            }
            current = current.getNext();
            otherside = head;
        }
        return flag;
    }

    public static void printlist(LinkedListNode head) {
        while (head != null) {
            System.out.print(head.getValue() + ",");
            head = head.getNext();
        }
    }
}
