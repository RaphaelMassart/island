import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Island extends JPanel {
	
	
	private JFrame frame;
	
	private Image sol_0000;
	private Image sol_0001;
	private Image sol_0010;
	private Image sol_0011;
	private Image sol_0100;
	private Image sol_0101;
	private Image sol_0110;                                                
	private Image sol_0111;
	private Image sol_0121;
	private Image sol_0222;
	private Image sol_1000;
	private Image sol_1001;
	private Image sol_1010;
	private Image sol_1011;
	private Image sol_1012;
	private Image sol_1100;
	private Image sol_1101;
	private Image sol_1110;
	private Image sol_1111;
	private Image sol_1112;
	private Image sol_1121;
	private Image sol_1122;
	private Image sol_1210;
	private Image sol_1211;
	private Image sol_1212;
	private Image sol_1221;
	private Image sol_1222;
	private Image sol_2022;
	private Image sol_2101;
	private Image sol_2111;
	private Image sol_2112;
	private Image sol_2121;
	private Image sol_2122;
	private Image sol_2202;
	private Image sol_2211;
	private Image sol_2212;
	private Image sol_2220;
	private Image sol_2221;
	private Image sol_2222;

	private int spriteLength = 9;

	private int largeur      = 70;
	private int hauteur      = 70;
	private int leftborder, rightborder, topborder, bottomborder;
	private int greenleftborder, greenrightborder, greentopborder, greenbottomborder;

	private Rectangle mainRect, greenRect;
	private Rectangle rectSupG, rectSupD, rectInfG, rectInfD;

	//private int[][] myWorld;
	private int[][] myBorder;

	private int I, J;
	private int code_brique;
	private MyWorld monde;
	
	public Island()
	{
		try
		{
			sol_0000 = ImageIO.read(new File("sol-0000.png"));
			sol_0001 = ImageIO.read(new File("sol-0001.png"));
			sol_0010 = ImageIO.read(new File("sol-0010.png"));
			sol_0011 = ImageIO.read(new File("sol-0011.png"));
			sol_0100 = ImageIO.read(new File("sol-0100.png"));
			sol_0101 = ImageIO.read(new File("sol-0101.png"));
			sol_0110 = ImageIO.read(new File("sol-0110.png"));
			sol_0111 = ImageIO.read(new File("sol-0111.png"));
			sol_0121 = ImageIO.read(new File("sol-0121.png"));
			sol_0222 = ImageIO.read(new File("sol-0222.png"));
			sol_1000 = ImageIO.read(new File("sol-1000.png"));
			sol_1001 = ImageIO.read(new File("sol-1001.png"));
			sol_1010 = ImageIO.read(new File("sol-1010.png"));
			sol_1011 = ImageIO.read(new File("sol-1011.png"));
			sol_1012 = ImageIO.read(new File("sol-1012.png"));
			sol_1100 = ImageIO.read(new File("sol-1100.png"));
			sol_1101 = ImageIO.read(new File("sol-1101.png"));
			sol_1110 = ImageIO.read(new File("sol-1110.png"));
			sol_1111 = ImageIO.read(new File("sol-1111.png"));
			sol_1112 = ImageIO.read(new File("sol-1112.png"));
			sol_1121 = ImageIO.read(new File("sol-1121.png"));
			sol_1122 = ImageIO.read(new File("sol-1122.png"));
			sol_1210 = ImageIO.read(new File("sol-1210.png"));
			sol_1211 = ImageIO.read(new File("sol-1211.png"));
			sol_1212 = ImageIO.read(new File("sol-1212.png"));
			sol_1221 = ImageIO.read(new File("sol-1221.png"));
			sol_1222 = ImageIO.read(new File("sol-1222.png"));
			sol_2022 = ImageIO.read(new File("sol-2022.png"));
			sol_2101 = ImageIO.read(new File("sol-2101.png"));
			sol_2111 = ImageIO.read(new File("sol-2111.png"));
			sol_2112 = ImageIO.read(new File("sol-2112.png"));
			sol_2121 = ImageIO.read(new File("sol-2121.png"));
			sol_2122 = ImageIO.read(new File("sol-2122.png"));
			sol_2202 = ImageIO.read(new File("sol-2202.png"));
			sol_2211 = ImageIO.read(new File("sol-2211.png"));
			sol_2212 = ImageIO.read(new File("sol-2212.png"));
			sol_2220 = ImageIO.read(new File("sol-2220.png"));
			sol_2221 = ImageIO.read(new File("sol-2221.png"));
			sol_2222 = ImageIO.read(new File("sol-2222.png"));

		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
		
		frame = new JFrame("Super island !!!");
		frame.add(this);
		frame.setSize(700,700);
		frame.setVisible(true);
		

		monde  = new MyWorld(largeur, hauteur); //briques
		myBorder = new int[largeur+1][hauteur+1]; //intersections
		

		/* on initialise toutes les cases de myBorder à 0 */
		for (int i=0; i==hauteur; i++)
			for (int j=0 ; j==largeur ; j++)
				myBorder[i][j] = 0;



		/* - - - - - - - - - Constitution des rectangles jaunes de base - - - - - - - - - - */
		//rectangle principal
		mainRect = new Rectangle(	(int) Math.floor(largeur/2),
									(int) Math.floor(hauteur/2),
									(int) Math.round((Math.random()*1/2 + 1/6)*largeur),
									(int) Math.round((Math.random()*1/2 + 1/4)*hauteur));
		leftborder = mainRect.getXCoinInfG();
		rightborder = mainRect.getXCoinSupD();
		topborder = mainRect.getYCoinSupD();
		bottomborder = mainRect.getYCoinInfG();
		System.out.println("lageur rect jaune principal = " + mainRect.getLargeur());
		System.out.println("hauteur rect jaune principal = " + mainRect.getHauteur());


		//rectangle coins
		rectSupG = mainRect.CreerSupGauche(mainRect.getLargeur(), mainRect.getHauteur());
		rectSupD = mainRect.CreerSupDroit(mainRect.getLargeur(), mainRect.getHauteur());
		rectInfG = mainRect.CreerInfGauche(mainRect.getLargeur(), mainRect.getHauteur());
		rectInfD = mainRect.CreerInfDroit(mainRect.getLargeur(), mainRect.getHauteur());
		/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */



		/* Croix jaunes distribuées dans les rectangles jaunes */
		for (int x=1 ; x != largeur ; x++){
			for(int y=1 ; y != hauteur ; y++)
			{
				//si on est dans le rectangle principal
				if ((x>leftborder)&&(x<rightborder)&&(y<bottomborder)&&(y>topborder))
						myBorder[x][y] = 1;
	
				
				//si on est dans rect SupGauche
				else if ((x>rectSupG.getXCoinInfG())&&(x<rectSupG.getXCoinSupD())&&(y<rectSupG.getYCoinInfG())&&(y>rectSupD.getYCoinSupG()))
						myBorder[x][y] = 1;

				//si on est dans rect SupDroit
				else if ((x>rectSupD.getXCoinInfG())&&(x<rectSupD.getXCoinSupD())&&(y<rectSupD.getYCoinInfG())&&(y>rectSupD.getYCoinSupG()))
						myBorder[x][y] = 1;

				//si on est dans rect InfGauche
				else if ((x>rectInfG.getXCoinInfG())&&(x<rectInfG.getXCoinSupD())&&(y<rectInfG.getYCoinInfG())&&(y>rectInfG.getYCoinSupG()))
						myBorder[x][y] = 1;

				//si on est dans rect InfDroit
				else if ((x>rectInfD.getXCoinInfG())&&(x<rectInfD.getXCoinSupD())&&(y<rectInfD.getYCoinInfG())&&(y>rectInfD.getYCoinSupG()))
						myBorder[x][y] = 1;
			}
		}


		/* Croix jaunes distribuées si voisins jaunes, avec une certaine probabilité */
		for (int x=2 ; x != largeur-1 ; x++)
		{
			for(int y=2 ; y != hauteur-1 ; y++)
			{

				if(	myBorder[x][y-1]==1 ||
					myBorder[x-1][y]==1 ||
					myBorder[x][y+1]==1 ||
					myBorder[x+1][y]==1)
				{
					if(Math.random()>0.6)
						myBorder[x][y] = 1;
				}
			}
		}




		/* - - - - - - - - - Constitution du rectangle vert de base - - - - - - - - - - */
		//rectangle principal
		greenRect = new Rectangle(	(int) Math.floor(largeur/2),
									(int) Math.floor(hauteur/2),
									mainRect.getLargeur()-6,
									mainRect.getHauteur()-8);
		greenleftborder = greenRect.getXCoinInfG();
		greenrightborder = greenRect.getXCoinSupD();
		greentopborder = greenRect.getYCoinSupD();
		greenbottomborder = greenRect.getYCoinInfG();
		System.out.println("lageur rect jaune principal = " + greenRect.getLargeur());
		System.out.println("hauteur rect jaune principal = " + greenRect.getHauteur());
		/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */



		/* Croix vertes distribuées dans le rectangle vert */
		for (int x=1 ; x != largeur ; x++)
			for(int y=1 ; y != hauteur ; y++)
				if ((x>greenleftborder)&&(x<greenrightborder)&&(y<greenbottomborder)&&(y>greentopborder))
						myBorder[x][y] = 2;



		/* Croix vertes distribuées avec probabilité */
		for (int x=2 ; x != largeur-1 ; x++)
		{
			for(int y=2 ; y != hauteur-1 ; y++)
			{	

				//s'il n'y a AUCUN voisin bleu
				if(	myBorder[x][y-1]!=0 &&
					myBorder[x-1][y]!=0 &&
					myBorder[x][y+1]!=0 &&
					myBorder[x+1][y]!=0)
				{

					//s'il y a au moins un voisin vert
					if(	myBorder[x][y-1]==2 ||
						myBorder[x-1][y]==2 ||
						myBorder[x][y+1]==2 ||
						myBorder[x+1][y]==2)
					{
						if(Math.random()>0.4)
							myBorder[x][y] = 2;
					}
					//si tous les voisins NSEW sont jaunes
					if(	myBorder[x][y-1]==1 &&
						myBorder[x-1][y]==1 &&
						myBorder[x][y+1]==1 &&
						myBorder[x+1][y]==1)
					{
						if(Math.random()>0.4)
							myBorder[x][y] = 2;
					}
				}
			}
		}

		myBorder[largeur/2][hauteur/2] = 0;


		/* Constitution des briques */ 
		for (int i=0 ; i != largeur ; i++)
			for (int j=0 ; j != hauteur ; j++)
			{
				I = 2*i + 1;
				J = 2*j + 1;
		

				code_brique =  3*3*3*myBorder[(int)((I - 1)/2)][(int)((J + 1)/2)];
				code_brique +=   3*3*myBorder[(int)((I - 1)/2)][(int)((J - 1)/2)];
				code_brique +=     3*myBorder[(int)((I + 1)/2)][(int)((J - 1)/2)];
				code_brique +=       myBorder[(int)((I + 1)/2)][(int)((J + 1)/2)];
				
				monde.setMyWorld(i, j, code_brique);
			}
	}
	







	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		for (int i=0 ; i < monde.getLength() ; i++)
			for (int j=0 ; j < monde.getWidth() ; j++)
			{
				switch(monde.getUneCase(i, j))
				{
					case 0 : 
						g2.drawImage(sol_0000,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 1 :
						g2.drawImage(sol_0001,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 3 :
						g2.drawImage(sol_0010,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 4 :
						g2.drawImage(sol_0011,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 9 :
						g2.drawImage(sol_0100,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 10 :
						g2.drawImage(sol_0101,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 12 :
						g2.drawImage(sol_0110,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 13 :
						g2.drawImage(sol_0111,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 16 :
						g2.drawImage(sol_0121,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 26 :
						g2.drawImage(sol_0222,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 27 :
						g2.drawImage(sol_1000,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 28 :
						g2.drawImage(sol_1001,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 30 :
						g2.drawImage(sol_1010,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 31 :
						g2.drawImage(sol_1011,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 32 :
						g2.drawImage(sol_1012,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 36 :
						g2.drawImage(sol_1100,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 37 :
						g2.drawImage(sol_1101,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 39 :
						g2.drawImage(sol_1110,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 40 :
						g2.drawImage(sol_1111,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 41 :
						g2.drawImage(sol_1112,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 43 :
						g2.drawImage(sol_1121,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 44 :
						g2.drawImage(sol_1122,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 48 :
						g2.drawImage(sol_1210,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 49 :
						g2.drawImage(sol_1211,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 50:
						g2.drawImage(sol_1212,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 52 :
						g2.drawImage(sol_1221,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 53 :
						g2.drawImage(sol_1222,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 62 :
						g2.drawImage(sol_2022,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 64 :
						g2.drawImage(sol_2101,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 67 :
						g2.drawImage(sol_2111,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 68 :
						g2.drawImage(sol_2112,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 70 :
						g2.drawImage(sol_2121,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 71 :
						g2.drawImage(sol_2122,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 74 :
						g2.drawImage(sol_2202,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 76 :
						g2.drawImage(sol_2211,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 77 :
						g2.drawImage(sol_2212,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 78 :
						g2.drawImage(sol_2220,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 79 :
						g2.drawImage(sol_2221,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					case 80 :
						g2.drawImage(sol_2222,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						break;
					default: ;
				}
			}
	//	ImageIO.write(g2, "png", new File("Island.png"));
	}
	
	public static void main(String[] args) {
	new Island();
	}
}
