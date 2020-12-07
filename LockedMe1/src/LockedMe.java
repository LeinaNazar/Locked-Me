	import java.io.File;
import java.io.IOException;
	import java.util.Arrays;
	import java.util.Scanner;

	public class LockedMe {
		static String fullfile;
		static String filepath="d:\\leina\\java\\";
		static File file;
		static boolean t=false;
		Scanner inputd= new Scanner( System.in );		
		public LockedMe() {
			System.out.println("*************************** Loked Me *******************************");
			System.out.println("******************************************************************\n");
			System.out.println("Developer Name:Leina Nazar Elgack\n\n");
			System.out.println("\t\t\tMenu");
			System.out.println("\t\t===================");
			System.out.println(" 1. return the current file names in an ascending order");
			System.out.println(" 2. Add a file to the existing directory list");
			System.out.println(" 3. Delete a user specified file from the existing directory list");
			System.out.println(" 4. Search a user specified file from the main directory");
			System.out.println(" 5. Close the application\n");	
		}
		
		public static void msg() {
			Scanner inputd= new Scanner( System.in );
			System.out.println("Do you want to navigate to main menu press y (YES)?");
			String s=inputd.nextLine();
			if(s.equals("Y") || s.equals("y")) {
				clrscr();
				t=true;
			}
			else
			{t=false;}
			
		}
		public static void clrscr()
	    {
	       try 
	       {
	         if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	         else
	            Runtime.getRuntime().exec("clear");
	       } catch (IOException | InterruptedException ex) {}
	    }
		 
		public static void ReturnFileName() throws IOException{
			clrscr();
			File dir = new File("d:\\leina\\java\\");
			System.out.println("\n ALL files and directories in an ascending order that found in path "+dir);
			File[] files = dir.listFiles();
			Arrays.sort(files, (f1, f2) -> f1.compareTo(f2));
			for (File file : files) {
		         if (!file.isHidden()) {
		            if (file.isDirectory()) {
		               System.out.println("DIR \t" + file.getName());
		            } else {
		               System.out.println("FILE\t" + file.getName());
		            }
		         }}
			
			msg();
		}
			
		public static void CreateFiles() throws IOException  {
			
			boolean result;
			try {
				clrscr();
				Scanner inputf= new Scanner( System.in );
			System.out.println("\n Please Enter the file name you want to add it in location "+filepath);
		         String s = inputf.nextLine().toLowerCase(); // Takes the filename with extension as the user input
		         fullfile=filepath.concat(s).concat(".txt");
		          file=new File(fullfile);
	        	 result=file.createNewFile();
	 					if(result==true) {
	 					System.out.println("File "+s+" was created in location: "+filepath);
	 					}//end if
	 					else
	 					{ file.exists();
	 						System.out.println("File "+s+" already exist in location "+file.getAbsolutePath());}
	 					msg();
				}//end try
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void DeleteFiles() throws IOException  {
			
			try {
				clrscr();
				System.out.println("\n Please Enter the file you want to delete from location "+filepath);
			Scanner inputd= new Scanner( System.in );
		    String s =inputd.nextLine(); // Takes the filename with extension as the user input
		    fullfile=(filepath.concat(s).concat(".txt")).toLowerCase();
	       file=new File(fullfile);
	       if(file.exists()) {
	    	   if(file.delete()) {
				System.out.println("successfully to delete File "+s+" from "+filepath);
	    	   }
	    	   else
	    	   {System.out.print("Failed to delete the file "+s+" from "+filepath);}
	       }//end inner if
	       
	       else {
				System.out.print("File "+s+" Not Found in "+filepath);
	       }
	       msg();
			}//end try
			catch(Exception e){
				e.printStackTrace();
			}
		}
	

		
				public static void SearchFile() throws IOException{
			try {
				clrscr();
				System.out.println("\n Please Enter the  file you want to search in location "+filepath);
				Scanner inputd= new Scanner( System.in );
			    String s =inputd.nextLine(); // Takes the filename with extension as the user input
			    fullfile=(filepath.concat(s).concat(".txt").toLowerCase());
			    file=new File(fullfile);
			    if(file.exists()) {
					System.out.println("File "+s+" is exist in location "+filepath);

			    }
			    else
			    {	System.out.println("File "+s+" does not exist in location "+filepath);}
			    msg();
			}			
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	    public static void operations(String x) throws IOException  {
	    	switch(x) {
	    	
	    	case "1":{
	    		try {
	    		ReturnFileName();
	    		break;
	    		}
	    		catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    			
	    	}
	    		
	    	
	    	case "2":{
	    		CreateFiles();
	    		break;	
	    		}
	    	
	    	case "3":{
	    		DeleteFiles();
	    		break;	
	    	}
	    	
	    	case "4":{
	    		SearchFile();
	    	//	SearchFilewithPaternMatech();
	    		break;
	    	}
	   
	    	case "5":{
	    		System.out.print("the application closed");
    			System.exit(0);
	    		break;
	    	}
	    	}
	    	
	    }
		public static void main(String[] args) throws IOException {
			t=true;
			while(t) {
			new LockedMe();
			
			System.out.println("\n Please give your choice from the menu: ");
			Scanner scan=new Scanner(System.in);
			String Choice=scan.next();
			operations(Choice);
			
		/*	System.out.println("Do you want to exit from program? ");
			String ex=scan.nextLine();
			if(ex.equalsIgnoreCase("Y")) {
				System.out.println("yes ");}*/
			}
		}
	}



