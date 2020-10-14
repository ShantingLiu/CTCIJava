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

        /* Test productExceptSelf()
        int[] test = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(test)));
        */

        /* Test maxSubArray()
        int[] test = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(test));
        */

        /* Test maxProduct()
        int[] test = new int[]{2, 3, -2, 4};
        System.out.println(maxProduct(test));
        */
    
        int[] test = new int[]{3, 4, 5, 1, 2};
        System.out.println(findMin(test));
    
    }

    private static int findMin(int[] nums){
        int L = 0;
        int R = nums.length - 1;

        while (nums[L] > nums[R]){
            int M = (L + R) / 2;
            if (nums[L] <= nums[M]){
                L = M + 1;
            } else {
                R = M;
            }
        }
        return nums[L];
    }

    private static int maxProduct(int[] nums){
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++){
            int temp_max = Math.max(nums[i], Math.max(max_so_far * nums[i], min_so_far * nums[i]));
            min_so_far = Math.min(nums[i], Math.min(max_so_far * nums[i], min_so_far * nums[i]));
            max_so_far = temp_max;
            result = Math.max(result, max_so_far);
        }
        return result;
    }

    private static int maxSubArray(int[] nums){
        int localSum = nums[0];
        int globalSum = nums[0];

        for (int i = 0; i < nums.length; i++){
            localSum = Math.max(nums[i], localSum + nums[i]);
            globalSum = Math.max(globalSum, localSum);
        }

        return globalSum;
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
