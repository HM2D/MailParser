/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mail.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author HM2D
 */
public class Search {
      int intIndex;
      int count=0;
      int temp=0;
      int vectors[][][] = new int[2][668][290];
      int[][][] returnVector(){
          
        return vectors;
      
      
      }
      int SearchFile(String[] s,String[] key){
        Pattern p;
          for (int i = 0; i < key.length; i++) {
             p = Pattern.compile(key[i]);
             int lastIndex = 0;
             int count =0;
             for (int j = 0; j < s.length ; j++) {
              if(s[j]== null)
              { break;
              }  
              Matcher m = p.matcher(s[j]);
              
        while (m.find()){
            count +=1;
            temp++;
        }
            vectors[0][i][j] = i;
            vectors[1][i][j] = temp;
            temp = 0;
}
          }
          
          /*for (int i = 0; i < s.length; i++) {
              for(int j=0;j<key.length;j++){
              System.out.println("Mail: "  + i + " keyword: " + j + " count" +  vectors[1][j][i]);
              
              }
              
          }*/
        
        return count;
    }
    
}