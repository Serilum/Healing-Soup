package com.natamus.healingsoup;

import com.natamus.collective.check.RegisterMod;
import com.natamus.healingsoup.items.SoupFoods;
import com.natamus.healingsoup.items.SoupItems;
import com.natamus.healingsoup.neoforge.config.IntegrateNeoForgeConfig;
import com.natamus.healingsoup.neoforge.events.NeoForgePopulateCreativeTabEvent;
import com.natamus.healingsoup.neoforge.events.NeoForgeSoupEvent;
import com.natamus.healingsoup.util.Reference;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(Reference.MOD_ID)
public class ModNeoForge {

	private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Reference.MOD_ID);

	public static final DeferredItem<Item> MUSHROOM_SOUP_ITEM = ITEMS.register("mushroom_soup", () -> new BowlFoodItem((new Item.Properties()).stacksTo(1).food(SoupFoods.MUSHROOM_SOUP)));
	public static final DeferredItem<Item> CACTUS_SOUP_ITEM = ITEMS.register("cactus_soup", () -> new BowlFoodItem((new Item.Properties()).stacksTo(1).food(SoupFoods.CACTUS_SOUP)));
	public static final DeferredItem<Item> CHOCOLATE_MILK_ITEM = ITEMS.register("chocolate_milk", () -> new BowlFoodItem((new Item.Properties()).stacksTo(1).food(SoupFoods.CHOCOLATE_MILK)));

	
	public ModNeoForge() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::loadComplete);

		ITEMS.register(modEventBus);
		modEventBus.register(NeoForgePopulateCreativeTabEvent.class);

		setGlobalConstants();
		ModCommon.init();

		IntegrateNeoForgeConfig.registerScreen(ModLoadingContext.get());

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadComplete(final FMLLoadCompleteEvent event) {
		SoupItems.MUSHROOM_SOUP = MUSHROOM_SOUP_ITEM.get();
		SoupItems.CACTUS_SOUP = CACTUS_SOUP_ITEM.get();
		SoupItems.CHOCOLATE_MILK = CHOCOLATE_MILK_ITEM.get();

		SoupItems.soups.add(SoupItems.MUSHROOM_SOUP);
		SoupItems.soups.add(SoupItems.CACTUS_SOUP);
		SoupItems.soups.add(SoupItems.CHOCOLATE_MILK);

		NeoForge.EVENT_BUS.register(NeoForgeSoupEvent.class);
	}

	private static void setGlobalConstants() {

	}
}