/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nlo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

/**
 *
 * @author itsto
 */
public class FileRead {
    JButton file_browse = new JButton("Browse File");
    JPanel filePanel = new JPanel();
    List<Double> data = new ArrayList();
    File file = null;
    /**
     * Just Call it to get data only
     */
    public FileRead() {
        filePanel.add(file_browse);
        file_browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser selector = new JFileChooser();
                if(selector.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
                {
                    file = selector.getSelectedFile();
                    String path = file.getName();
                    if(path.endsWith(".csv"))
                    {
                        data.removeAll(data);
                        try {
                            Scanner sc = new Scanner(file);
                            while (sc.hasNext())
                            {
                                String raw = sc.nextLine();
                                String[] values = raw.split(",");
                                data.add(Double.valueOf(values[4]));
                            }
                            sc.close();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(FileRead.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                        
                    
                }
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        
    }
    /**
     * for plotting graph.
     * @param graph 
     */
    public FileRead(Graph graph) {
        filePanel.add(file_browse);
        file_browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser selector = new JFileChooser();
                if(selector.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
                {
                    file = selector.getSelectedFile();
                    String path = file.getName();
                    if(path.endsWith(".csv"))
                    {
                        data.removeAll(data);
                        try {
                            Scanner sc = new Scanner(file);
                            while (sc.hasNext())
                            {
                                String raw = sc.nextLine();
                                String[] values = raw.split(",");
                                data.add(Double.valueOf(values[4]));
                            }
                            sc.close();
                            graph.startPlot(data);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(FileRead.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                        
                    
                }
//                throw new UnsupportedOperationException("Not suppo yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        
    }
    
    
    
    
}
