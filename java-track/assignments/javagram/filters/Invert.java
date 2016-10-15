package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class Invert implements Filter {

	@Override
	public Picture process(Picture original) {
		Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  Color c = original.get(i, j);
	          
	          //get color components from each pixel
	          int r = c.getRed();
	          int g = c.getGreen();
	          int b = c.getBlue();
	          
	          //invert color components
	          int newRed = 255 - r;
	          int newGreen = 255 - g;
	          int newBlue = 255 - b;
	          
	          //set new pixel in same location with modified color
	          processed.set(i, j, new Color(newRed, newGreen, newBlue));
	    	  
	      }
	    }
		
		return processed;
	}

}
