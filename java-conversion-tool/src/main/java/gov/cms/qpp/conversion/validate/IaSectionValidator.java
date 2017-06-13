package gov.cms.qpp.conversion.validate;

import gov.cms.qpp.conversion.model.Node;
import gov.cms.qpp.conversion.model.TemplateId;
import gov.cms.qpp.conversion.model.Validator;

import java.util.List;

/**
 * Validates Improvement Activity Section Node - expects at least one Improvement Activity Measure
 */
@Validator(value = TemplateId.IA_SECTION, required = true)
public class IaSectionValidator extends NodeValidator {

	protected static final String MINIMUM_REQUIREMENT_ERROR = "The IA Section must have at least one IA Measure";
	protected static final String MINIMUM_REPORTING_PARAM_REQUIREMENT_ERROR
			= "The IA Section must have a only one Reporting Parameter ACT";
	protected static final String WRONG_CHILD_ERROR =
			"The IA Section must contain only measures and reporting parameter";

	/**
	 * Validates a single IA Section node to ensure at least one Improvement Activity Measure exists
	 *
	 * @param node The node to validate.
	 */
	@Override
	protected void internalValidateSingleNode(Node node) {
		check(node)
				.childMinimum(MINIMUM_REQUIREMENT_ERROR, 1, TemplateId.IA_MEASURE)
				.childMinimum(MINIMUM_REPORTING_PARAM_REQUIREMENT_ERROR, 1,
						TemplateId.REPORTING_PARAMETERS_ACT)
				.childMaximum(MINIMUM_REPORTING_PARAM_REQUIREMENT_ERROR, 1,
						TemplateId.REPORTING_PARAMETERS_ACT)
				.onlyHasChildren(WRONG_CHILD_ERROR, TemplateId.IA_MEASURE, TemplateId.REPORTING_PARAMETERS_ACT);
	}

	/**
	 * Checks the interdependency of nodes in the parsed tree.
	 * IA Section has no dependencies on other nodes in the document.
	 *
	 * @param nodes The list of nodes to validate.
	 */
	@Override
	protected void internalValidateSameTemplateIdNodes(List<Node> nodes) {
		// No current cross node IA section validations
	}
}
