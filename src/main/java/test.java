public class test {
    public static void main(String[] args) {
        int[] arr = {6,2,3,8};
        int max = arr[0],min=arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        for (int j : arr){
            if(j<min){
                min = j;
            }
        }
        int val = (max-min-arr.length)+1;
        System.out.println(val);
    }
}
