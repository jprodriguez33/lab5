//JP Rodriguez
//Lab 5
public class Main {
    public static void main(String[] args) {
       int[] arr = {50,11,33,21,40,50,40,40,21};
       int n = arr.length;

       if(arr == null){
           System.out.println("Array is null");
       }

       MergeSort_Recursive(arr, 0, n-1);
       n = duplicates(arr,n);

       for (int i = 0; i < n; ++i )
           System.out.print(arr[i] +",");
    }
    static public void DoMerge(int [] numbers, int left, int mid, int right)
    //Recursive Mergesort function
    {
        int [] temp = new int[25];
        int i, left_end, num_elements, tmp_pos;

        left_end = (mid - 1);
        tmp_pos = left;
        num_elements = (right - left + 1);

        while ((left <= left_end) && (mid <= right))
        {
            if (numbers[left] <= numbers[mid])
                temp[tmp_pos++] = numbers[left++];
            else
                temp[tmp_pos++] = numbers[mid++];
        }
        while (left <= left_end)
            temp[tmp_pos++] = numbers[left++];
        while (mid <= right)
            temp[tmp_pos++] = numbers[mid++];
        for (i = 0; i < num_elements; i++)
        {
            numbers[right] = temp[right];
            right--;
        }
    }
    static public void MergeSort_Recursive(int [] numbers, int left, int right)
    {
        // use the middle element of the array to do the sorting
        int mid;
        if (right > left)
        {
            mid = (right + left) / 2;
            MergeSort_Recursive(numbers, left, mid);
            MergeSort_Recursive(numbers, (mid + 1), right);
            DoMerge(numbers, left, (mid+1), right);
        }
    }
    static int duplicates(int array[], int length){
        // function which handles duplicates
        // edge cases are tested first, if the length of the array is 0 or 1
        // it will return the element of the array
        if(length == 0 || length == 1)
            return length;
        int index = 0;

        //iterates through the array to check whether current index is equal to next index
        for(int i = 0; i < length-1; i++){
            if(array[i] != array[i+1]){
                array[index++] = array[i];
            }
        }
        array[index++] = array[length-1];
        return index;
    }
}
