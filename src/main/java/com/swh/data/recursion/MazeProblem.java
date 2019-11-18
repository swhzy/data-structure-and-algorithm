 package com.swh.data.recursion;

public class MazeProblem {

    public static void main(String[] args) {
        int[][] ints = new int[][]{{1,1,1,1,1,1},{1,0,0,0,0,1},{1,0,1 ,0,0,1},{1,1,1,0,0,1},{1,0,0,0,0,1},{1,1,1,1,1,1}};
        maze1(ints,1,1);
    }


    public  static void maze(int[][] maze,int x,int y){

        if(!(x==4&&y==4)) {
            if (maze[x][y + 1] == 0) {
                maze[x][y]=2;
                maze(maze,x,y+1);
            }else {
                maze[x][y]=2;
                maze(maze,x+1,y);
            }
        }else {
            for (int[] ints : maze) {
                for (int anInt : ints) {
                    System.out.print(anInt +" ");
                }
                System.out.println();
            }

            System.out.println("游戏结束");
        }





    }

    public  static boolean maze1(int[][] maze,int x,int y){

        if(maze[4][4]==2){
            for (int[] ints : maze) {
                for (int anInt : ints) {
                    System.out.print(anInt +" ");
                }
                System.out.println();
            }

            System.out.println("游戏结束");
            return true;
        }else {
            if(maze[x][y]==0){
                maze[x][y]=2;
                if(maze1(maze,x+1,y)){
                    return true;
                }else if(maze1(maze,x,y+1)){
                    return true;
                }else if(maze1(maze,x-1,y)){
                    return true;
                }else if(maze1(maze,x,y-1)){
                    return true;
                }else {
                    maze[x][y]=3;
                    return false;
                }
            }else {
                return false;
            }


        }







    }




}
