import java.util.ArrayList;

public class SieveOfEratosthenes {
	
	public SieveOfEratosthenes(){}
	
	public ArrayList<Integer> RunSieveOfEratosthenes(Integer number){
		
		Double sqrtOfNumber = Math.sqrt(number);
		
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		ArrayList<Integer> markedNumberList = setupMarkedNumberList(number);
		
		for(Integer i = 2; i < sqrtOfNumber; i = i + 1){
			
			for(Integer x = i; x < number; x = x+i){
				if(x == i){
					continue;
				}
				
				markedNumberList.set(x, 1);
			}
		}	
		
		for(Integer i = 0; i < markedNumberList.size(); i++){
			
			if(markedNumberList.get(i) == 0){
				if(i < 2){
					continue;
				}
				returnList.add(i);
			}
		}
		
		return returnList;
	}
	
	private ArrayList<Integer> setupMarkedNumberList(Integer number){

		ArrayList<Integer> returnList = new ArrayList<Integer>(number);
		for(Integer i = 0; i < number; i++){
			returnList.add(i, 0);
		}
		return returnList;
	}

}
