package searching;

import edu.princeton.cs.algs4.Queue;


/*
*二分查找搞了这么长时间, 模拟map老是出bug
*2015年6月7日16:24:03
*/
public class BinarySearchST<Key extends Comparable<Key>, Value>{
	private Key[] keys;
	private Value[] vals;
	private int N;

	public BinarySearchST(int capacity){//fang xing?
		keys = (Key[])new String[capacity];
		vals = (Value[])new Integer[capacity];
		N = 0;
	}

	public Value getMy(Key k){
		int index = search(k, 0, N-1);
		if (index == -1)
			return null;
		else
			return vals[index];
	}

	private void insert(Key k, Value v){
		keys[N] = k;
		vals[N++] = v;
		int i = N-1;
		Key temp = null;
		Value tempV = null;
		while(i > 0 ){
			if(keys[i-1].compareTo(keys[i]) > 0){
	/*			temp = keys[i];
				keys[i] = keys[i-1];
				keys[--i] = temp;*/
				
				/*
				 * 排序只排序了key,没有排序value........
				 * 2015年6月7日11:32:50
				 * 吃饭去
				 */
				temp = keys[i];
				tempV = vals[i];
				keys[i] = keys[i-1];
				vals[i] = vals[i-1];
				i--;
				keys[i] = temp;
				vals[i] = tempV;
			} else{
				return;
			}
			
		}
		
	}
	public void putMy(Key k, Value v){
		int index = search(k, 0, N-1);
		if(index == -1){
			insert(k,v);
		} else {
			vals[index] = v;
		}	
	}

	public boolean contains(Key k){
		int r = search(k, 0, N-1);
		if( r == -1)
			return false;
		else
			return true;
	}


	public int search(Key k, int lo, int hi){
		if(N == 0 || lo > hi){
			return -1;
		}
		int mid = (hi+lo)/2;
		int cmp = k.compareTo(keys[mid]);
		if(cmp == 0)
			return mid;
		else if(cmp > 0)
			//	 search(k, mid+1, hi); 没有加return,返回的总是-1.所以所有元素不管重复与否全都插入
//			2015年6月7日10:59:09
			return search(k, mid+1, hi);
		else
			return search(k,lo, mid-1);
	}

	public void show() {
		for(int i = 0; i < N; i++){
			System.out.println(keys[i] + ": " + vals[i]);
		}
	}

	/*
	*和search的实现一样, 这是树上的方式.
	* 没有想到的是返回位置的同时还能确定元素的有无
	* 根据的是vals[], 看put吧
	*/
	public int rankRecursion(Key k, int lo, int hi) {
		if(lo > hi)
			return lo;
		int mid = (lo + hi)/2;
		int cmp = k.compareTo(keys[mid]);
		if(cmp > 0)
			return rankRecursion(k, mid + 1, hi);
		else if( cmp < 0 )
			return rankRecursion(k, lo, mid - 1);
		else 
			return mid;
	}
	/**
	*最重要的是rank,
	*也就是lo返回的位置
	*/
	public int rank(Key k){
		int lo = 0;
		int hi = N-1;
		
		while(lo <= hi){
			int mid  = (lo + hi)/2;
			int cmp = k.compareTo(keys[mid]);
			if(cmp > 0){
				lo = mid + 1;
			} else if( cmp < 0 ){
				hi = mid - 1;
			} else 
				return mid;
		}

		return lo;
	}

	public Value get(Key k){
		if(N == 0)
			return null;
		int index = rank(k);
		if(keys[index] != null && k.compareTo(keys[index]) == 0)
			return vals[index];
		return null;
	}

	public void put(Key k, Value v){
		int index = rank(k);
		if(keys[index] == null || k.compareTo(keys[index]) != 0){

			for(int i = N-1; i >= index; i--){
				vals[i+1] = vals[i];
				keys[i+1] = keys[i];
			}
			vals[index] = v;
			keys[index] = k;
			N++;
		} else
			vals[index] = v;

	}

	public Key min(){
		return keys[0];
	}

	public Key max(){
		return keys[N-1];
	}

	public Key select(int i){
		return keys[i-1];
	}

	public Key ceiling(Key k){
		return keys[rank(k)];
	}

	public Iterable<Key> keys(Key lo, Key hi){
		Queue q = new Queue();
		for(int i = 0; i < N; i++){
			q.enqueue(keys[i]);
		}
		return q;
	}
}