package com.example.springbootmybatis.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class OrderDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Order order = new Order();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> orderId = order.orderId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> userId = order.userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> totalAmount = order.totalAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createdDate = order.createdDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> lastModifiedDate = order.lastModifiedDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Order extends AliasableSqlTable<Order> {
        public final SqlColumn<Integer> orderId = column("order_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> userId = column("user_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> totalAmount = column("total_amount", JDBCType.INTEGER);

        public final SqlColumn<Date> createdDate = column("created_date", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> lastModifiedDate = column("last_modified_date", JDBCType.TIMESTAMP);

        public Order() {
            super("order", Order::new);
        }
    }
}