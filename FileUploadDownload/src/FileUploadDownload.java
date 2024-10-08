import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;

import javax.activation.MimetypesFileTypeMap;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.springframework.web.multipart.MultipartFile;

import com.etel.utils.AuditLog;
import com.etel.utils.AuditLogEvents;
import com.wavemaker.common.util.IOUtils;
import com.wavemaker.runtime.RuntimeAccess;
import com.wavemaker.runtime.javaservice.JavaServiceSuperClass;
import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.server.DownloadResponse;
import com.wavemaker.runtime.server.FileUploadResponse;
import com.wavemaker.runtime.service.annotations.ExposeToClient;

/**
 * This is a client-facing service class. All public methods will be exposed to
 * the client. Their return values and parameters will be passed to the client
 * or taken from the client, respectively. This will be a singleton instance,
 * shared between all requests.
 * 
 * To log, call the superclass method log(LOG_LEVEL, String) or log(LOG_LEVEL,
 * String, Exception). LOG_LEVEL is one of FATAL, ERROR, WARN, INFO and DEBUG to
 * modify your log level. For info on these levels, look for tomcat/log4j
 * documentation
 */
@ExposeToClient
public class FileUploadDownload extends JavaServiceSuperClass {
	/*
	 * Pass in one of FATAL, ERROR, WARN, INFO and DEBUG to modify your log level;
	 * recommend changing this to FATAL or ERROR before deploying. For info on these
	 * levels, look for tomcat/log4j documentation
	 */

	SecurityService secservice = (SecurityService) RuntimeAccess.getInstance().getServiceBean("securityService");
	private String username = secservice.getUserName();

	public FileUploadDownload() {
		super(INFO);
	}

	/**********************************************************************************
	 * INNER CLASS: WMFile DESCRIPTION: The class WMFile is a class used to
	 * represent information about a list of files. An array of WMFile objects is
	 * returned when the client asks for a list of files on the server. NOTES: This
	 * class can be renamed, and you can add any fields you want (as long as you add
	 * get and set methods for each field). This class is here as an example, and
	 * can be changed to suit your needs
	 **********************************************************************************/
	public class WMFile {
		String path;
		String name;
		long size;
		String type;

		public WMFile(String path, String name, long size, String type) {
			this.path = path;
			this.name = name;
			this.size = size;
			this.type = type;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String s) {
			path = s;
		}

		public String getName() {
			return name;
		}

		public void setName(String s) {
			name = s;
		}

		public String getType() {
			return type;
		}

		public void setType(String s) {
			type = s;
		}

		public long getSize() {
			return size;
		}

		public void setSize(long i) {
			size = i;
		}
	};

	/********************************************************************************
	 * TEMPLATE PROPERTY: uploadDir DESCRIPTION When you created your java service,
	 * you were prompted to enter a value for uploadDir. The uploadDir is the
	 * default location to store files, and any request to delete or download files
	 * that contains a relative path will search for the file starting from
	 * uploadDir. NOTES: You can change this value at any time. You may need to set
	 * a different uploadDir for your deployment environment than you used on your
	 * local development environment.
	 ********************************************************************************/
	String uploadDir = "";

	protected File getUploadDir() throws IOException {
		if (uploadDir.length() == 0) {
			uploadDir = RuntimeAccess.getInstance().getSession().getServletContext()
					.getRealPath("resources/data/upload");
		}
		File f = new File(uploadDir);
		// f.mkdirs();
		f.createNewFile();
		return f;
	}

