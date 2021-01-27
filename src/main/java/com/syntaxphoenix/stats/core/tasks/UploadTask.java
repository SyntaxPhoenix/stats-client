package com.syntaxphoenix.stats.core.tasks;

import java.util.TimerTask;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.syntaxphoenix.stats.core.SyntaxPhoenixStats;
import com.syntaxphoenix.stats.core.tracker.StatsTracker;
import com.syntaxphoenix.stats.core.utils.Software;
import com.syntaxphoenix.stats.core.utils.Uploader;

public class UploadTask extends TimerTask {
	
	private SyntaxPhoenixStats stats;
	private Software software;
	private Uploader uploader;
	
	public UploadTask(SyntaxPhoenixStats stats, Software software, Uploader uploader) {
		this.stats = stats;
		this.software = software;
		this.uploader = uploader;
	}
	
	@Override
	public void run() {	
		try {
			this.uploader.uploadStats(this.packStatistics());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private JsonObject packStatistics() {
		Gson gson = new Gson();
		JsonObject statistics = new JsonObject();
		
		for (StatsTracker tracker : this.software.getTrackers()) {
			JsonElement trackerData = gson.toJsonTree(tracker.collectData(this.stats));
			statistics.add(tracker.getWorkspace(), trackerData);
		}
		
		return statistics;
	}
}
