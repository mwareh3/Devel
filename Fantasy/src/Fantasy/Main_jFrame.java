/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fantasy;

import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Mike
 */
public class Main_jFrame extends javax.swing.JFrame {

    /**
     * Creates new form Main_jFrame
     */
    public Main_jFrame() {
        initComponents();
        
        // These lines set the jTable to only allow single row selection
        this.Band_jTable.setSelectionModel(new ForcedListSelectionModel());
        this.BandMember_jTable.setSelectionModel(new ForcedListSelectionModel());        
        this.Album_jTable.setSelectionModel(new ForcedListSelectionModel());
        this.Song_jTable.setSelectionModel(new ForcedListSelectionModel());
        this.Venue_jTable.setSelectionModel(new ForcedListSelectionModel());
        this.FantasyUser_jTable.setSelectionModel(new ForcedListSelectionModel());
        this.Followed_jTable.setSelectionModel(new ForcedListSelectionModel());
        
        // The lines select the first row on init
        this.Band_jTable.setRowSelectionInterval(0, 0);
        this.Album_jTable.setRowSelectionInterval(0, 0);
        this.Song_jTable.setRowSelectionInterval(0, 0);
        this.FantasyUser_jTable.setRowSelectionInterval(0,0);
    }

    public class ForcedListSelectionModel extends DefaultListSelectionModel {

        public ForcedListSelectionModel () {
            setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }

        @Override
        public void clearSelection() {
        }

        @Override
        public void removeSelectionInterval(int index0, int index1) {
        }

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("jdbc:derby:Fantasy-DBPU").createEntityManager();
        bandQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT b FROM Band b");
        bandList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : bandQuery.getResultList();
        bandMemberQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT b FROM BandMember b");
        bandMemberList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : bandMemberQuery.getResultList();
        venueQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT v FROM Venue v");
        venueList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : venueQuery.getResultList();
        fantasyUserQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT f FROM FantasyUser f");
        fantasyUserList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : fantasyUserQuery.getResultList();
        followedQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT f FROM Followed f");
        followedList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : followedQuery.getResultList();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        BandInfo_jPanel = new javax.swing.JPanel();
        BandTable_jScrollPane = new javax.swing.JScrollPane();
        Band_jTable = new javax.swing.JTable();
        BandMemberTable_jScrollPane = new javax.swing.JScrollPane();
        BandMember_jTable = new javax.swing.JTable();
        BandMember_jLabel = new javax.swing.JLabel();
        Band_jLabel = new javax.swing.JLabel();
        Album_jLabel = new javax.swing.JLabel();
        AlbumTable_jScrollPane = new javax.swing.JScrollPane();
        Album_jTable = new javax.swing.JTable();
        Song_jLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Song_jTable = new javax.swing.JTable();
        Venue_jLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Venue_jTable = new javax.swing.JTable();
        FantasyUser_jPanel = new javax.swing.JPanel();
        FantasyUser_jLabel = new javax.swing.JLabel();
        FantasyUserTable_jScrollPane = new javax.swing.JScrollPane();
        FantasyUser_jTable = new javax.swing.JTable();
        FollowedTable_jScrollPane = new javax.swing.JScrollPane();
        Followed_jTable = new javax.swing.JTable();
        Followed_jLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Band_jTable.getTableHeader().setReorderingAllowed(false);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, bandList, Band_jTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${bandName}"));
        columnBinding.setColumnName("Band Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${startDate}"));
        columnBinding.setColumnName("Start Date");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${endDate}"));
        columnBinding.setColumnName("End Date");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        BandTable_jScrollPane.setViewportView(Band_jTable);

