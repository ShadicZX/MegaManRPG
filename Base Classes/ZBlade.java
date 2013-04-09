package megateam.megamanxrpg;

import java.util.Timer;
import java.util.TimerTask;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

public class ZBlade extends ItemSword{
	int tickssinceuse = 0;
	boolean cantripleslash = false;
	
	EntityPlayer player = ModLoader.getMinecraftInstance().thePlayer;
	
	Timer t = new Timer();
	
	public ZBlade(int id, EnumToolMaterial mat){
		super(id, mat);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, final Entity entity, int par4, boolean par5) {
		t.schedule(new TimerTask(){
			@Override
			public void run(){
				tickssinceuse++;
			}
		}, 50);
	}
	
	@Override
	public boolean onLeftClickEntity(final ItemStack stack, final EntityPlayer player, final Entity entity)
	{
		return false;
	}
}
