package fr.istic.prg1.tp3;

public class Fourmis {
	
	/**
	 * @param ui
	 * 			un terme de la suite des fourmis
	 * @return	le terme suivant de la suite des fourmis
	 */
	public static String next(String ui) {
		int compteur = 1; 				// nombre d'occurences
		char element = ui.charAt(0); 	//premier element a comparer
		String str = ""; 				//chaine du resultat
		for (int i = 1; i < ui.length(); i++){
			if(element == ui.charAt(i)){ 		//si l'element suivant est identique au precedant
				compteur++;
			}else { 							//sinon c'est un autre element 
				str += "" + compteur +""+ element ;
				element = ui.charAt(i);
				compteur = 1;
			}
		}
		str +=  "" + compteur +""+ element;
		return str;
	}
}