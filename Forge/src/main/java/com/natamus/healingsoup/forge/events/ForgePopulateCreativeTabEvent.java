package com.natamus.healingsoup.forge.events;

import com.natamus.healingsoup.items.SoupItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgePopulateCreativeTabEvent {
    @SubscribeEvent
    public void buildContents(BuildCreativeModeTabContentsEvent e) {
		if (e.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			e.accept(SoupItems.CACTUS_SOUP);
			e.accept(SoupItems.CHOCOLATE_MILK);
		}
    }
}
