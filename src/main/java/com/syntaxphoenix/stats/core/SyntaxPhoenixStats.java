package com.syntaxphoenix.stats.core;

import java.util.Timer;

import com.syntaxphoenix.stats.core.tasks.UploadTask;
import com.syntaxphoenix.stats.core.utils.Software;
import com.syntaxphoenix.stats.core.utils.Uploader;

public class SyntaxPhoenixStats {

	public static final double SYNTAXPHOENIX_STATS_VERSION = 0.4;

	private static final String URL = "https://stats.syntaxphoenix.com/submit/?type=bukkit";

	private Software software;
	private UploadTask uploadTask;
	private String serverUuid;

	public SyntaxPhoenixStats(Software software) {
		this(software, URL);
	}
	
	public SyntaxPhoenixStats(Software software, String url) {
		this.software = software;
		this.uploadTask = new UploadTask(this, software, new Uploader(url));
		
		// Implement Config here
		
		runStatsTracking();
	}

	private void runStatsTracking() {
		if (!software.isEnabled()) {
			return;
		}
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(uploadTask, 1000 * 60 * 5, 1000 * 60 * 15);
	}

	public String getServerUuid() {
		return serverUuid;
	}

	public void setServerUuid(String serverUuid) {
		this.serverUuid = serverUuid;
	}
}
