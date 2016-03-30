import java.util.ArrayList;


public class AdditiveFunctionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length == 0 || args.length > 1){
			System.out.println("You must pass in an argument and only 1.");
			return;
		}
		
		Integer passedInNumber = getInteger(args[0]);
		
		if(passedInNumber < 0){
			System.out.println("The value passed in was less than 0 or was an invalid number.");
			return;
		}
		
		SieveOfEratosthenes sieve = new SieveOfEratosthenes();
		ArrayList<Integer> primeNumbers = sieve.RunSieveOfEratosthenes(passedInNumber);
		
		if(checkIfSecretIsAdditive(primeNumbers)){
			System.out.println("The function is additive.");
		}
		else{
			System.out.println("The function is not additive.");
		}
	}
	
	private static Integer getInteger(String numberToParse){
		
		try{
			Integer returnNumber = Integer.parseInt(numberToParse);
			return returnNumber;
		}
		catch(NumberFormatException nfe){
			return -1;
		}
		
	}	
	
	private static Integer secret(Integer number){
		return number;
	}
	
	private static Boolean checkIfSecretIsAdditive(ArrayList<Integer> primeNumbers){
		
		for(Integer x : primeNumbers){
			for(Integer y : primeNumbers){
				if(secret(x + y) != (secret(x) + secret(y))){
					return false;
				}
			}
		}

		return true;
	}
}
