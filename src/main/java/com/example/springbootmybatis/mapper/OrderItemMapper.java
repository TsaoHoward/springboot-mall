package com.example.springbootmybatis.mapper;

import static com.example.springbootmybatis.mapper.OrderItemDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.example.springbootmybatis.po.OrderItem;
import jakarta.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface OrderItemMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<OrderItem>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(orderItemId, orderId, productId, quantity, amount);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="OrderItemResult", value = {
        @Result(column="order_item_id", property="orderItemId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER)
    })
    List<OrderItem> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("OrderItemResult")
    Optional<OrderItem> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, orderItem, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, orderItem, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer orderItemId_) {
        return delete(c -> 
            c.where(orderItemId, isEqualTo(orderItemId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(OrderItem row) {
        return MyBatis3Utils.insert(this::insert, row, orderItem, c ->
            c.map(orderItemId).toProperty("orderItemId")
            .map(orderId).toProperty("orderId")
            .map(productId).toProperty("productId")
            .map(quantity).toProperty("quantity")
            .map(amount).toProperty("amount")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<OrderItem> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, orderItem, c ->
            c.map(orderItemId).toProperty("orderItemId")
            .map(orderId).toProperty("orderId")
            .map(productId).toProperty("productId")
            .map(quantity).toProperty("quantity")
            .map(amount).toProperty("amount")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(OrderItem row) {
        return MyBatis3Utils.insert(this::insert, row, orderItem, c ->
            c.map(orderItemId).toPropertyWhenPresent("orderItemId", row::getOrderItemId)
            .map(orderId).toPropertyWhenPresent("orderId", row::getOrderId)
            .map(productId).toPropertyWhenPresent("productId", row::getProductId)
            .map(quantity).toPropertyWhenPresent("quantity", row::getQuantity)
            .map(amount).toPropertyWhenPresent("amount", row::getAmount)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<OrderItem> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, orderItem, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<OrderItem> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, orderItem, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<OrderItem> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, orderItem, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<OrderItem> selectByPrimaryKey(Integer orderItemId_) {
        return selectOne(c ->
            c.where(orderItemId, isEqualTo(orderItemId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, orderItem, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(OrderItem row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(orderItemId).equalTo(row::getOrderItemId)
                .set(orderId).equalTo(row::getOrderId)
                .set(productId).equalTo(row::getProductId)
                .set(quantity).equalTo(row::getQuantity)
                .set(amount).equalTo(row::getAmount);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(OrderItem row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(orderItemId).equalToWhenPresent(row::getOrderItemId)
                .set(orderId).equalToWhenPresent(row::getOrderId)
                .set(productId).equalToWhenPresent(row::getProductId)
                .set(quantity).equalToWhenPresent(row::getQuantity)
                .set(amount).equalToWhenPresent(row::getAmount);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(OrderItem row) {
        return update(c ->
            c.set(orderId).equalTo(row::getOrderId)
            .set(productId).equalTo(row::getProductId)
            .set(quantity).equalTo(row::getQuantity)
            .set(amount).equalTo(row::getAmount)
            .where(orderItemId, isEqualTo(row::getOrderItemId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(OrderItem row) {
        return update(c ->
            c.set(orderId).equalToWhenPresent(row::getOrderId)
            .set(productId).equalToWhenPresent(row::getProductId)
            .set(quantity).equalToWhenPresent(row::getQuantity)
            .set(amount).equalToWhenPresent(row::getAmount)
            .where(orderItemId, isEqualTo(row::getOrderItemId))
        );
    }
}