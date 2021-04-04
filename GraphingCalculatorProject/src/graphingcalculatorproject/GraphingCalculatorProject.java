//GraphingCalculator
//Nivetha Sathish
package graphingcalculatorproject;

import java.util.Scanner;

public class GraphingCalculatorProject {

    public static double[] getCoefficient() { //method that gets coefficient from user
        Scanner keyboard = new Scanner(System.in);

        double[] coefficient = new double[6];//create an array to hold the coefficients
        System.out.println("Please enter the coefficients and constant for your function");

        for (int counter = 0; counter < coefficient.length; counter++) {

            if (counter == 0) {
                System.out.print("Coefficient for x^5: ");
            } else if (counter == 1) {
                System.out.print("Coefficient for x^4: ");
            } else if (counter == 2) {
                System.out.print("Coefficient for x^3: ");
            } else if (counter == 3) {
                System.out.print("Coefficient for x^2: ");
            } else if (counter == 4) {
                System.out.print("Coefficient for x^1: ");
            } else if (counter == 5) {
                System.out.print("Coefficient for x^0: ");
            } //END OF IF STATEMENT

            coefficient[counter] = keyboard.nextDouble(); // let user type in the coefficient they want

        }//END OF FOR LOOP       

        
        return coefficient;

    }//END OF getCoefficient METHOD

    public static int calcYval(int xVal, double newCoefficient[]) {//returns the y value

        //running sum that accumulates total of each coefficient times x to the corresponding power
        double yVal = 0;
        double exponent = 5;

        for (int count = 0; count < 6; count++) {
            yVal = yVal + newCoefficient[count] * Math.pow((double) xVal, exponent); //calculate y value
            exponent = exponent - 1;
        }

        return (int) yVal;

    }//END OF calcYcal METHOD

    public static char[][] createGraph() {

        char[][] graphPaper = new char[21][21]; //array that receives the updated versions of the graph

        //FILL UP THE ARRAY WITH SPACES
        for (int column = 0; column <= 20; column++) {
            for (int row = 0; row <= 20; row++) {
                graphPaper[column][row] = ' ';
            }
        }

        //X AXIS
        for (int xAxisCounter = 0; xAxisCounter <= 20; xAxisCounter++) {
            graphPaper[xAxisCounter][10] = '-'; //columns 0-10 and row 10
        }

        //LEFT X AXIS SCALE                
        String leftXAxisScale = "987654321";
        int xAxisNumCounter = 1;
        for (int scale = 0; scale <= 8; scale++) {
            graphPaper[xAxisNumCounter][11] = leftXAxisScale.charAt(scale);
            xAxisNumCounter = xAxisNumCounter + 1;
        }

        //RIGHT X AXIS SCALE
        String rightXAxisScale = "123456789";
        int xAxisSecondNumCounter = 11;
        for (int scale = 0; scale <= 8; scale++) {
            graphPaper[xAxisSecondNumCounter][11] = rightXAxisScale.charAt(scale);
            xAxisSecondNumCounter = xAxisSecondNumCounter + 1;
        }

        //TOP Y AXIS
        for (int yAxisCounter = 0; yAxisCounter <= 9; yAxisCounter++) {
            graphPaper[10][yAxisCounter] = '|';
        }

        //BOTTOM Y AXIS
        for (int yAxisCounter = 11; yAxisCounter <= 20; yAxisCounter++) {
            graphPaper[10][yAxisCounter] = '|';
        }

        //TOP Y AXIS SCALE
        String topYAxisScale = "987654321";
        int yScaleCounter = 1;
        for (int scale = 0; scale <= 8; scale++) { //decrease the scale's number until it's 1
            graphPaper[9][yScaleCounter] = topYAxisScale.charAt(scale); //have the appropriate number be in the array
            yScaleCounter++;
        }

        //BOTTOM Y AXIS SCALE
        String bottomYAxisScale = "123456789";
        int yScaleBottomCounter = 11;
        for (int scale = 0; scale <= 8; scale++) { //decrease the scale's number until it's 1
            graphPaper[9][yScaleBottomCounter] = bottomYAxisScale.charAt(scale); //have the appropriate number be in the array
            yScaleBottomCounter++;
        }

        //BOTTOM NEGATIVE SIGNS FOR THE BOTTOM Y AXIS
        for (int bYNegative = 12; bYNegative <= 19; bYNegative++) {
            graphPaper[8][bYNegative] = '-';
        }

        return graphPaper;

    } //END OF createGraph METHOD

