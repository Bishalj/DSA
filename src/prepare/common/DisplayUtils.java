package prepare.common;

import java.util.Arrays;
import java.util.Collection;

public class DisplayUtils {
	public static void array(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] +" ");
		}
		System.out.println();
	}
}
