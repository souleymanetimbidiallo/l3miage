package fr.istic.prg1.tree;

import java.util.Scanner;

import fr.istic.prg1.tree.AbstractImage;
import fr.istic.prg1.tree_util.Iterator;
import fr.istic.prg1.tree_util.Node;
import fr.istic.prg1.tree_util.NodeType;

/**
 * @author Ewen Laudet<ewen.laudet@etudiant.univ-rennes1.fr> 
 * 		   Souleymane Diallo <souleymane.diallo.1@etudiant.univ-rennes1.fr>
 * 
 * @version 5.0
 * @since 2016-04-20
 * 
 *        Classe decrivant les images en noir et blanc de 256 sur 256 pixels
 *        sous forme d'arbres binaires.
 * 
 */

public class Image extends AbstractImage {
	private static final Scanner standardInput = new Scanner(System.in);

	public Image() {
		super();
	}

	public static void closeAll() {
		standardInput.close();
	}

	/**
	 * @param x abscisse du point
	 * @param y ordonnée du point
	 * @pre !this.isEmpty()
	 * @return true, si le point (x, y) est allumé dans this, false sinon
	 */
	@Override
	public boolean isPixelOn(int x, int y) {
		Iterator<Node> it = this.iterator(); // l'iterateur pointe au debut sur tout l'image
		int xi = 0, xf = 255, yi = 0, yf = 255, mid = 0;
		int level=0;
		boolean h = true; // pour verifier si c'est horizontal ou vertical
		while (it.getValue().state == 2) {
			if (level%2==0) { // Horizontal
				mid = (yi + yf) / 2;
				if (y <= mid) {
					it.goLeft(); // Partir vers le haut
					yf = mid;
				} else {
					it.goRight(); // Partir vers le bas
					yi = mid;
				}
				;
			} else { // Vertical
				mid = (xi + xf) / 2;
				if (x < mid) {
					it.goLeft(); // Partir vers la gauche
					xf = mid;
				} else {
					it.goRight(); // Partir vers la droite
					xi = mid;
				}
			}
			level++; // pour passer d'horizontal � vertical, de vertical � horizontal,...
		}
		return it.getValue().state == 1;
	}

	/**
	 * this devient identique à image2.
	 *
	 * @param image2 image à copier
	 *
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void affect(AbstractImage image2) {
		if (this != image2) {
			Iterator<Node> it1 = this.iterator();
			Iterator<Node> it2 = image2.iterator();
			it1.clear();
			affectAux(it1, it2);
		}
	}

	private void affectAux(Iterator<Node> it1, Iterator<Node> it2) {
		it1.addValue(it2.getValue()); // fait la copie du noeud courant
		if (it2.nodeType() == NodeType.DOUBLE) {
			// Parcours les fils gauches des 2 noeuds et fait la copie
			it2.goLeft();
			it1.goLeft();
			affectAux(it1, it2);
			it2.goUp();
			it1.goUp();
			// Parcours les fils droits des 2 noeuds et fait la copie.
			it2.goRight();
			it1.goRight();
			affectAux(it1, it2);
			it2.goUp();
			it1.goUp();
		}
	}

	/**
	 * this devient rotation de image2 à 180 degrés.
	 *
	 * @param image2 image pour rotation
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void rotate180(AbstractImage image2) {
		Iterator<Node> it1 = this.iterator();
		Iterator<Node> it2 = image2.iterator();
		it1.clear();
		rotate180Aux(it1, it2);
	}

	private void rotate180Aux(Iterator<Node> it1, Iterator<Node> it2) {
		it1.addValue(it2.getValue());
		if (it2.getValue().state == 2) {
			it1.goLeft();
			it2.goRight();
			rotate180Aux(it1, it2);
			it1.goUp();
			it2.goUp();
			
			it1.goRight();
			it2.goLeft();
			rotate180Aux(it1, it2);
			it1.goUp();
			it2.goUp();
		}

	}

	/**
	 * this devient rotation de image2 à 90 degrés dans le sens des aiguilles
	 * d'une montre.
	 *
	 * @param image2 image pour rotation
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void rotate90(AbstractImage image2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction non demeand�e");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	/**
	 * this devient inverse vidéo de this, pixel par pixel.
	 *
	 * @pre !image.isEmpty()
	 */
	@Override
	public void videoInverse() {
		Iterator<Node> it = this.iterator();
		videoInverseAux(it);
	}

