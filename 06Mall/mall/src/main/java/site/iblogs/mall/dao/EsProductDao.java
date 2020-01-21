package site.iblogs.mall.dao;

import org.apache.ibatis.annotations.Param;
import site.iblogs.mall.nosql.elasticsearch.document.EsProduct;

import java.util.List;

/**
 * 搜索系统中的商品管理自定义Dao
 */
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
