public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                merged[k] = nums1[i];
                i++;
            } else {
                merged[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < nums1.length) {
            merged[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length) {
            merged[k] = nums2[j];
            j++;
            k++;
        }
        
        if (merged.length % 2 == 0 ) {
            int arrayLocY = merged.length/2;
            int arrayLocX = arrayLocY - 1;
            double answer = merged[arrayLocX] + merged[arrayLocY];
            answer = answer/2;
            return answer;
        } else {
            int arrayLoc = (merged.length/2);
            double answer = merged[arrayLoc];
            return answer;
        }
    }
    public static void main(String[] args){
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}