package xyz.safety.base;

import java.io.InputStream;
import java.util.Properties;

public class SysConfig {

	private static final String SYS_CONFIG = "/sysconf.properties";
	
	private static Properties props = null;

	private SysConfig() {
		
		try {
			InputStream in = this.getClass().getResourceAsStream(SYS_CONFIG);
			props = new Properties();
			props.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static String getProperty(String key){
		if(props == null)
			new SysConfig();
		return props.getProperty(key);
	}
	

}
