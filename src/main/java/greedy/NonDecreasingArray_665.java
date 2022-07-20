package greedy;

public class NonDecreasingArray_665 {

    public static boolean checkPossibility(int[] nums) {

        int modify = 0;
        for (int i=0;i<nums.length-1;i++) {
            if (nums[i] > nums[i+1]) {
                modify++;
                if (modify > 1) {
                    return false;
                }
                if ( i - 1 < 0) {
                    nums[i] = nums[i+1];
                }
                if (i>0 && nums[i+1] >= nums[i - 1]) {
                    nums[i] = nums[i-1];
                }
                if (i > 0 && nums[i+1] < nums[i - 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }
        if (nums.length > 1 && nums[nums.length-1] < nums[nums.length - 2]) {
            modify++;
            if (modify > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean ans = checkPossibility(new int[]{1,2,3,2});  // 4 2 3   3 4 2 3   2 2 3 2 4  1 2 3 2

        System.out.println(ans);
    }
}
