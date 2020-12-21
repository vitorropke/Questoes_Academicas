package mars.mips.instructions.syscalls;
import mars.ProcessingException;
import mars.ProgramStatement;
import mars.mips.so.ProcessManager.*;
import mars.util.SystemIO;
import mars.mips.hardware.RegisterFile;
public class SyscallFork extends AbstractSyscall {

	public SyscallFork() {
		super(19, "SyscallFork");
	}

	@Override
	public void simulate(ProgramStatement statement) throws ProcessingException {
		createProcess();
	}
	
	public void createProcess() { 
		ProcessControlBlock contexto = new ProcessControlBlock(); 
		
		contexto.copyRegistersToPCB();
		
		ProcessTable.newProcess(new ProcessControlBlock
				(RegisterFile.getUserRegister("$a0").getValue(), 
						RegisterFile.getUserRegister("$a1").getValue(), 
						RegisterFile.getUserRegister("$v1").getValue(), contexto.getContexto()));
		SystemIO.printString("Processo adicionado com sucesso: " + 
		RegisterFile.getUserRegister("$a0").getValue() +"\n");
		
	}
}