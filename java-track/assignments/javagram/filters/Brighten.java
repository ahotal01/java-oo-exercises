package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class Brighten implements Filter {
	
	@Override
	public Picture process(Picture original) {
		Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  Color c = original.get(i, j);
	          
	          //get color components from each pixel
	    	  int oldRed = c.getRed();
	  		  int oldGreen = c.getGreen();
	  	      int oldBlue = c.getBlue();
	  		        
	  	      //lighten each shade
	  	      int newRed, newGreen, newBlue;
	  	      
	  	      if (oldRed >= 205) {
	  	    	  newRed = 255;
	  	      } else {
	  	    	  newRed = oldRed + 50;
	  	      }
	  	      
	  	      if (oldGreen >= 205) {
	  	    	  newGreen = 255;
	  	      } else {
	  	    	  newGreen = oldGreen + 50;
	  	      }
	  	      
	  	      if (oldBlue >= 205) {
	  	    	  newBlue = 255;
	  	      } else {
	  	    	  newBlue = oldBlue + 50;
	  	      }
	          
	  		  //set new pixel in same location with modified color
	          processed.set(i, j, new Color(newRed, newGreen, newBlue));
	    	  
	      }
	    }
		
		return processed;
		
	}

}
