package com.betacom.process;

import java.lang.reflect.Type;
import java.util.List;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.ObjectJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin JsonManager");
		
		ObjectJson usr = new ObjectJson("Giuseppe", "Verdi", true);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		/*
		 * Object to json
		 */
		String jsonString = gson.toJson(usr);
		System.out.println(jsonString);
		
		/*
		 * json to Object
		 */
		
		ObjectJson newUser = gson.fromJson(jsonString, ObjectJson.class);
		System.out.println("new Object json:" + newUser);
		
		
		List<ObjectJson> lU = List.of(
				new ObjectJson("Giuseppe", "Verdi", true),
				new ObjectJson("Paola", "Labella", false),
				new ObjectJson("Bruno", "Burba", true)	
				);
		
		jsonString = gson.toJson(lU);
		System.out.println("List:" + jsonString);
		
		Type type = new TypeToken<List<ObjectJson>>(){}.getType();  // retrieve object type (list<ObjectJson>
		List<ObjectJson> lU1 = gson.fromJson(jsonString, type);
		lU1.forEach(u -> System.out.println(u));
		
		return false;
	}

}
