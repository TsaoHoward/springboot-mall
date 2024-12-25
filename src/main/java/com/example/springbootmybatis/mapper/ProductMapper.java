package com.example.springbootmybatis.mapper;

import static com.example.springbootmybatis.mapper.ProductDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.example.springbootmybatis.po.Product;
import jakarta.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface ProductMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(productId, productName, category, imageUrl, price, stock, description, createdDate, lastModifiedDate);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.productId")
    int insert(InsertStatementProvider<Product> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.productId")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Product> records);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ProductResult", value = {
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
        @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
        @Result(column="image_url", property="imageUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_date", property="createdDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_modified_date", property="lastModifiedDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Product> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ProductResult")
    Optional<Product> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, product, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, product, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer productId_) {
        return delete(c -> 
            c.where(productId, isEqualTo(productId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Product row) {
        return MyBatis3Utils.insert(this::insert, row, product, c ->
            c.map(productName).toProperty("productName")
            .map(category).toProperty("category")
            .map(imageUrl).toProperty("imageUrl")
            .map(price).toProperty("price")
            .map(stock).toProperty("stock")
            .map(description).toProperty("description")
            .map(createdDate).toProperty("createdDate")
            .map(lastModifiedDate).toProperty("lastModifiedDate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Product> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, product, c ->
            c.map(productName).toProperty("productName")
            .map(category).toProperty("category")
            .map(imageUrl).toProperty("imageUrl")
            .map(price).toProperty("price")
            .map(stock).toProperty("stock")
            .map(description).toProperty("description")
            .map(createdDate).toProperty("createdDate")
            .map(lastModifiedDate).toProperty("lastModifiedDate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Product row) {
        return MyBatis3Utils.insert(this::insert, row, product, c ->
            c.map(productName).toPropertyWhenPresent("productName", row::getProductName)
            .map(category).toPropertyWhenPresent("category", row::getCategory)
            .map(imageUrl).toPropertyWhenPresent("imageUrl", row::getImageUrl)
            .map(price).toPropertyWhenPresent("price", row::getPrice)
            .map(stock).toPropertyWhenPresent("stock", row::getStock)
            .map(description).toPropertyWhenPresent("description", row::getDescription)
            .map(createdDate).toPropertyWhenPresent("createdDate", row::getCreatedDate)
            .map(lastModifiedDate).toPropertyWhenPresent("lastModifiedDate", row::getLastModifiedDate)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Product> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, product, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Product> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, product, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Product> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, product, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Product> selectByPrimaryKey(Integer productId_) {
        return selectOne(c ->
            c.where(productId, isEqualTo(productId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, product, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Product row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(productName).equalTo(row::getProductName)
                .set(category).equalTo(row::getCategory)
                .set(imageUrl).equalTo(row::getImageUrl)
                .set(price).equalTo(row::getPrice)
                .set(stock).equalTo(row::getStock)
                .set(description).equalTo(row::getDescription)
                .set(createdDate).equalTo(row::getCreatedDate)
                .set(lastModifiedDate).equalTo(row::getLastModifiedDate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Product row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(productName).equalToWhenPresent(row::getProductName)
                .set(category).equalToWhenPresent(row::getCategory)
                .set(imageUrl).equalToWhenPresent(row::getImageUrl)
                .set(price).equalToWhenPresent(row::getPrice)
                .set(stock).equalToWhenPresent(row::getStock)
                .set(description).equalToWhenPresent(row::getDescription)
                .set(createdDate).equalToWhenPresent(row::getCreatedDate)
                .set(lastModifiedDate).equalToWhenPresent(row::getLastModifiedDate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Product row) {
        return update(c ->
            c.set(productName).equalTo(row::getProductName)
            .set(category).equalTo(row::getCategory)
            .set(imageUrl).equalTo(row::getImageUrl)
            .set(price).equalTo(row::getPrice)
            .set(stock).equalTo(row::getStock)
            .set(description).equalTo(row::getDescription)
            .set(createdDate).equalTo(row::getCreatedDate)
            .set(lastModifiedDate).equalTo(row::getLastModifiedDate)
            .where(productId, isEqualTo(row::getProductId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Product row) {
        return update(c ->
            c.set(productName).equalToWhenPresent(row::getProductName)
            .set(category).equalToWhenPresent(row::getCategory)
            .set(imageUrl).equalToWhenPresent(row::getImageUrl)
            .set(price).equalToWhenPresent(row::getPrice)
            .set(stock).equalToWhenPresent(row::getStock)
            .set(description).equalToWhenPresent(row::getDescription)
            .set(createdDate).equalToWhenPresent(row::getCreatedDate)
            .set(lastModifiedDate).equalToWhenPresent(row::getLastModifiedDate)
            .where(productId, isEqualTo(row::getProductId))
        );
    }
}