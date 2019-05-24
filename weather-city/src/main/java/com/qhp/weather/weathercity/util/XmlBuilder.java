package com.qhp.weather.weathercity.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

public class XmlBuilder {

    public static Object xmlStrToObject(Class<?> clazz ,String xmlStr) throws Exception{
        Object objXml = null;
        Reader reader=null;
        JAXBContext context =  JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller =  context.createUnmarshaller();
        reader = new StringReader(xmlStr);
        objXml = unmarshaller.unmarshal(reader);
        if (null != reader){
            reader.close();
        }
        return objXml;
    }
}
