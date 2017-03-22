package Frame;

/**
 * Main method of the application
 */
public class BuilderApplication {
	
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuilderFrame().setVisible(true);
            }
        });
	}
}
