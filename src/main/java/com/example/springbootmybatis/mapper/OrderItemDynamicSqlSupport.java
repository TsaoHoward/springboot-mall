package com.example.springbootmybatis.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class OrderItemDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final OrderItem orderItem = new OrderItem();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> orderItemId = orderItem.orderItemId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> orderId = orderItem.orderId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> productId = orderItem.productId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> quantity = orderItem.quantity;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> amount = orderItem.amount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class OrderItem extends AliasableSqlTable<OrderItem> {
        public final SqlColumn<Integer> orderItemId = column("order_item_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> orderId = column("order_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> productId = column("product_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> quantity = column("quantity", JDBCType.INTEGER);

        public final SqlColumn<Integer> amount = column("amount", JDBCType.INTEGER);

        public OrderItem() {
            super("order_item", OrderItem::new);
        }
    }
}