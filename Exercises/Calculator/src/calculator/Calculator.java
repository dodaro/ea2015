package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
	
	//CREARE I SETTERS altrimenti spring non riferisce le proprietà
	
	private Operation sum;
	private Operation subtraction;
	private Operation division;
	private Operation multiplication;
	
	public Calculator() {
		// TODO Auto-generated constructor stub
	}

	public Calculator(Operation sum,Operation sub,Operation div,Operation mul) {
		// TODO Auto-generated constructor stub
		this.sum=sum;
		this.subtraction=sub;
		this.division=div;
		this.multiplication=mul;
	}
	
	public void getParameter(){

		String operation = null;
		double a=0;
		double b=0;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please insert operation name : ");
        try {
            operation = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } 
       
        System.out.print("Please insert first number : ");
        try {
            a = Double.parseDouble(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        System.out.print("Please insert second number : ");
        try {
            b = Double.parseDouble(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        this.performCalculation(a, b, operation);
        
	}
	
	public double performCalculation(double a, double b, String operation) {
		
		double result=0;
		switch (operation) {
        
        case "sum":
        	result=this.sum.operation(a, b);
        	break;
        case "division":
        	if(b==0){
        		System.out.println("ERROR, impossible operation");
        		return 0;
        	}
        	result=this.division.operation(a, b);
        	break;
        case "multiplication":
        	result=this.multiplication.operation(a, b);
        	break;
        case "subtraction":
        	result=this.subtraction.operation(a, b);
        	break;
        
        }
		
		System.out.println("Your result:"+result);
		return 0;
	}
	
	public Operation getSum() {
		return sum;
	}

	public void setSum(Operation sum) {
		this.sum = sum;
	}

	public Operation getSubtraction() {
		return subtraction;
	}

	public void setSubtraction(Operation subtraction) {
		this.subtraction = subtraction;
	}

	public Operation getDivision() {
		return division;
	}

	public void setDivision(Operation division) {
		this.division = division;
	}

	public Operation getMultiplication() {
		return multiplication;
	}

	public void setMultiplication(Operation multiplication) {
		this.multiplication = multiplication;
	}
}
