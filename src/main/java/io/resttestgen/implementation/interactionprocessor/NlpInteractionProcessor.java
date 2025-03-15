package io.resttestgen.implementation.interactionprocessor;

import io.resttestgen.core.datatype.parameter.Parameter;
import io.resttestgen.core.datatype.parameter.leaves.StringParameter;
import io.resttestgen.core.datatype.rule.Rule;
import io.resttestgen.core.helper.RuleExtractorProxy;
import io.resttestgen.core.testing.InteractionProcessor;
import io.resttestgen.core.testing.TestInteraction;
import io.resttestgen.core.testing.TestStatus;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class NlpInteractionProcessor extends InteractionProcessor {

    private final HashSet<Rule> rulesFromServerMessage = new HashSet<>();
    private boolean process = true;

    @Override
    public boolean canProcess(TestInteraction testInteraction) {
        return process && testInteraction.getTestStatus() == TestStatus.EXECUTED &&
                testInteraction.getResponseStatusCode().getCode() == 400;
    }

    @Override
    public void process(TestInteraction testInteraction) {

        // If response body is JSON, get all string parameters and send them to NLPRestTest
        if (testInteraction.getFuzzedOperation().getResponseBody() != null) {
            for (Parameter parameter : testInteraction.getFuzzedOperation().getResponseBody().getAllParameters()) {
                if (parameter instanceof StringParameter

                && parameter.getName().toString().toLowerCase().contains("message")

                ) {
                    rulesFromServerMessage.addAll(RuleExtractorProxy.extractRulesFromServerMessage(testInteraction.getFuzzedOperation(), parameter.getValue().toString()));
                }
            }
        }

        if (!testInteraction.getResponseHeaders().toLowerCase().contains("content-type")) {
            rulesFromServerMessage.addAll(RuleExtractorProxy.extractRulesFromServerMessage(testInteraction.getFuzzedOperation(), testInteraction.getResponseBody()));
        }

        System.out.println("SERVER MESSAGE RULES: " + rulesFromServerMessage);
    }

    @NotNull
    public Set<Rule> getRulesAndReset() {
        Set<Rule> setToReturn = new HashSet<>(rulesFromServerMessage);
        rulesFromServerMessage.clear();
        return setToReturn;
    }

    public boolean isProcess() {
        return process;
    }

    public void setProcess(boolean process) {
        this.process = process;
    }
}
