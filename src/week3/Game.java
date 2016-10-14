package week3;

import java.util.Scanner;

public class Game {
	Player dealer = new Player();
	Player user = new Player();

	public static void main(String[] args) {
		// tester class instantiating all objects
		Game g = new Game();
		g.start();
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);

		// this method should start the game
		System.out.println("Welcome to Black Jack ");
		System.out.println("What can I call you? ");
		String name = scanner.next();
		user.setName(name);
		System.out.println("How much money is in your wallet?");
		double wallet = scanner.nextInt();
		user.setWallet(wallet);
		Deck.makeDeck();
		Hand h = Deck.dealCard();
		user.setHand(h);

	}
}
