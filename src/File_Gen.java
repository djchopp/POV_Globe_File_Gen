import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class File_Gen {
	public static void main(String[] args) throws IOException{
		int i, j;
		
		FileOutputStream out = new FileOutputStream("LED.dat");
		BufferedImage img=ImageIO.read(new File("led_data.bmp"));
		
		int size = (img.getWidth() * img.getHeight());
		
        for(i = 3; i>=0;i--){
        	out.write((size>>(i*8)) & 0xFF);
        }
		
		for(i = 0; i< img.getWidth();i++){
			for(j = img.getHeight()-1;j>=0;j--){
				Color c = new Color(img.getRGB(i, j));
				out.write(c.getRed());
				out.write(c.getGreen());
				out.write(c.getBlue());
			}
		}
		
		out.close();

	}
}
