package com.silanis.esl.sdk.examples;

import com.silanis.esl.sdk.CapturedSignature;
import com.silanis.esl.sdk.DocumentPackage;
import com.silanis.esl.sdk.DocumentType;
import com.silanis.esl.sdk.PackageId;

import static com.silanis.esl.sdk.builder.DocumentBuilder.newDocumentWithName;
import static com.silanis.esl.sdk.builder.PackageBuilder.newPackageNamed;
import static com.silanis.esl.sdk.builder.SignatureBuilder.captureFor;
import static com.silanis.esl.sdk.builder.SignatureBuilder.signatureFor;
import static com.silanis.esl.sdk.builder.SignerBuilder.newSignerWithEmail;

/**
 * Created by schoi on 12/7/15.
 */
public class SignDocumentsExample extends SDKSample {
    private String signer2Id = "5071de17-44ef-49ee-b21b-feab9fd34381";

    public DocumentPackage retrievedPackageBeforeSigning, retrievedPackageAfterSigningApproval1, retrievedPackageAfterSigningApproval2;

    public static void main(String... args) {
        new SignDocumentsExample().run();
    }

    public void execute() {
        CapturedSignature capturedSignature = new CapturedSignature("AQAAAIPGDPtxqL+RsL7/w/7eEX+cAtwAAwADAFAAAAADAAAAnALcACMAAAACq5ZQg105VH9Z/1l+UM9QF3A0v3BEv2BmYYFgSGAYQBZAJkA0QDVAREBmQENAQ0BRUJFQg1CDUFKbQENASUBGQERFUA==");
     /*   DocumentPackage superDuperPackage = newPackageNamed(getPackageName())
                .describedAs("This is a package created using OneSpan Sign SDK")
                .withSigner(newSignerWithEmail(email1)
                        .withCustomId(signer1Id)
                        .withFirstName("John1")
                        .withLastName("Smith1"))
                .withDocument(newDocumentWithName("First Document")
                        .fromStream(documentInputStream1, DocumentType.PDF)
                        .withSignature(captureFor(senderEmail)
                                .onPage(0)
                                .atPosition(100, 100))
                        .withSignature(signatureFor(email1)
                                .onPage(0)
                                .atPosition(400, 100)))
                .withDocument(newDocumentWithName("Second Document")
                        .fromStream(documentInputStream2, DocumentType.PDF)
                        .withSignature(signatureFor(senderEmail)
                                .onPage(0)
                                .atPosition(100, 100))
                        .withSignature(captureFor(email1)
                                .onPage(0)
                                .atPosition(400, 100)))
                .build();

        packageId = eslClient.createPackage(superDuperPackage);
        eslClient.sendPackage(packageId);
        retrievedPackageBeforeSigning = eslClient.getPackage(packageId);*/
        PackageId PK = new PackageId("RiQTWY14cUwsHkwuqk4HInuF6Y8=");

        eslClient.signDocuments(PK, capturedSignature);
        retrievedPackageAfterSigningApproval1 = eslClient.getPackage(PK);

        eslClient.signDocuments(PK, signer2Id, capturedSignature);
        //eslClient.signDocuments(packageId, signer2Id, capturedSignature);
        retrievedPackageAfterSigningApproval2 = eslClient.getPackage(PK);
    }
}
