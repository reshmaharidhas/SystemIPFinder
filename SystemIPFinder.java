/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.ip.finder;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Reshma
 */
public class SystemIPFinder extends Frame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    Button btn;
    Label label,labelipaddr,labeladdress,labelhostname,labelinternet;
    SystemIPFinder(){
        labeladdress = new Label("Host Address:");
        labeladdress.setBounds(80,70,120,30);
        labeladdress.setBackground(Color.GRAY);
        label = new Label();
        label.setBounds(90, 100,120,30);
        labelhostname = new Label("Host name:");
        labelhostname.setBounds(80,130,120,30);
        labelhostname.setBackground(Color.GRAY);
        labelipaddr = new Label();
        labelipaddr.setBounds(90,160,120,30);  
        labelinternet = new Label();
        labelinternet.setBounds(65,190,190,30);
        labelinternet.setBackground(Color.GRAY);
        btn = new Button("Find ip of System");
        btn.setBounds(90,230,120,30);
        btn.addActionListener(this);
        add(label);
        add(labelipaddr);
        add(labeladdress);
        add(labelhostname);
        add(labelinternet);
        add(btn);
        setSize(300,300);
        setTitle("System IP finder");
        setLayout(null);
        setVisible(true);
        this.setBackground(Color.GRAY);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }
    public static void main(String[] args) {
        SystemIPFinder obj = new SystemIPFinder();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String devicename = InetAddress.getLocalHost().getHostName();
            String systemip = InetAddress.getLocalHost().getHostAddress();
            label.setText(devicename);
            labelipaddr.setText(systemip);
        } catch (UnknownHostException ex) {
            Logger.getLogger(SystemIPFinder.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            labelinternet.setText("Device connected to Internet");
            labelinternet.setForeground(Color.WHITE);
        } catch (MalformedURLException urle) {
            labelinternet.setText("Internet is not connected");
        } catch (IOException ioe) {
            labelinternet.setText("Internet is not connected");
      }
    } 
}
