package com.example.project;
public class LinearCalculator{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1; 
    private int x2; 
    private int y1; 
    private int y2; 


    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coord1, String coord2){ // <--add 2 string parameters to this constructor
        int ind = coord1.indexOf(",");                 
        x1 = Integer.parseInt(coord1.substring(1, ind));  //starts from the index after "(" up to the  index of "," so that if the integer is a negative number, the negative will be stored 
        int ind2 = coord1.indexOf(")");
        y1 = Integer.parseInt(coord1.substring(ind+1, ind2));  //same thing; if y is a negative number, it will be able to store the negtaive number successfully as opposed to just coord.substring(3,5), which would only end up picking up the negative sign 
        
        int ind3 = coord2.indexOf(",");
        x2 = Integer.parseInt(coord2.substring(1, ind3));
        int ind4 = coord2.indexOf(")"); 
        y2 = Integer.parseInt(coord2.substring(ind3 + 1, ind4)); 
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int newX1){x1 = newX1;}  //sets the value into the new value in the parameter 
    public void setY1(int newY1){y1 = newY1;}
    public void setX2(int newX2){x2 = newX2;}
    public void setY2(int newY2){y2 = newY2;}


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double dist =  roundedToHundredth(Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow(y2 - y1, 2))); 
        return dist;
    }

    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        if (slope() == -999.99) {   //if the slope was undefined, there would be no y=mx+b equation; the equation would be "x ="
            return -999.99;  
        } else {
            double m = slope(); 
            int y  = y1; 
            int x  = x1; 
            double b = (y - (m * x)); 
            return roundedToHundredth(b); //using the roundedToHundreth method makes it easier than typing "* 100.0/100.0" each time 
        }
        
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        if ((x2 - x1) == 0 ) {
            return -999.99; 
        } else {
            double slope = (double)(y2 - y1)/(x2 - x1); //since the coordinates are all itnegers, an integer/integer would result in an integer, so adding "(double)" would make y2-y1 a double and diving that by an integer would result in a double 
            return roundedToHundredth(slope);
        }
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        if (slope() == -999.99){
            return "undefined"; 
        } else if (slope() == 0){
            return "y=" + yInt();
        } else if (yInt() == 0) {
            return "y=" + slope() + "x";
        } else if (yInt() < 0){
            return "y=" + slope() + "x" + yInt();  //if the y-int is a negative number, it would not work if an "+" was printed after the "x"
        } else {
            return "y=" + slope() + "x+" + yInt();
        }

    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        double hundredth = Math.round(x * 100.0) / 100.0;   //rounding to the nearest hundreth is required in a lot of the other methods, it would be easier to make this method to round so that everytime, we will only need to call it 
        return hundredth;          
    }

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1  + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
 
        return str;
    }



}