        BandMember_jTable.getTableHeader().setReorderingAllowed(false);

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedElement.bandMemberCollection}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, Band_jTable, eLProperty, BandMember_jTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fName}"));
        columnBinding.setColumnName("First Name");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${minit}"));
        columnBinding.setColumnName("Middle Initial");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lName}"));
        columnBinding.setColumnName("Last Name");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${positionInBand}"));
        columnBinding.setColumnName("Position In Band");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${bandStartDate}"));
        columnBinding.setColumnName("Start Date with Band");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${endDate}"));
        columnBinding.setColumnName("End Date");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        BandMemberTable_jScrollPane.setViewportView(BandMember_jTable);

        BandMember_jLabel.setText("Band Members");

        Band_jLabel.setText("Bands");

        Album_jLabel.setText("Albums");

        Album_jTable.getTableHeader().setReorderingAllowed(false);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedElement.albumCollection}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, Band_jTable, eLProperty, Album_jTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${albumName}"));
        columnBinding.setColumnName("Album Name");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${releaseYear}"));
        columnBinding.setColumnName("Release Year");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${recordLabel}"));
        columnBinding.setColumnName("Record Label");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        AlbumTable_jScrollPane.setViewportView(Album_jTable);

        Song_jLabel.setText("Songs");

        Song_jTable.getTableHeader().setReorderingAllowed(false);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedElement.songCollection}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, Album_jTable, eLProperty, Song_jTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${songName}"));
        columnBinding.setColumnName("Song Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${trackNum}"));
        columnBinding.setColumnName("Track Number");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(Song_jTable);

        Venue_jLabel.setText("Venue");

        Venue_jTable.getTableHeader().setReorderingAllowed(false);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, venueList, Venue_jTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${venueName}"));
        columnBinding.setColumnName("Venue Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${streetAddress}"));
        columnBinding.setColumnName("Street Address");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${city}"));
        columnBinding.setColumnName("City");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${usState}"));
        columnBinding.setColumnName("Us State");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(Venue_jTable);

        javax.swing.GroupLayout BandInfo_jPanelLayout = new javax.swing.GroupLayout(BandInfo_jPanel);
        BandInfo_jPanel.setLayout(BandInfo_jPanelLayout);
        BandInfo_jPanelLayout.setHorizontalGroup(
            BandInfo_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BandTable_jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
            .addComponent(BandMemberTable_jScrollPane)
            .addComponent(AlbumTable_jScrollPane)
            .addComponent(jScrollPane1)
            .addGroup(BandInfo_jPanelLayout.createSequentialGroup()
                .addGroup(BandInfo_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BandMember_jLabel)
                    .addComponent(Band_jLabel)
                    .addComponent(Album_jLabel)
                    .addComponent(Song_jLabel)
                    .addComponent(Venue_jLabel))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        BandInfo_jPanelLayout.setVerticalGroup(
            BandInfo_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BandInfo_jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Band_jLabel)
                .addGap(3, 3, 3)
                .addComponent(BandTable_jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BandMember_jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BandMemberTable_jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Album_jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AlbumTable_jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Song_jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Venue_jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Band Info", BandInfo_jPanel);

        FantasyUser_jLabel.setText("Fantasy User");

        FantasyUser_jTable.getTableHeader().setReorderingAllowed(false);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, fantasyUserList, FantasyUser_jTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${userName}"));
        columnBinding.setColumnName("User Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fname}"));
        columnBinding.setColumnName("Fisrt Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${minit}"));
        columnBinding.setColumnName("M Init");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lname}"));
        columnBinding.setColumnName("Last Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${birthDate}"));
        columnBinding.setColumnName("Brith Date");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        FantasyUserTable_jScrollPane.setViewportView(FantasyUser_jTable);

        Followed_jTable.getTableHeader().setReorderingAllowed(false);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedElement.followedCollection}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, FantasyUser_jTable, eLProperty, Followed_jTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${bandName}"));
        columnBinding.setColumnName("Band Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        FollowedTable_jScrollPane.setViewportView(Followed_jTable);

        Followed_jLabel.setText("Followed");

        javax.swing.GroupLayout FantasyUser_jPanelLayout = new javax.swing.GroupLayout(FantasyUser_jPanel);
        FantasyUser_jPanel.setLayout(FantasyUser_jPanelLayout);
        FantasyUser_jPanelLayout.setHorizontalGroup(
            FantasyUser_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FantasyUserTable_jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
            .addGroup(FantasyUser_jPanelLayout.createSequentialGroup()
                .addGroup(FantasyUser_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FantasyUser_jLabel)
                    .addComponent(Followed_jLabel))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(FollowedTable_jScrollPane)
        );
        FantasyUser_jPanelLayout.setVerticalGroup(
            FantasyUser_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FantasyUser_jPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(FantasyUser_jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FantasyUserTable_jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Followed_jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FollowedTable_jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(410, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Fantasy User", FantasyUser_jPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main_jFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_jFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_jFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_jFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_jFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane AlbumTable_jScrollPane;
    private javax.swing.JLabel Album_jLabel;
    private javax.swing.JTable Album_jTable;
    private javax.swing.JPanel BandInfo_jPanel;
    private javax.swing.JScrollPane BandMemberTable_jScrollPane;
    private javax.swing.JLabel BandMember_jLabel;
    private javax.swing.JTable BandMember_jTable;
    private javax.swing.JScrollPane BandTable_jScrollPane;
    private javax.swing.JLabel Band_jLabel;
    private javax.swing.JTable Band_jTable;
    private javax.swing.JScrollPane FantasyUserTable_jScrollPane;
    private javax.swing.JLabel FantasyUser_jLabel;
    private javax.swing.JPanel FantasyUser_jPanel;
    private javax.swing.JTable FantasyUser_jTable;
    private javax.swing.JScrollPane FollowedTable_jScrollPane;
    private javax.swing.JLabel Followed_jLabel;
    private javax.swing.JTable Followed_jTable;
    private javax.swing.JLabel Song_jLabel;
    private javax.swing.JTable Song_jTable;
    private javax.swing.JLabel Venue_jLabel;
    private javax.swing.JTable Venue_jTable;
    private java.util.List<Fantasy.Band> bandList;
    private java.util.List<Fantasy.BandMember> bandMemberList;
    private javax.persistence.Query bandMemberQuery;
    private javax.persistence.Query bandQuery;
    private javax.persistence.EntityManager entityManager;
    private java.util.List<Fantasy.FantasyUser> fantasyUserList;
    private javax.persistence.Query fantasyUserQuery;
    private java.util.List<Fantasy.Followed> followedList;
    private javax.persistence.Query followedQuery;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.util.List<Fantasy.Venue> venueList;
    private javax.persistence.Query venueQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
