
public class Runner {

	public static void main(String[] args) {
		int size = 8;
		double timeDijkstra = 0;
		double timeFlyodWarshall = 0;
		int probability;
		int[][] matrix;
		while (true) {
			AdjacencyMatrix x = new AdjacencyMatrix(size);

			timeDijkstra = 0;
			timeFlyodWarshall = 0;
			float start = 0;
			probability = 33;
			
			for(int i = 1; i < 10; i ++) {
				
				if(i == 0) {
					x.generateConnected();
				}
				else {
					x.generateRandom(probability);
					probability += 6;
				}
				
				matrix = x.getMatrix();

				start = System.nanoTime();
				Dijkstra.printAllPairsDijkstra(matrix);
				timeDijkstra += System.nanoTime() - start;
				
				start = System.nanoTime();
				FlyodWarshall.shortPathAll(matrix);
				timeFlyodWarshall += System.nanoTime() - start;
			}
			
			
			timeDijkstra = timeDijkstra / 10;
			timeFlyodWarshall = timeFlyodWarshall / 10;
			System.out.println("Dijkstra: " + timeDijkstra);
			System.out.println("Flyod: " + timeFlyodWarshall);
			System.out.println("Matrix Size: " + size);
			
			
			size = size * 2;

		}
	}
	
	
}
