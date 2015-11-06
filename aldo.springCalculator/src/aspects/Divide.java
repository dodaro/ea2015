package aspects;

public class Divide extends Command{

	@Override
	public int execute() {
		
		if(getVal2() == 0)
			throw new IllegalArgumentException("Val 2 is 0.");
		
		return getVal1()/getVal2();
	}

}
