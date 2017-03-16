

public class MyWorld{
	
	private int largeur;
	private int hauteur;
	private int[][] tab;

	public MyWorld(int largeur, int hauteur)
	{
		tab = new int[largeur][hauteur];
	}

	public int xCenter()
	{
		return (int) Math.floor(largeur/2);
	}

	public int yCenter()
	{
		return (int) Math.floor(hauteur/2);
	}

	public void setMyWorld(int x, int y, int value){
		this.tab[x][y] = value;
	}

	public int getLength(){
		return tab.length;
	}

	public int getWidth(){
		return tab[0].length;
	}

	public int getUneCase(int i, int j){
		return tab[i][j];
	}


}
