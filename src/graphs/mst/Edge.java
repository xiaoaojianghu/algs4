package graphs.mst;

public class Edge implements Comparable<Edge>{
	private double weight;
	private int either, other;

	public Edge(int v, int w, double weight){
		this.weight = weight;
		either = v;
		other = w;
	}

	public double weight(){
		return weight;
	}

	public int either(){
		return either;
	}

	public int other(int v){
		if(either == v)
			return other;
		if(other == v)
			return either;
		throw new RuntimeException("Inconsisten edge");
	}

	public int compareTo(Edge e){
		if(weight > e.weight())
			return 1;
		else if(weight < e.weight())
			return -1;
		else
			return 0;
	}

	public String toString(){
		return String.format("%d-%d %.2f", either, other, weight);
	}

	public boolean equals(Edge e){
		int ev = e.either();
		int ew = e.other(ev);
		boolean a = (ev == either && ew == other);
		boolean b = (ev == other && ew == either);
		if(a || b)
			return true;
		return false; 
	}

	public int hashCode(){
		int hash = (either << 16) ^ other;
		return hash;
	}
}