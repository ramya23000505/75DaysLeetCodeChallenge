class Solution {
    public int possibleStringCount(String word) {

        int ans = 1;

        int i = 0;

        while (i < word.length()) {

            int j = i;

            while (j < word.length() && word.charAt(j) == word.charAt(i)) {
                j++;
            }

            ans += (j - i - 1);

            i = j;
        }

        return ans;
    }
}