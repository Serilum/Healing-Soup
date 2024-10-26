package com.natamus.healingsoup.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.healingsoup.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry(min = 0, max = 20) public static int soupHalfHeartHealAmount = 8;

	public static void initConfig() {
		configMetaData.put("soupHalfHeartHealAmount", Arrays.asList(
			"The amount of half hearts the mushroom stew/soup should heal. Minecraft PvP's default was 8."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}