/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.pkg8.puzzle;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hagarmohamad75
 */
public class Node {
  public  Node Parent;
  int col=3;
  int[] puzzle=new int[9];
   public  List<Node> childern=new LinkedList<>();
    public Node(int[] p){
        for (int i=0;i<puzzle.length;i++){
            puzzle[i]=p[i];
        }
    }
    int blank=0; // for the blank square
    
    public void MOveToRight(int[] puzz,int index){
      
        if(index%col<col-1){
            int[] p=new int[9];
            copyGrid(p, puzz);
            int temp=p[index+1];
            p[index+1]=p[index];
            p[index]=temp;
               Node child=new Node(p);
               childern.add(child);
               child.Parent=this;
           
        }
    }
    public void MOveToLeft(int[] puzz,int index){
        if(index%col>0){
            int []p=new int[9];
            copyGrid(p, puzz);
            int temp=p[index-1];
            p[index-1]=p[index];
            p[index]=temp; 
            Node child =new Node(p);
            childern.add(child);
            child.Parent=this;
        }
       
    }
    public void MOveToUp(int[] puzz,int index){
        if(index-col>=0){
            int[] p=new int[9];
            copyGrid(p, puzz);
            int temp=p[index-col];
            p[index-col]=p[index];
            p[index-col]=temp;
            Node child =new Node(p);
            childern.add(child);
            child.Parent=this;
        }
    }
    public void MOveToDown(int[] puzz,int index){
        if(index+col<puzz.length){
            int[] p=new int[9];
            copyGrid(p, puzz);
            int temp=p[index+col];
            p[index+col]=p[index];
            p[index+col]=temp;
            Node child =new Node(p);
            childern.add(child);
            child.Parent=this;
        }
    }
    public void copyGrid(int[]a,int[]b){
    for(int i=0;i<a.length;i++){
    a[i]=b[i];
    }}
    public boolean IsSamePuzzle(int[] p ){
        boolean IsSame=true;
   for(int i=0;i<puzzle.length;i++){
       if(puzzle[i]!=p[i])
           IsSame=false;
   }
       return IsSame; }
    public boolean GoalState(){
        int m=puzzle[0];
         boolean goal=true;
        for(int i=1;i<puzzle.length;i++){
        if(puzzle[i]<m)
            goal=false;
           m=puzzle[i]; 
        }
        
        
    return goal;}
    public void PrintPuzzle(){
   System.out.println();
        int m=0;
        for(int i=0;i<col;i++){
        for(int j=0;j<col;j++){
            System.out.print(puzzle[m]+" ");
        m++;
        }
          System.out.println();
        }
        }
    public void ExpandNode(){
     
        for(int i=0;i<puzzle.length;i++){
        if(puzzle[i]==0)
            blank=i;
         }
  MOveToRight(puzzle, blank);
  MOveToLeft(puzzle, blank);
  MOveToUp(puzzle, blank);
  MOveToDown(puzzle, blank);
        
       
        
    
    }
}
