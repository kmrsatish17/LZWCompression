package com.algo.assign;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class LZWDecoder {

	private static int MAX_TABLE_SIZE;
	private static int BIT_LEN;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br = null;
		Map<Integer, String> table = new HashMap<Integer, String>();
		String STRING = "";
		String NEW_STRING = "";
		String OUT_DEC= "";

		// get the bit length from argument
		if (null != args[3] && args[3].length() > 0) {
			BIT_LEN = Integer.parseInt(args[3]);
		}

		MAX_TABLE_SIZE = (int) Math.pow(2, BIT_LEN);

		// Initialize the table

		for (int i = 0; i < 256; i++) {

			table.put(i, Character.toString((char) i));
		}

		if (null != args[2]) {
			try {
				br = new BufferedReader(new FileReader(args[2]));

				String codes = br.readLine().toString();

				System.out.println("codes " + codes);
				StringTokenizer st = new StringTokenizer(codes);

				String CODE = st.nextToken();
				
				System.out.println("CODE " + CODE);
				
				STRING = table.get(Integer.parseInt(CODE, 2));
				System.out.print(STRING);
				OUT_DEC = OUT_DEC + STRING;

				while (st.hasMoreTokens()) {

					String tempTok = st.nextToken();
					if (!(table.containsKey(Integer.parseInt(tempTok, 2)))) {

						NEW_STRING = STRING + STRING.charAt(0);
					} else {

						NEW_STRING = table.get(Integer.parseInt(tempTok, 2));

					}
					System.out.print(NEW_STRING);
					OUT_DEC = OUT_DEC + NEW_STRING;
					if (table.size() < MAX_TABLE_SIZE) {

						table.put(table.size(), STRING + NEW_STRING.charAt(0));
						STRING = NEW_STRING;
					}
				}
				
				System.out.println();
				System.out.println(OUT_DEC);
				
				BufferedWriter bw = new BufferedWriter(
						new FileWriter(args[2].substring(0, args[2].indexOf(".")) + "_decoded.txt"));
				bw.write(OUT_DEC);
				bw.flush();
				

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
