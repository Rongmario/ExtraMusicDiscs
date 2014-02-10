package ExtraMusics;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mt;
import ww;
import yr;

public class dubstep1
  extends yr
{
  public disc1(int id, String recordName)
  {
    super(id, recordName);
    a(ww.f);
    this.cw = 1;
  }
  
  public String g()
  {
    if (this.a == "dubstepdisks:dubstep1.ogg") {
      return "Extra Music Disks - 1";
    }
    return "C418 - " + this.a;
  }
  
  @SideOnly(Side.CLIENT)
  public void a(mt par1IconRegister)
  {
    this.cz = par1IconRegister.a("dubstepdisks:dubstep1");
  }
}