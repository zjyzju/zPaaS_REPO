package com.zpaas.file;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zpaas.ConfigurationCenter;
import com.zpaas.ConfigurationWatcher;
import com.zpaas.PaasException;
import com.zpaas.mongo.MongoDBClient;
import com.zpaas.utils.PaasContextHolder;

/**
 * 基于MongoDB的文件服务实现类
 * @author ZhangJunyong
 *
 */
public class MongoFileManagerSVCImpl implements ConfigurationWatcher, FileManagerSVC{
	
	private static final Logger log = LoggerFactory.getLogger(MongoFileManagerSVCImpl.class);
		
	private static final String File_SERVER_KEY = "fileServer";
	private static final String File_REPO_KEY = "fileRepo";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	
	private String fileServer = null;
	private String fileRepo = null;
	private String userName = null;
	private String password = null;
	private MongoDBClient mongo = null;
	private ConfigurationCenter cc = null;
	private String confPath = "/com/zpaas/file/fileManagerSVC";
	
	public MongoFileManagerSVCImpl() {
		
	}
	
	public void init() {
		try {
			process(cc.getConfAndWatch(confPath, this));
			
		} catch (PaasException e) {
			e.printStackTrace();
		}
	}
	
	public void process(String conf) {
		if(log.isInfoEnabled()) {
			log.info("new log configuration is received: {}", conf);
		}
		JSONObject json = JSONObject.fromObject(conf);
		boolean changed = false;
		if(json.getString(File_SERVER_KEY) != null && !json.getString(File_SERVER_KEY).equals(fileServer)) {
			changed = true;
			fileServer = json.getString(File_SERVER_KEY);
		}
		if(json.getString(USERNAME) != null && !json.getString(USERNAME).equals(userName)) {
			changed = true;
			userName = json.getString(USERNAME);
		}
		if(json.getString(PASSWORD) != null && !json.getString(PASSWORD).equals(password)) {
			changed = true;
			password = json.getString(PASSWORD);
		}
		if(json.getString(File_REPO_KEY) != null && !json.getString(File_REPO_KEY).equals(fileRepo)) {
//			changed = true;
			fileRepo = json.getString(File_REPO_KEY);
		}
		if(changed) {
			if(fileServer != null) {
				mongo = new MongoDBClient(fileServer,fileRepo, userName, password);
				if(log.isInfoEnabled()) {
					log.info("log server address is changed to {}", fileServer);
				}
			}
		}
	}
	public String saveFile(String fileName, String fileType) {
		return mongo.saveFile(fileRepo, fileName, fileType);
	}
	public String saveFile(byte[] byteFile, String fileName, String fileType) {
		return mongo.saveFile(fileRepo, byteFile,fileName,fileType);
	}
	public byte[] readFile(String fileId) {
		return mongo.readFile(fileRepo, fileId);
	}
	public byte[] readFileByName(String fileName) {
		return mongo.readFileByName(fileRepo, fileName);
	}
	public void readFile(String fileId, String localFileName) {
		mongo.readFile(fileRepo, fileId, localFileName);
	}
	public void readFileByName(String fileName, String localFileName) {
		mongo.readFileByName(fileRepo, fileName, localFileName);
	}
	public void deleteFile(String fileId) {
		mongo.deleteFile(fileRepo, fileId);
	}
	
	public void deleteFileByName(String fileName) {
		mongo.deleteFileByName(fileRepo, fileName);
	}
	
	
	
	public ConfigurationCenter getCc() {
		return cc;
	}

	public void setCc(ConfigurationCenter cc) {
		this.cc = cc;
	}
	
	public String getConfPath() {
		return confPath;
	}

	public void setConfPath(String confPath) {
		this.confPath = confPath;
	}

	public static void main(String[] args) throws Exception{
		//ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "clientSenderContext.xml" });
		
//		FileManager manager = (FileManager)PaasContextHolder.getContext().getBean("secureFileRepo");
//		System.out.println(manager.saveFile("/Users/ZhangJunyong/Workspace/01_工作文档/01_支付平台/04_支付通道/一般支付和UPOP无卡支付/MerPrK_808080110594439_20141105145807.key", "key"));
//		FileManager manager = (FileManager)PaasContextHolder.getContext().getBean("secureFileRepo");
//		System.out.println(manager.saveFile("/Users/ZhangJunyong/Workspace/01_工作文档/01_支付平台/10_接入文档/测试平台密钥/public.cer", "cer"));
//		manager.readFile("53c398ca30045257c78b6f93", "/Volumes/HD/Downloads/53c398ca30045257c78b6f93");
		FileManagerSVC manager = (FileManagerSVC)PaasContextHolder.getContext().getBean("fileManager");
//		System.out.println(manager.saveFile("/Users/ZhangJunyong/ec_workspace/service/config/distributedRule-local.xml", "xml"));
		System.out.println(manager.saveFile("/Users/ZhangJunyong/Workspace/01_工作文档/01_支付平台/03_机密文件/4111.png", "png"));
//		FileManager manager = (FileManager)PaasContextHolder.getContext().getBean("secureFileRepo");
//		System.out.println(manager.saveFile("/Users/ZhangJunyong/Downloads/terminalMacKey", "key"));
//		System.out.println(manager.saveFile("/Volumes/HD/Downloads/53a7e874392ad15c6df3b835", "key"));
//		manager.readFile("53a7e874392ad15c6df3b835", "/Volumes/HD/Downloads/53a7e874392ad15c6df3b835");
//		File file = new File("/Volumes/HD/Downloads/bbb1.jpg");
		//ByteArrayInputStream bais = new ByteArrayInputStream(manager.readFile("53a39cf515376325c4709694"));
//		FileOutputStream fos = new FileOutputStream(file);
//		fos.write(manager.readFile("53a39cf515376325c4709694"));
		//manager.deleteFile("536e28261a884ead50efe832");
//		manager.deleteFileByName("mongo-java-driver-2.12.0-javadoc.jar");
//		FileManager manager = (FileManager)PaasContextHolder.getContext().getBean("ruleRepo");
//		System.out.println(manager.saveFile("/Users/ZhangJunyong/ec_workspace/service/rule/aipayRule.drl", "drl"));
//		FileManager manager = (FileManager)PaasContextHolder.getContext().getBean("secureFileRepo");
//		System.out.println(manager.saveFile("/Users/ZhangJunyong/Workspace/01_工作文档/01_支付平台/10_接入文档/测试平台密钥/hmall_public_test.cer", "cer"));
//		FileManager manager = (FileManager)PaasContextHolder.getContext().getBean("fileManager");
//		System.out.println(manager.saveFile("/Users/ZhangJunyong/Workspace/01_工作文档/01_支付平台/10_接入文档/平台接口协议/public_key.cer", "cer"));
//		FileManager manager = (FileManager)PaasContextHolder.getContext().getBean("secureFileRepo");
//		System.out.println(manager.saveFile("/Users/ZhangJunyong/Workspace/01_工作文档/01_支付平台/10_接入文档/平台接口协议/test_public_key.cer", "cer"));
//		FileManager manager = (FileManager)PaasContextHolder.getContext().getBean("fileManager");
//		System.out.println(manager.saveFile("/Users/ZhangJunyong/Workspace/01_工作文档/01_支付平台/10_接入文档/测试平台密钥/sign.jpg", "jpg"));
//		FileManager manager = (FileManager)PaasContextHolder.getContext().getBean("fileManager");
//		System.out.println(manager.saveFile("/Users/ZhangJunyong/ec_workspace/distributedDbPrj_multiTenant/config/distributedRule.xml", "xml"));

	}
}
