
public class Runner {

	public static void main(String[] args) {
		AdjacencyMatrix x = new AdjacencyMatrix(5);
		
		x.generateRandom();
		System.out.println(x);
		
		
		
		Dijkstra.printAllPairsDijkstra(x.getMatrix());
	}
	
	
}
