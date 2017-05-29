import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SwingMeter {
	
	private Constituency c;
	private static Map<String, Constituency> constit;
	private static CSVParser csv;

	SwingMeter()
	{
		constit = new TreeMap<String, Constituency>();		
	}
	
	public static void main(String[] args) throws Exception {
		CSVParser.main(args);
		for(Map.Entry<String, Constituency> entry : constit.entrySet())
		{
			String key = entry.getKey();
			Constituency c = entry.getValue();
			System.out.println("Constituency: " +key+ ", " + c.getConservative15() +", "+ c.getLabour15() );
		}

	}
	
	public void putObject (String key, Constituency con)
	{
		if (constit.containsKey(key) == true)
		{
			System.out.println("Clash");
		}
		else
		{
			constit.put(key, con);
		}
	}

}
