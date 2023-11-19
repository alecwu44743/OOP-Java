import java.io.*;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class BitmapImage {
	// File header: 14 bytes.
	private byte type[] = new byte[2];	// Two fixed characters, "BM" for bitmap images.
	private int size;	// File size in bytes.
	private byte reserved[] = new byte[4];	// Reserved field.
	// Offset, starting address where the bitmap image data are stored.
	private int offsetBits;
	
	// Image information: 40 bytes.
	private int infoSize; // Information size in byte.
	private int width; // Image width in pixel.
	private int height; // Image height in pixel.
	private short planes; // Number of image planes in the image, must be 1.
	private short bitPerPixel; // Number of bits used to represent the data for each pixel.
	private int compression; // Compressed form, 0 is uncompressed.
	private int imageSize; // Size of the actual pixel data, in bytes.
	private int xResolution; // Horizontal resolution of the image, pixels per meter.
	private int yResolution; // Vertical resolution of the image, pixels per meter.
	private int colors;	// Color indices, value is 0.                                         
	private int importantColors; // Number of important colors, value is 0.
	
	private byte[] palete; // Color palete, size is offsetBits-infoSize-14 bytes.
	private byte[] imageData; // Image pixel data area, size is imageSize bytes.
	
	private String fileName; // File name.
	
	public BitmapImage(String fName) {  // Constructor with string parameter.
		fileName = fName;  // Store the file name.
	}
	
	// Input an image file.
	public void readImage() throws IOException {  // fileName is the name of the input image file.
		FileInputStream fileIn = new FileInputStream(fileName);  // Create a file input stream.
		DataInputStream dataIn = new DataInputStream(fileIn); // Create a data input stream.
		
		int n = fileIn.available(); // The length of the image file, that is, the number of bytes of the image file.
		byte dump[] = new byte[n]; // Memory space for storing the image file.
		fileIn.read(dump); // Download the complete file.                                                                                                                                                  
		dataIn.close();	// Close the data input stream.
		
		int i = 0; // Initialize index of dump[] to 0.
		type[0] = dump[i++]; // Read character 'B'.
		type[1] = dump[i++]; // Read character 'M'.
		
		size = getInt(dump, i); // Read file size.
		i += 4;
		
		reserved[0] = dump[i++]; // Four reserved bytes.
		reserved[1] = dump[i++];
		reserved[2] = dump[i++];
		reserved[3] = dump[i++];
		
		offsetBits = getInt(dump, i); // Read offset of image data.
		i += 4;
		
		infoSize = getInt(dump, i); // Read information size.
		i += 4;
		
		width = getInt(dump, i); // Read image width in pixel.
		i += 4;
		
		height = getInt(dump, i); // Read image height in pixel.
		i += 4;
		
		planes = getShort(dump, i); // Read number of image planes.
		i += 2;
		
		bitPerPixel = getShort(dump, i); // Read  number of bits for each pixel.                                                                                                                                                    
		i += 2;
		
		compression = getInt(dump, i); // Read compressed form, 0 is uncompressed.
		i += 4;
		
		imageSize = getInt(dump, i); // Read image size.
		i += 4;
		
		xResolution = getInt(dump, i); // Read horizontal resolution.
		i += 4;
		
		yResolution = getInt(dump, i); // Read vertical resolution.
		i += 4;
		
		colors = getInt(dump, i); // Read color indices, value is 0.
		i += 4;
		
		importantColors = getInt(dump, i); // Read number of important colors, value is 0.
		i += 4;
		
		palete = new byte[offsetBits-infoSize-14]; // Memory space for the color palete.
		imageData = new byte[imageSize]; // Memory space for the image pixels.
		
		for (int j=0; j<offsetBits-infoSize-14; j++) palete[j] = dump[i++]; // Read color palete.
		for (int j=0; j<imageSize; j++) imageData[j] = dump[i++]; // Read image pixels.
	}
	
	// Output an image file.
	public void writeImage() throws IOException { // fileName is the name of the output image file.
	    FileOutputStream fileOut = new FileOutputStream(fileName); // Create a file output stream.
	    DataOutputStream dataOut = new DataOutputStream(fileOut); // Create a data input stream.                                                       

	    byte header[] = new byte[54]; // Byte array for file header.
	    int i = 0; // Index of the file header.
	    
	    header[i++] = 'B'; // Write character 'B'.
	    header[i++] = 'M'; // Write character 'M'.
	    
	    setInt(header, i, this.size); // Write file size.
	    i += 4;
	    
	    i += 4; // Reserved area, four bytes.
	    
	    setInt(header, i, this.offsetBits); // Write offset of image data.                                                                                                                                                    
	    i += 4;
	    
	    setInt(header, i, this.infoSize); // Write information size.
	    i += 4;
	    
	    setInt(header, i, this.width); // Write image width in pixel.
	    i += 4;
	    
	    setInt(header, i, this.height); // Write image height in pixel.
	    i += 4;
	    
	    setShort(header, i, this.planes); // Write number of image planes.
	    i += 2;
	    
	    setShort(header, i, this.bitPerPixel); // Write  number of bits for each pixel.                                                                                                    
	    i += 2;
	    
	    setInt(header, i, this.compression); // Write compressed form, 0 is uncompressed.
	    i += 4;
	    
	    setInt(header, i, this.imageSize); // Write image size.
	    i += 4;
	    
	    setInt(header, i, this.xResolution); // Write horizontal resolution.
	    i += 4;
	    
	    setInt(header, i, this.yResolution); // Write vertical resolution.
	    i += 4;
	    
	    setInt(header, i, this.colors); // Write color indices, value is 0.
	    i += 4;
	    
	    setInt(header, i, this.importantColors); // Write number of important colors, value is 0.
	    i += 4;
	    
	    dataOut.write(header); // Write file header.
	    dataOut.write(palete); // Write color palete
	    dataOut.write(imageData); // Write image pixels.
	    
	    dataOut.close();		
	}
	
	// Print image file header and image information.
	public void printImage() {
	    
		System.out.println("Image file name: " + fileName);
	    System.out.print("  type: " + (char) type[0] + (char) type[1]);
	    System.out.println();
	    System.out.println("  size: " + size);
	    System.out.print("  reserved: " + (char) reserved[0] + (char) reserved[1] +                                                                  
	(char) reserved[2] + (char) reserved[3]);
	    System.out.println();
	    System.out.println("  offsetBits: " + offsetBits);
	    System.out.println("  information size: " + infoSize);
	    System.out.println("  image width: " + width);
	    System.out.println("  image height: " + height);
	    System.out.println("  image planes: " + planes);
	    System.out.println("  bit per pixel: " + bitPerPixel);
	    System.out.println("  compression: " + compression);
	    System.out.println("  image size: " + imageSize);
	    System.out.println("  horizontal resolution: " + xResolution);
	    System.out.println("  vertical resolution: " + yResolution);
	    System.out.println("  color indices: " + colors);
	    System.out.println("  important colors: " + importantColors);                                                                                
	}

	// Rename image file.
	public String renameImage(String newFileName) {
		fileName = newFileName;		
		return fileName;
	}
	
	public int getOffsetBits() {return this.offsetBits;}
	
	public int getSize() {return this.size;}
	
	public void setSize(int size) {this.size = size;}
	
	public int getImageSize() {return this.imageSize;}
	
	public void setImageSize(int size) {this.imageSize = size;}
	
	public int getImageWidth() {return this.width;}
	
	public void setImageWidth(int width) {this.width = width;}
	
	public int getImageHeight() {return this.height;}
	
	public void setImageHeight(int height) {this.height = height;}                                                                                                         
	
	public void getImageData(byte[] imageBuff) {
		int n = imageData.length;
		
		for (int i=0; i<n; i++) imageBuff[i] = imageData[i];
	}
	
	public void setImageData(byte[] imageBuff) {
		int n = imageBuff.length;
		
		if (n!=imageData.length) imageData = new byte[n];
		
		for (int i=0; i<n; i++) imageData[i] = imageBuff[i];
	}
	
	// Get a short integer. The bytes are stored from right to left.
	private short getShort(byte buff[], int offset) {
		int ch0 = buff[offset+1];
		int ch1 = buff[offset+0];
		if (ch0<0) ch0 = ch0 & 0X000000FF;
		if (ch1<0) ch1 = ch1 & 0X000000FF;
		//System.out.printf("%2X %2X\n", ch0, ch1);
		return (short) ((ch0 << 8) | ch1);
	}
	
	// Set a short integer. The bytes are stored from right to left.
	private void setShort(byte buff[], int offset, short value) {                                                                                                               
		buff[offset] = (byte) (value % 256);
		value /= 256;
		buff[offset+1] = (byte) (value % 256);
	}
	
	// Get an integer. The bytes are stored from right to left.
	private int getInt(byte buff[], int offset) {
		int ch0 = buff[offset+3];
		int ch1 = buff[offset+2];
		int ch2 = buff[offset+1];
		int ch3 = buff[offset+0];
		if (ch0<0) ch0 = ch0 & 0X000000FF;
		if (ch1<0) ch1 = ch1 & 0X000000FF;
		if (ch2<0) ch2 = ch2 & 0X000000FF;
		if (ch3<0) ch3 = ch3 & 0X000000FF;
		//System.out.printf("%2X %2X %2X %2X \n", ch0, ch1, ch2, ch3);
		return (ch0 << 24) | (ch1 << 16) | (ch2 << 8) | ch3;
	}
	
	// Set an integer. The bytes are stored from right to left.
	private void setInt(byte buff[], int offset, int value) {                                                                                                                         
		buff[offset] = (byte) (value % 256);
		value /= 256;
		buff[offset+1] = (byte) (value % 256);
		value /= 256;
		buff[offset+2] = (byte) (value % 256);
		value /= 256;
		buff[offset+3] = (byte) (value % 256);                                                                                                                                                
	}
}
