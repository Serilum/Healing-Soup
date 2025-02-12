package com.natamus.healingsoup.forge.events;

import com.natamus.healingsoup.events.SoupEvent;
import net.minecraft.world.InteractionResult;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeSoupEvent {
	@SubscribeEvent
	public static void onPlayerInteract(PlayerInteractEvent.RightClickItem e) {
		if (SoupEvent.onPlayerInteract(e.getEntity(), e.getLevel(), e.getHand()).getResult().equals(InteractionResult.FAIL)) {
			e.setCanceled(true);
		}
	}
}