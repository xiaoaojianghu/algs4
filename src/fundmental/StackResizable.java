package fundmental;

public class StackResizable<Item> {
	private int N;
	private int size;
	private Item[] items;

	public StackResizable(int N){
		this.N = N;
		items = (Item[])new Object[N]; //!!!!!
	}
	public void push(Item i) {
		if(size == N){
			resize( 2*N );
			items[size++] = i;
		}
	}
	public Item pop(){
		Item item = items[--size];
		items[size] = null; // 避免对象游离，否则内存得不到回收
		if(size > 0 && size <= N/4){
			resize(N/2);
		}
		return item;
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
