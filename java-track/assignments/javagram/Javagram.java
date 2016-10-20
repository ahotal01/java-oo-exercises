package javagram;

import javagram.filters.*;

import java.io.File;
import java.util.Arrays;
import java.util.InputMismatchException;
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
		
		Filter filter = null;
		do {
			System.out.println("Enter filter number: 1-Blue, 2-Invert, 3-Brighten, "
					+ "4-Blur, 5-Monochrome, 6-Grayscale, 7-FlipVert, 8-FlipHoriz, 9-B&W, 0-Sepia");
			int filter_num = in.nextInt();
			
			try {
				filter = getFilter(filter_num);
			} catch (InputMismatchException e) {
				System.out.println(e);
			}
		} while (filter == null);

		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();
		
		System.out.println("Image successfully filtered");
		
		// save image, if desired
		
		System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
		String fileName = in.next();
		
		if (fileName.equals("exit")) {
			System.out.println("Image not saved");
		} else if (fileName.equals(dir)){
			System.out.println("Are you sure you want to overwrite the original? (Type y/n)");
			if (in.next() == "y") {
				String absFileName = dir + File.separator + fileName;
				processed.save(absFileName);
				System.out.println("Image saved to " + absFileName);
			} else {
				System.out.println("Image not saved");
			}
		} else {
			String absFileName = dir + File.separator + fileName;
			processed.save(absFileName);
			System.out.println("Image saved to " + absFileName);
		}	
		
		// close input scanner
		in.close();
	}
	
	private static Filter getFilter(int filter_num) throws InputMismatchException {
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
		default: throw new InputMismatchException("Invalid Filter number. ");
		}
	}

}