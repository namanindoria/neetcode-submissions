class Solution {
    int start;
    int end;
    int max;
    public String longestPalindrome(String s) {
        int n=s.length();
        start=0;
        end=0;
        max=0;
        for(int i=0;i<n;i++){
            fn(i,s,n);
        }
        String str=s.substring(start,end+1);
        return str;

    }
    public void fn(int i,String s,int n){

        
            int l1=expand(i,i,s,n);
            l1--;
            if(l1>max){
                max=l1;
                start=i-(l1/2);
                end=i+(l1/2);
            } 
        
        
            int l2=expand(i,i+1,s,n);
            if(l2>max){
                max=l2;
                start=i+1-(l2/2);
                end=i+(l2/2);
            } 
        
    }
    public int expand(int l,int r,String s,int n){
        int c=0;
        while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
            c=c+2;
            l--;
            r++;
        }
        return c;
    }
}
