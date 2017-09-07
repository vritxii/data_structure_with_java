package graph;

import tree.IndexMinPQ;
import java.util.ArrayList;
/**
 * Created by vrit on 16-12-21.
 */
/**
 *                             _ooOoo_
 *                            o8888888o
 *                            88" . "88
 *                            (| -_- |)
 *                            O\  =  /O
 *                         ____/`---'\____
 *                       .'  \\|     |//  `.
 *                      /  \\|||  :  |||//  \
 *                     /  _||||| -:- |||||-  \
 *                     |   | \\\  -  /// |   |
 *                     | \_|  ''\---/''  |   |
 *                     \  .-\__  `-`  ___/-. /
 *                   ___`. .'  /--.--\  `. . __
 *                ."" '<  `.___\_<|>_/___.'  >'"".
 *               | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *               \  \ `-.   \_ __\ /__ _/   .-` /  /
 *          ======`-.____`-.___\_____/___.-`____.-'======
 *                             `=---='
 *          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *                     佛祖保佑        永无BUG
*/
public class Dijkstra {
	double[] distTo;
	Edge[] edgeTo;
	IndexMinPQ<Double> pq;
	public Dijkstra(graph G, int s) {
		// TODO Auto-generated constructor stub
		double IMAX = Double.POSITIVE_INFINITY;
		distTo = new double[G.V()];
		edgeTo = new Edge[G.V()];
		for(int i=0; i<distTo.length; i++){
			distTo[i] = IMAX;
		}
		distTo[s] = 0;
		pq = new IndexMinPQ<Double>(G.V());
		pq.insert(s, 0.0);
		//System.out.println(pq.isEmpty());
		while (!pq.isEmpty()) {
			relex(G, pq.delMin());
		}
	}
	
	public String pathTo(int v) {
		Edge e = edgeTo[v];
		String path = "";
		double tolWeight = 0;
		while (e != null) {
			path = ("--->" + e.to()) + path;
			tolWeight += e.weight();
			e = edgeTo[e.from()];
		}
		path = "0" + path;
		System.out.println("TolWeight: " + tolWeight);
		return path;
	}
	
	public void relex(graph G, int v){
		for(Edge e: G.adj(v)){
			int w = e.to();
			if(distTo[w] > distTo[v] + e.weight()){
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				//System.out.println(e);
				if(pq.contains(w))
					pq.changeKey(w, distTo[w]);
				else 
					pq.insert(w, distTo[w]);
			}
		}
	}
	
	
	public static void main(String[] args) {
		graph G = new graph(8);
		double[][] mat = {
				{4, 5, 0.35},
				{5, 4, 0.35},
				{4, 7, 0.37},
				{5, 7, 0.28},
				{7, 5, 0.28},
				{5, 1, 0.32},
				{0, 4, 0.38},
				{0, 2, 0.26},
				{7, 3, 0.39},
				{1, 3, 0.29},
				{2, 7, 0.34},
				{6, 2, 0.40},
				{3, 6, 0.52},
				{6, 0, 0.58},
				{6, 4, 0.93}
		};
		for(int i=0; i<mat.length; i++){
			G.addEdge(new Edge((int)mat[i][0], (int)mat[i][1], mat[i][2]));
		}
		Dijkstra dijkstra = new Dijkstra(G, 0);
		System.out.println("From 0 To 1: ");
		System.out.println(dijkstra.pathTo(1));
	}
}

class graph{
	graphNode[] adjT;
    private int V;
    private int E;
    
    public graph(int V) {
		this.adjT = new graphNode[V];
		for(int i=0; i< V; i++){
			adjT[i] = new graphNode();
		}
		this.E = 0;
		this.V = V;
	}
    
    public int V() {
		return V;
	}
    
    public int E() {
		return E;
	}

    public void addEdge(Edge e) {
		int v = e.from();
		int w = e.to();
		adjT[v].add(e);
		adjT[w].add(e);
		E++;
	}
    
    public ArrayList<Edge> adj(int v) {
		return adjT[v].adj;
	}
}

class Edge{
	private final int v;
	private final int w;
	private final double weight;
	
	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int from() {
		return v;
	}
	
	public double weight() {
		return weight;
	}
	public int to() {
		return w;
	}
	public String toString() {
		return v + "--->" + w + ": " + weight;
	}
}

class graphNode{
	ArrayList<Edge> adj;
	public graphNode() {
		adj = new ArrayList<>();
	}
	
	public void add(Edge e) {
		adj.add(e);
	}
}
