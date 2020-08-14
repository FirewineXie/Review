package com.study.server.basic;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: XmlTest01
 * @Create : 2020/1/12
 * @Description :
 */
public class XmlTest01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {


        //SAX 解析
        //1. 获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2. 从解析工厂获取解析器
        SAXParser parse = factory.newSAXParser();
        //3. 加载文档Document 注册处理器
        PHandler handler = new PHandler();
        parse.parse(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/study/server/basic/p.xml"),handler);
        //4. 编写处理器


    }
}
class  PHandler  extends DefaultHandler{

    @Override
    public void startDocument() throws SAXException {
        System.out.println("开始解析文档");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName +"---->");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length);
        if (contents.length() > 0) {
            System.out.println("内容为----》"+ contents);
        }else {
            System.out.println("内容为---》"+ "空");
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        System.out.println(qName +"------>");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("解析文档结束");
    }
}
