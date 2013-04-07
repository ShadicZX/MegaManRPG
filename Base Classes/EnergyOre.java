package megateam.megamanxrpg;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.block.material.Material;

public class EnergyOre extends Block {
	public EnergyOre(int par1, int par2){
		super(par1, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(89.3F);
		this.setResistance(89.5F);
		this.setStepSound(soundMetalFootstep);
	}
	
  	public void registerIcons(IconRegister iconRegister)
  	{
	  	blockIcon = iconRegister.registerIcon("megamanxrpg:oreEnergy");
  	}
}