class Solution {
    private String process(String str) {
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == '#') {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public boolean backspaceCompare(String s, String t) {
        return process(s).equals(process(t));
    }
}