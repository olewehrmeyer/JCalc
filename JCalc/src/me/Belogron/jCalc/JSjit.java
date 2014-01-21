package me.Belogron.jCalc;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JSjit {

	ScriptEngineManager manager;
	ScriptEngine engine;

	public JSjit() {
		manager = new ScriptEngineManager();
		engine = manager.getEngineByName("JavaScript");
		engine.put("result", 0);
		engine.put("ans", 0);
	}

	public Object calculate(String input) throws ScriptException {

		engine.eval("result = " + input);
		Object result = engine.get("result");
		engine.put("ans", result);
		return result;

	}
}
