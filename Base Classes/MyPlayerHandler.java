package megateam.megamanxrpg;
import java.util.EnumSet;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.player.EntityPlayer;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class MyPlayerHandler implements ITickHandler
{

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
		playerTick((EntityPlayer)tickData[0]);
	}

	private boolean hasJumped = false;
	private void playerTick(EntityPlayer player)
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE) && (player.isJumping || player.isAirBorne) && player.motionY < 0.07 && !hasJumped)
		{
			if(player.motionY >= -0.44749789698341763 && player.motionY <= -0.230527368912964)
			{
				player.addVelocity(0, 0.75, 0);
				hasJumped = true;
			}
			else{
				player.addVelocity(0, 0.5, 0);
				hasJumped = true;
			}
		}
		
		if(player.onGround == true){
			hasJumped = false;
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{

	}

	@Override
	public EnumSet<TickType> ticks()
	{
		return EnumSet.of(TickType.PLAYER);
	}

	@Override
	public String getLabel()
	{
		return "MyPlayerHandler";
	} 

}