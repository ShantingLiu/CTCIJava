import java.util.*;

public class Blind75 {
    public static void main(String[] args) {
        System.out.println("This is Team Blind's 75 problems.");
        int[] numsTest = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numsTest, target)));
    }

    private static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
