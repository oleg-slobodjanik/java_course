package com.slobodianyk.homework1.reverselinkedlist;

class ListNode {
    @SuppressWarnings("checkstyle:VisibilityModifier")
    int val;
    @SuppressWarnings("checkstyle:VisibilityModifier")
    ListNode next;

    ListNode() {
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
