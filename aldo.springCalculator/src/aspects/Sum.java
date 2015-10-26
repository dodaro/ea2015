package aspects;

public class Sum extends Command{
	

	@Override
	public int execute() {
		
		return getVal1() + getVal2();
	}
}
