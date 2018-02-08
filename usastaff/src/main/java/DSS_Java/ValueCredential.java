package DSS_Java;

/**
Licensed Materials - Property of IBM

IBM Cognos Products: DOCS

(C) Copyright IBM Corp. 2008, 2009

US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
Schedule Contract with IBM Corp.
*/
/**
 * ValueCredential.java
 *
 * Copyright (C) 2008 Cognos ULC, an IBM Company. All rights reserved. Cognos
 * (R) is a trademark of Cognos ULC, (formerly Cognos Incorporated).
 *
 * Description: Used to display a fixed credential value
 */

import com.cognos.developer.schemas.ccs.auth.types._1.CredentialElementType;

public class ValueCredential extends ACredentialPrompt
{
	public ValueCredential(CredentialElementType cred)
	{
		super(cred);
	}

	/* (non-Javadoc)
	 * @see ACredentialPrompt#promptUser()
	 */
	@Override
	public void promptUser()
	{
		// Display the actual value to the user
		if (credential.getLabel() != null)
		{
			System.out.print(credential.getLabel());
			System.out.println(credential.getValue().getActualValue());
		}
	}
}
