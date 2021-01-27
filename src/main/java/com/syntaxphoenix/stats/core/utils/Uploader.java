package com.syntaxphoenix.stats.core.utils;

import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.syntaxphoenix.stats.core.SyntaxPhoenixStats;

public class Uploader {
	
	private String url;

	public Uploader(String url) {
		this.url = url;
	}
	
	public void uploadStats(JsonObject statistics) throws Exception {
		if (statistics == null) {
			throw new IllegalArgumentException("Data cannot be null!");
		}

		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

		connection.setRequestMethod("POST");
		connection.setRequestProperty("User-Agent", "SyntaxPhoenixStats-ServerVersion/" + SyntaxPhoenixStats.SYNTAXPHOENIX_STATS_VERSION);

		connection.setDoOutput(true);
		PrintStream ps = new PrintStream(connection.getOutputStream());
		ps.print("data=" + statistics.toString());
		connection.getInputStream();

		ps.close();
		connection.getInputStream().close();
	}

}
