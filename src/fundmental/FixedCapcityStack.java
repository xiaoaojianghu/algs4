package fundmental;

public class FixedCapcityStack<Item> {
	private int N;
	private int size;
	private Item[] items;

	public FixedCapcityStack(int N){
		this.N = N;
		items = (Item[])new Object[N]; //!!!!!
	}
	public void push(Item i) {
		if(size < N){
			items[++size] = i;
		}
	}
	public Item pop(){
		if(size > 0){
			return items[size--];
		}
		return null;
	}
	public boolean isEmpty(){
		return size==0;
	}

	public int size() {
		return size;
	}

	public void resize(int size){
		Item[] newSpace = (Item[])new Object[size];
		for(int i = 0; i < this.size; i++){
			newSpace[i] = items[i];
		}
		N = size;
		items = newSpace;
	}
}
