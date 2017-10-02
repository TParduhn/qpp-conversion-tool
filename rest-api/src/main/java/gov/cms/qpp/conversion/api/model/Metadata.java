package gov.cms.qpp.conversion.api.model;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGenerateStrategy;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedTimestamp;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DoNotEncrypt;
import com.google.common.base.Objects;

import java.util.Date;

/**
 * Model to hold conversion metadata. Maps to a table in DynamoDB.
 */
@DynamoDBTable(tableName = "ConversionMetadata")
public final class Metadata {
	private String uuid;
	private String tin;
	private String npi;
	private Date createdDate;
	private String apm;
	private long submissionYear;
	private String submissionLocator;
	private String fileName;
	private boolean overallStatus;
	private boolean conversionStatus;
	private boolean validationStatus;
	private boolean cpc;
	private String conversionErrorLocator;
	private String validationErrorLocator;


	/**
	 * The UUID that uniquely identifies this item.
	 *
	 * @return The UUID.
	 */
	@DynamoDBHashKey(attributeName = "Uuid")
	@DynamoDBAutoGeneratedKey
	public String getUuid() {
		return uuid;
	}

	/**
	 * There is no reason to set this manually because it is automatically generated when saved to DynamoDB.
	 *
	 * @param uuid The UUID to use.
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * The date and time when this item was created.
	 *
	 * @return The date and time.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "CreateDate")
	@DynamoDBAutoGeneratedTimestamp(strategy = DynamoDBAutoGenerateStrategy.CREATE)
	public Date getCreatedDate() {
		return new Date(createdDate.getTime());
	}

	/**
	 * There is no reason to set this manually because it is automatically generated when saved to DynamoDB.
	 *
	 * @param createdDate The date and time to use.
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = new Date(createdDate.getTime());
	}

	/**
	 * The TIN associated with the the conversion.
	 *
	 * @return The TIN.
	 */
	@DynamoDBAttribute(attributeName = "Tin")
	public String getTin() {
		return tin;
	}

	/**
	 * Sets the TIN associated with the the conversion.
	 *
	 * @param tin The TIN to use.
	 */
	public void setTin(String tin) {
		this.tin = tin;
	}

	/**
	 * The NPI associated with the the conversion.
	 *
	 * @return The NPI.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "Npi")
	public String getNpi() {
		return npi;
	}

	/**
	 * Sets the NPI associated with the the conversion
	 *
	 * @param npi The NPI to use.
	 */
	public void setNpi(String npi) {
		this.npi = npi;
	}

	/**
	 * The APM Entity ID associated with the the conversion. Used with CPC+.
	 *
	 * @return The APM Entity ID.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "Apm")
	public String getApm() {
		return apm;
	}

	/**
	 * Sets the the APM Entity ID associated with the the conversion. Used with CPC+.
	 *
	 * @param apm The APM Entity ID.
	 */
	public void setApm(String apm) {
		this.apm = apm;
	}

	/**
	 * The submission year associated with the the conversion.
	 *
	 * @return The submission year.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "SubmissionYear")
	public long getSubmissionYear() {
		return submissionYear;
	}

	/**
	 * Sets the submission year associated with the the conversion
	 *
	 * @param submissionYear The submission year to use.
	 */
	public void setSubmissionYear(long submissionYear) {
		this.submissionYear = submissionYear;
	}

	/**
	 * A location to where the submitted file can be found.
	 *
	 * For example, for AWS, this could be an ARN.
	 *
	 * @return The location.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "SubmissionLocator")
	public String getSubmissionLocator() {
		return submissionLocator;
	}

	/**
	 * Sets a location to where the submitted file can be found.
	 *
	 * @param submissionLocator The location to use.
	 */
	public void setSubmissionLocator(String submissionLocator) {
		this.submissionLocator = submissionLocator;
	}

