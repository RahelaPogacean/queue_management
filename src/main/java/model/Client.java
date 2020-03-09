package model;

public class Client {
	
	private int IDClient;
	private int arrivalTime;
	private int waitingTime;
	private int processingTime;//sau serviceTime
	private int finishingTime;
	
	public Client() {
		
	}
	
	public  String toString() {
		return ("c" + getIDClient()+"  ");
	}
	
	public Client(int arrivalTime, int processingTime) {
		this.arrivalTime=arrivalTime;
		this.processingTime=processingTime;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}

	public int getProcessingTime() {
		return processingTime;
	}

	public void setProcessingTime(int processingTime) {
		this.processingTime = processingTime;
	}

	public int getFinishingTime() {
		return finishingTime;
	}

	public void setFinishingTime(int finishingTime) {
		this.finishingTime = finishingTime;
	}

	public int getIDClient() {
		return IDClient;
	}

	public void setIDClient(int iDClient) {
		IDClient = iDClient;
	}

}