	private void videoInverseAux(Iterator<Node> it) {
		if (it.nodeType() == NodeType.LEAF) {
			if (it.getValue().state == 0) {
				it.setValue(Node.valueOf(1));
			} else {
				it.setValue(Node.valueOf(0));
			}
		} else {
			it.goLeft();
			videoInverseAux(it);
			it.goUp();
			it.goRight();
			videoInverseAux(it);
			it.goUp();
		}
	}

	/**
	 * this devient image miroir verticale de image2.
	 *
	 * @param imabge2 image à agrandir
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void mirrorV(AbstractImage image2) {
		if (this != image2) {
			Iterator<Node> it1 = this.iterator();
			Iterator<Node> it2 = image2.iterator();
			it1.clear();
			mirrorVAux(it1, it2, true);
		}
	}

	private void mirrorVAux(Iterator<Node> it1, Iterator<Node> it2, boolean b) {
		it1.addValue(it2.getValue());
		if(it2.getValue().state == 2) {
			it2.goLeft();
			if(b) { //Si c'est horizontal
				it1.goRight();
			}else { //Sinon vertical
				it1.goLeft();
			}
			mirrorVAux(it1, it2, !b);
			it1.goUp();
			it2.goUp();
			
			it2.goRight();
			if(b) {
				it1.goLeft();
			}else {
				it1.goRight();
			}
			mirrorVAux(it1, it2, !b);
			it1.goUp();
			it2.goUp();
		}
	}

	/**
	 * this devient image miroir horizontale de image2.
	 *
	 * @param image2 image à agrandir
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void mirrorH(AbstractImage image2) {
		if (this != image2) {
			Iterator<Node> it1 = this.iterator();
			Iterator<Node> it2 = image2.iterator();
			it1.clear();
			mirrorHAux(it1, it2, true);
		}
	}

	private void mirrorHAux(Iterator<Node> it1, Iterator<Node> it2, boolean b) {
		it1.addValue(it2.getValue());
		if(it2.getValue().state == 2) {
			it2.goRight();
			if(b) { //Si c'est horizontal
				it1.goRight();
			}else {	//Sinon vertical
				it1.goLeft();
			}
			mirrorHAux(it1, it2, !b);
			it1.goUp();
			it2.goUp();
			
			it2.goLeft();
			if(b) {
				it1.goLeft();
			}else {
				it1.goRight();
			}
			mirrorHAux(it1, it2, !b);
			it1.goUp();
			it2.goUp();
		}
		
	}

	/**
	 * this devient quart supérieur gauche de image2.
	 *
	 * @param image2 image à agrandir
	 * 
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void zoomIn(AbstractImage image2) {
		Iterator<Node> it1 = this.iterator();
		Iterator<Node> it2 = image2.iterator();
		it1.clear();
		if (it2.getValue().state == 2) {
			it2.goLeft();
			if (it2.getValue().state == 2) {
				it2.goLeft();
				affectAux(it1, it2);
			} else {
				affectAux(it1, it2);
			}
		} else {
			affectAux(it1, it2);
		}
	}

	/**
	 * Le quart supérieur gauche de this devient image2, le reste de this devient
	 * éteint.
	 * 
	 * @param image2 image à réduire
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void zoomOut(AbstractImage image2) {
		Iterator<Node> it1 = this.iterator();
		Iterator<Node> it2 = image2.iterator();
		int in = 0; 				//utilis� pour le parcours en profondeur
		int height = image2.height()-2; //La hauteur de l'arbre (image2) sans compter les deux premiers niveaux
		it1.clear(); 
		for(int i=0; i<2; i++) {
			it1.addValue(Node.valueOf(2));
			it1.goRight();
			it1.addValue(Node.valueOf(0));
			it1.goUp();
			it1.goLeft();
		}
		
		zoomOutAux(it1, it2, height);

		if (it1.getValue().state == 0) {
			it1.goRoot();
			it1.clear();
			it1.addValue(Node.valueOf(0));
		}
	}

	
	private void zoomOutAux(Iterator<Node> it1, Iterator<Node> it2, int height) {
		if (height == 0){
			if(it2.nodeType() == NodeType.DOUBLE) {
				it2.goLeft();
				int childLeft = it2.getValue().state;
				it2.goUp();
				
				it2.goRight();
				int childRight = it2.getValue().state;
				it2.goUp();
	
				if (childLeft == childRight && childLeft!=0) {
					it1.addValue(Node.valueOf(1));
				}else if(childLeft==1 || childRight==1) {
					it1.addValue(Node.valueOf(1));
				}else {
					it1.addValue(Node.valueOf(0));
				}
			}else {
				it1.addValue(it2.getValue());
			}
		} else {
			it1.addValue(it2.getValue());
			if(it2.nodeType() == NodeType.DOUBLE) {
				height--;
				it1.goLeft();
				it2.goLeft();
				zoomOutAux(it1, it2, height);
				int childLeft = it1.getValue().state;
				it1.goUp();
				it2.goUp();
				
				it1.goRight();
				it2.goRight();
				zoomOutAux(it1, it2, height);
				int childRight = it1.getValue().state;
				it1.goUp();
				it2.goUp();
				
				if (childLeft == childRight && childLeft!=2) {
					it1.clear();
					it1.addValue(Node.valueOf(childLeft));
				}
			}
		}		
	}

	/*
	 * 
	 */
	

