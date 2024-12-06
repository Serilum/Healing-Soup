package com.natamus.healingsoup.neoforge.events;

import com.natamus.healingsoup.events.SoupEvent;
import net.minecraft.world.InteractionResult;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class NeoForgeSoupEvent {
	@SubscribeEvent
	public static void onPlayerInteract(PlayerInteractEvent.RightClickItem e) {
		if (SoupEvent.onPlayerInteract(e.getEntity(), e.getLevel(), e.getHand()).equals(InteractionResult.FAIL)) {
			e.setCanceled(true);
		}
	}
}