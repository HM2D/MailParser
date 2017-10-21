
package mail.parser;

import com.sun.jndi.toolkit.dir.SearchFilter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.*;
import java.lang.*;
        

public class MailParser {
    public static void main(String[] args) throws IOException {
         int[] ham= new int[1000];
         int[] spam= new int[1000];
         int[] undefined = new int[1000];
         int hamcount=0;
         int spamcount=0;
         int uncount=0;
        Search search=new Search();
        String[] Mails=new String[1000];
        String[] Mails2=new String[1000];
        String[] Mails3=new String[290];
        String[] keywords = new String[1000];
        File directory = new File("c:/bare/part6");
        File[] listOfFiles = directory.listFiles();
        File[] array;
        int[][][] Vectors= new int[2][1000][1000];
        int[][][] SparsedVector = new int [2][668][1000];
          Search S = new Search();
          Sparse Sp = new Sparse(); 
          Parser P = new Parser();
        double arccos=0; 
        String filename = "C:/keywords.txt";
         try{
            MailParser file = new MailParser(filename);
            keywords = file.OpenFile();
         int i;
           
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }  
        
        try{
        int c=0;
       // array=nwe File[];
        array=directory.listFiles();
        for(int k=0;k<array.length;k++){
            File path=array[k];
            FileReader fr = new FileReader(path);
       BufferedReader br = new BufferedReader(fr);
       String s = " ";
        for(int m=0;m<Mails.length;m++){
       while (br.ready()) {
           Mails[c++] = br.readLine();
       }
       }
           
        }
        }catch(IOException e){
             System.out.println(e.getMessage());
        }
        int mailcounter=0;
        int ml=0;
        for (int i = 0; i < 990; i=i+3) {
            Mails[i]= Mails[i] + Mails[i+2];
            Mails2[mailcounter] = Mails[i];
            mailcounter++;
        }
        for (int i = 0; i < 290; i++) {
            Mails3[i] = Mails2[i];
        }
         /*for(int j=0;j<keywords.length;j++){
          
           System.out.println(keywords[j] + " Count:" + S.SearchFile(Mails, keywords[j],j));
            
          }*/
        for (int i = 0; i < 290; i++) {
            System.out.println("Mail number:" + i + "  " + Mails3[i]);
        }
        for (int i = 0; i < listOfFiles.length; i++) {
            System.out.println(listOfFiles[i].getName()); 
        }
        
        for (int i = 0; i < 668; i++) {
            System.out.println("Keyword number: " + i + " Keyword: " + keywords[i]);
        }
         S.SearchFile(Mails3, keywords);
         Vectors = S.returnVector();
         SparsedVector = Sp.parser(Vectors);
         int counter=0;
         LinkedList[] L = new LinkedList[1000];
         for (int i = 0; i < 290; i++) {
             L[i] = new LinkedList(SparsedVector,i);
            L[i].add(SparsedVector, i);
        }
         
        for (int i = 0; i < 290; i++) {
        }
        for (int i = 0; i < 290; i++) {
            System.out.println("  Mail: " + i);
           L[i].tostring();
            System.out.println("------------------------------------------------------------------------------------");
        }
         int counterm=0;
         int flaghami=0;
         int flaghamj=0;
         int flagspami=0;
         int flagspamj=0;
         for (int i = 0; i < 290; i++) {
             for (int j = i; j < 290 ; j++) {
           
                // System.out.println(P.Parsing(L[i].returnnode(), L[j].returnnode(), L[i].lengthofnode(), L[j].lengthofnode()));
            arccos =  P.Parsing(L[i].returnnode(), L[j].returnnode(), L[i].lengthofnode(), L[j].lengthofnode());
            if(Double.isNaN(arccos))
            {   continue;
            }/*
            if(arccos>  1.4)
            {
                for (int k = 0; k < hamcount; k++) {
             if(ham[k]==i)
             {
              flagi=1;   
             }
              if(ham[k]==j){flagj=1;}
              
                }
             if(flagi==0)
             {
                 ham[hamcount++]=i;
             }
             if(flagj==0){ham[hamcount++]=j;}
             flagj=0;
             flagi=0;
            }*/
            //if(arccos==0){undefined[uncount++]=i;}
         
            if(arccos>1.32){
                for (int k = 0; k < hamcount; k++) {
                    if(ham[k]==i)
                    {
                     flaghami=1;
                    }
                   
                }
                for (int k = 0; k < spamcount; k++) {
                    if(spam[k]==i)
                    {
                     flagspami=1;
                    }
                   
                }
                for (int k = 0; k < hamcount; k++) {
                    if(ham[k]==j)
                    {
                     flaghamj=1;
                    }
                   
                }
                for (int k = 0; k < spamcount; k++) {
                    if(spam[k]==j)
                    {
                     flagspamj=1;
                    }
                   
                }
                
                if((flaghami==0)&&(flagspami==0)&&(flaghamj==0)&&(flagspamj==0))
                {
                  ham[hamcount++]=i;
                  spam[spamcount++]=j;
                
                }
                
                if((flaghami==0)&&(flagspami==0)&&(flaghamj==0)&&(flagspamj==1))
                {
                    ham[hamcount++]=i;
                }
                if((flaghami==0)&&(flagspami==0)&&(flaghamj==1)&&(flagspamj==0))
                {
                   spam[spamcount++]=i;
                }
                if((flaghami==0)&&(flagspami==0)&&(flaghamj==1)&&(flagspamj==1))
                {
                 //   System.out.println("No");
                }
                
                if((flaghami==0)&&(flagspami==1)&&(flaghamj==0)&&(flagspamj==0))
                {
                    ham[hamcount++]=j;
                }
                
                if((flaghami==0)&&(flagspami==1)&&(flaghamj==0)&&(flagspamj==1))
                {
                  //  System.out.println("Ok");
                }
                if((flaghami==0)&&(flagspami==1)&&(flaghamj==1)&&(flagspamj==0))
                {
                //    System.out.println("Ok");
                }
               
                if((flaghami==0)&&(flagspami==1)&&(flaghamj==1)&&(flagspamj==1))
                {
                 //   System.out.println("No");
                }
               
                if((flaghami==1)&&(flagspami==0)&&(flaghamj==0)&&(flagspamj==0))
                {
                    spam[spamcount++]=j;
                }
               
                if((flaghami==1)&&(flagspami==0)&&(flaghamj==0)&&(flagspamj==1))
                {
                 //   System.out.println("OK");
                }
               
                if((flaghami==1)&&(flagspami==0)&&(flaghamj==1)&&(flagspamj==0))
                {
               //     System.out.println("OK");
                }
               
                if((flaghami==1)&&(flagspami==0)&&(flaghamj==1)&&(flagspamj==1))
                {
                //   System.out.println("No");
                 }
               
                if((flaghami==1)&&(flagspami==1)&&(flaghamj==0)&&(flagspamj==0))
                {
                 //   System.out.println("No");
                }
               
                if((flaghami==1)&&(flagspami==1)&&(flaghamj==0)&&(flagspamj==1))
                {
                 //   System.out.println("No");
                }
               
                if((flaghami==1)&&(flagspami==1)&&(flaghamj==1)&&(flagspamj==0))
                {
                //   System.out.println("No");
                }
               
                if((flaghami==1)&&(flagspami==1)&&(flaghamj==1)&&(flagspamj==1))
                {
                 //   System.out.println("No");
                }
                flaghami=0;
                flaghamj=0;
                flagspami=0;
                flagspamj=0;
         
            }
             }
        }
         int flg=0;
         /*for (int e = 0; e < 290; e++) {
             for(int i=0;i<hamcount;i++) {  
             if(ham[i]== e){
                flg=1;
                break;
             }
             }
             if(flg==0)
             { spam[spamcount++]=e;
             }
             flg=0;
        }*/
        /* for (int i = 0; i < hamcount; i++) {
             System.out.println("Ham: ");
             System.out.println(ham[i]);
        }*/
         System.out.println("//////////////////////////////////////////////////////////////////////////////////");
         
         /*for (int i = 0; i < spamcount; i++) {
             System.out.println("Spam: ");
             System.out.println(spam[i]);
        }*/
         System.out.println("Ham: "+hamcount);
         System.out.println("Spam: " + (290-hamcount) );
         //for (File file : listOfFiles) {
   // if (file.isFile()) {
     //   System.out.println(file.getName());
   // }
//}
    }
    private String path;
    public MailParser(String Fp){
     path = Fp;
    }
    public String[] OpenFile() throws IOException{
      FileReader Fr = new FileReader(path);
      BufferedReader textReader = new BufferedReader(Fr);
      int Nuline = readLines();
      String[] textData = new String[Nuline];
      int i;
        for (int j = 0; j < Nuline; j++) {
            textData[j] = textReader.readLine();
        }
        textReader.close();
        return textData;
    }
    int readLines() throws IOException{
      FileReader myfile = new FileReader(path);
      BufferedReader bf = new BufferedReader(myfile);
      String Aline;
      int Nuline = 0;
      while ((Aline = bf.readLine()) != null){
        Nuline++;
    }
      bf.close();
      return  Nuline;
    }
    
}
  