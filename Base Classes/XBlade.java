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
	public boolean onLeftClickEntity(final ItemStack stack, final EntityPlayer player, Entity entity)
	{
		if(stack.isItemDamaged() == false){
			t.schedule(new TimerTask(){
				@Override
				public void run(){
					stack.setItemDamage(950);
					fix(stack);
				}
			}, 10);
			return false;
		}
		else{
			return true;
		}
	}


	protected void fix(final ItemStack stack) {
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				stack.setItemDamage(900);
			}
		}, 100);
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				stack.setItemDamage(850);
			}
		}, 200);
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				stack.setItemDamage(800);
			}
		}, 300);
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				stack.setItemDamage(750);
			}
		}, 400);
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				stack.setItemDamage(700);
			}
		}, 500);
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				stack.setItemDamage(650);
			}
		}, 600);
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				stack.setItemDamage(600);
			}
		}, 700);
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				stack.setItemDamage(550);
			}
		}, 800);
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				stack.setItemDamage(500);
			}
		}, 900);
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				stack.setItemDamage(450);
			}
		}, 1000);
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				stack.setItemDamage(400);
			}
		}, 1100);
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				stack.setItemDamage(350);
			}
		}, 1200);
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				stack.setItemDamage(300);
			}
		}, 1300);
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				stack.setItemDamage(250);
			}
		}, 1400);
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				stack.setItemDamage(200);
			}
		}, 1500);
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				stack.setItemDamage(150);
			}
		}, 1600);
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				stack.setItemDamage(100);
			}
		}, 1700);
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				stack.setItemDamage(50);
			}
		}, 1900);
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				stack.setItemDamage(0);
			}
		}, 2000);
	}
}
