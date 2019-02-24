package pizza;


//this is the class to run the program

class PizzaDemo{
    public static void main(String args[]){
//pass the input file link to PizzaArray Constructor
   PizzaArray pArr = new PizzaArray("C:\\Users\\wicho\\Downloads\\d_big.in",1000,1000);
   String s = "big3_pizza.in";

   //create new class Pizza
   Pizza myPizza = new Pizza(pArr.convertArray(),1000,1000,6,14,s);
    myPizza.slice();
   
   

    
   
}
    
}

