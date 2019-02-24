package pizza;

//class Pizza which handles the slicing
import java.lang.*;
import java.io.*;
class Pizza{
   
    int mRow;
    int mCol;
    int minT;
    int maxC;
    int mCells;
    
    int numT=0;
    int numM=0;
    boolean bool;
    int mSlice= 0;
    boolean mSpace;
    int counter=0;
    int count;
    int cellNum;
    char   pizza[][];
    FileOutputStream fout = null;
    Runtime r;
    

  Pizza(char[][] array,int R, int C, int L, int H,String s){
      
      pizza = array;
      mRow = R;
      mCol = C;
      minT= L;
      maxC = H;
     r = Runtime.getRuntime();
      
      try {
                               fout = new FileOutputStream(s);
             
                                 }

                           catch(FileNotFoundException e){
                               System.out.println("Cannot open File");
                               }
      }


public int cells(int a, int b, int c, int d){
    int Cells = (Math.abs((b-a)) + 1) * (Math.abs((d-c)) + 1);
    return Cells;
}

public boolean check(char[] v){
    numT=0;
    numM=0;
    
    for (char x: v){
        if(x=='T') numT = numT +1;
        if(x=='M') numM = numM +1;
        
    }
    if (numT >= minT && numM>= minT) bool = true;
    else bool = false;
     return bool;    
    
}


public char[] values(int I,int J,int K,int L){
    int u = 0;
    char values[] = new char[maxC];
    if(J>=I && L>=K){
    for(int x = I; x <= J; x++){
        for(int y=K; y<=L; y++){
            values[u] = (char) pizza[x][y];
            
            u++;
        }
    }
    }

    else if( J < I && L>=K){
    for(int x = J; x <= I; x++){
        for(int y=K; y<=L; y++){
            values[u] = (char) pizza[x][y];
            
            u++;
        }
    }
    }

     else if( J < I && L < K){
    for(int x = J; x <= I; x++){
        for(int y=L; y<=K; y++){
            values[u] = (char) pizza[x][y];
            
            u++;
        }
    }
    }

     else if((J>=I) && (L< K)){
    for(int x = I; x <= J; x++){
        for(int y=L; y<=K; y++){
            values[u] = (char) pizza[x][y];
            
            u++;
        }
    }
    }


    return values;

}

public void deletevalues(int i,int j,int k,int l){
    if(j>=i && l>=k){
    for(int x = i; x<=j; x++){
        for(int y =k; y<=l; y++){
            pizza[x][y]= ' ';
        }
    }
    }

    else if(j<i && l>=k){
        for(int x = j; x<=i; x++){
           for(int y =k; y<=l; y++){
            pizza[x][y]= ' ';
        }

    }
    }
   else if(j>=i && l<k){
       for(int x = i; x<=j; x++){
        for(int y =l; y<=k; y++){
            pizza[x][y]= ' ';
        }

   }
   }
   else if(j<i && l<k){
       for(int x = j; x<=i; x++){
        for(int y =l; y<=k; y++){
            pizza[x][y]= ' ';
        }

   }
    
}
   }

public boolean checkSpace(char[] s){
   int f=0;
   mSpace=false;
   
    for(char space:s){
        if(space==' ')f++;
        
        }
        
    
    if (f>0) mSpace =false;
    else mSpace = true;
    return mSpace;

}

//slize the pizza 

public void slice()
{
    for(int i = 0; i<mRow; i++){
        for(int j=mRow-1; j>0; j--){
            for(int k=0; k<mCol;k++){
                for(int l=mCol-1; l>0; l--){
                    counter++;
                  
                    mCells= cells(i,j,k,l);
                    
                    if(mCells<= maxC && mCells>=(2*minT)){
                       
                        char val[]= values(i,j,k,l);
                        
                        if(check(val)){
                            
                            if(checkSpace(val)){
                                deletevalues(i,j,k,l);
                               
                            mSlice = mSlice +1;

                            String source = i + " " + k + " " + j + " " + l + "\n";
                            byte buf[] = source.getBytes();
                            
                              try{
                                 fout.write(buf);
                                   }
 
                                 catch(IOException e){
                                    System.out.println("I/O Error " + e);
                                   }

                              
                            }

                        }
                        
                        
                    }
                }
               
                
            }
           
        }
       
    }
   
    
    counter();
    try{
                                    fout.close();
                                     }

                              catch(IOException e2){
                                    System.out.println(e2);
                                  }
}

  public void counter(){
     count = 0;
      for (int t=0; t<mRow; t++){
          for (int d=0; d<mCol;d++){
              if(pizza[t][d] ==' ' ) count++;

          }
      }
      cellNum = mRow * mCol;
      System.out.println(count+"/"+cellNum);
  }

}