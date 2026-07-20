package com.hasantuncay.mobsec.common.models.data.compliance

/**
 * HIPAA (Health Insurance Portability and Accountability Act) Data Model.
 * Based on the 18 specific identifiers that constitute Protected Health Information (PHI)
 * under the HIPAA Privacy Rule (45 CFR § 160.103).
 */
data class HipaaPhiData(
    /** The Medical Record Number (MRN) assigned to the patient by the provider. */
    val medicalRecordNumber: String = "MRN-2026-998877",
    /** Health plan beneficiary number used for insurance claims. */
    val healthPlanBeneficiaryNumber: String = "HPB-5544332211",
    /** ICD-10 diagnostic code representing a specific medical condition (e.g., Type 2 Diabetes). */
    val icd10DiagnosisCode: String = "E11.9",
    /** Raw HL7 (Health Level Seven) formatted message payload used in clinical data exchange. */
    val hl7ProcedurePayload: String = "MSH|^~\\&|EPIC|HOSPITAL|LAB...||ORU^R01|",
    /** Dates directly related to an individual (e.g., admission, discharge). */
    val admissionDate: String = "2026-07-21T09:00:00Z",
    /** Full-face photographic image, considered a direct PHI identifier. */
    val fullFacePhotographicImageUri: String = "content://com.hospital.provider/patients/998877/face.jpg"
)
