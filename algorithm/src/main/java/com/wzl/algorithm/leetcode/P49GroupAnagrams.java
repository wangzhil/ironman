package com.wzl.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字母异位词分组   简单思路就是，将异位词放入到一个List里面。  首先对数组字符串进行单个排序，然后转换字符串，
 * 依次循环，并将字符串放入Hash里面作为key；如果key相同则Map的value为List则添加到一组。最后map.values()返回。
 *
 * 方法二： 可以通过判断字符出现的次数char[]转换为key 来判断重复。
 * for (char c : s.toCharArray())
 *             ca[c - 'a']++;
 *         //统计每个字符出现次数的数组转化为字符串
 *         String keyStr = String.valueOf(ca);
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/9 9:09
 */
public class P49GroupAnagrams {


    public static void main(String[] args) {
        Solution solution = new P49GroupAnagrams().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) {
                return new ArrayList<>();
            }
            Map<String, List<String>> hashMap = new HashMap<>();
            int length = strs.length;
            int n;
            for (n = 0; n < length; n ++) {
                char[] crs = strs[n].toCharArray();
                Arrays.sort(crs);
                String str = String.valueOf(crs);
                if (! hashMap.containsKey(str)) {
                    hashMap.put(str, new ArrayList<>());
                }
                hashMap.get(str).add(strs[n]);
            }
            return new ArrayList<>(hashMap.values());
        }
    }
}
