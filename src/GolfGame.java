
/* Author: Zubair Ab Aziz
 * Assignment: Project 1
 * Lab Section: MW, 1230-1345
 * TA Name: Sofia
 * Collaboration: I did not collaborate with anyone on this assignment
 */

import java.util.Scanner;
import java.util.Random;

public class Project1 {

	private static Scanner scanner;

	public static void main(String[] args) {

		// variables for the game
		int round = 0;
		int score = 0;
		int distance = 0;
		double gravity = 9.8;
		double angle;
		double speed;

		// New scanner and random number generator
		scanner = new Scanner(System.in);
		Random random = new Random();

		// Welcome text and rules for the player
		System.out.println("Welcome to Catapult Simulator!");
		System.out.println("");
		System.out.println(
				"A random target between 0-100 meters will be generated \nYou will enter the speed and angle of your shot to hit the target");
		System.out.println(
				"You will start with 0 points \n5 points will be added for a direct hit \n1 point will be deducted for a near miss \n2 points will be deducted for a shot way off target");
		System.out.println("");
		System.out.println("Enter 'quit' to exit game \nPress the 'Enter' key to start game");

		distance = random.nextInt(100); // Limits random number to 100

		/*
		 * Initial command is for the player to quit or start game. Once the
		 * game starts, a target of random distance is generated. The user will
		 * need to enter the angle and speed of launch. The program will tell
		 * how far off the player is and starts the next round. Scores are
		 * reported every round If the player hits the target, the game ends.
		 * The player will then be prompted with whether they want to restart
		 * the game or quit
		 */

		boolean flag = true;
		while (true) {
			String quit = "";
			if (flag) {
				quit = scanner.nextLine();
			}
			if (quit.equals("quit")) {
				System.exit(0);
			} else if (quit.equals("restart")) {
				round = 0;
				distance = 0;
				gravity = 9.8;
				distance = random.nextInt(100);
				flag = false;
				continue;
			} else {
				flag = true;
				round += 1;
				System.out.println("Round = " + round);
				System.out.println("Current Score: " + score);
				System.out.println("The target is " + distance + " meters away");
				System.out.print("Set the speed(m/s): ");
				speed = scanner.nextDouble();
				System.out.print("Set the angle(degrees): ");
				angle = scanner.nextDouble();
				scanner.nextLine();

				double shot = ((speed * speed) * (Math.sin(2 * angle))) / gravity;

				if (shot - distance >= 30) {
					System.out.println("");
					System.out.println("Your shot went: " + shot + " meters");
					System.out.println(
							"That's a miss... It's way too far... You were " + (shot - distance) + " meters off");
					score -= 2;
					System.out.println("(Enter 'quit' to exit game)\n(Press 'Enter' key for next round)");
					System.out.println();
					continue;
				} else if (shot - distance <= -30) {
					System.out.println("");
					System.out.println("Your shot went: " + shot + " meters");
					System.out
							.println("That's a miss... Way too short... You were " + (shot - distance) + " meters off");
					score -= 2;
					System.out.println("(Enter 'quit' to exit game)\n(Press 'Enter' key for next round)");
					System.out.println();
					continue;
				} else if (shot - distance >= 5) {
					System.out.println("");
					System.out.println("Your shot went: " + shot + " meters");
					System.out.println("Close... but not quite :\n went right over their heads.\n You were "
							+ (shot - distance) + " meters off");
					score -= 1;
					System.out.println("(Enter 'quit' to exit game)\n(Press 'Enter' key for next round)");
					System.out.println();
					continue;
				} else if (shot - distance <= -5) {
					System.out.println("");
					System.out.println("Your shot went: " + shot + " meters");
					System.out.println("Close... but not quite :\nWent down right in front of them.\nYou were"
							+ (shot - distance) + " meters off");
					score -= 1;
					System.out.println("(Enter 'quit' to exit game)\n(Press 'Enter' key for next round)");
					System.out.println();
					continue;
				} else if (shot - distance <= 5 || shot - distance >= -5) {
					System.out.println("");
					System.out.println("Your shot went: " + shot + " meters");
					System.out.println("Direct Hit! Nice shot!");
					score += 5;
					System.out.println("(Enter 'quit' to exit game)\n(Enter 'restart' to restart game)");
					System.out.println();
					continue;
				}

			}
		}
	}
}
