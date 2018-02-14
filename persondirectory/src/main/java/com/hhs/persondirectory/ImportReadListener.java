package com.hhs.persondirectory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.stereotype.Component;

@Component
public class ImportReadListener  implements ItemReadListener<HHSEmployee>{

	private static final Logger log = LoggerFactory.getLogger(ImportReadListener.class);

	@Override
	public void beforeRead() {
	}

	@Override
	public void afterRead(HHSEmployee item) {
		if(item != null)
			log.debug("Read 1 employee record");
		else
			log.debug("Read 0 employee record");

	}

	@Override
	public void onReadError(Exception ex) {
		log.error("Error occured while reading employee record:: " + ex);

	}



}
