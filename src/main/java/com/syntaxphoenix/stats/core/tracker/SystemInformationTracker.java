package com.syntaxphoenix.stats.core.tracker;

import java.util.HashMap;
import java.util.Map;

import com.syntaxphoenix.stats.core.SyntaxPhoenixStats;

public class SystemInformationTracker implements StatsTracker {

	public Map<String, String> collectData(SyntaxPhoenixStats stats) {
		int javaVersion = this.getVersion();
		String osName = System.getProperty("os.name");
		String osArch = System.getProperty("os.arch");
		String osVersion = System.getProperty("os.version");
		int coreCount = Runtime.getRuntime().availableProcessors();
		long memory = Runtime.getRuntime().totalMemory();
		
		HashMap<String, String> systemInformation = new HashMap<String, String>();

		systemInformation.put("JavaVersion", "Java " + javaVersion);
		systemInformation.put("OS", osName);
		systemInformation.put("OS-Version", osVersion);
		systemInformation.put("OS-Arch", osArch);
		systemInformation.put("Core-Count", "" + coreCount);
		systemInformation.put("Memory", "" + memory);
			
		return systemInformation;
	}

	public String getWorkspace() {
		return "system-information";
	}
	
	private int getVersion() {
	    String version = System.getProperty("java.version");
	    if (version.startsWith("1.")) {
	        version = version.substring(2, 3);
	    } else {
	        int dot = version.indexOf(".");
	        if (dot != -1) {
	        	version = version.substring(0, dot);
	        }
	    }
	    return Integer.parseInt(version);
	}
}
