
public class Dijkstra {

	public static void dijkstra(int[][] graph, int srcNode) {
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
				
				if(dist > 0 &&
						( (minDist + dist) < distance[vertexIndex] )
				  ) {
					parent[vertexIndex] = nearest;
					distance[vertexIndex] = minDist + dist;
 				}
			}
			
			printCost(distance,visited, parent);
		}

		
	}
	
	public static void printCost(int[] distance, boolean[] visited, int[] parent) {
		for(int i=0; i < distance.length; i++) {
			if(distance[i] != Integer.MAX_VALUE)
				System.out.print(distance[i] + "\t");
			else
				System.out.print("INF\t");
		}
		System.out.print("\n");
		for(int i=0; i < distance.length; i++) {
			System.out.print(visited[i] + "\t");
		}
		System.out.print("\n");
		for(int i=0; i < distance.length; i++) {
			System.out.print(parent[i] + "\t");
		}
		System.out.print("\n");
		System.out.println("------------------------------------------------------------");
	}
	
	
	public static void main(String[] args) {
		int[][] adjacencyMatrix = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 0, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 14, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		
		dijkstra(adjacencyMatrix, 0);
	}
}
