package gov.hhs.ehrp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class StepListener implements StepExecutionListener{
	
	private static final Logger log = LoggerFactory.getLogger(StepListener.class);

	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info(stepExecution.getStepName() + "::" + stepExecution.getStatus());
		
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {

       //If any of the steps fail (ExitStatus.FAILED)
		if(stepExecution.getExitStatus().equals(ExitStatus.FAILED)){
			stepExecution.getJobExecution().setExitStatus(new ExitStatus(stepExecution.getExitStatus().getExitCode(),stepExecution.getExitStatus().getExitDescription()));
			log.info(stepExecution.getStepName() + "::" + stepExecution.getStatus() + "::" + stepExecution.getExitStatus());
		}
		else if(stepExecution.getExitStatus().equals(ExitStatus.COMPLETED)){
              log.info(stepExecution.getStepName() + "::" + stepExecution.getExitStatus());
		}
		return stepExecution.getExitStatus();
	}

}
