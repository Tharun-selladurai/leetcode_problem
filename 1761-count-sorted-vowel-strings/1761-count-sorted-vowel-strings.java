class Solution {
    private int find(int n,int ind,String str,char[] ch,int[][] dp){
        if(n==0) return 1;
        if(dp[n][ind]!=-1) return dp[n][ind];
        int cnt=0;
        for(int i=ind;i<5;i++){
          str=str+ch[i];
          cnt+=find(n-1,i,str,ch,dp);
        }
        return dp[n][ind]=cnt;
    }
    public int countVowelStrings(int n) {
        int[][] dp=new int[n+1][5];
        for(int[] row:dp) Arrays.fill(row,-1);
        char[] ch={'a','e','i','o','u'};
        return find(n,0,"",ch,dp);
    }
}