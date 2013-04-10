package megateam.megamanxrpg;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenders()
	{
		
	}
	public void registerHandlers()
	{
		TickRegistry.registerTickHandler(new MyPlayerHandler(), Side.CLIENT);
	}
}