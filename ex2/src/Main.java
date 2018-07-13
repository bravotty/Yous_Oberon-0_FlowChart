import java.io.*;
import exceptions.*;
public class Main
{
public static void main(String argv[]) 
{
	int IDReturn;
	if (argv.length == 0)
	{
		System.out.println("Parameter(s), Usage: java Main <*.obr>");
	}
	else
	{
		for (int i = 0; i < argv.length; i++)
		{
			OberonComplierProgram scanner = null;
			try
			{
				scanner = new OberonComplierProgram(new java.io.FileReader(argv[i]));
				while (true)
				{
					try
					{
						IDReturn = scanner.yylex();
					}
					catch (LexicalException ex)
					{
						System.out.println(argv[i]+ " : "+ex.getMessage());
						System.out.println("line : "+scanner.get_line()+", colume : "+scanner.get_column());
						System.out.println(scanner.yytext()+"\n");
						break;
					}
					if (IDReturn > 0 && IDReturn != OberonLexical.WhiteSpace);	//token is valid,do nothing]
					
					else
					{
						if (IDReturn == 0)
						{
							System.out.println("---(0)ERRORS,(0)WARNINGS---.");
							System.out.println("There is no lexical error in " + argv[i]);
							break;
						}
					}
				}
			}
			catch (java.io.FileNotFoundException e) 
			{
				System.out.println("File not found : \""+argv[i]+"\"");
			}
			catch (java.io.IOException e) 
			{
				System.out.println("IO error scanning file \""+argv[i]+"\"");
				System.out.println(e);
			}
			catch (Exception e)
			{
				System.out.println("Unexpected exception:");
				e.printStackTrace();
			}
		}
	}
}
}

