package com.natamus.healingsoup.forge.events;

import com.natamus.healingsoup.items.SoupItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgePopulateCreativeTabEvent {
    @SubscribeEvent
    public void onCreativeTab(CreativeModeTabEvent.BuildContents e) {
		if (e.getTab().equals(CreativeModeTabs.FOOD_AND_DRINKS)) {
			e.accept(SoupItems.CACTUS_SOUP);
			e.accept(SoupItems.CHOCOLATE_MILK);
		}
    }
}
