//Main.java
import java.io.*;
public class Main
{
	public static void main(String args[])throws Exception
	{
		if (args.length == 0)
		{
			System.out.println("There need a parameter(s), Usage: java Main <*.obr>");
		}
		else
		{
			for (int i = 0; i < args.length; i++) 
			{
				OberonComplierProgram oberonScanner = new OberonComplierProgram(new java.io.FileReader(args[i]));
				Parser parser=new Parser(oberonScanner);
				System.out.println(args[i] + ":");
				try
				{	
					parser.parse();
				}
				catch(Exception e)
				{
					System.out.println(oberonScanner.get_line()+" line "+ oberonScanner.get_column()+" column");
					System.out.println(e.getMessage());
				}
				System.out.println();
			}
		}
	}
}
