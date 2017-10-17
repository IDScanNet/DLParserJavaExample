package net.idscan.dlparserexample;

import net.idscan.dlparser.DLParser;
import net.idscan.dlparser.DLParser.DLResult;
import net.idscan.dlparser.DLParser.DLParserException;

import java.io.UnsupportedEncodingException;

public class Main {

    private static final String _KEY = "***License key***";
    private static final String test_data = "%MNBURNSVILLE^HOMER J. SYMPSON^13225 MADRID RD^?\n\n;636038326007403611=12091991090106?\n\n%\" 55306      D               F064124   HZL                           X\"+H)     ?";

    public static void main(String[] args) {
        DLParser parser = new DLParser();
        try {
            System.out.println(parser.getVersion());

            // Setup parser.
            parser.setup(_KEY);
            // Parse the data.
            DLResult res = parser.parse(test_data.getBytes("UTF8"));

            System.out.println("Full name: " + res.fullName);
            System.out.println("First name: " + res.firstName);
            System.out.println("Middle name: " + res.middleName);
            System.out.println("Last name: " + res.lastName);
            System.out.println("Name suffix: " + res.nameSuffix);
            System.out.println("Name prefix: " + res.namePrefix);
            System.out.println("Document type: " + res.documentType);
            System.out.println("Country code: " + res.countryCode);
            System.out.println("Country: " + res.country);
            System.out.println("Jurisdiction code: " + res.jurisdictionCode);
            System.out.println("IIN: " + res.iin);
            System.out.println("Address1: " + res.address1);
            System.out.println("Address2: " + res.address2);
            System.out.println("City: " + res.city);
            System.out.println("License number: " + res.licenseNumber);
            System.out.println("Classification code: " + res.classificationCode);
            System.out.println("Restriction code: " + res.restrictionCode);
            System.out.println("Restriction code description: " + res.restrictionCodeDescription);
            System.out.println("Endorsements code: " + res.endorsementsCode);
            System.out.println("Endorsement code description: " + res.endorsementCodeDescription);
            System.out.println("Expiration date: " + res.expirationDate);
            System.out.println("HAZMATExpDate: " + res.HAZMATExpDate);
            System.out.println("Birthdate: " + res.birthdate);
            System.out.println("Card revision date: " + res.cardRevisionDate);
            System.out.println("Gender: " + res.gender);
            System.out.println("Issue date: " + res.issueDate);
            System.out.println("Issue by: " + res.issuedBy);
            System.out.println("Postal code: " + res.postalCode);
            System.out.println("Eye color: " + res.eyeColor);
            System.out.println("Race: " + res.race);
            System.out.println("Hair color: " + res.hairColor);
            System.out.println("Height: " + res.height);
            System.out.println("WeightKG: " + res.weightKG);
            System.out.println("WeightLBS: " + res.weightLBS);
            System.out.println("Compliance type: " + res.complianceType);

            if (res.isLimitedDurationDocument == DLResult.FLAG_TRUE)
                System.out.println("Limited duration document: " + "yes");
            else if (res.isLimitedDurationDocument == DLResult.FLAG_FALSE)
                System.out.println("Limited duration document: " + "no");
            else
                System.out.println("Limited duration document: " + "undefined");

            if (res.isOrganDonor == DLResult.FLAG_TRUE)
                System.out.println("Organ donor: " + "yes");
            else if (res.isOrganDonor == DLResult.FLAG_FALSE)
                System.out.println("Organ donor: " + "no");
            else
                System.out.println("Organ donor: " + "undefined");

            if (res.isVeteran == DLResult.FLAG_TRUE)
                System.out.println("Veteran: " + "yes");
            else if (res.isVeteran == DLResult.FLAG_FALSE)
                System.out.println("Veteran: " + "no");
            else
                System.out.println("Veteran: " + "undefined");

            System.out.println("Vehicle class code: " + res.vehicleClassCode);
            System.out.println("Vehicle class code description: " + res.vehicleClassCodeDescription);

        } catch (DLParserException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
