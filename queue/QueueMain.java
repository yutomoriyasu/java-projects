import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import packages.Queue;

public class QueueMain {

	public static void main(String[] args) {
	
		String command, input;
		int initSize = 4;
		Queue theQueue = new Queue(initSize);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			command = "";
			input = "";
			System.out.print("command > ");
			System.out.flush();
			try {
				StringTokenizer st = new StringTokenizer(br.readLine());

				if (st.hasMoreElements()) {
					command = st.nextToken();
				}
				if (st.hasMoreElements()) {
					input = st.nextToken();
				}

				System.out.println(command + " " + input);
				System.out.flush();
			} catch (IOException e) {
				System.out.println("Error: " + e);
			}

			if (command.equals("quit")) {

				// ここにquitと入力されたときの処理を書く
				System.out.println("QueueMain Terminated");
				return;
				
			} else if (command.equals("insert")) {

				// ここにinsertと入力されたときの処理を書く
				theQueue.insert(input);
				
			} else if (command.equals("remove")) {

				// ここにremoveと入力されたときの処理を書く
				if (theQueue.isEmpty()) {
					System.out.println("The queue is empty. There is nothing to remove");
				}
				System.out.println(theQueue.remove());
				
			} else if (command.equals("peek")) {

				// ここにpeekと入力されたときの処理を書く
				if (theQueue.isEmpty()) {
					System.out.println("The queue is empty. There is nothing to peek");
				}
				System.out.println(theQueue.peek());
				
			} else {
				System.out.println("Command is not found: " + command);
			}
		}

	}

}