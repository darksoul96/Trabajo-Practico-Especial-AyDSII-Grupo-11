package ui_cliente;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;


public class PopUpReintentar extends JDialog{

	private String messageReintento="Reintentando.";
	/**
	 * Create the application.
	 */
	public PopUpReintentar() {
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();// size of the screen
	    setLocation(scrSize.width/2 - 112, scrSize.height/2 -60);

	    setSize(225,120);
	    setLayout(null);
	    setUndecorated(true);
	    setLayout(new GridBagLayout());



	    JLabel lblMensaje = new JLabel(messageReintento);
	    Font font= new Font("Arial", Font.PLAIN,25);
	    lblMensaje.setFont(font);
	    lblMensaje.setAlignmentX(40);
	    lblMensaje.setAlignmentY(30);
	    
	    add(lblMensaje);
	    setVisible(true);
	    /*try {
	    	setVisible(true);
			TimeUnit.SECONDS.sleep(5);
			dispose();
		} catch (InterruptedException e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	    
	    
	    
	    /*
	    for (int i=0;i<5;i++) {
	    	try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	lblMensaje.setText("Reintentando..");
	    	try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	lblMensaje.setText("Reintentando...");
	    	try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	lblMensaje.setText("Reintentando.");
	    }
	    */
	    
	    
	    
	    
	    /*new Thread(){
	          @Override
	          public void run() {
	               try {
	            	   for (int i=0;i<5;i++) {
	            		   Thread.sleep(200);
	            		   lblMensaje.setText("Reintentando..");
		            	   Thread.sleep(200);
		            	   lblMensaje.setText("Reintentando...");
		            	   Thread.sleep(200);
		            	   lblMensaje.setText("Reintentando.");
	            	   }
	            	   Thread.sleep(4);
	            	   
	            	   dispose();
	               } catch (InterruptedException e) {
	                      e.printStackTrace();
	               }
	          };
	    }.start();
	    */
	}

}
