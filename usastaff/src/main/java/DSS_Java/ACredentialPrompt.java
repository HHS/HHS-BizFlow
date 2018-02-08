package DSS_Java;

/**
Licensed Materials - Property of IBM

IBM Cognos Products: DOCS

(C) Copyright IBM Corp. 2008, 2009

US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
Schedule Contract with IBM Corp.
*/
/**
 * ACredentialPrompt.java
 *
 * Copyright (C) 2008 Cognos ULC, an IBM Company. All rights reserved.
 * Cognos (R) is a trademark of Cognos ULC, (formerly Cognos Incorporated).
 *
 * Description: Abstract base class for prompting for credentials
 */

import com.cognos.developer.schemas.ccs.auth.types._1.CredentialElementType;

public abstract class ACredentialPrompt
{
	/**
	 * The associated credential element
	 */
	protected CredentialElementType credential;

	public ACredentialPrompt(CredentialElementType cred)
	{
		credential = cred;
	}

	/**
	 * Gets the associated credential element
	 *
	 * @return	The credental element
	 */
	public CredentialElementType getCredential()
	{
		return credential;
	}

	/**
	 * Prompts the user, and replaces the Missing Value with
	 * an Actual Value provided by the user.
	 */
	public abstract void promptUser();
}
