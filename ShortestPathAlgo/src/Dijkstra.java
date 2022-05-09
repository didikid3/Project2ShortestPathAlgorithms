
public class Dijkstra {

	public static int[] dijkstra(int[][] graph, int srcNode) {
		int size = graph.length;
		
		int[] distance = new int[size];
		boolean[] visited = new boolean[size];
		int[] parent = new int[size];
		
		//Initialize cost table to empty
		for(int i = 0; i < size; i++) {
			distance[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		
		distance[srcNode] = 0;
		parent[srcNode] = -1;
		
		for (int i = 0; i < size-1; i++) {
			int nearest = -1;
			int minDist = Integer.MAX_VALUE;
			
			//Min Distance
			for (int vertexIndex = 0; vertexIndex < size; vertexIndex++) {
				if(!visited[vertexIndex] &&
						distance[vertexIndex] < minDist) {
					nearest = vertexIndex;
					minDist = distance[vertexIndex];
				}
			}
			
			visited[nearest] = true;
			
			for (int vertexIndex = 0; vertexIndex < size; vertexIndex++) {
				int dist = graph[nearest][vertexIndex];
				
				if(dist !=0 && dist != Integer.MAX_VALUE && 
						( (minDist + dist) < distance[vertexIndex] )
				  ) {
					parent[vertexIndex] = nearest;
					distance[vertexIndex] = minDist + dist;
 				}
			}
			
			
		}
		
		return printCost(distance,visited, parent);
		
	}
	
	public static int[] printDist(int[] distance, boolean[] visited, int[] parent) {
		
		for(int i=0; i < distance.length; i++) {
			if(distance[i] != Integer.MAX_VALUE)
				System.out.print(distance[i] + "\t");
			else
				System.out.print("INF\t");
		}
		System.out.print("\n");
		return distance;
	}
	
	public static boolean[] printVisited(int[] distance, boolean[] visited, int[] parent) {
		for(int i=0; i < distance.length; i++) {
			System.out.print(visited[i] + "\t");
		}
		System.out.print("\n");
		return visited;
	}
	
	public static int[] printParent(int[] distance, boolean[] visited, int[] parent) {
		for(int i=0; i < distance.length; i++) {
			System.out.print(parent[i] + "\t");
		}
		System.out.print("\n");
		return parent;
	}
	
	public static int[] printCost(int[] distance, boolean[] visited, int[] parent) {
		int[] x =  distance;
		//printDist(distance, visited, parent);
		//printVisited(distance, visited, parent);
		//printParent(distance, visited, parent);
		//printDivider(distance.length);
		
		return x;
	}
	
	public static int[][] printAllPairsDijkstra(int[][] adjacencyMatrix) {
		int[][] result = new int[adjacencyMatrix.length][adjacencyMatrix.length];
		
		/*
		System.out.print("\t");
		for(int i =0; i < adjacencyMatrix.length; i++) {
			System.out.print((i+1)+"\t");
		}
		System.out.print("\n");
		printDivider(adjacencyMatrix.length);
		*/
		
		for(int i = 0; i < adjacencyMatrix.length; i++) {
			//System.out.print("ROW " + (i+1) + "|\t");
			result[i] = dijkstra(adjacencyMatrix, i);

		}
		
		return result;
	}
	
	public static void printDivider(int size) {
		for(int i = 0; i < size; i++) {
			System.out.print("---------");
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		int[][] adjacencyMatrix =
			{
			    { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 0, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 14, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
            };

		
		AdjacencyMatrix v = new AdjacencyMatrix(512);
		v.generateRandom(38);
		int[][] x = printAllPairsDijkstra(v.getMatrix());
		
		
		for(int i = 0; i < x.length; i++) {
			for(int j = 0; j < x.length; j++) {
				System.out.print(x[i][j] + ",\t");
			}
			System.out.println();
		}
		
	}
}
