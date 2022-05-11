package edu.miracostacollege.cs112.ic15_nobelpeaceprize.controller;

import edu.miracostacollege.cs112.ic15_nobelpeaceprize.model.Model;
import edu.miracostacollege.cs112.ic15_nobelpeaceprize.model.NobelLaureate;
import javafx.collections.ObservableList;

/**
 * The <code>Controller</code> is a Singleton object that relays all commands between the Model and View
 * (and vice versa).  There is only one Controller object, accessible by a call to the static getInstance()
 * method.
 *
 * @author Michael Paulding
 * @version 1.0
 */
public class Controller {
	// Singleton pattern = one object
	// Abstract classes = no object
	// 1. Class variable w/ same data type as the class
	// 2. Make a private constructor so no one else can make controller object
	// 3. Make a public method called getInstance
	// 		a. if instance is null, create object
	// 		b. else return theInstance
	private static Controller theInstance;
	private ObservableList<NobelLaureate> mAllLaureatesList;

	// Assigns new ram for the object, no initialization
	// no one else can use it
	private Controller() {
		// Fill allLaureates list w data from the model
	}
	/**
	 * Gets the one instance of the Controller.
	 * @return The instance
	 */
	public static Controller getInstance() {
		// if instance is null, create object, otherwise return theInstance
		if (theInstance == null) {
			theInstance = new Controller();
			if (Model.binaryFileHasData())
				theInstance.mAllLaureatesList = Model.populateListFromBinaryFile();
			else
				theInstance.mAllLaureatesList = Model.populateListFromCSVFile();
		}
		return theInstance;
	}

	/**
	 * Gets the list of all laureates.
	 * @return The list of all laureates.
	 */
	public ObservableList<NobelLaureate> getAllLaureates() {
		return mAllLaureatesList;
	}

	/**
	 * Makes a request for the model to save all the laureates data (the list of all laureates) to
	 * a persistent binary file.
	 */
	public void saveData() {
		Model.writeDataToBinaryFile(mAllLaureatesList);
	}
}
