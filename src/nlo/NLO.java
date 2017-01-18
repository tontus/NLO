/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nlo;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author itsto
 */
public class NLO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Graph graph = new Graph();
        FileRead file = new FileRead(graph);
        frame.add(file.filePanel,BorderLayout.NORTH);
        frame.add(graph.panel);
        frame.setVisible(true);
    }
    
}
