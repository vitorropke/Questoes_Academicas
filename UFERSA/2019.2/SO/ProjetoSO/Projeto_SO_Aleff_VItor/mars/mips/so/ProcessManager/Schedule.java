package mars.mips.so.ProcessManager;

import java.util.Collections;
import java.util.Random;
import mars.mips.so.ProcessManager.ProcessTable;

public class Schedule {
	
	public static boolean fifo() {
		if(ProcessTable.getRunning() != null) { 
			ProcessTable.getProcessListReady().add(ProcessTable.getRunning());  
		}
		if(ProcessTable.getProcessListReady().size() > 0) {
			ProcessTable.getProcessListReady().get(0).setStateProcess("running"); 
			ProcessTable.setRunning(ProcessTable.getProcessListReady().remove(0)); 
			System.out.println("Processo Setado como Executando: " + 
			ProcessTable.getRunning().getInitAdress());
			return true;
		}
		return false;
	}
	
	public static boolean fixedPriority() {
		if(ProcessTable.getRunning() != null) {
			ProcessTable.getProcessListReady().add(ProcessTable.getRunning()); 
		}
		if(ProcessTable.getProcessListReady().size() > 0) {
			Collections.sort(ProcessTable.getProcessListReady()); 
			ProcessTable.getProcessListReady().get(0).setStateProcess("running"); 
			ProcessTable.setRunning(ProcessTable.getProcessListReady().remove(0)); 
			
			System.out.println("Processo Setado como Executando Prioridade Fixa: " + 
			ProcessTable.getRunning().getInitAdress());
			return true;
		}
		return false;
	}
	
	public static boolean lottery() {
		if(ProcessTable.getRunning() != null) {
			ProcessTable.getProcessListReady().add(ProcessTable.getRunning()); 
		}
		
		if(ProcessTable.getProcessListReady().size() > 0) {
			Random r = new Random();
			
			int element = r.nextInt(ProcessTable.getProcessListReady().size());
						
			ProcessTable.getProcessListReady().get(0).setStateProcess("running"); 
			ProcessTable.setRunning(ProcessTable.getProcessListReady().remove(element)); 
			System.out.println("Processo Setado como Executando Loteria: " + 
			ProcessTable.getRunning().getInitAdress());
			
			return true;
		}
		return false;
	}
}