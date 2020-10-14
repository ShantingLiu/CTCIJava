import java.util.*;

public class Blind75 {
    public static void main(String[] args) {
        System.out.println("This is Team Blind's 75 problems.");

        /* Test twoSum()
        int[] numsTest = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numsTest, target)));
        */

        /* Test maxProfit()
        int[] priceTest = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(priceTest));
        */

        /* Test containsDuplicate()
        int[] test = new int[]{1, 2, 3, 1};
        System.out.println(containsDuplicate(test));
        */

        int[] test = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(test)));
        
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

    private static int maxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++){
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    private static boolean containsDuplicate(int[] arr){
        Set<Integer> set = new HashSet<>(arr.length);
        for (int value : arr){
            if (set.contains(value)){
                return true;
            }
            set.add(value);
        }
        return false;
    }

    private static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] L = new int[length];
        int[] R = new int[length];
        int[] result = new int[length];

        L[0] = 1;
        R[length - 1] = 1;

        for (int i = 1; i < length; i++){
            L[i] = nums[i - 1] * L[i - 1];
        }

        for (int i = length - 2; i >= 0; i--){
            R[i] = nums[i + 1] * R[i + 1];
        }

        for (int i = 0; i < length; i++){
            result[i] = L[i] * R[i];
        }

        return result;
    }
}
