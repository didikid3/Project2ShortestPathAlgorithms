public class FlyodWarshall {

		public static int[][] shortPathAll(int[][] adjacencyList) {
			int[][] x = adjacencyList;
			
			for(int k = 0; k < adjacencyList.length; k++) {
				
				for(int u = 0; u < adjacencyList.length; u++) {
					for(int v = 0; v < adjacencyList.length; v++) {
						if(x[u][k] == Integer.MAX_VALUE || x[k][v] == Integer.MAX_VALUE){
							x[u][v] = x[u][v];
						}
						else if(x[u][v] == Integer.MAX_VALUE)
							x[u][v] = x[u][k] + x[k][v];
						else
							x[u][v] = Math.min(x[u][v], x[u][k] + x[k][v]);
					}
				}
			}
			
			return adjacencyList;
		}
		
		
		public static void main(String[] args) {
			int size = 512;
			AdjacencyMatrix x = new AdjacencyMatrix(size);
			x.generateRandom(39);
			
			int[][] a = shortPathAll(x.getMatrix());
			
			for(int i = 0; i < a.length; i++) {
				for(int j = 0; j < a.length; j++) {
					if(a[i][j] != Integer.MAX_VALUE)
						System.out.print(a[i][j] + ",\t");
					else
						System.out.print("INF" + ",\t");
				}
				System.out.println();
			}
			
		}
}
