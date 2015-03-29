import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	
	String[] laguContainer;
	String nada = "";
	int n = 0;
	private Scanner stdin;
	
	String[] tabelNada = new String[24];
	
	public Main()
	{		
		tabelNada[0] = "c.";
		tabelNada[1] = "c#";
		tabelNada[2] = "d.";
		tabelNada[3] = "d#";
		tabelNada[4] = "e.";
		tabelNada[5] = "f.";
		tabelNada[6] = "f#";
		tabelNada[7] = "g.";
		tabelNada[8] = "g#";
		tabelNada[9] = "a.";
		tabelNada[10] = "a#";
		tabelNada[11] = "b.";
		
		tabelNada[12] = "C.";
		tabelNada[13] = "C#";
		tabelNada[14] = "D.";
		tabelNada[15] = "D#";
		tabelNada[16] = "E.";
		tabelNada[17] = "F.";
		tabelNada[18] = "F#";
		tabelNada[19] = "G.";
		tabelNada[20] = "G#";
		tabelNada[21] = "A.";
		tabelNada[22] = "A#";
		tabelNada[23] = "B.";
		
	}
	
	private int putParamOnRange(int param)
	{
		int ret = 0;
		
		if(param <= 1)
		{
			ret = 1;
		}
		else if(param >= 100)
		{
			ret = 100;
		}
		else
		{
			ret = param;
		}
		
		return ret;
	}
	
	public void readInput()
	{
		stdin = new Scanner(new BufferedInputStream(System.in));
		
		nada = stdin.next();
		n = putParamOnRange(stdin.nextInt());
		
		laguContainer = new String[n];
		
		for(int row = 0; row < n; row++)
		{
			laguContainer[row] = stdin.next();
		}
	}
	
	public void processInput()
	{
		int res = searchNadaOnContainer();
		if(res != -1)
		{
			System.out.println(res+1);
		}
		else
		{
			System.out.println("#");
		}
		
	}
	
	private int searchNadaOnContainer()
	{
		boolean found = false;
		int row = 0;
		int ret = -1;
		String patternNada = getPattern(nada);
		
		while(!found && row < n)
		{
			if(getPattern(laguContainer[row]).contains(patternNada))
			{
				ret = row;
				found = true;
			}
			else
			{
				row++;
			}
			
			
		}
		
		return ret;
	}
	
	private int getIndex(String simbol)
	{
		/*
		 * fungsi ini asumsinya simbol selalu ketemu
		 */
		int ret = -1;
		boolean found = false;
		int row = 0;
		
		while(!found && row < 24)
		{
			if(tabelNada[row].equals(simbol))
			{
				ret = row;
				found = true;
			}
			else
			{
				row++;
			}

		}
		
		return ret;
	}
	
	private String getPattern(String lagu)
	{		
		return getPatternFromArray(tokenize(lagu));
	}
	
	private String getPatternFromArray(ArrayList<String> tmp)
	{
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < tmp.size() - 1; i++)
		{
			sb.append(getIndex(tmp.get(i+1))-getIndex(tmp.get(i)));
		}
				
		return sb.toString();
	}
	
	private ArrayList<String> tokenize(String lagu)
	{
		StringBuilder sb = new StringBuilder();
		ArrayList<String> ret = new ArrayList<>();
		
		for(int i = 0; i < lagu.length(); i++)
		{
			sb.append(lagu.charAt(i));
			if(lagu.charAt(i) == '.' || lagu.charAt(i) == '#')
			{
				ret.add(sb.toString());
				sb = new StringBuilder();
			}
		}
		
		return ret;
	}
	
	public static void main(String args[])
	{
		Main main = new Main();
		main.readInput();
		main.processInput();
	}
}
