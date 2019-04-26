package edu.hbuas.Control;

import edu.hbuas.Model.javaBean.Book;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class xmlUnit {
    /**
     * 查询所有书本
     * @return xml文件中所有书本的集合
     */
    public static List<Book> xmlParse(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        List<Book> list = new ArrayList<>();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("/Users/zxg/Downloads/test/test.xml");
            NodeList books = document.getElementsByTagName("books");
            for (int i=0;i<books.getLength();i++){
                Node book = books.item(i);
                //解析books的子节点
                NodeList childNodes = book.getChildNodes();
                //循环book
                for (int j = 0; j < childNodes.getLength(); j++) {
                    String[] ar = new String[8];
                    if (childNodes.item(j).getNodeType()==Node.ELEMENT_NODE){
                        Node node = childNodes.item(j);
                        NodeList childNodes1 = node.getChildNodes();
                        //循环book下的节点
                        int x = 0;
                        for (int k = 0; k < childNodes1.getLength(); k++) {
                            if (childNodes1.item(k).getNodeType()==Node.ELEMENT_NODE){
                                if(childNodes1.item(k).hasChildNodes()){
                                    String value = childNodes1.item(k).getFirstChild().getNodeValue();
                                    ar[x] = value;
                                    x++;
                                }
                            }
                        }
                        Book b = new Book(Integer.parseInt(ar[0]), ar[1], ar[2], ar[3], ar[4], ar[5], ar[6], ar[7]);
                        list.add(b);
//                        System.out.println(b);
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 添加书本
     * @param b 要添加的书本
     */
    public static void pushBook(Book b){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
            Document document = db.parse("/Users/zxg/Downloads/test/test.xml");
            Node books = document.getElementsByTagName("books").item(0);
            Element book = document.createElement("book");
            Element bookid = document.createElement("bookid");
            bookid.setTextContent(b.getBookid()+"");
            book.appendChild(bookid);

            Element bookname = document.createElement("bookname");
            bookname.setTextContent(b.getBookname());
            book.appendChild(bookname);

            Element auth = document.createElement("auth");
            auth.setTextContent(b.getAuth());
            book.appendChild(auth);

            Element bookpublic = document.createElement("bookpublic");
            bookpublic.setTextContent(b.getBookpublic());
            book.appendChild(bookpublic);

            Element bookclass = document.createElement("bookclass");
            bookclass.setTextContent(b.getBookclass());
            book.appendChild(bookclass);

            Element loantime = document.createElement("loantime");
            loantime.setTextContent(b.getLoantime());
            book.appendChild(loantime);

            Element returntime = document.createElement("returntime");
            returntime.setTextContent(b.getEturntime());
            book.appendChild(returntime);

            Element status = document.createElement("status");
            status.setTextContent(b.getStatus());
            book.appendChild(status);

            books.appendChild(book);

            // 把xml内容输出到具体的文件中
            TransformerFactory formerFactory=TransformerFactory.newInstance();
            Transformer transformer=formerFactory.newTransformer();
            // 换行
            transformer.setOutputProperty(OutputKeys.INDENT, "YES");
            // 文档字符编码
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");

            // 可随意指定文件的后缀,效果一样,但xml比较好解析,比如: E:\\person.txt等
            transformer.transform(new DOMSource(document),new StreamResult("/Users/zxg/Downloads/test/test.xml"));

            System.out.println("添加成功:"+bookname.getNodeValue());


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除全部
     */
    public static void deleteAll(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
            Document document = db.parse("/Users/zxg/Downloads/test/test.xml");
            NodeList books = document.getElementsByTagName("book");
            int x = books.getLength();
            for (int i = 0; i < x; i++) {
                Node node = books.item(0);
                node.getParentNode().removeChild(node);
            }
            System.out.println("删除成功!");

            // 把xml内容输出到具体的文件中
            TransformerFactory formerFactory=TransformerFactory.newInstance();
            Transformer transformer=formerFactory.newTransformer();
            // 换行
            transformer.setOutputProperty(OutputKeys.INDENT, "YES");
            // 文档字符编码
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");

            // 可随意指定文件的后缀,效果一样,但xml比较好解析,比如: E:\\person.txt等
            transformer.transform(new DOMSource(document),new StreamResult("/Users/zxg/Downloads/test/test.xml"));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }


    /**
     * 根据id修改数据
     * @param b 传入一个修改后的book
     */
    public static void updateById(Book b){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
            Document document = db.parse("/Users/zxg/Downloads/test/test.xml");
            NodeList books = document.getElementsByTagName("book");
            int x = books.getLength();
            System.out.println(x);
            for (int i = 0; i < x; i++) {
                Node node = books.item(i);
                String id = node.getChildNodes().item(1).getTextContent();
//                System.out.println(id);
//                System.out.println("书的id:"+b.getBookid());
//                System.out.println(id.equals(b.getBookid()+""));
                if (id.equals(b.getBookid()+"")){
                    System.out.println(id);
                    node.getChildNodes().item(3).setTextContent(b.getBookname());
                    node.getChildNodes().item(5).setTextContent(b.getAuth());
                    node.getChildNodes().item(7).setTextContent(b.getBookpublic());
                    node.getChildNodes().item(9).setTextContent(b.getBookclass());
                    node.getChildNodes().item(11).setTextContent(b.getLoantime());
                    node.getChildNodes().item(13).setTextContent(b.getEturntime());
                    node.getChildNodes().item(15).setTextContent(b.getStatus());
                }
                System.out.println();
            }

            // 把xml内容输出到具体的文件中
            TransformerFactory formerFactory=TransformerFactory.newInstance();
            Transformer transformer=formerFactory.newTransformer();
            // 换行
            transformer.setOutputProperty(OutputKeys.INDENT, "YES");
            // 文档字符编码
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");

            // 可随意指定文件的后缀,效果一样,但xml比较好解析,比如: E:\\person.txt等
            transformer.transform(new DOMSource(document),new StreamResult("/Users/zxg/Downloads/test/test.xml"));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
