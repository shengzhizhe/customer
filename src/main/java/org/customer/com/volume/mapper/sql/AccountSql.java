package org.customer.com.volume.mapper.sql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.StringJoiner;

public class AccountSql {
    private static Logger logger = LoggerFactory.getLogger(AccountSql.class);

    public String select_page_type(String type,String account) {
        StringJoiner sql = new StringJoiner("");
        sql.add("select * from account_table a where 1=1");
        if (type != null && !type.isEmpty()) {
            sql.add(" and a.acctype=#{type}");
        }
        if (account != null && !account.isEmpty()) {
            sql.add(" and a.account=#{account}");
        }
        logger.info("[sql]---[" + sql.toString() + "]");
        return sql.toString();
    }
}
