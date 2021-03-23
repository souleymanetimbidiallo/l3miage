package fr.istic.prg1.tp3;

public class MainFourmis {

	public static void main(String[] args) {
		String ui = "1";
		for(int i=1; i<=10; i++) {
			System.out.println("u"+i+" = "+ui);
			ui = Fourmis.next(ui);
		}

	}

}
