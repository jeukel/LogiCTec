package edu.itcr.logictec.save;

/*
 * Librerias de entrada/salida, parseadors de xml, estructuradores.
 */


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Toxml {
	int exits;
	int[] array;
	
	public Toxml(int[] parray){
		this.exits = 0;
		this.array = parray;		
	}
	
	public void save() throws IOException {

	      try {

	        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

	        // root elements
	        Document doc = docBuilder.newDocument();
	        Element rootElement = doc.createElement("Component");
	        doc.appendChild(rootElement);

	        // Tree of one exit
	        Element tree = doc.createElement("ExitTree");
	        rootElement.appendChild(tree);

	        // number of exit on component
	        Attr attr = doc.createAttribute("exit");
	        attr.setValue(Integer.toString(exits));
	        tree.setAttributeNode(attr);

	        // Tree 
	        for (int i = 0 ; i < this.array.length; i++){
	        	Element node = doc.createElement("node");
		        node.appendChild(doc.createTextNode(Integer.toString(array[i])));
		        tree.appendChild(node);
	        }
	        

	        // write the content into xml file
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult(new File("NewComponent.xml"));
	        System.out.println(source);

	        transformer.transform(source, result);

	        System.out.println("File saved!");

	      } catch (ParserConfigurationException pce) {
	        pce.printStackTrace();
	      } catch (TransformerException tfe) {
	        tfe.printStackTrace();
	      }
	}
}
