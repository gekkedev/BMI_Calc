import java.util.Scanner;

public class Main {

	static Scanner input = new Scanner( System.in );

	public static void main(String[] args) {
		// called when the program starts
		echoln("The BMI calculator was launched. Please enter the required data now!");

		//prompt
		float height = readval("Body height in meters");
		int weight = Math.round(readval("Weight in kilogram"));
		float age = readval("Age");

		float index = (float) (weight/Math.pow(height, 2));

		String result;//init
		if (index < 18.5){result = "underweight";}
		else if (index < 25){result = "normal weight";}
		else if (index < 30){result = "overweight";}
		else result = "strong overweight";
		echoln("Calculated body mass index: " + index);

		if (height > 1.5) {
			String recommendation;//init
			if (age < 25){recommendation = "19-24";}
			else if (age < 65){recommendation = "22-27";}
			else recommendation = "24";
			echoln("Desirable body mass index for your age: " + recommendation);
		}
		echoln("Age-independent result: " + result);
	}

	private static float readval(String label) {
		// simplifying the process of reading input
		echo(label + ": ");
		String stringval = input.next();
		stringval = stringval.replace(",", ".");
		if (!isNumeric(stringval)) CalcErr("Please enter a valid number!");

		float val = Float.parseFloat(stringval);
		if (val < 0) {
			echoln("Invalid value! Continuing calculation with the positive value (" + val + ").");
			val = val * -1;
		} else if (val == 0) {
			CalcErr("Please enter a number bigger than zero.");
		}
		return val;
	}

	private static void CalcErr(String errdetail) {
		// stop exec
		echoln("Invalid value! Aborting. " + errdetail);
		System.exit(0);
	}

	private static void echo(String output) {
		System.out.print(output);
	}

	private static void echoln(String output) {
		System.out.println(output);
	}

	public static boolean isNumeric(String str) {
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal(both comma and point allowed)
	}
}
