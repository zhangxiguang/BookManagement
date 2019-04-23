package edu.hbuas.Control;

import edu.hbuas.Model.Dao.bookDao;
import edu.hbuas.Model.Dao.bookDaoImp;
import edu.hbuas.Model.javaBean.Book;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "bookServlet",urlPatterns = "/bookServlet")
public class bookServlet extends HttpServlet {
    private bookDao bookDao;
    private static final long serialVersionUID = 1L;
    private String uploadPath = "/Users/zxg/Downloads/test"; // 上传文件的目录
    private String tempPath = "/Users/zxg/Downloads/test"; // 临时文件目录
    File tempPathFile;


    @Override
    public void init() throws ServletException {
        bookDao=new bookDaoImp();
        File uploadFile = new File(uploadPath);
        if (!uploadFile.exists()) {
            uploadFile.mkdirs();
        }else {
            System.out.println("文件已存在！111");
        }
        File tempPathFile = new File(tempPath);
        if (!tempPathFile.exists()) {
            tempPathFile.mkdirs();
        }else {
            System.out.println("文件已存在！222");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        String  method = request.getParameter("method");
        switch (method) {
            case "addBook": {
                addBook(request, response);
                break;
            }
            case "upxml": {
                upxml(request, response);
                break;
            }
            case "delBook1": {
                delBook1(request, response);
                break;
            }
            case "delBook2": {
                delBook2(request, response);
                break;
            }
        }
    }

    protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入添加图书");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");

        String bookname=request.getParameter("bookname");
        String bookauth=request.getParameter("bookauth");
        String bookpublic=request.getParameter("bookpublic");
        String bookclass=request.getParameter("bookclass");


        boolean result=bookDao.addBook(bookname,bookauth,bookpublic,bookclass);

        System.out.println(result);

        if (result){
            System.out.println("添加图书成功");
        }else {
            System.out.println("添加图书失败");
        }
    }

    protected void upxml(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入上传xml文件");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");

        try {
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Set factory constraints
            factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb
            factory.setRepository(tempPathFile);// 设置缓冲区目录

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // Set overall request size constraint
            upload.setSizeMax(4194304); // 设置最大文件尺寸，这里是4MB

            List<FileItem> items = upload.parseRequest(request);// 得到所有的文件

            Iterator<FileItem> i = items.iterator();

            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                String fileName = fi.getName();

                if (fileName != null) {
                    File fullFile = new File(fi.getName());
                    System.out.println(fullFile.getName());
                    File savedFile = new File(uploadPath, "test.xml");
                    fi.write(savedFile);

                    //存储完前端传来的文件，开始DOM解析xml文件

                    //创建book对象
                    Book books=new Book();


                    //创建一个DocumentBuilderFactory的对象
                    DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();


                    try {
                        //创建DocumentBuilder对象
                        DocumentBuilder db = dbf.newDocumentBuilder();
                        //通过DocumentBuilder对象的parser方法加载books.xml文件到当前项目下
                        Document document = db.parse("/Users/zxg/Downloads/test/test.xml");
                        //获取所有book节点的集合
                        NodeList bookList = document.getElementsByTagName("book");
                        //通过nodelist的getLength()方法可以获取bookList的长度
                        System.out.println("一共有" + bookList.getLength() + "本书");
                        //遍历每一个book节点
                        for (int m = 0; m < bookList.getLength(); m++) {
                            System.out.println("=================下面开始遍历第" + (m + 1) + "本书的内容=================");
                            //通过 item(i)方法 获取一个book节点，nodelist的索引值从0开始
                            Node book = bookList.item(m);
                            //获取book节点的所有属性集合
                            NamedNodeMap attrs = book.getAttributes();
                            System.out.println("第 " + (m + 1) + "本书共有" + attrs.getLength() + "个属性");
                            //遍历book的属性
                            for (int j = 0; j < attrs.getLength(); j++) {
                                //通过item(index)方法获取book节点的某一个属性
                                Node attr = attrs.item(j);
                                //获取属性名
                                System.out.print("属性名：" + attr.getNodeName());
                                //获取属性值
                                System.out.println("--属性值" + attr.getNodeValue());
                            }
                            //解析book节点的子节点
                            NodeList childNodes = book.getChildNodes();
                            //遍历childNodes获取每个节点的节点名和节点值
                            System.out.println("第" + (m+1) + "本书共有" +
                                    childNodes.getLength() + "个子节点");
                            for (int k = 0; k < childNodes.getLength(); k++) {
                                //区分出text类型的node以及element类型的node
                                if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
                                    //获取了element类型节点的节点名
                                    System.out.print("第" + (k + 1) + "个节点的节点名："
                                            + childNodes.item(k).getNodeName());
                                    //获取了element类型节点的节点值
                                    System.out.println("--节点值是：" + childNodes.item(k).getFirstChild().getNodeValue());
                                    //System.out.println("--节点值是：" + childNodes.item(k).getTextContent());

                                    if(k==1){
                                        books.setBookname(childNodes.item(k).getFirstChild().getNodeValue());
                                    }else if(k==3){
                                        books.setAuth(childNodes.item(k).getFirstChild().getNodeValue());
                                    }else if(k==5){
                                        books.setPublic(childNodes.item(k).getFirstChild().getNodeValue());
                                    }else if(k==7){
                                        books.setBookclass(childNodes.item(k).getFirstChild().getNodeValue());
                                    }else if(k==9){
                                        String loantime=childNodes.item(k).getFirstChild().getNodeValue();
                                        System.out.println("loantime:"+loantime);
                                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                        format.setLenient(false);
                                        Timestamp ts = new Timestamp(format.parse(loantime).getTime());
                                        System.out.println(ts.toString());
                                        books.setLoantime(ts);
                                    }else if(k==11){
                                        String returntime=childNodes.item(k).getFirstChild().getNodeValue();
                                        System.out.println("returntime:"+returntime);
                                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                        format.setLenient(false);
                                        Timestamp ts = new Timestamp(format.parse(returntime).getTime());
                                        System.out.println(ts.toString());
                                        books.setReturntime(ts);
                                    }else if(k==13){
                                        books.setStatus(childNodes.item(k).getFirstChild().getNodeValue());
                                    }


                                }

                            }
                            System.out.println("======================结束遍历第" + (m + 1) + "本书的内容=================");
                            System.out.println(books);

                            boolean result=bookDao.addBokkByXml(books);

                            if (result){
                                System.out.println("添加图书成功");
                            }else {
                                System.out.println("添加图书失败");
                            }

                        }
                    } catch (ParserConfigurationException e) {
                        e.printStackTrace();
                    }  catch (IOException e) {
                        e.printStackTrace();
                    }



                }
            }
            System.out.print("upload succeed");
        } catch (Exception e) {
            // 可以跳转出错页面
            e.printStackTrace();
        }
    }

    protected void delBook1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入删除图书操作,通过书名删除");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");

        String bookname=request.getParameter("bookname");

        boolean result=bookDao.delBook1(bookname);

        if (result){
            System.out.println("添加图书成功");
        }else {
            System.out.println("添加图书失败");
        }
    }

    protected void delBook2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入删除图书操作,通过书号删除");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");

        int bookid=Integer.valueOf(request.getParameter("bookid")).intValue();

        boolean result=bookDao.delBook2(bookid);

        if (result){
            System.out.println("添加图书成功");
        }else {
            System.out.println("添加图书失败");
        }
    }


}
