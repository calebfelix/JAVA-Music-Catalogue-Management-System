/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccataloguemasy;


import AppPackage.AnimationClass;
import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javazoom.jl.player.Player;



/**
 *
 * @author Nancy Merciline
 */
public class Homepage extends javax.swing.JFrame {
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    playlist pl = new playlist();
    playlist sl = new playlist();
    playlist dl = new playlist();
    AnimationClass ac = new AnimationClass();
    
    
    
 
    
private Player player1;
private Player player2;
private Player player3;
private FileInputStream FIS;
private BufferedInputStream BIS;
private boolean canResume;
private boolean canResume2;
private boolean canResume3;
private boolean ispressed;
private String path;
private int total;
private int stopped;
private boolean valid;
private boolean valid2;
private boolean valid3;
boolean anim = true;
////////////////////////////////////////////////////////////////////////////
    
    ArrayList updateList = new ArrayList();
    ArrayList update = new ArrayList();
    ArrayList updateDownload = new ArrayList();
    
   
    File simpan;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Creates new form Homepage
     */
    MySQLConnect myc;
  
    public Homepage(String UNAME) {
    
    player1 = null;
    player2 = null;
    player3 = null;
    FIS = null;
    valid = false;
    valid2 = false;
    valid3=false;
    BIS = null;
    path = null;
    total = 0;
    stopped = 0;
    canResume = false;
    canResume2 = false;
    ispressed=false;
        initComponents();
        
        trackname_var.setBackground(new java.awt.Color(29,24,36));
        artist_var.setBackground(new java.awt.Color(29,24,36));
        path_var.setBackground(new java.awt.Color(29,24,36));
        genre_var.setBackground(new java.awt.Color(29,24,36));
        description_var.setBackground(new java.awt.Color(29,24,36));
        
        trackname_var.setForeground(new java.awt.Color(235,224,249));
        artist_var.setForeground(new java.awt.Color(235,224,249));
        path_var.setForeground(new java.awt.Color(235,224,249));
        genre_var.setForeground(new java.awt.Color(235,224,249));
        description_var.setForeground(new java.awt.Color(235,224,249));
        
        
        
        home_btn_var.setBackground(new Color(187,83,251));
        
        playlist_btn_var.setBackground(new Color(208,173,252));
        search_btn_var.setBackground(new Color(208,173,252));
        create_btn_var.setBackground(new Color(208,173,252));
        downloads_btn_var.setBackground(new Color(208,173,252));
        


        
        desc_var.setBackground(new java.awt.Color(29,24,36));
        desc_var.setForeground(new java.awt.Color(235,224,249));
        desc_var.setEditable(false);
        
        logout_var.setFocusPainted(false);
        
        HOME_UNAME.setText(UNAME);
        
                
        description_var.setLineWrap(true);
        description_var.setWrapStyleWord(true);
        
        desc_var.setLineWrap(true);
        desc_var.setWrapStyleWord(true);
        
        updateList();
        update();
        updateDownload();
        

        slideshow();
//        home_var.setEnabled(false);
//        jPanel4.setEnabled(false);
        myc = new MySQLConnect();
        setVisible(true);
        setLocationRelativeTo(null);
        
        
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    
public void slideshow(){
//        int a = jLabel1.getWidth();
//        System.out.println(a);
        int timestamp = 2000;
        Thread th;
        th = new Thread()  {
            @Override
            public void run() {
                int nb=0;
                try{
                    
                    
                    while (anim) {                        
                        switch(nb){

                            case 0:
                                
                                ImageIcon II = new ImageIcon(getClass().getResource("/images/smoke.jpg.png"));
                                JL1.setIcon(II);
                                
                                Thread.sleep(timestamp);
                                ac.jLabelXLeft(0, -500, 12, 10, JL1);
                                ac.jLabelXLeft(500, 0, 12, 10, JL2);
                                
                                System.out.println("done"+nb);
                                nb++;
                                break;
                                
                            case 1:
                                
                                ImageIcon II2 = new ImageIcon(getClass().getResource("/images/aw.png"));
                                JL2.setIcon(II2);
                                
                                Thread.sleep(timestamp);
                                ac.jLabelXRight(-500, 0, 12, 10, JL1);
                                ac.jLabelXRight(0, 500, 12, 10, JL2);
                                
                                System.out.println("done"+nb);
                                nb++;
                                break;        
                                
                            case 2:
                                
                                ImageIcon II3 = new ImageIcon(getClass().getResource("/images/bill.png"));
                                JL1.setIcon(II3);
                                Thread.sleep(timestamp);
                                ac.jLabelXLeft(0, -500, 12, 10, JL1);
                                ac.jLabelXLeft(500, 0, 12, 10, JL2);
                                
                                System.out.println("done"+nb);
                                nb++;
                                break;
                                
                            case 3:
                                ImageIcon II4  = new ImageIcon(getClass().getResource("/images/ed.png"));
                                JL2.setIcon(II4);
                                
                                Thread.sleep(timestamp);
                                ac.jLabelXRight(-500, 0, 12, 10, JL1);
                                ac.jLabelXRight(0, 500, 12, 10, JL2);
                                
                                System.out.println("done"+nb);
                                nb++;
                                break;
                                
                            case 4:
                                
                                ImageIcon II5 = new ImageIcon(getClass().getResource("/images/kha.png"));
                                JL1.setIcon(II5);
                                
                                Thread.sleep(timestamp);
                                ac.jLabelXLeft(0, -500, 12, 10, JL1);
                                ac.jLabelXLeft(500, 0, 12, 10, JL2);
                                
                                System.out.println("done"+nb);
                                nb++;
                                break;
                                
                            case 5:
                                
                                ImageIcon II6  = new ImageIcon(getClass().getResource("/images/taeswe.png"));
                                JL2.setIcon(II6);
                                
                                Thread.sleep(timestamp);
                                ac.jLabelXRight(-500, 0, 12, 10, JL1);
                                ac.jLabelXRight(0, 500, 12, 10, JL2);
                                
                                System.out.println("done"+nb);
                                nb++;
                                break;
                                
                            case 6:
                                
                                ImageIcon II7 = new ImageIcon(getClass().getResource("/images/trav.png"));
                                JL1.setIcon(II7);
                                
                                Thread.sleep(timestamp);
                                ac.jLabelXLeft(0, -500, 12, 10, JL1);
                                ac.jLabelXLeft(500, 0, 12, 10, JL2);
                                
                                System.out.println("done"+nb);
                                nb++;
                                break;
                                
                            case 7:
                                
                                ImageIcon II8  = new ImageIcon(getClass().getResource("/images/pm.png"));
                                JL2.setIcon(II8);
                                
                                Thread.sleep(timestamp);
                                ac.jLabelXRight(-500, 0, 12, 10, JL1);
                                ac.jLabelXRight(0, 500, 12, 10, JL2);
                                
                                System.out.println("done"+nb);
                                nb++;
                                break;
                                
                                case 8:
                                
                                ImageIcon II9 = new ImageIcon(getClass().getResource("/images/ag.png"));
                                JL1.setIcon(II9);
                                
                                Thread.sleep(timestamp);
                                ac.jLabelXLeft(0, -500, 12, 10, JL1);
                                ac.jLabelXLeft(500, 0, 12, 10, JL2);
                                
                                System.out.println("done"+nb);
                                nb++;
                                break;
                                
                            case 9:
                                
                                ImageIcon II10  = new ImageIcon(getClass().getResource("/images/jw.png"));
                                JL2.setIcon(II10);
                                
                                Thread.sleep(timestamp);
                                ac.jLabelXRight(-500, 0, 12, 10, JL1);
                                ac.jLabelXRight(0, 500, 12, 10, JL2);
                                
                                System.out.println("done"+nb);
                                nb++;
                                break;
                                
                                
                                case 10:
                                
                                ImageIcon II11 = new ImageIcon(getClass().getResource("/images/jonb.png"));
                                JL1.setIcon(II11);
                                
                                Thread.sleep(timestamp);
                                ac.jLabelXLeft(0, -500, 12, 10, JL1);
                                ac.jLabelXLeft(500, 0, 12, 10, JL2);
                                
                                System.out.println("done"+nb);
                                nb++;
                                break;
                                
                            case 11:
                                
                                ImageIcon II12  = new ImageIcon(getClass().getResource("/images/smoke1.jpg.png"));
                                JL2.setIcon(II12);
                                
                                Thread.sleep(timestamp);
                                ac.jLabelXRight(-500, 0, 12, 10, JL1);
                                ac.jLabelXRight(0, 500, 12, 10, JL2);
                                
                                System.out.println("done"+nb);
                                nb=0;
                                break;
                                                             
                        }
                    }
                    
                }catch(Exception ex){
                    
                }
               
            }
            
        };
                th.start();
    }    
    
    
void updateList() {
        updateList = pl.getListSong(HOME_UNAME.getText());
        System.out.println("helllllllllllllllllllllllllllllllllllllllll"+updateList);
        DefaultListModel model =  new DefaultListModel();
        for (int i = 0; i < updateList.size(); i++) {
            int j = i + 1;
            
            GetInfo gf = new GetInfo();
            File p = (File) updateList.get(i);
            String pa = (String)p.getAbsolutePath();
            
             String ui = gf.getUserId(pa);
             int ti = gf.getTrackid(pa);
             String tn = gf.getTrackName(pa);
             String art = gf.getTrackArtist(pa);
             String gen = gf.getTrackGenre(pa);
             String des = gf.getTrackDescription(pa);
            String a = j + " | "+"#"+ti+"  "+tn+"\n by: "+art;
            
            model.add(i,a);
        }
        Playlist_list.setModel(model);
   }    

void update() {
        update = sl.getAllsong();
        System.out.println("helllllllllllllllllllllllllllllllllllllllll"+update);
        DefaultListModel model =  new DefaultListModel();
        for (int i = 0; i < update.size(); i++) {
            int j = i + 1;
            
            GetInfo gf = new GetInfo();
            File p = (File) update.get(i);
            String pa = (String)p.getAbsolutePath();
            
             String ui = gf.getUserId(pa);
             int ti = gf.getTrackid(pa);
             String tn = gf.getTrackName(pa);
             String art = gf.getTrackArtist(pa);
             String gen = gf.getTrackGenre(pa);
             String des = gf.getTrackDescription(pa);
            String a = j + " | "+"#"+ti+"  "+tn+"\n by: "+art;
            
            
            model.add(i,a);
        }
        search_list.setModel(model);
   }

void updateDownload() {
        updateDownload = dl.getDownload(HOME_UNAME.getText());
        System.out.println("helllllllllllllllllllllllllllllllllllllllll"+updateDownload);
        DefaultListModel model =  new DefaultListModel();
        for (int i = 0; i < updateDownload.size(); i++) {
            int j = i + 1;
            
            GetInfo gf = new GetInfo();
            File p = (File) updateDownload.get(i);
            String pa = (String)p.getAbsolutePath();
            
             String ui = gf.getUserId(pa);
             int ti = gf.getTrackid(pa);
             String tn = gf.getTrackName(pa);
             String art = gf.getTrackArtist(pa);
             String gen = gf.getTrackGenre(pa);
             String des = gf.getTrackDescription(pa);
             int did = gf.getdownload_id(pa);
            String a = j + " | "+"#"+ti+"  "+tn+"\n by: "+art;
            
            
            model.add(i,a);
        }
        download_list.setModel(model);
   }



void reset(){
    trackname_var.setText("");
        artist_var.setText("");
        description_var.setText("");
        genre_var.setText("");
        path_var.setText("");
        
}


void add(){
    pl.add(this);
    updateList();
}




int getTrackid(String pathh){
    int trackid=0 ;
    try {
        
        Connection con = myc.getConn();
        PreparedStatement pst ;
        String sql = "select * from tracks where audio=?";
        pst = con.prepareStatement(sql);
        pst.setString(1, pathh);
        ResultSet rs=pst.executeQuery();       
        while(rs.next()){
             trackid = rs.getInt("track_id");
            }       
        } catch (Exception e) {
            System.out.println("couldnt get track id");
        }
    return trackid;
}


void remove(){
    try{
        int index = Playlist_list.getLeadSelectionIndex();
        
        
        
        System.out.println(("this is :"+pl.ls.get(index)));
        File f = (File) pl.ls.get(index);
        System.out.println((String)f.getPath());
        int trackid = getTrackid((String)f.getPath());
        
        try {
        Connection con = myc.getConn();
        
        PreparedStatement pst1 ;        
        String pre =  "SET FOREIGN_KEY_CHECKS=0";
        pst1 = con.prepareStatement(pre);
        pst1.executeUpdate();
        
        PreparedStatement pst2 ;        
        String sql =  "delete from tracks where track_id=?";
        pst2 = con.prepareStatement(sql);
        pst2.setInt(1, trackid);
        pst2.executeUpdate();
       
        
        PreparedStatement pst3 ;        
        String post =  "SET FOREIGN_KEY_CHECKS=1";
        pst3 = con.prepareStatement(post);
        pst3.executeUpdate();
        
        } catch (Exception e) {
            
            System.out.println("does not connect to db");
        }
        
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "couldnt remove");
    }
}

int getTrackidDown(String pathh){
    int trackid=0 ;
    try {
        
        Connection con = myc.getConn();
        PreparedStatement pst ;
        String sql = "select * from downloads where audio=? and user_id=?";
        pst = con.prepareStatement(sql);
        pst.setString(1, pathh);
        pst.setString(2, HOME_UNAME.getText());
        ResultSet rs=pst.executeQuery();       
        while(rs.next()){
             trackid = rs.getInt("track_id");
            }       
        } catch (Exception e) {
            System.out.println("couldnt get track id");
        }
    return trackid;
}

void removeDown(){
    int index = download_list.getLeadSelectionIndex();
        
        
        
        System.out.println(("this is :"+dl.down.get(index)));
        File f = (File) dl.down.get(index);
        System.out.println((String)f.getPath());
        int trackid = getTrackidDown((String)f.getPath());
        
        try {
        Connection con = myc.getConn();
        PreparedStatement pst ;

        String sql = "delete from downloads where track_id=? and user_id=?";
        pst = con.prepareStatement(sql);
        pst.setInt(1, trackid);
        pst.setString(2, HOME_UNAME.getText());
        
        
        pst.executeUpdate();
       
        
        } catch (Exception e) {
            
            System.out.println("does not connect to db");
        }
}

void up(){
    try{
        int s1 = Playlist_list.getLeadSelectionIndex();
        simpan = (File) pl.ls.get(s1);
        pl.ls.remove(s1);
        pl.ls.add(s1 - 1, simpan );
        updateList();
        Playlist_list.setSelectedIndex(s1-1);
    }catch(Exception e){
    }
}

void down(){
    try{
        int s1 = Playlist_list.getLeadSelectionIndex();
        simpan = (File) pl.ls.get(s1);
        pl.ls.remove(s1);
        pl.ls.add(s1 + 1, simpan );
        updateList();
        Playlist_list.setSelectedIndex(s1+1);
    }catch(Exception e){
    }
}

void open(){
    pl.openPls(this);
    updateList();
}

void save(){
    pl.saveAsPlaylist(this);
    updateList();
}

File plai;


public void pause_1(){
    try{
    stopped = FIS.available();
    player1.close();
    FIS = null;
    BIS = null;
    player1 = null;
    if(valid) canResume = true;
        pause_var.setEnabled(false);
        pause2_var.setEnabled(false);
        pause3_var.setEnabled(false);
        System.out.println("pause");
        play_var.setEnabled(true);
        play2_var.setEnabled(true);
        play3_var.setEnabled(true);
        
    }catch(Exception e){

    }
}

public void pause_2(){
    try{
    stopped = FIS.available();
    player2.close();
    FIS = null;
    BIS = null;
    player2 = null;
    if(valid2) canResume2 = true;
        pause_var.setEnabled(false);
        pause2_var.setEnabled(false);
        pause3_var.setEnabled(false);
        System.out.println("pause");
        play_var.setEnabled(true);
        play2_var.setEnabled(true);
        play3_var.setEnabled(true);
        
    }catch(Exception e){

    }
}

public void pause_3(){
    try{
    stopped = FIS.available();
    player3.close();
    FIS = null;
    BIS = null;
    player3 = null;
    if(valid3) canResume3 = true;
        pause_var.setEnabled(false);
        pause2_var.setEnabled(false);
        pause3_var.setEnabled(false);
        System.out.println("pause");
        play_var.setEnabled(true);
        play2_var.setEnabled(true);
        play3_var.setEnabled(true);
        
    }catch(Exception e){

    }
}


public void resume_1(){
    if(!canResume) return;
    if(putar_1(total-stopped)) canResume = false;
}

public void resume_2(){
    if(!canResume2) return;
    if(putar_2(total-stopped)) canResume2 = false;
}

public void resume_3(){
    if(!canResume3) return;
    if(putar_3(total-stopped)) canResume3 = false;
}


public boolean putar_1(int pos){
    valid = true;
    canResume = false;
    try{
     int p1 = Playlist_list.getSelectedIndex();
     plai = (File) this.updateList.get(p1);
    FIS = new FileInputStream(plai);
    total = FIS.available();
    if(pos > -1) FIS.skip(pos);
    BIS = new BufferedInputStream(FIS);
    player1 = new Player(BIS);
    new Thread(
            new Runnable(){
                public void run(){
                    try{
                        play_var.setEnabled(false);
                        play2_var.setEnabled(false);
                        play3_var.setEnabled(false);
                        player1.play();
                        play_var.setEnabled(true);
                        play2_var.setEnabled(true);
                        play3_var.setEnabled(true);
                        System.out.println("song done");   
                        
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Error playing mp3 file");
                        
                        valid = false;
                    }
                }
            }
    ).start();
    }catch(Exception e){
//        JOptionPane.showMessageDialog(null, "Select mp3 file");
System.out.println("player1 empty");
//        playlist_btn_var.doClick();
        valid = false;
        
    }
     
    return valid;
}



public boolean putar_2(int pos){
    valid2 = true;
    canResume2 = false;
    try{
     int p1 = search_list.getSelectedIndex();
     plai = (File) this.update.get(p1);
    FIS = new FileInputStream(plai);
    total = FIS.available();
    if(pos > -1) FIS.skip(pos);
    BIS = new BufferedInputStream(FIS);
    player2 = new Player(BIS);
    new Thread(
            new Runnable(){
                public void run(){
                    try{
                        play_var.setEnabled(false);
                        play2_var.setEnabled(false);
                        play3_var.setEnabled(false);
                        player2.play();
                        play_var.setEnabled(true);
                        play2_var.setEnabled(true);
                        play3_var.setEnabled(true);
                        System.out.println("song done");   
                        
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Error playing mp3 file");
                        
                        valid2 = false;
                    }
                }
            }
    ).start();
    }catch(Exception e){
//        JOptionPane.showMessageDialog(null, "Select mp3 file");
System.out.println("player2 empty");
//        search_btn_var.doClick();
        valid2 = false;
        
    }
     
    return valid2;
}


public boolean putar_3(int pos){
    valid3= true;
    canResume3 = false;
    try{
     int p1 = download_list.getSelectedIndex();
     plai = (File) this.updateDownload.get(p1);
    FIS = new FileInputStream(plai);
    total = FIS.available();
    if(pos > -1) FIS.skip(pos);
    BIS = new BufferedInputStream(FIS);
    player3 = new Player(BIS);
    new Thread(
            new Runnable(){
                public void run(){
                    try{
                        play_var.setEnabled(false);
                        play2_var.setEnabled(false);
                        play3_var.setEnabled(false);
                        player3.play();
                        play_var.setEnabled(true);
                        play2_var.setEnabled(true);
                        play3_var.setEnabled(true);
                        System.out.println("song done");   
                        
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Error playing mp3 file");
                        
                        valid3 = false;
                    }
                }
            }
    ).start();
    }catch(Exception e){
//        JOptionPane.showMessageDialog(null, "Select mp3 file");
System.out.println("player3 empty");
//        downloads_btn_var.doClick();
        valid3 = false;
        
    }
     
    return valid3;
}

public boolean canResume(){
    return canResume;
}

File sa;
void next_1(){
    
        try{
            player1.close();
            int s1 = Playlist_list.getSelectedIndex() +1;
            sa = (File) this.pl.ls.get(s1);
            FileInputStream fis = new FileInputStream(sa);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player1 = new javazoom.jl.player.Player(bis);
            
            Playlist_list.setSelectedIndex(s1);
        }catch(Exception e){
            System.out.println("Problem playing file");
            System.out.println(e);
            try{
            player1.close();
            int s1 = 0;
            sa = (File) this.pl.ls.get(s1);
            FileInputStream fis = new FileInputStream(sa);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player1 = new javazoom.jl.player.Player(bis);
            
            Playlist_list.setSelectedIndex(s1);
        }catch(Exception er){
            
                System.out.println(er);
        }
            
            
        }
        pause_var.setEnabled(true);
        pause2_var.setEnabled(true);
        pause3_var.setEnabled(true);
        putar_1(-1);

}

void next_2(){
    
        try{
            player2.close();
            int s1 = search_list.getSelectedIndex() +1;
            sa = (File) this.sl.sear.get(s1);
            FileInputStream fis = new FileInputStream(sa);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player2 = new javazoom.jl.player.Player(bis);
            
            search_list.setSelectedIndex(s1);
        }catch(Exception e){
            System.out.println("Problem playing file");
            System.out.println(e);
            try{
            player2.close();
            int s1 = 0;
            sa = (File) this.sl.sear.get(s1);
            FileInputStream fis = new FileInputStream(sa);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player2 = new javazoom.jl.player.Player(bis);
            
            search_list.setSelectedIndex(s1);
        }catch(Exception er){
            
                System.out.println(er);
        }
            
            
        }
        pause_var.setEnabled(true);
        pause2_var.setEnabled(true);
        pause3_var.setEnabled(true);
        putar_2(-1);

}

void next_3(){
    
        try{
            player3.close();
            int s1 = download_list.getSelectedIndex() +1;
            sa = (File) this.dl.down.get(s1);
            FileInputStream fis = new FileInputStream(sa);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player3 = new javazoom.jl.player.Player(bis);
            
            download_list.setSelectedIndex(s1);
        }catch(Exception e){
            System.out.println("Problem playing file");
            System.out.println(e);
            try{
            player3.close();
            int s1 = 0;
            sa = (File) this.dl.down.get(s1);
            FileInputStream fis = new FileInputStream(sa);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player3 = new javazoom.jl.player.Player(bis);
            
            download_list.setSelectedIndex(s1);
        }catch(Exception er){
            
                System.out.println(er);
        }
            
            
        }
       pause_var.setEnabled(true);
        pause2_var.setEnabled(true);
        pause3_var.setEnabled(true);
        putar_3(-1);

}


void previous_1(){
   
        try{
            player1.close();
            int s1 = Playlist_list.getSelectedIndex() -1;
            sa = (File) this.pl.ls.get(s1);
            FileInputStream fis = new FileInputStream(sa);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player1 = new javazoom.jl.player.Player(bis);
            Playlist_list.setSelectedIndex(s1);
        }catch(Exception e){
            System.out.println("Problem playing file");
            System.out.println(e);
        }
        pause_var.setEnabled(true);
        pause2_var.setEnabled(true);
        pause3_var.setEnabled(true);
        putar_1(-1); 
}

void previous_2(){
   
        try{
            player2.close();
            int s1 = search_list.getSelectedIndex() -1;
            sa = (File) this.sl.sear.get(s1);
            FileInputStream fis = new FileInputStream(sa);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player2 = new javazoom.jl.player.Player(bis);
            search_list.setSelectedIndex(s1);
        }catch(Exception e){
            System.out.println("Problem playing file");
            System.out.println(e);
        }
       pause_var.setEnabled(true);
        pause2_var.setEnabled(true);
        pause3_var.setEnabled(true);
        putar_2(-1);
}

void previous_3(){
   
        try{
            player3.close();
            int s1 = download_list.getSelectedIndex() -1;
            sa = (File) this.dl.down.get(s1);
            FileInputStream fis = new FileInputStream(sa);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player3 = new javazoom.jl.player.Player(bis);
            download_list.setSelectedIndex(s1);
        }catch(Exception e){
            System.out.println("Problem playing file");
            System.out.println(e);
        }
        pause_var.setEnabled(true);
        pause2_var.setEnabled(true);
        pause3_var.setEnabled(true);
        putar_3(-1);
}



int getdownload_id(String pathh){
        int download_id=0 ;
        try {
        
        Connection con = myc.getConn();
        PreparedStatement pst ;
        String sql = "select * from downloads where audio=?";
        pst = con.prepareStatement(sql);
        pst.setString(1, pathh);
        ResultSet rs=pst.executeQuery();       
        while(rs.next()){
             download_id = rs.getInt("download_id");
            }       
        } catch (Exception e) {
            System.out.println("couldnt get track id");
        }
    return download_id;
    }
    


boolean exists(String pathh){
    int did = getdownload_id(pathh);
    int download_id=0;
    String pat="same";
    String naam ="same";
    
    try{
    Connection con = myc.getConn();
        PreparedStatement pst ;
        
        String sql = "select * from downloads where audio=? and download_id=? and user_id=?";
        pst = con.prepareStatement(sql);
        pst.setString(1, pathh);
        pst.setInt(2, did);
        pst.setString(3, HOME_UNAME.getText());
        
        ResultSet rs=pst.executeQuery();       
        while(rs.next()){
             download_id = rs.getInt("download_id");
             pat = rs.getString("audio");
             naam = rs.getString("user_id");
            }
        System.out.println(download_id +"====="+pat+"===="+naam);
        if (download_id==0&&pat=="same"&&naam=="same") {          
            return true;      
        }else{
            return false;
        }
    }catch(Exception e){
        
    }
    return false;
}




void play_1_1(){
            if(canResume==false){ 
            putar_1(-1);     
        }
        else{
            resume_1();
            pause_var.setEnabled(true);
            play_var.setEnabled(false);
            System.out.println("resume");           
        }
}

void play_2_1(){
        if(canResume2==false){ 
            putar_2(-1);     
        }
        else{
            resume_2();
            pause2_var.setEnabled(true);
            play2_var.setEnabled(false);
            System.out.println("resume");           
        }
}

void play_3_1(){
       if(canResume3==false){ 
            putar_3(-1);     
        }
        else{
            resume_3();
            pause3_var.setEnabled(true);
            play3_var.setEnabled(false);
            System.out.println("resume");           
                 
        }
}


void stop1_1(){
                if(canResume==false && valid==true&&player1!=null){
                player1.close();
                canResume=false;
                play_var.setEnabled(true);
                System.out.println(canResume);
                System.out.println(valid);
        }else{
            System.out.println("stopping");
                System.out.println(canResume);
                System.out.println(valid);
        }
}

void stop2_1(){
      if(canResume2==false && valid2==true&&player2!=null){
                player2.close();
                canResume2=false;
                play2_var.setEnabled(true);
                System.out.println(canResume2);
                System.out.println(valid2);
        }else{
            System.out.println("stopping");
                System.out.println(canResume2);
                System.out.println(valid2);
        }
}

void stop3_1(){
      if(canResume3==false && valid3==true&&player3!=null){
                player3.close();
                canResume3=false;
                play3_var.setEnabled(true);
                System.out.println(canResume3);
                System.out.println(valid3);
        }else{
            System.out.println("stopping");
                System.out.println(canResume3);
                System.out.println(valid3);
        }
}

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        coverpanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logout_var = new javax.swing.JButton();
        side_panel = new javax.swing.JPanel();
        home_btn_var = new javax.swing.JButton();
        search_btn_var = new javax.swing.JButton();
        playlist_btn_var = new javax.swing.JButton();
        downloads_btn_var = new javax.swing.JButton();
        create_btn_var = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        home_var = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        HOME_UNAME = new javax.swing.JLabel();
        welcome_var = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        JL2 = new javax.swing.JLabel();
        JL1 = new javax.swing.JLabel();
        search_var = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        search_list = new javax.swing.JList<>();
        info_panel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        ti_var = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        art_var = new javax.swing.JLabel();
        tn_var = new javax.swing.JLabel();
        ui_var = new javax.swing.JLabel();
        gen_var = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        desc_var = new javax.swing.JTextArea();
        song_download_var = new javax.swing.JButton();
        playlist_var = new javax.swing.JPanel();
        add_var = new javax.swing.JButton();
        up_var = new javax.swing.JButton();
        remove_var = new javax.swing.JButton();
        down_var = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Playlist_list = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        downloads_var = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        download_list = new javax.swing.JList<>();
        jLabel18 = new javax.swing.JLabel();
        remove_download_var = new javax.swing.JButton();
        create_var = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description_var = new javax.swing.JTextArea();
        trackname_var = new javax.swing.JTextField();
        artist_var = new javax.swing.JTextField();
        genre_var = new javax.swing.JTextField();
        submitTrack_var = new javax.swing.JButton();
        reset_var = new javax.swing.JButton();
        filechose_var = new javax.swing.JButton();
        path_var = new javax.swing.JTextField();
        control_Tab = new javax.swing.JTabbedPane();
        Player_controls_1 = new javax.swing.JPanel();
        next_var = new javax.swing.JButton();
        stop_var = new javax.swing.JButton();
        play_var = new javax.swing.JButton();
        pause_var = new javax.swing.JButton();
        previous_var = new javax.swing.JButton();
        Player_controls_2 = new javax.swing.JPanel();
        next2_var = new javax.swing.JButton();
        stop2_var = new javax.swing.JButton();
        play2_var = new javax.swing.JButton();
        pause2_var = new javax.swing.JButton();
        previous2_var = new javax.swing.JButton();
        Player_controls_3 = new javax.swing.JPanel();
        next3_var = new javax.swing.JButton();
        stop3_var = new javax.swing.JButton();
        play3_var = new javax.swing.JButton();
        pause3_var = new javax.swing.JButton();
        previous3_var = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setFocusable(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        coverpanel.setBackground(new java.awt.Color(51, 51, 51));
        coverpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Papyrus", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(171, 85, 252));
        jLabel1.setText("Music Catalogue Management System!!");
        coverpanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 8, 698, 146));

        logout_var.setBackground(new java.awt.Color(208, 173, 252));
        logout_var.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        logout_var.setForeground(new java.awt.Color(0, 0, 0));
        logout_var.setText("Logout");
        logout_var.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        logout_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_varActionPerformed(evt);
            }
        });
        coverpanel.add(logout_var, new org.netbeans.lib.awtextra.AbsoluteConstraints(1011, 36, 108, 28));

        jPanel1.add(coverpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -8, 1140, 160));

        side_panel.setBackground(new java.awt.Color(187, 134, 252));

        home_btn_var.setBackground(new java.awt.Color(208, 173, 252));
        home_btn_var.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        home_btn_var.setText("Home");
        home_btn_var.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        home_btn_var.setFocusPainted(false);
        home_btn_var.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Homepage.this.mouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                home_btn_varmouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Homepage.this.mouseExited(evt);
            }
        });
        home_btn_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_btn_varActionPerformed(evt);
            }
        });

        search_btn_var.setBackground(new java.awt.Color(208, 173, 252));
        search_btn_var.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        search_btn_var.setText("Search");
        search_btn_var.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        search_btn_var.setFocusPainted(false);
        search_btn_var.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Homepage.this.mouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                home_btn_varmouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Homepage.this.mouseExited(evt);
            }
        });
        search_btn_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btn_varActionPerformed(evt);
            }
        });

        playlist_btn_var.setBackground(new java.awt.Color(208, 173, 252));
        playlist_btn_var.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        playlist_btn_var.setText("Playlist");
        playlist_btn_var.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        playlist_btn_var.setFocusPainted(false);
        playlist_btn_var.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Homepage.this.mouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                home_btn_varmouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Homepage.this.mouseExited(evt);
            }
        });
        playlist_btn_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playlist_btn_varActionPerformed(evt);
            }
        });

        downloads_btn_var.setBackground(new java.awt.Color(208, 173, 252));
        downloads_btn_var.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        downloads_btn_var.setText("Downloads");
        downloads_btn_var.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        downloads_btn_var.setFocusPainted(false);
        downloads_btn_var.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Homepage.this.mouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                home_btn_varmouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Homepage.this.mouseExited(evt);
            }
        });
        downloads_btn_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloads_btn_varActionPerformed(evt);
            }
        });

        create_btn_var.setBackground(new java.awt.Color(208, 173, 252));
        create_btn_var.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        create_btn_var.setText("Create");
        create_btn_var.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        create_btn_var.setFocusPainted(false);
        create_btn_var.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Homepage.this.mouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                home_btn_varmouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Homepage.this.mouseExited(evt);
            }
        });
        create_btn_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_btn_varActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout side_panelLayout = new javax.swing.GroupLayout(side_panel);
        side_panel.setLayout(side_panelLayout);
        side_panelLayout.setHorizontalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(create_btn_var, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(downloads_btn_var, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(home_btn_var, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(search_btn_var, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playlist_btn_var, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        side_panelLayout.setVerticalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, side_panelLayout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(home_btn_var, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(search_btn_var, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(playlist_btn_var, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(downloads_btn_var, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(create_btn_var, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );

        jPanel1.add(side_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 190, 550));

        jTabbedPane1.setBackground(new java.awt.Color(31, 27, 36));

        home_var.setBackground(new java.awt.Color(31, 27, 36));
        home_var.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(31, 27, 36));

        HOME_UNAME.setFont(new java.awt.Font("Ink Free", 1, 24)); // NOI18N
        HOME_UNAME.setForeground(new java.awt.Color(235, 224, 249));
        HOME_UNAME.setText("None");

        welcome_var.setFont(new java.awt.Font("Ink Free", 1, 36)); // NOI18N
        welcome_var.setForeground(new java.awt.Color(235, 224, 249));
        welcome_var.setText("WELCOME  !!!");

        jLabel17.setFont(new java.awt.Font("Ink Free", 1, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(208, 173, 252));
        jLabel17.setText("Home");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(welcome_var)
                            .addComponent(HOME_UNAME))
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(50, 50, 50))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel17)
                .addGap(99, 99, 99)
                .addComponent(welcome_var)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HOME_UNAME)
                .addContainerGap(255, Short.MAX_VALUE))
        );

        home_var.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 430, 510));

        JL2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL2MouseClicked(evt);
            }
        });
        home_var.add(JL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 500, 500));
        home_var.add(JL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        jTabbedPane1.addTab("tab1", home_var);

        search_var.setBackground(new java.awt.Color(31, 27, 36));
        search_var.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search_list.setBackground(new java.awt.Color(29, 24, 36));
        search_list.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        search_list.setForeground(new java.awt.Color(235, 224, 249));
        search_list.setSelectionBackground(new java.awt.Color(208, 173, 252));
        search_list.setSelectionForeground(new java.awt.Color(31, 27, 36));
        search_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search_listMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(search_list);

        search_var.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 389, 356));

        info_panel.setBackground(new java.awt.Color(31, 27, 36));

        jLabel10.setFont(new java.awt.Font("Ink Free", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(208, 173, 252));
        jLabel10.setText("Track info");

        jLabel11.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(235, 224, 249));
        jLabel11.setText("Track Name :");

        jLabel12.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(235, 224, 249));
        jLabel12.setText("Artists :");

        jLabel13.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(235, 224, 249));
        jLabel13.setText("Uploaded by :");

        jLabel14.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(235, 224, 249));
        jLabel14.setText("Genre :");

        jLabel15.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(235, 224, 249));
        jLabel15.setText("Description :");

        ti_var.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        ti_var.setForeground(new java.awt.Color(235, 224, 249));
        ti_var.setText("none");

        jLabel16.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(235, 224, 249));
        jLabel16.setText("Track id :");

        art_var.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        art_var.setForeground(new java.awt.Color(235, 224, 249));
        art_var.setText("none");

        tn_var.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        tn_var.setForeground(new java.awt.Color(235, 224, 249));
        tn_var.setText("none");

        ui_var.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        ui_var.setForeground(new java.awt.Color(235, 224, 249));
        ui_var.setText("none");

        gen_var.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        gen_var.setForeground(new java.awt.Color(235, 224, 249));
        gen_var.setText("none");

        desc_var.setBackground(new java.awt.Color(31, 27, 36));
        desc_var.setColumns(20);
        desc_var.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        desc_var.setRows(5);
        desc_var.setText("none");
        desc_var.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        desc_var.setFocusable(false);
        desc_var.setSelectedTextColor(new java.awt.Color(31, 27, 36));
        desc_var.setSelectionColor(new java.awt.Color(208, 173, 252));
        jScrollPane4.setViewportView(desc_var);

        javax.swing.GroupLayout info_panelLayout = new javax.swing.GroupLayout(info_panel);
        info_panel.setLayout(info_panelLayout);
        info_panelLayout.setHorizontalGroup(
            info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_panelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tn_var, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ti_var, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gen_var, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ui_var, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(art_var, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, info_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(162, 162, 162))
        );
        info_panelLayout.setVerticalGroup(
            info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_panelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(ti_var))
                .addGap(27, 27, 27)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tn_var))
                .addGap(27, 27, 27)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(art_var))
                .addGap(27, 27, 27)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(ui_var))
                .addGap(27, 27, 27)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(gen_var))
                .addGap(27, 27, 27)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        search_var.add(info_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 0, 450, -1));

        song_download_var.setBackground(new java.awt.Color(208, 173, 252));
        song_download_var.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        song_download_var.setText("download");
        song_download_var.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        song_download_var.setFocusPainted(false);
        song_download_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                song_download_varActionPerformed(evt);
            }
        });
        search_var.add(song_download_var, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 90, 30));

        jTabbedPane1.addTab("tab2", search_var);

        playlist_var.setBackground(new java.awt.Color(31, 27, 36));

        add_var.setBackground(new java.awt.Color(208, 173, 252));
        add_var.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        add_var.setForeground(new java.awt.Color(0, 0, 0));
        add_var.setText("Add");
        add_var.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add_var.setFocusPainted(false);
        add_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_varActionPerformed(evt);
            }
        });

        up_var.setBackground(new java.awt.Color(208, 173, 252));
        up_var.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        up_var.setForeground(new java.awt.Color(0, 0, 0));
        up_var.setText("Move up");
        up_var.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        up_var.setFocusPainted(false);
        up_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up_varActionPerformed(evt);
            }
        });

        remove_var.setBackground(new java.awt.Color(208, 173, 252));
        remove_var.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        remove_var.setForeground(new java.awt.Color(0, 0, 0));
        remove_var.setText("Remove ");
        remove_var.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        remove_var.setFocusPainted(false);
        remove_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_varActionPerformed(evt);
            }
        });

        down_var.setBackground(new java.awt.Color(208, 173, 252));
        down_var.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        down_var.setForeground(new java.awt.Color(0, 0, 0));
        down_var.setText("Move down");
        down_var.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        down_var.setFocusPainted(false);
        down_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                down_varActionPerformed(evt);
            }
        });

        Playlist_list.setBackground(new java.awt.Color(29, 24, 36));
        Playlist_list.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Playlist_list.setForeground(new java.awt.Color(235, 224, 249));
        Playlist_list.setSelectionBackground(new java.awt.Color(208, 173, 252));
        Playlist_list.setSelectionForeground(new java.awt.Color(31, 27, 36));
        Playlist_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Playlist_listMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Playlist_list);

        jLabel9.setFont(new java.awt.Font("Ink Free", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(208, 173, 252));
        jLabel9.setText("Playlist");

        javax.swing.GroupLayout playlist_varLayout = new javax.swing.GroupLayout(playlist_var);
        playlist_var.setLayout(playlist_varLayout);
        playlist_varLayout.setHorizontalGroup(
            playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playlist_varLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(50, 50, 50))
            .addGroup(playlist_varLayout.createSequentialGroup()
                .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playlist_varLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(up_var, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(down_var, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)))
                    .addGroup(playlist_varLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(add_var, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(remove_var, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(255, Short.MAX_VALUE))
        );
        playlist_varLayout.setVerticalGroup(
            playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playlist_varLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel9)
                .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playlist_varLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(playlist_varLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(up_var, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(down_var, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(remove_var, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_var, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab3", playlist_var);

        downloads_var.setBackground(new java.awt.Color(31, 27, 36));

        download_list.setBackground(new java.awt.Color(29, 24, 36));
        download_list.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        download_list.setForeground(new java.awt.Color(235, 224, 249));
        download_list.setSelectionBackground(new java.awt.Color(208, 173, 252));
        download_list.setSelectionForeground(new java.awt.Color(31, 27, 36));
        download_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                download_listMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(download_list);

        jLabel18.setFont(new java.awt.Font("Ink Free", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(208, 173, 252));
        jLabel18.setText("Downloads");

        remove_download_var.setBackground(new java.awt.Color(208, 173, 252));
        remove_download_var.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        remove_download_var.setForeground(new java.awt.Color(0, 0, 0));
        remove_download_var.setText("Remove ");
        remove_download_var.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        remove_download_var.setFocusPainted(false);
        remove_download_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_download_varActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout downloads_varLayout = new javax.swing.GroupLayout(downloads_var);
        downloads_var.setLayout(downloads_varLayout);
        downloads_varLayout.setHorizontalGroup(
            downloads_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, downloads_varLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(50, 50, 50))
            .addGroup(downloads_varLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(downloads_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(remove_download_var, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(387, Short.MAX_VALUE))
        );
        downloads_varLayout.setVerticalGroup(
            downloads_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, downloads_varLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel18)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(remove_download_var, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        jTabbedPane1.addTab("tab4", downloads_var);

        create_var.setBackground(new java.awt.Color(31, 27, 36));

        jLabel2.setFont(new java.awt.Font("Ink Free", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(208, 173, 252));
        jLabel2.setText("Create");

        jLabel3.setFont(new java.awt.Font("Ink Free", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(208, 173, 252));
        jLabel3.setText("Add Music:");

        jLabel4.setFont(new java.awt.Font("Ink Free", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(235, 224, 249));
        jLabel4.setText("Track Name :");

        jLabel5.setFont(new java.awt.Font("Ink Free", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(235, 224, 249));
        jLabel5.setText("Artist :");

        jLabel6.setFont(new java.awt.Font("Ink Free", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(235, 224, 249));
        jLabel6.setText("Genre :");

        jLabel7.setFont(new java.awt.Font("Ink Free", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(235, 224, 249));
        jLabel7.setText("Description :");

        jLabel8.setFont(new java.awt.Font("Ink Free", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(235, 224, 249));
        jLabel8.setText("Track file :");

        description_var.setColumns(20);
        description_var.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        description_var.setRows(5);
        description_var.setSelectedTextColor(new java.awt.Color(31, 27, 36));
        description_var.setSelectionColor(new java.awt.Color(208, 173, 252));
        jScrollPane1.setViewportView(description_var);

        trackname_var.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        trackname_var.setForeground(new java.awt.Color(0, 0, 0));
        trackname_var.setSelectedTextColor(new java.awt.Color(31, 27, 36));
        trackname_var.setSelectionColor(new java.awt.Color(208, 173, 252));

        artist_var.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        artist_var.setSelectedTextColor(new java.awt.Color(31, 27, 36));
        artist_var.setSelectionColor(new java.awt.Color(208, 173, 252));

        genre_var.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        genre_var.setSelectedTextColor(new java.awt.Color(31, 27, 36));
        genre_var.setSelectionColor(new java.awt.Color(208, 173, 252));

        submitTrack_var.setBackground(new java.awt.Color(208, 173, 252));
        submitTrack_var.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        submitTrack_var.setText("Submit Track");
        submitTrack_var.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        submitTrack_var.setFocusPainted(false);
        submitTrack_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitTrack_varActionPerformed(evt);
            }
        });

        reset_var.setBackground(new java.awt.Color(208, 173, 252));
        reset_var.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        reset_var.setText("Reset");
        reset_var.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        reset_var.setFocusPainted(false);
        reset_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_varActionPerformed(evt);
            }
        });

        filechose_var.setBackground(new java.awt.Color(208, 173, 252));
        filechose_var.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        filechose_var.setText("select file");
        filechose_var.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        filechose_var.setFocusPainted(false);
        filechose_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filechose_varActionPerformed(evt);
            }
        });

        path_var.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        path_var.setSelectedTextColor(new java.awt.Color(31, 27, 36));
        path_var.setSelectionColor(new java.awt.Color(208, 173, 252));
        path_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                path_varActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout create_varLayout = new javax.swing.GroupLayout(create_var);
        create_var.setLayout(create_varLayout);
        create_varLayout.setHorizontalGroup(
            create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(create_varLayout.createSequentialGroup()
                .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(create_varLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel3))
                    .addGroup(create_varLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(create_varLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(genre_var, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(create_varLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(path_var, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(create_varLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(create_varLayout.createSequentialGroup()
                                        .addComponent(trackname_var, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(filechose_var, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(create_varLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(artist_var, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(create_varLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel8)))
                .addGap(85, 85, 85)
                .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(submitTrack_var, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset_var, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        create_varLayout.setVerticalGroup(
            create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(create_varLayout.createSequentialGroup()
                .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(create_varLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2))
                    .addGroup(create_varLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(trackname_var, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(43, 43, 43)
                        .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(artist_var, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(44, 44, 44)
                        .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(genre_var, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(40, 40, 40)
                        .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filechose_var, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(path_var, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(55, 55, 55)
                        .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(create_varLayout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(submitTrack_var, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(reset_var, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67))
        );

        jTabbedPane1.addTab("tab5", create_var);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 930, 530));

        control_Tab.setForeground(new java.awt.Color(255, 255, 255));

        Player_controls_1.setBackground(new java.awt.Color(39, 39, 39));

        next_var.setBackground(new java.awt.Color(51, 51, 51));
        next_var.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        next_var.setForeground(new java.awt.Color(0, 0, 0));
        next_var.setText("►►");
        next_var.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                next_varMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                next_varMouseExited(evt);
            }
        });
        next_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_varActionPerformed(evt);
            }
        });

        stop_var.setBackground(new java.awt.Color(51, 51, 51));
        stop_var.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        stop_var.setForeground(new java.awt.Color(0, 0, 0));
        stop_var.setText("■");
        stop_var.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stop_varMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stop_varMouseExited(evt);
            }
        });
        stop_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stop_varActionPerformed(evt);
            }
        });

        play_var.setBackground(new java.awt.Color(51, 51, 51));
        play_var.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        play_var.setForeground(new java.awt.Color(0, 0, 0));
        play_var.setText(" ▶");
        play_var.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        play_var.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                play_varMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                play_varMouseExited(evt);
            }
        });
        play_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                play_varActionPerformed(evt);
            }
        });

        pause_var.setBackground(new java.awt.Color(51, 51, 51));
        pause_var.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pause_var.setForeground(new java.awt.Color(0, 0, 0));
        pause_var.setText("| |");
        pause_var.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pause_varMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pause_varMouseExited(evt);
            }
        });
        pause_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pause_varActionPerformed(evt);
            }
        });

        previous_var.setBackground(new java.awt.Color(51, 51, 51));
        previous_var.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        previous_var.setForeground(new java.awt.Color(0, 0, 0));
        previous_var.setText("◄◄");
        previous_var.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                previous_varMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                previous_varMouseExited(evt);
            }
        });
        previous_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previous_varActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Player_controls_1Layout = new javax.swing.GroupLayout(Player_controls_1);
        Player_controls_1.setLayout(Player_controls_1Layout);
        Player_controls_1Layout.setHorizontalGroup(
            Player_controls_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player_controls_1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(previous_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(pause_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(play_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(stop_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(next_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Player_controls_1Layout.setVerticalGroup(
            Player_controls_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player_controls_1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(Player_controls_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(previous_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pause_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(play_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stop_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        control_Tab.addTab("tab1", Player_controls_1);

        Player_controls_2.setBackground(new java.awt.Color(39, 39, 39));

        next2_var.setBackground(new java.awt.Color(51, 51, 51));
        next2_var.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        next2_var.setForeground(new java.awt.Color(0, 0, 0));
        next2_var.setText("►►");
        next2_var.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                next2_varMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                next2_varMouseExited(evt);
            }
        });
        next2_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next2_varActionPerformed(evt);
            }
        });

        stop2_var.setBackground(new java.awt.Color(51, 51, 51));
        stop2_var.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        stop2_var.setForeground(new java.awt.Color(0, 0, 0));
        stop2_var.setText("■");
        stop2_var.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stop2_varMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stop2_varMouseExited(evt);
            }
        });
        stop2_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stop2_varActionPerformed(evt);
            }
        });

        play2_var.setBackground(new java.awt.Color(51, 51, 51));
        play2_var.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        play2_var.setForeground(new java.awt.Color(0, 0, 0));
        play2_var.setText(" ▶");
        play2_var.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        play2_var.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                play2_varMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                play2_varMouseExited(evt);
            }
        });
        play2_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                play2_varActionPerformed(evt);
            }
        });

        pause2_var.setBackground(new java.awt.Color(51, 51, 51));
        pause2_var.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pause2_var.setForeground(new java.awt.Color(0, 0, 0));
        pause2_var.setText("| |");
        pause2_var.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pause2_varMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pause2_varMouseExited(evt);
            }
        });
        pause2_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pause2_varActionPerformed(evt);
            }
        });

        previous2_var.setBackground(new java.awt.Color(51, 51, 51));
        previous2_var.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        previous2_var.setForeground(new java.awt.Color(0, 0, 0));
        previous2_var.setText("◄◄");
        previous2_var.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                previous2_varMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                previous2_varMouseExited(evt);
            }
        });
        previous2_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previous2_varActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Player_controls_2Layout = new javax.swing.GroupLayout(Player_controls_2);
        Player_controls_2.setLayout(Player_controls_2Layout);
        Player_controls_2Layout.setHorizontalGroup(
            Player_controls_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player_controls_2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(previous2_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(pause2_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(play2_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(stop2_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(next2_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Player_controls_2Layout.setVerticalGroup(
            Player_controls_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player_controls_2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(Player_controls_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(previous2_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pause2_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(play2_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stop2_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next2_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        control_Tab.addTab("tab1", Player_controls_2);

        Player_controls_3.setBackground(new java.awt.Color(39, 39, 39));

        next3_var.setBackground(new java.awt.Color(51, 51, 51));
        next3_var.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        next3_var.setForeground(new java.awt.Color(0, 0, 0));
        next3_var.setText("►►");
        next3_var.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                next3_varMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                next3_varMouseExited(evt);
            }
        });
        next3_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next3_varActionPerformed(evt);
            }
        });

        stop3_var.setBackground(new java.awt.Color(51, 51, 51));
        stop3_var.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        stop3_var.setForeground(new java.awt.Color(0, 0, 0));
        stop3_var.setText("■");
        stop3_var.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stop3_varMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stop3_varMouseExited(evt);
            }
        });
        stop3_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stop3_varActionPerformed(evt);
            }
        });

        play3_var.setBackground(new java.awt.Color(51, 51, 51));
        play3_var.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        play3_var.setForeground(new java.awt.Color(0, 0, 0));
        play3_var.setText(" ▶");
        play3_var.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        play3_var.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                play3_varMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                play3_varMouseExited(evt);
            }
        });
        play3_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                play3_varActionPerformed(evt);
            }
        });

        pause3_var.setBackground(new java.awt.Color(51, 51, 51));
        pause3_var.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pause3_var.setForeground(new java.awt.Color(0, 0, 0));
        pause3_var.setText("| |");
        pause3_var.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pause3_varMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pause3_varMouseExited(evt);
            }
        });
        pause3_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pause3_varActionPerformed(evt);
            }
        });

        previous3_var.setBackground(new java.awt.Color(51, 51, 51));
        previous3_var.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        previous3_var.setForeground(new java.awt.Color(0, 0, 0));
        previous3_var.setText("◄◄");
        previous3_var.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                previous3_varMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                previous3_varMouseExited(evt);
            }
        });
        previous3_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previous3_varActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Player_controls_3Layout = new javax.swing.GroupLayout(Player_controls_3);
        Player_controls_3.setLayout(Player_controls_3Layout);
        Player_controls_3Layout.setHorizontalGroup(
            Player_controls_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player_controls_3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(previous3_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(pause3_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(play3_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(stop3_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(next3_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Player_controls_3Layout.setVerticalGroup(
            Player_controls_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player_controls_3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(Player_controls_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(previous3_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pause3_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(play3_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stop3_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next3_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        control_Tab.addTab("tab1", Player_controls_3);

        jPanel1.add(control_Tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 620, 510, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClicked
   
    }//GEN-LAST:event_mouseClicked

    private void home_btn_varmouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_btn_varmouseEntered
             
    }//GEN-LAST:event_home_btn_varmouseEntered

    private void mouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseExited

    }//GEN-LAST:event_mouseExited

    private void home_btn_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_btn_varActionPerformed
        home_btn_var.setBackground(new Color(187,83,251));
        
        playlist_btn_var.setBackground(new Color(208,173,252));
        search_btn_var.setBackground(new Color(208,173,252));
        create_btn_var.setBackground(new Color(208,173,252));
        downloads_btn_var.setBackground(new Color(208,173,252));
        
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_home_btn_varActionPerformed

    private void playlist_btn_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playlist_btn_varActionPerformed
//        updateList();
        playlist_btn_var.setBackground(new Color(187,83,251));
        
        home_btn_var.setBackground(new Color(208,173,252));
        search_btn_var.setBackground(new Color(208,173,252));
        create_btn_var.setBackground(new Color(208,173,252));
        downloads_btn_var.setBackground(new Color(208,173,252));
        
        jTabbedPane1.setSelectedIndex(2);
        control_Tab.setSelectedIndex(0);
    }//GEN-LAST:event_playlist_btn_varActionPerformed

    private void downloads_btn_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloads_btn_varActionPerformed
        downloads_btn_var.setBackground(new Color(187,83,251));
        
        home_btn_var.setBackground(new Color(208,173,252));
        search_btn_var.setBackground(new Color(208,173,252));
        create_btn_var.setBackground(new Color(208,173,252));
        playlist_btn_var.setBackground(new Color(208,173,252));
        
        jTabbedPane1.setSelectedIndex(3);
        control_Tab.setSelectedIndex(2);
    }//GEN-LAST:event_downloads_btn_varActionPerformed

    private void create_btn_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_btn_varActionPerformed
        create_btn_var.setBackground(new Color(187,83,251));
        
        home_btn_var.setBackground(new Color(208,173,252));
        search_btn_var.setBackground(new Color(208,173,252));
        downloads_btn_var.setBackground(new Color(208,173,252));
        playlist_btn_var.setBackground(new Color(208,173,252));
        
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_create_btn_varActionPerformed

    private void search_btn_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btn_varActionPerformed
        search_btn_var.setBackground(new Color(187,83,251));
        
        home_btn_var.setBackground(new Color(208,173,252));
        create_btn_var.setBackground(new Color(208,173,252));
        downloads_btn_var.setBackground(new Color(208,173,252));
        playlist_btn_var.setBackground(new Color(208,173,252));
        
        jTabbedPane1.setSelectedIndex(1);
        control_Tab.setSelectedIndex(1);
    }//GEN-LAST:event_search_btn_varActionPerformed

    private void submitTrack_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitTrack_varActionPerformed
        // TODO add your handling code here:
       
        
        int dia = JOptionPane.showConfirmDialog(null,"Sure? You want to Upload This song?", "Track upload",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
     

        if(dia==JOptionPane.YES_OPTION ){
            
        String Track_name = trackname_var.getText();
        String Artist = artist_var.getText();
        String Genre = genre_var.getText();
        String Description = description_var.getText();
        String path_link = path_var.getText();
        

           
        
        if(Track_name.trim().equals("")||
            Artist.trim().equals("")|| 
            Genre.trim().equals("")||
            Description.trim().equals("")){
                JOptionPane.showMessageDialog(null, "All fields are compulsary");
        }else{
                
                try{
                    Connection con = myc.getConn();
                    PreparedStatement pst ;
                    String saveQ = "insert into tracks(user_id,track_name, artist, genre,description,audio) values(?,?,?,?,?,?)";
                    pst = con.prepareStatement(saveQ);
                    pst.setString(1, HOME_UNAME.getText());
                    pst.setString(2, Track_name);
                    pst.setString(3, Artist);
                    pst.setString(4, Genre);
                    pst.setString(5, Description);
                    pst.setString(6, path_link);
                    JOptionPane.showMessageDialog(null, HOME_UNAME.getText());
          
                    
                    //track
                  
             
                    
                    int i = pst.executeUpdate();
                    if (i>=1) {
                        JOptionPane.showMessageDialog(null, "Song uploaded!!");
                        updateList();
                        update();
                        reset();
                    }else{
                        JOptionPane.showMessageDialog(null, "There was an error while uploading!!!");
                    }
                            
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
        }
        
    }else{
            System.out.println("no");
        }

    }//GEN-LAST:event_submitTrack_varActionPerformed

    private void reset_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_varActionPerformed
        // TODO add your handling code here:
        reset();
        
    }//GEN-LAST:event_reset_varActionPerformed

    private void add_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_varActionPerformed
//        add();   
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_add_varActionPerformed

    private void up_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up_varActionPerformed
        up();        // TODO add your handling code here:
    }//GEN-LAST:event_up_varActionPerformed

    private void remove_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_varActionPerformed
      
       int dia = JOptionPane.showConfirmDialog(null,"Sure? You want to remove This song?", "Track remove",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
     

        if(dia==JOptionPane.YES_OPTION ){ 
       remove(); 
      Homepage h = new Homepage(HOME_UNAME.getText());
      stop_var.doClick();
      stop2_var.doClick();
      stop3_var.doClick();
      
      this.dispose();
      anim=false;
      h.setVisible(true);
        }else{
            System.out.println("cancel removing the song");
        }
      
    }//GEN-LAST:event_remove_varActionPerformed

    private void down_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_down_varActionPerformed
        down();// TODO add your handling code here:
    }//GEN-LAST:event_down_varActionPerformed

    private void pause_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pause_varActionPerformed
       
         pause_1();
        pause_2();
        pause_3();
    }//GEN-LAST:event_pause_varActionPerformed

    private void previous_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previous_varActionPerformed
       stop2_var.doClick();
       stop3_var.doClick();
        
       previous_1();
       previous_2();
       previous_3();
    }//GEN-LAST:event_previous_varActionPerformed

    private void play_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_play_varActionPerformed
        stop2_var.doClick();
        stop3_var.doClick();
        
        play_1_1();
        play_2_1();
        play_3_1();

    }//GEN-LAST:event_play_varActionPerformed

    private void next_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_varActionPerformed
        stop2_var.doClick();
        stop3_var.doClick();
        
        next_1();
        next_2();
        next_3();
    }//GEN-LAST:event_next_varActionPerformed

    private void stop_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stop_varActionPerformed
         stop1_1();
         stop2_1();
         stop3_1();
    }//GEN-LAST:event_stop_varActionPerformed

    private void filechose_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filechose_varActionPerformed
       JFileChooser chooser = new JFileChooser();
       FileFilter filter = new FileNameExtensionFilter("MP3 File","mp3");
       chooser.setFileFilter(filter);
       chooser.showOpenDialog(null);
       File f = chooser.getSelectedFile();
       String filename = f.getAbsolutePath();
       path_var.setText(filename);
      
    }//GEN-LAST:event_filechose_varActionPerformed

    private void path_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_path_varActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_path_varActionPerformed

    private void JL2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL2MouseClicked
        System.out.println("mouse click");
    }//GEN-LAST:event_JL2MouseClicked

    private void search_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_listMouseClicked
        download_list.clearSelection();
        Playlist_list.clearSelection();
        
        int a = search_list.getSelectedIndex();
        System.out.println(a);
         File f = (File) sl.sear.get(a);
         String pa = (String)f.getAbsolutePath();
         
         
         GetInfo gf = new GetInfo();
            
            
            
             String ui = gf.getUserId(pa);
             int ti = gf.getTrackid(pa);
             String tn = gf.getTrackName(pa);
             String art = gf.getTrackArtist(pa);
             String gen = gf.getTrackGenre(pa);
             String des = gf.getTrackDescription(pa);
             
             
             
             ti_var.setText("#"+ti);
             tn_var.setText(tn);
             art_var.setText(art);
             gen_var.setText(gen);
             desc_var.setText(des);
             ui_var.setText(ui);
             desc_var.setEditable(true);
             desc_var.setText(des);
             desc_var.setEditable(false);
    }//GEN-LAST:event_search_listMouseClicked

    private void play_varMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_play_varMouseEntered
        
        play_var.setForeground(new java.awt.Color(187,134,252));
    }//GEN-LAST:event_play_varMouseEntered

    private void play_varMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_play_varMouseExited
        play_var.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_play_varMouseExited

    private void stop_varMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stop_varMouseEntered
        stop_var.setForeground(new java.awt.Color(187,134,252));
    }//GEN-LAST:event_stop_varMouseEntered

    private void stop_varMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stop_varMouseExited
        stop_var.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_stop_varMouseExited

    private void pause_varMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pause_varMouseEntered
        pause_var.setForeground(new java.awt.Color(187,134,252));
    }//GEN-LAST:event_pause_varMouseEntered

    private void pause_varMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pause_varMouseExited
        pause_var.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_pause_varMouseExited

    private void next_varMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next_varMouseEntered
        next_var.setForeground(new java.awt.Color(187,134,252));
    }//GEN-LAST:event_next_varMouseEntered

    private void next_varMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next_varMouseExited
        next_var.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_next_varMouseExited

    private void previous_varMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previous_varMouseEntered
        previous_var.setForeground(new java.awt.Color(187,134,252));
    }//GEN-LAST:event_previous_varMouseEntered

    private void previous_varMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previous_varMouseExited
        previous_var.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_previous_varMouseExited

    private void next2_varMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next2_varMouseEntered
        next2_var.setForeground(new java.awt.Color(187,134,252));
    }//GEN-LAST:event_next2_varMouseEntered

    private void next2_varMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next2_varMouseExited
        next2_var.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_next2_varMouseExited

    private void next2_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next2_varActionPerformed
        stop_var.doClick();
        stop3_var.doClick();
        
        next_1();
        next_2();
        next_3();
    }//GEN-LAST:event_next2_varActionPerformed

    private void stop2_varMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stop2_varMouseEntered
        stop2_var.setForeground(new java.awt.Color(187,134,252));
    }//GEN-LAST:event_stop2_varMouseEntered

    private void stop2_varMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stop2_varMouseExited
        stop2_var.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_stop2_varMouseExited

    private void stop2_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stop2_varActionPerformed
        stop1_1();
         stop2_1();
         stop3_1();
    }//GEN-LAST:event_stop2_varActionPerformed

    private void play2_varMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_play2_varMouseEntered
        play2_var.setForeground(new java.awt.Color(187,134,252));
    }//GEN-LAST:event_play2_varMouseEntered

    private void play2_varMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_play2_varMouseExited
        play2_var.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_play2_varMouseExited

    private void play2_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_play2_varActionPerformed
                stop_var.doClick();
                stop3_var.doClick();
                
        play_1_1();
        play_2_1();
        play_3_1();

    }//GEN-LAST:event_play2_varActionPerformed

    private void pause2_varMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pause2_varMouseEntered
        pause2_var.setForeground(new java.awt.Color(187,134,252));
    }//GEN-LAST:event_pause2_varMouseEntered

    private void pause2_varMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pause2_varMouseExited
        pause2_var.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_pause2_varMouseExited

    private void pause2_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pause2_varActionPerformed
         pause_1();
        pause_2();
        pause_3();
    }//GEN-LAST:event_pause2_varActionPerformed

    private void previous2_varMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previous2_varMouseEntered
        previous2_var.setForeground(new java.awt.Color(187,134,252));
    }//GEN-LAST:event_previous2_varMouseEntered

    private void previous2_varMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previous2_varMouseExited
        previous2_var.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_previous2_varMouseExited

    private void previous2_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previous2_varActionPerformed
        stop_var.doClick();
        stop3_var.doClick();
        
       previous_1();
       previous_2();
       previous_3();
    }//GEN-LAST:event_previous2_varActionPerformed

    private void logout_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_varActionPerformed
        this.setVisible(false);
        anim=false;
        stop2_var.doClick();
        stop_var.doClick();
        stop3_var.doClick();
        new Intpage().setVisible(true);
    }//GEN-LAST:event_logout_varActionPerformed

    private void next3_varMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next3_varMouseEntered
       next3_var.setForeground(new java.awt.Color(187,134,252));
    }//GEN-LAST:event_next3_varMouseEntered

    private void next3_varMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next3_varMouseExited
        next3_var.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_next3_varMouseExited

    private void next3_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next3_varActionPerformed
        stop_var.doClick();
        stop2_var.doClick();
        next_1();
        next_2();
        next_3();
    }//GEN-LAST:event_next3_varActionPerformed

    private void stop3_varMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stop3_varMouseEntered
        stop3_var.setForeground(new java.awt.Color(187,134,252));
    }//GEN-LAST:event_stop3_varMouseEntered

    private void stop3_varMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stop3_varMouseExited
        stop3_var.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_stop3_varMouseExited

    private void stop3_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stop3_varActionPerformed
        stop1_1();
         stop2_1();
         stop3_1();
    }//GEN-LAST:event_stop3_varActionPerformed

    private void play3_varMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_play3_varMouseEntered
        play3_var.setForeground(new java.awt.Color(187,134,252));

    }//GEN-LAST:event_play3_varMouseEntered

    private void play3_varMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_play3_varMouseExited
        play3_var.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_play3_varMouseExited

    private void play3_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_play3_varActionPerformed
        stop_var.doClick();
        stop2_var.doClick();
       
        play_1_1();
        play_2_1();
        play_3_1();
        
    }//GEN-LAST:event_play3_varActionPerformed

    private void pause3_varMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pause3_varMouseEntered
        pause3_var.setForeground(new java.awt.Color(187,134,252));
    }//GEN-LAST:event_pause3_varMouseEntered

    private void pause3_varMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pause3_varMouseExited
        pause3_var.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_pause3_varMouseExited

    private void pause3_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pause3_varActionPerformed
        pause_1();
        pause_2();
        pause_3();
        
    }//GEN-LAST:event_pause3_varActionPerformed

    private void previous3_varMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previous3_varMouseEntered
        previous3_var.setForeground(new java.awt.Color(187,134,252));
    }//GEN-LAST:event_previous3_varMouseEntered

    private void previous3_varMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previous3_varMouseExited
       previous3_var.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_previous3_varMouseExited

    private void previous3_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previous3_varActionPerformed
        stop_var.doClick();
        stop2_var.doClick();
        
        previous_1();
       previous_2();
       previous_3();
    }//GEN-LAST:event_previous3_varActionPerformed

    private void song_download_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_song_download_varActionPerformed

                    int a = search_list.getSelectedIndex();
                    System.out.println(a);
                     File f = (File)sl.sear.get(a);
                     String pa = (String)f.getAbsolutePath();
                     int id = getTrackid(pa);
