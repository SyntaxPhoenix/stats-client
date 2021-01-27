package com.syntaxphoenix.stats.core.tracker;

import java.util.Map;

import com.syntaxphoenix.stats.core.SyntaxPhoenixStats;

public interface StatsTracker {
	
	public String getWorkspace();
	
	public Map<String, String> collectData(SyntaxPhoenixStats stats);

}
