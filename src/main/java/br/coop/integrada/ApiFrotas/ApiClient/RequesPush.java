package br.coop.integrada.ApiFrotas.ApiClient;

import java.util.List;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import javax.xml.parsers.DocumentBuilder;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.springframework.stereotype.Service;
import org.apache.http.client.methods.HttpPost;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import javax.xml.parsers.ParserConfigurationException;

@Service
public class RequesPush {
	public List<EventoXml> getPlates(){
		List<EventoXml> lista = new ArrayList<>();
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			StringEntity params =new StringEntity("<AfterTime><picTime>-1</picTime></AfterTime>"); //serve como uma chave de acesso
			
			HttpPost httpPost = new HttpPost("http://usuario:senha@192.168.1.10/ISAPI/Traffic/channels/1/vehicleDetect/plates");//usuario - senha - ipcamera - caminho padrão
			httpPost.addHeader("content-type", "text/xml");
			httpPost.setEntity(params);
			
			HttpResponse httpResponse = httpClient.execute(httpPost);					
			HttpEntity httpEntity = httpResponse.getEntity();
			String xml = EntityUtils.toString(httpEntity);	
	
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new InputSource(new StringReader(xml)));
			
			Element elemento = doc.getDocumentElement();
			NodeList nodeList = elemento.getElementsByTagName("Plate");	
			
			for( int i=0; i<nodeList.getLength(); i++ ) {
			    Element tagEvento = (Element) nodeList.item( i );
			    EventoXml veiculo = new EventoXml(xml, xml, xml, xml, xml, xml, xml);
			    veiculo.setCaptureTime(getChildTagValue(tagEvento, "captureTime"));
			    veiculo.setPlateNumber(getChildTagValue(tagEvento, "plateNumber"));
			    veiculo.setPicName(getChildTagValue(tagEvento, "picName"));
			    veiculo.setCountry(getChildTagValue(tagEvento, "country"));
			    veiculo.setLaneNo(getChildTagValue(tagEvento, "laneNo"));
			    veiculo.setDirection(getChildTagValue(tagEvento, "direction"));
			    veiculo.setMatchingResult(getChildTagValue(tagEvento, "matchingResult")); 
				
			    lista.add(veiculo); 
			}
		    
		}catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	private static String getChildTagValue( Element elem, String tagName ) throws Exception {
        NodeList children = elem.getElementsByTagName( tagName );
        if( children == null ) return null;
        Element child = (Element) children.item(0);
        if( child == null ) return null;
        return child.getFirstChild().getNodeValue();
    }
    
    public static Document stringToDom(String xmlSource) throws SAXException, ParserConfigurationException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new InputSource(new StringReader(xmlSource)));
    } 
}
