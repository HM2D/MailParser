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
public class Sparse {
    int size1=668;
    int size2=1000;
    int[][][] parsed= new int[2][668][1000];
    int[][][] temp;
    int column=0;
    int mails=0;
    int count=0;
    
    int[][][] parser(int [][][]  Vectors){
        
        for (int i = 0; i < 290; i++) {
            for (int j = 0; j < 668 ; j++) {
                if(Vectors[1][j][i]!= 0)
                {
                parsed[0][column][mails] = j;    
                parsed[1][column][mails]= Vectors[1][j][i];
                column++;
                }
            }
            column=0;
            mails++;  
        }
         /*for (int i = 0; i < 1000; i++) {
             for (int j = 0; j < 668; j++) {
                 if(parsed[1][j][i]==0)
                 {
                 break;
                 }
                 count++;
             }
              for(int m=0;m < count ;m++)
              {
                  System.out.println("mail "+i+" keyword "+ parsed[0][m][i] + " : " +parsed[1][m][i]);    
        } 
                  count=0;
    }    */
    return parsed;
    }
    
    
    void sout(){
    for (int i = 0; i < mails; i++) {
              for(int m=0;m < column ;m++)
              {
                  System.out.print(parsed[1][m][i]);
                  
        } 
    }
    }
    
    
    
}
