package spring;

public class Operation
{
	private Number a;
	private Number b;
	private Operator operator;

	public Operation()
	{}

	public Operation(Number a, Number b, Operator operator)
	{
		this.a = a;
		this.b = b;
		this.operator = operator;
	}

	public Number getFirstNumber()
	{
		return a;
	}

	public void setFirstNumber(Number a)
	{
		this.a = a;
	}

	public Number getSecondNumber()
	{
		return b;
	}

	public void setSecondNumber(Number b)
	{
		this.b = b;
	}

	public Operator getOperator()
	{
		return operator;
	}

	public void setOperator(Operator operator)
	{
		this.operator = operator;
	}
}
