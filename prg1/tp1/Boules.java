package fr.istic.prg1.tp1;
public class Boules{
   static int nombresBoules = 0;

    /* resultat : contenant la suite des caracteres lus */
    public static char[] lireTableauBoules(){
        char [] tab = new char [nombresBoules];
        for(int i = 0; i < nombresBoules; ++i){
        	tab[i] = Lecture.lireChar();
            if(tab[i] == 10){
                --i;
            }
         }
         return tab;
    }

    /* effet: le contenu de tab est affiche a  l'ecran  */
     public static void ecrireTableauBoules(char [] tab){
         for(int i = 0; i < nombresBoules; ++i){
             Ecriture.ecrireChar(tab[i]);
         }

     }

     /* effet: echange tab[i] et tab[j] */
     public static void echange (int i, int j, char [] tab){
         char c = tab[i];
         tab[i] = tab[j];
         tab[j] = c;
     } 

     /* effet : afficher le valeurs intermediaires des indices r, s, t et de tab  */
     public static void photo (int r, int s, int t, char[] tab){
        Ecriture.ecrireStringln(" r = " + r + " s = " + s + " t = " + t);
        ecrireTableauBoules(tab);
        Ecriture.ecrireStringln("");
     }
    
     /* effet: methode principale d'execution */
     public static void main(String[] args) {
        Ecriture.ecrireString("Entrer le nombre de Boules Ã  trier : ");
        nombresBoules = Lecture.lireInt();
        char [] tableauBoules;
        Ecriture.ecrireString("suite des " + nombresBoules + " boules : ");
        tableauBoules = lireTableauBoules();
        int r = 0, s = 0, t = nombresBoules - 1;
        while(s <= t){
            /* tableauBoules[s] est la boule a  tester */
            switch(tableauBoules[s]){
            case 'v': 
                echange(r, s, tableauBoules);
                ++r;
                ++s;
            break ;
            case 'b': 
                ++s;
                break; 
            case 'r': 
                echange(s, t, tableauBoules);
                --t;
             //++s;
             break;
             default: 
                Ecriture.ecrireStringln("erreur :  s = " + s + ", boule = [" + tableauBoules[s]+"]");
                System.exit(0);
            }
            photo(r, s, t, tableauBoules);
        }
        Ecriture.ecrireString("resultat du tri: ");
        ecrireTableauBoules(tableauBoules);
        Ecriture.ecrireStringln("");

    }
    
}