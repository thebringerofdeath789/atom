package com.opencsv;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public interface ResultSetHelper {
    String[] getColumnNames(ResultSet resultSet) throws SQLException;

    String[] getColumnValues(ResultSet resultSet) throws SQLException, IOException;

    String[] getColumnValues(ResultSet resultSet, boolean z) throws SQLException, IOException;

    String[] getColumnValues(ResultSet resultSet, boolean z, String str, String str2) throws SQLException, IOException;
}