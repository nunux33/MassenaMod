
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.centimod.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.centimod.block.CentiniBlockBlock;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CentimodModBlocks {
	private static final List<Block> REGISTRY = new ArrayList<>();
	public static final Block CENTINI_BLOCK = register(new CentiniBlockBlock());

	private static Block register(Block block) {
		REGISTRY.add(block);
		return block;
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Block[0]));
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			CentiniBlockBlock.registerRenderLayer();
		}
	}
}
