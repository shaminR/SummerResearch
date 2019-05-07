package main;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public class I2cConn {
	
	public static int O_RDWR = 0x00000002;

	public I2cConn() {
		System.setProperty("jna.nosys", "true");
		String fileName = "/dev/i2c-1";
		
		int file = CLibrary.INSTANCE.open(fileName, O_RDWR);
		
		if(file < 0) {
			System.out.println("failed to open i2c-1 file");
			return;
		}
		
		
		int address = 0x21;	// the following address is specific to i2c device (his was 21)
		int i2cSlave = 0x0703;	// always use this
		int ioctl = CLibrary.INSTANCE.ioctl(file, i2cSlave, address);
		
		if(ioctl < 0) {
			System.out.println("ioctl call failed");
			return;
		}
		
		// following is for relay shit
		byte[] buf = {0, 0};
		int writeReturn = CLibrary.INSTANCE.write(file, buf, 2);
		
		if(writeReturn != 2) {
			System.out.println("write failed");
		}
		
		//if make to here we good
		
		
	}
	
	public interface CLibrary extends Library{
		@SuppressWarnings("deprecation")
		CLibrary INSTANCE = (CLibrary)Native.loadLibrary(Platform.isWindows() ? "msvcrt" : "c", CLibrary.class);
		
		public int ioctl(int file, int cmd, int arg);
		public int open(String path, int flags);
		public int close(int file);
		public int write(int file, byte[] buffer, int count);
		public int read(int file, byte[] buffer, int count);
	}
	
	public static void main(String[] args) {
		new I2cConn();
		System.out.println("end");
	}

}
