package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class SepiaFilter implements Filter {

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
	  		        
	  	      //apply sepia-toned modifiers
	  	      int newRed = (int)(oldRed * 0.393 + oldGreen * 0.769 + oldBlue * 0.189);
	  		  int newGreen = (int)(oldRed * 0.349 + oldGreen * 0.686 + oldBlue * 0.168);
	  		  int newBlue = (int)(oldRed * 0.272 + oldGreen * 0.534 + oldBlue * 0.131);
	          
	  		  //set new pixel in same location with modified color
	          processed.set(i, j, new Color(newRed, newGreen, newBlue));
	    	  
	      }
	    }
		
		return processed;
		
	}

}