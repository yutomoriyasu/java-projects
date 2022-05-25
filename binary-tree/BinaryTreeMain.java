import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import packages.BinaryTree;
import packages.Node;

public class BinaryTreeMain {

	public static void main(String[] args) {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String command, input; // コマンド，入力
		double value = 0; // 数値
		BinaryTree tree = new BinaryTree(); // 二分探索木の作成
		Node node = null;

		while (true) {
			command = "";
			input = "";

			boolean hasValue = false; // 数値が入力されたときtrueになる

			System.out.print("command > ");
			System.out.flush();

			try {
				StringTokenizer st = new StringTokenizer(br.readLine());

				// 最初のトークンはコマンド
				if (st.hasMoreElements()) {
					command = st.nextToken();
				}
				// 次のトークンがあれば数値
				if (st.hasMoreElements()) {
					input = st.nextToken();
					try {
						value = Double.parseDouble(input);
						hasValue = true;
					} catch (NumberFormatException e) {
						System.out.println("Illegal number was entered: " + input);
						continue;
					}
				}

				System.out.println(command + " " + input);
				System.out.flush();
			} 
			
			catch (IOException e) {
				System.out.println("Error: " + e);
			}

			if (command.equals("quit")) {
				break;
			} 
			
			else if (command.equals("min")) {

				// 最小値をプリントする処理を書く
				System.out.println("Minimum number is " + tree.getMinNode().getValue());
			} 
			
			else if (command.equals("max")) {

				// 最大値をプリントする処理を書く
				System.out.println("Maximum number is " + tree.getMaxNode().getValue());
			} 
			
			else if (command.equals("find")) {

				// 指定した値があるか調べる処理を書く
				boolean treeHasCertainNode = false;
        if (tree.findNode(value) != null) {
          treeHasCertainNode = true;
        }
        if (treeHasCertainNode) {
          System.out.println("Binary tree has the node");
        } else {
          System.out.println("Binary tree doesn't have the node");
        }
			} 
			
			else if (command.equals("insert")) {

				// 値を挿入する処理を書く
				tree.insertNode(value);
			} 
			
			else if (command.equals("remove")) {

				// 値を削除する処理を書く
        node = tree.findNode(value);
        if (node == null) {
          System.out.println("There is no node that has the value");
        } else {
          tree.removeNode(node);
          System.out.println("A node is successfully removed");
        }
			} 
			
			else if (command.equals("print")) {
				tree.printTree();
			} 
			
			else {
				System.out.println("Command is not found: " + command);
			}
		}

	}

}