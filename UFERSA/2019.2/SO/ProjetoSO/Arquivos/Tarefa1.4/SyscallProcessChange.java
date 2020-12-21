package mars.mips.instructions.syscalls;

import mars.ProcessingException;
import mars.ProgramStatement;
import mars.mips.so.ProcessManager.ProcessTable;
import mars.util.SystemIO;

/* swap process that running in the cpu */
public class SyscallProcessChange extends AbstractSyscall{

	public SyscallProcessChange() {
		super(20, "SyscallProcessChange");
	}

	@Override
	public void simulate(ProgramStatement statement) throws ProcessingException {
		
		ProcessTable.processChange(ProcessTable.getTypeScheduler());
		SystemIO.printString("Processo Escalonado!\n");
	}
	
}