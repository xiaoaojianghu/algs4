package searching;

public class LinearProbingHashST<Key, Value>{
	private Key[] keys;
	private Value[] vals;
	private int M;
	private int N;
	LinearProbingHashST(){
		this(11);
	}
	LinearProbingHashST(int M){
		this.M = M;
		keys = (Key[]) new  Object[M];
		vals = (Value[]) new Object[M];
	}

	private int hash(Key k){
		return (k.hashCode() & 0x07ffffff) % M;
	}

	public void putMy(Key k, Value v){
		int i = hash(k);
		for(Key key = keys[i]; key != null; key = keys[++i]){
			if(k.equals(key)){
				vals[i] = v;
				return;
			}
		}
		keys[i] = k;
		vals[i] = v;
	}

	public Value getMy(Key k){
		int i = hash(k);
		for(Key key = keys[i]; key != null; key = keys[++i]){
			if(k.equals(key)){
				return vals[i];
			}
		}
		return null;
	}

	public Value get(Key k){
		for(int i = hash(k); keys[i] != null; i = ++i % M)
			if(keys[i].equals(k))
				return vals[i];
		return null;
	}

	public void put(Key k, Value v){
//		if(N > M/2)
//			resize(2*M);
		int i;
		for(i = hash(k); keys[i] != null; i = ++i % M){
			if(k.equals(keys[i])){
				vals[i] = v;
				return;
			}
		}
		keys[i] = k;
		vals[i] = v;
		N++;
	}

	private void resize(int M){
		LinearProbingHashST<Key, Value> set = new LinearProbingHashST<Key, Value>(M);
		for(int i = 0; i < this.M; i++){
			if(keys[i] != null)
				set.put(keys[i], vals[i]);			
		}

		keys = (Key[]) set.keys;
		vals = (Value[]) set.vals;
		this.M = set.M;
	}

	public void delete(Key k){
		int i = hash(k);
		if(!contains(k))
			return;
		while(!keys[i].equals(k))
			i = ++i % M;
		keys[i] = null;
		vals[i] = null;
		i = ++i % M;
		while(keys[i] != null){
			Key tk = keys[i];
			Value tv = vals[i];
			keys[i] = null;
			vals[i] = null;
			put(tk, tv);
			i = ++i % M;
		}
		N--;
		if(N == M/8)
			resize(M/2);
	}

	public boolean contains(Key k){
		int i = hash(k);
		for(; keys[i] != null; i = ++i % M){
			if(keys[i].equals(k))
				return true;
		}
		return false;
	}
}