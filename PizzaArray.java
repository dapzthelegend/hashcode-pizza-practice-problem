package pizza;


import java.io.File;
import java.util.Scanner ;
class PizzaArray{
    int mRow ;
    int mCol;
    int mCells;
    File file;
    static String theString ="";
    String string;
    char array[];
    char pizzaArray[][];

PizzaArray(String f, int row, int col){
    file = new File(f);

    mRow = row;
    mCol = col;
    mCells = mRow * mCol;
    array= new char[mCells];
    string = readFiles(file);
    array = theString.toCharArray();
    pizzaArray= new char[mRow][mCol];
}


public static String readFiles(File f){
    try{
    Scanner scanner= new Scanner(f);
    theString = scanner.nextLine();
    while(scanner.hasNextLine()){
    theString = theString + "\n" + scanner.nextLine();
    }
    return theString;
    
    }
    catch(Exception e){
        System.out.println(e);
        return null;

    }
}

public void printString(){
    System.out.println(array);
    System.out.println(array.length);


}

public char[][] convertArray(){
    int i = 0;
    int j =0;
            for (char x:array){
                if(x != '\n'){

                    for (; i<mRow;){
                        for (; j<mCol;){
                            pizzaArray[i][j]= x;
                            break;

                        }
                        break;
                    }
                    if(j<mCol) j++;
                    if(j ==(mCol)) {
                        j=0  ;
                        if(i<mRow){
                            i++;
                        }

                    }
            
                }
            }
    
  
    return pizzaArray;
    
}


}