	/**
	 * this devient l'intersection de image1 et image2 au sens des pixels allumés.
	 * 
	 * @pre !image1.isEmpty() && !image2.isEmpty()
	 * 
	 * @param image1 premiere image
	 * @param image2 seconde image
	 */
	@Override
	public void intersection(AbstractImage image1, AbstractImage image2) {
		Iterator<Node> it1 = this.iterator();
		Iterator<Node> it2 = image1.iterator();
		Iterator<Node> it3 = image2.iterator();
		it1.clear();
		intersectionAux(it1, it2, it3);
	}

	private void intersectionAux(Iterator<Node> it1, Iterator<Node> it2, Iterator<Node> it3) {
		if (it2.getValue().state == 0 || it3.getValue().state == 0) {
			it1.addValue(Node.valueOf(0));
		} else if (it3.getValue().state == 1) {
			affectAux(it1, it2);
		} else if (it2.getValue().state == 1) {
			affectAux(it1, it3);
		} else {
			it1.addValue(Node.valueOf(2));

			it1.goLeft();
			it2.goLeft();
			it3.goLeft();
			intersectionAux(it1, it2, it3);
			int childLeft = it1.getValue().state;
			it1.goUp();
			it2.goUp();
			it3.goUp();

			it1.goRight();
			it2.goRight();
			it3.goRight();
			intersectionAux(it1, it2, it3);
			int childRight = it1.getValue().state;
			it1.goUp();
			it2.goUp();
			it3.goUp();

			if (childLeft == 0 && childRight == 0) {
				it1.clear();
				it1.addValue(Node.valueOf(0));
			}
		}
	}
	/**
	 * this devient l'union de image1 et image2 au sens des pixels allumés.
	 * 
	 * @pre !image1.isEmpty() && !image2.isEmpty()
	 * 
	 * @param image1 premiere image
	 * @param image2 seconde image
	 */
	@Override
	public void union(AbstractImage image1, AbstractImage image2) {
		Iterator<Node> it1 = this.iterator();
		Iterator<Node> it2 = image1.iterator();
		Iterator<Node> it3 = image2.iterator();

		it1.clear();
		unionAux(it1, it2, it3);
	}

	private void unionAux(Iterator<Node> it1, Iterator<Node> it2, Iterator<Node> it3) {
		if (it2.getValue().state == 1 || it3.getValue().state == 1) {
			it1.addValue(Node.valueOf(1));
		} else if (it2.getValue().state == 0 && it3.getValue().state == 0) {
			it1.addValue(Node.valueOf(0));
		} else if (it2.getValue().state == 0) {
			affectAux(it1, it3);
		} else if (it3.getValue().state == 0) {
			affectAux(it1, it2);
		} else {
			it1.addValue(Node.valueOf(2));

			int childLeft = 2, childRight = 2;
			it1.goLeft();
			it2.goLeft();
			it3.goLeft();
			unionAux(it1, it2, it3);
			childLeft = it1.getValue().state;
			it1.goUp();
			it2.goUp();
			it3.goUp();

			it1.goRight();
			it2.goRight();
			it3.goRight();
			unionAux(it1, it2, it3);
			childRight = it1.getValue().state;
			it1.goUp();
			it2.goUp();
			it3.goUp();

			if (childLeft == 1 && childRight == 1) {
				it1.clear();
				it1.addValue(Node.valueOf(childLeft));
			}
		}

	}

