package com.natamus.healingsoup.neoforge.events;

import com.natamus.healingsoup.items.SoupItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.bus.api.SubscribeEvent;

public class NeoForgePopulateCreativeTabEvent {
	@SubscribeEvent
	public static void buildContents(BuildCreativeModeTabContentsEvent e) {
		if (e.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			e.accept(SoupItems.CACTUS_SOUP);
			e.accept(SoupItems.CHOCOLATE_MILK);
		}
	}
}
