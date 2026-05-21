package com.betacom.process;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import com.betacom.interfaces.GeneralProcess;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReflectionManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		log.debug("Begin ReflectionManager");
		
		String pakageName = "com.betacom.objects";
		String className  = "MyClassReflection";
		
		Class cl = Class.forName(pakageName + "." + className);
		log.debug("class {} found",className);
			
		
		/*
		 * retrieve constructors from selected class
		 */
		Constructor selectedConstructor = null;
		int contructorToSelect = 2;
		Constructor[] ctore = cl.getConstructors();
		
		log.debug("numero di constructors trovate: {}", ctore.length);
		
		for (Constructor  ctore1:ctore) {
			/*
			 * search paramerti per ogni costructore
			 */
			log.debug(".... numeri di parametri trovato per contructor : {}", ctore1.getParameterCount());
			if (ctore1.getParameterCount() == contructorToSelect) {
				selectedConstructor = ctore1;
			}
			
			Type[] type = ctore1.getGenericParameterTypes();
			for (Type  t:type) {
				log.debug("........ Tipo parametro : {}", t);
			}
		}
		/*
		 * new instance
		 */
		Object myClass = null;
		if 	(contructorToSelect == 0) {
			myClass = selectedConstructor.newInstance();
			log.debug("new instance dell'object senza parametri");
		}
		if 	(contructorToSelect == 2) {
			myClass = selectedConstructor.newInstance(10, "due parametri");
			log.debug("new instance dell'object com 2 parametri (Integer, String)");
		}
		if 	(contructorToSelect == 3) {
			myClass = selectedConstructor.newInstance(30, "tre parametri", 500);
			log.debug("new instance dell'object com 3 parametri (Integer, String, integer)");
		}

		introMethods(myClass);
		
		
		return false;
	}
	
	
	private void introMethods (Object myClass) throws Exception{
		/*
		 * introspection methods
		 */
		Method[] methods = myClass.getClass().getMethods();
		for (Method method:methods) {
			log.debug(".......... nethod tovato {}", method.getName());
			if ("setId".equals(method.getName()))
				method.invoke(myClass, 10);
			if ("setDesc".equals(method.getName()))
				method.invoke(myClass, "desc caricato con refelction");
			if ("setP1".equals(method.getName()))
				method.invoke(myClass, 250);
		}
		String methodName = "toString";
		Method method = myClass.getClass().getMethod(methodName);
		String msg = (String)method.invoke(myClass);
		
		log.debug("ToString: {}" , msg);
		String par = "macchina";
		
	}

}
