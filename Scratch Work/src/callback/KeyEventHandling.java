package callback;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class KeyEventHandling extends KeyAdapter{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KeyEventHandling window = new KeyEventHandling();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KeyEventHandling() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.out.println("Key Pressed: " + e.getKeyChar());
				if( e.getKeyCode() == KeyEvent.VK_ESCAPE ) {
					System.out.println("Pressed Esc key");
				}
				
			}
		});
		Component[] components = 
		frame.getContentPane().getComponents();
		System.out.println(components.length);
		for ( Object item : components ) {
			System.out.println(item.toString());
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[]", "[][]"));
		
		JButton btnNewButton = new JButton("New button");
		frame.getContentPane().add(btnNewButton, "cell 0 0");
		
		JLabel lblNewLabel = new JLabel("New label");
		frame.getContentPane().add(lblNewLabel, "cell 0 1");
	}
	
	public void keyPressed(KeyEvent e) {
		System.out.println("Key Pressed: " + e.getKeyChar());
		if( e.getKeyCode() == KeyEvent.VK_ESCAPE ) {
			System.out.println("Pressed Esc key");
		}
	}

}
