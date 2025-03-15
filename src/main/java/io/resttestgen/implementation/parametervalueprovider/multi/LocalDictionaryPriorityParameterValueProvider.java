package io.resttestgen.implementation.parametervalueprovider.multi;

import io.resttestgen.core.Environment;
import io.resttestgen.core.datatype.parameter.leaves.LeafParameter;
import io.resttestgen.core.dictionary.Dictionary;
import io.resttestgen.core.testing.parametervalueprovider.ParameterValueProvider;
import io.resttestgen.core.testing.parametervalueprovider.ParameterValueProviderCachedFactory;
import io.resttestgen.core.testing.parametervalueprovider.ValueNotAvailableException;
import io.resttestgen.implementation.parametervalueprovider.ParameterValueProviderType;
import io.resttestgen.implementation.parametervalueprovider.single.*;
import kotlin.Pair;

/**
 * This parameter value provider prioritize the usage of values available in the local dictionary
 */
@SuppressWarnings("unused")
public class LocalDictionaryPriorityParameterValueProvider extends ParameterValueProvider {

    private Dictionary localDictionary;

    @Override
    public Pair<ParameterValueProvider, Object> provideValueFor(LeafParameter leafParameter) throws ValueNotAvailableException {

        // If local dictionary is available
        if (localDictionary != null) {

            // Try to get value from normalized dictionary
            ResponseDictionaryParameterValueProvider localDictionaryProvider = (ResponseDictionaryParameterValueProvider) ParameterValueProviderCachedFactory.getParameterValueProvider(ParameterValueProviderType.RESPONSE_DICTIONARY);
            localDictionaryProvider.setDictionary(localDictionary);
            localDictionaryProvider.setStrict(this.strict);
            if (localDictionaryProvider.countAvailableValuesFor(leafParameter) > 0) {
                return localDictionaryProvider.provideValueFor(leafParameter);
            }
        }

        // If local dictionary is not available, try other strategies (e.g., enum, example, default)
        EnumParameterValueProvider enumProvider = (EnumParameterValueProvider) ParameterValueProviderCachedFactory.getParameterValueProvider(ParameterValueProviderType.ENUM);
        enumProvider.setStrict(this.strict);
        if (enumProvider.countAvailableValuesFor(leafParameter) > 0) {
            return enumProvider.provideValueFor(leafParameter);
        }
        ExamplesParameterValueProvider examplesProvider = (ExamplesParameterValueProvider) ParameterValueProviderCachedFactory.getParameterValueProvider(ParameterValueProviderType.EXAMPLES);
        examplesProvider.setStrict(this.strict);
        if (examplesProvider.countAvailableValuesFor(leafParameter) > 0) {
            return examplesProvider.provideValueFor(leafParameter);
        }
        DefaultParameterValueProvider defaultProvider = (DefaultParameterValueProvider) ParameterValueProviderCachedFactory.getParameterValueProvider(ParameterValueProviderType.DEFAULT);
        defaultProvider.setStrict(this.strict);
        if (defaultProvider.countAvailableValuesFor(leafParameter) > 0) {
            return defaultProvider.provideValueFor(leafParameter);
        }

        // If no other value is available, randomly generate it
        ParameterValueProvider randomProvider = Environment.getInstance().getRandom().nextBoolean() ?
                ParameterValueProviderCachedFactory.getParameterValueProvider(ParameterValueProviderType.RANDOM) :
                ParameterValueProviderCachedFactory.getParameterValueProvider(ParameterValueProviderType.NARROW_RANDOM);
        randomProvider.setStrict(this.strict);
        return randomProvider.provideValueFor(leafParameter);
    }

    /**
     * Set the local dictionary to use.
     * @param localDictionary the local dictionary to use.
     */
    public void setLocalDictionary(Dictionary localDictionary) {
        this.localDictionary = localDictionary;
    }
}
