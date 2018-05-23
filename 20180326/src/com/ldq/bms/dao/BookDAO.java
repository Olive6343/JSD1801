package com.ldq.bms.dao;

import java.util.List;

import com.ldq.bms.entity.BookInfo;

public interface BookDAO {
    List<BookInfo> getAll();
}
