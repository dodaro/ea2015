package spring;

/*
 * Classe ignorante che ha il solo scopo di aggiungere un ulteriore livello di dettaglio
 * SCOPO DIDATTICO
 */
public class Number
{
	private double value;

	public Number()
	{}

	public Number(double value)
	{
		this.value = value;
	}

	public double getValue()
	{
		return value;
	}

	public void setValue(double value)
	{
		this.value = value;
	}
}