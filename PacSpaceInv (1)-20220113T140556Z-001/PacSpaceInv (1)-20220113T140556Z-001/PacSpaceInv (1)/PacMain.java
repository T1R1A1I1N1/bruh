/**
Pacman   
Evan Pouliot   
V1.0   
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PacMain  implements ActionListener, KeyListener
{
  JFrame f1;
  JPanel main, sub;
  PacGraphics g1;
  JButton b1,b2;
  int eatstep,pausecount,level,pellnum,CherTime;
  boolean endgame,start,caneat,cherOne,cherTwo;
  String dd;
  Pacman pac;
  ArrayList<pellet> pels,powpel;
  Ghost[] ghs;
  GameBorder gb;
  Clip audiostart, audioeat, audiodie, audioeatG, audiopause;
  
  public PacMain() 
  { 
      SetVari();
      SetFrame();
      SetGhost();
      SetPell();
      SetPowpel();
      SetMusic();
      runGame();
  }
  
  private void SetMusic()
  {
    try 
    {
      AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("pacman_beginning.wav"));
      audiostart = AudioSystem.getClip();
      audiostart.open(audioIn);
                    
      AudioInputStream audioIn2 = AudioSystem.getAudioInputStream(new File("pacman_chomp.wav"));
      audioeat = AudioSystem.getClip();
      audioeat.open(audioIn2);
    
      AudioInputStream audioIn3 = AudioSystem.getAudioInputStream(new File("pacman_death.wav"));
      audiodie = AudioSystem.getClip();
      audiodie.open(audioIn3);
      
      AudioInputStream audioIn4 = AudioSystem.getAudioInputStream(new File("pacman_eatghost.wav"));
      audioeatG = AudioSystem.getClip();
      audioeatG.open(audioIn4);
      
      AudioInputStream audioIn5 = AudioSystem.getAudioInputStream(new File("pacman_intermission.wav"));
      audiopause = AudioSystem.getClip();
      audiopause.open(audioIn5);
    } 
    catch(Exception ex) 
    {
      System.out.println("Error with playing sound.");
      ex.printStackTrace();
    }
  }
  
  private void SetVari()
  {
    gb = new GameBorder(0,0,770,690);
    pac = new Pacman(270,660,gb,1.2);
    pels = new ArrayList<pellet>();
    ghs = new Ghost[4];
    powpel = new ArrayList<pellet>();
    
    dd = "";
    endgame = false;
    caneat = false;
    start = false;
    level = 1;
    pausecount = 500;
    }
  private void SetFrame()
  {
    f1 = new JFrame("Graphics Example");
      f1.setSize(800,800);
      f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c1 = f1.getContentPane();
        
    g1 = new PacGraphics(pac,ghs,endgame,pels,powpel,gb);
      g1.addKeyListener(this);
          
    b1 =  new JButton("Start");
      b1.addActionListener(this);
        
    b2 =  new JButton("End");
      b2.addActionListener(this);
         
    sub = new JPanel(); 
      sub.add(b1);
      sub.add(b2);
                     
    main = new JPanel();
      main.setLayout(new BorderLayout());          
      main.setSize(600,600);
      main.add(g1,BorderLayout.CENTER);
      main.add(sub,BorderLayout.SOUTH);
       
    c1.add(main);
    f1.show();
  }
  private void SetGhost()
  {
    ghs[0] = new Ghost(540,270,gb,1);
    ghs[1] = new Ghost(540,270,gb,1);
    ghs[2] = new Ghost(540,270,gb,1);
    ghs[3] = new Ghost(540,270,gb,1);
  }
  private void SetPell()
  {
     for (int index = 0; index < 11; index++)
     {
        pels.add(new pellet(index*54+10,10));
        pels.add(new pellet(index*54+10,280));
        pels.add(new pellet(index*54+10,550));
        pels.add(new pellet(index*54+10,670));
        pels.add(new pellet(10,index*54+10));
        pels.add(new pellet(280,index*54+10));
        pels.add(new pellet(550,index*54+10));
        pels.add(new pellet(750,index*54+10));
     }
     for (int index = 0; index < 4; index++)
     {
        pels.add(new pellet(index*50+600,10));
        pels.add(new pellet(index*50+600,280));
        pels.add(new pellet(index*50+600,550));
        pels.add(new pellet(index*50+600,670));
     }
     for (int index = 0; index < 3; index++)
     {
        pels.add(new pellet(10,index*40+590));
        pels.add(new pellet(280,index*40+590));
        pels.add(new pellet(550,index*40+590));
        pels.add(new pellet(750,index*40+590));
     }
     for (int index = 0; index < pels.size(); index++)
     {
        for (int i = 0; i < pels.size(); i++)
        {
          if(pels.get(index).getX() == pels.get(i).getX() && i != index && pels.get(index).getY() == pels.get(i).getY())
          {
            pels.remove(i);
          }
        }
        if (pels.get(index).getDestroyed() == true)
        {
          pels.remove(index);
        }
     }
     pellnum = pels.size();
  }
    
  private void SetPowpel()
  {
    powpel.add(new pellet(5,5));
    powpel.add(new pellet(5,665));
    powpel.add(new pellet(745,5));
    powpel.add(new pellet(745,665));
  }
  
  public void runGame()
  {
    Thread runner = new Thread();
    while(!endgame)
    {    
      try 
      { 
        runner.sleep(5); 
      }
      catch(InterruptedException e) {}  
      if (start && pausecount < 0)
      { 
        PacPel();
        PacGhost();
        PacPowpel();
        PacCher();
        GhostDir();
        SendInfo();
        MusicRestart();
        DrawCher();
        if (pels.size() == 0 && powpel.size() == 0)
        {
          ResetGame();
        }
      }
      else
      {
        pausecount--;
      }
    } 
  } 
  private void PacCher()
  {
    
  }
  private void DrawCher()
  {
    CherTime --;
    if (pellnum*0.75 > pels.size() && cherOne == false)
    {
      
    }
    if (pellnum*0.4 > pels.size() && cherTwo == false)
    {
      
    }
    
  }
  private void MusicRestart()
  {
    if(audioeat.getMicrosecondPosition() >= audioeat.getMicrosecondLength())
    {
      audioeat.setMicrosecondPosition(0);
    }
    if(audioeatG.getMicrosecondPosition() >= audioeatG.getMicrosecondLength())
    {
      audioeatG.setMicrosecondPosition(0);
    }
    if(audiodie.getMicrosecondPosition() >= audiodie.getMicrosecondLength())
    {
      audiodie.setMicrosecondPosition(0);
    }
    if(audiopause.getMicrosecondPosition() >= audiopause.getMicrosecondLength())
    {
      audiopause.setMicrosecondPosition(0);
    }
  }
  private void ResetGame()
  {
    audiopause.start();
    pac.setX(270);
    pac.setY(660);
    SetPell();
    SetPowpel();
    for (int index = 0; index < 4; index++)
    {
      ghs[index].setX(540);
      ghs[index].setY(270);
      ghs[index].fixObject();
      ghs[index].increaseSpeed();
    }
    caneat = false;
    cherOne = false;
    cherTwo = false;
    pausecount = 500;
    level++;
  }
  private void SendInfo()
  {
    pac.changeDir(dd);
    pac.moveObject();
    g1.updateLocation(pac,level);
    g1.ghostStuff(ghs,powpel,eatstep,pels);
    
    g1.repaint();
  }
    
  private void GhostDir()
  {
      if (!caneat)
      {
        for (int index = 0; index < 4; index++)
        {
          //ghs[index].randomDir();
          ghs[index].sendMove(2,pac);
          //ghs[index].chaseDir(pac);
          //ghs[index].runDir(pac);
        }
      }
      else
      {
        for (int index = 0; index < 4; index++)
        {
          //ghs[index].randomDir();
          ghs[index].sendMove(3,pac);
          //ghs[index].chaseDir(pac);
          //ghs[index].runDir(pac);
        }
      }
    
  }
    
  private void PacPowpel()
  {
    for (int index = 0; index < powpel.size(); index++)
    { 
      if(pac.getX() >= powpel.get(index).getX()-10 && pac.getX() <= powpel.get(index).getX() + 20 && pac.getY() >= powpel.get(index).getY() - 10 && pac.getY() <= powpel.get(index).getY() + 20)
      {
        powpel.remove(index);
        pac.addScore(40);
        caneat = true;
        eatstep = 0;
        for (int i = 0; i < 4; i++)
        {
          ghs[i].setEat(caneat);
        }
      }
    }
  }
    
  private void PacGhost()
  {
    if (!caneat)
    {
      for (int index = 0; index < 4; index++)
      {  
        if(pac.getX() >= ghs[index].getX()-20 && pac.getX() <= ghs[index].getX() + 20 && pac.getY() >= ghs[index].getY() - 10 && pac.getY() <= ghs[index].getY() + 20 && ghs[index].getDestroyed() == false)
        {
          audiodie.start();
          if (pac.getLives() <= 0)
          {
            endgame= true;
            g1.hitGhost(endgame);
          }
          else 
          {
            audiodie.start();
            PacDie();  
          }
        } 
        ghs[index].moveGhost(); 
        ghs[index].moveObject();
      }
    }
    else
    {
      eatstep = eatstep + 1;
      for (int index = 0; index < 4; index++)
      {  
        if(pac.getX() >= ghs[index].getX()-20 && pac.getX() <= ghs[index].getX() + 20 && pac.getY() >= ghs[index].getY() - 10 && pac.getY() <= ghs[index].getY() + 20 && ghs[index].getDestroyed() == false)
        {
           audioeatG.start();
           ghs[index].destroyObject();
           pac.addScore(200);
        } 
        ghs[index].moveGhost(); 
        ghs[index].moveObject();
      }
      if (eatstep >= 800)
      {
        caneat = false;
        for (int i = 0; i < 4; i++)
        {
          ghs[i].setEat(caneat);
        }
      }
    }
  }
  
  private void PacDie()
  {
    pac.pacDie();
    pac.setX(270);
    pac.setY(660);
    for (int i = 0; i < 4; i++)
    {
      ghs[i].setX(540);
      ghs[i].setY(270);
    }
    caneat = false;
    pausecount = 500;
  }
  private void PacPel()
  {
    for (int index = 0; index < pels.size(); index++)
    { 
       if(pac.getX() >= pels.get(index).getX()-15 && pac.getX() <= pels.get(index).getX() + 20 && pac.getY() >= pels.get(index).getY() - 15 && pac.getY() <= pels.get(index).getY() + 20)
       {
         audioeat.start();
         pels.remove(index);
         pac.addScore(10);
       }
    }
  }
    
  public void actionPerformed (ActionEvent event)
  {
     if (event.getSource() == b1)
     {
       start = true; 
       g1.requestFocus();
       audiostart.start();
     }
     if (event.getSource() == b2)
     {
       endgame = true;
     }
    }
    
  public void keyPressed(KeyEvent evt)
  {
     if(evt.getKeyCode() == 38)
     {
       dd = "up";
       pac.changeDir(dd);
     }
     if(evt.getKeyCode() == 40)
     {
       dd = "down";
       pac.changeDir(dd);
     }
     if(evt.getKeyCode() == 37)
     {
       dd = "left";
       pac.changeDir(dd);
     }
     if(evt.getKeyCode() == 39)
     {
       dd = "right";
       pac.changeDir(dd);
     }  
  }
    
  public void keyReleased(KeyEvent evt)
  {}
    
  public void keyTyped(KeyEvent evt)
  {}
}