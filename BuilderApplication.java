package Frame;

import javax.swing.*;
import java.awt.*;

public class BuilderApplication {
	
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuilderFrame().setVisible(true);
            }
        });
	}
}
