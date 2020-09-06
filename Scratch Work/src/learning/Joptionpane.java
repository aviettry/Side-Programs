package learning;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Joptionpane {

	public static void main(String[] args) {
		// Creating drop-down lists.
		JComboBox<Integer> hourBox = new JComboBox<>();
		for (int i = 0; i < 12; i++) {
			hourBox.addItem(i + 1);
		}

		JComboBox<String> minuteBox = new JComboBox<>();
		minuteBox.addItem("00");
		minuteBox.addItem("05");
		for (int i = 10; i < 60; i += 5) {
			minuteBox.addItem("" + i);
		}

		String[] clockTime = { "AM", "PM" };
		JComboBox<String> clock = new JComboBox<>(clockTime);

		// Setup JPanel to display JOptionPane with three drop-down lists.
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("", "[grow]", "[][]"));
		JLabel lblStartDateFor = new JLabel("Reservation time:");
		panel.add(lblStartDateFor, "cell 0 0,alignx center");
		panel.add(hourBox, "flowx,cell 0 1, alignx center");
		panel.add(minuteBox, "flowx,cell 0 1,alignx center");
		panel.add(clock, "flowx,cell 0 1,alignx center");

		// Prompt user to select the period start time.
		int ret = JOptionPane.showOptionDialog(null, panel, "ADMIN PANEL",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null,
				null);
		System.out.println(ret);
	}

}
