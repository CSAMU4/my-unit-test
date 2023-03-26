import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoTest {
	private TestDemo testDemo; 

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo(); 
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly (
			int a, int b, int expected, Boolean isExceptionThrown) {
		
		if(isExceptionThrown) {
			handleException(a, b); 
		}
		else {
			handleNormalCase(a, b,expected); 
			
		}
	}
		
		private void handleNormalCase(int a, int b, int expected) {
			// Given: two positive numbers 
			
			// When: The Addition method is called 
			int actual = testDemo.addPositive(a, b); 
			
			// Then: The actual results is what is expected 
			assertThat(actual).isEqualTo(expected);
		}
		private void handleException(int a, int b) {
			// Given: Two numbers 
			
			// When: The Addition method is called 
			
			// Then: an IllegalArgumentException is thrown 
				assertThatThrownBy(() -> 
					testDemo.addPositive(a, b)).
						isInstanceOf(IllegalArgumentException.class);				
		}
		
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				arguments(2, 4, 6, false), 
				arguments(4, 3, 7, false),
				arguments(1, -1, 0, true),
				arguments(5, -7, 0, true), 
				arguments(-7, 5, 0, true), 
				arguments(1, 1, 2, false),
				arguments(0, 0, 0, true)
				); 	
	}
	
	// second test - 
	@Test
	 void assertThatNumberSquaredIsCorrect() {
		// Arrange 
		TestDemo mockDemo = spy(testDemo); 
		
		// Act 
		doReturn(5).when(mockDemo).getRandomInt(); 
		int fiveSquared = mockDemo.randomNumberSquared(); 
		
		// Assert
		assertThat(fiveSquared).isEqualTo(25); 
		
	}
} 
