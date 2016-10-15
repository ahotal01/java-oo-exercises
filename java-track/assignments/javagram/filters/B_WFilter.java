package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class B_WFilter implements Filter {

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
	          
	          //finding average intensity
	          int grayVal = (r + g + b) / 3;
	          
	          //if average intensity is closer to white, make white. Otherwise, make black
	          if (grayVal < 128) {
	        	  grayVal = 0;
	          } else grayVal = 255;
	          
	          //set new pixel in same location with grayVal as all three color values
	          processed.set(i, j, new Color(grayVal, grayVal, grayVal));
	    	  
	      }
	    }
		
		return processed;
	}

}