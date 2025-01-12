// Time Complexity : Exponential
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>());
        return result;

    }
    private void backtrack(String s,int start, List<String> temp) {

        // base case
        if(start >= s.length()){
            result.add(new ArrayList<>(temp));
        }

        // logic
        for(int i = start; i < s.length(); i++) {

            if(isPalindrome(s, start, i)) {
                //action
                temp.add(s.substring(start, i+1));
                //recurse
                backtrack(s, i+1, temp);
                // backtrack
                temp.remove(temp.size() - 1);

            }

        }

    }

    private boolean isPalindrome(String s, int l, int r) {

        if(l == r) return true;

        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

}