package com.ldq.bms.dao.impl;

import java.util.List;

import com.ldq.bms.dao.BookDAO;
import com.ldq.bms.entity.BookInfo;
import com.ldq.bms.utils.ReadAndWriteUtils;

public class BookDAOImpl implements BookDAO {
    @Override
    public List<BookInfo> getAll() {
        return ReadAndWriteUtils.readAllBookRecords();
    }
}
