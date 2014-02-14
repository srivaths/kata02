package kata02;
/**
* Binary searcher of an ordered integer array.
*/
public class Chopper {
	// The ordered list of integers to search
	private int[] theList;
	// The item being searched
	private int target;
	
	/**
	  * Creates an instance of this class.
	  * @param list An ordered list of integers.  Note: It is <b>assumed</b> that the list is ordered.
	  * @param intToFind The integer being searched.
	  */
	public Chopper(int[] list, int intToFind) {
		this.theList = list;
		this.target = intToFind;
	} 
	
	/**
	  * Searches for the target integer in the given list.
	  * @return The index at which the integer was found or -1 if not found.
	  */
	public int chop() {
		return chop(theList, 0);
	}
	
	/**
	  * Searches the given <tt>sourceArray</tt> for the <tt>target</tt> integer.
	  * @param sourceArray The array to search
	  * @param offset The offset with respect to <tt>theList</tt> that is represented by
	  * <tt>sourceArray</tt>.
	  */
	public int chop(int[] sourceArray, int offset) {
		/*
			* Split the contents of the source 50-50.  Remember that the array need not have
			* an even number of integers.
			*/
		int sourceArrayLength = sourceArray.length;
		int[] firstHalf = new int[sourceArrayLength/2];
		int[] secondHalf = new int[sourceArrayLength - sourceArrayLength/2];
		System.arraycopy(sourceArray, 0, firstHalf, 0, firstHalf.length);
		System.arraycopy(sourceArray, firstHalf.length, secondHalf, 0, secondHalf.length);
		
		// Determine the array that contains the target
		boolean first = false;
		if(target <= firstHalf[sourceArray.length/2-1]) {
			first = true;
		}
		
		// If the chunks have only 1 element we are done. 
		// Otherwise rinse & repeat.
		if(firstHalf.length == 1) {
			if(first) {
				return (firstHalf[0] == target)? offset: -1;
			} else {
				if(secondHalf.length == 1) {
					return (secondHalf[0] == target)? offset+1: -1;
				} else {
					return chop(secondHalf, offset+1);
				}
			}
		} else {
			return first? chop(firstHalf, offset): chop(secondHalf, (offset + sourceArrayLength/2));
		}
	}
	
	/**
		* Instantiate this class &amp; find the target.
		* @param list The source array.
		* @param find The integer to find.
		* @return The index at which the target integer was found.  If not found the return value 
		* will be -1.
		*/
	public static int find(int[] list, int find) {
		Chopper chopper = new Chopper(list, find);
		return chopper.chop();
	}
	
	
	public static void main(String[] arguments) {
		int[] a = new int[12344];
		for(int i = 0; i < a.length; i++) { a[i] = i; }
		System.out.println(Chopper.find(a, 12343));
	}
}