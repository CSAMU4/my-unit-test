import java.util.Random;

public class TestDemo {
	
	/**
	 * This is the specification:  
	 * Create addPositive method 
	 * Check to see if both numbers are positive and not zero
	 * If so, return the added result 
	 * If not, throw IllegalArgumentException 
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int addPositive(int a, int b) {
			if (a > 0 && b > 0) {
				return a + b; 	
			} 
			else {
				throw new IllegalArgumentException(
						"Both parameters must be positive!");
				}
			}	
	
	public int randomNumberSquared() {
		int randomNumber = getRandomInt(); 
		int result = randomNumber * randomNumber;
		return result; 	
	}
	 int getRandomInt() {
		Random random = new Random(); 
		return random.nextInt(10) + 1;
	} 
}