    public static char[][] plotGraph(char theGraph[][], double coefficient[]) {

        int yValue = 0;
        int xCoordinate = 0;
        
        for (int xValue = -10; xValue <= 10; xValue++) {
            yValue = calcYval(xValue, coefficient); //gets corresponding y-value            

            if ((yValue >= -10) && (yValue <= 10)) { //if the yValue is able to be plotted within the graph
                switch (yValue) {
                    case 9:
                        //change y values into column number
                        yValue = 1;
                        break;
                    case 10:
                        yValue = 0;
                        break;
                    case 8:
                        yValue = 2;
                        break;
                    case 7:
                        yValue = 3;
                        break;
                    case 6:
                        yValue = 4;
                        break;
                    case 5:
                        yValue = 5;
                        break;
                    case 4:
                        yValue = 6;
                        break;
                    case 3:
                        yValue = 7;
                        break;
                    case 2:
                        yValue = 8;
                        break;
                    case 1:
                        yValue = 9;
                        break;
                    case 0:
                        yValue = 10;
                        break;
                    case -1:
                        yValue = 11;
                        break;
                    case -2:
                        yValue = 12;
                        break;
                    case -3:
                        yValue = 13;
                        break;
                    case -4:
                        yValue = 14;
                        break;
                    case -5:
                        yValue = 15;
                        break;
                    case -6:
                        yValue = 16;
                        break;
                    case -7:
                        yValue = 17;
                        break;
                    case -8:
                        yValue = 18;
                        break;
                    case -9:
                        yValue = 19;
                        break;
                    case -10:
                        yValue = 20;
                        break;
                    default:
                        break;
                }
                theGraph[xCoordinate][yValue] = '*';

            } 

            xCoordinate = xCoordinate + 1;
        }
        //check if it's on the graph and plot it by changing the array

        return theGraph;

    } //END OF PLOT GRAPH METHOD    

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        char createNew = 'y';

        while (createNew == 'y') {

            System.out.println(" ");
            int integerExpression = 0;

            double[] newCoefficient = getCoefficient(); //Define array to store coefficients and constant
            double val = 0;
            int counterZero = 0;
            String formatStr = "";

            for (int newCounter = 0; newCounter < newCoefficient.length; newCounter++) {
                val = newCoefficient[newCounter];

                if (newCounter == 0) {
                    integerExpression = 5;
                } else if (newCounter == 1) {
                    integerExpression = 4;
                } else if (newCounter == 2) {
                    integerExpression = 3;
                } else if (newCounter == 3) {
                    integerExpression = 2;
                } else if (newCounter == 4) {
                    integerExpression = 1;
                } else {
                    integerExpression = 0;
                } //END OF IF STATEMENT

                if (newCounter == 0) {
                    System.out.print("y = ");
                }
                if (val == 0) { //count how many coefficients are zeroes
                    counterZero++;
                }

                if (newCoefficient[newCounter] != 0) { //if the coefficient is not equal to 0

                    if (integerExpression == 0) {//if the exponent = 0, don't print x
                        formatStr = "%5.2f";
                        if (newCoefficient[newCounter] > 0) {
                            formatStr = "+%5.2f";
                        }
                    } else if (integerExpression == 1) {//if the exponent = 1, don't print ^1                     
                        if (newCoefficient[newCounter + 1] == 0) {
                            formatStr = "%5.2fx";
                        } else if (newCoefficient[newCounter + 1] < 0) {
                            formatStr = "%5.2fx"; //if the # after this is -, it works, if it's +, no + appears
                        } else if (newCoefficient[newCounter + 1] > 0) {
                            formatStr = "%5.2fx+";
                        } else if (newCoefficient[newCounter] > 0) {
                            formatStr = "%5.2fx+";
                        }

                    } else {//if the exponent is not 0

                        if (newCoefficient[newCounter + 1] > 0) { //if the coefficient in front of the current one is greater than 0, add a plus sign
                            formatStr = "%5.2fx^%d+";
                        } else if (newCoefficient[newCounter + 1] <= 0) { //if the coefficient in front of the current one is less than 0, do not add a plus sign
                            formatStr = "%5.2fx^%d";
                        }
                    }
                    if(newCoefficient[newCounter]==1){ //if the coefficient is 1
                        if(integerExpression!=1){//if the exponent if not 1
                        System.out.printf("x^%d", integerExpression); //print the exponent
                        }
                        
                        if(integerExpression==1){ //if the exponent is 1
                            System.out.printf("x"); //do not print the exponent
                        }
                        
                    } else if(newCoefficient[newCounter]==-1){
                        System.out.printf("-x^%d+", integerExpression);
                    }
                    
                    else{
                        
                    System.out.printf(formatStr, val, integerExpression);
                    
                    }
                    
                } else if (counterZero == 6) { //if all coefficients are 0, print out y=0
                    System.out.println("0.00");
                }

            } //END OF FOR LOOP

//START OF GRAPHING
            System.out.println(" ");
            System.out.println(" ");

            for (int xValCount = -10; xValCount <= 10; xValCount++) { //test values from -10 to 10
                System.out.print("For an x value of ");
                System.out.print(xValCount);
                System.out.print(", y = ");
                System.out.println(calcYval(xValCount, newCoefficient));
            }

            char[][] graphPaperMain = plotGraph(createGraph(), newCoefficient); //array that receives the updated versions of the graph

            System.out.println();

            for (int r = 0; r <= 20; r++) {

                for (int c = 0; c <= 20; c++) {
                    System.out.print(graphPaperMain[c][r]); //print out the graph
                }
                System.out.println();//start printing on next line
            }

            System.out.print("Would you like to create another graph? Type y to create another one or type n to finish: ");
            createNew = keyboard.next().charAt(0);//let the user create a new graph or leave, if the user decides to create a new graph, the program will ask for new coefficients, if not the commands below will execute     
            if (createNew == 'n') {//if the user decides not to create a new graph, good day message will be shown
                System.out.println(" ");
                System.out.print("Have a good day!");
            }

        }

    }//END OF PUBLIC STATIC VOID
} //END OF PUBLIC CLASS 

