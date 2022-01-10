package br.com.marcelodaniel.mycommands;

import br.com.marcelodaniel.mycommands.database.SQLiteJDBCDriverConnection;
import br.com.marcelodaniel.mycommands.home.HomeView;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author marcelo
 */
public class MainApplication {

    public static void main(String[] args) {
        try {
            SQLiteJDBCDriverConnection.builder();
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
            System.out.println(System.getProperty("os.name"));
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HomeView homeView = new HomeView();
                homeView.setLocationRelativeTo(null);
                homeView.setVisible(true);
            }
        });
    }

}
