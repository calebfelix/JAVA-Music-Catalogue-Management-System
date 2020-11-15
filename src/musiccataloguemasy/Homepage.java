/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccataloguemasy;


import AppPackage.AnimationClass;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javazoom.jl.player.Player;

/**
 *
 * @author Nancy Merciline
 */
public class Homepage extends javax.swing.JFrame {
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    playlist pl = new playlist();
    AnimationClass ac = new AnimationClass();
 
    
private Player player;
private FileInputStream FIS;
private BufferedInputStream BIS;
private boolean canResume;
private boolean ispressed;
private String path;
private int total;
private int stopped;
private boolean valid;
////////////////////////////////////////////////////////////////////////////
    
    ArrayList updateList = new ArrayList();
    
   
    File simpan;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Creates new form Homepage
     */
    MySQLConnect myc;
  
    public Homepage(String UNAME) {
    
    player = null;
    FIS = null;
    valid = false;
    BIS = null;
    path = null;
    total = 0;
    stopped = 0;
    canResume = false;
    ispressed=false;
        initComponents();
        HOME_UNAME.setText(UNAME);
        updateList();

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
        int timestamp = 1000;
        new Thread()  {
            @Override
            public void run() {
                int nb=0;
                try{
                    
                     
                    while (true) {                        
                        switch(nb){
/////////////////////////////////////////////////////////////////////////////////Left move///////////////////////////////////////////////
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
                                 
                                 ImageIcon II2 = new ImageIcon(getClass().getResource("/images/Alan Walker.jpg.png"));
                                JL2.setIcon(II2);
                                 
                                 Thread.sleep(timestamp);
                                ac.jLabelXRight(-500, 0, 12, 10, JL1);
                                ac.jLabelXRight(0, 500, 12, 10, JL2);
                                
                                System.out.println("done"+nb);
                                nb++;
                                break;        
                                
                                case 2:
                                    
                                ImageIcon II3 = new ImageIcon(getClass().getResource("/images/Billie Eilish.jpg.png"));
                                JL1.setIcon(II3);
                                 Thread.sleep(timestamp);
                                ac.jLabelXLeft(0, -500, 12, 10, JL1);
                                ac.jLabelXLeft(500, 0, 12, 10, JL2);
                                
                                System.out.println("done"+nb);
                                nb++;
                                break;
                                
                             case 3:
                                 ImageIcon II4  = new ImageIcon(getClass().getResource("/images/Ed Sheeran.jpg.png"));
                                JL2.setIcon(II4);
                                 
                                 Thread.sleep(timestamp);
                                ac.jLabelXRight(-500, 0, 12, 10, JL1);
                                ac.jLabelXRight(0, 500, 12, 10, JL2);
                                
                                System.out.println("done"+nb);
                                nb++;
                                break;
                                
                                case 4:
                                    
                                ImageIcon II5 = new ImageIcon(getClass().getResource("/images/Khalid.jpg.png"));
                                JL1.setIcon(II5); 
                                    
                                 Thread.sleep(timestamp);
                                ac.jLabelXLeft(0, -500, 12, 10, JL1);
                                ac.jLabelXLeft(500, 0, 12, 10, JL2);
                                
                                System.out.println("done"+nb);
                                nb++;
                                break;
                                
                             case 5:
                                 
                                 ImageIcon II6  = new ImageIcon(getClass().getResource("/images/Taylor Swift.jpg.png"));
                                JL2.setIcon(II6);
                                 
                                 Thread.sleep(timestamp);
                                ac.jLabelXRight(-500, 0, 12, 10, JL1);
                                ac.jLabelXRight(0, 500, 12, 10, JL2);
                                
                                System.out.println("done"+nb);
                                nb++;
                                break;
                                
                                case 6:
                                    
                                ImageIcon II7 = new ImageIcon(getClass().getResource("/images/Travis Scott.jpg.png"));
                                JL1.setIcon(II7); 
                                    
                                 Thread.sleep(timestamp);
                                ac.jLabelXLeft(0, -500, 12, 10, JL1);
                                ac.jLabelXLeft(500, 0, 12, 10, JL2);
                                
                                System.out.println("done"+nb);
                                nb++;
                                break;
                                
                             case 7:
                                 
                                 ImageIcon II8  = new ImageIcon(getClass().getResource("/images/Post Malone.jpg.png"));
                                JL2.setIcon(II8);
                                 
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
        }.start();
    }    
    
    
void updateList() {
        updateList = pl.getListSong(HOME_UNAME.getText());
        System.out.println("helllllllllllllllllllllllllllllllllllllllll"+updateList);
        DefaultListModel model =  new DefaultListModel();
        for (int i = 0; i < updateList.size(); i++) {
            int j = i + 1;
            model.add(i, j + " | " + ((File) updateList.get(i)).getName());
        }
        jPlaylist.setModel(model);
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

void remove(){
    try{
        int akandihapus = jPlaylist.getLeadSelectionIndex();
        pl.ls.remove(akandihapus);
        updateList();
    }catch(Exception e){
    }
}

void up(){
    try{
        int s1 = jPlaylist.getLeadSelectionIndex();
        simpan = (File) pl.ls.get(s1);
        pl.ls.remove(s1);
        pl.ls.add(s1 - 1, simpan );
        updateList();
        jPlaylist.setSelectedIndex(s1-1);
    }catch(Exception e){
    }
}

void down(){
    try{
        int s1 = jPlaylist.getLeadSelectionIndex();
        simpan = (File) pl.ls.get(s1);
        pl.ls.remove(s1);
        pl.ls.add(s1 + 1, simpan );
        updateList();
        jPlaylist.setSelectedIndex(s1+1);
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

File play1;


public void pause(){
    try{
    stopped = FIS.available();
    player.close();
    FIS = null;
    BIS = null;
    player = null;
    if(valid) canResume = true;
        pause_var.setEnabled(false);
        System.out.println("pause");
        play_var.setEnabled(true);
        
    }catch(Exception e){

    }
}

public void resume(){
    if(!canResume) return;
    if(putar(total-stopped)) canResume = false;
}


public boolean putar(int pos){
    valid = true;
    canResume = false;
    try{
     int p1 = jPlaylist.getSelectedIndex();
     play1 = (File) this.updateList.get(p1);
    FIS = new FileInputStream(play1);
    total = FIS.available();
    if(pos > -1) FIS.skip(pos);
    BIS = new BufferedInputStream(FIS);
    player = new Player(BIS);
    new Thread(
            new Runnable(){
                public void run(){
                    try{
                        play_var.setEnabled(false);
                        player.play();
                        play_var.setEnabled(true);
                        System.out.println("song done");
                       
                        
                        
                        
                        
                        
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Error playing mp3 file");
                        
                        valid = false;
                    }
                }
            }
    ).start();
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Select mp3 file");
        playlist_btn_var.doClick();
        valid = false;
        
    }
     
    return valid;
}

public boolean canResume(){
    return canResume;
}

File sa;
void next(){
    
        try{
            player.close();
            int s1 = jPlaylist.getSelectedIndex() +1;
            sa = (File) this.pl.ls.get(s1);
            FileInputStream fis = new FileInputStream(sa);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new javazoom.jl.player.Player(bis);
            
            jPlaylist.setSelectedIndex(s1);
        }catch(Exception e){
            System.out.println("Problem playing file");
            System.out.println(e);
            try{
            player.close();
            int s1 = 0;
            sa = (File) this.pl.ls.get(s1);
            FileInputStream fis = new FileInputStream(sa);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new javazoom.jl.player.Player(bis);
            
            jPlaylist.setSelectedIndex(s1);
        }catch(Exception er){
            
                System.out.println(er);
        }
            
            
        }
        pause_var.setEnabled(true);
        putar(-1);
//        new Thread(
//            new Runnable(){
//                public void run(){
//                    try{
//                        player.play();
//                    }catch(Exception e){
//                        JOptionPane.showMessageDialog(null, "Error playing mp3 file");
//                        valid = false;
//                    }
//                }
//            }
//    ).start();
    

}

void previous(){
   
        try{
            player.close();
            int s1 = jPlaylist.getSelectedIndex() -1;
            sa = (File) this.pl.ls.get(s1);
            FileInputStream fis = new FileInputStream(sa);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new javazoom.jl.player.Player(bis);
            jPlaylist.setSelectedIndex(s1);
        }catch(Exception e){
            System.out.println("Problem playing file");
            System.out.println(e);
        }
        pause_var.setEnabled(true);
        putar(-1);
//        new Thread(
//            new Runnable(){
//                public void run(){
//                    try{
//                        player.play();
//                    }catch(Exception e){
//                        JOptionPane.showMessageDialog(null, "Error playing mp3 file");
//                        valid = false;
//                    }
//                }
//            }
//    ).start();
    
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
        JL2 = new javax.swing.JLabel();
        JL1 = new javax.swing.JLabel();
        search_var = new javax.swing.JPanel();
        playlist_var = new javax.swing.JPanel();
        add_var = new javax.swing.JButton();
        up_var = new javax.swing.JButton();
        remove_var = new javax.swing.JButton();
        down_var = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPlaylist = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        downloads_var = new javax.swing.JPanel();
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
        coverpanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logout_var = new javax.swing.JButton();
        Player_controls = new javax.swing.JPanel();
        next_var = new javax.swing.JButton();
        stop_var = new javax.swing.JButton();
        play_var = new javax.swing.JButton();
        pause_var = new javax.swing.JButton();
        previous_var = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        side_panel.setBackground(new java.awt.Color(204, 204, 255));

        home_btn_var.setBackground(new java.awt.Color(204, 204, 255));
        home_btn_var.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        home_btn_var.setText("Home");
        home_btn_var.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        search_btn_var.setBackground(new java.awt.Color(204, 204, 255));
        search_btn_var.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        search_btn_var.setText("Search");
        search_btn_var.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        playlist_btn_var.setBackground(new java.awt.Color(204, 204, 255));
        playlist_btn_var.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        playlist_btn_var.setText("Playlist");
        playlist_btn_var.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        downloads_btn_var.setBackground(new java.awt.Color(204, 204, 255));
        downloads_btn_var.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        downloads_btn_var.setText("Downloads");
        downloads_btn_var.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        create_btn_var.setBackground(new java.awt.Color(204, 204, 255));
        create_btn_var.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        create_btn_var.setText("Create");
        create_btn_var.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
                .addGap(29, 29, 29)
                .addGroup(side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(create_btn_var, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(downloads_btn_var, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(home_btn_var, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(search_btn_var, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playlist_btn_var, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        side_panelLayout.setVerticalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, side_panelLayout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(home_btn_var)
                .addGap(33, 33, 33)
                .addComponent(search_btn_var)
                .addGap(33, 33, 33)
                .addComponent(playlist_btn_var)
                .addGap(33, 33, 33)
                .addComponent(downloads_btn_var)
                .addGap(33, 33, 33)
                .addComponent(create_btn_var)
                .addGap(98, 98, 98))
        );

        jPanel1.add(side_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, 510));

        home_var.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HOME_UNAME.setFont(new java.awt.Font("Papyrus", 1, 24)); // NOI18N
        HOME_UNAME.setText("NONE");

        welcome_var.setFont(new java.awt.Font("Papyrus", 1, 24)); // NOI18N
        welcome_var.setText("WELCOME  !!!");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(welcome_var)
                    .addComponent(HOME_UNAME))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(welcome_var)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HOME_UNAME)
                .addContainerGap(365, Short.MAX_VALUE))
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

        javax.swing.GroupLayout search_varLayout = new javax.swing.GroupLayout(search_var);
        search_var.setLayout(search_varLayout);
        search_varLayout.setHorizontalGroup(
            search_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 928, Short.MAX_VALUE)
        );
        search_varLayout.setVerticalGroup(
            search_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", search_var);

        add_var.setText("Add ＋");
        add_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_varActionPerformed(evt);
            }
        });

        up_var.setText("Move up ▲");
        up_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up_varActionPerformed(evt);
            }
        });

        remove_var.setText("Remove  –");
        remove_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_varActionPerformed(evt);
            }
        });

        down_var.setText("Move down ▼");
        down_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                down_varActionPerformed(evt);
            }
        });

        jPlaylist.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jScrollPane2.setViewportView(jPlaylist);

        jLabel9.setFont(new java.awt.Font("Papyrus", 1, 36)); // NOI18N
        jLabel9.setText("Playlist");

        javax.swing.GroupLayout playlist_varLayout = new javax.swing.GroupLayout(playlist_var);
        playlist_var.setLayout(playlist_varLayout);
        playlist_varLayout.setHorizontalGroup(
            playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playlist_varLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(playlist_varLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(up_var, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(down_var, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(246, 246, 246))
                    .addGroup(playlist_varLayout.createSequentialGroup()
                        .addComponent(add_var, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(remove_var, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))))
        );
        playlist_varLayout.setVerticalGroup(
            playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playlist_varLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(add_var)
                        .addComponent(remove_var)))
                .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playlist_varLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(up_var)
                        .addGap(74, 74, 74)
                        .addComponent(down_var))
                    .addGroup(playlist_varLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );

        jTabbedPane1.addTab("tab3", playlist_var);

        javax.swing.GroupLayout downloads_varLayout = new javax.swing.GroupLayout(downloads_var);
        downloads_var.setLayout(downloads_varLayout);
        downloads_varLayout.setHorizontalGroup(
            downloads_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 928, Short.MAX_VALUE)
        );
        downloads_varLayout.setVerticalGroup(
            downloads_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", downloads_var);

        jLabel2.setFont(new java.awt.Font("Papyrus", 1, 36)); // NOI18N
        jLabel2.setText("Create");

        jLabel3.setFont(new java.awt.Font("Papyrus", 1, 24)); // NOI18N
        jLabel3.setText("Add Music:");

        jLabel4.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        jLabel4.setText("Track Name :");

        jLabel5.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        jLabel5.setText("Artist :");

        jLabel6.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        jLabel6.setText("Genre :");

        jLabel7.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        jLabel7.setText("Description :");

        jLabel8.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        jLabel8.setText("Track file :");

        description_var.setColumns(20);
        description_var.setRows(5);
        jScrollPane1.setViewportView(description_var);

        submitTrack_var.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        submitTrack_var.setText("Submit Track");
        submitTrack_var.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        submitTrack_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitTrack_varActionPerformed(evt);
            }
        });

        reset_var.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        reset_var.setText("Reset");
        reset_var.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        reset_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_varActionPerformed(evt);
            }
        });

        filechose_var.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        filechose_var.setText("select file");
        filechose_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filechose_varActionPerformed(evt);
            }
        });

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
                        .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                        .addComponent(artist_var, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(85, 85, 85)
                .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(submitTrack_var, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset_var, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
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
                            .addComponent(filechose_var)
                            .addComponent(path_var, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(55, 55, 55)
                        .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addGroup(create_varLayout.createSequentialGroup()
                                .addComponent(submitTrack_var)
                                .addGap(25, 25, 25)
                                .addComponent(reset_var))
                            .addComponent(jScrollPane1))))
                .addGap(67, 67, 67))
        );

        jTabbedPane1.addTab("tab5", create_var);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 930, 530));

        coverpanel.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Papyrus", 1, 36)); // NOI18N
        jLabel1.setText("Music Catalogue Management System!!");

        logout_var.setBackground(new java.awt.Color(204, 255, 255));
        logout_var.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        logout_var.setText("Logout");
        logout_var.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logout_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_varActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout coverpanelLayout = new javax.swing.GroupLayout(coverpanel);
        coverpanel.setLayout(coverpanelLayout);
        coverpanelLayout.setHorizontalGroup(
            coverpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coverpanelLayout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(logout_var, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        coverpanelLayout.setVerticalGroup(
            coverpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coverpanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(logout_var)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coverpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(coverpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -8, 1140, 160));

        Player_controls.setBackground(new java.awt.Color(204, 204, 204));

        next_var.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        next_var.setText("►►");
        next_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_varActionPerformed(evt);
            }
        });

        stop_var.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        stop_var.setText("■");
        stop_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stop_varActionPerformed(evt);
            }
        });

        play_var.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        play_var.setText(" ▶");
        play_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                play_varActionPerformed(evt);
            }
        });

        pause_var.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        pause_var.setText("| |");
        pause_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pause_varActionPerformed(evt);
            }
        });

        previous_var.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        previous_var.setText("◄◄");
        previous_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previous_varActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Player_controlsLayout = new javax.swing.GroupLayout(Player_controls);
        Player_controls.setLayout(Player_controlsLayout);
        Player_controlsLayout.setHorizontalGroup(
            Player_controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Player_controlsLayout.createSequentialGroup()
                .addContainerGap(350, Short.MAX_VALUE)
                .addComponent(previous_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(pause_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(play_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(stop_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(next_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(320, 320, 320))
        );
        Player_controlsLayout.setVerticalGroup(
            Player_controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Player_controlsLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(Player_controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(next_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stop_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(play_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pause_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previous_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(Player_controls, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 1120, 80));

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

    private void logout_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_varActionPerformed
         new Intpage().setVisible(true);
         player.close();
         
         

       this.setVisible(false);
       
    }//GEN-LAST:event_logout_varActionPerformed

    private void home_btn_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_btn_varActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_home_btn_varActionPerformed

    private void playlist_btn_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playlist_btn_varActionPerformed
//        updateList();
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_playlist_btn_varActionPerformed

    private void downloads_btn_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloads_btn_varActionPerformed
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_downloads_btn_varActionPerformed

    private void create_btn_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_btn_varActionPerformed
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_create_btn_varActionPerformed

    private void search_btn_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btn_varActionPerformed
        jTabbedPane1.setSelectedIndex(1);
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
        add();        // TODO add your handling code here:
    }//GEN-LAST:event_add_varActionPerformed

    private void up_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up_varActionPerformed
        up();        // TODO add your handling code here:
    }//GEN-LAST:event_up_varActionPerformed

    private void remove_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_varActionPerformed
      remove();  // TODO add your handling code here:
    }//GEN-LAST:event_remove_varActionPerformed

    private void down_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_down_varActionPerformed
        down();// TODO add your handling code here:
    }//GEN-LAST:event_down_varActionPerformed

    private void pause_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pause_varActionPerformed
       pause(); // TODO add your handling code here:
    }//GEN-LAST:event_pause_varActionPerformed

    private void previous_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previous_varActionPerformed
       previous(); // TODO add your handling code here:
    }//GEN-LAST:event_previous_varActionPerformed

    private void play_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_play_varActionPerformed
                if(canResume==false){
            
            putar(-1);
                
        }

        else{
            resume();
            pause_var.setEnabled(true);
            play_var.setEnabled(false);
            System.out.println("resume");
            
        }
    }//GEN-LAST:event_play_varActionPerformed

    private void next_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_varActionPerformed
        next();// TODO add your handling code here:
    }//GEN-LAST:event_next_varActionPerformed

    private void stop_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stop_varActionPerformed
                if(canResume==false && valid==true){
                player.close();
                canResume=false;
                play_var.setEnabled(true);
                System.out.println(canResume);
                System.out.println(valid);
        }else{
            System.out.println("stopping");
                System.out.println(canResume);
                System.out.println(valid);
        }
    }//GEN-LAST:event_stop_varActionPerformed

    private void filechose_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filechose_varActionPerformed
       JFileChooser chooser = new JFileChooser();
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
    private javax.swing.JPanel Player_controls;
    private javax.swing.JButton add_var;
    private javax.swing.JTextField artist_var;
    private javax.swing.JPanel coverpanel;
    private javax.swing.JButton create_btn_var;
    private javax.swing.JPanel create_var;
    private javax.swing.JTextArea description_var;
    private javax.swing.JButton down_var;
    private javax.swing.JButton downloads_btn_var;
    private javax.swing.JPanel downloads_var;
    private javax.swing.JButton filechose_var;
    private javax.swing.JTextField genre_var;
    private javax.swing.JButton home_btn_var;
    private javax.swing.JPanel home_var;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JList<String> jPlaylist;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logout_var;
    private javax.swing.JButton next_var;
    private javax.swing.JTextField path_var;
    private javax.swing.JButton pause_var;
    private javax.swing.JButton play_var;
    private javax.swing.JButton playlist_btn_var;
    private javax.swing.JPanel playlist_var;
    private javax.swing.JButton previous_var;
    private javax.swing.JButton remove_var;
    private javax.swing.JButton reset_var;
    private javax.swing.JButton search_btn_var;
    private javax.swing.JPanel search_var;
    private javax.swing.JPanel side_panel;
    private javax.swing.JButton stop_var;
    private javax.swing.JButton submitTrack_var;
    private javax.swing.JTextField trackname_var;
    private javax.swing.JButton up_var;
    private javax.swing.JLabel welcome_var;
    // End of variables declaration//GEN-END:variables

byte[] music = null;
}