	/********************************************************************************
	 * NAME: uploadFile DESCRIPTION: The wm.DojoFileUpload widget automatically
	 * calls this method whenever the user selects a new file. RETURNS
	 * DojoFileUploaderResponse This has the following fields Path: tells the client
	 * where the file was stored so that the client can identify the file to the
	 * server Name: tells the client what the original name of the file was so that
	 * any communications with the end user can use a filename familiar to that
	 * user. Type: returns type information to the client, based on filename
	 * extensions (.txt, .pdf, .gif, etc...) Error:This will NOT trigger an onError,
	 * but will allow the user of the widget to scan the list of returned files for
	 * any errors. Width/Height: Intended for returning width/height of uploaded
	 * images, but in fact you can use these to return any custom information you
	 * want. NOTES This is a good starting point for an upload service. However,
	 * there are a number of things you might want to change 1. File name: you may
	 * want to associate a database index with the filename: 32_hello.png instead of
	 * hello.png 2. Folder: you may want to store files someplace other than
	 * uploadDir. Perhaps a folder named for the table and database index associated
	 * with the file. Instead of uploadDir/hello.png uploadDir/table1/32/hello.png
	 * 3. You may actually want to write the file into a database field 4. You may
	 * want to use uploadDir as a "tmp" folder, and await a second javaservice call
	 * before doing something with the files. Just because a file has uploaded does
	 * not mean that the user has hit "Save" to commit all of their changes. 5. Add
	 * additional parameters that identify the file, what database entry or user its
	 * associated with, and other details of what to do with the file. (after
	 * compiling these changes, you may need to recreate your wm.DojoFileUpload
	 * widget)
	 ********************************************************************************/
	public FileUploadResponse uploadFile(MultipartFile file) throws IOException {

		// Create our return object
		FileUploadResponse ret = new FileUploadResponse();
		try {
			/* Find our upload directory, make sure it exists */
			File dir = getUploadDir();
			if (!dir.exists())
				dir.mkdirs();

			/*
			 * Create a file object that does not point to an existing file. Loop through
			 * names until we find a filename not already in use
			 */
			String filename = file.getOriginalFilename(); /*
															 * .replaceAll("[^a-zA-Z0-9 ._-]" ,"");
															 */
			boolean hasExtension = filename.indexOf(".") != -1;
			String name = (hasExtension) ? filename.substring(0, filename.lastIndexOf(".")) : filename;
			String ext = (hasExtension) ? filename.substring(filename.lastIndexOf(".")) : "";
			File outputFile = new File(dir, filename);
			for (int i = 0; i < 10000 && outputFile.exists(); i++) {
				outputFile = new File(dir, name + i + ext);
			}

			/* Write the file to the filesystem */
			FileOutputStream fos = new FileOutputStream(outputFile);
			IOUtils.copy(file.getInputStream(), fos);
			file.getInputStream().close();
			fos.close();

			/* Setup the return object */
			ret.setPath(outputFile.getPath());
			ret.setError("");
			ret.setWidth("");
			ret.setHeight("");
		} catch (Exception e) {
			System.out.println("ERROR:" + e.getMessage() + " | " + e.toString());
			ret.setError(e.getMessage());
		}
		return ret;
	}

	/********************************************************************************
	 * NAME: listFiles DESCRIPTION: Returns a description of every file in the
	 * uploadDir. RETURNS array of inner class WMFile (defined above) NOTES: This is
	 * a rather bare bones implementation. You will likely want to add a parameter
	 * to specify subfolders to list
	 ********************************************************************************/
	public WMFile[] listFiles() throws IOException {
		MimetypesFileTypeMap m = new MimetypesFileTypeMap();
		File dir = getUploadDir();

		/*
		 * Get a list of files; ignore any filename starting with "." as these are
		 * typically private or temporary files not for users to interact with
		 */
		File[] files = dir.listFiles(new java.io.FilenameFilter() {
			public boolean accept(File dir, String name) {
				return (name.indexOf(".") != 0);
			}
		});

		/* Iterate over every file, creating a WMFile object to be returned */
		WMFile[] result = new WMFile[files.length];
		for (int i = 0; i < files.length; i++) {
			result[i] = new WMFile(files[i].getPath(), files[i].getName(), files[i].length(),
					m.getContentType(files[i]));
		}
		return result;
	}

