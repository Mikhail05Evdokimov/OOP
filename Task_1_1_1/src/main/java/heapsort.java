public class heapsort
{
    public void sort(int[] arr)
    {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i=n-1; i>=0; i--)
        {
            int t = arr[0];
            arr[0] = arr[i];
            arr[i] = t;

            heapify(arr, i, 0);
        }
    }

    public void heapify(int []arr, int n, int i)
    {
        int largest = i;
        int l = 2*i + 1; // левый сын
        int r = 2*i + 2; // правый сын
        //sift Up
        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i)
        {
            int t = arr[i];
            arr[i] = arr[largest];
            arr[largest] = t;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {5, 4, 6, 1, 2, 3};

        heapsort ob = new heapsort();
        ob.sort(arr);
        for (int i : arr){
            System.out.print(i + " ");
        }
    }
}
