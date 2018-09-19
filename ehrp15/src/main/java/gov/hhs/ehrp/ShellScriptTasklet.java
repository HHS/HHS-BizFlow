package gov.hhs.ehrp;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShellScriptTasklet implements Tasklet {

	private static final Logger log = LoggerFactory.getLogger(ShellScriptTasklet.class);
	
	@Autowired
	private Properties properties;
	
	@SuppressWarnings("finally")
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
	
		try {
			
			//Check to see if file directories exist, if not create folders
			EHRPFileUtil.checkInterfaceDirectories(new File(properties.getInboundDir()), new File(properties.getProcessingDir()), new File(properties.getArchiveDir()), new File(properties.getErrorDir()));

			EHRPFileUtil cmd = new EHRPFileUtil();
			cmd.executeShellScript(properties.getEhrpScriptName(), properties.getEhrpScriptPath());

		}catch (Exception e) {
			log.info(e.getMessage() + "::" + e.getCause());
			contribution.setExitStatus(new ExitStatus(ExitStatus.FAILED.getExitCode(),e.getMessage()));
			chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put(properties.getEhrpScriptName(), e.getMessage() + "::" + e.getCause());
		}finally{
			return RepeatStatus.FINISHED;
		}
	}
}
