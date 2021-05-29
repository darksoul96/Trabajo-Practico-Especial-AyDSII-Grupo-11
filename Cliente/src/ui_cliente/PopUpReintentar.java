package ui_cliente;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ProgressMonitor;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.WindowConstants;


public class PopUpReintentar {

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
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                new BackgroundWorker().execute();

            }
            
        });
		
    }

    public class BackgroundWorker extends SwingWorker<Void, Void> {

        private ProgressMonitor monitor;

        public BackgroundWorker() {
            addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if ("progress".equalsIgnoreCase(evt.getPropertyName())) {
                        if (monitor == null) {
                            monitor = new ProgressMonitor(null, "Reintentando...", null, 0, 99);
                        }
                        monitor.setProgress(getProgress());
                    }
                }
            });
        }

        @Override
        protected void done() {
            if (monitor != null) {
                monitor.close();
            }
        }

        @Override
        protected Void doInBackground() throws Exception {
            for (int index = 0; index < 100; index++) {
                setProgress(index);
                Thread.sleep(125);
            }
            return null;
        }
    }

}
