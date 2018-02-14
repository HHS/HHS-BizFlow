package com.hhs.persondirectory;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

@Component
public class ImportWriteListener implements ItemWriteListener<MemberStg>{

	private static final Logger log = LoggerFactory.getLogger(ImportWriteListener.class);

	@Override
	public void beforeWrite(List<? extends MemberStg> items) {		
	}

	@Override
	public void afterWrite(List<? extends MemberStg> items) {
		
		if(items.size()==1)
			log.debug(""+ items.size() +" item written to MemberStg");
		else
			log.debug(""+ items.size() +" items written to MemberStg");
	}

	@Override
	public void onWriteError(Exception exception, List<? extends MemberStg> items) {
		log.error("Error occured while writing record to MemberStg:: " +exception);

	}

}
