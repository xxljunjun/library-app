package com.nanxiong.junjun.web;

import com.nanxiong.junjun.pojo.Book;
import com.nanxiong.junjun.service.BookService;
import com.nanxiong.junjun.service.impl.BookServiceImpl;
import com.nanxiong.junjun.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    /**
     * 查询图书馆的所有书籍
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用了查询表格");
        //1 通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
        for (Book book : books) {
            System.out.println("book"+book.getName());
        }
        //2 把全部图书保存到Request域中
        req.setAttribute("books", books);
        //3、请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/book.jsp").forward(req,resp);
    }

    /**
     * 删除某一本图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("delete");
        int id = Integer.parseInt(req.getParameter("id"));
        //删除完毕
        bookService.deleteBookById(id);
        //重新请求数据
        list(req,resp);
    }

    /**
     * 新增图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add");
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        bookService.addBook(book);
        //重新请求数据
//        list(req,resp);
        resp.sendRedirect(req.getContextPath() + "/bookServlet?action=list");
    }

    /**
     * 编辑图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("update");
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath() + "/bookServlet?action=list");
    }

    /**
     * 通过id查询图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("getBook");
        int id = Integer.parseInt(req.getParameter("id"));
        bookService.queryBookById(id);
        Book book = bookService.queryBookById(id);
        //3 保存到图书到Request域中
        req.setAttribute("book", book) ;
        //4 请求转发到。pages/manager/book_edit.jsp页面
        req.getRequestDispatcher("/pages/book_edit.jsp").forward(req,resp);
    }
}
