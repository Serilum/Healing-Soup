package com.natamus.healingsoup.forge.events;

import com.natamus.healingsoup.events.SoupEvent;
import net.minecraft.world.InteractionResult;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeSoupEvent {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeSoupEvent.class);

		PlayerInteractEvent.RightClickItem.BUS.addListener(ForgeSoupEvent::onPlayerInteract);
	}

	@SubscribeEvent
	public static boolean onPlayerInteract(PlayerInteractEvent.RightClickItem e) {
		if (SoupEvent.onPlayerInteract(e.getEntity(), e.getLevel(), e.getHand()).equals(InteractionResult.FAIL)) {
			return true;
		}
		return false;
	}
}