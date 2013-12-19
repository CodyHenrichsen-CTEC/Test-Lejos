package lejos.controller;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class UltrasonicTest
{
	UltrasonicSensor sonicSensor;
	public UltrasonicTest()
	{
		sonicSensor = new UltrasonicSensor(SensorPort.S1);
	}

	public void checkForward()
	{
		System.out.println(sonicSensor.getDistance());
		
		if (sonicSensor.getDistance() < 20)
		{
			Motor.A.stop();
			Motor.B.stop();
			Motor.A.setSpeed(720);
			Motor.B.setSpeed(720);
			Motor.A.backward();
			Motor.B.backward();
			try
			{
				Thread.sleep(200);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(sonicSensor.getDistance() == 255)
		{
			Motor.B.flt();
			Motor.A.flt();
			Motor.A.setSpeed(720);
			Motor.B.setSpeed(720);
			Motor.A.forward();
			Motor.B.forward();
			try
			{
				Thread.sleep(2000);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			int distanceSpeed = sonicSensor.getDistance() *10;
			Motor.A.setSpeed(distanceSpeed);
			Motor.B.setSpeed(distanceSpeed);
			Motor.A.forward();
			Motor.B.forward();
			try
			{
				Thread.sleep(200);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
}
