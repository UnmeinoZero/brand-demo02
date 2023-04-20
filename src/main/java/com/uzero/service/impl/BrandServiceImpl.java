package com.uzero.service.impl;

import com.uzero.mapper.BrandMapper;
import com.uzero.pojo.Brand;
import com.uzero.pojo.PageBean;
import com.uzero.service.BrandService;
import com.uzero.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author 千叶零
 * @version 1.0
 * creats 2023-02-20  15:07:26
 */
public class BrandServiceImpl implements BrandService {

    //创建 SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有方法，返回一个Brand集合
     * @return
     */
    public List<Brand> selectAll() {

        //获得SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获得BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        List<Brand> brands = mapper.selectAll();

        //释放资源
        sqlSession.close();

        //返回集合
        return brands;
    }


    /**
     * 添加数据方法，传入一个Brand对象
     * @param brand
     */
    public void add(Brand brand){
        //获得SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获得BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        mapper.add(brand);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }


    /**
     * 修改数据方法，传入一个Brand对象
     * @param brand
     */
    public void update(Brand brand){
        //获得SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获得BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        mapper.update(brand);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }


    /**
     * 传入一个id，根据id删除对应数据
     * @param id
     */
    public void deleteById(int id){
        //获得SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获得BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        mapper.deleteById(id);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }


    /**
     *根据传入的 id 数组，实现删除多个对应的数据
     * @param ids
     */
    public void deleteByIds(int[] ids){
        //获得SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获得BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        mapper.deleteByIds(ids);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }


    /**
     * 分页查询
     * @param currentPage 当前页码
     * @param pageSize 每页展示条数
     * @return
     */
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        //获得SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获得BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        //计算查询条目数
        int size = pageSize;

        //调用方法
        List<Brand> rows = mapper.selectByPage(begin, size);

        //查询数据总数
        int totalCount = mapper.selectTotalCount();

        //将得到的数据封装到 PageBean 对象
        PageBean<Brand> brandPageBean = new PageBean<Brand>();
        brandPageBean.setRows(rows);
        brandPageBean.setTotalCount(totalCount);

        //释放资源
        sqlSession.close();

        //返回 PageBean 对象
        return brandPageBean;
    }


    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @param brand
     * @return
     */
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        //获得SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //获得BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        //计算查询条目数
        int size = pageSize;

        //处理brand条件，设置模糊表达式
        String brandName = brand.getBrandName();
        String companyName = brand.getCompanyName();

        if (brandName != null && brandName.length() > 0){
            brand.setBrandName("%" + brandName + "%");
        }
        if (companyName != null && companyName.length() > 0){
            brand.setCompanyName("%" + companyName + "%");
        }

        //调用方法
        List<Brand> rows = mapper.selectByPageAndCondition(begin, size, brand);

        //查询数据总数
        int totalCount = mapper.selectTotalCountByCondition(brand);

        //将得到的数据封装到 PageBean 对象
        PageBean<Brand> brandPageBean = new PageBean<Brand>();
        brandPageBean.setRows(rows);
        brandPageBean.setTotalCount(totalCount);

        //释放资源
        sqlSession.close();

        //返回 PageBean 对象
        return brandPageBean;
    }
}
