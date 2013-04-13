package megateam.megamanxrpg;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class XBlade extends ItemSword {
	int i = 0;

	protected static Entity entity;
	protected static EntityPlayer player;
	
	private int x;
	int increase = 100;
	int index = 1;

	Timer t = new Timer();

	public XBlade(int id, EnumToolMaterial mat) {
		super(id, mat);
	}
	
	public void updateIcons(IconRegister iconRegister)
	{
	         iconIndex = iconRegister.registerIcon("megamanxrpg:XBlade");
	}

	@Override
	public boolean onLeftClickEntity(final ItemStack stack, final EntityPlayer fplayer, Entity fentity)
	{
		MyPlayerHandler.XEntitySelected = true;
		this.entity = fentity;
		this.player = fplayer;
		return false;
	}
	
	public static Entity getEntity(){
		return entity;
	}
	
	public static EntityPlayer getEntityPlayer(){
		return player;
	}
}
