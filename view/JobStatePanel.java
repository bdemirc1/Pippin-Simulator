package proj02.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import proj02.model.CPU;
import proj02.model.Job;
import proj02.model.Model;

public class JobStatePanel extends JPanel {

	
	private static final long serialVersionUID = -457860231679959091L;
	CPU cpu;
	JTextField state = new JTextField();
	

	public JobStatePanel(CPU cpu) {
		super(new GridLayout(1,1));
		this.cpu = cpu;
		add(new JLabel("Job State: ", JLabel.RIGHT));
		add(state);
		state.setEditable(false);
	}

	public void update(String arg1) {
		if(cpu.getCurrentJob().getCurrentState() == Job.State.PROGRAM_LOADED) {
			state.setBackground(Color.GREEN);
			state.setText("" + Job.State.PROGRAM_LOADED.toString());
		}else if(cpu.getCurrentJob().getCurrentState() == Job.State.PROGRAM_HALTED) {
			state.setBackground(Color.RED);
			state.setText("" + Job.State.PROGRAM_HALTED.toString());
		}else {
			state.setBackground(Color.WHITE);
			state.setText(""+ Job.State.NOTHING_LOADED.toString());
		}
		
	}

	public static void main(String[] args) {
		Model model = new Model();
		JobStatePanel panel = new JobStatePanel(model.getCpu());
		JFrame frame = new JFrame("TEST");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 60);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		frame.setVisible(true);
		panel.update("Testing");

	}

}
