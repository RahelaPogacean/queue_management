package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.Client;
import model.SimulationProcess;

public class View{
	
	public static JFrame frame;
	public static JTextField txMinArrival;
	public static JTextField txMaxArrival;
	public static JTextField txMinService;
	public static JTextField txMaxService;
	public static JTextField txNoQueues;
	public static JTextField txSimInterval;
	public static JTextField timer;
	public static JTextField avgP;
	public static JTextField avgF;;
	public static JTextArea qq;
	public static JTextArea simu;
	public static JButton btnSim, restart;
	
	public View() {
		
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(1400, 900));
		
		btnSim = new JButton("Start  Simulation");
		btnSim.setBackground(Color.LIGHT_GRAY);
		btnSim.setForeground(Color.RED);
		btnSim.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnSim.setBounds(100, 380, 200, 50);
		
		restart = new JButton("RESTART");
		restart.setBackground(Color.LIGHT_GRAY);
		restart.setForeground(Color.RED);
		restart.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		restart.setBounds(840, 50, 200, 50);
		
		JLabel lTime = new JLabel("Timer ");
		lTime.setBounds(340, 10, 200, 120);
		lTime.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		
		JLabel label = new JLabel("Arriving Time");
		label.setBounds(70, 90, 200, 120);
		label.setFont(new Font("Times New Roman", Font.BOLD, 17));
	
		JLabel label1 = new JLabel("Service Time");
		label1.setBounds(70, 90, 200, 240);
		label1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		JLabel label2 = new JLabel("Number of Queues");
		label2.setBounds(70, 90, 200, 360);
		label2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		JLabel 	label3 = new JLabel("Simulation Interval");
		label3.setBounds(70, 90, 200, 480);
		label3.setFont(new Font("Times New Roman", Font.BOLD, 17));

		JLabel ev = new JLabel("QUEUE  EVOLUTION");
		ev.setBounds(470, 400, 400, 300);
		ev.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		JLabel ss = new JLabel("SIMULATION  RESULTS");
		ss.setBounds(850, 400, 400, 300);
		ss.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		JLabel avgProc = new JLabel("Media timpilor de procesare");
		avgProc.setBounds(100, 420, 200, 100);
		avgProc.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel avgFin = new JLabel("Media timpilor de finalizare");
		avgFin.setBounds(100, 480, 200, 100);
		avgFin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txMinArrival = new JTextField(20);
		txMinArrival.setBounds(250, 130, 50, 30);
		txMinArrival.setColumns(10);

		txMaxArrival = new JTextField(20);
		txMaxArrival.setBounds(320, 130, 50, 30);
		txMaxArrival.setColumns(20);

		txMinService = new JTextField(20);
		txMinService.setBounds(250, 190, 50, 30);
		txMinService.setColumns(10);
		
		txMaxService = new JTextField(20);
		txMaxService.setBounds(320, 190, 50, 30);
		txMaxService.setColumns(10);
	
		txNoQueues = new JTextField(20);
		txNoQueues.setBounds(250, 250, 50, 30);
		txNoQueues.setColumns(10);
		
		txSimInterval = new JTextField(20);
		txSimInterval.setBounds(250, 310, 50, 30);
		txSimInterval.setColumns(10);
		
		timer=new JTextField();
		timer.setBounds(450, 50, 200, 50);
		timer.setColumns(10);
		
		avgP = new JTextField(20);
		avgP.setBounds(100, 480, 200, 30);
		avgP.setColumns(10);
		
		avgF = new JTextField(20);
		avgF.setBounds(100, 540, 200, 30);
		avgF.setColumns(10);
		
		qq=new JTextArea();//queue evolution
		Font font=new Font("Serif", Font.PLAIN, 15);
		qq.setBackground(new Color(153, 0, 77));
		qq.setFont(font);
		qq.setForeground(Color.WHITE);
		
		JScrollPane scrollPane = new JScrollPane(qq);
		scrollPane.setBounds(400, 130, 350, 400);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setVisible(true);
		
		simu=new JTextArea();//simulation results
		simu.setBackground(new Color(153, 0, 77));
		simu.setFont(font);
		simu.setForeground(Color.WHITE);
		
		JScrollPane scrollPane1 = new JScrollPane(simu);
		scrollPane1.setBounds(780, 130, 350, 400);
		scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane1.setVisible(true);
	
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(btnSim);
		panel.add(restart);
		panel.add(lTime);
		panel.add(label);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(ev);
		panel.add(ss);
		panel.add(avgProc);
		panel.add(avgFin);
		
		panel.add(txMinArrival);
		panel.add(txMaxArrival);
		panel.add(txMinService); 
		panel.add(txMaxService);
		panel.add(txNoQueues);
		panel.add(txSimInterval);
		panel.add(timer);
		panel.add(avgP);
		panel.add(avgF);
		panel.add(scrollPane);
		panel.add(scrollPane1);
		panel.setBounds(100,95, 1200, 700);
		
		 ImageIcon icon=new ImageIcon("back.jpg");
		 JLabel img=new JLabel(icon);
		 img.add(panel);
		 frame.setContentPane(img);	
		 frame.setVisible(true);
		
	}

	}

