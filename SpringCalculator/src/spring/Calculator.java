package spring;

public class Calculator
{
	private Operation operation;

	public Calculator()
	{}

	public Calculator(Operation operation)
	{
		this.operation = operation;
	}
	
	public Operation getOperation()
	{
		return operation;
	}

	public void setOperation(Operation operation)
	{
		this.operation = operation;
	}

	public double performCalculation()
	{
		double a = operation.getFirstNumber().getValue();
		double b = operation.getSecondNumber().getValue();
		Operator operator = operation.getOperator();
		switch (operator)
		{
			case SUM:
				return a + b;
			case SUBTRACTION:
				return a - b;
			case DIVISION:
				return (b != 0) ? a / b : 0;
			case MULTIPLICATION:
				return a * b;
		}
		return 0;
	}
}