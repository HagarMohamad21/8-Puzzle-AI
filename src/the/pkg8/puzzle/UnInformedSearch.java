/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.pkg8.puzzle;

import java.util.LinkedList;
import java.util.List;

public class UnInformedSearch {
    
     public List<Node> BreadthFirstSearch(Node root){
        List<Node> PathSolution=new LinkedList<>();
        List<Node> Queue=new LinkedList<>(); //AKA open list
         List<Node> Visited=new LinkedList<>();//AKA closed list
         
         Queue.add(root);  
         boolean GoalFound=false;
         
         while(Queue.size()>0&&!GoalFound){
         Node CurrentNode=Queue.get(0);
         Visited.add(CurrentNode);
         Queue.remove(0);
         // now we need to Expand current node to all possible moves after we find the balnk tile postion
         CurrentNode.ExpandNode();
         CurrentNode.PrintPuzzle();
         for(int i=0;i<CurrentNode.childern.size();i++){
         Node CurrentChild=CurrentNode.childern.get(i);
         if(CurrentChild.GoalState()){
             System.out.println("Goal Found ");
             GoalFound=true;
             //WE NOW NEED TO TRACE THE PATH TO THE SOLUTION..
             TraceSolution(PathSolution, CurrentChild);
         }
         if(!Contains(Visited, CurrentChild)&&!Contains(Queue, CurrentChild)){
         Queue.add(CurrentChild);
         }
         }  }
     
   return PathSolution;}
     public boolean Contains (List<Node> lst,Node c){
         Node cc;
     boolean contain= false;
     for(int i=0;i<lst.size();i++){
      cc=lst.get(i);
     if(cc.IsSamePuzzle(c.puzzle))
         contain=true;
     }
     
   return contain;}
    public void TraceSolution(List<Node>lst,Node n){
        System.out.println("TRACING PATH TO SOLUTION ....");
        Node current=n;
        lst.add(current);
        while(current.Parent!=null){
        current=current.Parent;
        lst.add(current);
        
        }
    }
}
