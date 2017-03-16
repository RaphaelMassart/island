
public class Rectangle{
	
	private int x_centre, y_centre;
	private int largeur, hauteur;

	public Rectangle(int x_centre, int y_centre, int largeur, int hauteur)
	{
		this.x_centre = x_centre;
		this.y_centre = y_centre;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}



	public String toString()
	{
		String s = "Rectangle de centre (" + x_centre + ", " + y_centre + "), de largeur " + largeur + " et de hauteur " + hauteur;
		return s;
	}


	public int getLargeur()
	{
	   return largeur;
	}


	public int getHauteur()
	{
		return hauteur;
	}

	public int getX()
	{
		return x_centre;
	}


	public int getY()
	{
		return y_centre;
	}



	/* - - - - - - pour obtenir coordonnées points coins - - - - - - */
	public int getXCoinSupG()
	{
		return x_centre - largeur/2;
	}

	public int getYCoinSupG()
	{
		return y_centre - hauteur/2;
	}

	public int getXCoinSupD()
	{
		return x_centre + largeur/2;
	}

	public int getYCoinSupD()
	{
		return y_centre - hauteur/2;
	}

	public int getXCoinInfG()
	{
		return x_centre - largeur/2;
	}

	public int getYCoinInfG()
	{
		return y_centre + hauteur/2;
	}

	public int getXCoinInfD()
	{
		return x_centre + largeur/2;
	}

	public int getYCoinInfD()
	{
		return y_centre + hauteur/2;
	}
	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */


	/* - - - - - pour obtenir une dimension d'un rectangle de coin, en fonction taille rect principal - - - - - */
	public int dimension(int largeur_rect, int hauteur_rect)
	{
		int dim = (int) Math.round((Math.random()*7/15 + 1/5) * Math.max(largeur_rect, hauteur_rect));
		return dim+2;
	}
	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */





	public Rectangle CreerSupGauche(int largeur_rect, int hauteur_rect)
	{
			Rectangle rectSupG = new Rectangle(	this.getXCoinSupG(),
												this.getYCoinSupG(),
												this.dimension(largeur_rect, hauteur_rect),
												this.dimension(largeur_rect, hauteur_rect)
												);
		return rectSupG;
	}

	public Rectangle CreerSupDroit(int largeur_rect, int hauteur_rect)
	{
		Rectangle rectSupD = new Rectangle(		this.getXCoinSupD(),
												this.getYCoinSupD(),
												this.dimension(largeur_rect, hauteur_rect),
												this.dimension(largeur_rect, hauteur_rect)
												);
		return rectSupD;
	}

	public Rectangle CreerInfGauche(int largeur_rect, int hauteur_rect)
	{
		Rectangle rectInfG = new Rectangle(		this.getXCoinInfG(),
												this.getYCoinInfG(),
												this.dimension(largeur_rect, hauteur_rect),
												this.dimension(largeur_rect, hauteur_rect)
												);
		return rectInfG;
	}

	public Rectangle CreerInfDroit(int largeur_rect, int hauteur_rect)
	{
		Rectangle rectInfD = new Rectangle(		this.getXCoinInfD(),
												this.getYCoinInfD(),
												this.dimension(largeur_rect, hauteur_rect),
												this.dimension(largeur_rect, hauteur_rect)
												);
		return rectInfD;
	}
}