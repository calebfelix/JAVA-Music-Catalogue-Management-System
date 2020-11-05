/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccataloguemasy;


import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javazoom.jl.player.Player;

/**
 *
 * @author Nancy Merciline
 */
public class Homepage extends javax.swing.JFrame {
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    playlist pl = new playlist();
    
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
  
    public Homepage() {
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
        myc = new MySQLConnect();
        setVisible(true);
        setLocationRelativeTo(null);
        
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
void updateList() {
        updateList = pl.getListSong();
        DefaultListModel model =  new DefaultListModel();
        for (int i = 0; i < updateList.size(); i++) {
            int j = i + 1;
            model.add(i, j + " | " + ((File) updateList.get(i)).getName());
        }
        jPlaylist.setModel(model);
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
        jPanel2 = new javax.swing.JPanel();
        home_btn_var = new javax.swing.JButton();
        search_btn_var = new javax.swing.JButton();
        playlist_btn_var = new javax.swing.JButton();
        downloads_btn_var = new javax.swing.JButton();
        create_btn_var = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        home_var = new javax.swing.JPanel();
        search_var = new javax.swing.JPanel();
        playlist_var = new javax.swing.JPanel();
        add_var = new javax.swing.JButton();
        up_var = new javax.swing.JButton();
        remove_var = new javax.swing.JButton();
        down_var = new javax.swing.JButton();
        pause_var = new javax.swing.JButton();
        previous_var = new javax.swing.JButton();
        play_var = new javax.swing.JButton();
        next_var = new javax.swing.JButton();
        stop_var = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(create_btn_var, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(downloads_btn_var, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(home_btn_var, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(search_btn_var, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playlist_btn_var, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(home_btn_var)
                .addGap(33, 33, 33)
                .addComponent(search_btn_var)
                .addGap(33, 33, 33)
                .addComponent(playlist_btn_var)
                .addGap(33, 33, 33)
                .addComponent(downloads_btn_var)
                .addGap(33, 33, 33)
                .addComponent(create_btn_var)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 205, -1, -1));

        javax.swing.GroupLayout home_varLayout = new javax.swing.GroupLayout(home_var);
        home_var.setLayout(home_varLayout);
        home_varLayout.setHorizontalGroup(
            home_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 928, Short.MAX_VALUE)
        );
        home_varLayout.setVerticalGroup(
            home_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab1", home_var);

        javax.swing.GroupLayout search_varLayout = new javax.swing.GroupLayout(search_var);
        search_var.setLayout(search_varLayout);
        search_varLayout.setHorizontalGroup(
            search_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 928, Short.MAX_VALUE)
        );
        search_varLayout.setVerticalGroup(
            search_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
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

        play_var.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        play_var.setText(" ▶");
        play_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                play_varActionPerformed(evt);
            }
        });

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

        jScrollPane2.setViewportView(jPlaylist);

        jLabel9.setFont(new java.awt.Font("Papyrus", 1, 36)); // NOI18N
        jLabel9.setText("Playlist");

        javax.swing.GroupLayout playlist_varLayout = new javax.swing.GroupLayout(playlist_var);
        playlist_var.setLayout(playlist_varLayout);
        playlist_varLayout.setHorizontalGroup(
            playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playlist_varLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
            .addGroup(playlist_varLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playlist_varLayout.createSequentialGroup()
                        .addComponent(add_var, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(remove_var, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(playlist_varLayout.createSequentialGroup()
                        .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(playlist_varLayout.createSequentialGroup()
                                .addComponent(previous_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(pause_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(play_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(stop_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(next_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(up_var, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(down_var, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(246, 246, 246))
        );
        playlist_varLayout.setVerticalGroup(
            playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playlist_varLayout.createSequentialGroup()
                .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playlist_varLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel9)
                        .addGap(107, 107, 107)
                        .addComponent(up_var)
                        .addGap(74, 74, 74)
                        .addComponent(down_var))
                    .addGroup(playlist_varLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(add_var)
                            .addComponent(remove_var))
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playlist_varLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stop_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(next_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(playlist_varLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pause_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(previous_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(play_var, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
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
            .addGap(0, 574, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", downloads_var);

        jLabel2.setFont(new java.awt.Font("Papyrus", 1, 36)); // NOI18N
        jLabel2.setText("Create");

        jLabel3.setFont(new java.awt.Font("Papyrus", 1, 24)); // NOI18N
        jLabel3.setText("Add Music:");

        jLabel4.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel4.setText("Track Name:");

        jLabel5.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel5.setText("Artist :");

        jLabel6.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel6.setText("Genre :");

        jLabel7.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel7.setText("Description :");

        jLabel8.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel8.setText("Track file:");

        description_var.setColumns(20);
        description_var.setRows(5);
        jScrollPane1.setViewportView(description_var);

        submitTrack_var.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        submitTrack_var.setText("Submit Track");
        submitTrack_var.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        submitTrack_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitTrack_varActionPerformed(evt);
            }
        });

        reset_var.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        reset_var.setText("Reset");
        reset_var.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        reset_var.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_varActionPerformed(evt);
            }
        });

        filechose_var.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
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
                        .addGap(96, 96, 96)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(422, 422, 422)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(create_varLayout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(genre_var, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(create_varLayout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(create_varLayout.createSequentialGroup()
                        .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(path_var, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(create_varLayout.createSequentialGroup()
                        .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(create_varLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(trackname_var))
                            .addGroup(create_varLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(artist_var, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(reset_var, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submitTrack_var, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filechose_var, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        create_varLayout.setVerticalGroup(
            create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(create_varLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(create_varLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(5, 5, 5)
                .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(create_varLayout.createSequentialGroup()
                        .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(trackname_var, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(create_varLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel5))
                            .addGroup(create_varLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(artist_var, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(create_varLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(reset_var))
                    .addComponent(submitTrack_var))
                .addGap(42, 42, 42)
                .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(create_varLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6))
                    .addComponent(genre_var, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(filechose_var)
                    .addComponent(path_var, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("tab5", create_var);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 930, 600));

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
                .addContainerGap(205, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(logout_var, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        coverpanelLayout.setVerticalGroup(
            coverpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coverpanelLayout.createSequentialGroup()
                .addGroup(coverpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coverpanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(logout_var))
                    .addGroup(coverpanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(coverpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -8, 1140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
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
                    String saveQ = "insert into tracks(track_name, artist, genre,description,audio) values(?,?,?,?,?)";
                    pst = con.prepareStatement(saveQ);
                    pst.setString(1, Track_name);
                    pst.setString(2, Artist);
                    pst.setString(3, Genre);
                    pst.setString(4, Description);
                    pst.setString(5, path_link);
          
                    
                    //track
                  
             
                    
                    int i = pst.executeUpdate();
                    if (i>=1) {
                        JOptionPane.showMessageDialog(null, "done bro");
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Loss");
                    }
                            
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
        }

    }//GEN-LAST:event_submitTrack_varActionPerformed

    private void reset_varActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_varActionPerformed
        // TODO add your handling code here:
        trackname_var.setText("");
        artist_var.setText("");
        description_var.setText("");
        genre_var.setText("");
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
                new Homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JButton stop_var;
    private javax.swing.JButton submitTrack_var;
    private javax.swing.JTextField trackname_var;
    private javax.swing.JButton up_var;
    // End of variables declaration//GEN-END:variables

byte[] music = null;
}
