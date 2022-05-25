package packages;
import packages.Node;

public class BinaryTree {
	
	private Node root; // 最上位の親ノード

	public boolean isEmpty() {
		return root == null;
	}

	public Node getMinNode() {

		// ここにgetMinNodeの処理を書く
		Node node;
    node = root.getMinNode();
    if (node != null) {
      return node;
    } else {
      return root;
    }
	}

	public Node getMaxNode() {

		// ここにgetMaxNodeの処理を書く
		Node node;
    node = root.getMaxNode();
    if (node != null) {
      return node;
    } else {
      return root;
    }
	}

	public Node findNode(double value) {

		// ここにfindNodeの処理を書く
		Node node;
    node = root;
    while (node != null) {
      if (node.getValue() < value) {
        node = node.getRightNode();
        continue;
      }
      if (node.getValue() > value) {
        node = node.getLeftNode();
        continue;
      }
      if (node.getValue() == value) {
        break;
      }
    }
    return node;
	}

	public void insertNode(double value) {

		// ここにinsertNodeの処理を書く
    Node node;
    node = root;
    // ルートがない場合
    if (root == null) {
      root = new Node(value);
      System.out.println("A node is successfully inserted");
      return;
    }
		while (node != null) {
      if (node.getValue() == value) {
        System.out.println("A node that has the same value already exists");
        return;
      }
      if (node.getValue() < value) {
        if (node.getRightNode() == null) {
          Node newRightNode = new Node(value);
          node.setRightNode(newRightNode);
          newRightNode.setUpperNode(node);
          System.out.println("A node is successfully inserted");
          return;
        }
        node = node.getRightNode();
        continue;
      }
      if (node.getValue() > value) {
        if (node.getLeftNode() == null) {
          Node newLeftNode = new Node(value);
          node.setLeftNode(newLeftNode);
          newLeftNode.setUpperNode(node);
          System.out.println("A node is successfully inserted");
          return;
        }
        node = node.getLeftNode();
        continue;
      }
    }
	}

	public void removeNode(Node node) {

		// ここにremoveNodeの処理を書く
    // ノードがルートの場合
    if (node == root) {
      Node newRoot = root.getLeftNode();
      newRoot.getMaxNode().setRightNode(root.getRightNode());
      root = newRoot;
      return;
    }
    // ノードが子を持たない場合
		if (node.getLeftNode() == null && node.getRightNode() == null) {
      if (node.getUpperNode().getLeftNode() == node) {
        node.getUpperNode().setLeftNode(null);
        return;
      }
      if (node.getUpperNode().getRightNode() == node) {
        node.getUpperNode().setRightNode(null);
        return;
      }
    }
    // ノードが1つの子を持つ場合
    if (node.getLeftNode() == null && node.getRightNode() != null) {
      node.getUpperNode().setRightNode(node.getRightNode());
      return;
    }
    if (node.getLeftNode() != null && node.getRightNode() == null) {
      node.getUpperNode().setLeftNode(node.getLeftNode());
      return;
    }
    // ノードが2つの子を持つ場合
    
	}

	private void printSubTree(Node node) {
		System.out.print(" ( " + node.getValue());
		
		if (node.getLeftNode() != null || node.getRightNode() != null) {
			if (node.getLeftNode() == null) {
				System.out.print(" ( null ) ");
			} else {
				printSubTree(node.getLeftNode());
			}

			if (node.getRightNode() == null) {
				System.out.print(" ( null ) ");
			} else {
				printSubTree(node.getRightNode());
			}
		}

		System.out.print( " )");
	}

	public void printTree() {
		if (isEmpty()) {
			System.out.print("( null )");
		} else {
			printSubTree(root);
		}
		System.out.println();
	}

}