package onehao.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CmdTest
{

	public static void main(String[] args) throws Exception
	{

		// ProcessBuilder pb = new ProcessBuilder ( "tasklist");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br2 = new BufferedReader(isr);

//		String str  = br2.readLine();
		String str;

		while (null != (str = br2.readLine()))
		{
			System.out.println(str);
			ProcessBuilder pb = new ProcessBuilder("cmd", "/c", str);

		try
		{
			Process process = pb.start();
			InputStream fis = process.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));

			String line = null;
			StringBuffer cmdout = new StringBuffer();
			while ((line = br.readLine()) != null)
			{
				cmdout.append(line).append("\n");
			}
			System.out.println(cmdout.toString().trim());
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		}
		
//		System.out.println(str);
		
//		String str = "dir";
		
	}
}