	/********************************************************************************
	 * NAME: deleteFile/deleteFiles DESCRIPTION: Deletes the files with the given
	 * path or name. If the parameters are just file names, it will look for files
	 * of that name in the uploadDir. If its a full path will delete the file at
	 * that path IF that path is within the uploadDir. RETURNS nothing, though an
	 * error will be noticed by the client. NOTES: - wm.DojoFileUpload will send a
	 * full path, not a relative path to the file to be deleted. You can change this
	 * behavior by changing the path data sent in the uploadFile method. - These two
	 * methods are used by the wm.DojoFileUpload widget. Renaming these or changing
	 * the parameters may result in a loss of functionality for your upload widget.
	 * There are a few customizations you may still want to make. Of particular
	 * note, the test to verify that its ok to delete the specified file may benefit
	 * from a better understanding of how/where you are storing files.
	 ****************************************************************************/
	public void deleteFiles(String[] files) throws IOException {
		File dir = getUploadDir();
		for (int i = 0; i < files.length; i++) {
			File f = (files[i].startsWith("/")) ? new File(files[i]) : new File(dir, files[i]);

			// verify that the path specified by the server is a valid path, and
			// not, say,
			// your operating system, or your .password file.
			if (f.getAbsolutePath().indexOf(dir.getAbsolutePath()) == 0)
				f.delete();
		}
	}

	public void deleteFile(String file) throws IOException {
		File dir = getUploadDir();
		File f = (file.startsWith("/")) ? new File(file) : new File(dir, file);

		// verify that the path specified by the server is a valid path, and
		// not, say,
		// your operating system, or your .password file.
		if (f.getAbsolutePath().indexOf(dir.getAbsolutePath()) == 0)
			f.delete();

	}

	/********************************************************************************
	 * NAME: downloadFile DESCRIPTION: The specified file will be downloaded to the
	 * user's computer. - file: filename (if the file is in uploadDir) or path -
	 * filename: Optional string; if used, then this is the name that the user will
	 * see for the downloaded file. Else its name matches whats on the server.
	 * RETURNS DownloadResponse instance NOTES: There are a few customizations you
	 * may still want to make. Of particular note, the test to verify that its ok to
	 * download the specified file may benefit from a better understanding of
	 * how/where you are storing files.
	 ****************************************************************************/
	public DownloadResponse downloadFile(String file, String returnname) throws Exception {
		File dir = getUploadDir();
		File f = (file.startsWith("/")) ? new File(file) : new File(dir, file);

		// verify that the path specified by the server is a valid path, and
		// not, say,
		// your .password file.
		if (f.getAbsolutePath().indexOf(dir.getAbsolutePath()) != 0)
			throw new Exception("File not in uploadDir");

		// Create our return object and setup its properties
		DownloadResponse ret = new DownloadResponse();

		returnname = (returnname != null && returnname.length() > 0) ? returnname : f.getName();
		String type = new MimetypesFileTypeMap().getContentType(f);
		// Setup the DownloadResponse
		FileInputStream fis = new FileInputStream(f);
		ret.setContents(fis);
		ret.setContentType(type);
		ret.setFileName(returnname);
		return ret;
	}

