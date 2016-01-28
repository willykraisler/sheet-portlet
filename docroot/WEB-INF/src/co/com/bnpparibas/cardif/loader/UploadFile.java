package co.com.bnpparibas.cardif.loader;

import java.io.File;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.apache.commons.io.FileUtils;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class NewPortlet
 */
public class UploadFile extends MVCPortlet {

	private final static int ONE_GB = 1073741824;

	private final static String baseDir = "/tmp/uploaded/";

	private final static String fileInputName = "fileupload";

	public void upload(ActionRequest request, ActionResponse response)
			throws Exception {

		UploadPortletRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(request);

		long sizeInBytes = uploadRequest.getSize(fileInputName);

		if (uploadRequest.getSize(fileInputName) == 0) {
			throw new Exception("Received file is 0 bytes!");
		}

		// Get the uploaded file as a file.
		File uploadedFile = uploadRequest.getFile(fileInputName);

		String sourceFileName = uploadRequest.getFileName(fileInputName);

		// Where should we store this file?
		File folder = new File(baseDir);
		Integer a = new Integer(0);

		// Check minimum 1GB storage space to save new files...

		if (folder.getUsableSpace() < ONE_GB) {
			throw new Exception("Out of disk space!");
		}

		// This is our final file path.
		File filePath = new File(folder.getAbsolutePath() + File.separator
				+ sourceFileName);

		// Move the existing temporary file to new location.
		FileUtils.copyFile(uploadedFile, filePath);
	}

}
