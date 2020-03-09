package mainController;

import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.SimulationProcess;

public class MainClass {

	public static void main(String[] args) {

		View v = new View();

		View.btnSim.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				View.txMinArrival.setText("1");
				View.txMaxArrival.setText("3");
				View.txMinService.setText("5");
				View.txMaxService.setText("7");
				View.txNoQueues.setText("2");
				View.txSimInterval.setText("25");
				
				int minArrive=1;
				int maxArrive=3;
				int minService=5;
				int maxService=7;
				int nrQueues=2;
				int interval=25;
				
				SimulationProcess s = new SimulationProcess(minArrive, maxArrive,minService, maxService, nrQueues, interval);
				s.start();
			
			}
		});
		
		View.restart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e2) {

				View.txMinArrival.setText("");
				View.txMaxArrival.setText("");
				View.txMinService.setText("");
				View.txMaxService.setText("");
				View.txNoQueues.setText("");
				View.txSimInterval.setText("");
				View.timer.setText("");
				View.avgP.setText("");
				View.avgF.setText("");
				View.qq.setText("");
				View.simu.setText("");
			
			}
		});
	}
}
