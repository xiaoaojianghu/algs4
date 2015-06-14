package sorting;

/*
 * 堆排序
 * 基本一次成功了,还不错!
 */

public class MaxPQmy<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N = 0;
	public MaxPQmy(int N){
		pq = (Key [])new Comparable[N + 1];
	}

	public Key delMax(){
		Key key = pq[1];
		exch(1, N--);//N忘了减去1
		sinkMy(1);
		return key;
	}

	private  boolean less( int i, int j){
		return pq[i].compareTo( pq[j] ) < 0;
	}

	private void exch(int i, int j){
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}

	public void insert(Key key){
		pq[++N] = key;
		swimMy(N);
	}

	public boolean isEmpty(){
		return N==0;
	}

	private void swimMy(int k){
		int cur = k;
		int parent = k/2;
		while( parent > 0 && less(parent, cur) ){
			exch(cur, parent);
			cur = parent;
			parent /= 2;
		}
	}

	private void sinkMy(int k){
		int cur = k;
		int child = 2*k;
		while( child <= N ){
			int max = child;	
			if(child + 1 <= N && less(child, child+1))
				max = child + 1;
			if( less(cur, max))
				exch(cur, max);
			cur = max;
			child = 2 * max;
		}
	}

	private void swim(int k){
		while(k > 1 &&  less(k/2, k)){
			exch(k, k/2);
			k /= 2;
		}
	}

	private void sink(int k){
		while(2*k <= N){
			int j = 2*k;
			if(j<N && less(j,j+1)) j++;//通过j<N,当最后右子树不存在时,使得访问不会越界
			if(less(j,k)) 
				break; //sink到一定程度,就跳出.上面实现时候没有考虑到!
						//swim 不知道为啥中间过程没有跳出
			exch(j,k);
			k=j;
		}
	}


}