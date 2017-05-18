package com.algo.assign;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class LZWEncoder {

	private static int MAX_TABLE_SIZE;
	private static int BIT_LEN;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br = null;
		Map<String, Integer> table = new HashMap<String, Integer>();
		String STRING = "";
		char SYMBOL;
		String OUTPUT = "";

		// get the bit length from argument
		if (null != args[3] && args[3].length() > 0) {
			BIT_LEN = Integer.parseInt(args[3]);
		}

		MAX_TABLE_SIZE = (int) Math.pow(2, BIT_LEN);

		// Initialize the table
		for (int i = 0; i < 256; i++) {

			table.put(Character.toString((char) i), i);
		}

		if (null != args[2] &&
		// lenght > 4 because a.txt will be shortest filename
				args[2].length() > 4 &&
				// check if arguments have the correct file extension
				args[2].endsWith(".txt")) {
			try {
				br = new BufferedReader(new FileReader(args[2]));

				char[] symbols = br.readLine().toCharArray();

				for (int j = 0; j < symbols.length; j++) {

					SYMBOL = symbols[j];
					String tempKey = STRING + Character.toString(SYMBOL);
					if (table.containsKey(tempKey)) {
						STRING = tempKey;
					} else {

						System.out.print(table.get(STRING) + ", ");
						OUTPUT = OUTPUT + table.get(STRING) + " ";

						if (table.size() < MAX_TABLE_SIZE) {
							table.put(STRING + SYMBOL, table.size());
						}

						STRING = Character.toString(SYMBOL);

					}

				}
				System.out.print(table.get(STRING) + ", ");
				OUTPUT = OUTPUT + table.get(STRING) + " ";

				/*
				 * byte[] outBin = OUTPUT.getBytes("UTF-16");
				 * //System.out.println(outBin);
				 * 
				 * for(byte b : outBin){
				 * System.out.println(Integer.toBinaryString(b)); }
				 */

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//			System.out.println();
//			System.out.println("OUTPUT " + OUTPUT);
			// System.out.println("Binary :" + Integer.toBinaryString(OUTPUT,
			// "UTF-16BE"));

			byte[] outBin;
			try {
				
				
				System.out.println(OUTPUT);
				BufferedWriter bw = new BufferedWriter(
						new FileWriter(args[2].substring(0, args[2].indexOf(".")) + ".lzw"));
				
					String[] mainData = OUTPUT.split(" ");
					for(String s : mainData){
						System.out.print(String.format("%016d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(s)))) + " ");
						bw.write(String.format("%016d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(s)))) + " ");
							
					}	
					
					bw.flush();
				
//				outBin = OUTPUT.getBytes("UTF-16BE");
//				
//
//				System.out.println(args[2].substring(0, args[2].indexOf(".")));
				
//				
//
//				for (byte b : outBin) {
//					System.out.println(b);
//					bw.write(Integer.toBinaryString(b) + " ");
//
//				}
				
//				bw.flush();

			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println(outBin);
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/*
			 * System.out.println(); System.out.println(OUTPUT);
			 */
		}

	}

}
