import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Search {
	
	static String directories;
	Talker talk;


	
	//Iterative fcn to traverse in the given directory
	Search(Talker talk) throws IOException{
		this.talk=talk;
		findPaths();
		System.out.println(directories);
	
				 
				//Maintain a queue to store files and directories
				Queue<File> queue = new LinkedList<>();
				
				//add root directory to queue
				queue.add(new File(directories));


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
							else if(file.toString().endsWith(".wav") || 
									file.toString().endsWith(".mp3") || 
									file.toString().endsWith(".mp4") ||
									file.toString().endsWith(".jpg") ||
									file.toString().endsWith(".png") ||
									file.toString().endsWith(".mpg")){ 
								talk.send(file.toString());
								
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
	            System.out.println(path + "In findPaths");
	            	            directories = path.toString();
	            	            
	         }
	         
	      } catch(Exception e) {
	         
	         // if any error occurs
	         e.printStackTrace();
	      }
		
	}
		
	

public void searchForFiles()
{
	System.out.println("Starting File Crawler...");
	int numOfFiles;
	File currentFile;
	File currentDir;
	LinkedList <File>queue;
	File[] rootArray = File.listRoots();
	File[] fileArray;
	System.out.println("Crawling...");
	
	System.out.println("Number of Roots: " + rootArray.length);
	queue = new LinkedList();
	
	for (int i = 0; i < rootArray.length; i++)
	{
		queue.add(rootArray[i]);
		System.out.println(File.listRoots()[i]);
		System.out.println("Current Root: " + i);
	}
	while(!queue.isEmpty())
	{
		currentDir = queue.poll();
		fileArray = currentDir.listFiles();
		if (currentDir != null && fileArray != null)
		{
			fileArray = currentDir.listFiles();
			numOfFiles = currentDir.listFiles().length;
			System.out.println("Files to Process: "+ numOfFiles);
			if (fileArray != null)
			{
				System.out.println("CURRENT DIRECTORY: " + currentDir);
				System.out.println("Number of Files in current Directory: " + numOfFiles);
				for(int x = 0; x < numOfFiles; x++)
				{
					currentFile = currentDir.listFiles()[x];
					if (currentFile.isDirectory())
					{
						System.out.println("Found Folder: " + currentFile + "; Adding to Queue;");
						queue.add(currentFile);
					}
					else
					{
						System.out.println("*** FOUND FILE: '" + currentFile + "' ***");
						
					}
				}
			}
		}
	}

	
}
		
	
}
