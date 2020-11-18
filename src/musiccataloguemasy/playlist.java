/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccataloguemasy;


    import java.io.File;
    import java.io.FileInputStream;
    import java.io.FileOutputStream;
    import java.io.ObjectInputStream;
    import java.io.ObjectOutputStream;
    import java.util.ArrayList;
    import java.util.Arrays;
    import javax.swing.JFileChooser;
    import javax.swing.JFrame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ROTAN27
 */
public class playlist {
    JFileChooser fc = new JFileChooser();
    ArrayList ls = new ArrayList();
    ArrayList sear = new ArrayList();
    MySQLConnect myc = new MySQLConnect();
    
    void add(JFrame frame){
        fc.setMultiSelectionEnabled(true);
        int fileValid = fc.showOpenDialog(frame);
        if (fileValid == javax.swing.JFileChooser.CANCEL_OPTION){
            return;
        } else if (fileValid == javax.swing.JFileChooser.APPROVE_OPTION){
            File[] file = fc.getSelectedFiles();
            ls.addAll(Arrays.asList(file));
        }
    }
    
    
    ArrayList getAllsong(){
        try {
        
        Connection con = myc.getConn();
        PreparedStatement pst ;
        String sql = "select * from tracks";
        
        pst = con.prepareStatement(sql);
        ResultSet rs=pst.executeQuery();
        
        while(rs.next()){
            String songpath = rs.getString("audio");
            
            File f = new File(songpath); 
//           ls.addAll(Arrays.asList(file));
            if(sear.contains(f)){
            
            System.out.println("song already present");
  
        }else{
            sear.add(f);
            System.out.println("song aadded");
            }
        }
        
         return sear;
       
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "nope");
    }
        
        return sear;
    }
    
    
    ArrayList getListSong(String name){
         try {
        
        Connection con = myc.getConn();
        PreparedStatement pst ;
        String sql = "select * from tracks where user_id=?";
        
        pst = con.prepareStatement(sql);
        pst.setString(1, name);
        ResultSet rs=pst.executeQuery();
        
        while(rs.next()){
            String songpath = rs.getString("audio");
            
            File f = new File(songpath); 
//           ls.addAll(Arrays.asList(file));
            if(ls.contains(f)){
            
            System.out.println("song already present");
  
        }else{
            ls.add(f);
            System.out.println("song aadded");
            }
        }
        
         return ls;
       
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "nope");
    }
        
        return ls;
}
    
    
    //save playlist
    FileOutputStream fos;
    ObjectOutputStream oos;
    
    public void saveAsPlaylist(JFrame frame){
        fc.setMultiSelectionEnabled(false);
        int Valid = fc.showSaveDialog(frame);
        if (Valid == javax.swing.JFileChooser.CANCEL_OPTION){
            return;
        } else if (Valid == javax.swing.JFileChooser.APPROVE_OPTION){
            File pls = fc.getSelectedFile();
            try{
                fos = new FileOutputStream(pls + ".mcms");
                oos = new ObjectOutputStream(fos);
                for (int i=0; i<ls.size() ; i++){
                    File tmp = (File) ls.get(i);
                    oos.writeObject(tmp);
                }
                oos.close();
            }
            catch (Exception e){
                
        }
        }
    }
    FileInputStream fis;
    ObjectInputStream ois;
    
    public void openPls(JFrame frame){
        fc.setMultiSelectionEnabled(false);
        int Valid = fc.showOpenDialog(frame);
        if (Valid == javax.swing.JFileChooser.CANCEL_OPTION){
            return;
        }
        if (Valid == javax.swing.JFileChooser.APPROVE_OPTION){
            File pls = fc.getSelectedFile();
            try{
                fis = new FileInputStream(pls);
                ois = new ObjectInputStream(fis);
                File tmp;
                while ((tmp = (File) ois.readObject()) != null){
                    ls.add(tmp);
                }
              if ((tmp = (File) ois.readObject()) == null){
                  ls.isEmpty();
              }
              ois.close();
            }catch (Exception e){
        }
        
        }
    }
}
