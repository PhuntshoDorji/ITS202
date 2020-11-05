public class KeyIndex{
	public static void main(String[] args) {
		int[]arr={6,4,3,0,2,2,5,1};
		int R=7;
		int N=arr.length;
		int[] count=new int [R+1];
		int[] aux=new int [arr.length];
		// Compute frequency counts.
		for (int i=0;i<N ;i++ ) {
			count[arr[i]+1]++;
		}
		// Transform counts to indices.
		for (int j=0;j<R ;j++ ) {
			count[j+1]+=count[j];
		}
		// Distribute the records.
		for (int i=0;i<N ;i++ ) {
			aux[count[arr[i]]++]=arr[i];
		}
		// Copy back.
		for (int i=0;i<N ;i++ ) {
			arr[i]=aux[i];
		}
		for (int i=0;i<N ;i++ ) {
			System.out.print(" "+arr[i]);
		}
		System.out.println(" ");
	}
}
