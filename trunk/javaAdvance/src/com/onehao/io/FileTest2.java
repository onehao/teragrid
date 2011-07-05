package com.onehao.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class FileTest2
{
	public static void main(String[] args) throws IOException, URISyntaxException
	{
		File file = new File("./gen");
		
		File file2 = new File(file,"hello.txt");
		
		file2.createNewFile();
		
		File file3 = new File("./gen", "h");
		file3.createNewFile();
		
		
		System.out.println(file.pathSeparator);
		System.out.println(file.separator);
		
		String str = "/gen1/gen2/gen3/gen4/gen5/gen6/gen6";
		System.out.println(str.lastIndexOf("/"));
		
		File myFile = new File("gen/c11/a21/a31/a41");
		
		System.out.println(myFile.getParent());
		
		URI uri = new URI("http://localhost/gen/");
//		File uriFile = new File(uri);
//		
//		System.out.println(uriFile.listFiles().length);
		
		System.out.println(uri.getSchemeSpecificPart());
		
	}
}
