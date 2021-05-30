package ui_empleado;

import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ProgressMonitor;
import javax.swing.SwingWorker;
import javax.swing.UIManager;


public class ProgressReintentarEmpleado {

	private String messageReintento="Reintentando.";
	/**
	 * Create the application.
	 */
	public ProgressReintentarEmpleado() {
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
