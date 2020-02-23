class Solution {
    public int daysBetweenDates(String date1, String date2) {
        int result=date1.compareTo(date2);
        if(result==0)
            return 0;
        else if(result>0) {
            String temp=date1;
            date1=date2;
            date2=temp;
        }
        String[] da1=date1.split("-");
        String[] da2=date2.split("-");
        int[] monday={0,31,28,31,30,31,30,31,31,30,31,30,31};
        int year1=Integer.parseInt(da1[0]);
        int month1=Integer.parseInt(da1[1]);
        int day1=Integer.parseInt(da1[2]);
        int year2=Integer.parseInt(da2[0]);
        int month2=Integer.parseInt(da2[1]);
        int day2=Integer.parseInt(da2[2]);
        
        int total=0;
        for(int i=year1; i<year2; i++) {
            if(i%4==0 && i%100!=0 || i%400==0){
                total+=366;
            }
            else
                total+=365;
        }
        for(int i=1; i<month1; i++)
            total-=monday[i];
        total-=day1;
        if(month1>2 && (year1%4==0 && year1%100!=0 || year1%400==0))
            --total;
        
        for(int i=1; i<month2; i++)
            total+=monday[i];
        total+=day2;
        if(month2>2 && (year2%4==0 && year2%100!=0 || year2%400==0))
            ++total;
        return total;
    }
}
