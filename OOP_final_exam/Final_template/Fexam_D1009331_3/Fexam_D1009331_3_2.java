import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fexam_D1009331_3_2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String path = "./";  // Path of the image files.
		String sourName; // Source image file name.
		String destName; // Flip and merge image file name.

		System.out.print("Enter the source image file name: ");
		sourName = in.nextLine();
		
		System.out.print("Enter the flip and merge image file name: ");
		destName = in.nextLine();
		

		BitmapImage image = new BitmapImage(path + sourName); // Create a bitmap image object.
		

		try {
			// Read the source image.
			image.readImage();

			// Print the file header and image information of the source image.
			// System.out.println("Image file name: " + sourName);
			image.printImage();

			// Get the size of image pixels.
			int width = image.getImageWidth(); // Image width.
			int height = image.getImageHeight(); // Image height.
			int fillings = (4 - (width * 3) % 4) % 4; // Filling bytes at the end of each row.
			int rowSize = width * 3 + fillings; // Number of bytes in each row.
			int size = rowSize * height; // Size of the image.
			byte imageBuff[] = new byte[size]; // Create buffer for storing image pixels.

			// Create buffer for storing image pixels.
			image.getImageData(imageBuff);

			// Copy the original image pixel data.
			// int width = image.getImageWidth(); // Image width.
			// int height = image.getImageHeight(); // Image height.
			// int fillings = (4 - (width * 3) % 4) % 4; // Filling bytes at the end of each row.
			// int rowSize = width * 3 + fillings; // Number of bytes in each row.
			int widthMerge = width * 2; // Width of the merged image.
			int fillingsMerge = (4 - (widthMerge * 3) % 4) % 4; // Filling bytes of the merged image.
			int rowSizeMerge = widthMerge * 3 + fillingsMerge; // Number of bytes in each row of the merged image.
			int sizeMerge = rowSizeMerge * height; // Size of the merged image.
			byte imageBuffMerge[] = new byte[sizeMerge]; // Create buffer for storing the merged image pixels.
			
			int i, j, k, kLeft, kRight; // Loop variables.
			for (i = 0; i < height; i++) { // Scan all rows.
				for (j = 0; j < width; j++) { // Scan all pixels in a row.
					k = i * rowSize + j * 3; // Index of the pixel.
					kLeft = i * rowSizeMerge + j * 3; // Left index of the pixel of the merged image.
					kRight = i * rowSizeMerge + (widthMerge-1-j) * 3; // Right index of the pixel of the merged image.
					// Copy blue color value of the left half.
					imageBuffMerge[kLeft] = imageBuff[k];

					// Copy green color value of the left half.
					imageBuffMerge[kLeft+1] = imageBuff[k+1];

					// Copy red color value of the left half.
					imageBuffMerge[kLeft+2] = imageBuff[k+2];

					// Copy blue color value of the right half.
					imageBuffMerge[kRight] = imageBuff[k];

					// Copy green color value of the right half.
					imageBuffMerge[kRight+1] = imageBuff[k+1];

					// Copy red color value of the right half.
					imageBuffMerge[kRight+2] = imageBuff[k+2];
				}
			}
			
			// Set modified width of the merged image.
			image.setImageWidth(widthMerge);

			// Set modified file size of the merged image.
			image.setSize(sizeMerge);

			// Set modified image size of the merged image.
			image.setImageSize(sizeMerge);

			// Set the modified image pixel data of the merged image.
			image.setImageData(imageBuffMerge);

			// Rename the image to the flip and merge image file name.
			image.renameImage(destName);

			// Write the flip and merge image.
			image.writeImage();

			// Print the file header and image information of the flip and merge image.
			// System.out.println("Image file name: " + destName);
			image.printImage();
		} catch (Exception ex) {
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
// abraham_lake.bmp
// flip_merge.bmp