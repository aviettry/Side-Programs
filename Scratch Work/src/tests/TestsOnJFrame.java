package tests;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class TestsOnJFrame extends ComponentAdapter {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestsOnJFrame window = new TestsOnJFrame();
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
	public TestsOnJFrame() {
		initialize();
//		init2();
	}

	@SuppressWarnings("unused")
	private void init2() {
		frame = new JFrame("Scanning Fingerprint");
		frame.getContentPane().setLayout(
		    new MigLayout("", "[grow,center]", "[grow,center][grow,center]"));
		frame.setBounds(0, 0, 1000, 2000);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLabel updating = new JLabel("SCANNING");
		updating.setFont(
		    new Font("Times New Roman", Font.PLAIN, frame.getWidth() / 10));
		frame.getContentPane().add(updating, "cell 0 0, alignx center, growy");

		JLabel waiting = new JLabel("PRESS FIRMLY");
		waiting.setFont(
		    new Font("Times New Roman", Font.PLAIN, frame.getWidth() / 10));
		frame.getContentPane().add(waiting, "cell 0 1, alignx center, growy");

		frame.addComponentListener(new ComponentAdapter() {
			public void componentMoved(ComponentEvent e) {
				updating.setFont(new Font("Times New Roman", Font.PLAIN,
				    frame.getWidth() / 10));
				waiting.setFont(new Font("Times New Roman", Font.PLAIN,
				    frame.getWidth() / 10));
			}
		});
		frame.setAlwaysOnTop(true);
		frame.pack();
	}

	String text = "Line 1\nLine 2\nLine 3\nLine 4";
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JPanel datePanel = new JPanel();
		datePanel.setLayout(new MigLayout("", "[][][]", "[][][]"));
		JLabel messageLabel = new JLabel("Period Start Date");
		datePanel.add(messageLabel, "cell 0 0 3 0,alignx center");

		JTextField monthField = new JTextField();
		datePanel.add(monthField, "cell 0 2, center");
		monthField.setColumns(2);
		JTextField dayField = new JTextField();
		datePanel.add(dayField, "cell 1 2, center");
		dayField.setColumns(2);
		JTextField yearField = new JTextField();
		datePanel.add(yearField, "cell 2 2, center");
		yearField.setColumns(4);
		
		JLabel monthLabel = new JLabel("MM");
		JLabel dayLabel = new JLabel("DD");
		JLabel yearLabel = new JLabel("YYYY");
		datePanel.add(monthLabel, "cell 0 1, center");
		datePanel.add(dayLabel, "cell 1 1, center");
		datePanel.add(yearLabel, "cell 2 1, center");
		
		
	}

}
