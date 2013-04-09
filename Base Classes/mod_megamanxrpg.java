package megateam.megamanxrpg;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "MegamanXRPG", name = "Megaman X RPG", version = "0.0.1 Alpha")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class mod_megamanxrpg
{
       public static final String modid = "mod_megamanxrpg";
       
       @Instance("MegamanXRPG")
   	   public static mod_megamanxrpg instance;
   	
   	   @SidedProxy(clientSide="megateam.megamanxrpg.ClientProxy", serverSide="megateam.megamanxrpg.common.CommonProxy")
   	   public static CommonProxy proxy;
       
   	   public static Block EnergyOre;
   	   public static Item XBlade;
   	   public static Item ZBlade;
   	   
   	   static EnumToolMaterial toolEnergy = net.minecraftforge.common.EnumHelper.addToolMaterial(null, 8, 1000, 15F, 1, 0);
   	   
       @PreInit
       public void preload(FMLPreInitializationEvent preevent)
       {
    	   EnergyOre = new EnergyOre(538, 0).setUnlocalizedName("Condensed Light Particles Ore");
    	   XBlade = new XBlade(539, toolEnergy).setUnlocalizedName("Condensed Light Particle XBlade");
    	   ZBlade = new ZBlade(540, toolEnergy).setUnlocalizedName("Condensed Light Particle ZBlade");
       }
      
       @Init
       public void load(FMLInitializationEvent event)
       {
    	   	proxy.registerBlocks();
    	   	proxy.addNames();
    	   	proxy.registerHandlers();
    	   	proxy.registerRenders();
       }
       
       @PostInit
       public void postload(FMLPostInitializationEvent postevent)
       {
    	   
       }
}