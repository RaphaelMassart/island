public class MyBorder{
	

	private int hauteur, largeur;
	private int[][] tab;

	public MyBorder(int l, int h){
		tab = new int[l][h];
		this.hauteur = h; 
		this.largeur = l;
	}

	public void setUneCase (int i, int j, int value){
		this.tab[i][j] = value;
	}

	public int getUneCase(int i, int j){
		return this.tab[i][j];
	}
}
