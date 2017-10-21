/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mail.parser;

import static java.lang.Math.acos;
import static java.lang.Math.sqrt;

/**
 *
 * @author HM2D
 */
public class Parser {
    double AB;
    double dA;
    double dB;
    double ma;
    double temp;
    double teta;
    public Parser(){
    AB=0;
    dA=0;
    dB=0;
    }
    double Parsing(int[][] node1,int[][] node2, int length1,int length2)
    {    
        for (int j = 0; j < length1; j++) {
            for (int i = 0; i < length2; i++) {
                
                if( node1[0][j]==node2[0][i])
                {
                 AB =+ node1[1][j]*node2[1][i];
                
                }
               }
        }
        for (int i = 0; i < length1; i++) {
           temp=+ node1[1][i]*node1[1][i];
           dA = sqrt(temp);
        }
        
        for (int i = 0; i < length2; i++) {
           temp=+ node2[1][i]*node2[1][i];
           dB = sqrt(temp);
        }
          ma = dA * dB;
          
           temp = AB/ma;
           
           teta = acos(temp);
        return teta;
        
        }
    
    }
    

