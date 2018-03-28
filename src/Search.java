import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class Search {
	
	static File directories;
	static Queue<File> queue;


	
	//Iterative fcn to traverse in the given directory
	public static void main(String[] args){

		findPaths();
		System.out.println(directories);
		
		//Root Directory
			
				 
				//Maintain a queue to store files and directories
				queue = new LinkedList<>();

				//loop until queue is empty- all files and directories present
				// inside the root directory are processed
				while (!queue.isEmpty()){
					
					//get next file/directory from queue
					File current = queue.poll();
					
								
					//get list of all files and directories in 'current'
					File[] listOfFileAndDirectory = current.listFiles();
					
					//listfiles() returns non-null array if 'current' denotes a dir
					if(listOfFileAndDirectory != null){
						
						//iterate over the names of the files and directories in 
						//the current directory
						for( File file : listOfFileAndDirectory){
							
							//if file denotes a directory
							if(file.isDirectory()){
								queue.add(file);
							}
							//if file denotes a file, print it
							else { 
								System.out.println(file);
						}	
						}
					}
				}
			}

	
		public static void findPaths (){
		 File[] paths;
	      
	      try {  
	      
	         // returns pathnames for files and directory
	         paths = File.listRoots();
	         
	         // for each pathname in pathname array
	         for(File path:paths) {
	         
	            // prints file and directory paths
	            System.out.println(path);
	        	//add root directory to queue
				
	            	            queue.add((path));
	            	            
	         }
	         
	      } catch(Exception e) {
	         
	         // if any error occurs
	         e.printStackTrace();
	      }
		
	}
		
		
		
	
}
