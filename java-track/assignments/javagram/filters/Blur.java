package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class Blur implements Filter {

	@Override
	public Picture process(Picture original) {
		Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  Color c = original.get(i, j);
	          
	          //get color components from each pixel, multiply by weights
	          int r = c.getRed() * 8;
	          int g = c.getGreen() * 8;
	          int b = c.getBlue() * 8;
	          
	          //keep track of the sum of the weights
	          int rSum = 8;
	          int gSum = 8;
	          int bSum = 8;
	          
	          //add weighted values for pixel to the left, if not on left border
	          if (i != 0) {
	        	  r += original.get(i - 1, j).getRed() * 3;
	        	  g += original.get(i - 1, j).getGreen() * 3;
	        	  b += original.get(i - 1, j).getBlue() * 3;
	        	  
	        	  rSum += 3;
	        	  gSum += 3;
	        	  bSum += 3;
	          }
	          
	          //add weighted values for pixel to the top, if not on top border
	          if (j != 0) {
	        	  r += original.get(i, j - 1).getRed() * 3;
	        	  g += original.get(i, j - 1).getGreen() * 3;
	        	  b += original.get(i, j - 1).getBlue() * 3;
	        	  
	        	  rSum += 3;
	        	  gSum += 3;
	        	  bSum += 3;
	          }
	          
	          //add weighted values for pixel to the right, if not on right border
	          if (i != original.width() - 1) {
	        	  r += original.get(i + 1, j).getRed() * 3;
	        	  g += original.get(i + 1, j).getGreen() * 3;
	        	  b += original.get(i + 1, j).getBlue() * 3;
	        	  
	        	  rSum += 3;
	        	  gSum += 3;
	        	  bSum += 3;
	          }
	          
	          //add weighted values for pixel to the bottom, if not on bottom border
	          if (j != original.height() - 1) {
	        	  r += original.get(i, j + 1).getRed() * 3;
	        	  g += original.get(i, j + 1).getGreen() * 3;
	        	  b += original.get(i, j + 1).getBlue() * 3;
	        	  
	        	  rSum += 3;
	        	  gSum += 3;
	        	  bSum += 3;
	          }
	          
	          //divide sum of values by sum of weights to get weighted average
	          int newRed = r / rSum;
	          int newGreen = g / gSum;
	          int newBlue = b / bSum;
	          
	          //set new pixel in same location with modified color
	          processed.set(i, j, new Color(newRed, newGreen, newBlue));
	    	  
	      }
	    }
		
		return processed;
	}

}