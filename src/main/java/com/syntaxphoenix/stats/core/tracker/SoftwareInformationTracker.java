package com.syntaxphoenix.stats.core.tracker;

import java.util.HashMap;
import java.util.Map;

import com.syntaxphoenix.stats.core.SyntaxPhoenixStats;
import com.syntaxphoenix.stats.core.utils.Software;

public class SoftwareInformationTracker implements StatsTracker {
	
	private Software software;
	
	public SoftwareInformationTracker(Software software) {
		this.software = software;
	}

	public Map<String, String> collectData(SyntaxPhoenixStats stats) {
		HashMap<String, String> softwareInformation = new HashMap<String, String>();

		softwareInformation.put("Name", this.software.getName());
		softwareInformation.put("Service-ID", this.software.getServiceId());
		softwareInformation.put("Version", this.software.getVersion().toString());
		softwareInformation.put("ServerUUID", stats.getServerUuid());
		
		return softwareInformation;
	}

	public String getWorkspace() {
		return "software-information";
	}

}
