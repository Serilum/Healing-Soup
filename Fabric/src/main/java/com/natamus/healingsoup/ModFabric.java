package com.natamus.healingsoup;

import com.natamus.collective.check.RegisterMod;
import com.natamus.healingsoup.events.SoupEvent;
import com.natamus.healingsoup.items.SoupFoods;
import com.natamus.healingsoup.items.SoupItems;
import com.natamus.healingsoup.util.Reference;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class ModFabric implements ModInitializer {
	
	@Override
	public void onInitialize() {
		setGlobalConstants();
		ModCommon.init();

		registerItems();

		loadEvents();

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	@SuppressWarnings("UnstableApiUsage")
	private void registerItems() {
		SoupItems.MUSHROOM_SOUP = new BowlFoodItem((new Item.Properties()).stacksTo(1).food(SoupFoods.MUSHROOM_SOUP));
		SoupItems.CACTUS_SOUP = new BowlFoodItem((new Item.Properties()).stacksTo(1).food(SoupFoods.CACTUS_SOUP));
		SoupItems.CHOCOLATE_MILK = new BowlFoodItem((new Item.Properties()).stacksTo(1).food(SoupFoods.CHOCOLATE_MILK));

		Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Reference.MOD_ID, "mushroom_soup"), SoupItems.MUSHROOM_SOUP);
		Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Reference.MOD_ID, "cactus_soup"), SoupItems.CACTUS_SOUP);
		Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Reference.MOD_ID, "chocolate_milk"), SoupItems.CHOCOLATE_MILK);

		SoupItems.soups.add(SoupItems.MUSHROOM_SOUP);
		SoupItems.soups.add(SoupItems.CACTUS_SOUP);
		SoupItems.soups.add(SoupItems.CHOCOLATE_MILK);

		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries -> entries.prepend(SoupItems.CACTUS_SOUP));
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries -> entries.prepend(SoupItems.CHOCOLATE_MILK));
	}

	private void loadEvents() {
		UseItemCallback.EVENT.register((player, world, hand) -> {
			return SoupEvent.onPlayerInteract(player, world, hand);
		});
	}

	private static void setGlobalConstants() {

	}
}
