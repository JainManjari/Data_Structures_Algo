package BinaryTree;

import java.util.*;

class BTNode<T> {
	public T data;
	public BTNode<T> left;
	public BTNode<T> right;

	public BTNode(T data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class Triplet<Integer, Boolean> {
	int max;
	int min;
	boolean isBST;

}

class HTail<T> {
	T head;
	T tail;
}

class Pair<T> {
	T height;
	T diameter;
}

class Node<T> {
	T data;
	Node<T> next;

	public Node(T data) {
		this.data = data;
		next = null;
	}
}

public class BT {

	public static Node<Integer> bstLLout(BTNode<Integer> root) {
		return bstLL(root).head;
	}

	private static HTail<Node<Integer>> bstLL(BTNode<Integer> root) {
		// TODO Auto-generated method stub
		if (root == null) {
			HTail<Node<Integer>> node = new HTail();
			node.head = null;
			node.tail = null;
			return node;
		}
		HTail<Node<Integer>> left = bstLL(root.left);
		Node<Integer> node = new Node(root.data);
		HTail<Node<Integer>> r = new HTail();
		if (left.head != null) {
			left.tail.next = node;
			r.head = left.head;
		} else {
			r.head = node;
		}
		r.tail = node;
		HTail<Node<Integer>> right = bstLL(root.right);
		if (right.head != null) {
			r.tail.next = right.head;
		} else {
			r.tail = node;
		}
		return r;

	}

	public static BTNode<Integer> takeInput(Scanner in) {
		System.out.println("Enter root data: ");
		int rootData = in.nextInt();
		if (rootData == -1) {
			return null;
		}
		// BTNode<Integer> root=new BTNode(rootData);
		BTNode<Integer> root = new BTNode(rootData);
		System.out.print("left Child of root: " + root.data + "=>");
		root.left = takeInput(in);
		System.out.print("Right Child of root: " + root.data + "=>");
		root.right = takeInput(in);
		return root;
	}

	public static void printBT(BTNode<Integer> root) {
		if (root == null) {
			return;

		}
//		System.out.print(root.data+" ");;
//		printBT(root.left);
//		printBT(root.right);

		String s = "Root " + root.data + ": ";
		if (root.left != null) {
			s += "L" + root.left.data;
		}
		if (root.right != null) {
			s += ",R" + root.right.data;
		}
		System.out.println(s);
		printBT(root.left);
		printBT(root.right);
	}

	public static BTNode<Integer> takeInputIter(Scanner in) {
		Queue<BTNode<Integer>> q = new LinkedList<>();
		System.out.println("Enter root data: ");
		int ele = in.nextInt();
		BTNode<Integer> root = new BTNode(ele);
		q.add(root);
		while (!q.isEmpty()) {
			BTNode<Integer> t = q.remove();
			System.out.println("Enter left child of " + t.data);
			int left = in.nextInt();
			if (left != -1) {
				BTNode<Integer> leftC = new BTNode(left);
				t.left = leftC;
				q.add(leftC);
			}
			System.out.println("Enter right child of " + t.data);
			int right = in.nextInt();
			if (right != -1) {
				BTNode<Integer> rightC = new BTNode(right);
				t.right = rightC;
				q.add(rightC);
			}
		}
		return root;
	}

	public static void printBTIter(BTNode<Integer> root) {
		if (root == null) {
			return;
		}
		Queue<BTNode<Integer>> q = new LinkedList<>();
		System.out.println("Main root: " + " " + root.data);
		q.add(root);
		while (!q.isEmpty()) {
			BTNode<Integer> t = q.remove();
			System.out.print("Root: " + t.data + " => ");
			if (t.left != null) {
				System.out.print("L" + t.left.data);
				q.add(t.left);
			} else {
				System.out.print("L(-1)");
			}
			if (t.right != null) {
				System.out.print(",R" + t.right.data);
				q.add(t.right);
			} else {
				System.out.print(",R(-1)");
			}
			System.out.println();
		}
	}

	public static int countNodes(BTNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	public static int height(BTNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public static Pair<Integer> diameter(BTNode<Integer> root) {
		if (root == null) {
			Pair<Integer> p = new Pair();
			return p;
		}
		Pair<Integer> p = new Pair();
		Pair<Integer> l = diameter(root.left);
		Pair<Integer> r = diameter(root.right);
		p.height = 1 + Math.max(l.height, r.height);
		int op1 = l.height + r.height;
		int op2 = l.diameter;
		int op3 = r.diameter;
		p.diameter = Math.max(op1, Math.max(op2, op3));
		return p;
	}

	public static boolean isBSTout(BTNode<Integer> root) {
		return isBST(root).isBST;
	}

	public static Triplet<Integer, Boolean> isBST(BTNode<Integer> root) {
		if (root == null) {
			Triplet<Integer, Boolean> t = new Triplet();
			t.max = Integer.MIN_VALUE;
			t.min = Integer.MAX_VALUE;
			t.isBST = true;
			return t;
		}
		Triplet<Integer, Boolean> l = isBST(root.left);
		Triplet<Integer, Boolean> r = isBST(root.right);
		Triplet<Integer, Boolean> t = new Triplet();
		t.max = Math.max(root.data, Math.max(l.max, r.max));
		t.min = Math.min(root.data, Math.min(l.min, r.min));
		t.isBST = (l.isBST && r.isBST && (l.max < root.data) && (r.min >= root.data));
		System.out.println(t.max + " " + t.min + " " + t.isBST);
		return t;

	}

	public static boolean isBST3(BTNode<Integer> root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (min >= root.data || max < root.data) {
			return false;
		}
		boolean left = isBST3(root.left, min, root.data - 1);
		boolean right = isBST3(root.right, root.data, max);
		return left && right;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		BTNode<Integer> root = takeInputIter(in);
		printBTIter(root);
		System.out.println(isBSTout(root));
//		ArrayList<Integer> a=new ArrayList<Integer>();
//		System.out.println(a.isEmpty());
	}

}
