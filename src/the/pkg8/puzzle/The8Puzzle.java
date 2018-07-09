/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.pkg8.puzzle;

import java.util.List;

/**
 *
 * @author hagarmohamad75
 */
public class The8Puzzle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] Puzzle={1,2,4,
                      3,0,5,
                      7,6,8};
         
        Node root=new Node(Puzzle);
        UnInformedSearch UI=new UnInformedSearch();
       List< Node> Solution=UI.BreadthFirstSearch(root);
        if(Solution.size()>0){
        for(int i=0;i<Solution.size();i++){
        Solution.get(i).PrintPuzzle();}
        }
        else System.out.println("No Solutoin is Found");
        
    }
    
}