//                     int did = getdownload_id(pa);
                        if(exists(pa)){

                     String name = HOME_UNAME.getText();

                     try{
                                Connection con = myc.getConn();
                                PreparedStatement pst ;
                                String saveQ = "insert into downloads(user_id, track_id,audio) VALUES(?,?,?)";
                                pst = con.prepareStatement(saveQ);
                                pst.setString(1, HOME_UNAME.getText());
                                pst.setInt(2, id);
                                pst.setString(3, pa);

                                pst.executeUpdate();
                                updateDownload();
                     }catch(Exception e){
                         System.out.println("not work");

                     }
                        }else{
                            JOptionPane.showMessageDialog(null, "already exists");
                        }

  
    }//GEN-LAST:event_song_download_varActionPerformed

    private void Playlist_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Playlist_listMouseClicked
        download_list.clearSelection();
        search_list.clearSelection();
    }//GEN-LAST:event_Playlist_listMouseClicked

    private void download_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_download_listMouseClicked
        search_list.clearSelection();
        Playlist_list.clearSelection();
    }//GEN-LAST:event_download_listMouseClicked

    private void remove_download_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_download_varActionPerformed
       int dia = JOptionPane.showConfirmDialog(null,"Sure? You want to remove This song?", "Track remove",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
     

        if(dia==JOptionPane.YES_OPTION ){ 
        
                
           removeDown();
      Homepage h = new Homepage(HOME_UNAME.getText());
      stop_var.doClick();
      stop2_var.doClick();
      stop3_var.doClick();
      
      this.dispose();
      anim=false;
      h.setVisible(true);
        }else{
            System.out.println("cancel removing the song");
        }
    }//GEN-LAST:event_remove_download_varActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                new Homepage("None").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HOME_UNAME;
    private javax.swing.JLabel JL1;
    private javax.swing.JLabel JL2;
    private javax.swing.JPanel Player_controls_1;
    private javax.swing.JPanel Player_controls_2;
    private javax.swing.JPanel Player_controls_3;
    private javax.swing.JList<String> Playlist_list;
    private javax.swing.JButton add_var;
    private javax.swing.JLabel art_var;
    private javax.swing.JTextField artist_var;
    private javax.swing.JTabbedPane control_Tab;
    private javax.swing.JPanel coverpanel;
    private javax.swing.JButton create_btn_var;
    private javax.swing.JPanel create_var;
    private javax.swing.JTextArea desc_var;
    private javax.swing.JTextArea description_var;
    private javax.swing.JButton down_var;
    private javax.swing.JList<String> download_list;
    private javax.swing.JButton downloads_btn_var;
    private javax.swing.JPanel downloads_var;
    private javax.swing.JButton filechose_var;
    private javax.swing.JLabel gen_var;
    private javax.swing.JTextField genre_var;
    private javax.swing.JButton home_btn_var;
    private javax.swing.JPanel home_var;
    private javax.swing.JPanel info_panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logout_var;
    private javax.swing.JButton next2_var;
    private javax.swing.JButton next3_var;
    private javax.swing.JButton next_var;
    private javax.swing.JTextField path_var;
    private javax.swing.JButton pause2_var;
    private javax.swing.JButton pause3_var;
    private javax.swing.JButton pause_var;
    private javax.swing.JButton play2_var;
    private javax.swing.JButton play3_var;
    private javax.swing.JButton play_var;
    private javax.swing.JButton playlist_btn_var;
    private javax.swing.JPanel playlist_var;
    private javax.swing.JButton previous2_var;
    private javax.swing.JButton previous3_var;
    private javax.swing.JButton previous_var;
    private javax.swing.JButton remove_download_var;
    private javax.swing.JButton remove_var;
    private javax.swing.JButton reset_var;
    private javax.swing.JButton search_btn_var;
    private javax.swing.JList<String> search_list;
    private javax.swing.JPanel search_var;
    private javax.swing.JPanel side_panel;
    private javax.swing.JButton song_download_var;
    private javax.swing.JButton stop2_var;
    private javax.swing.JButton stop3_var;
    private javax.swing.JButton stop_var;
    private javax.swing.JButton submitTrack_var;
    private javax.swing.JLabel ti_var;
    private javax.swing.JLabel tn_var;
    private javax.swing.JTextField trackname_var;
    private javax.swing.JLabel ui_var;
    private javax.swing.JButton up_var;
    private javax.swing.JLabel welcome_var;
    // End of variables declaration//GEN-END:variables

byte[] music = null;
}
