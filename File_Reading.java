import java.io.*;
import java.util.regex.*;


class Data{
	String date, time, sale, rating, amount, issue, pop, net, comment;
	
}
public class File_Reading {
	
	public static void main(String[] args) {
		 File file = new File("/home/sourav/Documents/Finance/library/test1.txt");
		 try{
		 BufferedReader in = new BufferedReader(new FileReader(file));
		 String line = "", first_word = "";
		 String[] columns;
		 Pattern p = Pattern.compile("[0-9]+/[0-9]+");
		 
		 String date= "", time="", sale ="", rating="", amount="", issue="", pop="", 
				 net="", comment="";
		 int count =1;
		 
		 // Create Data object
		 Data data = new Data();
		 BuildExcel buildExcel = new BuildExcel("/home/sourav/Documents/Finance/library/output1.xlsx"); 
		 File_Reading obj = null;
		 while((line = in.readLine()) != null){
			 
			 columns = line.split("[$][$]");
			 
			 columns = trimValues(columns);
			 
			 // Check if this a first line for next column
			 if(columns.length > 0){	 
				 first_word = columns[0];
			 }
			 else{
				 continue;
			 }
			 Matcher m = p.matcher(first_word);
			 
			 if(m.find() && count > 1){
				 count = 1;	 
				 
				 // Add data to data object
				 data.date = date;
				 data.time = time;
				 data.sale = sale;
				 data.rating = rating;
				 data.amount = amount;
				 data.issue = issue;
				 data.pop = pop;
				 data.net = net;
				 data.comment = comment;
				 
				 buildExcel.addRow(data);
				 System.out.println("date is "+date);
				 System.out.println("time is "+time);
				 System.out.println("sale is "+sale);
				 System.out.println("rating is "+rating);
				 System.out.println("amount is "+amount);
				 System.out.println("issue is "+issue);
				 System.out.println("pop is "+pop);
				 System.out.println("net is "+net);
				 System.out.println("comment is "+comment);
				 System.out.println();
				 date = ""; time= ""; sale =""; rating=""; amount=""; issue=""; pop=""; 
						 net=""; comment="";
						 
						 
			 }
			 
			 
			 if(count == 1){
				 date = columns[0];
				 if(columns.length > 1)
					 rating = columns[1];
			 }
			 else if (count == 2){
				 time = columns[0];
			 }
			 else if (count == 3){
				 sale = columns[0];
				 if(columns.length > 1)
					 amount = columns[1];
			 }
			 if(columns.length > 2){
				 issue = issue + columns[2]+"\n";
			 }
			 
			 if(columns.length > 3){
				 pop = pop + columns[3]+"\n";
			 } 
			 if(columns.length > 4){
				 net = net + columns[4]+"\n";
			 } 
			 
			 if(columns.length > 5){
				 comment = comment + columns[5]+"\n";
			 } 
			 	 
			 count++;
			 
		 }
		 in.close();
		 // Add data to data object
		 data.date = date;
		 data.time = time;
		 data.sale = sale;
		 data.rating = rating;
		 data.amount = amount;
		 data.issue = issue;
		 data.pop = pop;
		 data.net = net;
		 data.comment = comment;
		 
		 buildExcel.addRow(data);
		 buildExcel.generateOutput();
		 
		 System.out.println("date is "+date);
		 System.out.println("time is "+time);
		 System.out.println("sale is "+sale);
		 System.out.println("rating is "+rating);
		 System.out.println("amount is "+amount);
		 System.out.println("issue is "+issue);
		 System.out.println("pop is "+pop);
		 System.out.println("net is "+net);
		 System.out.println("comment is "+comment);
		 System.out.println();	 
		 }
		 
		 catch(Exception e){
			 e.printStackTrace();
		 }

	}
	
	public static String formed_line(String line, int beg, int end){
		
		if(line.length() >= end)
			return line.substring(beg, end);
		else if(line.length() > beg)
			return line.substring(beg);
		else
			return "";
		
	}
	
	public static String[] trimValues(String[] columns){
		String [] retColumns = new String[columns.length];
		
		for(int i=0; i<columns.length; i++){
			retColumns[i] = columns[i].trim();
		}
		
		return retColumns;
	}

}
