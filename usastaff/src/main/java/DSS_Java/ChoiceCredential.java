package DSS_Java;

/**
Licensed Materials - Property of IBM

IBM Cognos Products: DOCS

(C) Copyright IBM Corp. 2008, 2009

US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
Schedule Contract with IBM Corp.
*/
/**
 * ChoiceCredential.java
 *
 * Copyright (C) 2008 Cognos ULC, an IBM Company. All rights reserved. Cognos
 * (R) is a trademark of Cognos ULC, (formerly Cognos Incorporated).
 *
 * Description: Used to prompt the user when the credential has an enumeration of
 * 				allowed values
 */
import java.util.Scanner;

import com.cognos.developer.schemas.ccs.auth.types._1.CredentialElementType;
import com.cognos.developer.schemas.ccs.auth.types._1.EnumerationType;
import com.cognos.developer.schemas.ccs.auth.types._1.ValueElementType;

public class ChoiceCredential extends ACredentialPrompt
{
	public ChoiceCredential(CredentialElementType cred)
	{
		super(cred);
	}

	/* (non-Javadoc)
	 * @see ACredentialPrompt#promptUser()
	 */
	public void promptUser()
	{
		try
		{
			System.out.print("Please select a value for ");
			System.out.println(credential.getLabel());

			// Display the list of possible choices with a number
			EnumerationType[] enums = credential.getValue().getMissingValue().getEnumeration();
			for (int i = 0; i < enums.length; i++)
			{
				System.out.print(i + 1);
				System.out.print(") ");
				System.out.println(enums[i].getLabel());
			}

			// Read the number associated with the users choice
			Scanner reader = new Scanner(System.in);
			int val = reader.nextInt();
			if (val > enums.length || val < 1)
				throw new NumberFormatException();

			// Replace the missing value with the actual value
			ValueElementType value = new ValueElementType();
			value.setActualValue(enums[val - 1].getValue());
			credential.setValue(value);
		}
		catch (NumberFormatException e)
		{
			System.out.println("That selection is not valid");
			promptUser();
		}
	}
}
