package com.example.springbootmybatis.mapper;

import static com.example.springbootmybatis.mapper.OrderDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.example.springbootmybatis.po.Order;
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
public interface OrderMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Order>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(orderId, userId, totalAmount, createdDate, lastModifiedDate);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="OrderResult", value = {
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="created_date", property="createdDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_modified_date", property="lastModifiedDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Order> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("OrderResult")
    Optional<Order> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, order, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, order, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer orderId_) {
        return delete(c -> 
            c.where(orderId, isEqualTo(orderId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Order row) {
        return MyBatis3Utils.insert(this::insert, row, order, c ->
            c.map(orderId).toProperty("orderId")
            .map(userId).toProperty("userId")
            .map(totalAmount).toProperty("totalAmount")
            .map(createdDate).toProperty("createdDate")
            .map(lastModifiedDate).toProperty("lastModifiedDate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Order> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, order, c ->
            c.map(orderId).toProperty("orderId")
            .map(userId).toProperty("userId")
            .map(totalAmount).toProperty("totalAmount")
            .map(createdDate).toProperty("createdDate")
            .map(lastModifiedDate).toProperty("lastModifiedDate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Order row) {
        return MyBatis3Utils.insert(this::insert, row, order, c ->
            c.map(orderId).toPropertyWhenPresent("orderId", row::getOrderId)
            .map(userId).toPropertyWhenPresent("userId", row::getUserId)
            .map(totalAmount).toPropertyWhenPresent("totalAmount", row::getTotalAmount)
            .map(createdDate).toPropertyWhenPresent("createdDate", row::getCreatedDate)
            .map(lastModifiedDate).toPropertyWhenPresent("lastModifiedDate", row::getLastModifiedDate)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Order> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, order, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Order> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, order, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Order> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, order, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Order> selectByPrimaryKey(Integer orderId_) {
        return selectOne(c ->
            c.where(orderId, isEqualTo(orderId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, order, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Order row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(orderId).equalTo(row::getOrderId)
                .set(userId).equalTo(row::getUserId)
                .set(totalAmount).equalTo(row::getTotalAmount)
                .set(createdDate).equalTo(row::getCreatedDate)
                .set(lastModifiedDate).equalTo(row::getLastModifiedDate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Order row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(orderId).equalToWhenPresent(row::getOrderId)
                .set(userId).equalToWhenPresent(row::getUserId)
                .set(totalAmount).equalToWhenPresent(row::getTotalAmount)
                .set(createdDate).equalToWhenPresent(row::getCreatedDate)
                .set(lastModifiedDate).equalToWhenPresent(row::getLastModifiedDate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Order row) {
        return update(c ->
            c.set(userId).equalTo(row::getUserId)
            .set(totalAmount).equalTo(row::getTotalAmount)
            .set(createdDate).equalTo(row::getCreatedDate)
            .set(lastModifiedDate).equalTo(row::getLastModifiedDate)
            .where(orderId, isEqualTo(row::getOrderId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Order row) {
        return update(c ->
            c.set(userId).equalToWhenPresent(row::getUserId)
            .set(totalAmount).equalToWhenPresent(row::getTotalAmount)
            .set(createdDate).equalToWhenPresent(row::getCreatedDate)
            .set(lastModifiedDate).equalToWhenPresent(row::getLastModifiedDate)
            .where(orderId, isEqualTo(row::getOrderId))
        );
    }
}