	/**
	 * Attention : cette fonction ne doit pas utiliser la commande isPixelOn
	 * 
	 * @return true si tous les points de la forme (x, x) (avec 0 <= x <= 255)
	 *         sont allumés dans this, false sinon
	 */
	@Override
	public boolean testDiagonal() {
		Iterator<Node> it = this.iterator();
		return testDiagonalAux(it);
	}

	private boolean testDiagonalAux(Iterator<Node> it) {
		boolean isDiagonal = false;
		if (it.nodeType() == NodeType.LEAF) {
			return it.getValue().state == 1;
		} else {
			it.goLeft();
			if (it.nodeType() == NodeType.DOUBLE) {
				it.goLeft();
				isDiagonal = testDiagonalAux(it);
				it.goUp();
			} else {
				isDiagonal = it.getValue().state == 1;
			}
			it.goUp();

			if (isDiagonal) {
				it.goRight();
				if (it.nodeType() == NodeType.DOUBLE) {
					it.goRight();
					isDiagonal = testDiagonalAux(it);
					it.goUp();
				} else {
					isDiagonal = it.getValue().state == 1;
				}
				it.goUp();
			}
			return isDiagonal;
		}

	}

	/**
	 * @param x1 abscisse du premier point
	 * @param y1 ordonnée du premier point
	 * @param x2 abscisse du deuxième point
	 * @param y2 ordonnée du deuxième point
	 * @pre !this.isEmpty()
	 * @return true si les deux points (x1, y1) et (x2, y2) sont représentés par
	 *         la même feuille de this, false sinon
	 */
	@Override
	public boolean sameLeaf(int x1, int y1, int x2, int y2) {
		Iterator<Node> it = this.iterator();
		int xi = 0, yi = 0, xf = 255, yf = 255, mid_x = 0, mid_y = 0;
		boolean b = true, sameLeaf = true;
		int level = 0;

		while ((it.getValue().state == 2) && sameLeaf) {
			if (level%2 == 0) { // Si c'est horizontal
				mid_y = (yi + yf) / 2;

				if (y1 <= mid_y && y2 <= mid_y) {
					it.goLeft(); // Partir vers le haut
					yf = mid_y;
				} else if (y1 > mid_y && y2 > mid_y) {
					it.goRight(); // Partir vers le bas
					yi = mid_y + 1;
				} else {
					sameLeaf = false;
				}
			} else { // Si c'est vertical
				mid_x = (xi + xf) / 2;
				if (x1 <= mid_x && x2 <= mid_x) {
					it.goLeft(); // Partir vers la gauche
					xf = mid_x;
				} else if (x1 > mid_x && x2 > mid_x) {
					it.goRight(); // Partir vers la droite
					xi = mid_x + 1;
				} else {
					sameLeaf = false;
				}
			}

			level++; // pour passer d'horizontal � vertical, de vertical � horizontal, ...
		}
		return sameLeaf;
	}

	/**
	 * @param image2 autre image
	 * @pre !this.isEmpty() && !image2.isEmpty()
	 * @return true si this est incluse dans image2 au sens des pixels allumés
	 *         false sinon
	 */
	@Override
	public boolean isIncludedIn(AbstractImage image2) {
		Iterator<Node> it1 = this.iterator();
		Iterator<Node> it2 = image2.iterator();
		return isIncludedInAux(it1, it2);

	}

	private boolean isIncludedInAux(Iterator<Node> it1, Iterator<Node> it2) {
		boolean isIncluded = false, left_included = false, right_included = false;
		if (it1.getValue().state != 2) {
			switch (it2.getValue().state) {
			case 0:
				isIncluded = it1.getValue().state == 0;
				break;
			case 1:
				isIncluded = it1.getValue().state == 1;
				break;
			case 2:
				isIncluded = true;
				break;
			}
		} else {
			switch (it2.getValue().state) {
			case 1:
				isIncluded = true;
				break;
			case 0:
				isIncluded = false;
				break;
			case 2:
				it1.goLeft();
				it2.goLeft();
				left_included = isIncludedInAux(it1, it2);
				it1.goUp();
				it2.goUp();

				it1.goRight();
				it2.goRight();
				right_included = isIncludedInAux(it1, it2);
				it1.goUp();
				it2.goUp();
				isIncluded = (left_included && right_included);
				break;
			}
		}
		return isIncluded;
	}
}