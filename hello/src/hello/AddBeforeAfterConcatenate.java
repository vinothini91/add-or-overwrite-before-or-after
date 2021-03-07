package hello;

import java.io.BufferedOutputStream;
import static java.nio.file.StandardOpenOption.APPEND;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AddBeforeAfterConcatenate {

	public static void main(String[] args) {
		String filename = null;

		String useroption = null;

		String userbeforeOrAfter = null;

		String userinput1 = null;

		String userinput2 = null;

		InputStreamReader ir = new InputStreamReader(System.in);

		BufferedReader br = new BufferedReader(ir);

		System.out.println("Get file name as input from user:");

		try {

			filename = br.readLine(); // get file name as input from user

			filename = filename + ".txt";

			System.out.println(filename);

			File f = new File(filename);

			Path p = Paths.get(filename);

			boolean present = f.exists();

			System.out.println("File exists:" + present);

			if (!present)

			{

				boolean filecreate = f.createNewFile(); // file not exist,so create

				if (filecreate)

					System.out.println("file created");

			}

			System.out.println("To add New content in file Type keyword append:");

			useroption = br.readLine();

			if (useroption.equalsIgnoreCase("append"))

			{

				OutputStream out = new BufferedOutputStream(Files.newOutputStream(p, APPEND));

				System.out.println("Type your data to append in the file"); // get input from user

				userinput1 = br.readLine();

				byte[] data = userinput1.getBytes();

				out.write(data);

				out.close();

				// }

				// StringBuilder sb = new StringBuilder(); // Read a file and store it into a
				// string variable

				String strLine = "";

				String strdata = "";

				BufferedReader brr = new BufferedReader(new FileReader(filename));

				while (strLine != null)

				{

					if (strLine == null)

						break;

					strdata += strLine;

					strLine = brr.readLine();

				}

				System.out.println("FILE DATA:" + strdata);

				brr.close();

				System.out.println("Type before or after to append data:");

				userbeforeOrAfter = br.readLine();

				if (userbeforeOrAfter.equalsIgnoreCase("before"))

				{

					System.out.println("Type your input to be added:");

					OutputStream out2 = new BufferedOutputStream(Files.newOutputStream(p, APPEND));

					userinput2 = br.readLine();

					byte[] data2 = userinput2.getBytes();

					out2.write(data2);

					out2.close();

					/*
					 * OutputStream outoverwrite = new
					 * BufferedOutputStream(Files.newOutputStream(p)); // overwrite file
					 * 
					 * System.out.println("overwrite in existing file");
					 * 
					 * strdata=br.readLine();
					 * 
					 * byte[] dataoverwrite = strdata.getBytes();
					 * 
					 * outoverwrite.write(dataoverwrite);
					 * 
					 * outoverwrite.close();
					 */

					String concat = "";

					// concat=strdata+" "+userinput2;
					concat = userinput2 + concat + strdata;

					System.out.println("concat:" + concat);

					// String s = " This line will be written in File";

					/*
					 * System.out.println("Writing to File : " + concat);
					 * 
					 * FileWriter outFile = new FileWriter(filename);
					 * 
					 * BufferedWriter bWriter = new BufferedWriter(outFile);
					 * 
					 * bWriter.write(concat);
					 * 
					 * 
					 * 
					 * OutputStream ovwrite = new
					 * BufferedOutputStream(Files.newOutputStream(p,APPEND));
					 * 
					 * concat=br.readLine();
					 * 
					 * byte[] dataconcat = concat.getBytes();
					 * 
					 * ovwrite.write(dataconcat);
					 * 
					 * ovwrite.close();
					 */

					// System.out.println("FILE READING WITH NEW CONTENT");

					FileWriter fwrite = new FileWriter(f.getAbsoluteFile());

					BufferedWriter bw = new BufferedWriter(fwrite);

					bw.write(concat);

					bw.close();

					// InputStream input1 = Files.newInputStream(p);

					// BufferedReader reader = new BufferedReader(new InputStreamReader(input1));

					BufferedReader in = new BufferedReader(new FileReader(f));

					String linenew = null;

					while ((linenew = in.readLine()) != null)

					{

						System.out.println("Read the file:" + linenew);

					}

				}

			}

		}

		catch (Exception e)

		{

			e.printStackTrace();

			// System.out.println("exception"+e);

		}

	}

}
