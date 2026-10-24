package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class GroupAnagrams {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> result = new ArrayList<>();

            if (strs == null) {
                return result;
            }

            HashMap<String, List<String>> map = new HashMap<>();

            for (String str : strs) {
                int[] freq = new int[26];

                for (char ch : str.toCharArray()) {
                    freq[ch - 'a']++;
                }

                StringBuilder key = new StringBuilder();

                for (int count : freq) {
                    key.append('#');
                    key.append(count);
                }

                String signature = key.toString();

                if (!map.containsKey(signature)) {
                    map.put(signature, new ArrayList<>());
                }

                map.get(signature).add(str);
            }

            return new ArrayList<>(map.values());
        }
}
