/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mail.parser;

/**
 *
 * @author HM2D
 */
public class LinkedList {
    int size;
    int[][] node;
    int count;
    int temp1,temp2;
    int counter=0;
    int[][] temparray;
    public LinkedList(int[][][] vector,int index){
       for (int j = 0; j < 668; j++) {
              if(vector[1][j][index]==0){break;}
              counter++;
           }
       size=counter;
        node = new int[2][size];
    }
    public int[][] returnnode(){
    return node;
    }
    public int lengthofnode(){
    
    return size;
    }
    public void tostring(){
      for (int j = 0; j < size; j++) {
                System.out.print("  Keyword "+ node[0][j] + " | count: " +node[1][j]);
                System.out.println("");      
      }
    
    }
   public void add(int[][][] vector,int index){
           for (int i = 0; i < size; i++) {
              temp2 = vector[1][i][index];
              temp1 = vector[0][i][index];
              node[0][i] = temp1;
              node[1][i]= temp2;
            
           }
       
   }
    
}
