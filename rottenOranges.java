class Solution {
//TC:O(mn) SC:O(nums of 2)
        int mins=0;
        int[][] dirs={{0,1},{1,0},{-1,0},{0,-1}}; //{move right,move down, move up,move left}
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)q.add(new int[]{i,j});
                if(grid[i][j]==1)
                    fresh++;
                }
        }
        if(fresh==0)return 0;
        //start rotting oranges by bfs
        while(!q.isEmpty()){
            
            int s=q.size();//this q has all 2'occurences
            while(s-- > 0){
                int[] rot=q.poll();//first 2 will be polled
                //move in all possible directions from the polled index 
                for(int dir[]:dirs){
                    //4 directions, so 4 steps
                    //dir[]={0,1} ;dir[]={1,0};dir[]={-1,0};dir[]={0,-1}
                    int nr=dir[0]+rot[0];
                    int nc=dir[1]+rot[1];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1 ){
                        q.add(new int[]{nr,nc});
                        //rotting by placing 2 in place of 1
                        grid[nr][nc]=2;
                        fresh--;
                    }
                    
                }
            }
            //rotting each polled array i.e adjacent oranges takes 1 min
                mins++;
        }
        //if some orange cannot be rotten then impossible   i.e not changed from 1 to 2 
        if(fresh != 0) return -1;
        //no fresh oranges i.e 1's are avaialble 
        if(mins==0) return 0;
        return mins-1;
    }
}
    
