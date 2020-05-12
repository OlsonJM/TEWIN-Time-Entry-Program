/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TimeCardComment.java
 *
 * Created on Oct 22, 2009, 2:23:05 PM
 */

package tewin;
import java.sql.*;
import java.awt.Color;
import javax.swing.JOptionPane;


/**
 *
 * @author James M. Olson
 */
public class TimeCardComment extends javax.swing.JFrame {

    private DataConnection dc;
    private String comment;
    private int weekNumber;
    private int year;
    private boolean isNew;
    private int ID;

    /** Creates new form TimeCardComment */
    public TimeCardComment(int year,int weekNumber) {
        initComponents();
        this.setTitle("Comment for TimeCard Week" + Integer.toString(weekNumber));
        this.weekNumber = weekNumber;
        this.year = year;
        this.dc = new DataConnection();
        this.dc.connect();
        this.bExitSave.setEnabled(false);
        getData();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taComment = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        bExitSave = new javax.swing.JButton();
        bExitCancel = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Enter Time Card Comment");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setResizable(false);

        taComment.setColumns(20);
        taComment.setRows(5);
        taComment.setToolTipText("Edit or Enter Comment for Time Card");
        taComment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                taCommentKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(taComment);

        jLabel1.setText("Time Card Comment");

        bExitSave.setText("Save Changes");
        bExitSave.setToolTipText("Save changes to time card comment");
        bExitSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitSaveActionPerformed(evt);
            }
        });

        bExitCancel.setText("Exit and Cancel Changes");
        bExitCancel.setToolTipText("Exit editor, Cancel changes, and return to time card");
        bExitCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitCancelActionPerformed(evt);
            }
        });

        bDelete.setText("Delete and Exit");
        bDelete.setToolTipText("Delete time card comment from database");
        bDelete.setEnabled(false);
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(bExitSave, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bExitCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bExitSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bExitCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bExitSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitSaveActionPerformed
        if(setData()){
            this.dc.closeConnection();
            this.dispose();
        }
    }//GEN-LAST:event_bExitSaveActionPerformed

    private void bExitCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitCancelActionPerformed
        this.dc.closeConnection();
        this.dispose();
    }//GEN-LAST:event_bExitCancelActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        this.dc.deleteComment(this.ID);
        this.dc.closeConnection();
        this.dispose();
    }//GEN-LAST:event_bDeleteActionPerformed

    private void taCommentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taCommentKeyTyped
        this.bExitSave.setEnabled(true);
    }//GEN-LAST:event_taCommentKeyTyped



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bExitCancel;
    private javax.swing.JButton bExitSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taComment;
    // End of variables declaration//GEN-END:variables

    private void getData(){
        ResultSet rs  = this.dc.getComment(this.year, this.weekNumber);

        try{
            if(rs.next()){
                this.ID = rs.getInt(1);
                this.comment = rs.getString(4);
                this.isNew = false;
                this.bDelete.setEnabled(true);

            }else
            {
                this.ID = -1;
                this.comment = "";
                this.isNew = true;
            }
            this.taComment.setText(this.comment);
            rs.close();
        }
         catch (Exception e) {
              connectionErr(e);
              this.taComment.setText("Error");
              this.isNew = false;
        }
    }

    /**
     * Get time card comment from database
     * @return boolean true if comment data was sucessfully retrieved from db
     */

    private boolean setData(){

        try{
                //CHECK COMMENT FIELD FOR COMMAS. IF EXISTS CANCEL UPDATE
                if(checkForCommas(this.taComment.getText())){
                    this.taComment.setBackground(Color.red);
                    JOptionPane.showMessageDialog(this, "Comment field must not contain commas");
                    return false;
                }

                //UPDATE COMMENT IF NOT AN EMPTY STRING
                this.comment = this.taComment.getText();
                if(this.comment.length()>0){
                    this.dc.setComment(this.ID,this.year,this.weekNumber, this.comment, this.isNew);
                    return true;
                }else
                {
                    JOptionPane.showMessageDialog(this, "Comment field is blank. Use delete to remove\n" +
                            "comment. Or select Exit and Cancel Changes button" );
                    return false;
                }
        }
         catch (Exception e) {
              connectionErr(e);
        }

        return false;

    }

    /**
     * General error message pane for time card comment class
     * @param e
     */
    private void connectionErr(Exception e){
        JOptionPane.showMessageDialog(this, "TimeCardComment Class Error has occured: \n" + e);
    }

    /**
     * Check String for commas
     * @param test
     * @return boolean true if string contains a command
     */

    private boolean checkForCommas(String test){
        boolean commas = false;

        if(test.contains(","))
            commas = true;
        else
            commas = false;

    return commas;
}
}