package CoreComponents.Cucumber;

import CoreComponents.managers.CoreFunctionsManager;

public class TestContext {
    private CoreFunctionsManager coreFunctionsManager;

    public TestContext(){
        coreFunctionsManager = new CoreFunctionsManager();
    }
    public CoreFunctionsManager getCoreFunctionsManager(){
        return coreFunctionsManager;
    }
}
