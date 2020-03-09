package model;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import view.View;

public class Queue extends Thread {

	private int QID;//ID-ul fiecarei case
	BlockingQueue<Client> consumers=new ArrayBlockingQueue<Client>(100);
	private int processing;
	private int waiting;
	private int finishing;
	public AtomicInteger totalTime=new AtomicInteger(0);
	public final static int SEC=2000;
	
	public Queue(int QID) {
		setQID(QID);
	}
	
	public String toString() {
		String ss=" ";
		for(Client c: consumers) {
			ss+=c.toString()+" ";
		}
		return ss+"\n";
	}

	public void run() {
	
		while(true) {
			
			if(consumers.size()>0) {
	
			Client topClient=consumers.peek();
			processing=topClient.getProcessingTime();
			try {
				sleep(processing*SEC);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int wait=SimulationProcess.currentTime-topClient.getFinishingTime();
			View.simu.append("\n CURRENT= "+ SimulationProcess.currentTime);
			View.simu.append("\nClientul "+topClient.getIDClient() +
					"  a PLECAT din coada "+ QID+", a ASTEPTAT "+wait +" secunde");
			consumers.remove();
			totalTime.set(totalTime.get()-processing);//modific timpul casei
		}
	}
	}
	public int getQID() {
		return QID;
	}
	
	public void setQID(int qID) {
		QID = qID;
	}

	public void setConsumers(BlockingQueue<Client> consumers) {
		this.consumers = consumers;
	}

	public BlockingQueue<Client> getConsumers() {
		return consumers;
	}

	public int getProcessing() {
		return processing;
	}

	public void setProcessing(int processing) {
		this.processing = processing;
	}

	public int getWaiting() {
		return waiting;
	}

	public void setWaiting(int waiting) {
		this.waiting = waiting;
	}

	public int getFinishing() {
		return finishing;
	}

	public void setFinishing(int finishing) {
		this.finishing = finishing;
	}

	public AtomicInteger getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(AtomicInteger totalTime) {
		this.totalTime = totalTime;
	}
	
	public int queueLength() {
		return consumers.size();
	}
	
	public void addClient(Client c) {
		consumers.add(c);
	}
	
}