package Queue;

public class Queue_Class {
int data[];
int front;
int rear;
int size;
public Queue_Class(int capacity) {
	data = new int[capacity];
	front = -1;
	rear = -1;
	size = 0;
	
}
public int size() {
	return size;
}
public boolean isEmpty() {
	return(size() == 0);
}
public int front() throws QueueEmptyException{
	if(isEmpty()) {
		throw new QueueEmptyException();
	}
	return data[front];
}
public void enqueue(int element) throws QueueFullException{
	if(size == data.length) {
		throw new QueueFullException();
	}
	if(size == 0) {
		front = -1;
	}
	size++;
	rear = (rear+1)%data.length;
	data[rear] = element;
	
}
public int dequeue() throws QueueEmptyException{
	if(isEmpty()) {
		throw new QueueEmptyException();
	}
	int temp = data[front];
	front = (front+1)%data.length;
	size--;
	if(size == 0) {
		front = -1;
		rear = -1;
	}
	return temp;
	
}
}
