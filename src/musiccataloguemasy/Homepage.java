/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccataloguemasy;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Nancy Merciline
 */
public class Homepage extends javax.swing.JFrame {
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        playlist pl = new playlist();
    
    ArrayList updateList = new ArrayList();
    
    javazoom.jl.player.Player player;
    File simpan;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Creates new form Homepage
     */
    MySQLConnect myc;
  
    public Homepage() {
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
static int a = 0;

void putar(){
    if(a==0){
        try{
            int p1 = jPlaylist.getSelectedIndex();
            play1 = (File) this.updateList.get(p1);
            FileInputStream fis = new FileInputStream(play1);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new javazoom.jl.player.Player(bis);
            a =1;
        }catch(Exception e){
            System.out.println("Problem playing file");
            System.out.println(e);
        }
        
        new Thread(){
            @Override
            public void run(){
                try{
                    player.play();
                
            }catch (Exception e){
            }
        }
    }.start();
    }else{
        player.close();
        a=0;
        putar();
    }
}

File sa;
void next(){
    if(a==0){
        try{
            int s1 = jPlaylist.getSelectedIndex() +1;
            sa = (File) this.pl.ls.get(s1);
            FileInputStream fis = new FileInputStream(sa);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new javazoom.jl.player.Player(bis);
            a =1;
            jPlaylist.setSelectedIndex(s1);
        }catch(Exception e){
            System.out.println("Problem playing file");
            System.out.println(e);
        }
        
        new Thread(){
            @Override
            public void run(){
                try{
                    player.play();
                
            }catch (Exception e){
            }
        }
    }.start();
    }else{
        player.close();
        a=0;
        next();
    }

}

void previous(){
    if(a==0){
        try{
            int s1 = jPlaylist.getSelectedIndex() -1;
            sa = (File) this.pl.ls.get(s1);
            FileInputStream fis = new FileInputStream(sa);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new javazoom.jl.player.Player(bis);
            a =1;
            jPlaylist.setSelectedIndex(s1);
        }catch(Exception e){
            System.out.println("Problem playing file");
            System.out.println(e);
        }
        
        new Thread(){
            @Override
            public void run(){
                try{
                    player.play();
                
            }catch (Exception e){
            }
        }
    }.start();
    }else{
        player.close();
        a=0;
        previous();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPlaylist = new javax.swing.JList<>();
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
        coverpanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

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
            .addGap(0, 969, Short.MAX_VALUE)
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
            .addGap(0, 969, Short.MAX_VALUE)
        );
        search_varLayout.setVerticalGroup(
            search_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", search_var);

        jButton1.setText("add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Move up");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("remove");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Move down");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton8.setText("| |");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("|<");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("play");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText(">|");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("[_]");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jPlaylist);

        javax.swing.GroupLayout playlist_varLayout = new javax.swing.GroupLayout(playlist_var);
        playlist_var.setLayout(playlist_varLayout);
        playlist_varLayout.setHorizontalGroup(
            playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playlist_varLayout.createSequentialGroup()
                .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playlist_varLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(playlist_varLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(playlist_varLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))))
                .addContainerGap(289, Short.MAX_VALUE))
        );
        playlist_varLayout.setVerticalGroup(
            playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playlist_varLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jButton1)
                .addGap(28, 28, 28)
                .addComponent(jButton4)
                .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playlist_varLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playlist_varLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(155, 155, 155)))
                .addGroup(playlist_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(jButton11)
                    .addComponent(jButton12))
                .addGap(47, 47, 47))
        );

        jTabbedPane1.addTab("tab3", playlist_var);

        javax.swing.GroupLayout downloads_varLayout = new javax.swing.GroupLayout(downloads_var);
        downloads_var.setLayout(downloads_varLayout);
        downloads_varLayout.setHorizontalGroup(
            downloads_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 969, Short.MAX_VALUE)
        );
        downloads_varLayout.setVerticalGroup(
            downloads_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", downloads_var);

        jLabel2.setFont(new java.awt.Font("Papyrus", 1, 24)); // NOI18N
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

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
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

        javax.swing.GroupLayout create_varLayout = new javax.swing.GroupLayout(create_var);
        create_var.setLayout(create_varLayout);
        create_varLayout.setHorizontalGroup(
            create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(create_varLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(create_varLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(create_varLayout.createSequentialGroup()
                                .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(genre_var, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                    .addComponent(artist_var, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(trackname_var, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(66, 66, 66)
                                .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(submitTrack_var, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reset_var, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(288, Short.MAX_VALUE))
                    .addGroup(create_varLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
        );
        create_varLayout.setVerticalGroup(
            create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(create_varLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(create_varLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(trackname_var, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(create_varLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(submitTrack_var)))
                .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(create_varLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(artist_var, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(create_varLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(reset_var)))
                .addGap(42, 42, 42)
                .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(genre_var, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jLabel8)
                .addGap(58, 58, 58)
                .addGroup(create_varLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab5", create_var);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, -1, 600));

        coverpanel.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Papyrus", 1, 36)); // NOI18N
        jLabel1.setText("Music Catalogue Management System!!");

        jButton6.setBackground(new java.awt.Color(204, 255, 255));
        jButton6.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        jButton6.setText("Logout");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
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
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        coverpanelLayout.setVerticalGroup(
            coverpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coverpanelLayout.createSequentialGroup()
                .addGroup(coverpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coverpanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(coverpanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton6)))
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

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         new Intpage().setVisible(true);
         player.close();
       this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

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
        
        if(Track_name.trim().equals("")||
            Artist.trim().equals("")|| 
            Genre.trim().equals("")||
            Description.trim().equals("")){
                JOptionPane.showMessageDialog(null, "All fields are compulsary");
        }else{
                
                try{
                    Connection con = myc.getConn();
                    PreparedStatement pst ;
                    String saveQ = "insert into tracks(track_name, artist, genre,description) values(?,?,?,?)";
                    pst = con.prepareStatement(saveQ);
                    pst.setString(1, Track_name);
                    pst.setString(2, Artist);
                    pst.setString(3, Genre);
                    pst.setString(4, Description);
                    
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        add();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        up();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      remove();  // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        down();// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       previous(); // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        putar();// TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        next();// TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        player.close();// TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

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
    private javax.swing.JTextField artist_var;
    private javax.swing.JPanel coverpanel;
    private javax.swing.JButton create_btn_var;
    private javax.swing.JPanel create_var;
    private javax.swing.JTextArea description_var;
    private javax.swing.JButton downloads_btn_var;
    private javax.swing.JPanel downloads_var;
    private javax.swing.JTextField genre_var;
    private javax.swing.JButton home_btn_var;
    private javax.swing.JPanel home_var;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JList<String> jPlaylist;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton playlist_btn_var;
    private javax.swing.JPanel playlist_var;
    private javax.swing.JButton reset_var;
    private javax.swing.JButton search_btn_var;
    private javax.swing.JPanel search_var;
    private javax.swing.JButton submitTrack_var;
    private javax.swing.JTextField trackname_var;
    // End of variables declaration//GEN-END:variables
}
