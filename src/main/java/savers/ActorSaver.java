package savers;

import entities.Actor;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class ActorSaver {
    DocumentBuilderFactory documentFactory;
    DocumentBuilder documentBuilder;
    Document document;
    public ActorSaver() {
        try{
            documentFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = documentFactory.newDocumentBuilder();
            document = documentBuilder.newDocument();


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void saveActors(List<Actor> actors, String xmlFilePath){
        Element root = document.createElement("Actors");
        document.appendChild(root);
        actors.forEach(actor -> {
            Element xmlActor = document.createElement("actor");
            root.appendChild(xmlActor);
            Attr name = document.createAttribute("name");
            xmlActor.setAttribute("name", actor.getName());
            var plays = document.createElement("plays");
            actor.plays.forEach(play -> {
                var xmlPlay = document.createElement("play");
                xmlPlay.setAttribute("playName", play.title);
                plays.appendChild(xmlPlay);
            });
            xmlActor.appendChild(plays);
        });
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(xmlFilePath));

        try {
            transformer.transform(domSource, streamResult);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        System.out.println("Done creating XML File");

    }
}
