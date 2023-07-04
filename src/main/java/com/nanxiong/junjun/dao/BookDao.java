package com.nanxiong.junjun.dao;

import com.nanxiong.junjun.pojo.Book;

import java.util.List;

public interface BookDao {
    /**
     *新增图书
     * @param book
     * @return
     */
    public int addBook(Book book);

    /**
     *删除图书
     * @param id
     * @return
     */
    public int deleteBookById(Integer id);

    /**
     *修改图书
     * @param book
     * @return
     */
    public int updateBook(Book book);
    /**
     *  通过id查询图书
     * @param id
     * @return
     */
    public Book queryBookById(Integer id);
    /**
     *  查询所有图书
     * @return
     */
    public List<Book> queryBooks();
}
