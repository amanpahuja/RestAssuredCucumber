package CoreComponents.Cucumber;

import CoreComponents.managers.CoreScenarioManager;
import io.cucumber.java.hu.Ha;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private CoreScenarioManager coreScenarioManager;
    private Map<String, Object> scenarioContext;
    public ScenarioContext(){
        scenarioContext = new HashMap<String, Object>();
        coreScenarioManager = new CoreScenarioManager();
    }
    public CoreScenarioManager getCoreScenarioManager(){
        return coreScenarioManager;
    }
}