	public FileUploadResponse uploadImageFile(MultipartFile file) throws IOException {

		// Create our return object
		FileUploadResponse ret = new FileUploadResponse();
		try {
			String filename = file.getOriginalFilename(); /* .replaceAll("[^a-zA-Z0-9 ._-]",""); */
			boolean hasExtension = filename.indexOf(".") != -1;
			String name = (hasExtension) ? filename.substring(0, filename.lastIndexOf(".")) : filename;
			String ext = (hasExtension) ? filename.substring(filename.lastIndexOf(".")) : "";
			System.out.println("File ext : " + ext);

			if (ext.equalsIgnoreCase(".png") || ext.equalsIgnoreCase(".jpg") || ext.equalsIgnoreCase(".jpeg")) {
				/* Find our upload directory, make sure it exists */
				File dir = new File(
						RuntimeAccess.getInstance().getSession().getServletContext().getRealPath("resources/tempdir/"));
				if (!dir.exists())
					dir.mkdirs();

				/*
				 * Create a file object that does not point to an existing file. Loop through
				 * names until we find a filename not already in use
				 */
				File outputFile = new File(dir, filename);
				for (int i = 0; i < 10000 && outputFile.exists(); i++) {
					outputFile = new File(dir, name + i + ext);
				}
				/* Write the file to the filesystem */
				FileOutputStream fos = new FileOutputStream(outputFile);
				IOUtils.copy(file.getInputStream(), fos);
				file.getInputStream().close();
				fos.close();

				BufferedImage image = ImageIO.read(outputFile);
				// get image width and height
				int width = image.getWidth();
				int height = image.getHeight();

				// convert to grayscale
				for (int y = 0; y < height; y++) {
					for (int x = 0; x < width; x++) {
						int p = image.getRGB(x, y);
						int a = (p >> 30) & 0xff;
						int r = (p >> 16) & 0xff;
						int g = (p >> 8) & 0xff;
						int b = p & 0xff;
						// calculate average
						int avg = (r + g + b) / 3;

						// replace RGB value with avg
						p = (a << 30) | (avg << 16) | (avg << 8) | avg;

						image.setRGB(x, y, p);
					}
				}

				OutputStream os = new FileOutputStream(outputFile);

				Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
				ImageWriter writer = (ImageWriter) writers.next();

				ImageOutputStream ios = ImageIO.createImageOutputStream(os);
				writer.setOutput(ios);

				ImageWriteParam param = writer.getDefaultWriteParam();
				param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
				param.setCompressionQuality(0.35f);
				writer.write(null, new IIOImage(image, null, null), param);

				os.close();
				ios.close();
				writer.dispose();

				/* Setup the return object */
				ret.setPath(outputFile.getPath());
				ret.setError("");
				ret.setWidth("");
				ret.setHeight("");
			} else {
				ret.setError("Invalid Image File Format");
			}
		} catch (Exception e) {
			System.out.println("ERROR11:" + e.getMessage() + " | " + e.toString());
			ret.setError(e.getMessage());
		}
		if (ret.getError().equals("")) {
			AuditLog.addAuditLog(AuditLogEvents.getAuditLogEvents(AuditLogEvents.M_UPLOAD_SIGCARD),
					"User " + username + " Uploaded Signature Card.", username, new Date(),
					AuditLogEvents.getEventModule(AuditLogEvents.M_UPLOAD_SIGCARD));
		}
		return ret;
	}

	public String uploadImageFilePreview(MultipartFile file) throws IOException {

		// Create our return object
		FileUploadResponse ret = new FileUploadResponse();
		String filename = "";
		try {
			filename = file.getOriginalFilename(); /* .replaceAll("[^a-zA-Z0-9 ._-]",""); */
			boolean hasExtension = filename.indexOf(".") != -1;
			String name = (hasExtension) ? filename.substring(0, filename.lastIndexOf(".")) : filename;
			String ext = (hasExtension) ? filename.substring(filename.lastIndexOf(".")) : "";

			if (ext.equalsIgnoreCase(".png") || ext.equalsIgnoreCase(".jpg") || ext.equalsIgnoreCase(".jpeg")) {
				/* Find our upload directory, make sure it exists */
				File dir = new File(
						RuntimeAccess.getInstance().getSession().getServletContext().getRealPath("resources/tempdir/"));
				if (!dir.exists())
					dir.mkdirs();

				/*
				 * Create a file object that does not point to an existing file. Loop through
				 * names until we find a filename not already in use
				 */
				File outputFile = new File(dir, filename);
				for (int i = 0; i < 10000 && outputFile.exists(); i++) {
					outputFile = new File(dir, name + i + ext);
					filename = name + i + ext;
				}
				/* Write the file to the filesystem */
				FileOutputStream fos = new FileOutputStream(outputFile);
				IOUtils.copy(file.getInputStream(), fos);
				file.getInputStream().close();
				fos.close();

//				BufferedImage image = ImageIO.read(outputFile);
//				// get image width and height
//				int width = image.getWidth();
//				int height = image.getHeight();
//
//				// convert to grayscale
//				for (int y = 0; y < height; y++) {
//					for (int x = 0; x < width; x++) {
//						int p = image.getRGB(x, y);
//						int a = (p >> 30) & 0xff;
//						int r = (p >> 16) & 0xff;
//						int g = (p >> 8) & 0xff;
//						int b = p & 0xff;
//						// calculate average
//						int avg = (r + g + b) / 3;
//
//						// replace RGB value with avg
//						p = (a << 30) | (avg << 16) | (avg << 8) | avg;
//
//						image.setRGB(x, y, p);
//					}
//				}
//
//				OutputStream os = new FileOutputStream(outputFile);
//
//				Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
//				ImageWriter writer = (ImageWriter) writers.next();
//
//				ImageOutputStream ios = ImageIO.createImageOutputStream(os);
//				writer.setOutput(ios);
//
//				ImageWriteParam param = writer.getDefaultWriteParam();
//				param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
//				param.setCompressionQuality(0.35f);
//				writer.write(null, new IIOImage(image, null, null), param);
//
//				os.close();
//				ios.close();
//				writer.dispose();

				/* Setup the return object */
				ret.setPath(outputFile.getPath());
				ret.setError("");
				ret.setWidth("");
				ret.setHeight("");
			} else {
				ret.setError("Invalid Image File Format");
			}
			System.out.println(filename);
		} catch (Exception e) {
			System.out.println("ERROR11:" + e.getMessage() + " | " + e.toString());
			ret.setError(e.getMessage());
		}
		if (ret.getError().equals("")) {
			AuditLog.addAuditLog(AuditLogEvents.getAuditLogEvents(AuditLogEvents.M_UPLOAD_SIGCARD),
					"User " + username + " Uploaded Signature Card.", username, new Date(),
					AuditLogEvents.getEventModule(AuditLogEvents.M_UPLOAD_SIGCARD));
		}
		return "resources/tempdir/" + filename;
	}

