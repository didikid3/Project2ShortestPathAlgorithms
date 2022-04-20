
public class AdjacencyMatrix {
	public int size;
	public int range;
	public int[][] matrix;
	
	public AdjacencyMatrix() {
		this(4);
	}
	public AdjacencyMatrix(int size) {
		this(size, 5);
	}
	public AdjacencyMatrix(int s, int r) {
		size = s;
		range = r;
		matrix = new int[size][size];
		setFullNull();
	}
	
	//Sets entire matrix to have no edges
	public void setFullNull() {
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++) {
				matrix[i][j] = Integer.MAX_VALUE;
			}
		}
	}
	
	//Randomly creates edges between nodes
	public void generateRandom()
	{
		int path = 0;
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++) {
				//Calculate a value 1 or 2
				//Value 1 represents no edge between nodes
				path = (int)Math.floor(Math.random()*2+1);
				
				if(path == 1) {
					matrix[i][j] = Integer.MAX_VALUE;
				}
				else {
					matrix[i][j] = (int)(Math.random()*range) + 1;
				}
			}
		}
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
		AdjacencyMatrix x = new AdjacencyMatrix();
		
		x.generateRandom();
		System.out.print(x);
	}

}
