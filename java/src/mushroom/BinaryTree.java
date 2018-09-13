package mushroom;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	public static class Listing {
		int number;

		public Listing(int number) {
			this.number = number;
		}

		public Listing deepClone() {
			return new Listing(number);
		}
	}

	public static class TreeNode {
		public Listing l;

		public TreeNode left;
		public TreeNode right;

		public TreeNode(Listing l) {
			this.l = l.deepClone();
		}
	}

	public TreeNode root;

	public BinaryTree() {
		root = null;
	}

	public void insert(Listing l) {

		if (root == null) {
			root = new TreeNode(l);
			return;
		}
		TreeNode node = root;
		while (true) {
			if (l.number < node.l.number) {
				if (node.left == null) {
					node.left = new TreeNode(l);
					break;
				}
				node = node.left;
			} else {
				if (node.right == null) {
					node.right = new TreeNode(l);
					break;
				}
				node = node.right;
			}
		}
	}

	public TreeNode bfs(Listing l) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode e = q.remove();
			System.out.println("Checking " + e.l.number + " With " + l.number);
			if (e.l.number == l.number) {
				return e;
			}
			if (e.left != null && l.number < e.l.number) {
				q.add(e.left);
			}
			if (e.right != null && l.number > e.l.number) {
				q.add(e.right);
			}
		}
		return null;
	}

	public TreeNode dfsRecursion(Listing l, TreeNode node) {
		if (node == null) {
			return null;
		}
		System.out.println("Checking " + node.l.number + " With " + l.number);
		if (l.number == node.l.number) {
			return node;
		}
		if (l.number < node.l.number) {
			return dfsRecursion(l, node.left);
		} else {
			return dfsRecursion(l, node.right);
		}
	}

	public TreeNode dfs(Listing l) {
		return dfsRecursion(l, root);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(new Listing(50));
		bt.insert(new Listing(40));
		bt.insert(new Listing(30));
		bt.insert(new Listing(45));
		bt.insert(new Listing(100));
		System.out.println(bt.bfs(new Listing(45)).l.number);
		System.out.println(bt.dfs(new Listing(100)).l.number);
	}
}
