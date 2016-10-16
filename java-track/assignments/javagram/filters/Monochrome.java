package javagram.filters;

import java.awt.Color;
import java.util.Scanner;

import javagram.Picture;

public class Monochrome implements Filter {

	@Override
	public Picture process(Picture original) {
		Picture processed = new Picture(original.width(), original.height());
		
		Scanner in = new Scanner(System.in);
		System.out.println("Input color of choice: 1-Red 2-Green 3-Blue "
				+ "4-Yellow 5-Purple 6-Turquoise 7-Gray");
		int color_num = in.nextInt();
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  Color c = original.get(i, j);
	          
	    	//get color components from each pixel
	          int r = c.getRed();
	          int g = c.getGreen();
	          int b = c.getBlue();
	          
	          //get average intensity of RGB values
	          int grayVal = (r + g + b) / 3;
	          
	          //set new pixel in same location with average intensity as all color values
	          switch(color_num) {
	  		  case 1: processed.set(i, j, new Color(grayVal, 0, 0));
	  		  case 2: processed.set(i, j, new Color(0, grayVal, 0));
	  		  case 3: processed.set(i, j, new Color(0, 0, grayVal));
	  		  case 4: processed.set(i, j, new Color(grayVal, grayVal, 0));
	  		  case 5: processed.set(i, j, new Color(grayVal, 0, grayVal));
	  		  case 6: processed.set(i, j, new Color(0, grayVal, grayVal));
	  		  case 7: processed.set(i, j, new Color(grayVal, grayVal, grayVal));
	  		  default: processed.set(i, j, new Color(0, 0, 0));
	  		  }
	          
	          processed.set(i, j, new Color(grayVal, grayVal, grayVal));
	    	  
	      }
	    }
	    in.close();
		return processed;
		
	}

}