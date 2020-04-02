package com.zpaas.test;



import com.zpaas.file.FileManagerSVC;
import com.zpaas.utils.PaasContextHolder;

public class Test {
	public static void main(String[] args)throws Exception {
		//文件服务，机密文件服务（secureFileSVC）
		FileManagerSVC fileSVC = (FileManagerSVC)PaasContextHolder.getContext().getBean("fileSVC");
		String fileId = fileSVC.saveFile("/Users/ZhangJunyong/Downloads/云嘉LOGO.png", "png");
		fileSVC.readFile(fileId, "/Users/ZhangJunyong/Downloads/云嘉LOGO_bak.png");
		fileSVC.deleteFile(fileId);
	}
}
