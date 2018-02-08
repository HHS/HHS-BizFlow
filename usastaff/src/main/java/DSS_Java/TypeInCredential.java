package DSS_Java;

/**
Licensed Materials - Property of IBM

IBM Cognos Products: DOCS

(C) Copyright IBM Corp. 2008, 2009

US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
Schedule Contract with IBM Corp.
*/
/**
 * TypeInCredential.java
 *
 * Copyright (C) 2008 Cognos ULC, an IBM Company. All rights reserved. Cognos
 * (R) is a trademark of Cognos ULC, (formerly Cognos Incorporated).
 *
 * Description: Used to prompt the user when the credential may contain any value
 */
import java.util.Scanner;

import com.cognos.developer.schemas.ccs.auth.types._1.CredentialElementType;
import com.cognos.developer.schemas.ccs.auth.types._1.ValueElementType;

public class TypeInCredential extends ACredentialPrompt
{
	public TypeInCredential(CredentialElementType cred)
	{
		super(cred);
	}

	/* (non-Javadoc)
	 * @see ACredentialPrompt#promptUser()
	 */
	@Override
	public void promptUser()
	{
		// Prompt the user to type in a value
		System.out.print("Please type a value for ");
		System.out.println(credential.getLabel());

		// Read the value
		Scanner scan = new Scanner(System.in);
		String value = scan.nextLine();
		scan.close();

		// Replace the missing value with the actual value
		ValueElementType val = new ValueElementType();
		val.setActualValue(value);
		credential.setValue(val);
	}

}
