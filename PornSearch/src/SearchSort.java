public class SearchSort {
	private float[] sum;
	private String[] key;
	private String[] value;

	public SearchSort(float[] a, String[] b, String[] c) {
		sum = a;
		key = b;
		value = c;
	}

	public void doSort() {
		for (int i = 0; i < sum.length - 1; i++) {
			if (sum[i + 1] > sum[i]) {
				float temp1 = sum[i];
				sum[i] = sum[i + 1];
				sum[i + 1] = temp1;

				String temp2 = key[i];
				key[i] = key[i + 1];
				key[i + 1] = temp2;

				String temp3 = value[i];
				value[i] = value[i + 1];
				value[i + 1] = temp3;
			}
		}
	}

}