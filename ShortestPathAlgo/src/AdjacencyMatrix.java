import java.lang.Math;

public class AdjacencyMatrix {
	public int size;
	public int range;
	public int[][] matrix;
	
	public AdjacencyMatrix() {
		this(4);
	}
	public AdjacencyMatrix(int size) {
		this(size, 10);
	}
	public AdjacencyMatrix(int s, int r) {
		size = s;
		range = r;
		matrix = new int[size][size];
		setFullNull();
		setDiag();
	}
	
	//Sets entire matrix to have no edges
	public void setFullNull() {
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++) {
				matrix[i][j] = Integer.MAX_VALUE;
			}
		}
	}
	
	public void setDiag() {
		for(int i = 0; i < size; i++) {
			for(int j = i; j <= i; j++) {
				matrix[i][j] = 0;
			}
		}
	}
	public void generateConnected() {
		//int probability = sparseness;
		int totalEdges = 0;
		int encouragedMax = (int)Math.log(size)/(int)Math.log(3) + size + size/3;
		
		//Connect Triangles
		while(totalEdges < size) {
			
			if(totalEdges % 3 == 0) {
				if(totalEdges + 2  > size)
					matrix[totalEdges][0] = (int)(Math.random()*range) + 1;
				else
					matrix[totalEdges][totalEdges + 1] = (int)(Math.random()*range) + 1;
			}
			else if(totalEdges % 3 == 1) {
				if (totalEdges + 1 < size) {
					matrix[totalEdges][totalEdges + 1] = (int)(Math.random()*range) + 1;
				}
				else {
					matrix[totalEdges][totalEdges - 1] = (int)(Math.random()*range) + 1;
				}
			}
			else {
				matrix[totalEdges][totalEdges - 2] = (int)(Math.random()*range) + 1;
			}
			totalEdges ++;
		}
		//Circular Triangles
		int edgeCircleTotal = size/3;
		if(size%3 != 0)
			edgeCircleTotal ++;
		int count = 0;
		while(count < edgeCircleTotal) {
			if(count*3+3 < size) {
				matrix[count*3][count*3+3] = (int)(Math.random()*range)+1;
			}
			else {
				matrix[count*3][0] = (int)(Math.random()*range)+1;
			}
		
			count++;
		}
	}
	
	
	//Randomly creates edges between nodes
	//2:1 Bias for choosing to create an edge
	public void generateRandom(int probability)
	{
		int path = 0;
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++) {
				//Value 3 represents no edge between nodes
				path = (int)Math.floor(Math.random()*100+1);
				
				if(path == probability) {
					matrix[i][j] = Integer.MAX_VALUE;
				}
				else {
					matrix[i][j] = (int)(Math.random()*range) + 1;
				}
			}
		}
		setDiag();
	}
	
	//Set a specific edge description for 2 nodes
	public void setNode(int value, int i, int j) {
		matrix[i][j] = value;
	}
	
	//Add an additional node with initialization of no edge to the node
	public void addNode() {
		int[][] tempMatrix = new int[size+1][size+1];
		
		//Copy old data into new matrix of increased size
		for (int i = 0; i < size; i ++) {
			for (int j = 0; j < size; j++) {
				tempMatrix[i][j] = matrix[i][j];
			}
		}
		
		//Initialize edges for new node
		for(int i = 0; i < size+1; i++) {
			tempMatrix[size][i] = Integer.MAX_VALUE;
			tempMatrix[i][size] = Integer.MAX_VALUE;
		}
		
		matrix = tempMatrix;
		size += 1;
		setDiag();
	}
	
	public int[][] getMatrix(){
		return matrix;
	}
	
	public int getValue(int i, int j) {
		return matrix[i][j];
	}
	
	//Prints out the adjacency matrix
	public String toString() {
		String temp = "";
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(matrix[i][j] != Integer.MAX_VALUE)
					temp += matrix[i][j] + "\t";
				else
					temp += "INF" + "\t";
			}
			temp += "\n";
		}
		
		return temp;
	}
	
	
	public static void main(String[] args){
		AdjacencyMatrix x = new AdjacencyMatrix(13);	
		//x.generateRandom();
		x.generateConnected();
		System.out.print(x);
	}

}
