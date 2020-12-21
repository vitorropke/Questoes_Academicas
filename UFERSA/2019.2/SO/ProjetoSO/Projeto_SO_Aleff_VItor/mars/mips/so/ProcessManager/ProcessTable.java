package mars.mips.so.ProcessManager;

import java.util.ArrayList;
import java.util.List;

import mars.mips.hardware.RegisterFile;
import mars.mips.so.ProcessManager.ProcessControlBlock;

public class ProcessTable {
	public static String typeScheduler = "FIFO";
	
	private static ProcessControlBlock running; 
	
	private static List<ProcessControlBlock> processListReady = 
			new ArrayList<ProcessControlBlock>();
	
	public static void processChange(String metodo) {
		if(running != null) {
			System.out.println("Salvando o contexto do processo que estava executando\n");
			
			running.setStateProcess("ready"); 
			running.setInitAdress(RegisterFile.getProgramCounter());
			running.getContexto().clear();
			
			running.copyRegistersToPCB();  
		}
				
		if(metodo.equals("FIFO")) { 
			System.out.println("Endereço que estou: " + RegisterFile.getProgramCounter());
			
			if(Schedule.fifo()) {
				RegisterFile.setProgramCounter(running.getInitAdress());
				
				System.out.println("Indo para: " + RegisterFile.getProgramCounter());
				running.pcbToRegister();
			}
		}
		else if (metodo.equals("Fixa")) {
			if(Schedule.fixedPriority()) {
				for(int i = 0;  i < running.getContexto().size(); i++) {
					RegisterFile.updateRegister(i, running.getContexto().get(i));
				}
			}
			if(running != null) {
				RegisterFile.setProgramCounter(running.getInitAdress());
			}
		}
		
		else if (metodo.equals("Loteria")) {	
			if(Schedule.lottery()) {
				for(int i = 0;  i < running.getContexto().size(); i++) {
					RegisterFile.updateRegister(i, running.getContexto().get(i));
				}
			}
			if(running != null) {
				RegisterFile.setProgramCounter(running.getInitAdress());
			}
		}
	}
	
	public static String getTypeScheduler() {
		return typeScheduler;
	}

	public static void setTypeScheduler(String x) {
		ProcessTable.typeScheduler = x;
	}
	
	public ProcessTable(ProcessControlBlock process) {
		ProcessTable.running = process; 
	}
	
	public static ProcessControlBlock getRunning() {
		return running;
	}

	public static void setRunning(ProcessControlBlock running) {
		ProcessTable.running = running;
	}

	public static List<ProcessControlBlock> getProcessListReady() {
		return processListReady;
	}
	public static void setProcessListReady(List<ProcessControlBlock> processListReady) {
		ProcessTable.processListReady = processListReady;
	} 
	
	public static void newProcess(ProcessControlBlock process) {
		processListReady.add(process);
	}

	public static void endProcess(String metodo) {
		running = null;
		processChange(metodo);
	}
	
}