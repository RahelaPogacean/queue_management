package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import view.*;

public class SimulationProcess extends Thread {

	private  int minArrivalTime=1;
	private  int maxArrivalTime=3;
	private int minServiceTime=2;
	private int maxServiceTime=9;
	public static int noQueues=4;
	private static int simInterval=20;
	static ArrayList<Queue> q;
	public static int  currentTime;
	public final static int SEC=2000;
	
	public SimulationProcess(int minArrivalTime, int maxArrivalTime, int minServiceTime, 
			int maxServiceTime, int noQueues, int simInterval) {
		q = new ArrayList<Queue>(noQueues);
		this.minArrivalTime = minArrivalTime;
		this.maxArrivalTime = maxArrivalTime;
		this.minServiceTime = minServiceTime;
		this.maxServiceTime = maxServiceTime;//procesare
		this.noQueues = noQueues;
		this.simInterval = simInterval;
		
		for(int i=0; i<noQueues; i++) {
			Queue qe=new Queue(i);
			q.add(qe);
			q.get(i).start();//pornesc thread-ul coada
		}
	}
	private static int generateRandomTime(int minTime, int maxTime) {
	
		Random random = new Random();
		return random.nextInt(maxTime - minTime + 1) + minTime;
	}

	private int findMinIndex() {
		//aflu indexul cu timpul de asteptare minim, care casa este mai "libera", pt a pozitiona clientul acolo
		int idx = 0;
		int minim = q.get(0).queueLength();
		for (int i = 1; i < q.size(); i++) {
			int length = q.get(i).queueLength();
			if (length < minim) {
				minim = length;
				idx = i;
			}
		}
		return idx;
	}
	
	public String getListString() {
		String ss="";
		for(int i=0; i<noQueues; i++) {
			ss+=q.get(i).toString()+ "Timp coada "+q.get(i).getQID()+": "+ q.get(i).getTotalTime()+" \n";
		}
		return ss;
	}
		
	public void run() {
		
		currentTime = 0;//ora curenta
		int arrive, process;
		int sumFinish=0;//suma timpi finalizare
		int sumProc=0;//suma timpi procesare/servire
		int ctClients=0;//nr clienti
		View.qq.setText(getListString());
		
		while (currentTime < simInterval) {
			
			arrive=generateRandomTime(minArrivalTime, maxArrivalTime);
			process=generateRandomTime(minServiceTime, maxServiceTime);
			Client c = new Client(arrive, process);// constructor cu sosire si procesare
			c.setIDClient(ctClients);
			View.simu.append("\n CURRENT= "+ currentTime);
			View.simu.append("\nClientul "+ c.getIDClient()+" va SOSI in  "+ arrive +" secunde\n");
			
			try {
				for(int i=0; i<c.getArrivalTime();i++) {
					currentTime++;//simulez trecerea timpului, trecerea fiecarei secunde
					View.timer.setText(""+ currentTime);
					sleep(SEC);
				
				}
					} catch (InterruptedException e) {
				e.printStackTrace();
			}
			c.setWaitingTime(process);//timpul de asteptare al clientului, initializat cu timpProcesare
			c.setFinishingTime(currentTime+c.getProcessingTime());//finalizare=timpul curent+procesare
			int index = findMinIndex();
			q.get(index).addClient(c);//adaug clientul in coada pe pozitia libera
			q.get(index).getTotalTime().set(q.get(index).getTotalTime().get() + process);//actualizez timpul casei
			ctClients++;//actualizez nr clienti
			sumProc+=process;
			sumFinish+=c.getFinishingTime();
			
			View.qq.setText("");
			View.qq.setText(getListString());
			View.simu.append("\n CURRENT= "+ currentTime);
			View.simu.append(" \nClientul "+c.getIDClient() +
					" a fost ADAUGAT in coada "+ Integer.toString(index)+"\n" +"timp procesare client= "+ process+"=>iesire:"+ c.getFinishingTime()+"\n");
			}
		int avgFinish=sumFinish/ctClients;//timpul mediu de finalizare
		View.avgF.setText(avgFinish+ "");
		int avgProc=sumProc/ctClients;//timpul mediu de servire
		View.avgP.setText(avgProc+ "");
	}
	
	public int getMinArrivalTime() {
		return minArrivalTime;
	}

	public void setMinArrivalTime(int minArrivalTime) {
		this.minArrivalTime = minArrivalTime;
	}

	public int getMaxArrivalTime() {
		return maxArrivalTime;
	}

	public void setMaxArrivalTime(int maxArrivalTime) {
		this.maxArrivalTime = maxArrivalTime;
	}

	public int getMinServiceTime() {
		return minServiceTime;
	}

	public void setMinServiceTime(int minServiceTime) {
		this.minServiceTime = minServiceTime;
	}

	public int getMaxServiceTime() {
		return maxServiceTime;
	}

	public void setMaxServiceTime(int maxServiceTime) {
		this.maxServiceTime = maxServiceTime;
	}

	public int getNoQueues() {
		return noQueues;
	}

	public void setNoQueues(int noQueues) {
		this.noQueues = noQueues;
	}

	public int getSimInterval() {
		return simInterval;
	}

	public void setSimInterval(int simInterval) {
		this.simInterval = simInterval;
	}
	
	public ArrayList<Queue> getQ() {
		return q;
	}

	public void setQ(ArrayList<Queue> q) {
		this.q = q;
	}
	}
