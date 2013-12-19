package lejos.controller;

import lejos.nxt.*;

public class LejosSample
{

	public static void main(String[] args)
	{
		
		
		UltrasonicTest ultraTest = new UltrasonicTest();
		while(!Button.LEFT.isDown())
		{
			ultraTest.checkForward();
		}
		
		

	}

}
