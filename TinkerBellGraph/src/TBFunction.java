
public class TBFunction {
	private double xStart; //.000
	private double yStart; //.000
	private double a; //.000
	private double b; //.000
	private double c; //.000
	private double d; //.000
	private int sizeX;
	private int sizeY;
	private int generations;
	private int zoom;
	private int translateX;
	private int translateY;
	
	public TBFunction(double xStart, double yStart, double a, double b, double c, double d, int sizeX, int sizeY, int generations, int zoom, int translateX, int translateY) {
		this.xStart = xStart;
		this.yStart = yStart;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.generations = generations;
		this.zoom = zoom;
		this.translateX = translateX;
		this.translateY = translateY;
	}
	
	boolean[][] toArray(){
		boolean[][] array = new boolean[sizeX][sizeY];
		array = addAxis(array);
		System.out.println("" + translateX + " " + translateY);
		return addPoint(xStart, yStart, array, generations);
	}
	
	public boolean[][] addPoint(double x, double y, boolean[][] arr, int gen) {
		double tempX = (x*zoom)+(sizeX/2) + translateX;
		double tempY = (y*zoom)+(sizeY/2) + translateY;
		
		if (gen < 0) {
			return arr;
		}
		else {
			gen--;
			if(tempX > 0 && tempX < sizeX-1 && tempY > 0 && tempY < sizeY-1) {
				arr[(int)tempX][sizeY-1-(int)tempY] = true;
			}
			double nextX = (x*x) - (y*y) + (a*x) + (b*y);
			double nextY = (2*x*y) + (c*x) + (d*y);
			return addPoint(nextX, nextY, arr, gen);
		}
	}
	
	public boolean[][] addAxis(boolean[][] arr){
		for (int i=0; i < sizeX; i++) {
			for (int j=0; j < sizeY; j++) {
				if(i == (sizeX/2) || j == (sizeY/2)) {
					arr[i][j] = true;
				}
			}
		}
		return arr;
	}

}
