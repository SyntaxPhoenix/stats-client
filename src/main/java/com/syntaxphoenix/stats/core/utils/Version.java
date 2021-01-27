package com.syntaxphoenix.stats.core.utils;

public class Version {
	
	private int majorVersion;
	private int minorVersion;
	private int patchVersion;
	
	public Version(int majorVersion, int minorVersion, int patchVersion) {
		this.majorVersion = majorVersion;
		this.minorVersion = minorVersion;
		this.patchVersion = patchVersion;
	}
	
	// TODO: Make this secure for non numberic Inputs
	public Version(String version) {
		this.minorVersion = 0;
		this.patchVersion = 0;
		
		String[] versionParts = version.split(".");
		this.majorVersion = Integer.valueOf(versionParts[0]);
		if (versionParts.length >= 2) {
			this.minorVersion = Integer.valueOf(versionParts[1]);
			if (versionParts.length >= 3) {
				this.patchVersion = Integer.valueOf(versionParts[2]);
			}
		}
		
	}

	public int getPatchVersion() {
		return patchVersion;
	}

	public void setPatchVersion(int patchVersion) {
		this.patchVersion = patchVersion;
	}

	public int getMinorVersion() {
		return minorVersion;
	}

	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}

	public int getMajorVersion() {
		return majorVersion;
	}

	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}
	
	public String toString() {
		return this.majorVersion + "." + this.minorVersion + "." + this.patchVersion;
	}

}
