package kr.co.ca;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.utils.UploadFileUtils;

@Controller
public class UploadController {
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping("/displayfile100")
	@ResponseBody
	public ResponseEntity<byte[]> displayfile100(String filename){
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;
		try {
			in = new FileInputStream(uploadPath + filename);
			org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			try {
				if(in != null) in.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/uploadform", method = RequestMethod.POST)
	public String uploadform(MultipartHttpServletRequest request, Model model) throws Exception {
		String id = request.getParameter("id");
		List<MultipartFile> list = request.getFiles("file");
		List<String> savedNameList = new ArrayList<String>();
		
		for(MultipartFile x : list) {
			String savedName = UploadFileUtils.uploadFile(uploadPath, x);
			savedNameList.add(savedName);
			model.addAttribute("savedNameList", savedNameList);
		}
		
		return "showupload";
	}
	
	@RequestMapping("/uploadform")
	public void uploadform() {
		
	}
}
