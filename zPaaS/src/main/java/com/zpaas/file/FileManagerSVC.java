package com.zpaas.file;

/**
 * 文件服务接口类
 * @author ZhangJunyong
 *
 */
public interface FileManagerSVC {
	public String saveFile(String fileName, String fileType);
	public String saveFile(byte[] byteFile, String fileName, String fileType);
	public byte[] readFile(String fileId);
	public void readFile(String fileId, String localFileName);
	public void deleteFile(String fileId);
	public byte[] readFileByName(String fileName);
	public void readFileByName(String fileName, String localFileName);
	public void deleteFileByName(String fileName);
}
