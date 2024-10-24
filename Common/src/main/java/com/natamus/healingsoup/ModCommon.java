package com.natamus.healingsoup;

import com.natamus.collective.functions.CreativeModeTabFunctions;
import com.natamus.collective.services.Services;
import com.natamus.healingsoup.config.ConfigHandler;
import com.natamus.healingsoup.items.SoupFoods;
import com.natamus.healingsoup.items.SoupItems;
import com.natamus.healingsoup.util.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModCommon {

	public static void init() {
		ConfigHandler.initConfig();
		load();
	}

	private static void load() {
		
	}

	public static void registerAssets(Object modEventBusObject) {
		Services.REGISTERITEM.registerItem(modEventBusObject, ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "mushroom_soup"), (properties) -> new Item(properties), new Item.Properties().stacksTo(1).food(SoupFoods.MUSHROOM_SOUP), CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks"));
		Services.REGISTERITEM.registerItem(modEventBusObject, ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "cactus_soup"), (properties) -> new Item(properties), new Item.Properties().stacksTo(1).food(SoupFoods.CACTUS_SOUP), CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks"));
		Services.REGISTERITEM.registerItem(modEventBusObject, ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "chocolate_milk"), (properties) -> new Item(properties), new Item.Properties().stacksTo(1).food(SoupFoods.CHOCOLATE_MILK), CreativeModeTabFunctions.getCreativeModeTabResourceKey("food_and_drinks"), true);
	}

	public static void setAssets() {
		SoupItems.MUSHROOM_SOUP = Services.REGISTERITEM.getRegisteredItem(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "mushroom_soup"));
		SoupItems.CACTUS_SOUP = Services.REGISTERITEM.getRegisteredItem(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "cactus_soup"));
		SoupItems.CHOCOLATE_MILK = Services.REGISTERITEM.getRegisteredItem(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "chocolate_milk"));

		SoupItems.soups.add(SoupItems.MUSHROOM_SOUP);
		SoupItems.soups.add(SoupItems.CACTUS_SOUP);
		SoupItems.soups.add(SoupItems.CHOCOLATE_MILK);
	}
}