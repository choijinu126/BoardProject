package kr.co.utils;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class UploadFileUtils {
	public static String uploadFile(String uploadPath, MultipartFile file) throws Exception {
		String ori_name = file.getOriginalFilename();
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + ori_name;

		String datePath = calPath(uploadPath);

		File target = new File(uploadPath + datePath, savedName);
		FileCopyUtils.copy(file.getBytes(), target);

		String bp = datePath + File.separator + savedName;
		String ap = bp.replace(File.separatorChar, '/');

		return ap;
	}

	public static String calPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format((cal.get(Calendar.MONTH) + 1));
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));

		makeDir(uploadPath, yearPath, monthPath, datePath);

		return datePath;
	}

	private static void makeDir(String uploadPath, String ... arr) {
		for(String path: arr) {
			if(new File(uploadPath + arr[arr.length-1]).exists()) {
				return;
			}else {
				File dirPath = new File(uploadPath + path);
				
				if(!dirPath.exists()) {
					dirPath.mkdir();
				}
			}
		}
	}
}
