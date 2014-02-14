package kata02;
import org.junit.runners.Parameterized;
import static org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
@RunWith (Parameterized.class)
public class Tester {
	@Parameters
	public static Collection<Object[]> data() {
	  return Arrays.asList(new Object[][] {
			{ new int[] {1, 2, 3, 4, 5}, 2, 1},
			{ new int[] {1, 2, 3, 4, 5}, 6, -1}
    });
	}
	private int[] searchList;
	private int   searchFor;
	private int   expectAt;
	public Tester(int[] array, int target, int expectedIndex) {
		searchList = array;
		searchFor  = target;
		expectAt   = expectedIndex;
	}
	
	@Test
	public void doIt() {
		int foundAt = Chopper.find(searchList, searchFor);
		assertEquals("" + expectAt + " is not " + foundAt + ".", expectAt, foundAt);
	}
}