import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fexam_D1009331_3_1 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String path = "./";  // Path of the image files.
		String sourName; // Source image file name.
		String destName; // Copied image file name.
		
		System.out.print("Enter the source image file name: ");
		sourName = in.nextLine();
		
		System.out.print("Enter the copied image file name: ");
		destName = in.nextLine();
		
		// Create a bitmap image object.
		BitmapImage image = new BitmapImage(path + sourName);
		// Create a copy of the bitmap image object.
		BitmapImage copy = new BitmapImage(path + destName);
		
		
		try {
			// Read the source image.
			image.readImage();

			// Print the file header and image information of the source image. 
			// System.out.println("Image file name: " + sourName);
			image.printImage();
			
			// Rename the image to the copied image file name.  
			image.renameImage(path + destName);

			// Write the copied image.
			image.writeImage();

			// Print the file header and image information of the copied image.
			// System.out.println("Image file name: " + destName);
			copy.readImage();
			copy.printImage();
		}
		catch (Exception ex) { 
			// Print the stack trace, if exception occurs.
			ex.printStackTrace();
		}
		// Close the standard input stream.
		in.close();
	}

	// Define BitmapImage is a static inner class. 
	// or import BitmapImage class
	// public static class BitmapImage {

	// }
}

// Enter the source image file name: abraham_lake.bmp
// Enter the copied image file name: copied.bmp