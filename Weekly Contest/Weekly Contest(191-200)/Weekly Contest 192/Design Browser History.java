class BrowserHistory {
    Map<String, String> forward;
    Map<String, String> backward;
    String currentpage;
    public BrowserHistory(String homepage) {
        currentpage=homepage;
        forward=new HashMap<String, String>();
        backward=new HashMap<String, String>();
    }
    
    public void visit(String url) {
        forward.put(currentpage, url);
        backward.put(url, currentpage);
        currentpage=url;
    }
    
    public String back(int steps) {
        while(steps-->0) {
            if(!backward.containsKey(currentpage))
                return currentpage;
            currentpage=backward.get(currentpage);
        }
        
        return currentpage;
    }
    
    public String forward(int steps) {
        while(steps-->0) {
            if(!forward.containsKey(currentpage))
                return currentpage;
            currentpage=forward.get(currentpage);
        }
        
        return currentpage;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
