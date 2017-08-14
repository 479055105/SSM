package cn.com.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.google.gson.Gson;

import cn.com.dao.ManagerInfoMapper;
import cn.com.pojo.ManagerInfo;
import cn.com.service.IManagerInfoServer;

@Controller
public class ManagerInfoController {

	@Resource
	private IManagerInfoServer managerInfoServer;

	@RequestMapping("/managerinfo.action")
	public String Login(ManagerInfo managerInfo, Model model) {
		Map<String, Object> prams = new HashMap<String, Object>();
		List<ManagerInfo> managerinfos = new ArrayList<ManagerInfo>();
		managerinfos = managerInfoServer.selectall(prams);
		System.out.println(managerinfos.size());
		model.addAttribute("managerinfos", managerinfos);

		return "Show";
	}
	
	
	@RequestMapping("/test.action")
	public @ResponseBody
	void myjson(HttpServletResponse response) {
		Map<String, Object> prams = new HashMap<String, Object>();
		List<ManagerInfo> managerinfos = managerInfoServer.selectall(prams);
		String json = null;
		Gson gson = new Gson();
		json = gson.toJson(managerinfos);
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			ServletOutputStream out = response.getOutputStream();
			byte[] b = json.getBytes("utf-8");// ����
			out.write(b);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/download.action")
	public void myDownLoad(String filename,HttpServletResponse response,HttpServletRequest request){
		System.out.println(filename);
		try {
			// ת��
			byte[] b = filename.getBytes("iso-8859-1");
			filename = new String(b, "utf-8");
			System.out.println("filename:" + filename);
			// �ļ���ȡ(�ֽ�)
			//getRealPath()��ȡ����˵�ַ
			String filepath = request.getRealPath("download/" + filename);
			System.out.println("filepath:" + filepath);
			File tempFile = new File(filepath);
			if (tempFile.exists()) {
				// �ļ�����
				// �ļ�����
				request.setCharacterEncoding("utf-8");			
				String userAgent = request.getHeader("User-Agent");
				System.out.println("userAgent:" + userAgent);
				// ϸ�� ����� *=utf-8
				response.setHeader(
						"Content-disposition",
						"attachment;filename*="
								+ URLEncoder.encode(filename, "utf-8"));
				// �����ļ��������
				response.setContentType("application/octet-stream; charset=utf-8");
				// //�����������
				response.setHeader("Content-Length",
						String.valueOf(tempFile.length()));
				InputStream in = new BufferedInputStream(new FileInputStream(
						tempFile));
				//
				FileCopyUtils.copy(in, response.getOutputStream());
				in.close();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/springUpload.action")
	public String upload(HttpServletRequest request, String testid) {
		String res = "error";
		// ����ǰ�����ĳ�ʼ���� CommonsMutipartResolver ���ಿ�ֽ�������
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// ���form���Ƿ���enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// ��request��ɶಿ��request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// ��ȡmultiRequest �����е��ļ���
			Iterator iter = multiRequest.getFileNames();
			boolean flag = true;
			try {
				while (iter.hasNext()) {
					System.out.println("okfile");
					// һ�α��������ļ�
					MultipartFile file = multiRequest.getFile(iter.next()
							.toString());
					if (file != null) {
						String path = request.getRealPath("upload") + "\\"
								+ file.getOriginalFilename();
						System.out.println("path:" + path);
						// �ϴ�
						file.transferTo(new File(path));
					}
				}
				// ������������
				System.out.println("testid:" + testid);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("�ϴ��ļ��쳣");
				flag = false;
			}
			System.out.println("flag:" + flag);
			if (flag) {
				res = "index";
			}
		}
		return res;
	}
	
}
