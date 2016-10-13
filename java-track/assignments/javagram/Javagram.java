package javagram;

import javagram.filters.*;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Javagram {

	public static void main(String[] args) {

		// Create the base path for images		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String dir = String.join(File.separator, baseParts);
		String relPath;
		Picture picture = null;
		Scanner in = new Scanner(System.in);
		
		// prompt user for image to filter and validate input
		do {
			
			String imagePath = "path not set";
			
			// try to open the file
			try {
				
				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();
				
				String[] relPathParts = relPath.split(File.separator);
				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));
				
				picture = new Picture(imagePath);
				
			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}
			
		} while(picture == null);
		
		// TODO - prompt user for filter and validate input
		System.out.println("Enter filter number: 1-Blue, 2-Invert, 3-Brighten, "
				+ "4-Blur, 5-Monochrome, 6-Grayscale, 7-FlipVert, 8-FlipHoriz, 9-B&W, 0-Sepia");
		int filter_num = in.nextInt(); 
		// validate filter_num
		Filter filter = getFilter(filter_num);			

		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();
		
		System.out.println("Image successfully filtered");
		
		// save image, if desired
		
		System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
		String fileName = in.next();
		
		// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original
		
		if (fileName.equals("exit")) {
			System.out.println("Image not saved");
		} else {
			String absFileName = dir + File.separator + fileName;
			processed.save(absFileName);
			System.out.println("Image saved to " + absFileName);
		}	
		
		// close input scanner
		in.close();
	}
	
	// TODO - refactor this method to throw an exception if the int doesn't correspond to a filter
	private static Filter getFilter(int filter_num) {
		switch(filter_num) {
		case 1: return new BlueFilter();
		case 2: return new Invert();
		case 3: return new Brighten();
		case 4: return new Blur();
		case 5: return new Monochrome();
		case 6: return new Grayscale();
		case 7: return new FlipVert();
		case 8: return new FlipHoriz();
		case 9: return new B_WFilter();
		case 0: return new SepiaFilter();
		default: throw new ParseException("Unavailable Filter number " + filter_num, 0);
		}
	}

}