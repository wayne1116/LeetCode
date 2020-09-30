// 1600. Throne Inheritance
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-208/problems/throne-inheritance/
class ThroneInheritance {
    Map<String, List<String>> pc;
    Map<String, Boolean> dflag;
    String king;
    public ThroneInheritance(String kingName) {
        this.pc=new HashMap<String, List<String>>();
        this.pc.put(kingName, new ArrayList<String>());
        this.dflag=new HashMap<String, Boolean>();
        this.king=kingName;
        dflag.put(kingName, false);
    }
    
    public void birth(String parentName, String childName) {
        List<String> t=this.pc.get(parentName);
        t.add(childName);
        dflag.put(parentName, false);
        dflag.put(childName, false);
        if(this.pc.get(childName)==null)
            this.pc.put(childName, new ArrayList<String>());
    }
    
    public void death(String name) {
        dflag.put(name, true);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> result=new ArrayList<String>();
        solv(king, result);
        //if(result.size()==1)
        //    return new ArrayList<String>();
        return result;
    }
    
    void solv(String name, List<String> result) {
        List<String> t=this.pc.get(name);
        if(!dflag.get(name))
            result.add(name);
        for(int i=0; i<t.size(); i++)
            solv(t.get(i), result);
        
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
