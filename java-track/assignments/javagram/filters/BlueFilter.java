package javagram.filters;

import javagram.Picture;
import java.awt.Color;

public class BlueFilter implements Filter{

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
	          
	          //find average intensity of RGB values
	          int newBlue = (r + g + b) / 3;
	          
	          //set new pixel in same location with average intensity as shade of blue
	          processed.set(i, j, new Color(0, 0, newBlue));
	    	  
	      }
	    }
		
		return processed;
	}

}
