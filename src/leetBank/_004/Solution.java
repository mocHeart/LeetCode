package leetBank._004;

class Solution {
    // 解法一：合并数组，在根据新数组的个数的奇偶取得中位数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int l = m + n;
        int[] nums3 = new int[l];

        // 合并为新数组
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        for (int i = 0; i < l; i++) {
            if (index1 == m && index2 == n) {
                break;
            }
            else if (index1 == m) {
                nums3[index3] = nums2[index2];
                index2++;
            } else if (index2 == n) {
                nums3[index3] = nums1[index1];
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                nums3[index3] = nums2[index2];
                index2++;
            } else {
                nums3[index3] = nums1[index1];
                index1++;
            }
            index3++;
        }

        // 根据奇偶取中位数
        if (l % 2 == 1) {
            return nums3[l/2];
        } else {
            return (nums3[l/2-1] + nums3[l/2]) / 2.0;
        }
    }


    // 解法二： 从两个排好序的数字中依次取出最小值，
    // 当两数组元素总个数len为奇数时，中位数为取出的 第 len/2+1 个
    // 当为偶数时，中位数为取出的 第 len/2 个和第 len/2+1 个的平均值
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        // 用right和left记录当前取出的值和前一次取出的值
        int left = 0;
        int right = 0;
        // aStart和bStart记录两数组当前取值的位置
        int aStart = 0;
        int bStart = 0;
        for (int i = 0; i < len / 2 + 1; i++) {
            left = right;
            if (aStart == m) {
                right = nums2[bStart];
                bStart++;
            } else if (bStart == n) {
                right = nums1[aStart];
                aStart++;
            } else if (nums1[aStart] > nums2[bStart]) {
                right = nums2[bStart];
                bStart++;
            } else {
                right = nums1[aStart];
                aStart++;
            }
        }

        // 根据奇偶取得中位数
        if (len % 2 == 1) {
            return right;
        } else {
            return (left + right) / 2.0;
        }
    }


    // 解法三：采用二分法的思想在两个有序数组寻找第（中间位数）小的数既是中位数
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        // 中间位置，奇数个时 left == right
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;

        // 在两个有序数组中寻找第left小和第right小的数
        // 将偶数和奇数的情况合并，如果是奇数，会求两次得到同样的k.
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    // 两个有序数组中寻找第k小的数
    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        // 取每个数组的第k/2小
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }


    // 解法四：挖掘中位数的定义，采用二分思路充分考虑各种情况
    public double findMedianSortedArrays4(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            return findMedianSortedArrays(B,A); // 保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && B[j-1] > A[i]){ // i 需要增大
                iMin = i + 1;
            }
            else if (i != 0 && j != n && A[i-1] > B[j]) { // i 需要减小
                iMax = i - 1;
            }
            else { // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; } // 奇数的话不需要考虑右半部分

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
            }
        }
        return 0.0;
    }


        public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        System.out.println(s.findMedianSortedArrays3(nums1, nums2));
    }
}

