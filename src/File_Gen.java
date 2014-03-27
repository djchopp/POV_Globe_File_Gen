import java.io.*;
import java.util.*;


public class File_Gen {
	
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(new File("raw_led_data.txt"));

        FileOutputStream out = new FileOutputStream("LED.dat");
        int temp, i;
        
        temp = (int)input.nextLong();
        for(i = 3; i>=0;i--){
        	out.write((temp>>(i*8)) & 0xFF);
        }
        
        while(input.hasNextInt()){
        	
        	temp = input.nextInt();
        	out.write(temp);
        }
        
        out.close();


	}
}
