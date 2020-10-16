public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int [] arr = {2,7,11,15};
        int target = 13;
        int [] arr2;
        Solution solution = new Solution();
        arr2 = solution.twoSum(arr,target);
        //System.out.println(arr2.length);
        //System.out.println(arr2[1]);
        for (int i : arr2) {
            System.out.println(i);
        }


    }
}
