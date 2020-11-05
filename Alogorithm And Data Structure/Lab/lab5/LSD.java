public class LSD{
	//void sort(String[] a, int W)
	void Sort(String[] a, int W, String[] aux, int N, int R){
		for (int d = W-1; d >= 0; d--)
		{
		// Sort by key-indexed counting ondth char.
			int[] count = new int[R+1];
			// Compute frequency counts.
			for (int i = 0; i < N; i++)
				count[a[i].charAt(d) + 1]++;
			for (int r = 0; r < R; r++)
				//Transform counts to indices.
				count[r+1] += count[r];
			for (int i = 0; i < N; i++)
				// Distribute.
				aux[count[a[i].charAt(d)]++] = a[i];
			for (int i = 0; i < N; i++)
				// Copy back.
				a[i] = aux[i];
		}
	}
	public static void main(String[] args)
	{
		LSD obj = new LSD();
		String[] a = {"Samten", "Ngawang", "Khandu", "choden"};
		//Sort a[] on leading W characters.
		int N = a.length;
		int R = 256;
		int W = a.length;
		String[] aux = new String[N];
		System.out.println("Before Sorting");
		for (int i=0; i<N ; i++ ) {
			System.out.print(" "+a[i]);	
		}
		System.out.println("");
		obj.Sort(a, W, aux, N, R);	
		System.out.println("After Sorting");
		for (int i=0; i<N ; i++ ) {
			System.out.print(" "+a[i]);	
		}
		System.out.println("");
	}
}