	public FileUploadResponse uploadImageFileNew(MultipartFile file) throws IOException {

		// Create our return object
		FileUploadResponse ret = new FileUploadResponse();
		String filename = "";
		try {
			filename = file.getOriginalFilename(); /* .replaceAll("[^a-zA-Z0-9 ._-]",""); */
			boolean hasExtension = filename.indexOf(".") != -1;
			String name = (hasExtension) ? filename.substring(0, filename.lastIndexOf(".")) : filename;
			String ext = (hasExtension) ? filename.substring(filename.lastIndexOf(".")) : "";

			if (ext.equalsIgnoreCase(".png") || ext.equalsIgnoreCase(".jpg") || ext.equalsIgnoreCase(".jpeg")) {
				/* Find our upload directory, make sure it exists */
				File dir = new File(
						RuntimeAccess.getInstance().getSession().getServletContext().getRealPath("resources/tempdir/"));
				if (!dir.exists())
					dir.mkdirs();

				/*
				 * Create a file object that does not point to an existing file. Loop through
				 * names until we find a filename not already in use
				 */
				File outputFile = new File(dir, filename);
				for (int i = 0; i < 10000 && outputFile.exists(); i++) {
					outputFile = new File(dir, name + i + ext);
					filename = name + i + ext;
				}
				/* Write the file to the filesystem */
				FileOutputStream fos = new FileOutputStream(outputFile);
				IOUtils.copy(file.getInputStream(), fos);
				file.getInputStream().close();
				fos.close();

				/* Setup the return object */
				ret.setPath(outputFile.getPath());
				ret.setError("");
				ret.setWidth("");
				ret.setHeight("");
			} else {
				ret.setError("Invalid Image File Format");
			}
			System.out.println(filename);
		} catch (Exception e) {
			System.out.println("ERROR11:" + e.getMessage() + " | " + e.toString());
			ret.setError(e.getMessage());
		}
		if (ret.getError().equals("")) {
			AuditLog.addAuditLog(AuditLogEvents.getAuditLogEvents(AuditLogEvents.M_UPLOAD_SIGCARD),
					"User " + username + " Uploaded Signature Card.", username, new Date(),
					AuditLogEvents.getEventModule(AuditLogEvents.M_UPLOAD_SIGCARD));
		}
		return ret;
	}

}