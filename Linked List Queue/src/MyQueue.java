public class MyQueue<T> implements QueueADT<T>{
	
	MyLinkedList<T> queue;

	@Override
	public void offer(T item) {
		queue.add(item);
	}

	@Override
	public T poll() {
		return queue.remove(0);
	}

	@Override
	public T peek() {
		return queue.get(0);
	}

	@Override
	public int size() {
		return queue.size();
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public void clear() {
		while(!queue.isEmpty()) {
			queue.remove(0);
		}
	}

}
