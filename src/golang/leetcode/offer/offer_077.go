package offer

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func sortList(head *ListNode) *ListNode {
	return helper(head, nil)
}

func helper(head *ListNode, tail *ListNode) *ListNode {
	fmt.Printf("%v %v\n", head, tail)
	if head == tail {
		return head
	}
	var nh *ListNode = nil
	var h *ListNode = nil
	var t *ListNode
	for cur := head.Next; cur != tail; cur = cur.Next {
		if cur.Val < head.Val {
			if nh == nil {
				nh = cur
				h = nh
			} else {
				h.Next = cur
				h = cur
			}
		} else {
			if t == nil {
				t = cur
			} else {
				t.Next = cur
				t = cur
			}
		}
	}
	var newHead *ListNode = head
	if h != nil {
		h.Next = head
		newHead = helper(nh, h)
	}
	t.Next = tail
	r := helper(head.Next, t)
	head.Next = r
	return newHead
}
