package com.syntaxphoenix.stats.core.utils;

import java.util.List;

import com.syntaxphoenix.stats.core.tracker.SoftwareInformationTracker;
import com.syntaxphoenix.stats.core.tracker.StatsTracker;
import com.syntaxphoenix.stats.core.tracker.SystemInformationTracker;

public class Software {
	
	private String name;
	private String serviceId;
	
	private Version version;
	
	private boolean enabled;
	
	private List<StatsTracker> trackers;
	
	public Software(String name, String serviceId, Version version, boolean enabled, List<StatsTracker> trackers) {
		this.name = name;
		this.serviceId = serviceId;
		this.version = version;
		this.enabled = enabled;
		this.trackers = trackers;
		this.trackers.add(new SoftwareInformationTracker(this));
		this.trackers.add(new SystemInformationTracker());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<StatsTracker> getTrackers() {
		return trackers;
	}

	public void setTrackers(List<StatsTracker> trackers) {
		this.trackers = trackers;
	}
}
