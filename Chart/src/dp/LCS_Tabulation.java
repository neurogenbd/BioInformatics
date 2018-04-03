package dp;

public class LCS_Tabulation {

	public static void main(String[] args) {
		LCS_Tabulation lcs = new LCS_Tabulation();
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " + lcs.lcs(X, Y, m, n, s1, s2));

	}

	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	int lcs(char[] X, char[] Y, int m, int n, String s1, String s2) {

		int L[][] = new int[m + 1][n + 1];

		/*
		 * Following steps build L[m+1][n+1] in bottom up fashion. Note that L[i][j]
		 * contains length of LCS of X[0..i-1] and Y[0..j-1]
		 */
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X[i - 1] == Y[j - 1])
					L[i][j] = L[i - 1][j - 1] + 1;
				else
					L[i][j] = max(L[i - 1][j], L[i][j - 1]);
			}
		}

		// Following code is used to print LCS
		int index = L[m][n];
		int temp = index;

		// Create a character array to store the lcs string
		char[] lcs_print = new char[index + 1];
		lcs_print[index] = '\0'; // Set the terminating character

		// Start from the right-most-bottom-most corner and
		// one by one store characters in lcs[]
		String XX = s1;
		String YY = s2;

		int i = m, j = n;
		while (i > 0 && j > 0) {
			// If current character in X[] and Y are same, then
			// current character is part of LCS
			if (XX.charAt(i - 1) == YY.charAt(j - 1)) {
				// Put current character in result
				lcs_print[index - 1] = XX.charAt(i - 1);

				// reduce values of i, j and index
				i--;
				j--;
				index--;
			}

			// If not same, then find the larger of two and
			// go in the direction of larger value
			else if (L[i - 1][j] > L[i][j - 1])
				i--;
			else
				j--;
		}

		// Print the lcs
		// System.out.print("LCS of " + XX + " and " + YY + " is ");
		for (int k = 0; k <= temp; k++) {
			System.out.print(lcs_print[k]);
		}

		System.out.println();

		return L[m][n];
	}

	/* Utility function to get max of 2 integers */
	int max(int a, int b) {
		return (a > b) ? a : b;
	}

}
