// 1773. Count Items Matching a Rule
// difficulty: easy
// website: https://leetcode.com/contest/weekly-contest-230/problems/count-items-matching-a-rule/

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int result = 0;
        for(int i=0; i<items.size(); i++) {
            List<String> t = items.get(i);
            String type = t.get(0);
            String color = t.get(1);
            String name = t.get(2);
            if(ruleKey.compareTo("color")==0) {
                if(ruleValue.compareTo(color)==0)
                    ++result;
            }
            else if(ruleKey.compareTo("type")==0) {
                if(ruleValue.compareTo(type)==0)
                    ++result;
            }
            else{
                if(ruleValue.compareTo(name)==0)
                    ++result;
            }
        }
        return result;
    }
}
