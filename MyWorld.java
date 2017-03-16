
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
}