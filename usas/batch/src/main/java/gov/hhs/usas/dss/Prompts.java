package gov.hhs.usas.dss;

import com.cognos.developer.schemas.rds.types._2.PValueArrayItem;
import com.cognos.developer.schemas.rds.types._2.PromptValue;
import com.cognos.developer.schemas.rds.types._2.RangePValue;
import com.cognos.developer.schemas.rds.types._2.SimplePValue;

public class Prompts {

	public PromptValue buildSimpleValuePrompt(String promptName, String useVal, String displayVal) {
        PromptValue pv = new PromptValue();
        pv.setName(promptName);
        SimplePValue spv = new SimplePValue();
        spv.setDisplayValue(displayVal);
        spv.setUseValue(useVal);
        spv.setInclusive(true);
        PValueArrayItem[] pvi = new PValueArrayItem[1];
        pvi[0] = new PValueArrayItem();
        pvi[0].setSimplePValue(spv);
        pv.setValues(pvi);
		return pv;
	}
	
	public PromptValue buildRangeValuePrompt(String promptName, String useVal1, String useVal2, String displayVal1, String displayVal2) {
        PromptValue pv = new PromptValue();
        pv.setName(promptName);
        RangePValue rpv = new RangePValue();
        SimplePValue spvStart = new SimplePValue();
        spvStart.setDisplayValue(displayVal1);
        spvStart.setUseValue(useVal1);
        SimplePValue spvEnd = new SimplePValue();
        spvEnd.setDisplayValue(displayVal2);
        spvEnd.setUseValue(useVal2);
        rpv.setStart(spvStart);
        rpv.setEnd(spvEnd);
        rpv.setInclusive(true);
        PValueArrayItem[] pvi = new PValueArrayItem[1];
        pvi[0] = new PValueArrayItem();
        pvi[0].setRangePValue(rpv);
        pv.setValues(pvi);
		return pv;
	}	
	
}
