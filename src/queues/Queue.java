/**
 *
 */
package queues;

import java.util.LinkedList;

/**
 * @author Personal
 *
 */
public class Queue<T> {
	LinkedList<T> queue = new LinkedList<>();


	public void enqueue(T item) {
		queue.add(item);
	}
	/**
	 * remove items from queue.
	 */
	public Object dequeue() {
		if (queue.size() == 0) {
			throw new RuntimeException();
		}
		Object data = queue.get(0);
		queue.remove(0);
		return data;
	}
	/**
	 * Check if queue is empty.
	 */

	public boolean isEmpty() {
		if (queue.size() == 0) {
			return true;
		}
		return false;
	}
	/**
	 * check queue size.
	 */
	public int size() {
		return queue.size();
	}
}
