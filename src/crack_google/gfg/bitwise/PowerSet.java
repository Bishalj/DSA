package crack_google.gfg.bitwise;

public class PowerSet {
	public static void main(String[] args) {
		int n = 3;
		generatePowerSet(n);
	}

	private static void generatePowerSet(int n) {
		for(int i=1; i<=Math.pow(2,n); i++){
			final StringBuilder stringBuilder = new StringBuilder();
			for(int j=1; j<=n; j++)
				if((i & (1 << (j-1))) != 0)
					stringBuilder.append((char)(64+j));
			System.out.println(stringBuilder);
		}
	}
}

