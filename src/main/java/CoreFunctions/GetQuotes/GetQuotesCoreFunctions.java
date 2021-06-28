package CoreFunctions.GetQuotes;

import CoreFunctions.GetQuotes.triggers.GetQuotesFunctions;
import CoreFunctions.GetQuotes.triggers.impl.GetQuotesFunctionsImpl;

public class GetQuotesCoreFunctions {
    public GetQuotesFunctions getQuotesFunctions(){
        return new GetQuotesFunctionsImpl();
    }
}