	/**
	 * The file name of the file uploaded to the converter.
	 *
	 * @return The file name.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "FileName")
	public String getFileName() {
		return fileName;
	}

	/**
	 * Sets the file name of the file uploaded to the converter.
	 *
	 * @param fileName The file name to use.
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * The success or failure of the conversion and the submission validation.
	 *
	 * @return Success or failure.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "OverallStatus")
	public boolean isOverallStatus() {
		return overallStatus;
	}

	/**
	 * Sets the overall status of the conversion and submission validation.
	 *
	 * @param overallStatus The overall status to use.
	 */
	public void setOverallStatus(boolean overallStatus) {
		this.overallStatus = overallStatus;
	}

	/**
	 * The success or failure of only the conversion.
	 *
	 * @return Success or failure.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "ConversionStatus")
	public boolean isConversionStatus() {
		return conversionStatus;
	}

	/**
	 * Sets the conversion status.
	 *
	 * @param conversionStatus The conversion status to use.
	 */
	public void setConversionStatus(boolean conversionStatus) {
		this.conversionStatus = conversionStatus;
	}

	/**
	 * The success or failure of only the submission validation.
	 *
	 * @return Success or failure.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "ValidationStatus")
	public boolean isValidationStatus() {
		return validationStatus;
	}

	/**
	 * Sets the submission validation status.
	 *
	 * @param validationStatus The validation status to use.
	 */
	public void setValidationStatus(boolean validationStatus) {
		this.validationStatus = validationStatus;
	}

	/**
	 * Whether the conversion was for the CPC+ program.
	 *
	 * @return True for a CPC+ conversion, false otherwise.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "Cpc")
	public boolean isCpc() {
		return cpc;
	}

	/**
	 * Sets whether the conversion was for the CPC+ program.
	 *
	 * @param cpc A CPC+ conversion or not.
	 */
	public void setCpc(boolean cpc) {
		this.cpc = cpc;
	}

	/**
	 * A location to where the conversion error JSON can be found.
	 *
	 * For example, for AWS, this could be an ARN.
	 *
	 * @return The location.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "ConversionErrorLocator")
	public String getConversionErrorLocator() {
		return conversionErrorLocator;
	}

	/**
	 * Sets a location to where the conversion error JSON can be found.
	 *
	 * @param conversionErrorLocator A location.
	 */
	public void setConversionErrorLocator(String conversionErrorLocator) {
		this.conversionErrorLocator = conversionErrorLocator;
	}

	/**
	 * A location to where the submission validation error JSON can be found.
	 *
	 * For example, for AWS, this could be an ARN.
	 *
	 * @return The location.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "ValidationErrorLocator")
	public String getValidationErrorLocator() {
		return validationErrorLocator;
	}

	/**
	 * Sets a location to where the submission validation error JSON can be found.
	 *
	 * @param validationErrorLocator A location.
	 */
	public void setValidationErrorLocator(String validationErrorLocator) {
		this.validationErrorLocator = validationErrorLocator;
	}

	/**
	 * Determines the equality between this object and another.
	 *
	 * @param o The other object.
	 * @return True if equal, false if not equal.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Metadata)) {
			return false;
		}
		Metadata metadata = (Metadata) o;

		boolean weGood = submissionYear == metadata.submissionYear
				&& overallStatus == metadata.overallStatus
				&& conversionStatus == metadata.conversionStatus;
		weGood = weGood && validationStatus == metadata.validationStatus
				&& cpc == metadata.cpc;
		weGood = weGood && Objects.equal(uuid, metadata.uuid)
				&& Objects.equal(tin, metadata.tin);
		weGood = weGood && Objects.equal(npi, metadata.npi)
				&& Objects.equal(createdDate, metadata.createdDate);
		weGood = weGood && Objects.equal(apm, metadata.apm)
				&& Objects.equal(submissionLocator, metadata.submissionLocator);
		weGood = weGood && Objects.equal(fileName, metadata.fileName)
				&& Objects.equal(conversionErrorLocator, metadata.conversionErrorLocator);
		return weGood && Objects.equal(validationErrorLocator, metadata.validationErrorLocator);
	}

	/**
	 * Computes and returns the hash code for this object.
	 * @return The hash code.
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(uuid, tin, npi, createdDate, apm, submissionYear,
				submissionLocator, fileName, overallStatus, conversionStatus, validationStatus,
				cpc, conversionErrorLocator, validationErrorLocator);
	}
}
