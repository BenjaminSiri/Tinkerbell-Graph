
public class Function {
	private double m;
	private double b;
	private int sizeX;
	private int sizeY;
	
	public Function(double m, double b, int sizeX, int sizeY) {
		this.m = m;
		this.b = b;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	public boolean[][] toArray(){
		boolean[][] out = new boolean[sizeX][sizeY];
		
		for(int i = 0; i < sizeX; i++) {
			for(int j = 0; j < sizeY; j++) {
				if(j == m*i+b) {
					out[i][sizeY-1-j] = true;
				}
				else {
					out[i][sizeY-1-j] = false;
				}
			}
		}
		return out;		
	}
}
